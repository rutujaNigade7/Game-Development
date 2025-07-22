package org.JavaApplication;
import java.util.*;

// This class is a placeholder for the Tic-Tac-Toe game implementation.
public class GameImplementation {

    static String[] board;
    static String turn;

    //Print board
    static void printBoard() {
        System.out.println("Current Board:");
        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("---------");
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("---------");
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
    }

    //logic to check winner
    static String checkWinner() {
        String line = null;

        for(int i=0;i<8;i++) {
            switch (i) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }
            if(line.equals("XXX")) {
                return "X"; // X wins
            } else if(line.equals("OOO")) {
                return "O"; // O wins
            }
        }

        for(int i=0; i<9; i++) {
            if(Arrays.asList(board).contains(String.valueOf(i+1))) {
                break;
            } else if(i == 8) {
                return "draw"; // No winner, it's a draw
            }
        }

        System.out.println(turn + "'s turn; enter a slot number to place in:");
        return null;
    }
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        board = new String[9];
        turn = "X";
        String winner = null;

        System.out.println("Welcome to Tic Tac Toe Game");

        for(int i=0;i<9;i++){
            board[i] = String.valueOf(i+1);
        }

        printBoard();

        System.out.println("Game starts by player X, enter the slot number to place in : ");

        while(winner == null) {
            int numInput;
            try {
                numInput = sc.nextInt();
                if(!(numInput > 0 && numInput < 9)) {
                    System.out.println("Invalid input. Please enter a number between 1 and 9.");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 9.");
                sc.next(); // Clear the invalid input
                continue;
            }

            if(board[numInput-1].equals(String.valueOf(numInput))){
                board[numInput-1] = turn;

                if(turn.equals("X")) {
                    turn = "O";
                } else {
                    turn = "X";
                }

                printBoard();
                winner = checkWinner();

            }else{
                System.out.println("Slot already taken. Choose another slot.");
                continue;
            }
        } // while loop ends

        if(winner == "draw") {
            System.out.println("It's a draw!");
        } else {
            System.out.println("Congratulations! " + winner + " has won the game!");
        }

        sc.close();
    }
}
