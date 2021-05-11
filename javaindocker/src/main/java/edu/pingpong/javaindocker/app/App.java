package edu.pingpong.javaindocker.app;

import java.util.Scanner;

import edu.pingpong.javaindocker.domain.regex.RomanNumber;

public class App {
    public static void main(String[] args) {

        RomanNumber romanNumber = new RomanNumber();
        Scanner input = new Scanner(System.in);
        String status = "";

        while (!status.equals("N")) {

            System.out.println("========================= ¡ WELCOME ! ================================\n");
            System.out.println("\t¡ Convert any Roman Number to Decimal !\n\n");
            System.out.println("Type a Roman Number below;");
            String inputRomanNum = input.nextLine();

            romanNumber.initRegexDictionary();
            romanNumber.setRomanNum(inputRomanNum);
            romanNumber.setDecimalNum(0);
            romanNumber.toDecimal();

            if (romanNumber.getDecimalNum() != 0) {
                clearScreen();
                System.out.println("\n¡ Your number has been converted SUCCESSFULLY !\n");
                System.out.println("Roman Number ---> " + inputRomanNum);
                System.out.println("Decimal Number ---> " + romanNumber.getDecimalNum() + "\n");

                System.out.println("\n \n ========OTHER TIME?========!");
                System.out.println('\n' + "Y/N");

                Scanner confirm = new Scanner(System.in);
                status = confirm.nextLine();
                clearScreen();

            } else {
                clearScreen();
                System.out.println("\nSorry unable to convert this number: " + inputRomanNum + " :(\n");
                System.out.println("¡ Please enter a valid Roman Number !\n");
                System.out.println("\tRULES\n");
                System.out.println(
                        "- X, C and M can be 3 consecutive times\n- V, L and D can NOT be 3 consecutive times \n- V can NOT be substractive\n");
            }
        }
        clearScreen();
        System.out.println("\n\t==================== ¡ SEE YOU SOON ! ====================");
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
