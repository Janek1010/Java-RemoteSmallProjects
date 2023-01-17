package pl.janek;

import java.util.Scanner;

public class Cinema {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[][] cinema;
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();
        cinema = new String[rows][seats];

        initializeCinema(cinema);
        boolean cond = true;
        while (cond) {
            switch (showMenuWithInput()) {
                case 1:
                    printCinema(cinema);
                    break;
                case 2:
                    buyTicket(cinema);
                    break;
                case 3:
                    showStatistics(cinema);
                    break;
                case 0:
                    cond = false;
                    break;
            }
        }
    }

    public static int showMenuWithInput() {
        System.out.println();
        System.out.println("1. Show the seats\n" +
                "2. Buy a ticket\n" +
                "3. Statistics\n" +
                "0. Exit");
        return scanner.nextInt();
    }

    public static void buyTicket(String[][] cinema) {
        System.out.println();
        System.out.println("Enter a row number:");
        int rowCoordinate = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seatCoordinate = scanner.nextInt();
        if (rowCoordinate < 1 || rowCoordinate > cinema.length || seatCoordinate < 1 || seatCoordinate > cinema[0].length) {
            System.out.println("Wrong input!");
            return;
        }
        if (cinema[rowCoordinate - 1][seatCoordinate - 1] == " S") {
            int ticketPrice = 10;
            if (cinema.length * cinema[0].length > 60 && (rowCoordinate > (cinema.length / 2))) {
                ticketPrice = 8;
            }
            System.out.println("Ticket price: $" + ticketPrice);
            cinema[rowCoordinate - 1][seatCoordinate - 1] = " B";
        } else {
            System.out.println("That ticket has already been purchased!");
            buyTicket(cinema);
        }
    }

    public static void initializeCinema(String[][] cinema) {
        for (int i = 0; i < cinema.length; i++) {
            for (int y = 0; y < cinema[0].length; y++) {
                cinema[i][y] = " S";
            }
        }
    }

    public static void printCinema(String[][] cinema) {
        System.out.println();
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 0; i < cinema[0].length; i++) {
            System.out.print(" " + (i + 1));
        }
        System.out.println();
        for (int i = 0; i < cinema.length; i++) {
            System.out.print(i + 1);
            for (int x = 0; x < cinema[0].length; x++) {
                System.out.print(cinema[i][x]);
            }
            System.out.println();
        }
    }

    public static void showStatistics(String[][] cinema) {
        int ticketsAmount = 0;
        int totalIncome;
        int currentIncome = 0;
        int rows = cinema.length;
        int seats = cinema[0].length;
        if (rows * seats > 60) {
            totalIncome = ((rows / 2) * seats * 10) + ((rows - (rows / 2)) * seats * 8);
        }
        else {
            totalIncome = seats * rows * 10;
        }
        for (int i = 0; i < rows; i++) {
            for (int g = 0; g < seats; g++) {
                if (cinema[i][g] == " B") {
                    ticketsAmount++;
                    if (rows * seats > 60){
                        if ( i >= (rows / 2)) {
                            currentIncome += 8;
                        }
                        else {
                            currentIncome += 10;
                        }
                    }
                    else {
                        currentIncome += 10;
                    }
                }
            }
        }
        int max = rows * seats;
        double percentage = ((double )ticketsAmount / (double)max) * 100;
        System.out.printf("Number of purchased tickets: %d\n" +
                "Percentage: %.2f%%\n" +
                "Current income: $%d\n" +
                "Total income: $%d", ticketsAmount, percentage, currentIncome, totalIncome);
    }
}