package com.entity;

public class app_student {
	private int app_student_id;
	private int stu_id;
	private int book_id;
	private String app_date;//修改从data变为date
	public int getApp_student_id() {
		return app_student_id;
	}
	public void setApp_student_id(int app_student_id) {
		this.app_student_id = app_student_id;
	}
	public int getStu_id() {
		return stu_id;
	}
	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getApp_date() {
		return app_date;
	}
	public void setApp_date(String app_date) {
		this.app_date = app_date;
	}
	
	
}
