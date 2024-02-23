package View;
import java.sql.SQLException;
import java.util.*;
import Controller.MentorController;
public class Student {
    String name;
    String reg_no;
    String dept;
    int p_level;
    String lang;
    String domain;
    String project;
    double mark_10;
    double mark_12;
    double cgpa;
    String batch;
    MentorController mc=new MentorController();
	public void insertStudent() throws SQLException {
		Scanner cs=new Scanner(System.in);
        System.out.println("ENTER NAME OF STUDENT"); 		
		 name=cs.nextLine();
		 System.out.println("ENTER REGISTER NO OF STUDENT"); 		
		 reg_no=cs.nextLine();
		System.out.println("ENTER DEPARTMENT");
		 dept=cs.nextLine();
		System.out.println("ENTER PORTAL LEVEL COMPLETION");
		p_level=cs.nextInt();
		cs.nextLine();
		System.out.println("ENTER THE LANGUAGE");
		lang=cs.nextLine();
		System.out.println("ENTER DOAMIN");
		domain=cs.nextLine();
		System.out.println("PROJECT COMPLETION(YES/NO)");
		project=cs.nextLine();
		System.out.println("ENTER 10TH PERCENTAGE");
		mark_10=cs.nextDouble();
		System.out.println("ENTER 12TH PERCENTAGE");
		mark_12=cs.nextDouble();
		System.out.println("ENTER CGPA");
		cgpa=cs.nextDouble();
		cs.nextLine();
		System.out.println("ENTER BATCH ");
		batch=cs.nextLine();
		if(mc.insertStudent(name,reg_no,dept,p_level,lang,domain,project,mark_10,mark_12,cgpa,batch)) {
			System.out.println("STUDENT INSERTED SUCCESSFULLY");
		}
		else {
			System.out.println("INSERTION FAILED");
		}
		cs.close();
	}
	public void updateBatch() throws SQLException {
		Scanner cs=new Scanner(System.in);
		System.out.println("ENTER REGISTER NO TO CHNAGE BATCH");
		reg_no=cs.nextLine();
		System.out.println("ENTER NEW BATCH");
		batch=cs.nextLine();
		if(mc.updateBatch(reg_no,batch))
			System.out.println("UPDATED NEW BATCH");
		else
			System.out.println("UPDATION FAILED");
		cs.close();
	}
	public void updateProject() throws SQLException {
		Scanner cs=new Scanner(System.in);
		System.out.println("ENTER REGISTER NO TO CHANGE PROJECT STATUS");
		reg_no=cs.nextLine();
		System.out.println("ENTER NEW STATUS");
	    String status=cs.nextLine();
		if(mc.updateProject(reg_no,status))
			System.out.println("UPDATED PROJECT STATUS");
		else
			System.out.println("UPDATION FAILED");
		cs.close();
	}
	public void updatePortal() throws SQLException {
		Scanner cs=new Scanner(System.in);
		System.out.println("ENTER REGISTER NO TO CHANGE PORTAL LEVEL");
		reg_no=cs.nextLine();
		System.out.println("ENTER NEW LEVEL");
		String level=cs.nextLine();
		if(mc.updatePortal(reg_no,level))
			System.out.println("UPDATED NEW PORTAL LEVEL");
		else
			System.out.println("UPDATION FAILED");
		cs.close();
	}
	public void deleteStudent() throws SQLException {
		Scanner cs=new Scanner(System.in);
		System.out.println("ENTER STUDENT REGITER NUMBER TO DELETE");
		reg_no=cs.nextLine();
		if(mc.deleteStudent(reg_no)) {
			System.out.println("DELETED STUDENT SUCESSFULLY");
		}
		else {
			System.out.println("DELETION FAILED");
			
		}
		cs.close();
	}
	public void displayAll(String placed) throws SQLException {
		Scanner cs=new Scanner(System.in);
		ArrayList<String> students=mc.displayAll(placed);
		 System.out.println("+-----------------+------------------------+------------------+----------------+----------------+----------------------+---------------+");
	        System.out.println("|  Name           | REGISTER_NO            | DEPARTMENT       | PORTAL_LEVEL   | LANGUAGE       | DOMAIN               | BATCH         |");
	        System.out.println("+-----------------+------------------------+------------------+----------------+----------------+----------------------+---------------+");
		    for(String i:students) {
		    	String s1[]=i.split("@");
		    	
		    	 System.out.printf("| %-14s  |%-22s  |%-16s  |%-14s  |%-14s  |%-20s  |%-13s  |%n",s1[0],s1[1],s1[2],s1[3],s1[4],s1[5],s1[6] );
		    	//System.out.println(i.get(0));
		    System.out.println("+-----------------+------------------------+------------------+----------------+----------------+----------------------+---------------+");
		    }  
		    //cs.close();
}
   
}
