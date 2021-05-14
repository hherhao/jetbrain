//package cinema;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        // Write your code here
        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter the number of rows:");
        int h1 = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int h2 = scanner.nextInt();

        String[][] twoDimArray = new String[h1][h2];
        for (int i = 0; i < twoDimArray.length; i++) {
            for (int j = 0; j < twoDimArray[i].length; j++) {
                twoDimArray[i][j] = "S";
            }
        }

//        Buy_ticket(twoDimArray);
//        Show_seats(twoDimArray);


        while (true) {
            System.out.println();
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            int val = scanner.nextInt();
            if (val == 1) {
                Show_seats(twoDimArray);
            } else if (val == 2) {
                Buy_ticket(twoDimArray);
            }else if (val ==3){
                Statistics(twoDimArray);
            }
            else if (val == 0) {
                break;
            }
        }
    }


    public static void Show_seats (String[][]twoDimArray){

        System.out.println("Cinema:");
        System.out.print("  ");

        for (int i = 1; i <= twoDimArray[1].length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < twoDimArray.length; i++) {
            for (int j = 0; j < twoDimArray[i].length + 1; j++) {
                if (j == 0) {
                    System.out.print(i + 1 + " ");
                } else {
                    System.out.print(twoDimArray[i][j - 1] + " ");

                }
            }
            System.out.println();
        }
    }


    public static void Buy_ticket(String[][] twoDimArray) {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a row number:");
            int h3 = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            int h4 = scanner.nextInt();
            int h1 = twoDimArray.length;
            int h2 = twoDimArray[1].length;

            if ((h3 <= h1  && h4 <= h2 ) && (twoDimArray[h3 - 1][h4 - 1] != "B")) {
                twoDimArray[h3 - 1][h4 - 1] = "B";
                if (h1 * h2 <= 60) {
                    System.out.println("Ticket price: $10");
                } else if (h3 <= (h1 / 2)) {
                    System.out.println("Ticket price: $10");
                } else {
                    System.out.println("Ticket price: $8");
                }

                System.out.println();
                break;
            } else if (!(h3 <= h1  && h4 <= h2 )) {
                System.out.println("Wrong input!");
                System.out.println();
            } else if (twoDimArray[h3 - 1][h4 - 1] == "B") {
                System.out.println("That ticket has already been purchased!");
                System.out.println();
            }
        }
    }

    public static void Statistics(String[][] twoDimArray) {
        int ticketnum=0;
        int currentincome=0;
        int totalincome=0;
        double percent = 0;
        int h1=twoDimArray.length;
        int h2=twoDimArray[1].length;
        if(h1*h2<=60) {
            totalincome = 10 * h1 * h2;
        }
        else {
            totalincome=(h1/2)*h2*10+(h1-h1/2)*h2*8;
        }
        for (int i = 0; i < twoDimArray.length; i++) {
            for (int j = 0; j < twoDimArray[i].length ; j++) {
                if(twoDimArray[i][j]=="B"){
                    ticketnum+=1;
                    if (twoDimArray.length*twoDimArray[1].length>60&&(i>(twoDimArray.length/ 2)-1)){
                        currentincome+=8;
                    }
                    else {
                        currentincome+=10;
                    }
                }
            }
        }
        double ticket = ticketnum;
        percent=(ticket/(h1*h2))*100;
        System.out.println();
        System.out.printf("Number of purchased tickets: %d%n",ticketnum);
        System.out.printf("Percentage: %.2f%%%n",percent);
        System.out.printf("Current income: $%d%n",currentincome);
        System.out.printf("Total income: $%d%n",totalincome);


    }
//
//        //third part
//
//
//        System.out.println("Cinema:");
//        System.out.print("  ");
//
//        for (int i =1;i <= h2;i++){
//            System.out.print(i +" ");
//        }
//        System.out.println();
//        for (int i = 0; i < h1; i++) {
//            for (int j = 0; j < h2+1; j++) {
//                if (j==0){
//                    System.out.print(i+1 +" ");
//                }
//                else if ((i==h3-1)&&(j==h4)){
//                    System.out.print("B ");
//                }
//                else{
//                    System.out.print("S ");
//
//                }
//            }
//            System.out.println();
//        }






}
