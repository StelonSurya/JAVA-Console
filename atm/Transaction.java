package atm;

public class Transaction {
   public String user;
   public String getter;
   public int  amount; 
   public String userUPI;
   public String getterUPI;
   
   public Transaction(String id,int cash) {
	   user=id;
	   amount=cash;
   }
   public Transaction(String id1,String id2,int cash) {
	   user=id1;
	   getter=id2;
	   amount=cash;
   }
}
