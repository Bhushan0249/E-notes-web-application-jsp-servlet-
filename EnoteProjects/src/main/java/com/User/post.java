package com.User;

import java.sql.Date;

public class post {

	private int mid;
	private String title;
	private String content;
	private Date  udate;
	private UserDetails user;
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getUdate() {
		return udate;
	}
	public void setUdate(Date udate) {
		this.udate = udate;
	}
	public UserDetails getUser() {
		return user;
	}
	public void setUser(UserDetails user) {
		this.user = user;
	}
	public post() {
		super();
		// TODO Auto-generated constructor stub
	}
	public post(int mid, String title, String content, Date udate, UserDetails user) {
		super();
		this.mid = mid;
		this.title = title;
		this.content = content;
		this.udate = udate;
		this.user = user;
	}
	
	
	
}
