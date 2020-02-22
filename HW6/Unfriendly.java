/**
* This class is a Unfriendly class that extends off of the Character class
* @author Jade Law (jlaw39)
* @version 1.0
*/
public class Unfriendly extends Character {
    /**
    * Constructor for Unfriendly
    * @param n name of the Unfriendly character
    */
    public Unfriendly(String n) {
        super(15, n);
        System.out.println("The name's " + n + ". I'm not friendly.");
    }

    /**
    * method makes this Unfriendly character interact with another character
    * @param c is the character to be interacted with
    */
    public void interact(Character c) {
        if (!super.isSame(c)) {
            System.out.println(super.getName() + ": What are you looking at " + c.getName() + "!?");
        }
    }
}