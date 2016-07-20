package com.rent.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
@Entity
public class Rent_Out {
  private int out_id;
  private Date publish_time;
  private String area;
  private String equipment;
  private String title;
  private String address;
  private float money;
  private String house_pictures;
  private String detail;
  private char legal;
  private boolean checked;
  private String rentType;
  private Date checked_time;
  private User user;
  private Set<Message> message=new HashSet<Message>();
  @Id
  @GeneratedValue
public int getOut_id() {
	return out_id;
}
public void setOut_id(int out_id) {
	this.out_id = out_id;
}
@Temporal(TemporalType.DATE)
public Date getPublish_time() {
	return publish_time;
}
public void setPublish_time(Date publish_time) {
	this.publish_time = publish_time;
}
public String getEquipment() {
	return equipment;
}
public void setEquipment(String equipment) {
	this.equipment = equipment;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public float getMoney() {
	return money;
}
public void setMoney(float money) {
	this.money = money;
}
public String getHouse_pictures() {
	return house_pictures;
}
public void setHouse_pictures(String house_pictures) {
	this.house_pictures = house_pictures;
}
public String getDetail() {
	return detail;
}
public void setDetail(String detail) {
	this.detail = detail;
}
public char getLegal() {
	return legal;
}
public void setLegal(char legal) {
	this.legal = legal;
}
public boolean isChecked() {
	return checked;
}
public void setChecked(boolean checked) {
	this.checked = checked;
}
@Temporal(TemporalType.DATE)
public Date getChecked_time() {
	return checked_time;
}
public void setChecked_time(Date checked_time) {
	this.checked_time = checked_time;
}
@ManyToOne
@JoinColumn(name="user_id")
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}

@OneToMany(cascade=CascadeType.ALL,mappedBy="out")
public Set<Message> getMessage() {
	return message;
}
public void setMessage(Set<Message> message) {
	this.message = message;
}
public String getRentType() {
	return rentType;
}
public void setRentType(String rentType) {
	this.rentType = rentType;
}
public String getArea() {
	return area;
}
public void setArea(String area) {
	this.area = area;
}
  
  
  
}
