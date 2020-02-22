/**
* This class is a Friendly class that extends off of the Character class
* @author Jade Law (jlaw39)
* @version 1.0
*/
public class Friendly extends Character {

    /**
    * Constructor for Friendly
    * @param n name of the Friendly character
    */
    public Friendly(String n) {
        super(10, n);
        System.out.println("Hi my name is " + n + "! I am friendly!");
    }

    /**
    * method makes this Friendly character interact with another character
    * @param c is the character to be interacted with
    */
    public void interact(Character c) {
        if (!super.isSame(c)) {
            System.out.println(super.getName() + ": Hi " + c.getName() + "!");
        }
    }
}