public class Test{
    public static void main(String[] args) {
        Dog dog1 = new Dog("Cullen", 100.00, true, 3);
        Dog dog2 = new Dog("Cullen", 200.00, true, 34);
        Dog dog3 = new Dog("Jade", 50.00, false, 800);
        Cat cat1 = new Cat("Jade", 100.00, 0, true);
        Cat cat2 = new Cat("Neko", 30.00, 1, true);
        Cat cat3 = new Cat("Cat", 150.00, 5, false);
        Animal anidog1 = new Dog("Inu", 70.0, true, -1);
        Animal anidog2 = new Dog("Bork", 100.0, false, 33);
        Animal anicat1 = new Cat("Gabi", 1000.00, 5, true);
        Animal anicat2 = new Cat("Gabi", 100.00, 5000, false);

        Store store = new Store(10);

        store.add(dog1);
        store.add(dog2);
        store.add(dog3);
        store.add(cat1);
        store.add(cat2);
        store.add(cat3);
        store.add(anidog1);
        store.add(anidog2);
        store.add(anicat1);
        store.add(anicat2);



        store.sort();

        for (int i = 0; i < store.pets.length; i++) {
            System.out.println(store.pets[i]);
        }

        System.out.println(store.binarySearch(dog1));
        System.out.println(store.binarySearch(anicat2));
        System.out.println(store.binarySearch(dog3));
        System.out.println(store.binarySearch(cat2));
        System.out.println(store.binarySearch(anidog2));
    }
}