package com.doerit.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class SessionExpireInterceptor extends AbstractInterceptor {

  private static final long serialVersionUID = 1L;
  private static final String SESSION_ERROR = "sessionExpired";

  @Override
  public String intercept(ActionInvocation invocation) throws Exception {

    Map<String, Object> session = ActionContext.getContext().getSession();
    Object obj = session.get(com.doerit.util.SessionKey.SESSION_USER);

    if (obj != null) {
      return invocation.invoke();
    } else {
      return SESSION_ERROR;
    }
  }
}
