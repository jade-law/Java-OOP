/**
 * Cat class that is a subclass of the abstract Animal class
 * @author Jade Law (jlaw39)
 * @version 1.0
 */
public class Cat extends Animal implements Comparable<Animal> {
    protected int miceCaught;
    protected boolean likesLasagna;

    /**
     * Constructor for Cat
     * default value of storeId (200) is passed to Animal constructor
     * @param name the name of the Cat, to be passed to the Animal constructor
     * @param price the price of the Cat, to be passed to the Animal constructor
     * @param miceCaught number of mice the Cat has caught
     * @param likesLasagna boolean of whether or not the Cat likes lasagna
     */
    public Cat(String name, double price, int miceCaught, boolean likesLasagna) {
        super(200, name, price);
        this.miceCaught = miceCaught;
        this.likesLasagna = likesLasagna;
    }

    /**
     * Another constructor for Cat, has default values for name ("none") and price (30.00)
     * Calls the above constructor
     * @param miceCaught number of mice the Cat has caught
     * @param likesLasagna boolean of whether or not the Cat likes lasagna
     */
    public Cat(int miceCaught, boolean likesLasagna) {
        this("none", 30.00, miceCaught, likesLasagna);
    }

    /**
     * Getter method for miceCaught
     * @return int of number of mice caught
     */
    public int getMiceCaught() {
        return miceCaught;
    }

    /**
     * Getter method for likesLasagna
     * @return true if Cat likes lasagna, false if Cat does not like lasagna
     */
    public boolean getLikesLasagna() {
        return likesLasagna;
    }

    /**
     * Setter method for miceCaught
     * @param i the int to be set to miceCaught
     */
    public void setMiceCaught(int i) {
        miceCaught = i;
    }

    /**
     * Setter method for likesLasagna
     * @param b the boolean to be set to likesLasagna
     */
    public void setLikesLasagna(boolean b) {
        likesLasagna = b;
    }

    /**
     * Compares two Cats to each other.
     * Fulfills the requirements for implementation of Comparable interface
     * @param c the Cat to be compared to
     * @return 1 if this is greater than a, -1 if this is less than a, 0 if this and a are the same
     */
    @Override
    public int compareTo(Animal c) {
        int i = super.compareTo(c);
        if (c instanceof Cat) {
            i = super.compareTo(c);
            if (i == 0) {
                if (((Cat) c).miceCaught > this.miceCaught) {
                    i = 1;
                } else if (((Cat) c).miceCaught < this.miceCaught) {
                    i = -1;
                } else {
                    i = 0;
                }
            }
        }
        return i;
    }

    /**
     * What should be printed when printing an Cat
     * Calls Animal's toString() to reuse code
     * @return the String that should be printed
     */
    public String toString() {
        return super.toString() + ", Likes Lasagna: " + this.getLikesLasagna()
            + ", Mice Caught: " + this.getMiceCaught();
    }
}