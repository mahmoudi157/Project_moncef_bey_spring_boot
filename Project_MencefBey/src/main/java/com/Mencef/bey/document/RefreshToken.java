package com.Mencef.bey.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.*;

@Document
@Data
public class RefreshToken {
    @Id
    String id;
    @DocumentReference(lazy = true)
    private User owner;
	public RefreshToken(String id, User owner) {
		super();
		this.id = id;
		this.owner = owner;
	}
	public RefreshToken() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
}
