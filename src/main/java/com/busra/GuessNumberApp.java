package com.busra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GuessNumberApp {
    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);

        int numberOfPlayer = getNumberOfPlayer();
        int[] producedNumbers = createRandomNumbers(numberOfPlayer);

        int[] step = new int[numberOfPlayer];
        boolean[] isGuessed = new boolean[numberOfPlayer];

        for (int user = 0; !isGameOver(isGuessed); user++){
            user = user % numberOfPlayer;
            if (!isGuessed[user]){
                System.out.printf("PLAYER %d Guess the Number: ", user + 1);
                int guessedNumber = kb.nextInt();
                if (guessedNumber == producedNumbers[user]) {
                    step[user]++;
                    isGuessed[user] = true;
                    System.out.printf("Congratulations! You guessed right in %d step.\n", step[user]);
                } else {
                    if (guessedNumber < producedNumbers[user]){
                        step[user]++;
                        System.out.println("Too Low, Try Again...");
                    } else {
                        step[user]++;
                        System.out.println("Too High, Try Again...");
                    }
                }

            }
        }
    }

    public static boolean isGameOver(boolean[] userStatus){
        boolean result = true;
        for (boolean status : userStatus) {
            result = result & status;
        }

        return result;
    }

    public static int[] createRandomNumbers(int numberOfPlayer){
        int[] producedNumbers = new int[numberOfPlayer];
        for (int i = 0; i < producedNumbers.length; i++) {
            producedNumbers[i] = (int) (Math.random() * 101);
        }
        return producedNumbers;
    }

    public static int getNumberOfPlayer(){
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter the number of player: ");
        int numberOfPlayer = Integer.parseInt(kb.nextLine());
        return numberOfPlayer;
    }

}