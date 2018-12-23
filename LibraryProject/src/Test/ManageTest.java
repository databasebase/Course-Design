package Test;

import java.util.Scanner;
import com.entity.*;

import dao.AppStudentDao;
import dao.AppTeacherDao;
import dao.BorrowStudentDao;
import dao.BorrowTeacherDao;
import dao.ColStudentDao;
import dao.ColTeacherDao;
import dao.ManagerDao;

/**
 * This test is manager test
 * @author chenmengda
 *
 */
public class ManageTest {
	public void TestManager()
	{
		System.out.println("Please choose login or sign in");
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		ManagerDao md = new ManagerDao();
		
		if(str.equals("login"))
		{
			String s1 = md.login_man();
			System.out.println("Welcom the manager "+s1);
		}
		else if (str.equals("sign in"))
		{
			md.sign_man();
			String s1 = md.login_man();
			System.out.println("Welcom the manager "+s1);
		}
		System.out.println("There are 11 tables you can operate.");
		System.out.println("Which part do you want to operate?");
		System.out.print("I want to operate the ");
		int flag = 0;
		Scanner s1 = new Scanner(System.in);
		String str1 = s1.nextLine();
		if(str1.equals("AppStudent table")){
			flag = 1;
		}else if(str1.equals("AppTeacher table")){
			flag = 2; 
		}else if(str1.equals("book table")){
			flag = 3;
		}else if(str1.equals("BorrowStudent table")){
			flag = 4;
		}else if(str1.equals("BorrowTeacher table")){
			flag = 5;
		}else if(str1.equals("ColStudent table")){
			flag = 6;
		}else if(str1.equals("ColTeacher table")){
			flag = 7;
		}else if(str1.equals("ReturnStudent table")){
			flag = 8;
		}else if(str1.equals("ReturnTeacher table")) {
			flag = 9;
		}else if(str1.equals("student table")){
			flag = 10 ;
		}else if(str1.equals("teacher table")){
			flag = 11;
		}else if(str1.equals("leave"))
		{
			flag = 12;
		}
		switch(flag) {
		case 1:
			while(true) 
			{
				AppStudentDao asd = new AppStudentDao();
				System.out.println("Please choose the number.");
				System.out.println("1.Insert a application to the Student Application table.");
				System.out.println("2.View the Student Application table");
				System.out.println("3.Delete a application from the Student Application table");
				System.out.println("4.Change a application from the Student Application table");
				System.out.println("5.Leave this part");
				Scanner s2 = new Scanner(System.in);
				String str2 = s2.nextLine();
				int num = Integer.parseInt(str2);
				int asflag = 0;
				switch(num) {
				case 1:
					AppStudent as = new AppStudent();
					System.out.println("Please input the student_id");	
					Scanner s3 = new Scanner(System.in);
					String str3= s3.nextLine();
					int student_id = Integer.parseInt(str3);
					as.setStu_id(student_id);
				
					System.out.println("Please input the book_id");
					Scanner s4 = new Scanner(System.in);	
					String str4 = s4.nextLine();
					int book_id = Integer.parseInt(str4);
					as.setBook_id(book_id);
				
					System.out.println("Please input the application_date");
					Scanner s5 = new Scanner(System.in);
					String app_date = s5.nextLine();
					as.setApp_date(app_date);
					asd.Insert(as);
					System.out.println("Insert Successfully ");
					break;
				case 2:
					asd.select();
					break;
				case 3:
					AppStudent as1 = new AppStudent();
					System.out.println("Please input the app_student_id you want to delete");
					Scanner s6 = new Scanner(System.in);
					String str6 = s6.nextLine();
					int app_student_id = Integer.parseInt(str6);
					as1.setApp_student_id(app_student_id);
					asd.delete(as1);
					System.out.println("Delete Successfully ");
					break;
				case 4:
					AppStudent as2 = new AppStudent();
					System.out.println("Please input the content you want to change(student_id, book_id, app_date)");
					Scanner s7 = new Scanner(System.in);
					String str7 = s7.nextLine();
					if(str7.equals("student_id"))
					{
						System.out.println("Please input the student_id and app_student_id you want to change");
						Scanner s8 = new Scanner(System.in);
						String str8 = s8.nextLine();
						String st[] = str8.split(" ");
						asd.changestu_id(Integer.parseInt(st[0]), Integer.parseInt(st[1]));
						System.out.println("Change Successfully ");
					}else if(str7.equals("book_id"))
					{
						System.out.println("Please input the book_id and app_student_id you want to change");
						Scanner s8 = new Scanner(System.in);
						String str8 = s8.nextLine();
						String st[] = str8.split(" ");
						asd.changebook_id(Integer.parseInt(st[0]), Integer.parseInt(st[1]));
						System.out.println("Change Successfully ");
					}else if(str7.equals("app_date"))
					{

						System.out.println("Please input the app_date and app_student_id you want to change");
						Scanner s8 = new Scanner(System.in);
						String str8 = s8.nextLine();
						String st[] = str8.split(" ");
						asd.changeapp_date(st[0], Integer.parseInt(st[1]));		
						System.out.println("Change Successfully ");
					}
					break;
				case 5:
					asflag = 1;
					break;
				}
				if (asflag == 1)
				{
					break;
				}
			}
			break;
		case 2:
			while(true) 
			{
				AppTeacherDao atd = new AppTeacherDao();
				System.out.println("Please choose the number.");
				System.out.println("1.Insert a application to the Teacher Application table.");
				System.out.println("2.View the Teacher Application table");
				System.out.println("3.Delete a application from the Teacher Application table");
				System.out.println("4.Change a application from the Teacher Application table");
				System.out.println("5.Leave this part");
				Scanner s2 = new Scanner(System.in);
				String str2 = s2.nextLine();
				int num = Integer.parseInt(str2);
				int atflag = 0;
				switch(num) {
				case 1:
					AppTeacher at = new AppTeacher();
					System.out.println("Please input the teacher_id");	
					Scanner s3 = new Scanner(System.in);
					String str3= s3.nextLine();
					int teacher_id = Integer.parseInt(str3);
					at.setTea_id(teacher_id);
					
					System.out.println("Please input the book_id");
					Scanner s4 = new Scanner(System.in);	
					String str4 = s4.nextLine();
					int book_id = Integer.parseInt(str4);
					at.setBook_id(book_id);
				
					System.out.println("Please input the application_date");
					Scanner s5 = new Scanner(System.in);
					String app_date = s5.nextLine();
					at.setApp_date(app_date);
					atd.Insert(at);
					System.out.println("Insert Successfully ");
					break;
				case 2:
					atd.select();
					break;
				case 3:
					AppTeacher at1 = new AppTeacher();
					System.out.println("Please input the app_teacher_id you want to delete");
					Scanner s6 = new Scanner(System.in);
					String str6 = s6.nextLine();
					int app_teacher_id = Integer.parseInt(str6);
					at1.setApp_teacher_id(app_teacher_id);
					atd.delete(at1);
					break;
				case 4:
					AppTeacher at2 = new AppTeacher();
					System.out.println("Please input the content you want to change(teacher_id, book_id, app_date)");
					Scanner s7 = new Scanner(System.in);
					String str7 = s7.nextLine();
					if(str7.equals("teacher_id"))
					{
						System.out.println("Please input the teacher_id and app_teacher_id you want to change");
						Scanner s8 = new Scanner(System.in);
						String str8 = s8.nextLine();
						String st[] = str8.split(" ");
						atd.changetea_id(Integer.parseInt(st[0]), Integer.parseInt(st[1]));
					}else if(str7.equals("book_id"))
					{
						System.out.println("Please input the book_id and app_teacher_id you want to change");
						Scanner s8 = new Scanner(System.in);
						String str8 = s8.nextLine();
						String st[] = str8.split(" ");
						atd.changebook_id(Integer.parseInt(st[0]), Integer.parseInt(st[1]));
					
					}else if(str7.equals("app_date"))
					{

						System.out.println("Please input the app_date and app_teacher_id you want to change");
						Scanner s8 = new Scanner(System.in);
						String str8 = s8.nextLine();
						String st[] = str8.split(" ");
						atd.changeapp_date(st[0], Integer.parseInt(st[1]));		
					}
					break;
				case 5:
					atflag = 1;
					break;
				}
				if (atflag == 1)
				{
					break;
				}
			}
			break;
		case 4:
			while(true) 
			{
				BorrowStudentDao bsd = new BorrowStudentDao();
				System.out.println("Please choose the number.");
				System.out.println("1.Insert a borrowing record to the Student Borrow table.");
				System.out.println("2.View the Student Borrow table");
				System.out.println("3.Delete a borrowing record from the Student Borrow table");
				System.out.println("4.Change a borrowing record from the Student Borrowtable");
				System.out.println("5.Leave this part");
				Scanner s2 = new Scanner(System.in);
				String str2 = s2.nextLine();
				int num = Integer.parseInt(str2);
				int bsflag = 0;
				switch(num) {
				case 1:
					BorrowStudent bs = new BorrowStudent();
					System.out.println("Please input the student_id");	
					Scanner s3 = new Scanner(System.in);
					String str3= s3.nextLine();
					int student_id = Integer.parseInt(str3);
					bs.setStu_id(student_id);
					
					System.out.println("Please input the book_id");
					Scanner s4 = new Scanner(System.in);	
					String str4 = s4.nextLine();
					int book_id = Integer.parseInt(str4);
					bs.setBook_id(book_id);
				
					System.out.println("Please input the borrow_date");
					Scanner s5 = new Scanner(System.in);
					String borrow_date = s5.nextLine();
					bs.setBorrow_date(borrow_date);
					bsd.Insert(bs);
					System.out.println("Insert Successfully ");
					break;
				case 2:
					bsd.select();
					break;
				case 3:
					BorrowStudent bs1 = new BorrowStudent();
					System.out.println("Please input the borrow_student_id you want to delete");
					Scanner s6 = new Scanner(System.in);
					String str6 = s6.nextLine();
					int borrow_student_id = Integer.parseInt(str6);
					bs1.setBorrow_student_id(borrow_student_id);
					bsd.delete(bs1);
					break;
				case 4:
					BorrowStudent bs2 = new BorrowStudent();
					System.out.println("Please input the content you want to change(student_id, book_id, borrow_date)");
					Scanner s7 = new Scanner(System.in);
					String str7 = s7.nextLine();
					if(str7.equals("student_id"))
					{
						System.out.println("Please input the student_id and borrow_student_id you want to change");
						Scanner s8 = new Scanner(System.in);
						String str8 = s8.nextLine();
						String st[] = str8.split(" ");
						bsd.changestu_id(Integer.parseInt(st[0]), Integer.parseInt(st[1]));
					}else if(str7.equals("book_id"))
					{
						System.out.println("Please input the book_id and borrow_student_id you want to change");
						Scanner s8 = new Scanner(System.in);
						String str8 = s8.nextLine();
						String st[] = str8.split(" ");
						bsd.changebook_id(Integer.parseInt(st[0]), Integer.parseInt(st[1]));
					
					}else if(str7.equals("app_date"))
					{

						System.out.println("Please input the borrow_date and borrow_student_id you want to change");
						Scanner s8 = new Scanner(System.in);
						String str8 = s8.nextLine();
						String st[] = str8.split(" ");
						bsd.changeborrow_date(st[0], Integer.parseInt(st[1]));		
					}
					break;
				case 5:
					bsflag = 1;
					break;
				}
				if (bsflag == 1)
				{
					break;
				}
			}
			break;
		case 3:
			break;
		case 5:
			while(true) 
			{
				BorrowTeacherDao btd = new BorrowTeacherDao();
				System.out.println("Please choose the number.");
				System.out.println("1.Insert a borrowing record to the Teacher Borrow table.");
				System.out.println("2.View the Student Borrow table");
				System.out.println("3.Delete a borrowing record from the Teacher Borrow table");
				System.out.println("4.Change a borrowing record from the Teacher Borrowtable");
				System.out.println("5.Leave this part");
				Scanner s2 = new Scanner(System.in);
				String str2 = s2.nextLine();
				int num = Integer.parseInt(str2);
				int btflag = 0;
				switch(num) {
				case 1:
					BorrowTeacher bt = new BorrowTeacher();
					System.out.println("Please input the teacher_id");	
					Scanner s3 = new Scanner(System.in);
					String str3= s3.nextLine();
					int teacher_id = Integer.parseInt(str3);
					bt.setTea_id(teacher_id);
					
					System.out.println("Please input the book_id");
					Scanner s4 = new Scanner(System.in);	
					String str4 = s4.nextLine();
					int book_id = Integer.parseInt(str4);
					bt.setBook_id(book_id);
				
					System.out.println("Please input the borrow_date");
					Scanner s5 = new Scanner(System.in);
					String borrow_date = s5.nextLine();
					bt.setBorrow_date(borrow_date);
					btd.Insert(bt);
					System.out.println("Insert Successfully ");
					break;
				case 2:
					btd.select();
					break;
				case 3:
					BorrowTeacher bt1 = new BorrowTeacher();
					System.out.println("Please input the borrow_teacher_id you want to delete");
					Scanner s6 = new Scanner(System.in);
					String str6 = s6.nextLine();
					int borrow_teacher_id = Integer.parseInt(str6);
					bt1.setBorrow_teacher_id(borrow_teacher_id);
					btd.delete(bt1);
					break;
				case 4:
					BorrowTeacher bt2 = new BorrowTeacher();
					System.out.println("Please input the content you want to change(teacher_id, book_id, borrow_date)");
					Scanner s7 = new Scanner(System.in);
					String str7 = s7.nextLine();
					if(str7.equals("teacher_id"))
					{
						System.out.println("Please input the teacher_id and borrow_teacher_id you want to change");
						Scanner s8 = new Scanner(System.in);
						String str8 = s8.nextLine();
						String st[] = str8.split(" ");
						btd.changetea_id(Integer.parseInt(st[0]), Integer.parseInt(st[1]));
					}else if(str7.equals("book_id"))
					{
						System.out.println("Please input the book_id and borrow_teacher_id you want to change");
						Scanner s8 = new Scanner(System.in);
						String str8 = s8.nextLine();
						String st[] = str8.split(" ");
						btd.changebook_id(Integer.parseInt(st[0]), Integer.parseInt(st[1]));
					
					}else if(str7.equals("app_date"))
					{

						System.out.println("Please input the borrow_date and borrow_teacher_id you want to change");
						Scanner s8 = new Scanner(System.in);
						String str8 = s8.nextLine();
						String st[] = str8.split(" ");
						btd.changeborrow_date(st[0], Integer.parseInt(st[1]));		
					}
					break;
				case 5:
					btflag = 1;
					break;
				}
				if (btflag == 1)
				{
					break;
				}
			}
			break;
		case 6:
			while(true) 
			{
				ColStudentDao csd = new ColStudentDao();
				System.out.println("Please choose the number.");
				System.out.println("1.Insert a collection record to the Student Collection table.");
				System.out.println("2.View the Student Collection table");
				System.out.println("3.Delete a collection record from the Student Collection table");
				System.out.println("4.Change a collection record from the Student Collection table");
				System.out.println("5.Leave this part");
				Scanner s2 = new Scanner(System.in);
				String str2 = s2.nextLine();
				int num = Integer.parseInt(str2);
				int csflag = 0;
				switch(num) {
				case 1:
					ColStudent cs = new ColStudent();
					System.out.println("Please input the student_id");	
					Scanner s3 = new Scanner(System.in);
					String str3= s3.nextLine();
					int student_id = Integer.parseInt(str3);
					cs.setStu_id(student_id);
					
					System.out.println("Please input the book_id");
					Scanner s4 = new Scanner(System.in);	
					String str4 = s4.nextLine();
					int book_id = Integer.parseInt(str4);
					cs.setBook_id(book_id);
				
					System.out.println("Please input the col_date");
					Scanner s5 = new Scanner(System.in);
					String col_date = s5.nextLine();
					cs.setCol_date(col_date);
					
					System.out.println("Please input the col_instr");
					Scanner ss = new Scanner(System.in);
					String col_instr = ss.nextLine();
					cs.setCol_instr(col_instr);
					csd.Insert(cs);
					System.out.println("Insert Successfully ");
					break;
				case 2:
					csd.select();
					break;
				case 3:
					ColStudent cs1 = new ColStudent();
					System.out.println("Please input the col_student_id you want to delete");
					Scanner s6 = new Scanner(System.in);
					String str6 = s6.nextLine();
					int col_student_id = Integer.parseInt(str6);
					cs1.setCol_student_id(col_student_id);
					csd.delete(cs1);
					break;
				case 4:
					ColStudent cs2 = new ColStudent();
					System.out.println("Please input the content you want to change(student_id, book_id, col_date,col_instr)");
					Scanner s7 = new Scanner(System.in);
					String str7 = s7.nextLine();
					if(str7.equals("student_id"))
					{
						System.out.println("Please input the student_id and col_student_id you want to change");
						Scanner s8 = new Scanner(System.in);
						String str8 = s8.nextLine();
						String st[] = str8.split(" ");
						csd.changestu_id(Integer.parseInt(st[0]), Integer.parseInt(st[1]));
					}else if(str7.equals("book_id"))
					{
						System.out.println("Please input the book_id and col_student_id you want to change");
						Scanner s8 = new Scanner(System.in);
						String str8 = s8.nextLine();
						String st[] = str8.split(" ");
						csd.changebook_id(Integer.parseInt(st[0]), Integer.parseInt(st[1]));
					
					}else if(str7.equals("col_date"))
					{

						System.out.println("Please input the col_date and col_student_id you want to change");
						Scanner s8 = new Scanner(System.in);
						String str8 = s8.nextLine();
						String st[] = str8.split(" ");
						csd.changecol_date(st[0], Integer.parseInt(st[1]));		
					}else if(str7.equals("col_instr"))
					{

						System.out.println("Please input the col_instr and col_student_id you want to change");
						Scanner s8 = new Scanner(System.in);
						String str8 = s8.nextLine();
						String st[] = str8.split(" ");
						csd.changecol_instr(st[0], Integer.parseInt(st[1]));	
					}
					break;
				case 5:
					csflag = 1;
					break;
				}
				if (csflag == 1)
				{
					break;
				}
			}
			break;
		case 7:
			while(true) 
			{
				ColTeacherDao ctd = new ColTeacherDao();
				System.out.println("Please choose the number.");
				System.out.println("1.Insert a collection record to the Teacher Collection table.");
				System.out.println("2.View the Student Collection table");
				System.out.println("3.Delete a collection record from the Teacher Collection table");
				System.out.println("4.Change a collection record from the Teacher Collection table");
				System.out.println("5.Leave this part");
				Scanner s2 = new Scanner(System.in);
				String str2 = s2.nextLine();
				int num = Integer.parseInt(str2);
				int csflag = 0;
				switch(num) {
				case 1:
					ColTeacher ct = new ColTeacher();
					System.out.println("Please input the teacher_id");	
					Scanner s3 = new Scanner(System.in);
					String str3= s3.nextLine();
					int teacher_id = Integer.parseInt(str3);
					ct.setTea_id(teacher_id);
					
					System.out.println("Please input the book_id");
					Scanner s4 = new Scanner(System.in);	
					String str4 = s4.nextLine();
					int book_id = Integer.parseInt(str4);
					ct.setBook_id(book_id);
				
					System.out.println("Please input the col_date");
					Scanner s5 = new Scanner(System.in);
					String col_date = s5.nextLine();
					ct.setCol_date(col_date);
					
					System.out.println("Please input the col_instr");
					Scanner ss = new Scanner(System.in);
					String col_instr = ss.nextLine();
					ct.setCol_instr(col_instr);
					ctd.Insert(ct);
					System.out.println("Insert Successfully ");
					break;
				case 2:
					ctd.select();
					break;
				case 3:
					ColTeacher ct1 = new ColTeacher();
					System.out.println("Please input the col_teacher_id you want to delete");
					Scanner s6 = new Scanner(System.in);
					String str6 = s6.nextLine();
					int col_teacher_id = Integer.parseInt(str6);
					ct1.setCol_teacher_id(col_teacher_id);
					ctd.delete(ct1);
					break;
				case 4:
					ColTeacher cs2 = new ColTeacher();
					System.out.println("Please input the content you want to change(teacher_id, book_id, col_date,col_instr)");
					Scanner s7 = new Scanner(System.in);
					String str7 = s7.nextLine();
					if(str7.equals("teacher_id"))
					{
						System.out.println("Please input the teacher_id and col_teacher_id you want to change");
						Scanner s8 = new Scanner(System.in);
						String str8 = s8.nextLine();
						String st[] = str8.split(" ");
						ctd.changetea_id(Integer.parseInt(st[0]), Integer.parseInt(st[1]));
					}else if(str7.equals("book_id"))
					{
						System.out.println("Please input the book_id and col_teacher_id you want to change");
						Scanner s8 = new Scanner(System.in);
						String str8 = s8.nextLine();
						String st[] = str8.split(" ");
						ctd.changebook_id(Integer.parseInt(st[0]), Integer.parseInt(st[1]));
					
					}else if(str7.equals("col_date"))
					{

						System.out.println("Please input the col_date and col_teacher_id you want to change");
						Scanner s8 = new Scanner(System.in);
						String str8 = s8.nextLine();
						String st[] = str8.split(" ");
						ctd.changecol_date(st[0], Integer.parseInt(st[1]));		
					}else if(str7.equals("col_instr"))
					{

						System.out.println("Please input the col_instr and col_teacher_id you want to change");
						Scanner s8 = new Scanner(System.in);
						String str8 = s8.nextLine();
						String st[] = str8.split(" ");
						ctd.changecol_instr(st[0], Integer.parseInt(st[1]));	
					}
					break;
				case 5:
					csflag = 1;
					break;
				}
				if (csflag == 1)
				{
					break;
				}
			}
			break;
		case 8:
			break;
		case 9:
			break;
		case 10:
			break;
		case 11:
			break;
		case 12:
			break;
		default:
			break;
		}
	}
}
