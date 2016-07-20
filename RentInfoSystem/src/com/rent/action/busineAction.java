package com.rent.action;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.rent.dao.rentDao;
import com.rent.impl.rentImpl;
import com.rent.model.Page;
import com.rent.model.Rent_In;
import com.rent.model.Rent_Out;
import com.rent.model.User;
import com.rent.util.ImageUploadUtil;
import com.rent.util.PageUtil;
import com.rent.util.passwordUtil;
import com.rent.util.sqlUtil;

public class busineAction extends ActionSupport implements SessionAware{
	 private File upload;                   //上传文件域 前台标签file的name名
	 private String uploadContentType;       //上传文件类型
	 private String uploadFileName;          //上传文件名
	 private String uploadPath;
	 String fileName="";
	 private Map session;
	 
	 private Page page;//分页时所用参数
	 private int currentPage;//当前页面
	 
		private List list;//显示rentIn信息
		private List listOut;//显示rentOut信息
	        private String id;
			
	        private User user;//接收注册时用户的信息
	        private Rent_In rentIn;//接收求租信息
	        private Rent_Out rentOut;//接收出租信息
			private String result;
	     private static final rentDao  dao=new  rentImpl();
     
	     @Override
			public void setSession(Map session) {
		      this.session=session;
				
			}
			 
	     public String rigester(){
	    	 HttpServletResponse response = ServletActionContext.getResponse();  
	    	 if(dao.checkUserExist(sqlUtil.checkUserExist(user.getUserName()))){
	    		 result="对不起，该用户名已经存在！";
	    		return SUCCESS ;
	    	 }
		      fileName=ImageUploadUtil.imageUpload(upload, uploadContentType, uploadFileName, uploadPath);
		    	  user.setHead_Image(fileName);
		    	  user.setPassword(passwordUtil.message(user.getPassword()));//密码加密
		         dao.save(user);
	         List<User> list= dao.login(sqlUtil.login(user.getUserName(),user.getPassword()));	 
		        for(User user:list){
		        	  session.put("userid",user.getUserId());//用户的id为自动生成，所以必须查找出来后遍历它的id		  
			     }
		   	     session.put("username", user.getUserName());
		   	     session.put("head_Image", user.getHead_Image());
		   	     result="恭喜您注册成功！";
		         return SUCCESS;
		  }
	     public String getUserInfo(){//获得用户个人信息
	    	 if(session.get("username")==null){
	    		 result="对不起，您还没有登录！！";
	    		 return  SUCCESS;
	    	 }
	    	 user=dao.get(User.class, session.get("userid").toString());
	    	 return SUCCESS;
	     }
	     public String updateUserInfo(){//更新个人信息
	    	 User	users= dao.get(User.class, session.get("userid").toString());
			  users.setAge(user.getAge());
			  users.setBirthday(user.getBirthday());
			 // users.setHead_Image(user.getHead_Image());
			  users.setPhone(user.getPhone());
			  users.setUserName(user.getUserName());
			  users.setSex(user.getSex());
				dao.update(users);
              session.put("username", users.getUserName());
              result="修改成功！";
	    	 return SUCCESS;
	     }
	     
	     public String saveRentOut(){
			 fileName=ImageUploadUtil.imageUpload(upload, uploadContentType, uploadFileName, uploadPath);
			 rentOut.setHouse_pictures(fileName);
			 rentOut.setChecked(false);
			 rentOut.setLegal('N');
			 rentOut.setPublish_time(new Date());
			 dao.saveRentOut(rentOut,  Integer.parseInt(session.get("userid").toString()));
			 result="恭喜您，发布成功！";
			 return SUCCESS;
		 }
		 
		 public String saveRentIn(){
			 rentIn.setChecked(false);
			 rentIn.setLegal('N');
			 System.out.println(new Date());
			 rentIn.setPublish_time(new Date());
			 dao.saveRentIn(rentIn, Integer.parseInt(session.get("userid").toString()));
			 result="恭喜您，发布成功！";
			 return SUCCESS;
		 }
		 
		 
		public File getUpload() {
			return upload;
		}
		public void setUpload(File upload) {
			this.upload = upload;
		}
		public String getUploadContentType() {
			return uploadContentType;
		}
		public void setUploadContentType(String uploadContentType) {
			this.uploadContentType = uploadContentType;
		}
		public String getUploadFileName() {
			return uploadFileName;
		}
		public void setUploadFileName(String uploadFileName) {
			this.uploadFileName = uploadFileName;
		}
		public String getUploadPath() {
			return uploadPath;
		}
		public void setUploadPath(String uploadPath) {
			this.uploadPath = uploadPath;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}		
		public Page getPage() {
			return page;
		}
		public void setPage(Page page) {
			this.page = page;
		}
		public int getCurrentPage() {
			return currentPage;
		}
		public void setCurrentPage(int currentPage) {
			this.currentPage = currentPage;
		}
		public List getList() {
			return list;
		}
		public void setList(List list) {
			this.list = list;
		}
		public List getListOut() {
			return listOut;
		}
		public void setListOut(List listOut) {
			this.listOut = listOut;
		}

		public String getResult() {
			return result;
		}
    	public void setResult(String result) {
			this.result = result;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public Rent_In getRentIn() {
			return rentIn;
		}
		public void setRentIn(Rent_In rentIn) {
			this.rentIn = rentIn;
		}
		public Rent_Out getRentOut() {
			return rentOut;
		}
		public void setRentOut(Rent_Out rentOut) {
			this.rentOut = rentOut;
		}									
}
