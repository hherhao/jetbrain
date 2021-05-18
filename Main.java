//package tictactoe;
import java.net.PortUnreachableException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here

        // System.out.println("X O X");
        // System.out.println("O X O");
        // System.out.println("X X O");
        System.out.println("Enter cells:");
        Scanner scanner = new Scanner(System.in);
        String inputString=scanner.nextLine();
        // System.out.println(inputString);
        // String myString="abcd";
        char myChar[]=inputString.toCharArray();
        System.out.println("---------");
        System.out.println("| "+myChar[0]+" "+myChar[1]+" "+myChar[2]+" |");
        System.out.println("| "+myChar[3]+" "+myChar[4]+" "+myChar[5]+" |");
        System.out.println("| "+myChar[6]+" "+myChar[7]+" "+myChar[8]+" |");
        System.out.println("---------");

        int [][] twoDimArray = new int[3][3];
        int count=0;
        for(int i=0;i <3;i ++){
            for (int j=0;j<3;j++){
                twoDimArray[i][j]=myChar[count];
              //  System.out.println( twoDimArray[i][j]);
                count++;
            }
        }
//        System.out.println(countGame.hasEmpty(twoDimArray));
//        System.out.println(countGame.numXOdiff(twoDimArray));
//        System.out.println(countGame.xLine(twoDimArray));
//        System.out.println(countGame.oLine(twoDimArray))
        if ((countGame.xLine(twoDimArray)&&countGame.oLine(twoDimArray))||(countGame.numXOdiff(twoDimArray)>=2)){
            System.out.println("Impossible");
        }
        else if (!countGame.hasEmpty(twoDimArray)&&!countGame.oLine(twoDimArray)&&!countGame.xLine(twoDimArray)){
            System.out.println("Draw");
        }
        else if (countGame.hasEmpty(twoDimArray)&&!countGame.oLine(twoDimArray)&&!countGame.xLine(twoDimArray)){
            System.out.println("Game not finished");
        }
        else if (countGame.oLine(twoDimArray)){
            System.out.println("O wins");
        }
        else if (countGame.xLine(twoDimArray)){
            System.out.println("X wins");
        }










    }
}

class countGame {
    public static boolean hasEmpty(int[][] twoDimArray) {
        boolean val=false;
        for(int i=0;i <3;i ++){
            for (int j=0;j<3;j++){
                if (twoDimArray[i][j]==95) {
                    val=true;
                    break;
                }
                }
            }
        return val;
        }
    public static int numXOdiff(int[][] twoDimArray) {
        int numX=0;
        int numO=0;
        for(int i=0;i <3;i ++){
            for (int j=0;j<3;j++){
                if (twoDimArray[i][j]==88) {
                    numX++;
                }
                if (twoDimArray[i][j]==79) {
                    numO++;
                }
            }
        }
        return Math.abs(numO-numX);
    }

    public static boolean xLine(int[][] twoDimArray){
        boolean val =false;
        for (int i=0;i<3;i++){
            if(twoDimArray[i][0]+twoDimArray[i][1]+twoDimArray[i][2]==264||twoDimArray[0][i]+twoDimArray[1][i]+twoDimArray[2][i]==264){
                val=true;
                break;
            }
        }
        if (twoDimArray[0][0]+twoDimArray[1][1]+twoDimArray[2][2]==264||twoDimArray[0][2]+twoDimArray[1][1]+twoDimArray[2][0]==264){
            val=true;
        }
        return val;
    }

    public static boolean oLine(int[][] twoDimArray){
        boolean val =false;
        for (int i=0;i<3;i++){
            if(twoDimArray[i][0]+twoDimArray[i][1]+twoDimArray[i][2]==237||twoDimArray[0][i]+twoDimArray[1][i]+twoDimArray[2][i]==237){
                val=true;
                break;
            }
        }
        if (twoDimArray[0][0]+twoDimArray[1][1]+twoDimArray[2][2]==237||twoDimArray[0][2]+twoDimArray[1][1]+twoDimArray[2][0]==237){
            val=true;
        }
        return val;
    }

    }

