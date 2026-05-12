package hust.soict.dsai.lab01;
import javax.swing.JOptionPane;

public class Equation {
    public static void main(String[] args){
        String str_a, str_b;
        str_a = JOptionPane.showInputDialog("Enter the value of a:");
        str_b = JOptionPane.showInputDialog("Enter the value of b:");
        double a = Double.parseDouble(str_a);
        double b = Double.parseDouble(str_b);
        if(a == 0 && b == 0) {
            JOptionPane.showMessageDialog(null, "The equation has infinitely many solutions.");
        } else if(a == 0 && b != 0) {
            JOptionPane.showMessageDialog(null, "The equation has no solution.");
        } else {
            double solution = -b / a;
            JOptionPane.showMessageDialog(null, "The solution to the equation is: " + solution);
        }
    }
}

