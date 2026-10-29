package com.pluralsight;

import java.io.*;
import java.util.Scanner;
import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * Search Engine Logger – Exercise 3 | Section 2.2
 *
 * @author Behlul
 */
public class LoggerApplication {
    public static void main(String[] args) {
        //Set the time of user as a variable
        LocalDateTime userTime = LocalDateTime.now();
        LoggerApplication.userLogger(userTime, "launch", ""); //call log to: started application

        Scanner myScanner = new Scanner(System.in);
        String userInput;

        do {
            System.out.print("Enter a search term (X or x to exit): ");
            userInput = myScanner.nextLine();

            LoggerApplication.userLogger(userTime, "search", userInput); //call log to: user searched
            if (userInput.equalsIgnoreCase("x")) {
                break;
            }

            System.out.println("Sorry but no WIFI D:");


        } while (true);
        LoggerApplication.userLogger(userTime, "exit", ""); //call log to: user exit

    }

    public static void userLogger(LocalDateTime userTime, String userAction, String search) {
        // year-day-month --> 2026-04-22
        String yearToMonthFmt = userTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        try {
            FileWriter writer = new FileWriter("src/main/resources/logs.txt", true);
            if (userAction.equals("search")) {
                //output to File.
                System.out.println(yearToMonthFmt + " " + userAction + " : " + search + "\n");
                writer.write(yearToMonthFmt + " " + userAction + " : " + search + "\n");
            } else {
                System.out.println(yearToMonthFmt + " " + userAction);
                writer.write(yearToMonthFmt + " " + userAction + "\n");
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
