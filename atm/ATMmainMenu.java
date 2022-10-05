package atm;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ATMmainMenu {
	UserDetails object=new UserDetails();
	Operation operation=new Operation();
	static ATM atm = new ATM();
    Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) {
		ATMmainMenu object1=new ATMmainMenu();
		object1.start();
	}

	private void start() {
		boolean boo=true;
		while(boo) {
			System.out.println(" 1.User \n 2.Admin \n 3.exit");
			int choice=scanner.nextInt();
			switch (choice) {
			case 1:{
				System.out.println("enter userID");
				String id=scanner.next();
				System.out.println("PassWord");
				String passWord=scanner.next();
				if(object.userCheck(id,passWord)) {
					System.out.println("Welcome "+ passWord);
					User obj=object.addUserDetails(id,passWord);
					userOptions(obj);
				}
				else {
					System.out.println("invalid id or passWord");
					start();
				}
			}break;
			case 2:{
				System.out.println("enter userID");
				String id=scanner.next();
				System.out.println("PassWord");
				String passWord=scanner.next();
				if(object.adminCheck(id,passWord)) {
					System.out.println("Welcome "+ passWord);
					User obj=object.addUserDetails(id,passWord);
					adminOption(obj);
				}
				else {
					System.out.println("invalid id or passWord");
					start();
				}
			}break;
			case 3:{boo=false;
			System.out.println("Thank You");}break;
			default :System.out.println("Enter Correct Input");
			}
		}
	}

	private void adminOption(User obj) {
		boolean boo=true;
		while(boo) {
			System.out.println(" 1.print transaction details \n 2.print ATM status \n 3.Exit");
			int choice=scanner.nextInt();
			switch(choice) {
			case 1:{
				System.out.println("Deposition Details");
				print(operation.depositionDetails);
				System.out.println("Withdrawl Details");
				print(operation.withdrawlDetails);
				System.out.println("Transaction Details");
				printTransaction(operation.transactionDetails);
			}break;
			case 2:{
				System.out.println("------------- ATM status -------------");
				System.out.println("Available Amount in Atm  : "+atm.getAmount());
			}break;
			case 3:{
				boo=false;
			}break;
			default :System.out.println("Invalid Input ");
			}
		}
	}

	
	

	private void userOptions(User obj) {
		boolean boo =true;
		while(boo) {
			System.out.println(" 1.Saving Account \n 2.Checking Account \n 3.set UPI \n 4.Exit");
			int choice=scanner.nextInt();
			switch(choice) {
			case 1:{
				savingsAccountOptions(obj);
			}break;
			case 2:{
				checingAccountOptions(obj);
			}break;
			case 3:{
				System.out.println("Enter mobile number");
				String mobileNo=scanner.next();
				while(!mobileNumberValidation(mobileNo)) {
					System.out.println("Invalid Mobile Number");
					System.out.println("Enter Valid mobile number");
					mobileNo=scanner.next();
				}
				String upi=mobileNo+"@ybl";
				obj.setUpi(upi);
				System.out.println("UPI setup successfull");
				System.out.println("Your UPI ID is : "+obj.getUpi());
				
			}break;
            case 4:{
				boo=false;
			}break;
			default:System.out.println("Invalid Input");
			}
		}
	}
	
	private void savingsAccountOptions(User obj) {
		boolean boo =true;
		while(boo) {
			System.out.println(" 1.Withdraw \n 2.Deposit \n 3.Money Transfer \n 4.Cardless Transaction \n 5.Balance Enquiry \n 6.Exit");
			int choice=scanner.nextInt();
			switch(choice) {
			case 1:{
				operation.savingsWithdrawl(obj);
			}break;
			case 2:{
				operation.savingsDeposit(obj);
			}break;
			case 3:{
				operation.savingsTransfer(obj);
			}break;
            case 4:{
				operation.UPItransfer(obj);
			}break;
            case 5:{
	            operation.viewSavingsBalance(obj);
            }break;
            case 6:{
            	boo=false;
            }break;
			default:System.out.println("Invalid Input");
			}
		}
	}
	private void checingAccountOptions(User obj) {
		boolean boo =true;
		while(boo) {
			System.out.println(" 1.Withdraw \n 2.Deposit \n 3.Money Transfer \n 4.Cardless Transaction \n 5.Balance Enquiry \n 6.Exit");
			int choice=scanner.nextInt();
			switch(choice) {
			case 1:{
				operation.checkingWithdrawl(obj);
			}break;
			case 2:{
				operation.checkingDeposit(obj);
			}break;
			case 3:{
				operation.checkingTransfer(obj);
			}break;
            case 4:{
				operation.UPItransfer(obj);
			}break;
            case 5:{
	            operation.viewCheckingBalance(obj);
            }break;
            case 6:{
            	boo=false;
            }break;
			default:System.out.println("Invalid Input");
			}
		}
	}

	private static boolean mobileNumberValidation(String visterDetail) {
		String mobileNumber = "^[6-9][0-9]{9}$";
		
		Pattern pattern = Pattern.compile(mobileNumber);
		Matcher matcher = pattern.matcher(visterDetail);
		
		
		return matcher.matches();
		
	}
	private void print(List<Transaction> depositionDetails) {
		System.out.println("--------------------------------------------------");
		System.out.printf("%-25s %-6s","Account number","amount");
		System.out.println();
		System.out.println("--------------------------------------------------");
		for(Transaction t:depositionDetails) {
			System.out.printf("%-25s %-6s",t.user,t.amount);
			System.out.println();
		}
		System.out.println("-------------------------------------------------- \n \n");
	}

	private void printTransaction(List<Transaction> transactionDetails) {
		System.out.println("--------------------------------------------------");
		System.out.printf("%-15s %-15s %-6s","From Acc.no","To Acc.no","amount");
		System.out.println();
		System.out.println("--------------------------------------------------");
		for(Transaction t:transactionDetails) {
			System.out.printf("%-15s %-15s %-6s",t.user,t.getter,t.amount);
			System.out.println();
		}
		System.out.println("-------------------------------------------------- \n \n");
	}
}
