package com.rent.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;

@Entity
public class User {
	private int userId;
	private String userName;
	private String password;
	private int age;
	private Date birthday;
	private String phone;
	private String sex;
	private int role;
	private String head_Image;
	private Set<Rent_In> in=new HashSet<Rent_In>();
	private Set<Rent_Out> out=new HashSet<Rent_Out>();
	private Set<Message> message=new HashSet<Message>();
	@Id
	@GeneratedValue
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getHead_Image() {
		return head_Image;
	}
	public void setHead_Image(String head_Image) {
		this.head_Image = head_Image;
	}
	@OneToMany(mappedBy="user")
	@Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE,org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	public Set<Rent_In> getIn() {
		return in;
	}
	public void setIn(Set<Rent_In> in) {
		this.in = in;
	}
	@OneToMany(mappedBy="user")
	@Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE,org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	public Set<Rent_Out> getOut() {
		return out;
	}
	public void setOut(Set<Rent_Out> out) {
		this.out = out;
	}
	@OneToMany(mappedBy="user")
	@Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE,org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	public Set<Message> getMessage() {
		return message;
	}
	public void setMessage(Set<Message> message) {
		this.message = message;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	

}
