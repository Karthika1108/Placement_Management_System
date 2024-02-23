package View;
import java.sql.SQLException;
import java.util.*;
import Controller.AdminController;
public class Company {
	AdminController ac=new AdminController();
	 private String name;
	 private double mark_10;
	 private double mark_12;
	 private String lang;
	 private String domain;
	 private double cgpa;
	 private double pack;
	 private String dateFixed;
	 private String location;
	 private String mode;
	private void addCompany() throws SQLException {
		Scanner cs=new Scanner(System.in);
		System.out.println("ENTER NAME:");
		name=cs.nextLine();
		System.out.println("ENTER 10TH PERCENTAGE");
		mark_10=cs.nextDouble();
		System.out.println("ENTER 12TH PERCENTAGE");
		mark_12=cs.nextDouble();
		cs.nextLine();
		System.out.println("ENTER PREFERRED LANGUAGES");
		lang=cs.nextLine();
		System.out.println("ENTER DOMAIN");
		domain=cs.nextLine();
		System.out.println("ENTER CGPA");
		cgpa=cs.nextDouble();
		System.out.println("ENTER THE PACKAGE");
		pack=cs.nextDouble();
		cs.nextLine();
		System.out.println("ENTER DATE OF DRIVE");
		dateFixed=cs.nextLine();
		System.out.println("ENTER THE LOCATION OF COMPANY");
		location=cs.nextLine();
		System.out.println("ENTER THE MODE OF INTERVIEW");
		mode=cs.nextLine();
		if(ac.addCompany(name,mark_10,mark_12,lang,domain,cgpa,pack,dateFixed,location,mode)) {
			System.out.println("COMPANY DETAILS Added");
		}
		else {
			System.out.println("INSERTION FAILED");
		}
		//cs.close();
	}
	private void updateCompany() throws SQLException {
		Scanner cs=new Scanner(System.in);
		System.out.println("ENTER NAME OF COMPANY");
	     String name=cs.nextLine();
	     System.out.println("ENTER THE UPDATED DRIVE DATE");
	     String date=cs.nextLine();
	     if(ac.updateCompany(name, date)) {
	    	 System.out.println("UPDATED SUCESSFULLY");
	     }
	     else {
	    	 System.out.println("UPDATION FAILED");
	     }
	     cs.close();
	}
    private void deleteCompany() throws SQLException {
		Scanner cs=new Scanner(System.in);
		System.out.println("ENTER NAME OF COMPANY TO DELETE");
		name=cs.nextLine();
		if(ac.deleteCompany(name)) {
			System.out.println("DELETED COMPANY SUCESSFULLY");
		}
		else {
			System.out.println("DELETION FAILED");
		}
		//cs.close();
	}
    public void getDeleteCompany() throws SQLException {
		deleteCompany();
	}
	public void getUpdateCompany() throws SQLException {
		updateCompany();
	}
	public void getAddCompany() throws SQLException {
		addCompany();
	}
	
	public static void main(String[] args) {
		
		
	}
}
