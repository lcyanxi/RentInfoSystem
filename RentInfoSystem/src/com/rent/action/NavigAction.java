package com.rent.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class NavigAction extends ActionSupport implements SessionAware {
	private Map session;
	@Override
	public String execute() throws Exception {
		session.put("username", null);
		session.put("userid", null);
		session.put("head_Image", null);
		return SUCCESS;
	}

	@Override
	public void setSession(Map session) {
		this.session=session;
		
	}

	
}
