package View;
import java.sql.SQLException;
import java.util.*;
import Controller.AdminController;
public class placement {
	private String reg_no;
	private String c_name;
	private String c_package;
	private String c_date;
     public void setPlacement() throws SQLException {
    	 AdminController ac=new AdminController();
    	 Scanner cs=new Scanner(System.in);
    	 int option=1;
    	 while(option!=3) {
    	 System.out.println("1--->ADD PLACED STUDENTS\n2--->UPDATE PACKAGE\n3--->EXIT");
    	 option=cs.nextInt();
    	 cs.nextLine();
    	 switch(option) {
    	 case 1:{
    		 System.out.println("ENTER THE STUDENT REGISTER NUMBER");
    		 setReg_no(cs.nextLine());
    		 System.out.println("ENTER THE COMPANY NAME");
    		 setC_name(cs.nextLine());
    		 System.out.println("ENTER THE COMPANY PACKAGE");
    		 setC_package(cs.nextLine());
    		 System.out.println("ENTER THE YEAR");
    		 setC_date(cs.nextLine());
    		 ac.setPlaced(getReg_no(),getC_name(),getC_package(),getC_date());
    		 break;
    	 }
    	 case 2:{
    		 System.out.println("ENTER REGISTER NUMBER");
    		 reg_no=cs.nextLine();
    		 System.out.println("ENTER NEW PACKAGE");
    		 c_package=cs.nextLine();
    		if( ac.updatePackage(reg_no,c_package))
    		    System.out.println("UPDATED SUCCESSFULLY");
    		else
    			System.out.println("UPDATION FAILED");
    		 break;
    	 }
    	 case 3:{
    		       break;
    	        }
    	 default:{
    		 System.out.println("ENTER VALID OPTION");
    		 break;
    	 }
    	    }
    	 }
    	 //cs.close();
     }
	public String getReg_no() {
		return reg_no;
	}
	public void setReg_no(String reg_no) {
		this.reg_no = reg_no;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_package() {
		return c_package;
	}
	public void setC_package(String c_package) {
		this.c_package = c_package;
	}
	public String getC_date() {
		return c_date;
	}
	public void setC_date(String c_date) {
		this.c_date = c_date;
	}
	
}
