package com.rent.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Message {
   private  int message_id;
   private int  sender;
   private int  getter;
   private String content;
   private Date date;
   private Rent_Out out;
   private Rent_In in;
   private User user;
   @Id
   @GeneratedValue
public int getMessage_id() {
	return message_id;
}
public void setMessage_id(int message_id) {
	this.message_id = message_id;
}

public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
@Temporal(TemporalType.TIME)
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
@ManyToOne(cascade=CascadeType.ALL)
@JoinColumn(name="out_id")
public Rent_Out getOut() {
	return out;
}
public void setOut(Rent_Out out) {
	this.out = out;
}
@ManyToOne(cascade=CascadeType.ALL)
@JoinColumn(name="in_id")
public Rent_In getIn() {
	return in;
}
public void setIn(Rent_In in) {
	this.in = in;
}
public int getSender() {
	return sender;
}
public void setSender(int sender) {
	this.sender = sender;
}
public int getGetter() {
	return getter;
}
public void setGetter(int getter) {
	this.getter = getter;
}
@ManyToOne(cascade=CascadeType.ALL)
@JoinColumn(name="user_id")
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
 
   
   
}
