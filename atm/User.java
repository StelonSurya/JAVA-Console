package atm;

public class User {
	
   private String accountNumber;
   
   private String password;
  
   private int savingAccountBalance;
  
   private int checkingAccountBalance;
   
   private String upi;
   
   
   public User(String accNo,String pass) {
	   accountNumber=accNo;
	   password=pass;
	   savingAccountBalance=1000;
	   checkingAccountBalance=1000;
   }
public String getAccountNumber() {
	return accountNumber;
}

public void setAccountNumber(String accountNumber) {
	this.accountNumber = accountNumber;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public int getSavingAccountBalance() {
	return savingAccountBalance;
}

public void setSavingAccountBalance(int savingAccountBalance) {
	this.savingAccountBalance = savingAccountBalance;
}

public int getCheckingAccountBalance() {
	return checkingAccountBalance;
}

public void setCheckingAccountBalance(int checkingAccountBalance) {
	this.checkingAccountBalance = checkingAccountBalance;
}

public String getUpi() {
	return upi;
}

public void setUpi(String upi) {
	this.upi = upi;
}

}
