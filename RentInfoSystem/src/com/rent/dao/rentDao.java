package com.rent.dao;

import java.util.List;

import com.rent.model.Page;
import com.rent.model.Rent_In;
import com.rent.model.Rent_Out;
import com.rent.model.User;
public interface rentDao {
	public void save(Object obj);
	public <T> T get(Class<T> clazz, String id);
	public void update(Object obj);
	public <T> void delete(Class<T> clazz, String id);
	public void delete(Object obj);
	public <T> List<T> findAll(Class<T> clazz);
	public List<User> login(String sql);
	public  boolean checkUserExist(String sql);
	
	public void deleteById(String  sql);
	public int  findAllCount(String sql);
	public List findAll(Class calzz,Page page,String sql);
	
	public List<Rent_In> findRentIn(Page page,String sql);
	
	
	public void saveRentIn(Rent_In in,int id);
	public void saveRentOut(Rent_Out out,int id);
}
