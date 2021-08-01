package main_package;

import currency.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainCal {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to currency converter");
        selectedchoice();
    }

    public static ArrayList<Double> userresultes = new ArrayList<Double>();


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
        result(userchoice, useramount);

    }

    //  show the user the result
    private static void result(int userchoice, double useramount) throws IOException {
        double resulteuser = 0;

        if (userchoice == 1) {
            CoinFactory CoinFactory = new CoinFactory();
//            Coin usercoin = CoinFactory.getCoinInstance(ILS);
            Coin usercoin = currency.CoinFactory.getCoinInstance(Coins.ILS);
            resulteuser = new ILS().calculate(useramount);
            System.out.println(resulteuser);
        }
        if (userchoice == 2) {
            CoinFactory CoinFactory = new CoinFactory();
            Coin usercoin = currency.CoinFactory.getCoinInstance(Coins.USD);
            resulteuser = new USD().calculate(useramount);
            System.out.println(resulteuser);
        }

//        ArrayList<Double> userresultes = new ArrayList<Double>();
        userresultes.add(resulteuser);
        System.out.println(userresultes);
//        for (double i = 1; i > userresultes.size(); i++){
//
//        }

        startover();

    }

    //  Ask the user if they want to stop or continue the calculation
    public static void startover() throws IOException {
        System.out.println("Do you want to star over?" + "\n" + "if you do press Y, otherwise press N");
        Scanner scanner3 = new Scanner(System.in);
        String userchoice = scanner3.next();
        if (userchoice.equalsIgnoreCase("Y")) {
            selectedchoice();
        } else {
            System.out.println("Thanks for using our currency converter");
        }

        FileWriter writer = new FileWriter("output1.txt");
        for(double str: userresultes) {
            writer.write(str + System.lineSeparator());
        }
        writer.close();


    }


}
