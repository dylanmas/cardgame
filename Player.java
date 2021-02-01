import java.util.*;

public class Player {
    private String name = "";
    private ArrayList<Card> inventory;
    
    public Player(){
        inventory = new ArrayList<Card>();   
    }

    //accessors
    public String getPlayerCard(){
        String output = "";
        for (int i = 1; i < inventory.size(); i++) {
            output += inventory.get(i);
        }
        return output;
    }

    //mutators
    public void addPlayerCard(Card adder){
        inventory.add(adder);
    }

}
