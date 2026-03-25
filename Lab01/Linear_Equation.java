import javax.swing.JOptionPane;

public class Linear_Equation {
    public static void main(String[] args) {
        String str1, str2;
        str1 = JOptionPane.showInputDialog(null, "Please input a=", JOptionPane.INFORMATION_MESSAGE);
        str2 = JOptionPane.showInputDialog(null, "Please input b=", JOptionPane.INFORMATION_MESSAGE);

        double a = Double.parseDouble(str1);
        double b = Double.parseDouble(str2);

        if (a == 0) {
            if (b == 0) {
                JOptionPane.showMessageDialog(null, "Infinite solutions", "Solution", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No solution", "Solution", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            double x = -b / a;

            JOptionPane.showMessageDialog(null, "The solution is: " + x, "Solution", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
