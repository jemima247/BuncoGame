package src;


import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Oluwatobi Jemima Alabi
 */
public class BuncoGame {
    private Player player1;
    private Player player2;
    private DiceBox diceBox;
    private Scanner input;
    private static ArrayList<String> winners = new ArrayList<String>();
    
    /**
     * Constructor for the BuncoGame class
     */
   public BuncoGame() {
       
       try{
            input = new Scanner(System.in);
            System.out.println("Welcome to Bunco! Input your name");
            String player1Name = input.nextLine();
            player1 = new Player(player1Name, input);
       }
       catch(Exception e){
           System.out.println("Error: " + e);
       }
       player2 = new Player();
       diceBox = new DiceBox();
    }

    /**
     * A method to chose the player who will go first
     * @return the player who will go first
     * @param round which round the game is on
     */
    public Player goesFirst(int round){
        if(round == 1){
            Dice dice1 = new Dice();
            Dice dice2 = new Dice();
            dice1.roll();
            dice2.roll();
            int roll1 = dice1.getFaceValue();
            int roll2 = dice2.getFaceValue();
            if (roll1 > roll2){
                return player1;
            }
            else {
                return player2;
            }

        }
        else{
            if(player1.getScore() > player2.getScore()){
                return player1;
            }
            else{
                return player2;
            }
        }

    }


    /**
     * A method to play the game
     * @param round which round the game is on
     */

    public void play(int round) {
        Player currentPlayer = goesFirst(round);
        System.out.println("Player " + currentPlayer.getName() + " is going first");

        String outcome = currentPlayer.playRound(round, diceBox);
       
        if(outcome.equals("Bunco")){
            System.out.println("Round " + round + " over");
        }
        else if(outcome.equals("End")){
            if(currentPlayer == player1){
                System.out.println(player2.playRound(round, diceBox));
                System.out.println("Round " + round + " over");
            }
            else{
                System.out.println(player1.playRound(round, diceBox));
                System.out.println("Round " + round + " over");
            }
            
        }
        
    }
        

    /**
     * This is the main method
     * it runs the game
     *
     * @param args the command line arguments
     */
            
    public static void main(String[] args) {
        BuncoGame game = new BuncoGame();

        int gamePlayed = 0;
        System.out.println("Do you want to play a game? yes/no");
        String answer = game.input.nextLine();
        while(answer.equals("yes")){
            gamePlayed++;
            game.player1.resetScore();
            game.player2.resetScore();
            

            for (int i = 1; i <= 6; i++) {
                game.play(i);
            }
            if(game.player1.getScore() > game.player2.getScore()){
                winners.add(game.player1.getName());
                System.out.println(gamePlayed + " games played so far");
                for(int i = 0; i < gamePlayed; i++){
                    int x = i + 1;
                    System.out.println(winners.get(i) + " won " + " game" + x);
                }
                System.out.println(game.player1.getName() + " : " + game.player1.getScore());
                System.out.println(game.player2.getName() + " : " + game.player2.getScore());
                System.out.println("Player 1 " + game.player1.getName() + " wins!");
                

            }
            else{
                winners.add(game.player2.getName());
                System.out.println(gamePlayed + " games played so far");
                for(int i = 0; i < gamePlayed; i++){
                    System.out.println(winners.get(i) + " won " + " game" + i+1);
                }
                System.out.println(game.player1.getName() + " : " + game.player1.getScore());
                System.out.println(game.player2.getName() + " : " + game.player2.getScore());
                System.out.println("Player 2 " + game.player2.getName() + " wins!");
            }
            System.out.println("Game over! Do you want to play another game? yes/no");
            answer = game.input.nextLine();
        }
        game.input.close();

    }


}