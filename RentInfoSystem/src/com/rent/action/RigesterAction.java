package com.rent.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.opensymphony.xwork2.ActionSupport;
import com.rent.dao.rentDao;
import com.rent.impl.rentImpl;
import com.rent.model.Rent_In;
import com.rent.model.Rent_Out;
import com.rent.model.User;
import com.rent.util.ImageUploadUtil;
import com.rent.util.passwordUtil;
import com.rent.util.sqlUtil;

public class RigesterAction extends ActionSupport{
	 private File upload;                   //上传文件域 前台标签file的name名
	 private String uploadContentType;       //上传文件类型
	 private String uploadFileName;          //上传文件名
	 private String uploadPath;
	 String fileName="";
	 
	    private String id;
		private User user;
		private Rent_Out rentOut;//获取出租信息
		private Rent_In  rentIn;//获取求租信息
     private static final rentDao  dao=new  rentImpl();
	 
  
	  public String rigester(){
	      fileName=ImageUploadUtil.imageUpload(upload, uploadContentType, uploadFileName, uploadPath);
	    	  user.setHead_Image(fileName);
	    	  user.setPassword(passwordUtil.message(user.getPassword()));//密码加密
	         dao.save(user);
	         List<User> list= dao.login(sqlUtil.login(user.getUserName(), passwordUtil.message(user.getPassword())));
		     if(list!=null){		    	 
	         for(User user:list){
		    	  id=user.getUserId()+"";
		      }
		     }
	         return SUCCESS;
	  }
	 public String saveRentOut(){
		 fileName=ImageUploadUtil.imageUpload(upload, uploadContentType, uploadFileName, uploadPath);
		 rentOut.setHouse_pictures(fileName);
		 rentOut.setChecked(false);
		 rentOut.setLegal('N');
		 rentOut.setPublish_time(new Date());
		 rentOut.setTitle("商院精品房出租");
		 dao.save(rentOut);
		 return SUCCESS;
	 }
	 
	 public String saveRentIn(){
		 rentIn.setChecked(false);
		 rentIn.setLegal('N');
		 System.out.println(new Date());
		 rentIn.setPublish_time(new Date());
		 dao.saveRentIn(rentIn, Integer.parseInt(id));
		 return SUCCESS;
	 }
	 
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
	public Rent_Out getRentOut() {
		return rentOut;
	}
	public void setRentOut(Rent_Out rentOut) {
		this.rentOut = rentOut;
	}
	public Rent_In getRentIn() {
		return rentIn;
	}
	public void setRentIn(Rent_In rentIn) {
		this.rentIn = rentIn;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	 
	 
	 
	

}
