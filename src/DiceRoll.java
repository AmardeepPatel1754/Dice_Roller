/**
 * @author: Amardeep Sanjaybhai Patel
 */


import java.util.Scanner;

public class DiceRoll {
    public static void main(String[] args) {

        //Create a Scanner object to read user input
        Scanner sc = new Scanner(System.in);

        //Prompt the user to enter the number of dice
        System.out.print("Enter the Number of Dice: ");
        int numDice = sc.nextInt();

        //Create an array to hold the number of sides for each die
        int[] sides = new int[numDice];

        //Prompt the user to enter the number of sides for eah die and store in the sides array
        for (int i = 0; i < numDice; i++) {
            System.out.print("Enter The Number of Sides: " + (i + 1) + ": ");
            sides[i] = sc.nextInt();
        }

        //Create a new DiceCollection object with the sides array
        DiceCollection collection = new DiceCollection(sides);

        //Print out the initial state of the dice collection
        System.out.println(collection.toString());

        //Loop until the user choose quit
        boolean done = false;
        while (!done) {
            //Prompt the user for their choice of action
            System.out.println("\n1. Roll Once\n2. Roll 100,000 Times\n3. Quit");
            int choice = sc.nextInt();

            //Preform the corresponding action based on the user's choice
            switch (choice) {
                case 1:
                    //Roll all the dice once and print out the updated state of the collection
                    collection.rollAll();
                    System.out.println(collection.toString() + "/n");
                    break;
                case 2:
                    //Roll all the dice 100,000 times and print out the resulting histogram
                    System.out.print("Rolling 100,000 Times... ");
                    int[] histogram = collection.histogram(100000);
                    System.out.println("Done.\n");
                    for (int i = 0; i < histogram.length; i++) {
                        if (histogram[i] != 0) {
                            System.out.println("Sum " + i + ": " + histogram[i]);
                        }
                    }
                    break;
                case 3:
                    //Exit the program
                    done = true;
                    break;
                default:
                    //Prompt the user to enter a valid choice if they input an invalid one
                    System.out.println("Choice InValid");
            }
        }

        //Close the Scanner object
        sc.close();
    }
}
