package hust.soict.dsai.lab01;
import java.util.Scanner;

public class DaysAndMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("Enter year: ");
            String yearInput = scanner.nextLine().trim();
            System.out.print("Enter month: ");
            String monthInput = scanner.nextLine().trim().toLowerCase();
            
            int month = -1;
            int year = -1;


            if (monthInput.matches("\\d+")) {
                int m = Integer.parseInt(monthInput);
                if (m >= 1 && m <= 12) month = m;
            } 

            else {
                if (monthInput.equals("january") || monthInput.equals("jan.") || monthInput.equals("jan")) month = 1;
                else if (monthInput.equals("february") || monthInput.equals("feb.") || monthInput.equals("feb")) month = 2;
                else if (monthInput.equals("march") || monthInput.equals("mar.") || monthInput.equals("mar")) month = 3;
                else if (monthInput.equals("april") || monthInput.equals("apr.") || monthInput.equals("apr")) month = 4;
                else if (monthInput.equals("may")) month = 5;
                else if (monthInput.equals("june") || monthInput.equals("jun.") || monthInput.equals("jun")) month = 6;
                else if (monthInput.equals("july") || monthInput.equals("jul.") || monthInput.equals("jul")) month = 7;
                else if (monthInput.equals("august") || monthInput.equals("aug.") || monthInput.equals("aug")) month = 8;
                else if (monthInput.equals("september") || monthInput.equals("sept.") || monthInput.equals("sep")) month = 9;
                else if (monthInput.equals("october") || monthInput.equals("oct.") || monthInput.equals("oct")) month = 10;
                else if (monthInput.equals("november") || monthInput.equals("nov.") || monthInput.equals("nov")) month = 11;
                else if (monthInput.equals("december") || monthInput.equals("dec.") || monthInput.equals("dec")) month = 12;
            }


            if (yearInput.matches("\\d+")) {
                year = Integer.parseInt(yearInput);
            }

            // 3. Final Check and Calculation
            if (month != -1 && year >= 0) {
                int days;
                boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

                if (month == 2) {
                    days = isLeap ? 29 : 28;
                } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                    days = 30;
                } else {
                    days = 31;
                }

                System.out.println("Result: Month " + month + " in " + year + " has " + days + " days.");
                break; // Valid input received, exit the loop
            } else {
                System.out.println("Invalid month or year. Please enter again (e.g., Jan, 2024).");
            }
        }
        scanner.close();
    }
}
