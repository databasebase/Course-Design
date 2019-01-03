package Test;

import com.entity.movie_review;

import dao.movie_reviewDao;

public class movie_reviewTest {
	public static void main(String[] args) {
		view();
//		insert();
//		delete();
		change();
		view();
	}
	
	public static void view() {
		movie_reviewDao obj = new movie_reviewDao();
		obj.view();
	}
	
	public static void insert() {
		movie_reviewDao obj = new movie_reviewDao();
		movie_review a = new movie_review();
		a.setMovie_id(3);
		a.setUser_id(2);
		a.setMovie_time("2018-12-25");
		a.setMovie_lik("25");
		a.setMovie_review("非常好看");
		obj.insert(a);
	}
	
	public static void delete() {
		movie_reviewDao obj = new movie_reviewDao();
		obj.delete(3, 2);
	}
	
	public static void change() {
		movie_reviewDao obj = new movie_reviewDao();
		movie_review a = new movie_review();
		a.setMovie_id(3);
		a.setUser_id(1);
		a.setMovie_time("2018-12-25");
		a.setMovie_lik("50");
		a.setMovie_review("真好看");
		obj.change(a);
	}
}
