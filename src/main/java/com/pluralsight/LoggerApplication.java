package com.pluralsight;

import java.io.*;
import java.util.Scanner;


public class LoggerApplication {
    public static void main(String[] args) {
        //call log to :started application

        Scanner myScanner = new Scanner(System.in);
        String userInput;

        do{
            System.out.print("Enter a search term (X or x to exit): ");
            userInput = myScanner.nextLine();
            //call log to -- Searched...
            System.out.println("Sorry but no WIFI D:");

            if(userInput.equalsIgnoreCase("x")){
                break;
            }

        } while(true);
        //call log: exited program

        //need to loop the menu
        //need a date import

    }

    public static void userLogger() {
        //Actions to log
        // Launching Application
        //terms searched
        //exiting application

        try{
            FileWriter writer = new FileWriter( "src/main/resources/logs.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
