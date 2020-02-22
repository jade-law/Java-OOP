/**
* This class represents the Cup obejct
* @author Jade Law (jlaw39)
* @version 1.0
*/

public class Cup {
    private Drink drink;
    private String stamp;

    /**
    * Creates an empty cup with a stamp
    * Takes 1 parameter
    * @param s a String to be set as the stamp
    */
    public Cup(String s) {
        Drink d = Drink.EMPTY;
        this.drink = d;
        this.stamp = s;
    }

    /**
    * Creates a cup with a drink and a stamp
    * Takes 2 parameters
    * @param drink the drink in the cup
    * @param s the stamp on the cup
    */
    public Cup(Drink drink, String s) {
        this.drink = drink;
        this.stamp = s;
    }

    /**
    * Setter method for drink
    * @param d Drink
    */
    public void setDrink(Drink d) {
        this.drink = d;
    }

    /**
    * @return the cup's drink
    */
    public Drink getDrink() {
        return this.drink;
    }
    /**
    * @return the cup's stamp
    */
    public String getStamp() {
        return this.stamp;
    }

    /**
    * Compares the drinks and stamps of two cups
    * @param c the cup to be compared to
    * @return true if the drinks and stamps are same, false if different
    */
    public boolean equals(Cup c) {
        return ((getDrink().equals(c.getDrink())) && (getStamp().equals(c.getStamp())));
    }

    /**
    * @return the drink and it's stamp
    */
    public String toString() {
        return "A cup of " + drink.getName() + " from " + stamp;
    }
}