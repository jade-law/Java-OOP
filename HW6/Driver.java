public class Driver {

    public static void main(String[] args) {
        //TODO: Create an object of each type
        //TODO: Make sure the constructors output the correct info

        Healer gabi = new Healer("Gabi");
        Healer cullen = new Healer("Cullen");
        Character rashmi = new Friendly("Rashmi");
        Attacker david = new Attacker("David");
        Attacker jade = new Attacker("Jade");

        gabi.interact(cullen);
        cullen.interact(gabi);
        cullen.interact(rashmi);
        cullen.interact(david);
        gabi.interact(rashmi);
        jade.interact(cullen);
        gabi.heal(cullen);
        gabi.heal(cullen);
        gabi.heal(cullen);
        jade.attack(cullen);
        jade.attack(cullen);
        jade.attack(cullen);
        jade.attack(cullen);
        gabi.heal(cullen);
        david.interact(gabi);
        jade.interact(gabi);
        gabi.interact(david);
        jade.interact(gabi);
        gabi.interact(david);
        jade.interact(david);

        gabi.interact(gabi);
        jade.interact(jade);



        //TODO: Test object interactions. Remember most types have
        // unique interactions with other types.

        // Try having attackers attack healers, other attackers, 
        // themselves, etc. Refer to the homework description to see
        // what each interaction should do! (Or not do.)
    }

    

}