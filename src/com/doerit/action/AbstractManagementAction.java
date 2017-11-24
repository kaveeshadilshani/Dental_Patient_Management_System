package com.doerit.action;

import java.util.Calendar;
import java.util.Random;
import java.util.Stack;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.doerit.model.ActivityLogger;
import com.doerit.model.InsertUpdate;
import com.doerit.model.StatusModel;
import com.doerit.model.TotalRegistrations;
import com.doerit.service.ActivityLoggerService;
import com.doerit.util.Pager;
import com.doerit.util.Searcher;
import com.doerit.util.SessionKey;
import com.doerit.util.State;
import com.doerit.util.UrlWrapper;
import com.google.common.base.CaseFormat;
import com.opensymphony.xwork2.Preparable;

public class AbstractManagementAction extends AbstractAction implements Preparable {

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(AbstractManagementAction.class);
	private Random random = new Random(1000);
	
	@Autowired private ActivityLoggerService activityLoggerService; 
	public enum Mode {
		ADD, EDIT, DIRECT
	}

	private String timeChar;
	protected String id;
	protected Pager pager;
	protected Integer pageStart = Pager.DEFAULT_PAGE_START;
	protected Integer pageSize = Pager.DEFAULT_PAGE_SIZE;
	protected Boolean paging = false;
	protected String targetDiv = null;
	protected UrlWrapper urlWrapper;
	protected Searcher searcher;
	protected TotalRegistrations RegTotal;

	protected Mode mode = Mode.ADD; // default

	public Mode getMode() {
		return mode;
	}

	public void setMode(Mode mode) {
		this.mode = mode;
	}

	public String index() {
		return SUCCESS;
	}
	
	protected String getClientIPAddress(){
		return ServletActionContext.getRequest().getRemoteAddr();
	}

	protected void setUserLastAccessDateTime() {
		String employeeId = getSessionUserId();

		if (employeeId != null) {

		}
	}

	public void addInsertSettings(InsertUpdate entity) {
		entity.setInsertDatetime(Calendar.getInstance().getTime());
		entity.setInsertUserId(getSessionUserId());
	}

	public void addUpdateSettings(InsertUpdate entity) {
		entity.setUpdateDatetime(Calendar.getInstance().getTime());
		entity.setUpdateUserId(getSessionUserId());
	}

	public void setSuspendState(StatusModel sm) {
		sm.setStatus(State.DELETED.getDatabaseValue());
	}
	
	public void setPermonentDeteleState(StatusModel sm) {
		sm.setStatus(State.PERMONENTLY_DELETED.getDatabaseValue());
	}
	
	public void setActiveState(StatusModel sm) {
		sm.setStatus(State.ACTIVE.getDatabaseValue());
	}
	
	public void setInitialInsertSettings(InsertUpdate entity) {
		entity.setInsertDatetime(Calendar.getInstance().getTime());
		entity.setInsertUserId(getSessionUserId());
		entity.setUpdateDatetime(Calendar.getInstance().getTime());
		entity.setUpdateUserId(getSessionUserId());
	}
	
	public void prepare() {
		/*this.urlWrapper = UrlWrapper.getInstance(ServletActionContext.getActionMapping().getName(), 
				ServletActionContext.getActionMapping().getNamespace(),
				ServletActionContext.getRequest().getParameterMap(),
				ServletActionContext.getActionMapping().getMethod());
		
		this.urlWrapper.setTargetDiv(targetDiv);
		
		addToHistory(urlWrapper);
		
		logger.info(urlWrapper);*/
	}
	
	@SuppressWarnings("unchecked")
	private void addToHistory(UrlWrapper urlWrapper) {
		Stack<UrlWrapper> actionHistory = new Stack<UrlWrapper>(){
		    private static final long serialVersionUID = 1L;
		    public UrlWrapper push(UrlWrapper urlWrapper) {
		        if (this.size() == 10) {
		            this.removeElementAt(0);
		        }
		        return super.push(urlWrapper);
		    }
		};
		
		if(session.get(SessionKey.HISTORY_ACTION) != null) {
			actionHistory = (Stack<UrlWrapper>)session.get(SessionKey.HISTORY_ACTION);
		} else {
			actionHistory = new Stack<UrlWrapper>();
		}
		
		actionHistory.add(urlWrapper);
		
	}
	
