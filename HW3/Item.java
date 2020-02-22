import java.util.Random;

/**
 * An Item.
 * @author jdierberger3 and <jlaw39>
 * @version 1331
 */
public class Item {

    /*
     * The Random instance to be used to acquire random values. You must use
     * this to get Random values if you want any credit!
     */
    private static Random random = new Random();

    // A String instance variable called "name"
    private String name;

    // TODO : Add a double instance variable called "price"
    private double price;

    // TODO : Add a double instance variable called "weight"
    private double weight;

    // Create an Item called "Random item" with a random price and weight.
    public Item() {
        name = "Random item";
        // TODO : Use one call to random to set price to a random double
        // TODO : Use one call to random to set weight to a random double
        // Both these doubles should have a value in the range [10, 100)
        price = 10 + random.nextDouble() * 90;
        weight = 10 + random.nextDouble() * 90;
    }

    // Create an Item with the given name, price and weight.
    public Item(String name, double price, double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    // Get the item name.
    public String getName() {
        return name;
    }

    // Get the item weight.
    public double getWeight() {
        return weight;
    }

    // Get the item price.
    public double getPrice() {
        return price;
    }

}