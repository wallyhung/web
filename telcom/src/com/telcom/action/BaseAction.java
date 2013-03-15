package com.telcom.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
public class BaseAction extends ActionSupport
{
	/**后台消息提示**/
	protected String message;
	
	public BaseAction() {
	}
	
	private static final long serialVersionUID = -7511027704889958365L;
	
	@JSON(serialize = false)
	protected HttpServletRequest getRequest()
	{
		return ServletActionContext.getRequest();
	}
	@JSON(serialize = false)
	protected HttpServletResponse getResponse()
	{
		return ServletActionContext.getResponse();
	}
	@JSON(serialize = false)
	protected String getParameter(String param)
	{
		return ServletActionContext.getRequest().getParameter(param);
	}
	@JSON(serialize = false)
	protected HttpSession getSession()
	{
		return ServletActionContext.getRequest().getSession();
	} 
	
	///~ getter and setter
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}

}
