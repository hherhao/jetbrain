package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.play();
    }
}

class TicTacToe {
    final Scanner s = new Scanner(System.in);
    final int INPUT_LENGTH = 9;
    final int S = 3;
    char[][] board;
    int x;
    int y;
    
    TicTacToe() {
        board = new char[S][S]; //if field is '\0' tests will fail..
        for (int i = 0; i < S; i++)
            for (int j = 0; j < S; j++)
                board[i][j] = ' ';
    }
    
    void printBoardWithFrame() {
        System.out.println("---------");
        for (int i = 0; i < S; i++) {
            for (int j = -1; j < S + 1; j++) {
                if (j == -1 || j == S)
                    System.out.print("| ");
                else 
                    System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------");
    }
    
    void play() {
        printBoardWithFrame();
        byte s = -4;
        boolean xTurn = true;
        while (!gameFinished(s)) {
            validateUserInput();
            if (xTurn) {
                board[x-1][y-1] = 'X';
                xTurn = false;
            } else {
                board[x-1][y-1] = 'O';
                xTurn = true;
            }
            printBoardWithFrame();
            s = verifyGameState();
        }
        printGameState();
    }
    
    void validateUserInput() {
        byte result = -4;
         while (result != 1) {
            System.out.print("Enter the coordinates: ");
            result = verifyUserInput();
            printInfo(result);
        }
    }
    
    byte verifyUserInput(){
        if (!s.hasNextInt())
            return -2;
        else {
             x = s.nextInt();
            y = s.nextInt();
            if (!(1 <= x && x <= 3 && 1 <= y && y <= 3))
                return -1;
            else if (board[x-1][y-1] == 'X' || board[x-1][y-1] == 'O')
                return 0;
            else 
                return 1;     
        }
    }
    
    void printInfo(int result) {
        String msg = "";
        switch (result) {
            case -2 :
                msg = "You should enter numbers!";
                break;
            case -1 :
                msg = "Coordinates should be from 1 to 3!";
                break;
            case 0 :
                msg = "This cell is occupied! Choose another one!";
                break;                
        }
        if (!msg.equals(""))
            System.out.println(msg);
    }
    
    boolean gameFinished(int s) {
        return (s == 0 || s == 1 || s == 2 );
    }
    
    void printGameState() {
        String state = getGameState();
        System.out.println(state);
    }
    
    String getGameState() {
        byte state = verifyGameState();
        switch (state) {
            case -1 :
                return "Game not finished";
            case 0 :
                return "Draw";
            case 1 :
                return "X wins";
            case 2 : 
                return "O wins";
        }
        return "";
    }
    
    byte verifyGameState() {
        int xRows = 0;
        int oRows = 0;
        int xCols = 0;
        int oCols = 0;
        
        int x = 0;
        int o = 0;
        int e = 0;

        for (int i = 0; i < S; i++) {
            xRows = (sameCharInARow(i, 'X')) ? xRows + 1 : xRows;
            oRows = (sameCharInARow(i, 'O')) ? oRows + 1 : oRows;
            for (int j = 0; j < S; j++) {
                // i == 0 --> check each column only once
                xCols = i == 0 && sameCharInCol(j, 'X') ? xCols + 1 : xCols;
                oCols = i == 0 && sameCharInCol(j, 'O') ? oCols + 1 : oCols;
                x = (board[i][j] == 'X') ? x + 1 : x;
                o = (board[i][j] == 'O') ? o + 1 : o;
                e = (board[i][j] == ' ') ? e + 1 : e;
            }
        }
        return getState(x, o, e, xRows, oRows, xCols, oCols);
    }
    
    byte getState(int x, int o, int e, int xRows, int oRows, int xCols, int oCols) {
        if (xRows == 1 || xCols == 1 || sameCharDiagonal('X'))
            return 1;           // X wins
        else if (oRows == 1 || oCols == 1 || sameCharDiagonal('O'))
            return 2;           // O wins
        else if (e > 0)    
            return -1;          // Game not finished
        else
            return 0;           // draw - no empty place 
    }
    
    boolean sameCharInARow(int r, char c) {
        return board[r][0] == c && board[r][1] == c && board[r][2] == c; 
    }
    
    boolean sameCharInCol(int col, char c) {
        return board[0][col] == c && board[1][col] == c && board[2][col] == c; 
    }    

    boolean sameCharDiagonal(char c) {
        return board[0][0] == c && board[1][1] == c && board[2][2] == c ||
            board[0][2] == c && board[1][1] == c && board[2][0] == c;
    }
}
