public class Card {
    private int value = 0;
    private int suit = 0;
    
    //the use of numbers will make the code more compatible with card-generating algorithms.

    public Card (int initvalue, int initsuit){
        value = initvalue;
        suit = initsuit;
    }

    public Card (){
        //-1 means joker
        value = -1;
        suit = -1;
    }

    //getters & setters

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getSuit() {
        return this.suit;
    }

    public String getSuitName() {
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

    public void setSuit(int suit) {
        this.suit = suit;
    }

    //the name is generated based on the two values.

    public String toString() {
        String output = "";

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

        return output;
    }

    //other methods
    //compareTo, which compares cards.
    //if this > other, return positive.
    //if equal, return 0.
    //if this < other, return negative.

    public int compareTo(Card otherCard){
        return this.getValue() - otherCard.getValue();
    }

    //isEqual, which returns if the value is equal or not as a boolean
    
    public boolean isEqual(Card otherCard){
        return this.getValue() == otherCard.getValue();
    }
}
