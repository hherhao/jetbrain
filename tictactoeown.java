//package tictactoe;
import java.net.PortUnreachableException;


import java.util.*;

public class Main {
    public static void main(String[] args) {

//        System.out.println("Enter cells:");
        Scanner scanner = new Scanner(System.in);
//        String inputString = scanner.nextLine();
//        char myChar[] = inputString.toCharArray();
//        for (int i=0 ;i<=8;i++){
//            if(myChar[i]=='_'){
//                myChar[i]=' ';
//
//            }
//        }
        System.out.println("---------");
        System.out.println("|       |");
        System.out.println("|       |");
        System.out.println("|       |");
        System.out.println("---------");
        //        System.out.println("| " + myChar[3] + " " + myChar[4] + " " + myChar[5] + " |");
//        System.out.println("| " + myChar[6] + " " + myChar[7] + " " + myChar[8] + " |");
        String inputString = "         ";
        char myChar[] = inputString.toCharArray();

        int[][] twoDimArray = new int[3][3];
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                twoDimArray[i][j] = myChar[count];

                count++;
            }
        }
        int evencount=0;
        while (true) {
            while (true) {
                System.out.println("Enter the coordinates:");
                String test = scanner.nextLine();
                String[] val = test.split(" ");
                if (val.length == 2) {
                    if (Num.isNumeric(val[0]) && Num.isNumeric(val[0])) {
                        int num1 = Integer.parseInt(val[0]);
                        int num2 = Integer.parseInt(val[1]);
                        if ((num1 <= 3 && num1 >= 1) && (num2 <= 3 && num2 >= 1)) {
                            if ((twoDimArray[num1 - 1][num2 - 1] != 88) && (twoDimArray[num1 - 1][num2 - 1] != 79)) {
                                if (evencount%2==0) {
                                    twoDimArray[num1 - 1][num2 - 1] = 88;
                                }
                                else {
                                    twoDimArray[num1 - 1][num2 - 1] = 79;
                                }
                                break;
                            } else {
                                System.out.println("This cell is occupied! Choose another one!");
                            }
                        } else {
                            System.out.println("Coordinates should be from 1 to 3!");
                        }

                    } else {
                        System.out.println("You should enter numbers!");
                    }
                } else {
                    System.out.println("You should enter numbers!");
                }

            }


            System.out.println("---------");
            System.out.println("| " + Character.toString(twoDimArray[0][0]) + " " + Character.toString(twoDimArray[0][1]) + " " + Character.toString(twoDimArray[0][2]) + " |");
            System.out.println("| " + Character.toString(twoDimArray[1][0]) + " " + Character.toString(twoDimArray[1][1]) + " " + Character.toString(twoDimArray[1][2]) + " |");
            System.out.println("| " + Character.toString(twoDimArray[2][0]) + " " + Character.toString(twoDimArray[2][1]) + " " + Character.toString(twoDimArray[2][2]) + " |");
            System.out.println("---------");
            evencount++;
            if ((countGame.xLine(twoDimArray)&&countGame.oLine(twoDimArray))||(countGame.numXOdiff(twoDimArray)>=2)){
            }
            else if (!countGame.hasEmpty(twoDimArray)&&!countGame.oLine(twoDimArray)&&!countGame.xLine(twoDimArray)){
                System.out.println("Draw");
                break;
            }
            else if (countGame.hasEmpty(twoDimArray)&&!countGame.oLine(twoDimArray)&&!countGame.xLine(twoDimArray)){
            }
            else if (countGame.oLine(twoDimArray)){
                System.out.println("O wins");
                break;
            }
            else if (countGame.xLine(twoDimArray)){
                System.out.println("X wins");
                break;
            }

        }
    }
}

class Num{
    public static boolean isNumeric(String str){
        for(int i=str.length();--i>=0;){
            int chr=str.charAt(i);
            if(chr<48 || chr>57)
                return false;
        }
        return true;
    }

}


class countGame {
    public static boolean hasEmpty(int[][] twoDimArray) {
        boolean val=false;
        for(int i=0;i <3;i ++){
            for (int j=0;j<3;j++){
                if (twoDimArray[i][j]==32) {
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































