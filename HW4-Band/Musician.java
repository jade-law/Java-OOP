public class Musician {
    private String name; // Name of the musician.
    private String instrument; //Name of the musician’s weapon of choice.
    private int yearsPlaying; //Number of years the musician has been playing the instrument.
    private double skillLevel; //Related to yearsPlaying, more to explain shortly.

    //Constructors
    public Musician(String n, String ins) {
        new Musician(n, ins, 0);
    }

    public Musician(String n, String ins, int years) {
        name = n;
        instrument = ins;
        yearsPlaying = years;
        skillLevel = (yearsPlaying * 0.5) + 1;
    }


    //Methods
    public void rehearse() {
        yearsPlaying += 1;
        skillLevel += 0.5;
    }
    public void perform() {
        skillLevel += 1;
    }
    public String toString() {
        return "My name is " + name + ". I have been playing " + instrument + " for " + yearsPlaying + " years.";
    }


    //getters
    public String getName() {
        return name;
    }
    public String getInstrument() {
        return instrument;
    }
    public int getYearsPlaying() {
        return yearsPlaying;
    }
    public double getSkillLevel() {
        return skillLevel;
    }
}