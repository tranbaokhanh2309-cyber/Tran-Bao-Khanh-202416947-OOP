package hust.soict.dsai.lab01;
import javax.swing.JOptionPane;

public class DoubleNumber {
    public static void main(String[] args) {
        String strNum1, strNum2;
        String numNotification;
        strNum1 = JOptionPane.showInputDialog(null, "Enter the first number: ", JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null, "Enter the second number: ", JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;
        if(num2 != 0) {
            double quotient = num1 / num2;
            numNotification = "The sum is: " + sum + "\nThe difference is: " + difference + "\nThe product is: " + product + "\nThe quotient is: " + quotient;
        } else {
            numNotification = "The sum is: " + sum + "\nThe difference is: " + difference + "\nThe product is: " + product + "\nCannot divide by zero.";
        }
        JOptionPane.showMessageDialog(null, numNotification, "Results", JOptionPane.INFORMATION_MESSAGE);
    }
}