	public void getBack() {
		Stack<UrlWrapper> actionHistory = getSessionHistoryActionStack();
		if( actionHistory.size() > 1) {
			actionHistory.pop();  //need the second item
			urlWrapper = actionHistory.peek();
		}
	}
	
	@SuppressWarnings("unchecked")
	private Stack<UrlWrapper> getSessionHistoryActionStack() {
		
		Stack<UrlWrapper> actionHistory = new Stack<UrlWrapper>();
		if(session.get(SessionKey.HISTORY_ACTION) != null) {
			actionHistory = (Stack<UrlWrapper>)session.get(SessionKey.HISTORY_ACTION);
		} else {
			session.put(SessionKey.HISTORY_ACTION, actionHistory);
		}
		return actionHistory;
	}
	
	public Pager setActionContext(Pager pager) {
		pager.setTargetDiv(targetDiv);
		pager.setActionCallInfo(ServletActionContext.getActionMapping().getName(), 
				ServletActionContext.getActionMapping().getNamespace(),
				ServletActionContext.getRequest().getParameterMap());
		return pager;
	}
	
	public void beforeAction() {
		if (ServletActionContext.getRequest().getParameterMap().containsKey("pageStart")
				&& ServletActionContext.getRequest().getParameterMap().containsKey("pageSize")) {
			this.pager = new Pager();
			this.pager.setStart(pageStart);
			this.pager.setSize(pageSize);
		} else {
			this.pager = new Pager();
		}
		getSearcher().setNamespace(ServletActionContext.getActionMapping().getNamespace());
	}
	
	public HttpServletResponse getServletResponse() {
        return ServletActionContext.getResponse();
    }

	public String generatePrimaryKey() {
		return String.valueOf(Calendar.getInstance().getTimeInMillis() + random.nextInt());
	}
	
	
	
	
	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public Integer getPageStart() {
		return pageStart;
	}

	public void setPageStart(Integer pageStart) {
		this.pageStart = pageStart;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public UrlWrapper getUrlWrapper() {
		getBack();
		return urlWrapper;
	}

	public void setUrlWrapper(UrlWrapper urlWrapper) {
		this.urlWrapper = urlWrapper;
	}

	public Boolean getPaging() {
		return paging;
	}

	public void setPaging(Boolean paging) {
		this.paging = paging;
	}

	public Searcher getSearcher() {
		if(this.searcher == null)
			this.searcher = new Searcher();
		return searcher;
	}

	public void setSearcher(Searcher searcher) {
		this.searcher = searcher;
	}

	public String get_() {
		return timeChar;
	}

	public void set_(String timeChar) {
		this.timeChar = timeChar;
	}
	
	public String upperUnderToCamel(String s) {
		return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, s);
	}
	
	protected void addLoggerMessage(String relateKey, String messageType, String message, String description) {

		ActivityLogger logger = new ActivityLogger();
		logger.setRelateKey(relateKey);
		logger.setMessageType(messageType);
		logger.setMessage(message);
		logger.setDescription(description);
		logger.setAccessHost(getClientIPAddress());
		logger.setId(String.valueOf(System.currentTimeMillis()));
		logger.setInsertDatetime(Calendar.getInstance().getTime());
		logger.setInsertUserId(getSessionUserId());

		try{
			activityLoggerService.save(logger);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void addLoggerMessage(String userId, String relateKey, String messageType, String message, String description) {

		ActivityLogger logger = new ActivityLogger();
		logger.setRelateKey(relateKey);
		logger.setMessageType(messageType);
		logger.setMessage(message);
		logger.setDescription(description);
		logger.setAccessHost(getClientIPAddress());
		logger.setId(String.valueOf(System.currentTimeMillis()));
		logger.setInsertDatetime(Calendar.getInstance().getTime());
		logger.setInsertUserId(userId);

		try{
			activityLoggerService.save(logger);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
