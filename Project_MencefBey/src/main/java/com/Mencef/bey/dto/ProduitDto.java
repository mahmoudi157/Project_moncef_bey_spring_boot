package com.Mencef.bey.dto;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.*;

@Document
@Getter
@Setter
public class ProduitDto {
   
	
	private String name;
	
	private String parent;
	
	
	public String getParent() {
		return parent;
	}
	

	private String descp;
	
	private String keycate;
	private double price;
	private String img;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescp() {
		return descp;
	}
	public void setDescp(String descp) {
		this.descp = descp;
	}
	public String getKeycate() {
		return keycate;
	}
	public void setKeycate(String keycate) {
		this.keycate = keycate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public ProduitDto(String name, String parent, String descp, String keycate, double price, String img) {
		super();
		this.name = name;
		this.parent = parent;
		this.descp = descp;
		this.keycate = keycate;
		this.price = price;
		this.img = img;
	}
	
	
	
	
	
	
	
	
	
	
	
}
