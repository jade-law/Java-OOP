/**
 * @author Eve Eve
 * @version 1.0 Mar 05, 19
 **/
public class Dog {
    String name;
    boolean isAGoodBoy;

    public Dog(String name, boolean isAGoodBoy){
        this.name = name;
        this.isAGoodBoy = isAGoodBoy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public boolean getIsAGoodBoy() {
        return isAGoodBoy;
    }

    public void setIsAGoodBoy(boolean isAGoodBoy) {
        this.isAGoodBoy = isAGoodBoy;
    }
}
