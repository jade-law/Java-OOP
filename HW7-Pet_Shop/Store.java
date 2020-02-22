/**
 * Store class that implements StoreOrganizer interface
 * "Manages" the store. Keeps track of all of the pets and sorts the pets
 * Performs searches for certain pets
 * @author Jade Law (jlaw39)
 * @version 1.0
 */
public class Store implements StoreOrganizer {
    protected int numPets;
    protected Animal[] pets;

    /**
     * Constructor for Store.
     * @param numPets the number indices in pets array
     */
    public Store(int numPets) {
        this.numPets = numPets;
        pets = new Animal[numPets];
    }

    /**
     * Getter method for the pets array
     * @return the pets array
     */
    public Animal[] getPets() {
        return pets;
    }

    /**
     * adds Animals to the pets array if there is room for Animals
     * @param a the Animal to be added into the pets array
     */
    public void add(Animal a) {
        for (int i = 0; i < pets.length; i++) {
            if (pets[i] == null) {
                pets[i] = a;
                break;
            }
        }
    }

    /**
     * method for sorting the pets list
     * Incorporates the actualSort method
     * Big O of O(n^2). This is because the program has to run through the list
     * multiple times before the list is actually sorted
     */
    public void sort() {
        int s = -1;
        while (s != 0) {
            s = 0;
            for (int i = 0; i < pets.length - 1; i++) {
                int j;
                if ((pets[i] instanceof Dog && pets[i + 1] instanceof Dog)
                    || (pets[i] instanceof Cat && pets[i + 1] instanceof Cat)) {
                    j = pets[i].compareTo(pets[i + 1]);
                    s = actualSort(i, j, s);
                    //System.out.println(s);
                } else {
                    try {
                        j = ((Animal) pets[i]).compareTo(((Animal) pets[i + 1]));
                        s = actualSort(i, j, s);
                    } catch (NullPointerException npe) {
                        continue;
                    }
                }
            }
        }
    }

    private int actualSort(int i, int j, int s) {
        Animal temp;
        if (j > 0) {
            temp = pets[i];
            pets[i] = pets[i + 1];
            pets[i + 1] = temp;
            s += 1;
        }
        return s;
    }

    /**
     * makes a binary search through the pets array
     * incorporates the private findHigh() method
     * Big O of O(log n). Very efficient because you are eliminating
     * half of the code each time so there are no unnecessary steps
     * @param a the Animal being searched for
     * @return the index that the Animal is stored
     */
    public int binarySearch(Animal a) {
        int low = 0;
        int high = this.findHigh();
        int mid = (low + high) / 2;
        int j = -1;
        while (low != high) {
            try {
                if (a.compareTo(pets[mid]) == 0) {
                    j = mid;
                    return j;
                } else if (a.compareTo(pets[high]) == 0) {
                    j = high;
                    return j;
                } else if (a.compareTo(pets[low]) == 0) {
                    j = low;
                    return j;
                } else if (a.compareTo(pets[mid]) < 0) {
                    high = mid - 1;
                    mid = (low + high) / 2;
                } else if (a.compareTo(pets[mid]) > 0) {
                    low = mid + 1;
                    mid = (low + high) / 2;
                }
            } catch (ArrayIndexOutOfBoundsException ae) {
                return j;
            }
        }
        return j;
    }

    private int findHigh() {
        int high = pets.length - 1;
        for (int i = high; i >= 0; i--) {
            if (pets[i] != null) {
                return i;
            }
        }
        return high;
    }

    /**
     * makes a linear search through the pets array
     * Big O of O(n). This is because it goes through the entire list
     * and will eventually find the item or worst case not find the item
     * or the item will be the very last index
     * @param a the Animal being searched for
     * @return the index that the Animal is stored
     */
    public int linearSearch(Animal a) {
        int j = -1;
        for (int i = 0; i < pets.length; i++) {
            if (pets[i].compareTo(a) == 0) {
                j = i;
            } else {
                continue;
            }
        }
        return j;
    }
}