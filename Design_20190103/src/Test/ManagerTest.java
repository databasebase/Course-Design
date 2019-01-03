package Test;
import dao.*;
import com.entity.*;

public class ManagerTest {
	public static void main(String[] args) {
		Login();
	}
	
	public static void view() {
		managerDao man = new managerDao();
		man.view_man();
	}
	
	public static void Insert() {
		manager m = new manager();
		m.setManager_name("lkb");
		m.setManager_age(20);
		m.setManager_cardid("1234");
		m.setManager_code("1234");
		m.setManager_email("lkb@qq.com");
		m.setManager_passsword("132456461544");
		m.setManager_phone("18820192019");
		managerDao man = new managerDao();
		man.Insert_man(m);
	}
	
	public static void Delete_id() {
		manager m = new manager();
		m.setManager_id(2);
		managerDao man = new managerDao();
		man.delete_man_id(m);
	}
	
	public static void Delete_name() {
		manager m = new manager();
		m.setManager_name("lkb");;
		managerDao man = new managerDao();
		man.delete_man_username(m);
	}
	
	public static void Change() {
		manager m = new manager();
		m.setManager_id(3);
		m.setManager_name("lkb");
		m.setManager_age(20);
		m.setManager_cardid("1234");
		m.setManager_code("1234");
		m.setManager_email("lkb@qq.com");
		m.setManager_passsword("132456461544");
		m.setManager_phone("18820192019");
		managerDao man = new managerDao();
		man.change_man(m);
	}
	
	public static void Sign() {
		managerDao man = new managerDao();
		man.sign_man();
	}
	
	public static void Login() {
		managerDao man = new managerDao();
		man.login_man();
	}
}
