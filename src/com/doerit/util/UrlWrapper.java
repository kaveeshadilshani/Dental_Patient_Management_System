package com.doerit.util;

import java.io.Serializable;
import java.util.Map;

public class UrlWrapper implements Serializable{

	private static final long serialVersionUID = 1L;
	protected String actionName;
	protected String namespace;
	protected String targetDiv;
	protected Map<String, String[]> parameters;
	protected String pageTitle;
	protected String method;

	public UrlWrapper() {

	}

	public UrlWrapper(String name, String namespace, Map<String, String[]> params) {
		this.actionName = name;
		this.namespace = namespace;
		this.parameters = params;
	}

	public UrlWrapper(String name, String namespace, Map<String, String[]> params, String method) {
		this.actionName = name;
		this.namespace = namespace;
		this.parameters = params;
		this.method = method;
	}

	public static UrlWrapper getInstance(String name, String namespace, Map<String, String[]> params) {
		return new UrlWrapper(name, namespace, params);
	}

	public static UrlWrapper getInstance(String name, String namespace, Map<String, String[]> params, String method) {
		return new UrlWrapper(name, namespace, params, method);
	}

	public void setActionCallInfo(String name, String namespace, Map<String, String[]> params) {
		this.actionName = name;
		this.namespace = namespace;
		this.parameters = params;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public String getTargetDiv() {
		return targetDiv;
	}

	public void setTargetDiv(String targetDiv) {
		this.targetDiv = targetDiv;
	}

	public Map<String, String[]> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, String[]> parameters) {
		this.parameters = parameters;
	}

	public String getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	@Override
	public String toString() {
		return "UrlWrapper [actionName=" + actionName + ", namespace=" + namespace + ", targetDiv=" + targetDiv
				+ ", parameters=" + parameters + ", pageTitle=" + pageTitle + ", method=" + method + "]";
	}

}