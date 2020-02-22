/**
* This class is a Attacker class that extends off of the Unfriendly class
* @author Jade Law (jlaw39)
* @version 1.0
*/
public class Attacker extends Unfriendly {
    /**
    * Constructor for Attacker
    * @param s name of the Unfriendly character
    */
    public Attacker(String s) {
        super(s);
    }

    /**
    * this method allows the Attacker to attack another character
    * @param c is the character to be attacked
    */
    public void attack(Character c) {
        if (!super.isSame(c)) {
            if (c.getHealth() == 0) {
                System.out.println(super.getName() + ": You show such weakness " + c.getName() + ".");
            } else {
                if (c instanceof Friendly) {
                    int hp = c.getHealth() - 5;
                    if (checkHpNeg(hp)) {
                        c.setHealth(0);
                    } else {
                        c.setHealth(hp);
                    }
                } else if (c instanceof Unfriendly) {
                    int hp = c.getHealth() - 3;
                    if (checkHpNeg(hp)) {
                        c.setHealth(0);
                    } else {
                        c.setHealth(hp);
                    }
                }
                System.out.println(checkHp(c.getHealth(), c));
            }
        }
    }

    /**
    * This method allows Attacker to interact with other characters
    * @param c is the other character
    */
    public void interact(Character c) {
        if (!super.isSame(c)) {
            super.interact(c);
        }
        attack(c);
    }

    private boolean checkHpNeg(int n) {
        return (n >= 0);
    }

    private String checkHp(int n, Character c) {
        String thisName = super.getName();
        String cName = c.getName();
        if (n != 0) {
            return thisName + ": Now you're only at " + c.getHealth() + " health. How does it feel " + cName + "!?";
        } else {
            return thisName + ": You were no match for me " + cName + ".";
        }
    }
}