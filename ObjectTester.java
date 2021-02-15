public class ObjectTester {
    public static void main(String[] args) {
        Card test = new Card(13, 2);
        Card foo = new Card(1, 2);
        System.out.println(test.getSuitName() + "jfsdjlkfsdjklfdsjkldsfakjl");
        System.out.println(test.compareTo(foo));
        
        Deck lol = new Deck(1);
        System.out.println(lol);
    }
}