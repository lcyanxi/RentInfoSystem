package com.rent.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.rent.dao.rentDao;
import com.rent.impl.rentImpl;
import com.rent.model.User;
import com.rent.util.passwordUtil;
import com.rent.util.sqlUtil;

public class LoginAction extends ActionSupport implements SessionAware{
      private String username;
      private String password;
      private String result;
      private Map session;
      private static final rentDao dao=new rentImpl();
      
      
	     @Override
			public void setSession(Map session) {
		      this.session=session;
				
			}
			 
	     
	@Override
	public String execute() throws Exception {
		List<User> list= dao.login(sqlUtil.login(username, passwordUtil.message(password)));
		if(list!=null){
			for(User user:list){
				session.put("userid", user.getUserId());
				session.put("username", username);
				session.put("head_Image", user.getHead_Image());
			    result=  "恭喜您'"+username+"'登录成功！";
			    return SUCCESS;
				/*if(user.getRole()==0) return SUCCESS;
				if(user.getRole()==1) return NONE;
				*/
				
			}
		}
	   result= "对不起，你的用户名或者密码不正确！";
		return SUCCESS;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}

      
      
      
      
      
}
