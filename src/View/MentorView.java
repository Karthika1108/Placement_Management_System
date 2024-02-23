package View;
import java.sql.SQLException;
import java.util.*;
import Controller.MentorController;
public class MentorView {
	   private String email;
	   private String password;
	   public void checkMentor() throws SQLException {
		    Scanner cs=new Scanner(System.in);
	        System.out.println("ENTER EMAIL");
	        email=cs.nextLine();
	        System.out.println("ENTER PASSWORD");
	        password=cs.nextLine();
	        MentorController mc=new MentorController();
	        if(mc.loginMentor(email,password)) {
	        	mentorOperation();
	        }
	        else 
	        	System.out.println("ERROR");
	        //cs.close();
	   }
	        private void mentorOperation() throws SQLException {
	        	Scanner cs=new Scanner(System.in);
	        	Student s=new Student();
	        	MentorController mc=new MentorController();
	        	System.out.println("------MENTOR OPERATION------");
	        	
	        	int option=1;
	        	while(option!=4) {
	        	System.out.println("1--->MANAGE STUDENT\n2--->DISPLAY STUDENTS\n3--->CHANGE USER PASSWORD\n4--->EXIT");
	        	option=cs.nextInt();
	        	cs.nextLine();
	        	switch(option) {
	        	case 1:{
	        		option =1;
	        		while(option!=4) {
	        			System.out.println("1--->ADD STUDENT\n2---->UPDATE STUDENTS\n3---->DELETE STUDENTS\n4--->EXIT");
	        			option=cs.nextInt();
	        			switch(option) {
	        			   case 1:{ 
	        				  s.insertStudent();
	        				  break;
	        			   }
	        			   case 2:{
	        				   option=1;
	        				   while(option!=4) {
	        					   System.out.println("1--->UPDATE BATCH\n2--->UPDATE PORTAL LEVEL COMPLETION\n3--->UPDATE PROJECT STATUS\n4--->EXIT");
	        					   option=cs.nextInt();
	        					   switch(option) {
	        					   case 1:{
	        					
	        						    s.updateBatch();
	        						    break;
	        					     }
	        					   case 2:{
	        						   s.updatePortal();
	        						   break;
	        					   }
	        					   case 3:{
	        						   s.updateProject();
	        						   break;
	        					   }
	        					   case 4:{
	        						   break;
	        						  // System.exit(option);
	        					   }
	        					   default:{
	        						   System.out.println("ENTER VALID OPTION");
	        						   break;
	        					      }
	        					   }
	        				   }
	        				  
	        			   }
	        			   case 3:{
		        				s.deleteStudent();
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
	        		displayMentorRole();
	        	}
	        	case 3:{
	        		System.out.println("ENTER EMAIL TO CHANGE PASSWORD");
	        		 email=cs.nextLine();
	        		 System.out.println("ENTER NEW PASSWORD");
	        		 password=cs.nextLine();
	        		 if(mc.changePassword(email, password)) 
	        			 System.out.println("PASSWORD CHANGED SUCESSFULLY");
	        		 else
	        			 System.out.println("PASSWORD FAILED TO CHANGE");
	        		 break;
	        	}
	        	case 4:{
	        		break;
	        	}
	        	default:{
	        		System.out.println("ENTER VALID OPTION");
	        		break;
	        	}
	        	
	        }}
	        	//cs.close();
	        }
	        public void displayMentorRole() throws SQLException {
	        	Scanner cs=new Scanner(System.in);
	        	 MentorController mc=new MentorController();
	        	 Student s=new Student();
        		int option=1;
        		while(option!=8) {
        			System.out.println("1--->DISPLAY ALL PLACED STUDENTS\n2--->DISPLAY ALL NON PLACED STUDENTS\n3--->DISPLAY BY LANGUAGE\n4--->DISPLAY BY DOMAIN\n5--->DISPLAY BY LEVEL COMPLETION\n6--->DISPLAY BY PROJECT COMPLETION \n7--->DISPLAY BY CGPA\n8--->EXIT");
        			option=cs.nextInt();
        			cs.nextLine();
        			switch(option) {
        			case 1:{
        				String placed="= 1";
        				s.displayAll(placed);
        				 break;
        			  }
        			case 2:{
        				String placed="IS NULL";
        				s.displayAll(placed);
        				break;
        			}
        			case 3:{
        				String cat="S_LANGUAGE";
        				System.out.println("ENTER THE VALUE");
        				String val=cs.nextLine();
        				ArrayList<String> student=mc.display(cat,val);
        				 System.out.println("+-----------------+------------------------+------------------+----------------+----------------+----------------------+---------------+");
					        System.out.println("|  Name           | REGISTER_NO            | DEPARTMENT       | PORTAL_LEVEL   | LANGUAGE       | DOMAIN               | BATCH         |");
					        System.out.println("+-----------------+------------------------+------------------+----------------+----------------+----------------------+---------------+");
						    for(String i:student) {
						    	String s1[]=i.split("@");
						    	
						    	 System.out.printf("| %-14s  |%-22s  |%-16s  |%-14s  |%-14s  |%-20s  |%-13s  |%n",s1[0],s1[1],s1[2],s1[3],s1[4],s1[5],s1[6] );
						    	//System.out.println(i.get(0));
						    System.out.println("+-----------------+------------------------+------------------+----------------+----------------+----------------------+---------------+");
						    }      
     		    	break;
     			}
        			case 4:{
        				String cat="S_DOMAIN";
        				System.out.println("ENTER THE VALUE");
        				String val=cs.nextLine();
        				ArrayList<String> student=mc.display(cat,val);
        				 System.out.println("+-----------------+------------------------+------------------+----------------+----------------+----------------------+---------------+");
					        System.out.println("|  Name           | REGISTER_NO            | DEPARTMENT       | PORTAL_LEVEL   | LANGUAGE       | DOMAIN               | BATCH         |");
					        System.out.println("+-----------------+------------------------+------------------+----------------+----------------+----------------------+---------------+");
						    for(String i:student) {
						    	String s1[]=i.split("@");
						    	
						    	 System.out.printf("| %-14s  |%-22s  |%-16s  |%-14s  |%-14s  |%-20s  |%-13s  |%n",s1[0],s1[1],s1[2],s1[3],s1[4],s1[5],s1[6] );
						    	//System.out.println(i.get(0));
						    System.out.println("+-----------------+------------------------+------------------+----------------+----------------+----------------------+---------------+");
						    }      
        		    	break;
        			}
        			case 5:{
        				String cat="S_PLEVEL";
        				System.out.println("ENTER THE GREATER THEN VALUE");
        				String val=cs.nextLine();
        				ArrayList<String> student=mc.displayRange(cat,val);
        				System.out.println("+-----------------+------------------------+------------------+----------------+----------------+----------------------+---------------+");
				        System.out.println("|  Name           | REGISTER_NO            | DEPARTMENT       | PORTAL_LEVEL   | LANGUAGE       | DOMAIN               | BATCH         |");
				        System.out.println("+-----------------+------------------------+------------------+----------------+----------------+----------------------+---------------+");
					    for(String i:student) {
					    	String s1[]=i.split("@");
					    	
					    	 System.out.printf("| %-14s  |%-22s  |%-16s  |%-14s  |%-14s  |%-20s  |%-13s  |%n",s1[0],s1[1],s1[2],s1[3],s1[4],s1[5],s1[6] );
					    	//System.out.println(i.get(0));
					    System.out.println("+-----------------+------------------------+------------------+----------------+----------------+----------------------+---------------+");
					    }      
    		    	break;
    			}
        			case 6:{
        				String cat="S_PROJECT";
        				System.out.println("ENTER THE VALUE");
        				String val=cs.nextLine();
        				ArrayList<String> student=mc.display(cat,val);
        				System.out.println("+-----------------+------------------------+------------------+----------------+----------------+----------------------+---------------+");
				        System.out.println("|  Name           | REGISTER_NO            | DEPARTMENT       | PORTAL_LEVEL   | LANGUAGE       | DOMAIN               | BATCH         |");
				        System.out.println("+-----------------+------------------------+------------------+----------------+----------------+----------------------+---------------+");
					    for(String i:student) {
					    	String s1[]=i.split("@");
					    	
					    	 System.out.printf("| %-14s  |%-22s  |%-16s  |%-14s  |%-14s  |%-20s  |%-13s  |%n",s1[0],s1[1],s1[2],s1[3],s1[4],s1[5],s1[6] );
					    	//System.out.println(i.get(0));
					    System.out.println("+-----------------+------------------------+------------------+----------------+----------------+----------------------+---------------+");
					    }      
    		    	break;
    			}
        			case 7:{
        				String cat="S_CGPA";
        				System.out.println("ENTER THE GREATER THAN VALUE");
        				String val=cs.nextLine();
        				ArrayList<String> student=mc.displayRange(cat,val);
        				System.out.println("+-----------------+------------------------+------------------+----------------+----------------+----------------------+---------------+");
				        System.out.println("|  Name           | REGISTER_NO            | DEPARTMENT       | PORTAL_LEVEL   | LANGUAGE       | DOMAIN               | BATCH         |");
				        System.out.println("+-----------------+------------------------+------------------+----------------+----------------+----------------------+---------------+");
					    for(String i:student) {
					    	String s1[]=i.split("@");
					    	
					    	 System.out.printf("| %-14s  |%-22s  |%-16s  |%-14s  |%-14s  |%-20s  |%-13s  |%n",s1[0],s1[1],s1[2],s1[3],s1[4],s1[5],s1[6] );
					    	//System.out.println(i.get(0));
					    System.out.println("+-----------------+------------------------+------------------+----------------+----------------+----------------------+---------------+");
					    }      
    		    	break;
    			}
        			
        			case 8:{
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
        
        	
        	
		public  void getMentorOperation() throws SQLException {
	    	    mentorOperation();
	       }

	       
	   }

