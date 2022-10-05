package dining;

import java.util.*;

public class DiningMain {
	List<Integer> bookedTables = new ArrayList<>();
	Scanner scanner = new Scanner(System.in);
	MenuCard menucard = new MenuCard();

	public static void main(String[] args) {
		DiningMain object = new DiningMain();
		object.start();
	}

	private void start() {
		Scanner scanner = new Scanner(System.in);
		DiningMain object = new DiningMain();
		boolean boo = true;
		while (boo) {
			System.out.println(" 1.Dining \n 2.help/support \n 3.exit ");
			int mainChoice = scanner.nextInt();
			switch (mainChoice) {
			case 1: {

				boolean case1 = true;
				while (case1) {
					System.out.println(" 1.select table \n 2.shoW Available Table \n 3.back to main menu");
					int orderFoodOptions = scanner.nextInt();
					switch (orderFoodOptions) {
					case 1: {
						object.orderFood();
					}
						break;
					case 2: {

					}
						break;
					case 3: {
						case1 = false;
					}
						break;
					default:
						System.out.println("please enter correct input :)");
					}
				}
			}
				break;
			case 2: {
				boo = false;
			}
				break;
			case 3: {
				boo = false;
			}
				break;
			default:
				System.out.println("please enter correct input:)");
			}
		}
	}

	private void orderFood() {

		boolean tableSelection = true;
		while (tableSelection) {
			System.out.println("SELECT (1 - 10)");
			int seletedTableNumber = scanner.nextInt();
			if (seletedTableNumber >= 1 && seletedTableNumber <= 10) {
				if (bookedTables.contains(seletedTableNumber)) {
					System.out.println(" SORRY !!! \n TABLE ALREADY SELECTED \n SELECT SOME OTHER TABLE \n \n");
					continue;
				}
				System.out.println("TABLE " + seletedTableNumber + " IS SUCCESSFULLY BOOKED FOR YOU \n \n");
				bookedTables.add(seletedTableNumber);
				menucard.showMenu();

				tableSelection = false;
			}

		}
	}

}
