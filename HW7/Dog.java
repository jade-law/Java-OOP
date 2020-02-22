/**
 * Dog class that is a subclass of the abstract Animal class
 * @author Jade Law (jlaw39)
 * @version 1.0
 */
public class Dog extends Animal implements Comparable<Animal> {
    protected boolean curlyTail;
    protected int droolRate;

    /**
     * Constructor for Dog
     * default value of storeId (100) is passed to Animal constructor
     * @param name the name of the Dog, to be passed to the Animal constructor
     * @param price the price of the Dog, to be passed to the Animal constructor
     * @param curlyTail whether or not the Dog has a curly tail
     * @param droolRate the rate at which the Dog drools
     */
    public Dog(String name, double price, boolean curlyTail, int droolRate) {
        super(100, name, price);
        this.curlyTail = curlyTail;
        this.droolRate = droolRate;
    }

    /**
     * Another constructor for Dog, has default values for name ("none") and price (50.00)
     * Calls the above constructor
     * @param curlyTail whether or not the Dog has a curly tail
     * @param droolRate the rate at which the Dog drools
     */
    public Dog(boolean curlyTail, int droolRate) {
        this("none", 50.00, curlyTail, droolRate);
    }

    /**
     * Getter method for curlyTail of the Dog
     * @return true if Dog has curly tail, false if Dog does not have curly tail
     */
    public boolean getCurlyTail() {
        return curlyTail;
    }

    /**
     * Getter method for droolRate of the Dog
     * @return int droolRate
     */
    public int getDroolRate() {
        return droolRate;
    }

    /**
     * Setter method for curlyTail
     * @param b the boolean to be set to curlyTail
     */
    public void setCurlyTail(boolean b) {
        curlyTail = b;
    }

    /**
     * Setter method for droolRate
     * @param i the int to be set to droolRate
     */
    public void setDroolRate(int i) {
        droolRate = i;
    }

    /**
     * Compares two Dogs to each other.
     * Fulfills the requirements for implementation of Comparable interface
     * @param a the Dog to be compared to
     * @return 1 if this is greater than a, -1 if this is less than a, 0 if this and a are the same
     */
    @Override
    public int compareTo(Animal a) {
        int i = super.compareTo(a);
        if (a instanceof Dog) {
            i = super.compareTo(a); //Check if dog or cat
            if (i == 0) {
                if (((Dog) a).droolRate > this.droolRate) {
                    i = 1;
                } else if (((Dog) a).droolRate < this.droolRate) {
                    i = -1;
                } else {
                    i = 0;
                }
            }
        }
        return i;
    }
    /**
     * What should be printed when printing an Dog
     * Calls Animal's toString() to reuse code
     * @return the String that should be printed
     */
    public String toString() {
        return super.toString() + ", Curly Tail: " + this.getCurlyTail() + ", Drool Rate: " + this.getDroolRate();
    }
}