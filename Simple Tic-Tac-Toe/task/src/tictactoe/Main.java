package tictactoe;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static String getInitialBoard() {
        System.out.println("Enter cells: ");
        String userInput = scanner.nextLine();
        return userInput;
    }

    static void displayInitialBoard(String[][] board) {
        board[0][0] = "|";
        board[0][4] = "|";
        board[1][0] = "|";
        board[1][4] = "|";
        board[2][0] = "|";
        board[2][4] = "|";

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == null) {
                    board[i][j] = " ";
                }
            }
        }

        System.out.println("---------");
        for (String[] row : board) {
            for (String column : row) {
                System.out.print(column + " ");
            }
            System.out.println();
        }
        System.out.println("---------");
    }

    static void getCoordinates(boolean xTurn, String[][] board) {
        System.out.println("Enter the coordinates: ");
        String coordinates = scanner.nextLine();
        checkValidCoordinates(coordinates,xTurn,board);
    }

    static void checkValidCoordinates(String coordinates, boolean xTurn, String[][] board) {
            String[] splitCoordinates = coordinates.split(" ");
        try {
            int coordinateOne = Integer.parseInt(splitCoordinates[0]);
            int coordinateTwo = Integer.parseInt(splitCoordinates[1]);
            if ((coordinateOne < 1 || coordinateOne > 3) || (coordinateTwo < 1 || coordinateTwo > 3)) {
                System.out.println("Coordinates should be from 1 to 3!");
                getCoordinates(xTurn, board);
            } else if (board[coordinateOne - 1][coordinateTwo].equals("X") || board[coordinateOne - 1][coordinateTwo].equals("O")) {
                System.out.println("This cell is occupied! Choose another one!");
                getCoordinates(xTurn, board);
            } else {
                displayUpdatedBoard(coordinateOne, coordinateTwo, xTurn, board);
            }
        } catch (Exception e) {
            System.out.println("You should enter numbers!");
            getCoordinates(xTurn, board);
        }
    }

    static void displayUpdatedBoard(int coordinateOne, int coordinateTwo, boolean xTurn, String[][] board) {
        if (xTurn) {
            board[coordinateOne - 1][coordinateTwo] = "X";
        } else {
            board[coordinateOne - 1][coordinateTwo] = "O";
        }
        System.out.println("---------");
        for (String[] row : board) {
            for (String column : row) {
                System.out.print(column + " ");
            }
            System.out.println();
        }
        System.out.println("---------");
    }

    static boolean checkForWinner(boolean xTurn, String[][] board) {
        boolean xRowsWinner = checkRowsX(board);
        boolean oRowsWinner = checkRowsO(board);
        boolean xColumnWinner = checkColumnsX(board);
        boolean oColumnWinner = checkColumnsO(board);
        boolean xDiagonalWinner = checkDiagonalsX(board);
        boolean oDiagonalWinner = checkDiagonalsO(board);
        return xRowsWinner || oRowsWinner || xColumnWinner || oColumnWinner || xDiagonalWinner || oDiagonalWinner;
    }

    static boolean checkRowsX(String[][] board) {
        boolean xWinnerRow1 = board[0][1] == "X" && board[0][2] == "X" && board[0][3] == "X";
        boolean xWinnerRow2 = board[1][1] == "X" && board[1][2] == "X" && board[1][3] == "X";
        boolean xWinnerRow3 = board[2][1] == "X" && board[2][2] == "X" && board[2][3] == "X";
        if (xWinnerRow1 || xWinnerRow2 || xWinnerRow3) {
            System.out.println("X wins");
            return true;
        } else {
            return false;
        }
    }

    static boolean checkRowsO(String[][] board) {
        boolean oWinnerRow1 = board[0][1] == "O" && board[0][2] == "O" && board[0][3] == "O";
        boolean oWinnerRow2 = board[1][1] == "O" && board[1][2] == "O" && board[1][3] == "O";
        boolean oWinnerRow3 = board[2][1] == "O" && board[2][2] == "O" && board[2][3] == "O";
        if (oWinnerRow1 || oWinnerRow2 || oWinnerRow3) {
            System.out.println("O wins");
            return true;
        } else {
            return false;
        }
    }

    static boolean checkColumnsX(String[][] board) {
        boolean xWinnerColumn1 = board[0][1] == "X" && board[1][1] == "X" && board[2][1] == "X";
        boolean xWinnerColumn2 = board[0][2] == "X" && board[1][2] == "X" && board[2][2] == "X";
        boolean xWinnerColumn3 = board[0][3] == "X" && board[1][3] == "X" && board[2][3] == "X";
        if (xWinnerColumn1 || xWinnerColumn2 || xWinnerColumn3) {
            System.out.println("X wins");
            return true;
        } else {
            return false;
        }
    }

    static boolean checkColumnsO(String[][] board) {
        boolean oWinnerColumn1 = board[0][1] == "O" && board[1][1] == "O" && board[2][1] == "O";
        boolean oWinnerColumn2 = board[0][2] == "O" && board[1][2] == "O" && board[2][2] == "O";
        boolean oWinnerColumn3 = board[0][3] == "O" && board[1][3] == "O" && board[2][3] == "O";
        if (oWinnerColumn1 || oWinnerColumn2 || oWinnerColumn3) {
            System.out.println("O wins");
            return true;
        } else {
            return false;
        }
    }

    static boolean checkDiagonalsX(String[][] board) {
        boolean xWinnerDiagonal1 = board[0][1] == "X" && board[1][2] == "X" && board[2][3] == "X";
        boolean xWinnerDiagonal2 = board[0][3] == "X" && board[1][2] == "X" && board[2][1] == "X";
        if (xWinnerDiagonal1 || xWinnerDiagonal2) {
            System.out.println("X wins");
            return true;
        } else {
            return false;
        }
    }

    static boolean checkDiagonalsO(String[][] board) {
        boolean oWinnerDiagonal1 = board[0][1] == "O" && board[1][2] == "O" && board[2][3] == "O";
        boolean oWinnerDiagonal2 = board[0][3] == "O" && board[1][2] == "O" && board[2][1] == "O";
        if (oWinnerDiagonal1 || oWinnerDiagonal2) {
            System.out.println("O wins");
            return true;
        } else {
            return false;
        }
    }

    static void playGame() {
        boolean gameFinished = false;
        boolean xTurn = true;
        String[][] board = new String[3][5];
        displayInitialBoard(board);
        while (!gameFinished) {
            getCoordinates(xTurn, board);
            boolean winner = checkForWinner(xTurn, board);
            if (winner == true) {
                gameFinished = true;
            }
            xTurn = !xTurn;
        }
    }




    public static void main(String[] args) {
        // write your code here
        playGame();
    }
}