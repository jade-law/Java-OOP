/*In order to help learn course concepts, I worked on the homework with
Gabrielle Schweinfurth, discussed homework topics and issues with
Gabrielle Schweinfurth, and/or consulted related material that can be found at none.*/

public class Concert {
    private double ticketPrice; //General Admission ticket price.
    private int capacity; //Venue capacity.
    private int ticketsSold; //Number of tickets sold.
    private String location; //Location of the concert.
    private String date; //The date of the concert in the format MM/DD/YYYY.

    //Constructors
    public Concert(int cap, String loc, String d) {
        new Concert(30.0, cap, loc, d);
    }

    public Concert(double p, int cap, String loc, String d) {
        ticketPrice = p;
        capacity = cap;
        location = loc;
        date = d;
        ticketsSold = 0;
    }

    //Methods
    public boolean isSoldOut() {
        boolean bool;
        if (this.ticketsSold < this.capacity) {
            bool = false; //not sold out
        } else {
            bool = true; //sold out
        }
        return bool;
    }

    public void sellTicket() {
        int sold = this.getTicketsSold();
        int cap = this.getCapacity();
        boolean canSell = this.isSoldOut();
        if (!canSell) {
            ticketsSold += 1;
        }
    }

    public String toString() {
        return "A concert on " + this.getDate() + " at " + this.getLocation();
    }

    //Getters
    public double getTicketPrice() { return ticketPrice; }
    public int getCapacity() {
        return capacity;
    }
    public int getTicketsSold() {
        return ticketsSold;
    }
    public String getLocation() {
        return location;
    }
    public String getDate() {
        return date;
    }

    //Setters
    public void setLocation(String loc) {
        location = loc;
    }
    public void setTicketPrice(int price) {
        ticketPrice = price;
    }
}