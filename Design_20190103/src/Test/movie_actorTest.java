package Test;
import com.entity.*;
import dao.*;

import com.entity.movie_actor;

import dao.movie_actorDao;

public class movie_actorTest {
	public static void main(String[] args) {
		view();
//		insert();
//		delete();
		change();
		view();
	}
	
	public static void view() {
		movie_actorDao obj = new movie_actorDao();
		obj.view();
	}
	
	public static void insert() {
		movie_actorDao obj = new movie_actorDao();
		movie_actor a = new movie_actor();
		a.setMovie_id(3);
		a.setActor_id(2);
		a.setActor_pro("主演");
		obj.insert(a);
	}
	
	public static void delete() {
		movie_actorDao obj = new movie_actorDao();
		obj.delete(3, 2);
	}
	
	public static void change() {
		movie_actorDao obj = new movie_actorDao();
		movie_actor a = new movie_actor();
		a.setMovie_id(3);
		a.setActor_id(1);
		a.setActor_pro("配角");
		obj.change(a);
	}
}
