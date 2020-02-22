public class ConcertSimulator {
    public static void main(String[] args) {
        Musician klaus = new Musician("Christopher W. Klaus", "violin", 30);
        Musician uga = new Musician("UGA", "students", 234);
        Fan gerald = new Fan(18, 8, 52, true, klaus);
        Concert c1 = new Concert(500, 60, "Mercedes-Benz Stadium", "02/03/2019");
        System.out.println(klaus);
        System.out.println(uga);
        gerald.announceFavoriteMusician();
        int i = 0;
        while (i <= 60) {
            c1.sellTicket();
            i += 1;
        }
        if (c1.isSoldOut()) {
            System.out.println("Sorry! A concert on " + c1.getDate() + " at " + c1.getLocation() + " is fully booked!");
        }
        System.out.print(gerald.liveTweet(c1));
    }
}