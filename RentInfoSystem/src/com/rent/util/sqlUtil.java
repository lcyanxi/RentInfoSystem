package com.rent.util;


public class sqlUtil {
	public static String findRentInCount(){
		String sql="select count(*) from Rent_In";
		return sql;
	}
	public static String findRentIn(){
		String sql="from Rent_In r left join fetch r.user order by publish_time desc";
		return sql;
	}
	public static String findRentOutCount(){
		String sql="select count(*) from Rent_Out";
		return sql;
	}
	public static String findRentOut(){
		String sql="from Rent_Out r left join fetch r.user order by publish_time desc";
		return sql;
	}
    public static String login(String username,String password){
    	String sql="from User where userName='"+username+"' and password='"+password+"'";
    	return sql;
    }
    public static String deleteRentInById(int id){
    	String sql="delete Rent_In where in_id='"+id+"' ";
    	return sql;
    }
    public static String deleteRentOutById(int id){
    	String sql="delete Rent_Out where out_id='"+id+"' ";
    	return sql;
    }
    public static String checkUserExist(String username){
    	String sql="select id from User where userName='"+username+"'";
    	return sql;
    }
 }

