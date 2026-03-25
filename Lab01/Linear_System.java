import javax.swing.JOptionPane;

public class Linear_System {
    public static void main(String[] args) {
        String str1, str2, str3, str4, str5, str6;
        str1 = JOptionPane.showInputDialog(null, "Please enter a11: ", JOptionPane.INFORMATION_MESSAGE);
        str2 = JOptionPane.showInputDialog(null, "Please enter a12: ", JOptionPane.INFORMATION_MESSAGE);
        str3 = JOptionPane.showInputDialog(null, "Please enter b1: ", JOptionPane.INFORMATION_MESSAGE);
        str4 = JOptionPane.showInputDialog(null, "Please enter a21: ", JOptionPane.INFORMATION_MESSAGE);
        str5 = JOptionPane.showInputDialog(null, "Please enter a22: ", JOptionPane.INFORMATION_MESSAGE);
        str6 = JOptionPane.showInputDialog(null, "Please enter b2: ", JOptionPane.INFORMATION_MESSAGE);
        double a11 = Double.parseDouble(str1);
        double a12 = Double.parseDouble(str2);
        double b1 = Double.parseDouble(str3);
        double a21 = Double.parseDouble(str4);
        double a22 = Double.parseDouble(str5);
        double b2 = Double.parseDouble(str6);
        double det = a11 * b2 - a21 * b1;
        if (det == 0) {
            if (b1 * a22 - b2 * a12 == 0 && a11 * b2 - a21 * b1 == 0) {
                JOptionPane.showMessageDialog(null, "Infinite solutions", "Solution", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No solution", "Solution", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            double x = (b1 * a22 - b2 * a12) / det;
            double y = (a11 * b2 - a21 * b1) / det;
            JOptionPane.showMessageDialog(null, "The solution is: " + x + " " + y, "Solution",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
