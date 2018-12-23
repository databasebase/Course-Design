package com.entity;

public class movies_review {
	private int movie_id;
	private int user_id;
	private String movie_time;
	private String movie_lik;
	public int getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getMovie_time() {
		return movie_time;
	}
	public void setMovie_time(String movie_time) {
		this.movie_time = movie_time;
	}
	public String getMovie_lik() {
		return movie_lik;
	}
	public void setMovie_lik(String movie_lik) {
		this.movie_lik = movie_lik;
	}
}
