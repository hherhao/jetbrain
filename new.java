import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Enter cells:");
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        char myChar[] = inputString.toCharArray();
        for (int i=0 ;i<=8;i++){
            if(myChar[i]=='_'){
                myChar[i]=' ';

            }
        }
        System.out.println("---------");
        System.out.println("| " + myChar[0] + " " + myChar[1] + " " + myChar[2] + " |");
        System.out.println("| " + myChar[3] + " " + myChar[4] + " " + myChar[5] + " |");
        System.out.println("| " + myChar[6] + " " + myChar[7] + " " + myChar[8] + " |");
        System.out.println("---------");

        int[][] twoDimArray = new int[3][3];
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                twoDimArray[i][j] = myChar[count];

                count++;
            }
        }
        while (true) {
            System.out.println("Enter the coordinates:");
            String test = scanner.nextLine();
            String [] val =test.split(" ");
//            System.out.println(val[0]);
//            System.out.println(val[1]);
//            System.out.println(val1);
//            System.out.println(val2);
//            System.out.println(Num.isNumeric(val1));
//            System.out.println(Num.isNumeric(val2));
            if (val.length==2) {
                if (Num.isNumeric(val[0]) && Num.isNumeric(val[0])) {
                    int num1 = Integer.parseInt(val[0]);
                    int num2 = Integer.parseInt(val[1]);
                    if ((num1 <= 3 && num1 >= 1) && (num2 <= 3 && num2 >= 1)) {
                        if ((twoDimArray[num1 - 1][num2 - 1] != 88)&&(twoDimArray[num1 - 1][num2 - 1] != 79)) {
                            twoDimArray[num1 - 1][num2 - 1] = 88;
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
            }
            else {
                System.out.println("You should enter numbers!");
            }

        }

//        System.out.println("---------");
//        System.out.println("| " + twoDimArray[0][0] + " " + twoDimArray[0][1] + " " + twoDimArray[0][2] + " |");
//        System.out.println("| " + twoDimArray[1][0] + " " + twoDimArray[1][1] + " " + twoDimArray[1][2] + " |");
//        System.out.println("| " + twoDimArray[2][0] + " " + twoDimArray[2][1] + " " + twoDimArray[2][2] + " |");
//        System.out.println("---------");

        System.out.println("---------");
        System.out.println("| " + Character.toString(twoDimArray[0][0]) + " " + Character.toString(twoDimArray[0][1]) + " " + Character.toString(twoDimArray[0][2]) + " |");
        System.out.println("| " + Character.toString(twoDimArray[1][0]) + " " + Character.toString(twoDimArray[1][1]) + " " + Character.toString(twoDimArray[1][2]) + " |");
        System.out.println("| " + Character.toString(twoDimArray[2][0]) + " " + Character.toString(twoDimArray[2][1]) + " " + Character.toString(twoDimArray[2][2]) + " |");
        System.out.println("---------");
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
