package com.Mencef.bey.document;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.*;

@Document
@Getter
@Setter
public class Message {
    @Id
	private String id ;
    public void setId(String id) {
		this.id = id;
	}
    

	
	private String toid;
	private String fromid;
	
	private Date date;
	private int view;
	private String img;
	private String msg;
	
	public String getToid() {
		return toid;
	}
	public void setToid(String toid) {
		this.toid = toid;
	}
	
	public String getFromid() {
		return fromid;
	}
	public void setFromid(String fromid) {
		this.fromid = fromid;
	}
	
	public Message(String toid, String fromid, Date date, String img, String msg) {
		super();
		this.toid = toid;
		this.fromid = fromid;
		this.date = date;
		this.img = img;
		this.msg = msg;
		this.view=0;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getId() {
		return id;
	}
	
	
}
