package com.company;

import java.util.*;

/**
 * This class mimics a gumball machine.  It includes a main method which can be run to interact with the simulated
 * machine.
 */
public class Gumball_Machine {

    /**
     * Main method launches simulation of gumball machine
     *
     * @param args
     */

    public static void main(String args[]) {

        //this holds the truthiness of whether a customer is at the machine or not.
        boolean atMachine = true;

        //this will hold the number of cents a user has put in the machine.
        int currency = 0;

        //this arraylist holds the invalid currencies a user may put.
        ArrayList<String> otherCurrency = new ArrayList<>();

        //==============================================================================================================
        //this string will be used constantly after each operation to remind the user how to operate the machine.
        //Important Note: reading this instruction manual will explain the switch/case statement in lower code fragment.
        //==============================================================================================================

        final String instructions = "INSTRUCTIONS:" +
                "\nType a letter in order to perform an action at the gumball machine." +
                "\n[e] exit the gumball machine." +
                "\n[i] see instructions again" +
                "\n----Currency Operations----" +
                "\n[n] insert nickel." +
                "\n[q] insert quarter." +
                "\n[d] insert dime." +
                "\n[o] insert other currency (other currency is invalid, do not choose this option.  It will be returned when you press the dispenser.)" +
                "\n[c] press lever to get your change back (dispense currency currently in the machine)." +
                "\n----Gumball Operations----" +
                "\n[r] press lever to purchase red gumball (5 cents)" +
                "\n[y] press lever purchase yellow gumball (10 cents)" +
                "\n" +
                "\n";

        //these messages will print depending on the success or failure of the gumball machine operation.
        final String success = "\nOperation completed successfully.  Good job!\n";
        final String failure = "\nINVALID INPUT: y'know, it's not too hard to use a gumball machine.  please read the instructions and try again.\n";
        final String brokeBoy = "\nThis machine doesn't run on good will... try putting some money in, will you?\n";


        //prints instructions on first use for the customer to see.
        System.out.println(instructions); //asks for user input

        //this loop will continue until the user chooses to exit.
        while (atMachine) {
            System.out.println("press [i] to see instructions again");
            System.out.println("CURRENT CURRENCY IN GUMBALL MACHINE: " + currency);
            Scanner sc = new Scanner(System.in);
            String userInput = sc.nextLine();

            //we prompt the user for input and depending on input, perform a certain action in accordance w/ the instructions.
            switch (userInput) {

                case "i":
                    System.out.println(instructions);
                    break;

                default:
                    System.out.println(failure);
                    break;

                case "e":
                    atMachine = false;
                    break;

                case "y":
                    if (currency < 10) {
                        System.out.println(brokeBoy);
                        break;
                    } else {
                        currency -= 10;
                        System.out.println("Enjoy your yellow gumball! :-)");
                        break;
                    }

                case "q":
                    currency += 25;
                    break;

                case "d":
                    currency += 10;
                    break;

                case "o":
                    System.out.println("well, you're really not meant to do this... but OK, type in the currency you want to insert and then press enter.");
                    String invldInput = sc.nextLine();
                    otherCurrency.add(invldInput);
                    break;

                case "c":
                    System.out.println("Returning " + currency + "cents. ");
                    currency = 0;
                    if (otherCurrency.size() > 0) {
                        System.out.print("Dispensing other (invalid) currencies: \n");
                        for (String s : otherCurrency) {
                            System.out.println("- " + s + " ");
                        }
                        otherCurrency.clear();
                        System.out.println("...why'd you put that all in the machine?  weird...");
                    }
                    break;

                case "r":
                    if (currency < 5) {
                        System.out.println(brokeBoy);
                        break;
                    } else {
                        currency -= 5;
                        System.out.println("Enjoy your red gumball! :-)");
                        break;
                    }

                case "n":
                    currency += 5;
                    break;
            }

        }

        //exit message
        System.out.println("-----GOODBYE VALUED CUSTOMER.  PLEASE COME AGAIN.-----");
    }
}
