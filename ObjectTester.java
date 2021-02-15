public class ObjectTester {
    public static void main(String[] args) {
        Card test = new Card(13, 2);
        Card foo = new Card(1, 2);
        System.out.println(test.getSuitName() + "jfsdjlkfsdjklfdsjkldsfakjl");
        System.out.println(test.compareTo(foo));
        
        Deck lol = new Deck(1);
        System.out.println(lol);

        Player pl1 = new Player("Johannesburg");
        Player pl2 = new Player("CapeTown");

        lol.shuffleCards();
        lol.deal(pl1, pl2);

        System.out.println(pl1);
        System.out.println(pl2 + "DIVIDER");

        Card fff = pl2.dealTop();

        System.out.println("\n" + fff.toString() + "\n\t\t\tHere's the new cards" + pl2);
    }
}