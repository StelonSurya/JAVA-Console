package dining;

import java.util.*;

public class MenuCard {
	Scanner scanner=new Scanner(System.in);
   
    Map<String, Integer> orderedFood=new LinkedHashMap<>();
	Map<String, Integer> vegGravy;
	Map<String, Integer> vegStarters;
	Map<String, Integer> IndianBreads;
	Map<String, Integer> NonVeg;
	Map<String, Integer> NonVegGravy;
	Map<String, Integer> NonVegStarters;
	Map<String, Integer> MilkShakes;

	private void addFoodDetails() {
		vegGravy = new LinkedHashMap<>();
		vegGravy.put("PanneerTikkaMasala", 270);
		vegGravy.put("PanneerButterMasala", 250);
		vegGravy.put("GobiManchurian", 200);
		vegGravy.put("MushroomPepperMasala", 300);
		vegGravy.put("PanneerKadaiGravy", 300);
		vegStarters = new LinkedHashMap<>();
		vegStarters.put("Panneer65", 270);
		vegStarters.put("CornMasala", 50);
		vegStarters.put("PotatoFry", 200);
		vegStarters.put("Gobi65", 300);
		vegStarters.put("PotatoSmiley", 75);
		IndianBreads = new LinkedHashMap<>();
		IndianBreads.put("PlainNaan", 75);
		IndianBreads.put("ButterNaan", 85);
		IndianBreads.put("GarlicNaan", 95);
		IndianBreads.put("Chapathi", 70);
		IndianBreads.put("Parotta", 80);
		NonVeg = new LinkedHashMap<>();
		NonVeg.put("ChickenBriyani", 200);
		NonVeg.put("MuttonBriyani", 250);
		NonVeg.put("PrawnBriyani", 225);
		NonVeg.put("ChickenFriedRice", 230);
		NonVeg.put("ChickenNoodles", 225);
		NonVegGravy = new LinkedHashMap<>();
		NonVegGravy.put("ChickenbutterMasala", 250);
		NonVegGravy.put("ChickenTikkaMasala", 350);
		NonVegGravy.put("MuttonChukka", 350);
		NonVegGravy.put("PrawnMasala", 325);
		NonVegGravy.put("CrabMasala", 300);
		NonVegStarters = new LinkedHashMap<>();
		NonVegStarters.put("FishFry", 150);
		NonVegStarters.put("Chicken65", 175);
		NonVegStarters.put("FishFry", 150);
		NonVegStarters.put("CrabLollipop", 250);
		NonVegStarters.put("DragonChicken", 150);
		MilkShakes = new LinkedHashMap<>();
		MilkShakes.put("KitkatMilkshake", 100);
		MilkShakes.put("StrawberryMilkshake", 120);
		MilkShakes.put("OreoMilkshake", 110);
		MilkShakes.put("BlackCurrantMilkshake", 130);
		MilkShakes.put("BananaMilkshake", 100);
	}

	void showMenu() {
		addFoodDetails() ;
		boolean vegOrNon = true;
		while (vegOrNon) {
			System.out.println(" 1.VEG \n 2.NON-VEG \n 3.SHOW BILL \n 4.ENOUGH/EXIT \n \n");
			int food = scanner.nextInt();
			switch (food) {
			case 1: {
				showVegMenu();
				
			}
				break;
			case 2: {
				showNonVegMenu();
			}
				break;
			case 3: {
				int totalAmount=printBill(orderedFood);
				if(totalAmount==0)System.out.println("YOU HAVE NOT ORDERED ANYTHING  \n \n \n");
				else {
					System.out.println("---------------------------------------");
					System.out.println("TOTAL  AMOUNT  FOR  FOOD        " +   totalAmount );
					System.out.println("GST   AND  OTHER   TAXES        " +   (float)(totalAmount/20f) );
					System.out.println("---------------------------------------");
					System.out.println("TOTAL  PAYABLE   AMOUNT         " +   ((float)totalAmount+(float)(totalAmount/20f) ));
					System.out.println("---------------------------------------");
				}
			}
				break;
			case 4: {
				System.out.println("YOUR ORDER WILL BE SERVED SOON \n \n");
				vegOrNon = false;
			}
				break;
			default:
				System.out.println("ENTER CORRECT INPUT : \n \n");
			}
		}
	}


