package com.stockers.main;

import com.stockers.stocks.StockTracker;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Take input for no of companies
        System.out.println("Enter the no of companies");
        int noOfCompanies = sc.nextInt();

        double[] stockPrices = new double[noOfCompanies];
        boolean[] stockPriceStatus = new boolean[noOfCompanies];
        for (int i = 0; i < noOfCompanies; i++) {
            //Take input of stock price for each company
            System.out.println("Enter current stock price of the company " + (i + 1));
            stockPrices[i] = sc.nextDouble();

            //Take input of status of stock price compare to yesterday's
            System.out.println("Whether company's stock price rose today compare to yesterday?");
            stockPriceStatus[i] = sc.nextBoolean();
        }

        while (true) {
            //Show Operation list
            System.out.println("""
                    
                    -----------------------------------------------
                    Enter the operation that you want to perform
                    1. Display the companies stock prices in ascending order
                    2. Display the companies stock prices in descending order
                    3. Display the total no of companies for which stock prices rose today
                    4. Display the total no of companies for which stock prices declined today
                    5. Search a specific stock price
                    6. press 0 to exit
                    -----------------------------------------------""");

            int operation = sc.nextInt();

            if (operation == 0) {
                //exit application
                break;
            }

            //initializing StockTrackHelper
            StockTracker stockTracker = new StockTracker(stockPrices, stockPriceStatus);
            switch (operation) {
                case 1 ->
                        //call display stock price asc
                        stockTracker.showStocks(true);
                case 2 ->
                        //call display stock price desc
                        stockTracker.showStocks(false);
                case 3 ->
                        //call display count of stock rose today
                        stockTracker.showNoOfCompaniesStockRose();
                case 4 ->
                        //call display count of stock declined today
                        stockTracker.showNoOfCompaniesStockDeclined();
                case 5 -> {
                    System.out.println("enter the key value");
                    var searchValue = sc.nextDouble();
                    stockTracker.searchStockPrice(searchValue);
                }
                //call Search operation
                default -> System.out.println("Invalid operation input");
            }
        }
        System.out.println("Exited successfully");
    }
}
