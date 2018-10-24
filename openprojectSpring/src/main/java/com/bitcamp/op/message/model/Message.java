package com.bitcamp.op.message.model;

public class Message {
	private int message_id;
	private String userid_member;
	private String message;

	public int getMessage_id() {
		return message_id;
	}

	public void setMessage_id(int message_id) {
		this.message_id = message_id;
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
		return "Message [message_id=" + message_id + ", userid_member=" + userid_member + ", message=" + message + "]";
	}

	

}
