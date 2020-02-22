/**
* This class is an abstract Character class
* @author Jade Law (jlaw39)
* @version 1.0
*/

//I worked on the homework assignment alone, using only course materials.

public abstract class Character {

    private int health;
    private int maxHealth;
    private String name;

    /**
    * Constructor for Character
    * For the subclass' use since this is an abstract class
    * @param maxHp the maximum health of the character and the starting health of character
    * @param n the name of the character
    */
    public Character(int maxHp, String n) {
        maxHealth = maxHp;
        health = maxHealth;
        name = n;
    }

    /**
    * Getter method for name
    * @return name of the character
    */
    public String getName() {
        return name;
    }

    /**
    * Getter method for maxHealth
    * @return maxHealth of character
    */
    public int getMaxHealth() {
        return maxHealth;
    }

    /**
    * Getter method for the current health
    * @return current health of character
    */
    public int getHealth() {
        return health;
    }

    /**
    * Sets current health for character
    * @param h the new value of health
    */
    public void setHealth(int h) {
        health = h;
    }

    // Feel free to add instance variables as you see fit - just don't remove what's there.

    /**
    * an abstract method for characters to interact with other characters
    * @param c the character to interact with
    */
    public abstract void interact(Character c);

    /**
    * this method returns whether the character is an instance of itself
    * @param c the character to be compared to
    * @return true if they are same, false if not same
    */
    public boolean isSame(Character c) {
        return (this == c);
    }

    // Define any other abstract or concrete methods here to solve the homework problem.
    // Remember, anything you put here will be inherited by all subclasses and can be overridden!
    // Consider how you can use this to your advantage to store useful information or define useful behavior.


}