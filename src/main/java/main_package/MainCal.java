package main_package;

import currency.*;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The class is for determining the requests from the user and showing the results.
 */
public class MainCal {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to currency converter");
        selectedchoice();
    }

    public static ArrayList<Double> userresultes = new ArrayList<Double>();
    List<List<String>> resultConversionFlow = new ArrayList<List<String>>();

    //    user input USD--ILS or ILD--USD
    public static void selectedchoice() throws IOException {
        Scanner firstscreen = new Scanner(System.in);
        System.out.println("Please choose an option (1/2):"
                + "\n" + "1. Dollars to Shekels" + "\n" + "2. Shekels to Dollars");
        if (!firstscreen.hasNextInt()) {
            System.out.println("Invalid Choice, please try again");
            selectedchoice();
        }
        int userchoice = firstscreen.nextInt();
        if (userchoice == 1 || userchoice == 2) {
            amountconvert(userchoice);
        } else {
            System.out.println("Invalid Choice, please try again");
            selectedchoice();
        }
    }


    //  user choice of amount
    public static void amountconvert(int userchoice) throws IOException {
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Please enter an amount to convert");
        double useramount = scanner2.nextDouble();
        resultofuser(userchoice, useramount);

    }

    //  show the user the result
    private static void resultofuser(int userchoice, double useramount) throws IOException {
        double resultuser = 0;
        String conversionflow = null;

        if (userchoice == 1) {
            CoinFactory CoinFactory = new CoinFactory();
            Coin usercoin = currency.CoinFactory.getCoinInstance(Coins.ILS);
            resultuser = new ILS().calculate(useramount);
            conversionflow = new ILS().conversion();
        }
        if (userchoice == 2) {
            CoinFactory CoinFactory = new CoinFactory();
            Coin usercoin = currency.CoinFactory.getCoinInstance(Coins.USD);
            resultuser = new USD().calculate(useramount);
            conversionflow = new USD().conversion();
        }

        userresultes.add(resultuser);
        System.out.println(userresultes);

        startover();

    }

    //  Ask the user if they want to stop or continue the calculation amd write to a file
    public static void startover() throws IOException {
        System.out.println("Do you want to star over?" + "\n" + "if you do press Y, otherwise press N");
        Scanner scanner3 = new Scanner(System.in);
        String userchoice = scanner3.next();
        if (userchoice.equalsIgnoreCase("Y")) {
            selectedchoice();
        } else if (userchoice.equalsIgnoreCase("N")){
            System.out.println("Thanks for using our currency converter");
        } else {
            System.out.println("Invalid Choice, please try again");
            startover();
        }

        FileWriter writer = new FileWriter("C:\\Users\\edenmm\\Desktop\\output1.txt");
        for(double str: userresultes) {
            writer.write(str + System.lineSeparator());
        }
        writer.close();
    }
}
