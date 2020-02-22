/**
* This class is a Healer class that extends off of the Friendly class
* @author Jade Law (jlaw39)
* @version 1.0
*/
public class Healer extends Friendly {
    /**
    * This is the constructor for a Healer
    * @param n is the name of the Healer
    */
    public Healer(String n) {
        super(n);
    }

    /**
    * this method allows the Healer to heal another character
    * @param c is the character to be healed
    */
    public void heal(Character c) {
        if (!super.isSame(c)) {
            if (c.getHealth() == 0) {
                System.out.println(super.getName() + ": I'm sorry " + c.getName() + ". Nothing is working!");
            } else if (c.getHealth() == c.getMaxHealth()) {
                System.out.println(super.getName() + ": Hey " + c.getName() + ". You look perfectly fine to me!");
            } else {
                if (c instanceof Friendly) {
                    int hp = c.getHealth() + 4;
                    if (hp > c.getMaxHealth()) {
                        c.setHealth(c.getMaxHealth());
                    } else {
                        c.setHealth(hp);
                    }
                } else if (c instanceof Unfriendly) {
                    int hp = c.getHealth() + 2;
                    if (hp > c.getMaxHealth()) {
                        c.setHealth(c.getMaxHealth());
                    } else {
                        c.setHealth(hp);
                    }
                }
                System.out.print(super.getName() + ": Got you up to " + c.getHealth());
                System.out.print(" health. Hope you feel better " + c.getName() + "!\n");
            }
        }
    }

    /**
    * This method allows Healer to interact with other characters
    * @param c is the other character
    */
    public void interact(Character c) {
        if (!super.isSame(c)) {
            super.interact(c);
        }
        heal(c);
    }
}