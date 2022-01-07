package src;

/**
 * This class represents a single die.
 *
 * @author Oluwatobi Jemima Alabi
 */
public class Dice {
    private int faceValue;
    
    /**
     * Constructor for the Dice class.
     */
    public Dice() {
        faceValue = 0;
       
    }
    /**
     * This method rolls the die.
     */
    public void roll() {
        faceValue = (int)(Math.random() * 5) + 1;
    }
    
    /**
     * This method returns the face value of the die.
     * @return the face value of the die.
     */
    public int getFaceValue() {
        return faceValue;
    }
    
    /**
     * This method returns the face value of the die in a string.
     * @return the face value of the die.
     */
    public String toString() {
        return "The value of the dice is " + faceValue;
    }
    
}
