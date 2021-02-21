package com.ensialligence.model;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {
	
	private int idMsg;
	private String msg;
	private Date date_envoi;
	private boolean isRead;
	private int idSender;
	private int idReceiver;
	
	public Message() {
		super();
	}
	
	public Message(int idMsg, String msg, Date date_envoi, boolean isRead, int idSender, int idReceiver) {
		super();
		this.idMsg = idMsg;
		this.msg = msg;
		this.date_envoi = date_envoi;
		this.isRead = isRead;
		this.idSender = idSender;
		this.idReceiver = idReceiver;
	}

	public int getIdMsg() {
		return idMsg;
	}
	
	public void setIdMsg(int idMsg) {
		this.idMsg = idMsg;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public Date getDate_envoi() {
		return date_envoi;
	}
	
	public void setDate_envoi(Date date_envoi) {
		this.date_envoi = date_envoi;
	}
	
	public boolean isRead() {
		return isRead;
	}
	
	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}
	
	public int getIdSender() {
		return idSender;
	}
	
	public void setIdSender(int idSender) {
		this.idSender = idSender;
	}
	
	public int getIdReceiver() {
		return idReceiver;
	}
	
	public void setIdReceiver(int idReceiver) {
		this.idReceiver = idReceiver;
	}

	@Override
	public String toString() {
		return "Message [idMsg=" + idMsg + ", msg=" + msg + ", date_envoi=" + date_envoi + ", isRead=" + isRead
				+ ", idSender=" + idSender + ", idReceiver=" + idReceiver + "]";
	}
	

}
