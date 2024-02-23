package View;
import java.sql.SQLException;


import java.util.*;
import Controller.AdminController;
public class AdminView extends MentorView {
	private String email;
	private String password;
	AdminController ad = new AdminController();
	public  void checkAdmin() throws SQLException {
		Scanner cs=new Scanner(System.in);
		
		System.out.println("ENTER EMAIL");
		email=cs.nextLine();
		System.out.println();
		System.out.println("ENTER PASSWORD");
		password=cs.nextLine();
		System.out.println();
		AdminController ad = new AdminController();
		if(ad.checkLogin(email,password)) {
			dashboard();
		}
		else {
			System.out.println("\n------YOU,ARE NOT AN ADMIN------\n");
			
		}
		//cs.close();
	}
	public void dashboard() throws SQLException {
	   Scanner cs=new Scanner(System.in);
	   System.out.printf("               +---------------DASHBOARD----------------+%n%n");
	   System.out.printf("                TOTAL NUMBER OF STUDENTS            = %d%n", ad.countStud());
	   System.out.printf("                TOTAL NUMBER OF PLACED STUDENTS     = %d%n", ad.countPlaced());
	   System.out.printf("                TOTAL NUMBER OF NON PLACED STUDENTS = %d%n", ad.countNon());
	   System.out.printf("                TOTAL NUMBER OF COMPANIES           = %d%n", ad.countCompany());
	   System.out.printf("                TOTAL NUMBER OF MENTORS             = %d%n%n", ad.countMentor());
	   System.out.printf("               +-----------------------------------------+%n%n");
	  int option=0;
	   while( option!=2) {
		   System.out.println("ENTER 1 TO CONTINUE AND 2 TO EXIT");
		    option=cs.nextInt();
	        switch(option) {
	        case 1:{
	        	Operation();
	        	break;
	          }
	        case 2:{
	        	break;
	        }
	        default:{
	        	System.out.println("ENTER VALID OPTION");
	          }
	        }
	   }
	}
	   public  void Operation() throws SQLException {
		   Scanner cs=new Scanner(System.in);
		  
		   int option=1;
		   while(option!=3) {
	       System.out.println("-------------------------------------------------------");
		   System.out.println("1--->MENTOR OPERATION\n2--->ADMIN OPERATION\n3--->EXIT");
		   System.out.println("-------------------------------------------------------");
		   option=cs.nextInt();
		  
		   switch(option) {
		   case 1:{
			   super.getMentorOperation();
			   break;
		    }
		   case 2:{
			   adminOperation();
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

		   public void adminOperation() throws SQLException {
			   Scanner cs=new Scanner(System.in);
			   
			   
		   System.out.println("---------ADMIN OPERATION---------");
			int option=1;
			while(option!=6) {
		    System.out.println("------------------------------------------");
			System.out.println("1--->MANAGE MENTORS\n2--->MANAGE COMPANY\n3--->DISPLAY\n4--->CHANGE USER PASSWORD\n5--->MANAGE PLACED STUDENT\n6--->EXIT");
			System.out.println("------------------------------------------");
			option=cs.nextInt();
			cs.nextLine();
			switch(option) {
			case 1:{
			int	option1=1;
				while(option1!=4) {
					System.out.println("-----------------------------------------");
					System.out.println("\n1--->ADD MENTOR\n2--->UPDATE MENTOR BATCH\n3--->DELETE MENTOR\n4--->EXIT");
					System.out.println("-----------------------------------------");
					
					option1=cs.nextInt();
					cs.nextLine();
					switch(option1) {
					case 1:{
						System.out.println("ENTER MENTOR EMAIL");
						String mail=cs.nextLine();
						System.out.println("ENTER MENTOR USERNAME");
						String username=cs.nextLine();
						System.out.println("ENTER PASSWORD");
						String pwd=cs.nextLine();
						System.out.println("ENTER MENTOR BATCH");
						String batch=cs.nextLine();
						if(ad.addMentor(mail,username,pwd,batch))
							System.out.println("MENTOR ADDED SUCCESSFULLY");
						else
							System.out.println("NOT ADDED");
						break;
					  }
					case 2:{
						System.out.println("ENTER MENTOR EMAIL TO CHANGE BATCH");
						 email=cs.nextLine();
						System.out.println("ENTER NEW BATCH");
						String batch=cs.nextLine();
						if(ad.changeBatch(email,batch))
							System.out.println("UPDATED SUCCESSFULLY");
						else
							System.out.println("UPDATION FAILED");
						break;
					}
					case 3:{
						System.out.println("ENTER MENTOR EMAIL TO DELETE");
						 email=cs.nextLine();
						 if(ad.removeMentor(email)) 
							 System.out.println("DELETED SUCESSFULLY");
						 else
							 System.out.println("DELETION FAILED");
						 break;
					  }
					case 4:{
						break;
					   }
					default:{
						System.out.println("ENTER VALID OPTION");
						break;
					   }
					}
				}
				break;
			   }
			case 2:{
				  int option2=1;
				   while(option2!=4) {
					   System.out.println("----------------------------------------");
					   System.out.println("1--->ADD COMPANY\n2--->UPDATE COMPANY\n3--->DELETE COMPANY\n4--->EXIT");
					   System.out.println("----------------------------------------");
						
					   Company c=new Company();
					   option2 =cs.nextInt();
					   switch(option2) {
					   case 1:{
						      c.getAddCompany();
						      break;
					      }
					   case 2:{
						   int option3=1;
						   while(option3!=2) {
						   System.out.println("------------------------------------------");
						   System.out.println("1--->UPDATE COMPANY DRIVE DATE\n2--->EXIT ");
						   System.out.println("------------------------------------------");
						   option3=cs.nextInt();
						   cs.nextLine();
						   switch(option3) {
						   case 1:{
							   c.getUpdateCompany();
							   break;
						       }
						   case 2:{
							   break;
						   }
						   default:{
							   System.out.println("ENTER VALID OPTION");
							   break;
						   }
						     }
						   }
						   break;
					   }
					   case 3:{
						   c.getDeleteCompany();
						   break;
					     }
					   case 4:{
						   break;
					   }
					   default:{
						   System.out.println("ENTER VALID OPTION");
						   break;
					   }
					   }
				   }
				   break;
			   }
			case 3:{
				int option4=1;
				while(option4!=4) {
					System.out.println("1--->VIEW STUDENTS DETAILS\n2--->VIEW STUDENT DETAILS BY COMPARING COMPANY DETAILS\n3--->DISPLAY PLACED STUDENTS DETAILS\n4--->EXIT");
					option4=cs.nextInt();
					cs.nextLine();
					switch(option4) {
					case 1:{
						super.displayMentorRole();
						break;
					}
					case 2:{
						System.out.println("ENTER COMPANY NAME TO SORTLIST STUDENT");
						String Cname=cs.nextLine();
								String Ccat="C_DOMAIN";
								String Scat="S_DOMAIN";
								String Clang="C_LANG";
								String Slang="S_LANGUAGE";
								String Ccgpa="C_CGPA";
								String Scgpa="S_CGPA";
								String Smark10="S_MARK10";
								String Cmark10="C_MARK10";
								String Smark12="S_MARK12";
								String Cmark12="C_MARK12";
								String Splace;
								System.out.println("INCLUDE PLACED STUDENDS(Y/N)");
								String include=cs.next();
								if(include.equalsIgnoreCase("y"))
									Splace="1";
								else
									Splace="NULL";
							    ArrayList<String> match=ad.display(Ccat,Scat,Clang,Slang,Ccgpa,Scgpa,Cmark10,Smark10,Cmark12,Smark12,Splace,Cname);
							   // System.out.println(match);
							    
							    System.out.println("+-----------------+------------------------+------------------+----------------+----------------+----------------------+---------------+");
						        System.out.println("|  Name           | REGISTER_NO            | DEPARTMENT       | PORTAL_LEVEL   | LANGUAGE       | DOMAIN               | BATCH         |");
						        System.out.println("+-----------------+------------------------+------------------+----------------+----------------+----------------------+---------------+");
							    for(String i:match) {
							    	String s[]=i.split("@");
							    	
							    	 System.out.printf("| %-14s  |%-22s  |%-16s  |%-14s  |%-14s  |%-20s  |%-13s  |%n",s[0],s[1],s[2],s[3],s[4],s[5],s[6] );
							    	//System.out.println(i.get(0));
							    System.out.println("+-----------------+------------------------+------------------+----------------+----------------+----------------------+---------------+");
								      
							    }
							   break;
				            }
					case 3:{
						ArrayList<String> match=ad.displayRange();
						    System.out.println("+-----------------+------------------------+------------------+----------------+----------------+----------------------+---------------+-----------------+--------------+");
					        System.out.println("|  Name           | REGISTER_NO            | DEPARTMENT       | PORTAL_LEVEL   | LANGUAGE       | DOMAIN               | BATCH         |COMPANY NAME      |PACKAGE       |");
					        System.out.println("+-----------------+------------------------+------------------+----------------+----------------+----------------------+---------------+-----------------+--------------+");
						    for(String i:match) {
						    	String s[]=i.split("@");
						    	
						    	 System.out.printf("| %-14s  |%-22s  |%-16s  |%-14s  |%-14s  |%-20s  |%-13s  |%-15s  |%-13s |%n",s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8] );
						    	//System.out.println(i.get(0));
						    System.out.println("+-----------------+------------------------+------------------+----------------+----------------+----------------------+---------------+-----------------+--------------+");
							      
						    }
					   break;
					}
					case 4:{
						break;
					}
			         default:{
			    	System.out.println("ENTER VALID OPTION");
			    	break;
			        }
					}
				}
				break;
			}
			case 4:{
				System.out.println("ENTER ADMIN EMAIL TO CHANGE PASSWORD");
				email=cs.nextLine();
				System.out.println("ENTER THE NEW PASSWORD");
				password=cs.nextLine();
				if(ad.getChangePassword(email,password)) {
					System.out.println("PASSWORD UPDATED");
				}
				else {
					System.out.println("UPDATION FAILED");
				}
				break;
			}
			case 5:{
				placement p=new placement();
				p.setPlacement();
				break;
			}
			case 6:{
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
}