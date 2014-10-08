package com.massconnections.Domains;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Message implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1113415222023133104L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	private String subject;
	private Date date;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private String content;
	
	@ManyToOne
	@JoinColumn(name="senderId")
	private Crowd sender;
	
	@ManyToOne
	@JoinColumn(name="recieverId")
	private Crowd reciever;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Crowd getSender() {
		return sender;
	}
	public void setSender(Crowd sender) {
		this.sender = sender;
	}
	public Crowd getRecever() {
		return reciever;
	}
	public void setRecever(Crowd recever) {
		this.reciever = recever;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	
}