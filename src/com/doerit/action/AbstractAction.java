package com.doerit.action;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import com.doerit.exception.SessionNotExist;
import com.doerit.model.type.UserRoleType;
import com.doerit.util.SessionKey;
import com.doerit.util.SessionUser;
import com.opensymphony.xwork2.ActionSupport;

public abstract class AbstractAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	public static final Integer DEFAULT_HEADER_KEY = -1;
	public static final String DEFAULT_HEADER_TEXT = "Invalid";
	public static final String HEAD_OFFICE_ID = "HO0001";

	private static Logger logger = Logger.getLogger(AbstractAction.class);
	private static final String SESSION_NOT_EXIST = "Session doesn't exist";
	protected Map<SessionKey, Object> session = null;

	private int x;
	private int y;

	private Integer allCount;
	private Date fromDate;
	private Date toDate;
	
	// protected ACTION_STATUS actionStatus;

	public String alwaysSuccess() {
		return SUCCESS;
	}

	/*public void addSessionUserAccount(UserAccount userAccount) throws SessionNotExist {
		if (session != null) {

			session.put(SessionKey.SESSION_USER_ACCOUNT, userAccount);
		} else {
			logger.error(SESSION_NOT_EXIST);
			throw new SessionNotExist(SESSION_NOT_EXIST);
		}
	}*/
	
	public void addSessionUser(SessionUser sessionUser) throws SessionNotExist {
		if (session != null) {
			
			session.put(SessionKey.SESSION_USER, sessionUser);
			
		} else {
			logger.error(SESSION_NOT_EXIST);
			throw new SessionNotExist(SESSION_NOT_EXIST);
		}
	}
	
	public SessionUser getSessionUser() throws SessionNotExist {
		if (session != null) {
			if (session.containsKey(SessionKey.SESSION_USER)) {
				return (SessionUser) session.get(SessionKey.SESSION_USER);
			} else {
				throw new SessionNotExist(SESSION_NOT_EXIST);
			}
		} else {
			logger.error(SESSION_NOT_EXIST);
			throw new SessionNotExist(SESSION_NOT_EXIST);
		}
	}

	public String getUserRole() throws SessionNotExist {
		SessionUser su = getSessionUser();
		return su.getRole();
	}

	public String getUserRoleName() throws SessionNotExist {
		SessionUser su = getSessionUser();
		return su.getRoleName();
	}
	
	public String getSessionUserId() {
		try {
			SessionUser su = getSessionUser();
			return su.getId();
		} catch(SessionNotExist e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean isAdmin(){
		
		try {
			SessionUser su = getSessionUser();
			
			if (su.getRoleName().equalsIgnoreCase(UserRoleType.ADMIN.getDbId())) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}
	
	public boolean isDentalDoctor(){
		
		try {
			SessionUser su = getSessionUser();
			
			if (su.getRoleName().equalsIgnoreCase(UserRoleType.DENTAL_DOCTOR.getDbId())) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}
	
	public boolean isClerk(){
		
		try {
			SessionUser su = getSessionUser();
			
			if (su.getRoleName().equalsIgnoreCase(UserRoleType.CLERK.getDbId())) {
				return true;
			}
			
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	public boolean isNurse() {

		try {
			SessionUser su = getSessionUser();

			if (su.getRoleName().equalsIgnoreCase(UserRoleType.DENTAL_NURSE.getDbId())
					|| su.getRoleName().equalsIgnoreCase(UserRoleType.HEALTH_MINISTRY_NURSE.getDbId())) {
				return true;
			}

		} catch (Exception e) {
			return false;
		}
		return false;
	}
	
	public boolean authorizeVisits(){
		
		if (isAdmin() || isDentalDoctor() || isNurse()) {
			return true;
		}
		return false;
	}
	
/*	public boolean isDepartment(){
		
		try {
			SessionUser su = getSessionUser();
			
			if (su.getRoleName().equalsIgnoreCase(UserRoleType.DEPARTMENT.getDbId())) {
				return true;
			}
			
		} catch (Exception e) {
			return false;
		}
		return false;
	}	*/
	
	public void removeSessionVariable(SessionKey key) throws SessionNotExist {
		if (session != null) {
			if (session.containsKey(key)) {
				session.remove(key);
			}
		} else {
			logger.error(SESSION_NOT_EXIST);
			throw new SessionNotExist(SESSION_NOT_EXIST);
		}
	}

	public boolean verifySessionStaff() throws SessionNotExist {
		
		if (session != null) {
			return session.containsKey(SessionKey.SESSION_USER);
		} else {
			logger.error(SESSION_NOT_EXIST);
			throw new SessionNotExist(SESSION_NOT_EXIST);
		}
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public void setSession(@SuppressWarnings("rawtypes") Map session) {
		this.session = session;
	}

	/*
	 * public ACTION_STATUS getStatus() { return actionStatus; }
	 * 
	 * public void setStatus(ACTION_STATUS status) { this.actionStatus = status;
	 * }
	 */
	public boolean isLogin() {
		try {
			SessionUser su = (SessionUser) session.get(SessionKey.SESSION_USER);
			if (su != null) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}


	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Integer getAllCount() {
		return allCount;
	}

	public void setAllCount(Integer allCount) {
		this.allCount = allCount;
	}

	public boolean isInvalid(String value) {
		return (value == null || value.trim().length() == 0);
	}

	protected void validateTimeIntervel() {
		
		if(getFromDate().after(getToDate())){
			setFromDate(getToDate());
		}
	}

	public Date getFromDate() {
		if(fromDate == null)
			setFromDate(new Date());			
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		Calendar c = Calendar.getInstance(); 
		c.setTime(fromDate); 
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH),0,0,0);
		this.fromDate = c.getTime();
	}

	public Date getToDate() {
		if(toDate == null)
			setToDate(new Date());
		return toDate;
	}

	public void setToDate(Date toDate) {
		Calendar c = Calendar.getInstance(); 
		c.setTime(toDate); 
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE),0,0,0);
		c.add(Calendar.DATE, 1);
		c.add(Calendar.MINUTE, -1);
		this.toDate = c.getTime();
	}
}
