package Test;

import com.entity.actor;
import com.entity.users;
import com.entity.users;

import dao.actorDao;
import dao.usersDao;
import dao.usersDao;

public class usersTest {
	public static void main(String[] args) {
		view();
//		insert();
//		delete();
//		change();
//		Sign();
		Login();
//		view();
	}
	
	public static void view() {
		usersDao man = new usersDao();
		man.view();
	}
	
	public static void insert() {
		users m = new users();
		m.setUser_name("lkb");
		m.setUser_age(20);
		m.setUser_cardid("1234");
		m.setUser_code("1234");
		m.setUser_email("lkb@qq.com");
		m.setUser_password("1234567890");
		m.setUser_sex("male");
		usersDao man = new usersDao();
		man.Insert(m);
	}
	
	public static void delete() {
		usersDao man = new usersDao();
		man.delete(4);
	}
	
	
	public static void change() {
		users m = new users();
		m.setUser_id(3);
		m.setUser_name("lkb");
		m.setUser_age(20);
		m.setUser_cardid("1234");
		m.setUser_code("1234");
		m.setUser_email("lkb@qq.com");
		m.setUser_password("5895");
		m.setUser_sex("男");
		usersDao man = new usersDao();
		man.change(m);
	}
	
	public static void Sign() {
		usersDao man = new usersDao();
		man.sign();
	}
	
	public static void Login() {
		usersDao man = new usersDao();
		man.login();
	}
}
