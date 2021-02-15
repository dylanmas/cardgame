import java.util.*;

public class Player {
    private String name = "";
    private ArrayList<Card> inventory;
    
    public Player(String nameIn){
        inventory = new ArrayList<Card>();   
        name = nameIn;
    }

    //----------------------------------------------------------getter and setter methods:

    public Card getPlayerCard(int index){
        return inventory.get(index);
    }

    public void addPlayerCard(Card adder){
        inventory.add(adder);
    }

    public void removePlayerCard(int index){
        inventory.remove(index);
    }

    public void removeTopPlayerCard(){
        inventory.remove(inventory.size() - 1);
    }
    

    //the deal methods would ideally have their calls be assigned to a variable.
    public Card dealTop(){
        Card output;
        output = inventory.get(inventory.size() - 1);
        inventory.remove(inventory.size() - 1);
        return output;
    }

    public Card dealIndex(int index){
        Card output;
        output = inventory.get(index);
        inventory.remove(index);
        return output;
    }


    public String toString(){
        String output = name + "\n";
        for (int i = 1; i < inventory.size(); i++) {
            output += inventory.get(i) + "\n";
        }
        return output;
    }
}