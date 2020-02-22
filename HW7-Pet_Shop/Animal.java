/**
 * Abstract class Animal that implements Comparable interface
 * Dog class and Cat class extend off of Animal
 * @author Jade Law (jlaw39)
 * @version 1.0
 */

//I worked on the homework assignment alone, using only course materials.
public abstract class Animal implements Comparable<Animal> {
    protected int storeId;
    protected String name;
    protected double price;

    /**
     * Constructor for Animal. Cannot be instantiated
     * @param storeId the store Id of the Animal
     * @param name the name of the Animal
     * @param price the price of the Animal
     */
    public Animal(int storeId, String name, double price) {
        this.storeId = storeId;
        this.name = name;
        this.price = price;
    }

    /**
     * Another constructor for Animal. Includes the default values of name and price.
     * @param storeId the store Id of the Animal
     */
    public Animal(int storeId) {
        this(storeId, "Buzz", 222.00);
    }

    /**
     * Getter method for storeId of the Animal
     * @return int storeId
     */
    public int getStoreId() {
        return storeId;
    }

    /**
     * Getter method for name of the Animal
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for the price of the Animal
     * @return double price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Setter method for storeId
     * @param i the Id to be set for the Animal
     */
    public void setStoreId(int i) {
        storeId = i;
    }

    /**
     * Setter method for name
     * @param n the name to be set for the Animal
     */
    public void setName(String n) {
        name = n;
    }

    /**
     * Setter method for price
     * @param p the price to be set for the Animal
     */
    public void setPrice(double p) {
        price = p;
    }

    /**
     * Compares two animals to each other.
     * Fulfills the requirements for implementation of Comparable interface
     * @param a the Animal to be compared to
     * @return 1 if this is greater than a, -1 if this is less than a, or compares the names of the two animals
     */
    public int compareTo(Animal a) {
        int i = 0;
        if (a instanceof Animal) {
            if (this.getStoreId() > ((Animal) a).getStoreId()) {
                i = 1; //this is a cat and o is a dog
            } else if (this.getStoreId() < ((Animal) a).getStoreId()) {
                i = -1; //this is a dog and o is a cat
            } else { //both are dogs or both are cats
                i = this.name.compareTo(((Animal) a).name); //-1=this comes first in alphabet.
                //1=this comes later in alphabet
            }
        }
        return i;
    }

    /**
     * What should be printed when printing an Animal
     * @return the String that should be printed
     */
    public String toString() {
        return "Store ID: " + this.storeId + ", Name: " + this.name + ", Price: " + this.price + 0;
    }
}