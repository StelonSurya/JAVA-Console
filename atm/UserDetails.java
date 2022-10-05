package atm;

import java.util.*;

public class UserDetails {
	

public List<User> details=new ArrayList<>();
  
    static public boolean userCheck(String id,String passWord) {
    	 if(id.equals("7339367515") && passWord.equals("jaisurya"))return true;
    	 else if(id.equals("7339367515") && passWord.equals("venkatesh"))return true;
    	 else if(id.equals("7339367515") && passWord.equals("vaithees"))return true;
    	 else if(id.equals("7339367515") && passWord.equals("subha"))return true;
    	 else if(id.equals("7339367515") && passWord.equals("nadimuthu"))return true;
    	 else if(id.equals("7339367515") && passWord.equals("maheswari"))return true;
    	 else if(id.equals("7339367515") && passWord.equals("bagavath"))return true;
    	 else if(id.equals("7339367515") && passWord.equals("saravanavel"))return true;
    	 else System.out.println("invalid USER ID or PASSWORD");
    	 return false;
     }
     
     public boolean adminCheck(String id,String passWord) {
    	 if(id.equals("7339367515") && passWord.equals("jaisurya"))return true;
    	 else System.out.println("invalid USER ID or PASSWORD");
    	 return false;
     }
     public User addUserDetails(String id, String passWord) {
    	 User object=new User(id,passWord);
    		details.add(object);
    	 return object ;
     }
     
    
   }
