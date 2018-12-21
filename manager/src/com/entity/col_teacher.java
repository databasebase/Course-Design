package com.entity;

public class col_teacher {
	private int col_teacher_id;
	private int tea_id;
	private int book_id;
	private String col_date;
	private String col_instr;
	public int getCol_teacher_id() {
		return col_teacher_id;
	}
	public void setCol_teacher_id(int col_teacher_id) {
		this.col_teacher_id = col_teacher_id;
	}
	public int getTea_id() {
		return tea_id;
	}
	public void setTea_id(int tea_id) {
		this.tea_id = tea_id;
	}
	public String getCol_date() {
		return col_date;
	}
	public void setCol_date(String col_date) {
		this.col_date = col_date;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getCol_instr() {
		return col_instr;
	}
	public void setCol_instr(String col_instr) {
		this.col_instr = col_instr;
	}
	
}
