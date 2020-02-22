public class Fan {
    private int yearsAsFan; //How many years this person has been a fan of the band.
    private int albumsBought; //Number of albums that this fan has bought.
    private int concertsAttended; //Number of concerts this fan has attended.
    private boolean buzzcard; //Boolean representing whether or not this fan has their Buzzcard.
    private Musician favoriteMusician; //This fan’s favorite musician

    //Constructor
    public Fan(int years, int albums, int concerts, boolean buzz, Musician fave) {
        yearsAsFan = years;
        albumsBought = albums;
        concertsAttended = concerts;
        buzzcard = buzz;
        favoriteMusician = fave;
    }

    //methods
    public boolean winGiveaway() {
        return true;
    }

    public String liveTweet(Concert concert) {
        String a;
        String b;
        String c;
        if (yearsAsFan > 5) {
            a = "Best band ever!\n";
        } else {
            a = "\n";
        }
        double price = concert.getTicketPrice();
        if (price > 100) {
            b = "Totally worth my entire bank account!\n";
        } else {
            b = "\n";
        }
        if (albumsBought >= 1) {
            c = "Even better in person!\n";
        } else {
            c = "\n";
        }
        concertsAttended += 1;
        if (concertsAttended > 1) {
            return a + b + c + "I've been to " + concertsAttended + " concerts!";
        } else {
            return a + b + c + "I've been to 1 concert!";
        }
    }

    public void lostBuzzcard() {
        if (yearsAsFan > 3) {
            buzzcard = false;
        }
    }

    public void announceFavoriteMusician() {
        System.out.println("My favorite musician is " + favoriteMusician.getName() + "!");
    }

    //getters
    public int getYearsAsFan() {
        return yearsAsFan;
    }
    public int getAlbumsBought() {
        return albumsBought;
    }
    public int getConcertsAttended() {
        return concertsAttended;
    }
    public boolean hasBuzzcard() {
        return buzzcard;
    }
    public Musician getFavoriteMusician() {
        return favoriteMusician;
    }
}