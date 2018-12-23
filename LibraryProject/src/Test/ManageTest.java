package Test;

import java.util.Scanner;
import com.entity.*;

import dao.AppStudentDao;
import dao.AppTeacherDao;
import dao.BookDao;
import dao.BorrowStudentDao;
import dao.BorrowTeacherDao;
import dao.ColStudentDao;
import dao.ColTeacherDao;
import dao.ManagerDao;
import dao.ReturnStudentDao;
import dao.ReturnTeacherDao;
import dao.StudentDao;
import dao.TeacherDao;

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
		while(true){
			int fflag = 0;
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
			while(true) 
			{
				BookDao bd = new BookDao();
				System.out.println("Please choose the number.");
				System.out.println("1.Insert a book record to the book table.");
				System.out.println("2.View the book table");
				System.out.println("3.Delete a book record book table");
				System.out.println("4.Change a book record from the book table");
				System.out.println("5.Leave this part");
				Scanner s2 = new Scanner(System.in);
				String str2 = s2.nextLine();
				int num = Integer.parseInt(str2);
				int bflag = 0;
				switch(num) {
				case 1:
					book b = new book();
					System.out.println("Please input the book_name");	
					Scanner s3 = new Scanner(System.in);
					String str3= s3.nextLine();
					b.setBook_name(str3);
					
					System.out.println("Please input the book_intro");
					Scanner s4 = new Scanner(System.in);	
					String str4 = s4.nextLine();
					b.setBook_intro(str4);
				
					System.out.println("Please input the book_addr");
					Scanner s5 = new Scanner(System.in);
					String str5 = s5.nextLine();
					b.setBook_addr(str5);
					
					System.out.println("Please input the book_ok");
					Scanner s6 = new Scanner(System.in);
					String str6 = s6.nextLine();
					b.setBook_ok(str6);
					
					System.out.println("Please input the book_health");
					Scanner s7 = new Scanner(System.in);
					String str7 = s7.nextLine();
					b.setBook_health(Integer.parseInt(str7));
					
					System.out.println("Please input the book_record");
					Scanner s8 = new Scanner(System.in);
					String str8 = s8.nextLine();
					b.setBook_record(str8);
					
					System.out.println("Please input the book_borrow_times");
					Scanner s9 = new Scanner(System.in);
					String str9 = s9.nextLine();
					b.setBook_borrow_times(Integer.parseInt(str9));
					
					System.out.println("Please input the book_price");
					Scanner s10 = new Scanner(System.in);
					String str10 = s10.nextLine();
					b.setBook_price(Double.parseDouble(str10));
					
					System.out.println("Please input the book_sort");
					Scanner s11 = new Scanner(System.in);
					String str11 = s11.nextLine();
					b.setBook_sort(str11);
					
					System.out.println("Please input the book_aut");
					Scanner s12 = new Scanner(System.in);
					String str12 = s12.nextLine();
					b.setBook_aut(str12);
					
					System.out.println("Please input the book_state");
					Scanner s13 = new Scanner(System.in);
					String str13 = s13.nextLine();
					b.setBook_state(Integer.parseInt(str13));
					
					bd.Insert(b);
					System.out.println("Insert Successfully ");
					break;
				case 2:
					bd.select();
					break;
				case 3:
					book b1 = new book();
					System.out.println("Please input the book_id you want to delete");
					Scanner s14 = new Scanner(System.in);
					String str14 = s14.nextLine();
					int book_id = Integer.parseInt(str14);
					b1.setBook_id(book_id);
					bd.delete(b1);
					break;
				case 4:
					book b2 = new book();
					System.out.println("Please input the content you want to change(book_name, book_intro, book_addr,book_ok,book_health,book_record,book_borrow_times,book_price,book_sort,book_aut,book_state)");
					Scanner s15 = new Scanner(System.in);
					String str15 = s15.nextLine();
					if(str15.equals("book_name"))
					{
						System.out.println("Please input the book_name and book_id you want to change");
						Scanner s16 = new Scanner(System.in);
						String str16 = s16.nextLine();
						String st[] = str16.split(" ");
						bd.changebook_name(st[0], Integer.parseInt(st[1]));
					}else if(str15.equals("book_intro"))
					{
						System.out.println("Please input the book_intro and book_id you want to change");
						Scanner s16 = new Scanner(System.in);
						String str16 = s16.nextLine();
						String st[] = str16.split(" ");
						bd.changebook_intro(st[0], Integer.parseInt(st[1]));
					
					}else if(str15.equals("book_addr"))
					{

						System.out.println("Please input the book_addr and book_id you want to change");
						Scanner s16 = new Scanner(System.in);
						String str16 = s16.nextLine();
						String st[] = str16.split(" ");
						bd.changebook_addr(st[0], Integer.parseInt(st[1]));		
					}else if(str15.equals("book_ok"))
					{

						System.out.println("Please input the book_ok and book_id you want to change");
						Scanner s16 = new Scanner(System.in);
						String str16 = s16.nextLine();
						String st[] = str16.split(" ");
						bd.changebook_ok(st[0], Integer.parseInt(st[1]));		
					}else if(str15.equals("book_record"))
					{

						System.out.println("Please input the book_record and book_id you want to change");
						Scanner s16 = new Scanner(System.in);
						String str16 = s16.nextLine();
						String st[] = str16.split(" ");
						bd.changebook_record(st[0], Integer.parseInt(st[1]));		
					}else if(str15.equals("book_sort"))
					{

						System.out.println("Please input the book_sort and book_id you want to change");
						Scanner s16 = new Scanner(System.in);
						String str16 = s16.nextLine();
						String st[] = str16.split(" ");
						bd.changebook_sort(st[0], Integer.parseInt(st[1]));		
					}else if(str15.equals("book_aut"))
					{

						System.out.println("Please input the book_aut and book_id you want to change");
						Scanner s16 = new Scanner(System.in);
						String str16 = s16.nextLine();
						String st[] = str16.split(" ");
						bd.changebook_aut(st[0], Integer.parseInt(st[1]));		
					}else if(str15.equals("book_health"))
					{

						System.out.println("Please input the book_health and book_id you want to change");
						Scanner s16 = new Scanner(System.in);
						String str16 = s16.nextLine();
						String st[] = str16.split(" ");
						bd.changebook_health(Integer.parseInt(st[0]), Integer.parseInt(st[1]));		
					}else if(str15.equals("book_borrow_times"))
					{

						System.out.println("Please input the book_borrow_times and book_id you want to change");
						Scanner s16 = new Scanner(System.in);
						String str16 = s16.nextLine();
						String st[] = str16.split(" ");
						bd.changebook_borrow_times(Integer.parseInt(st[0]), Integer.parseInt(st[1]));		
					}else if(str15.equals("book_price"))
					{

						System.out.println("Please input the book_price and book_id you want to change");
						Scanner s16 = new Scanner(System.in);
						String str16 = s16.nextLine();
						String st[] = str16.split(" ");
						bd.changebook_price(Double.parseDouble(st[0]), Integer.parseInt(st[1]));		
					}else if(str15.equals("book_state"))
					{

						System.out.println("Please input the book_state and book_id you want to change");
						Scanner s16 = new Scanner(System.in);
						String str16 = s16.nextLine();
						String st[] = str16.split(" ");
						bd.changebook_state(Integer.parseInt(st[0]), Integer.parseInt(st[1]));		
					}
					break;
				case 5:
					bflag = 1;
					break;
				}
				if (bflag == 1)
				{
					break;
				}
			}
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
			while(true) 
			{
				ReturnStudentDao rsd = new ReturnStudentDao();
				System.out.println("Please choose the number.");
				System.out.println("1.Insert a return record to the Student Return table.");
				System.out.println("2.View the Student Return table");
				System.out.println("3.Delete a return record from the Student Teacher table");
				System.out.println("4.Change a return record from the Student Teacher table");
				System.out.println("5.Leave this part");
				Scanner s2 = new Scanner(System.in);
				String str2 = s2.nextLine();
				int num = Integer.parseInt(str2);
				int rsflag = 0;
				switch(num) {
				case 1:
					ReturnStudent rs = new ReturnStudent();
					System.out.println("Please input the student_id");	
					Scanner s3 = new Scanner(System.in);
					String str3= s3.nextLine();
					int student_id = Integer.parseInt(str3);
					rs.setStu_id(student_id);
					
					System.out.println("Please input the book_id");
					Scanner s4 = new Scanner(System.in);	
					String str4 = s4.nextLine();
					int book_id = Integer.parseInt(str4);
					rs.setBook_id(book_id);
				
					System.out.println("Please input the return_date");
					Scanner s5 = new Scanner(System.in);
					String return_date = s5.nextLine();
					rs.setReturn_date(return_date);
					
					System.out.println("Please input the manager_id");
					Scanner ss = new Scanner(System.in);
					String manager_id = ss.nextLine();
					rs.setManager_id(Integer.parseInt(manager_id));
					
					System.out.println("Please input the book_health");
					Scanner ss1 = new Scanner(System.in);
					String book_health = ss1.nextLine();
					rs.setBook_health(Integer.parseInt(book_health));
					
					System.out.println("Insert Successfully ");
					break;
				case 2:
					rsd.select();
					break;
				case 3:
					ReturnStudent rs1 = new ReturnStudent();
					System.out.println("Please input the return_student_id you want to delete");
					Scanner s6 = new Scanner(System.in);
					String str6 = s6.nextLine();
					int return_student_id = Integer.parseInt(str6);
					rs1.setReturn_student_id(return_student_id);
					rsd.delete_id(rs1);
					break;
				case 4:
					ReturnStudent rs2 = new ReturnStudent();
					System.out.println("Please input the content you want to change(student_id, book_id, return_date,manager_id,book_health)");
					Scanner s7 = new Scanner(System.in);
					String str7 = s7.nextLine();
					if(str7.equals("student_id"))
					{
						System.out.println("Please input the student_id and return_student_id you want to change");
						Scanner s8 = new Scanner(System.in);
						String str8 = s8.nextLine();
						String st[] = str8.split(" ");
						rsd.changestu_id(Integer.parseInt(st[0]), Integer.parseInt(st[1]));
					}else if(str7.equals("book_id"))
					{
						System.out.println("Please input the book_id and return_student_id you want to change");
						Scanner s8 = new Scanner(System.in);
						String str8 = s8.nextLine();
						String st[] = str8.split(" ");
						rsd.changebook_id(Integer.parseInt(st[0]), Integer.parseInt(st[1]));
					
					}else if(str7.equals("col_date"))
					{

						System.out.println("Please input the return_date and return_student_id you want to change");
						Scanner s8 = new Scanner(System.in);
						String str8 = s8.nextLine();
						String st[] = str8.split(" ");
						rsd.changereturn_date(st[0], Integer.parseInt(st[1]));		
					}else if(str7.equals("manager_id"))
					{
						System.out.println("Please input the manager_id and return_student_id you want to change");
						Scanner s8 = new Scanner(System.in);
						String str8 = s8.nextLine();
						String st[] = str8.split(" ");
						rsd.changemanager_id(Integer.parseInt(st[0]), Integer.parseInt(st[1]));
					
					}else if(str7.equals("book_health"))
					{
						System.out.println("Please input the book_health and return_student_id you want to change");
						Scanner s8 = new Scanner(System.in);
						String str8 = s8.nextLine();
						String st[] = str8.split(" ");
						rsd.changebook_health(Integer.parseInt(st[0]), Integer.parseInt(st[1]));
					
					}
					break;
				case 5:
					rsflag = 1;
					break;
				}
				if (rsflag == 1)
				{
					break;
				}
			}
			break;
		case 9:
			while(true) 
			{
				ReturnTeacherDao rtd = new ReturnTeacherDao();
				System.out.println("Please choose the number.");
				System.out.println("1.Insert a return record to the Teacher Return table.");
				System.out.println("2.View the Teacher Return table");
				System.out.println("3.Delete a return record from the Teacher Return table");
				System.out.println("4.Change a return record from the Teacher Return table");
				System.out.println("5.Leave this part");
				Scanner s2 = new Scanner(System.in);
				String str2 = s2.nextLine();
				int num = Integer.parseInt(str2);
				int rsflag = 0;
				switch(num) {
				case 1:
					ReturnTeacher rt = new ReturnTeacher();
					System.out.println("Please input the teacher_id");	
					Scanner s3 = new Scanner(System.in);
					String str3= s3.nextLine();
					int teacher_id = Integer.parseInt(str3);
					rt.setTea_id(teacher_id);
					
					System.out.println("Please input the book_id");
					Scanner s4 = new Scanner(System.in);	
					String str4 = s4.nextLine();
					int book_id = Integer.parseInt(str4);
					rt.setBook_id(book_id);
				
					System.out.println("Please input the return_date");
					Scanner s5 = new Scanner(System.in);
					String return_date = s5.nextLine();
					rt.setReturn_date(return_date);
					
					System.out.println("Please input the manager_id");
					Scanner ss = new Scanner(System.in);
					String manager_id = ss.nextLine();
					rt.setManager_id(Integer.parseInt(manager_id));
					
					System.out.println("Please input the book_health");
					Scanner ss1 = new Scanner(System.in);
					String book_health = ss1.nextLine();
					rt.setBook_health(Integer.parseInt(book_health));
					
					System.out.println("Insert Successfully ");
					break;
				case 2:
					rtd.select();
					break;
				case 3:
					ReturnTeacher rt1 = new ReturnTeacher();
					System.out.println("Please input the return_teacher_id you want to delete");
					Scanner s6 = new Scanner(System.in);
					String str6 = s6.nextLine();
					int return_teacher_id = Integer.parseInt(str6);
					rt1.setReturn_teacher_id(return_teacher_id);
					rtd.delete_id(rt1);
					break;
				case 4:
					ReturnTeacher rt2 = new ReturnTeacher();
					System.out.println("Please input the content you want to change(teacher_id, book_id, return_date,manager_id,book_health)");
					Scanner s7 = new Scanner(System.in);
					String str7 = s7.nextLine();
					if(str7.equals("teacher_id"))
					{
						System.out.println("Please input the teacher_id and return_teacher_id you want to change");
						Scanner s8 = new Scanner(System.in);
						String str8 = s8.nextLine();
						String st[] = str8.split(" ");
						rtd.changetea_id(Integer.parseInt(st[0]), Integer.parseInt(st[1]));
					}else if(str7.equals("book_id"))
					{
						System.out.println("Please input the book_id and return_teacher_id you want to change");
						Scanner s8 = new Scanner(System.in);
						String str8 = s8.nextLine();
						String st[] = str8.split(" ");
						rtd.changebook_id(Integer.parseInt(st[0]), Integer.parseInt(st[1]));
					
					}else if(str7.equals("col_date"))
					{

						System.out.println("Please input the return_date and return_teacher_id you want to change");
						Scanner s8 = new Scanner(System.in);
						String str8 = s8.nextLine();
						String st[] = str8.split(" ");
						rtd.changereturn_date(st[0], Integer.parseInt(st[1]));		
					}else if(str7.equals("manager_id"))
					{
						System.out.println("Please input the manager_id and return_teacher_id you want to change");
						Scanner s8 = new Scanner(System.in);
						String str8 = s8.nextLine();
						String st[] = str8.split(" ");
						rtd.changemanager_id(Integer.parseInt(st[0]), Integer.parseInt(st[1]));
					
					}else if(str7.equals("book_health"))
					{
						System.out.println("Please input the book_health and return_teacher_id you want to change");
						Scanner s8 = new Scanner(System.in);
						String str8 = s8.nextLine();
						String st[] = str8.split(" ");
						rtd.changebook_health(Integer.parseInt(st[0]), Integer.parseInt(st[1]));
					
					}
					break;
				case 5:
					rsflag = 1;
					break;
				}
				if (rsflag == 1)
				{
					break;
				}
			}
			break;
		case 10:
			while(true) 
			{
				StudentDao sd = new StudentDao();
				System.out.println("Please choose the number.");
				System.out.println("1.Insert a student record to the Student table.");
				System.out.println("2.View the Student table");
				System.out.println("3.Delete a student record from the Student table");
				System.out.println("4.Change a student record from the Student table");
				System.out.println("5.Leave this part");
				Scanner s2 = new Scanner(System.in);
				String str2 = s2.nextLine();
				int num = Integer.parseInt(str2);
				int sflag = 0;
				switch(num) {
				case 1:
					student st = new student();
					System.out.println("Please input the stu_name");	
					Scanner s3 = new Scanner(System.in);
					String str3= s3.nextLine();
					st.setStu_name(str3);
					
					System.out.println("Please input the stu_sex");
					Scanner s4 = new Scanner(System.in);	
					String str4 = s4.nextLine();
					st.setStu_sex(str4);
				
					System.out.println("Please input the stu_age");
					Scanner s5 = new Scanner(System.in);
					String str5 = s5.nextLine();
					st.setStu_age(Integer.parseInt(str5));
					
					System.out.println("Please input the stu_pro");
					Scanner s6 = new Scanner(System.in);
					String str6 = s6.nextLine();
					st.setStu_pro(str6);
					
					System.out.println("Please input the stu_grade");
					Scanner s7 = new Scanner(System.in);
					String str7 = s7.nextLine();
					st.setStu_grade(Integer.parseInt(str7));
					
					System.out.println("Please input the stu_username");
					Scanner s8 = new Scanner(System.in);
					String str8 = s8.nextLine();
					st.setStu_username(str8);
					
					System.out.println("Please input the stu_passwd");
					Scanner s9 = new Scanner(System.in);
					String str9 = s9.nextLine();
					st.setStu_passwd(str9);
					
					System.out.println("Please input the stu_email");
					Scanner s10 = new Scanner(System.in);
					String str10 = s10.nextLine();
					st.setStu_email(str10);
					
					System.out.println("Please input the stu_cardid");
					Scanner s11 = new Scanner(System.in);
					String str11 = s11.nextLine();
					st.setStu_cardid(str11);
					
					System.out.println("Please input the stu_code");
					Scanner s12 = new Scanner(System.in);
					String str12 = s12.nextLine();
					st.setStu_code(str12);
					
					System.out.println("Please input the stu_left_borrow");
					Scanner s13 = new Scanner(System.in);
					String str13 = s13.nextLine();
					st.setStu_left_borrow(Integer.parseInt(str13));
					
					System.out.println("Please input the stu_left_applicate");
					Scanner s14= new Scanner(System.in);
					String str14 = s14.nextLine();
					st.setStu_left_applicate(Integer.parseInt(str14));
					
					System.out.println("Insert Successfully ");
					break;
				case 2:
					sd.View();
					break;
				case 3:
					student st1 = new student();
					System.out.println("Please input the student_id you want to delete");
					Scanner s15 = new Scanner(System.in);
					String str15 = s15.nextLine();
					sd.delete(Integer.parseInt(str15));
					break;
				case 4:
					student st2 = new student();
					System.out.println("Please input the content you want to change(student_name, student_sex, student_age,student_pro,student_grade,student_username,student_passwd,student_email,student_cardid,student_code,stu_left_borrow,stu_left_applicate)");
					Scanner s16 = new Scanner(System.in);
					String str16 = s16.nextLine();
					if(str16.equals("stu_name"))
					{
						System.out.println("Please input the student_name and stu_id you want to change");
						Scanner s17 = new Scanner(System.in);
						String str17 = s17.nextLine();
						String stt[] = str17.split(" ");
						sd.changestu_name(stt[0], Integer.parseInt(stt[1]));
					}if(str16.equals("stu_sex"))
					{
						System.out.println("Please input the student_sex and stu_id you want to change");
						Scanner s17 = new Scanner(System.in);
						String str17 = s17.nextLine();
						String stt[] = str17.split(" ");
						sd.changestu_sex(stt[0], Integer.parseInt(stt[1]));
					}if(str16.equals("stu_age"))
					{
						System.out.println("Please input the student_age and stu_id you want to change");
						Scanner s17 = new Scanner(System.in);
						String str17 = s17.nextLine();
						String stt[] = str17.split(" ");
						sd.changestu_age(Integer.parseInt(stt[0]), Integer.parseInt(stt[1]));
					}if(str16.equals("stu_pro"))
					{
						System.out.println("Please input the student_pro and stu_id you want to change");
						Scanner s17 = new Scanner(System.in);
						String str17 = s17.nextLine();
						String stt[] = str17.split(" ");
						sd.changestu_pro(stt[0], Integer.parseInt(stt[1]));
					}if(str16.equals("stu_grade"))
					{
						System.out.println("Please input the student_grade and stu_id you want to change");
						Scanner s17 = new Scanner(System.in);
						String str17 = s17.nextLine();
						String stt[] = str17.split(" ");
						sd.changestu_grade(Integer.parseInt(stt[0]), Integer.parseInt(stt[1]));
					}if(str16.equals("stu_username"))
					{
						System.out.println("Please input the student_username and stu_id you want to change");
						Scanner s17 = new Scanner(System.in);
						String str17 = s17.nextLine();
						String stt[] = str17.split(" ");
						sd.changestu_username(stt[0], Integer.parseInt(stt[1]));
					}if(str16.equals("stu_passwd"))
					{
						System.out.println("Please input the student_passwd and stu_id you want to change");
						Scanner s17 = new Scanner(System.in);
						String str17 = s17.nextLine();
						String stt[] = str17.split(" ");
						sd.changestu_passwd(stt[0], Integer.parseInt(stt[1]));
					}if(str16.equals("stu_email"))
					{
						System.out.println("Please input the student_email and stu_id you want to change");
						Scanner s17 = new Scanner(System.in);
						String str17 = s17.nextLine();
						String stt[] = str17.split(" ");
						sd.changestu_email(stt[0], Integer.parseInt(stt[1]));
					}if(str16.equals("stu_cardid"))
					{
						System.out.println("Please input the student_cardid and stu_id you want to change");
						Scanner s17 = new Scanner(System.in);
						String str17 = s17.nextLine();
						String stt[] = str17.split(" ");
						sd.changestu_cardid(stt[0], Integer.parseInt(stt[1]));
					}if(str16.equals("stu_code"))
					{
						System.out.println("Please input the student_code and stu_id you want to change");
						Scanner s17 = new Scanner(System.in);
						String str17 = s17.nextLine();
						String stt[] = str17.split(" ");
						sd.changestu_code(stt[0], Integer.parseInt(stt[1]));
					}if(str16.equals("stu_left_borrow"))
					{
						System.out.println("Please input the student_left_borrow and stu_id you want to change");
						Scanner s17 = new Scanner(System.in);
						String str17 = s17.nextLine();
						String stt[] = str17.split(" ");
						sd.changestu_left_borrow(Integer.parseInt(stt[0]), Integer.parseInt(stt[1]));
					}if(str16.equals("stu_left_applicate"))
					{
						System.out.println("Please input the student_left_applicate and stu_id you want to change");
						Scanner s17 = new Scanner(System.in);
						String str17 = s17.nextLine();
						String stt[] = str17.split(" ");
						sd.changestu_left_applicate(Integer.parseInt(stt[0]), Integer.parseInt(stt[1]));
					}
					break;
				case 5:
					sflag = 1;
					break;
				}
				if (sflag == 1)
				{
					break;
				}
			}
			break;
		case 11:
			while(true) 
		{
			TeacherDao td = new TeacherDao();
			System.out.println("Please choose the number.");
			System.out.println("1.Insert a teacher record to the Teacher table.");
			System.out.println("2.View the Teacher table");
			System.out.println("3.Delete a teacher record from the Teacher table");
			System.out.println("4.Change a teacher record from the Teacher table");
			System.out.println("5.Leave this part");
			Scanner s2 = new Scanner(System.in);
			String str2 = s2.nextLine();
			int num = Integer.parseInt(str2);
			int tflag = 0;
			switch(num) {
			case 1:
				teacher tt = new teacher();
				System.out.println("Please input the tea_name");	
				Scanner s3 = new Scanner(System.in);
				String str3= s3.nextLine();
				tt.setTea_name(str3);
				
				System.out.println("Please input the tea_sex");
				Scanner s4 = new Scanner(System.in);	
				String str4 = s4.nextLine();
				tt.setTea_sex(str4);
			
				System.out.println("Please input the tea_age");
				Scanner s5 = new Scanner(System.in);
				String str5 = s5.nextLine();
				tt.setTea_age(Integer.parseInt(str5));
				
				System.out.println("Please input the tea_dep");
				Scanner s6 = new Scanner(System.in);
				String str6 = s6.nextLine();
				tt.setTea_dep(str6);
				
				
				System.out.println("Please input the tea_username");
				Scanner s8 = new Scanner(System.in);
				String str8 = s8.nextLine();
				tt.setTea_username(str8);
				
				System.out.println("Please input the tea_passwd");
				Scanner s9 = new Scanner(System.in);
				String str9 = s9.nextLine();
				tt.setTea_passwd(str9);
				
				System.out.println("Please input the tea_email");
				Scanner s10 = new Scanner(System.in);
				String str10 = s10.nextLine();
				tt.setTea_email(str10);
				
				System.out.println("Please input the tea_cardid");
				Scanner s11 = new Scanner(System.in);
				String str11 = s11.nextLine();
				tt.setTea_cardid(str11);
				
				System.out.println("Please input the tea_code");
				Scanner s12 = new Scanner(System.in);
				String str12 = s12.nextLine();
				tt.setTea_code(str12);
				
				System.out.println("Please input the tea_left_borrow");
				Scanner s13 = new Scanner(System.in);
				String str13 = s13.nextLine();
				tt.setTea_left_borrow(Integer.parseInt(str13));
				
				System.out.println("Please input the tea_left_applicate");
				Scanner s14= new Scanner(System.in);
				String str14 = s14.nextLine();
				tt.setTea_left_applicate(Integer.parseInt(str14));
				
				System.out.println("Insert Successfully ");
				break;
			case 2:
				td.select();
				break;
			case 3:
				teacher tt1 = new teacher();
				System.out.println("Please input the teacher_id you want to delete");
				Scanner s15 = new Scanner(System.in);
				String str15 = s15.nextLine();
				tt1.setTea_id(Integer.parseInt(str15));
				td.delete_id(tt1);
				break;
			case 4:
				teacher tt2 = new teacher();
				System.out.println("Please input the content you want to change(teacher_name, teacher_sex, teacher_age,teacher_dep,teacher_username,teacher_passwd,teacher_email,teacher_cardid,teacher_code,tea_left_borrow,tea_left_applicate)");
				Scanner s16 = new Scanner(System.in);
				String str16 = s16.nextLine();
				if(str16.equals("tea_name"))
				{
					System.out.println("Please input the teacher_name and tea_id you want to change");
					Scanner s17 = new Scanner(System.in);
					String str17 = s17.nextLine();
					String stt[] = str17.split(" ");
					td.changetea_name(stt[0], Integer.parseInt(stt[1]));
				}if(str16.equals("tea_sex"))
				{
					System.out.println("Please input the teacher_sex and tea_id you want to change");
					Scanner s17 = new Scanner(System.in);
					String str17 = s17.nextLine();
					String stt[] = str17.split(" ");
					td.changetea_sex(stt[0], Integer.parseInt(stt[1]));
				}if(str16.equals("tea_age"))
				{
					System.out.println("Please input the teacher_age and tea_id you want to change");
					Scanner s17 = new Scanner(System.in);
					String str17 = s17.nextLine();
					String stt[] = str17.split(" ");
					td.changetea_age(Integer.parseInt(stt[0]), Integer.parseInt(stt[1]));
				}if(str16.equals("tea_dep"))
				{
					System.out.println("Please input the teacher_dep and tea_id you want to change");
					Scanner s17 = new Scanner(System.in);
					String str17 = s17.nextLine();
					String stt[] = str17.split(" ");
					td.changetea_dep(stt[0], Integer.parseInt(stt[1]));
				}if(str16.equals("tea_username"))
				{
					System.out.println("Please input the teacher_username and tea_id you want to change");
					Scanner s17 = new Scanner(System.in);
					String str17 = s17.nextLine();
					String stt[] = str17.split(" ");
					td.changetea_username(stt[0], Integer.parseInt(stt[1]));
				}if(str16.equals("tea_passwd"))
				{
					System.out.println("Please input the teacher_passwd and tea_id you want to change");
					Scanner s17 = new Scanner(System.in);
					String str17 = s17.nextLine();
					String stt[] = str17.split(" ");
					td.changetea_passwd(stt[0], Integer.parseInt(stt[1]));
				}if(str16.equals("tea_email"))
				{
					System.out.println("Please input the teacher_email and tea_id you want to change");
					Scanner s17 = new Scanner(System.in);
					String str17 = s17.nextLine();
					String stt[] = str17.split(" ");
					td.changetea_email(stt[0], Integer.parseInt(stt[1]));
				}if(str16.equals("tea_cardid"))
				{
					System.out.println("Please input the teacher_cardid and tea_id you want to change");
					Scanner s17 = new Scanner(System.in);
					String str17 = s17.nextLine();
					String stt[] = str17.split(" ");
					td.changetea_cardid(stt[0], Integer.parseInt(stt[1]));
				}if(str16.equals("tea_code"))
				{
					System.out.println("Please input the teacher_code and tea_id you want to change");
					Scanner s17 = new Scanner(System.in);
					String str17 = s17.nextLine();
					String stt[] = str17.split(" ");
					td.changetea_code(stt[0], Integer.parseInt(stt[1]));
				}if(str16.equals("tea_left_borrow"))
				{
					System.out.println("Please input the teacher_left_borrow and tea_id you want to change");
					Scanner s17 = new Scanner(System.in);
					String str17 = s17.nextLine();
					String stt[] = str17.split(" ");
					td.changetea_left_borrow(Integer.parseInt(stt[0]), Integer.parseInt(stt[1]));
				}if(str16.equals("tea_left_applicate"))
				{
					System.out.println("Please input the teacher_left_applicate and tea_id you want to change");
					Scanner s17 = new Scanner(System.in);
					String str17 = s17.nextLine();
					String stt[] = str17.split(" ");
					td.changetea_left_applicate(Integer.parseInt(stt[0]), Integer.parseInt(stt[1]));
				}
				break;
			case 5:
				tflag = 1;
				break;
			}
			if (tflag == 1)
			{
				break;
			}
		}
			break;
		case 12:
			fflag = 1;
			break;
		default:
			break;
		}
		if(fflag == 1)
			break;
		}
		}
}
