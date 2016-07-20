package com.rent.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.rent.dao.rentDao;
import com.rent.impl.rentImpl;
import com.rent.model.Page;
import com.rent.model.Rent_In;
import com.rent.model.Rent_Out;
import com.rent.model.User;
import com.rent.util.PageUtil;
import com.rent.util.passwordUtil;
import com.rent.util.sqlUtil;

public class showDateInfoAction extends ActionSupport implements SessionAware{
	private Page page;
	private int currentPage;//当前页面
	private List list;
	private List listOut;
	private List<Rent_In> rentIn;
	
	private Map session;
    private String inId;
	private String outId;
	private String message;
    private static final	rentDao dao=new rentImpl();


	@Override
	public void setSession(Map session) {
		this.session=session;
		
	}
    public String  showRentInInfo(){
    	    	 page=PageUtil.createPage(5, dao.findAllCount(sqlUtil.findRentInCount()), currentPage);
    			    list=dao.findAll(Rent_In.class, page, sqlUtil.findRentIn());	    
		    return SUCCESS;
	
    }
    public String showRentOutInfo(){	 
   	        page=PageUtil.createPage(5, dao.findAllCount(sqlUtil.findRentOutCount()), currentPage);
			listOut=dao.findAll(Rent_Out.class, page, sqlUtil.findRentOut());

			return SUCCESS;
    }
    public String deleteRentIn(){
		 dao.deleteById(sqlUtil.deleteRentInById(Integer.parseInt(inId)));
		 showRentInInfo();//删除数据后更新一下后台数据和前端数据一致
		 return SUCCESS;
	 }
	 public String deleteRentOut(){
		 dao.deleteById(sqlUtil.deleteRentOutById(Integer.parseInt(outId)));
		 showRentOutInfo();//删除数据后更新一下后台数据和前端数据一致
		 return SUCCESS;
	 }
    public String  checkedRentInLegal(){
    	Rent_In rentIn=dao.get(Rent_In.class, inId);
    	  rentIn.setChecked(true);
    	  rentIn.setLegal(message.charAt(0));
    	  rentIn.setChecked_time(new Date());
    	  dao.update(rentIn);
    	  page=PageUtil.createPage(5, dao.findAllCount(sqlUtil.findRentInCount()), currentPage);
		    list=dao.findAll(Rent_In.class, page, sqlUtil.findRentIn());
          return SUCCESS;
    }
    
    public String  checkedRentOutLegal(){ 	
    	Rent_Out rentOut=dao.get(Rent_Out.class, outId);
    	  rentOut.setChecked(true);
    	  rentOut.setLegal(message.charAt(0));
    	  rentOut.setChecked_time(new Date());
    	  dao.update(rentOut);
    	  page=PageUtil.createPage(5, dao.findAllCount(sqlUtil.findRentOutCount()), currentPage);
		  listOut=dao.findAll(Rent_Out.class, page, sqlUtil.findRentOut());
          return SUCCESS;
    }

    public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
    
    public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
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
	public List<Rent_In> getRentIn() {
		return rentIn;
	}
	public void setRentIn(List<Rent_In> rentIn) {
		this.rentIn = rentIn;
	}
	public String getInId() {
		return inId;
	}
	public void setInId(String inId) {
		this.inId = inId;
	}
	public String getOutId() {
		return outId;
	}
	public void setOutId(String outId) {
		this.outId = outId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}



	
	
	
	
}
