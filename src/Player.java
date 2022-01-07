package src;

import java.util.Scanner;

/** 
 * This class represents a player in the game of Bunco.
 * it has a name and a score.
 *
 * @author Oluwatobi Jemima Alabi
 */
public class Player {
    private String name;
    private int score;
    private Scanner input;

    /**
     * Constructor for objects of class Player
     * @param name the name of the player
     */
    public Player(String name, Scanner input) {
        this.name = name;
        this.score = 0;
        this.input = input;
    }

    /**
     * Get the name of the player
     * @return the default name of the player "Computer"
     */
    public Player(){
        this.name = "Computer";
        this.score = 0;
    }

    /**
     * Get the name of the player
     * @return the name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * check the score of the player
     * @return if score is 21
     */
    public boolean isABunco(int points){
        return points == 21;
    }

    /**
     * check the score of the player
     * @return if score of the player is 5
     */
    public boolean isAMiniBunco(int points){
        return points == 5;
    }

    /**
     * plays a round for the player
     * @return if the player wins the round or passes to the next player
     */
    public String playRound(int round, DiceBox diceBox) {
        System.out.println(this.name + " is playing round " + round);
        
        if(!name.equals("Computer")){
            System.out.println("hit enter to play round");
            try {
                
                input.nextLine();
            } catch (Exception e) {
                System.out.println("Error reading input");
            }
        }
        diceBox.roll();
        diceBox.setPlayRound(round);
        int score = diceBox.getPoints();
        this.score += score;
        if (isABunco(score)) {
            return "Bunco!";
        } else if (isAMiniBunco(score)) {
            System.out.println("Mini Bunco! keep playing round");
            return playRound(round, diceBox);
          
        } 
        else if(score > 0){
            System.out.println("keep playing round");
            return playRound(round, diceBox);
        }
        else{
            System.out.println("you lost");
        }
        return "End";
    }

    /**
     * Get the score of the player
     * @return the score of the player
     */
    public int getScore() {
        return score;
    }

    /**
     * Reset the score of the player to 0
     * 
     */
    public void resetScore() {
        this.score = 0;
    }

    

}
