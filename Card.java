/*
Date:
    1/14/2021
Coder name:
    Dylan Masulis
Project name:
    Card Game

    P.S. TODOs will be committed to the repo at a later date.

TODO:
    1. I realize that I use too many switch statements which are all the same.
    SOL: Make a function that calls to the switch and returns the appropriate value.
    WHY: Reduce program clutter, makes things more readable.
*/

public class Card {

    //declaration and initialization of card value and suit.
    private int value = 0;
    private int suit = 0;
    
    //the use of numbers will make working with cards 1000% easier.
    //it will be better for algorithms and it will cut down on what i need to write.
    //the full name, value text names (king, queen, jack), and suit names are automated.
    
    //apply values to the card value and the card suit.
    public Card (int initvalue, int initsuit){
        value = initvalue;
        suit = initsuit;
    }

    //not passing arguements creates a joker card. values of -1 mean joker.
    public Card (){
        //-1 means joker
        value = -1;
        suit = -1;
    }

    //----------------------------------------------------------getters & setter methods:

    //getValue() returns the value of the card as the pure number.
    public int getValue() {
        return this.value;
    }

    //getValueName() returns the value of the card, which counts string names like ace and queen.
    //returned as a string to accomidate string names for cards.
    public String getValueName() {
        String output = "";
        
        //switch determines the output based on value.
        switch(value){
            case 1:
                output += "ace";
                break;

            case 11:
                output += "jack";
                break;

            case 12:
                output += "queen";
                break;

            case 13:
                output += "king";
                break;

            case -1:
                output += "joker";
                break;

            default:
                output += "" + value + " of ";
                break;
        }
        
        return output;
    }

    //setValue() sets the value of a card.
    //likely only used for debugging.
    public void setValue(int value) {
        this.value = value;
    }

    //getSuit() returns the suit as a pure number.
    public int getSuit() {
        return this.suit;
    }

    //getSuitName() returns the suit as its String.
    public String getSuitName() {
        //switch statement determines the value of the Suit to return.
        switch (suit) {
            case 1:
                return "diamonds";

            case 2:
                return "clubs";

            case 3:
                return "hearts";

            case 4:
                return "spades";

            default:
                return "!! Invalid Suit Error !!";
        }
    }

    //setSuit() sets the suit based on number value.
    public void setSuit(int suit) {
        this.suit = suit;
    }

    //----------------------------------------------------------toString method:
    
    //the name is generated based on the two values.
    public String toString() {
        String output = "";

        //this switch determines the value of the card to output.
        switch(value){
            case 1:
                output += "ace of ";
                break;

            case 11:
                output += "jack of ";
                break;

            case 12:
                output += "queen of ";
                break;

            case 13:
                output += "king of ";
                break;

            case -1:
                output += "joker";
                break;

            default:
                output += "" + value + " of ";
                break;
        }

        //this switch determines the suit of the card to output.
        switch (suit) {
            case 1:
                output += "diamonds";
                break;

            case 2:
                output += "clubs";
                break;

            case 3:
                output += "hearts";
                break;

            case 4:
                output += "spades";
                break;

            default:
                break;
        }

        //returns the final output.
        return output;
    }

    //----------------------------------------------------------unique methods:

    //compareTo() returns a value that determines the difference between the two cards.
    public int compareTo(Card otherCard){
        return this.getValue() - otherCard.getValue();
    }

    //isEqual(), which returns if the value is equal or not as a boolean
    public boolean isEqual(Card otherCard){
        return this.getValue() == otherCard.getValue();
    }
}
