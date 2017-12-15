package com.github.alagesh.mongodb;

import org.bson.types.ObjectId;

/* Simple POJO for Movie */

public class Movie {

	
	private ObjectId Id;
	private String name;
	private int rating;
	
	public Movie() {
    }
	
	public Movie(String name, int rating) {
		super();
		this.Id = new ObjectId();
		this.name = name;
		this.rating = rating;
	}
	
	public ObjectId getId() {
		return Id;
	}
	public void setId(ObjectId id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "Movie [Id=" + Id + ", name=" + name + ", rating=" + rating + "]";
	}
	
	
	
	

}
