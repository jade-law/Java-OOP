public class Tester {
	public static void main(String args[]) {
		// Drink d1 = Drink.CHOCOLATE;
		// Drink d2 = Drink.TEA;
		// Drink d3 = Drink.COFFEE;
		// Drink d4 = Drink.CHOCOLATE;
		// Drink d5 = Drink.CHOCOLATE;
		// Drink d6 = Drink.TEA;
		// Drink d7 = Drink.COFFEE;
		// Drink d8 = Drink.CHOCOLATE;
		// Drink d9 = Drink.CHOCOLATE;
		// Drink d10 = Drink.TEA;
		// Drink d11 = Drink.COFFEE;
		// Drink d12 = Drink.CHOCOLATE;

		Cup c1 = new Cup(Drink.CHOCOLATE, "Starbuck's");
		Cup c2 = new Cup(Drink.CHOCOLATE, "Starbuck's");
		Cup c3 = new Cup(Drink.TEA, "Teavana");

		System.out.println(c1.getDrink());
		System.out.println(c1.getStamp());
		System.out.println(c2.getDrink());
		System.out.println(c2.getStamp());
		System.out.println(c3.getDrink());
		System.out.println(c3.getStamp());


		System.out.println(c1.equals(c2));
		System.out.println(c1.equals(c3));

		// System.out.println(CoffeeMachine.pour(d1));
		// System.out.println(CoffeeMachine.pour(c3, d1));
		// System.out.println(CoffeeMachine.pour(d3));
		// System.out.println(CoffeeMachine.pour(d4));
		// System.out.println(CoffeeMachine.pour(c2, d1));
		// System.out.println(CoffeeMachine.pour(d6));
		// System.out.println(CoffeeMachine.pour(d7));
		// System.out.println(CoffeeMachine.pour(d8));
		// System.out.println(CoffeeMachine.pour(d9));
		// System.out.println(CoffeeMachine.pour(d10));
		// System.out.println(CoffeeMachine.pour(c2, d1));
		// System.out.println(CoffeeMachine.pour(d12));
		// System.out.println(CoffeeMachine.pour(Drink.CHOCOLATE));
		// System.out.println(CoffeeMachine.pour(Drink.CHOCOLATE));

		// CoffeeMachine.stats();

		





	}
}