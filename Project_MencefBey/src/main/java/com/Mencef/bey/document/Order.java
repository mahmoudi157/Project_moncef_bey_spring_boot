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
public class Order {
    @Id
	private String id ;
    public void setId(String id) {
		this.id = id;
	}
    
    Produit produit;
    
   
	
	
	private String toid;
	
	
	private Date date;
	private String adress;
	private String phone;
	private String fromid;
	private String quntite;
	private String acp;
	private String rec;
	
	
	
	
	public Order(Produit produit, String toid, Date date, String adress, String phone,
			String fromid, String quntite, String acp, String rec) {
		super();
		this.produit = produit;
		
		this.toid = toid;
		this.date = date;
		this.adress = adress;
		this.phone = phone;
		this.fromid = fromid;
		this.quntite = quntite;
		this.acp = acp;
		this.rec = rec;
		
	}
	
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	
	public String getToid() {
		return toid;
	}
	public void setToid(String toid) {
		this.toid = toid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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
	public String getAcp() {
		return acp;
	}
	public void setAcp(String acp) {
		this.acp = acp;
	}
	public String getRec() {
		return rec;
	}
	public void setRec(String rec) {
		this.rec = rec;
	}
	public String getId() {
		return id;
	}
	
	
	
	
	
	
	
	
	
	
}
