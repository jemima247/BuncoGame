package src;

/**
 * This class represents a box of dice.
 * 
 * @author Oluwatobi Jemima Alabi
 *
 */
public class DiceBox {
    
    private Dice[] dice;
    private int numDice = 3;
    private int numRolls;
    private int playRound;
    
    /**
     * Constructor for the DiceBox class.
     * 
     * numDice : The number of dice in the box.
     */
    public DiceBox() {
        dice = new Dice[numDice];
        numRolls = 0;
    }
    
    /**
     * rolls the 3 die and stores the values in the dice array.
     * 
     */
    public void roll() {
        for (int i = 0; i < numDice; i++) {
            dice[i] = new Dice();
            dice[i].roll();
            System.out.println(dice[i].toString());
            
        }
        numRolls++;
    }

    
    /**
     * Returns the number of rolls.
     * 
     * @return numRolls
     */
    public int getNumRolls() {
        return numRolls;
    }
    

    /**
     * Returns the values of all dice in the box.
     * 
     * @return dice
     */
    public Dice[] getDiceValues() {

        return dice;
    }
    
    /**
     * takes the round in which the player is playing in 
     * 
     * @param playRound
     */
    public void setPlayRound(int playRound) {
        this.playRound = playRound;
    }
    
    /**
     * checks the value of points for the round in which the player is playing.
     * using the values of the dice in the box.
     * @return points
     */
    public int getPoints() {
        int count = 0;
        for (int i = 0; i < numDice; i++) {
            if (dice[i].getFaceValue() == playRound) {
                count++;
            }
        }
        if (count == numDice) {
            System.out.println("you get 21 points");
            return 21;
        }
        else if (count > 0) {
            System.out.println("you get " + count + " points keep rolling");
            return count;
        }
        else {
            int allOnes = 0;
            for (int i = 0; i < numDice; i++) {
                if (dice[i].getFaceValue() == 1) {
                    allOnes++;
                }
            }
            if(allOnes == numDice) {
                System.out.println("you get 5 more points, keep rolling");
                return 5;
            }
            else {
                System.out.println("you get 0 points, pass to next player");
                
            }
            
        }
        return 0;
    }


}
