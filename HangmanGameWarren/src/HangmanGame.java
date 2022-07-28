import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HangmanGame {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("C:\\Users\\wbche\\eclipse-workspace\\HangmanGameWarren\\src\\words_alpha.txt"));
        Scanner input = new Scanner(System.in);

        List<String> word_bank = new ArrayList<>();

        while (scanner.hasNext()){
            word_bank.add(scanner.nextLine());
        }

        Random rand = new Random();

        String chosen_word =  word_bank.get(rand.nextInt(word_bank.size()));

        List<String> wrongLetterGuesses = new ArrayList();
        List<Character> playerGuesses = new ArrayList<>();

        int lives = 0;

        System.out.println("--------Welcome to Hangman!-------");
        System.out.println("A Random word has been chosen from the dictionary.");
        System.out.println("Guess a letter that the chosen word contains:");
        System.out.println(chosen_word); //This output is the random word, this is meant for debugging purposes only

        String playerletterGuess;

        while(true){
            printHangedMan(lives);
            //System.out.println("");
            playerletterGuess = getPlayerletterGuess(input);

            //This char allows the player letter guess to be flexible throughout the program

            if(lives >= 6){
                System.out.println("You have ran out of lives!");
                System.out.println("The word was: " + chosen_word);
                break;
            }

            printCurrentChosenWordState(chosen_word, playerGuesses);

            if(!getPlayerGuess(playerletterGuess, chosen_word, playerGuesses)){//(!chosen_word.contains(playerletterGuess)){
                System.out.println("Sorry that letter is not part of the word");
                if(!wrongLetterGuesses.contains(playerletterGuess)){//This if statement prevents duplicates in the wrong guess list
                    wrongLetterGuesses.add(playerletterGuess);
                    lives++;
                }
                else { //(wrongLetterGuesses.contains(playerletterGuess))
                    System.out.println("You have already guessed that letter");
                    System.out.println("Please enter a Letter that is not part of the Previous letter guess list");
                    System.out.println("Previous Letter guesses: " + wrongLetterGuesses);
                    continue;
                }

                System.out.println("Previous Letter guesses: " + wrongLetterGuesses);



            }
            if(printCurrentChosenWordState(chosen_word, playerGuesses)){
                System.out.println("You have guessed the word");
                System.out.println("You Win!!");
                break;
            }



        }



    }

    private static String getPlayerletterGuess(Scanner input) {
        String playerletterGuess;
        System.out.println("Please enter a letter:");
        playerletterGuess = input.next();
        return playerletterGuess;
    }

    private static boolean printCurrentChosenWordState(String chosen_word, List<Character> playerGuesses) {
        int correctCount = 0;
        for (int i = 0; i < chosen_word.length(); i++) {
            if (playerGuesses.contains(chosen_word.charAt(i))) {
                System.out.print(chosen_word.charAt(i));
                correctCount++;
            } else {
                System.out.print("-");
            }
        }
        System.out.println();

        return (chosen_word.length() == correctCount);

    }


    private static boolean getPlayerGuess(String letterGuess, String chosen_word, List<Character> playerGuesses) {
        playerGuesses.add(letterGuess.charAt(0));// adds the first letter of the string into playerGuess list

        return chosen_word.contains(letterGuess);
    }



    private static void printHangedMan(int lives){
        if (lives == 0) {
            System.out.println("__________");
            System.out.println("|     |");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|__________");
        }
        else if (lives == 1) {
            System.out.println("___________");
            System.out.println("|     |");
            System.out.println("|     o");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|__________");
        }
        else if (lives == 2) {
            System.out.println("___________");
            System.out.println("|     |");
            System.out.println("|     o");
            System.out.println("|     |");
            System.out.println("|     |");
            System.out.println("|");
            System.out.println("|__________");
        }
        else if (lives == 3){
            System.out.println("___________");
            System.out.println("|     |");
            System.out.println("|     o");
            System.out.println("|    \\|");
            System.out.println("|     |");
            System.out.println("|");
            System.out.println("|__________");
        }
        else if (lives == 4){
            System.out.println("___________");
            System.out.println("|     |");
            System.out.println("|     o");
            System.out.println("|    \\|/");
            System.out.println("|     |");
            System.out.println("|    /");
            System.out.println("|__________");
        }
        else if (lives == 5){
            System.out.println("___________");
            System.out.println("|     |");
            System.out.println("|     o");
            System.out.println("|    \\|/");
            System.out.println("|     |");
            System.out.println("|    / \\");
            System.out.println("___________");
        }
        else if (lives == 6){
            System.out.println("-----------");
            System.out.println("|      |");
            System.out.println("|      o");
            System.out.println("|     \\|/");
            System.out.println("|      |");
            System.out.println("|     / \\");
            System.out.println("___________");
        }


    }
}
