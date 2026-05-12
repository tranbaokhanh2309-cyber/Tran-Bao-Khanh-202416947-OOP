package hust.soict.dsai.lab01;
import javax.swing.JOptionPane;

public class EquationSystem {
    public static void main(String[] args){
        String str_a1, str_b1, str_c1, str_a2, str_b2, str_c2;
        str_a1 = JOptionPane.showInputDialog("Enter the value of a1:");
        str_b1 = JOptionPane.showInputDialog("Enter the value of b1:");
        str_c1 = JOptionPane.showInputDialog("Enter the value of c1:");
        str_a2 = JOptionPane.showInputDialog("Enter the value of a2:");
        str_b2 = JOptionPane.showInputDialog("Enter the value of b2:");
        str_c2 = JOptionPane.showInputDialog("Enter the value of c2:");
        double a1 = Double.parseDouble(str_a1);
        double b1 = Double.parseDouble(str_b1);
        double c1 = Double.parseDouble(str_c1);
        double a2 = Double.parseDouble(str_a2);
        double b2 = Double.parseDouble(str_b2);
        double c2 = Double.parseDouble(str_c2);
        
        double determinant = a1 * b2 - a2 * b1;
        
        if(determinant == 0) {
            if(a1 * c2 == a2 * c1 && b1 * c2 == b2 * c1) {
                JOptionPane.showMessageDialog(null, "The system has infinitely many solutions.");
            } else {
                JOptionPane.showMessageDialog(null, "The system has no solution.");
            }
        } else {
            double x = (c1 * b2 - c2 * b1) / determinant;
            double y = (a1 * c2 - a2 * c1) / determinant;
            JOptionPane.showMessageDialog(null, "The solution to the system is: x = " + x + ", y = " + y);
        }
    }
}

