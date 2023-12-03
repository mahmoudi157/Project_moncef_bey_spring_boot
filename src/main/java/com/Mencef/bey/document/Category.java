package com.Mencef.bey.document;

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
public class Category {
    @Id
	private String id ;
    public void setId(String id) {
		this.id = id;
	}
	
	private String name;
	
	private String descp;
	
	private String parantkey;
	private String img;
	private double price;
	
	private String cov1;
	private String cov2;
	private String cov3;
	private String cov4;
	private String qrcode;
	private float rating;
	private int nbrevente;
	private String adress;
	private float lat;
	public Category(String name, String descp, String parantkey, String img, double price, String cov1, String cov2,
			String cov3, String cov4, String qrcode, String adress, float lat, float lng, float min, String provider) {
		super();
		this.name = name;
		this.descp = descp;
		this.parantkey = parantkey;
		this.img = img;
		this.price = price;
		this.cov1 = cov1;
		this.cov2 = cov2;
		this.cov3 = cov3;
		this.cov4 = cov4;
		this.qrcode = qrcode;
		this.adress = adress;
		this.lat = lat;
		this.lng = lng;
		this.min = min;
		this.provider = provider;
	}
	public String getParantkey() {
		return parantkey;
	}
	public void setParantkey(String parantkey) {
		this.parantkey = parantkey;
	}
	public String getCov1() {
		return cov1;
	}
	public void setCov1(String cov1) {
		this.cov1 = cov1;
	}
	public String getCov2() {
		return cov2;
	}
	public void setCov2(String cov2) {
		this.cov2 = cov2;
	}
	public String getCov3() {
		return cov3;
	}
	public void setCov3(String cov3) {
		this.cov3 = cov3;
	}
	public String getCov4() {
		return cov4;
	}
	public void setCov4(String cov4) {
		this.cov4 = cov4;
	}
	public String getQrcode() {
		return qrcode;
	}
	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public int getNbrevente() {
		return nbrevente;
	}
	public void setNbrevente(int nbrevente) {
		this.nbrevente = nbrevente;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public float getLat() {
		return lat;
	}
	public void setLat(float lat) {
		this.lat = lat;
	}
	public float getLng() {
		return lng;
	}
	public void setLng(float lng) {
		this.lng = lng;
	}
	public float getMin() {
		return min;
	}
	public void setMin(float min) {
		this.min = min;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}

	private float lng;
	private float min;
	private String provider;

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
	public String getId() {
		return id;
	}
	
	
	
	
	
	
	
	
	
	
}
