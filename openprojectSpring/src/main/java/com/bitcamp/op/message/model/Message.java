package com.bitcamp.op.message.model;

public class Message {
	private int id;
	private String userid_member;
	private String message;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserid_member() {
		return userid_member;
	}

	public void setUserid_member(String userid_member) {
		this.userid_member = userid_member;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", userid_member=" + userid_member + ", message=" + message + "]";
	}

	

}
