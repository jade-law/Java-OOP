//I worked on the homework assignment alone, using only course materials.

/**
* This class represents the CoffeeMachine.
* @author Jade Law (jlaw39)
* @version 1.0
*/

public class CoffeeMachine {
    private static int cupsUsed;
    private static double sales;
    private static Cup[] cups = new Cup[10];

    /**
    * This method prints the sales and cups used.
    */
    public static void stats() {
        System.out.println("Today we made " + sales + " and used " + cupsUsed);
    }

    /**
    * This method pours a drink for a customer who brings their own cup.
    * This method takes two parameters and returns a Cup object.
    * @param c a Cup object
    * @param d a Drink Enum
    * @return Cup c that is filled with the Drink d
    */
    public static Cup pour(Cup c, Drink d) {
        c.setDrink(d);
        update(c);
        return c;
    }

    /**
    * This method pours a drink for a customer who will use one of the coffee machine's cups
    * This method takes one parameter and returns a Cup object
    * @param d a Drink enum
    * @return the Cup object filled with Drink d
    */
    public static Cup pour(Drink d) {
        Cup cup = null;
        restock();
        for (int i = 0; i < 10; i++) {
            if (canPour(i)) {
                cups[i].setDrink(d);
                cup = cups[i];
                update(i);
                break;
            }
        }
        return cup;
    }

    private static boolean canPour(int i) {
        boolean bool;
        if (cups[i].getDrink() == Drink.EMPTY) {
            bool = true;
        } else {
            bool = false;
        }
        return bool;
    }

    private static void restock() {
        if (cupsUsed % 10 == 0) {
            for (int i = 0; i < 10; i++) {
                cups[i] = new Cup("Java");
            }
        }
    }

    private static void update(int i) {
        cupsUsed += 1;
        sales += cups[i].getDrink().getPrice();
    }

    private static void update(Cup c) {
        sales += c.getDrink().getPrice();
    }

    /**
    * Setter method for cupsUsed
    * @param i number of cups used
    */
    public void setCupsUsed(int i) {
        cupsUsed = i;
    }
    /**
    * Setter method for sales
    * @param d double
    */
    public void setSales(double d) {
        sales = d;
    }

    /**
    * @return number of cups used
    */
    public int getCupsUsed() {
        return cupsUsed;
    }
    /**
    * @return amount of sales
    */
    public double getSales() {
        return sales;
    }


}