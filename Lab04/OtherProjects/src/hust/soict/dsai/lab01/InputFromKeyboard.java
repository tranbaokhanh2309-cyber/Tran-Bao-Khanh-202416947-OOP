package hust.soict.dsai.lab01;
import java.util.Scanner;

public class InputFromKeyboard {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        System.out.print("What's your name: ");
        String strName = keyboard.nextLine();
        System.out.println("How old are you: ");
        int iAge = keyboard.nextInt();
        System.out.println("How tall are you: ");
        double dHeight = keyboard.nextDouble();
        System.out.println("Mr/Ms " + strName + ", you are " + iAge + " years old and " + dHeight + " meters tall.");
        keyboard.close();
    }
}

