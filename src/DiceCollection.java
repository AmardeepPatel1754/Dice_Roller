/**
 * @author: Amardeep Sanjaybhai Patel,
 */

public class DiceCollection {
    private Die[] dice; // array to store the dice in the collection
    private int minRoll; // minimum possible roll value for the collection
    private int maxRoll; // maximum possible roll value for the collection

    // Constructor that takes an array of integers representing the number of sides for each die
    public DiceCollection(int[] sides) {
        dice = new Die[sides.length]; // initialize the dice array with the appropriate length
        for (int i = 0; i < sides.length; i++) {
            dice[i] = new Die(sides[i]); // create a new die with the given number if sides
            minRoll += 1; // add 1 to the minimum possible roll for each die
            maxRoll += sides[i]; // add the number of sides to the maximum possible roll for each die
        }
    }

    // Method to get the sum of all dice values in the collection
    public int getSum() {
        int sum = 0;
        for (Die d : dice) {
            sum += d.getValues();
        }
        return sum;
    }

    // Getter for the minimum possible roll value
    public int getMinRoll() {
        return minRoll;
    }

    // Getter for the maximum possible roll value
    public int getMaxRoll() {
        return maxRoll;
    }

    // Method to roll all dice in the collection
    public void rollAll() {
        for (Die d : dice) {
            d.roll();
        }
    }

    //  Override of the toString method to display information about the collection
    @Override
    public String toString() {
        String result = "";
        for (Die d : dice) {
            result += d.toString() + "\n";
        }
        result += "Possible Minimum Rolls: " + minRoll + "\n";
        result += "Possible Maximum Rolls: " + maxRoll + "\n";
        result += "Recent Rolls: " + getSum() + "\n";
        return result;
    }

    // Method to simulate rolling the dice in the collection a given number of times and return a histogram of the results
    public int[] histogram(int rolls) {
        int[] histogram = new int[maxRoll - minRoll + 1]; //initialize the histogram with the appropriate length
        for (int i = 0; i < rolls; i++) {
            rollAll(); // roll the dice
            int sum = getSum(); // get the sum of the dice values
            histogram[sum - minRoll]++; // increment the appropriate bin inn the histogram
        }
        return histogram;
    }
}