	private void showNonVegMenu() {
		boolean nonVegMenu = true;
		while (nonVegMenu) {
			System.out.println(" 1.INDIAN BREADS \n 2.GRAVY \n 3.MAIN DISH \n 4.STARTERS \n 5.MILK SHAKES , FRESH JUICE \n 6.BACK");
			int option=scanner.nextInt();
			switch(option) {
			case 1:{
				printMenu(IndianBreads);
				int choice=scanner.nextInt();
			    while(!(choice>=1 && choice<=5)) {
			    	System.out.println("ENTER CORRECT INPUT \n \n");
			    	choice=scanner.nextInt();
			    }
			    String orderedDish=addBillings(choice,IndianBreads);
			    System.out.println(orderedDish+"  ADDED SUCCESSFULLY!! \n \n ");
			}break;
			case 2:{
				printMenu(NonVegGravy);
				int choice=scanner.nextInt();
			    while(!(choice>=1 && choice<=5)) {
			    	System.out.println("ENTER CORRECT INPUT \n \n");
			    	choice=scanner.nextInt();
			    }
			    String orderedDish=addBillings(choice,NonVegGravy);
			    System.out.println(orderedDish+"  ADDED SUCCESSFULLY!! \n \n");
			}break;
			case 3:{
				printMenu(NonVeg);
				int choice=scanner.nextInt();
			    while(!(choice>=1 && choice<=5)) {
			    	System.out.println("ENTER CORRECT INPUT \n \n");
			    	choice=scanner.nextInt();
			    }
			    String orderedDish=addBillings(choice,NonVeg);
			    System.out.println(orderedDish+"  ADDED SUCCESSFULLY!!  \n \n");
				}break;
			case 4:{
				printMenu(NonVegStarters);
				int choice=scanner.nextInt();
			    while(!(choice>=1 && choice<=5)) {
			    	System.out.println("ENTER CORRECT INPUT \n \n");
			    	choice=scanner.nextInt();
			    }
			    String orderedDish=addBillings(choice,NonVegStarters);
			    System.out.println(orderedDish+" ADDED SUCCESSFULLY!!  \n \n");
			}break;
			case 5:{
				printMenu(MilkShakes);
				int choice=scanner.nextInt();
			    while(!(choice>=1 && choice<=5)) {
			    	System.out.println("ENTER CORRECT INPUT \n \n");
			    	choice=scanner.nextInt();
			    }
			    String orderedDish=addBillings(choice,MilkShakes);
			    System.out.println(orderedDish+"  ADDED SUCCESSFULLY!!  \n \n");
			}break;
			case 6:{
				nonVegMenu = false;
				}break;
			default:System.out.println("PLEASE ENTER CORRECT INPUT :) \n \n");
			}
		}
	}


	private void showVegMenu() {
		boolean vegMenu = true;
		while (vegMenu) {
			System.out.println(" 1.VEG GRAVY \n 2.VEG STARTERS \n 3.INDIA NBREADS \n 4.MILK SHAKES \n 5.BACK");
			int option=scanner.nextInt();
			switch(option) {
			case 1:{
				printMenu(vegGravy);
				int choice=scanner.nextInt();
			    while(!(choice>=1 && choice<=5)) {
			    	System.out.println("ENTER CORRECT INPUT \n \n");
			    	choice=scanner.nextInt();
			    }
			    String orderedDish=addBillings(choice,vegGravy);
			    System.out.println(orderedDish+"  ADDED SUCCESSFULLY!! \n \n");
				
			}break;
			case 2:{
				printMenu(vegStarters);
				int choice=scanner.nextInt();
			    while(!(choice>=1 && choice<=5)) {
			    	System.out.println("ENTER CORRECT INPUT \n \n ");
			    	choice=scanner.nextInt();
			    }
			    String orderedDish= addBillings(choice,vegStarters);
			    System.out.println(orderedDish+"  ADDED SUCCESSFULLY!! \n  \n ");
			}break;
			case 3:{
				printMenu(IndianBreads);
				int choice=scanner.nextInt();
			    while(!(choice>=1 && choice<=5)) {
			    	System.out.println("ENTER CORRECT INPUT \n \n");
			    	choice=scanner.nextInt();
			    }
			    String orderedDish= addBillings(choice,IndianBreads);
			    System.out.println(orderedDish+"  ADDED SUCCESSFULLY!! \n \n");
				}break;
			case 4:{
				printMenu(MilkShakes);
				int choice=scanner.nextInt();
			    while(!(choice>=1 && choice<=5)) {
			    	System.out.println("ENTER CORRECT INPUT \n \n");
			    	choice=scanner.nextInt();
			    }
			    String orderedDish=addBillings(choice,MilkShakes);
			    System.out.println(orderedDish+"  ADDED SUCCESSFULLY!! \n \n");
			}break;
			
			case 5:{
				vegMenu = false;
				}break;
			default:System.out.println("PLEASE ENTER CORRECT INPUT :) \n \n");
			}
		}
	}

	private String addBillings(int index, Map<String, Integer> map) {
		int currentIndex=1; 
		String food="";
		for(Map.Entry<String, Integer> pair:map.entrySet()) {
		   if(currentIndex++==index) {
			   orderedFood.put(pair.getKey(), pair.getValue());
			   food+=pair.getKey();
			   break;
		   }
		}return food;
	}
	private void printMenu(Map<String, Integer> map) {
		 int foodIndex=0;
		System.out.printf("%-5s %-25s %-5s","S.NO","NAME","PRICE");
		System.out.println();
		System.out.println("---------------------------------------");
		for(Map.Entry<String, Integer> pair:map.entrySet()) {
			System.out.printf("%-5s %-25s %-5s",++foodIndex,pair.getKey().toUpperCase(), pair.getValue());
			System.out.println();
		}
	
	}

	private int printBill(Map<String, Integer> map) {
		 int foodIndex=0;
		 int amount=0;
			System.out.printf("%-5s %-25s %-5s","S.NO","NAME","PRICE");
			System.out.println();
			System.out.println("---------------------------------------");
			for(Map.Entry<String, Integer> pair:map.entrySet()) {
				System.out.printf("%-5s %-25s %-5s",++foodIndex,pair.getKey().toUpperCase(), pair.getValue());
				amount+= pair.getValue();
				System.out.println();
			}
			return amount;
		
	}

}
