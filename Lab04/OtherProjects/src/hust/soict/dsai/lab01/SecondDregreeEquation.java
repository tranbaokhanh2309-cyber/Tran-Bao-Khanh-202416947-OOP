package hust.soict.dsai.lab01;
import javax.swing.JOptionPane;

public class SecondDregreeEquation {
    public static void main(String[] args){
        String str_a, str_b, str_c;
        str_a = JOptionPane.showInputDialog("Enter the value of a:");
        str_b = JOptionPane.showInputDialog("Enter the value of b:");
        str_c = JOptionPane.showInputDialog("Enter the value of c:");
        double a = Double.parseDouble(str_a);
        double b = Double.parseDouble(str_b);
        double c = Double.parseDouble(str_c);
        
        if(a == 0) {
            if(b == 0) {
                if(c == 0) {
                    JOptionPane.showMessageDialog(null, "The equation has infinitely many solutions.");
                } else {
                    JOptionPane.showMessageDialog(null, "The equation has no solution.");
                }
            } else {
                double solution = -c / b;
                JOptionPane.showMessageDialog(null, "The solution to the equation is: " + solution);
            }
        } else {
            double discriminant = b * b - 4 * a * c;
            if(discriminant < 0) {
                JOptionPane.showMessageDialog(null, "The equation has no real solutions.");
            } else if(discriminant == 0) {
                double solution = -b / (2 * a);
                JOptionPane.showMessageDialog(null, "The equation has one real solution: " + solution);
            } else {
                double sqrt_discriminant = Math.sqrt(discriminant);
                double solution1 = (-b + sqrt_discriminant) / (2 * a);
                double solution2 = (-b - sqrt_discriminant) / (2 * a);
                JOptionPane.showMessageDialog(null, "The equation has two real solutions: " + solution1 + " and " + solution2);
            }
        }
    }
}

