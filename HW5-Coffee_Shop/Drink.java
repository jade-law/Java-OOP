/**
* This is a enum Drink
* @author Jade Law (jlaw39)
* @version 1.0
*/

public enum Drink {
    CHOCOLATE ("hot chocolate", 1.50), COFFEE ("coffee", 2.00), TEA ("tea", 1.00), EMPTY ("nothing", 0.00);

    private String name;
    private double price;

    private Drink(String s, double d) {
        this.name = s;
        this.price = d;
    }

    /**
    * @return this name of the drink
    */
    public String getName() {
        return this.name;
    }

    /**
    * @return price of the drink
    */
    public double getPrice() {
        return this.price;
    }
}