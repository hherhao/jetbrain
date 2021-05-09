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

        while (true) {
            System.out.println();
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("0. Exit");
            int val = scanner.nextInt();
            if (val == 1) {
                Show_seats(twoDimArray);
            } else if (val == 2) {
                Buy_ticket(twoDimArray);
            } else if (val == 0) {
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

                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter a row number:");
                int h3 = scanner.nextInt();
                System.out.println("Enter a seat number in that row:");
                int h4 = scanner.nextInt();
                int h1=twoDimArray.length;
                int h2=twoDimArray[1].length;

                if (h1 * h2 <= 60) {
                    System.out.println("Ticket price: $10");
                } else if (h3 <= (h1 / 2)) {
                    System.out.println("Ticket price: $10");
                } else {
                    System.out.println("Ticket price: $8");
                }

                System.out.println();
                twoDimArray[h3-1][h4-1] = "B";


            }


}