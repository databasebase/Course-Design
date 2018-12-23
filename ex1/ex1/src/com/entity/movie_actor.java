package com.entity;

public class movie_actor {
	private int movie_id;
	private int actor_id;
	private String actor_pro;
	public int getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}
	public int getActor_id() {
		return actor_id;
	}
	public void setActor_id(int actor_id) {
		this.actor_id = actor_id;
	}
	public String getActor_pro() {
		return actor_pro;
	}
	public void setActor_pro(String actor_pro) {
		this.actor_pro = actor_pro;
	}
}
