package atm;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operation { 
    List<Transaction> depositionDetails=new ArrayList<>();
	List<Transaction> withdrawlDetails=new ArrayList<>();
	List<Transaction> transactionDetails=new ArrayList<>();
	Scanner scanner=new Scanner(System.in);
	
	public void savingsWithdrawl(User obj) {
		
		System.out.println("Enter amount : ");
		int amount=scanner.nextInt();
		if(amount>obj.getSavingAccountBalance()) {
			System.out.println("In-sufficient Fund");
			return;
		}
		
		obj.setSavingAccountBalance(obj.getSavingAccountBalance()-amount);
		
		withdrawlDetails.add(new Transaction(obj.getAccountNumber(),amount));
		ATMmainMenu.atm.setAmount(ATMmainMenu.atm.getAmount()-amount);
		System.out.println("withdrawl successfully");
		
	}
	
	public void savingsDeposit(User obj) {
		System.out.println("Enter amount : ");
		int amount=scanner.nextInt();
		if(amount>50000) {
			System.out.println("Maximum Deposit Amount is 50000");
			return;
		}
		obj.setSavingAccountBalance(obj.getSavingAccountBalance()+amount);
		depositionDetails.add(new Transaction(obj.getAccountNumber(),amount));
		ATMmainMenu.atm.setAmount(ATMmainMenu.atm.getAmount()+amount);
		System.out.println("deposited successfull");
	}
	
	public void savingsTransfer(User obj) {
		System.out.println("Enter account Number which u want to Transfer : ");
		String id=scanner.next();
		System.out.println("enter password ");
		String passWord=scanner.next();
		if(!UserDetails.userCheck(id, passWord)) {
			System.out.println("invalid userID or passWord");
			return;
		}
		User reciever=new User(id,passWord);
		System.out.println("Enter amount : ");
		int amount=scanner.nextInt();
		obj.setSavingAccountBalance(obj.getSavingAccountBalance()-amount);
		reciever.setSavingAccountBalance(reciever.getSavingAccountBalance()+amount);
		transactionDetails.add(new Transaction(obj.getAccountNumber(),reciever.getAccountNumber(),amount));
		System.out.println("Transaction Successfull");
	}
	
	public void UPItransfer(User obj) {
		System.out.println("enter your UPI-ID");
		String upi=scanner.next();
		if(!upiValidation(upi)) {
			System.out.println("invalid upi");
			return;
		}
		if(!obj.getUpi().equals(upi)) {
			System.out.println("you haven't setup Your upi ");
			return;
		}
		
		System.out.println("Enter account Number which u want to Transfer : ");
		String id=scanner.next();
		System.out.println("enter password ");
		String passWord=scanner.next();
		if(!UserDetails.userCheck(id, passWord)) {
			System.out.println("invalid userID or passWord");
			return;
		}
		User reciever=new User(id,passWord);
		System.out.println("Enter amount : ");
		int amount=scanner.nextInt();
		obj.setCheckingAccountBalance(obj.getCheckingAccountBalance()-amount);
		reciever.setCheckingAccountBalance(reciever.getCheckingAccountBalance()+amount);
		transactionDetails.add(new Transaction(obj.getAccountNumber(),reciever.getAccountNumber(),amount));
		System.out.println("Transaction Successfull");
		
	}

	private boolean upiValidation(String upi) {
      String upi1= "^[0-9]{10}@ybl$";
		
		Pattern pattern = Pattern.compile(upi1);
		Matcher matcher = pattern.matcher(upi);
		
		
		return matcher.matches();
	}

	public void viewSavingsBalance(User obj) {
		System.out.println("your current savings account balance is : "+obj.getSavingAccountBalance());
	}

	public void checkingWithdrawl(User obj) {
		System.out.println("Enter amount : ");
		int amount=scanner.nextInt();
		if(amount>obj.getCheckingAccountBalance()) {
			System.out.println("In-sufficient Fund");
			return;
		}
		
		obj.setCheckingAccountBalance(obj.getCheckingAccountBalance()-amount);
		
		withdrawlDetails.add(new Transaction(obj.getAccountNumber(),amount));
		ATMmainMenu.atm.setAmount(ATMmainMenu.atm.getAmount()-amount);
		System.out.println("withdrawl success");
	}

	public void checkingDeposit(User obj) {
		System.out.println("Enter amount : ");
		int amount=scanner.nextInt();
		if(amount>50000) {
			System.out.println("Maximum Deposit Amount is 50000");
			return;
		}
		obj.setCheckingAccountBalance(obj.getCheckingAccountBalance()+amount);
		depositionDetails.add(new Transaction(obj.getAccountNumber(),amount));
		ATMmainMenu.atm.setAmount(ATMmainMenu.atm.getAmount()+amount);
		System.out.println("deposited successfull");
	}

	public void checkingTransfer(User obj) {
		System.out.println("Enter account Number which u want to Transfer : ");
		String id=scanner.next();
		System.out.println("enter password ");
		String passWord=scanner.next();
		if(!UserDetails.userCheck(id, passWord)) {
			System.out.println("invalid userID or passWord");
			return;
		}
		User reciever=new User(id,passWord);
		System.out.println("Enter amount : ");
		int amount=scanner.nextInt();
		obj.setCheckingAccountBalance(obj.getCheckingAccountBalance()-amount);
		reciever.setCheckingAccountBalance(reciever.getCheckingAccountBalance()+amount);
		transactionDetails.add(new Transaction(obj.getAccountNumber(),reciever.getAccountNumber(),amount));
		System.out.println("Transaction Successfull");
	}

	public void viewCheckingBalance(User obj) {
		
		System.out.println("your current savings account balance is : "+obj.getCheckingAccountBalance());
	}
}
