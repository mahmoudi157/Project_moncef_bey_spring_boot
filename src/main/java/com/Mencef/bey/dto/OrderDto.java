package com.Mencef.bey.dto;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;



import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.*;

@Document
@Getter
@Setter
public class OrderDto {
   private	String prodid;
  
   public OrderDto(String prodid,  String toid, String adress, String phone, String fromid, String quntite) {
	super();
	this.prodid = prodid;
	
	this.toid = toid;
	this.adress = adress;
	this.phone = phone;
	this.fromid = fromid;
	this.quntite = quntite;
}
public String getProdid() {
	return prodid;
}
public void setProdid(String prodid) {
	this.prodid = prodid;
}


public String getToid() {
	return toid;
}
public void setToid(String toid) {
	this.toid = toid;
}
public String getAdress() {
	return adress;
}
public void setAdress(String adress) {
	this.adress = adress;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getFromid() {
	return fromid;
}
public void setFromid(String fromid) {
	this.fromid = fromid;
}
public String getQuntite() {
	return quntite;
}
public void setQuntite(String quntite) {
	this.quntite = quntite;
}

    private String toid;
	private	String adress;
	private String phone;
	private String fromid;
	private String quntite;
	
	
	
	
}
