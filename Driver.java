/*
Date:
    3/12/2021
Coder name:
    Dylan Masulis
Project name:
    Card Game
*/

//import all of java.util
import java.util.*;

public class Driver {
    public static void main(String[] args) {
        //on run, print a welcome message for first-time use.
        System.out.println("Welcome to War!");
        //create a new war object. This starts the entire game and loop.
        War newGame = new War();
        //rounds will continue endlessly, so you can play as many games as you want.
        //to exit the loop, you are intended to do CTRL + C, as that is the way to terminate java.
    }
}
