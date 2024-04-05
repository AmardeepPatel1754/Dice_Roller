/**
 * @author: Amardeep Sanjaybhai Patel
 */

public class Die {
    private int sides;
    private int value;

    // Constructor that takes the number of sides as a parameter and initializes the value of the die by rolling it
    public Die(int sides){
        this.sides = sides;
        roll();
    }

    // Getter method for the number of sides of the die
    public int getSides(){
        return sides;
    }

    // Getter method for the current value of the die
    public int getValues(){
        return value;
    }

    // Method that simulates rolling the die by generating a random integer between 1 and the number of sides
    public void roll(){
        value = (int) (Math.random() * sides) + 1;
    }

    // Method that returns a string representation of the die, including the number of the sides and the current value
    public String toString(){
        return "Dice With: " + sides + " sides showing: " + value;
    }
}