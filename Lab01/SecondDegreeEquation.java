import javax.swing.JOptionPane;

public class SecondDegreeEquation {

    public static void main(String[] args) {
        String str1, str2, str3;
        str1 = JOptionPane.showInputDialog(null, "Please enter a: ", "Input", JOptionPane.INFORMATION_MESSAGE);
        str2 = JOptionPane.showInputDialog(null, "Please enter b: ", "Input", JOptionPane.INFORMATION_MESSAGE);
        str3 = JOptionPane.showInputDialog(null, "Please enter c: ", "Input", JOptionPane.INFORMATION_MESSAGE);

        double a = Double.parseDouble(str1);
        double b = Double.parseDouble(str2);
        double c = Double.parseDouble(str3);

        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    JOptionPane.showMessageDialog(null, "Infinite solutions", "Solution",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No solution", "Solution", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                double x = -c / b;
                JOptionPane.showMessageDialog(null, "The solution is: " + x, "Solution",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            double delta = b * b - 4 * a * c;
            if (delta < 0) {
                JOptionPane.showMessageDialog(null, "No solution", "Solution", JOptionPane.INFORMATION_MESSAGE);
            } else if (delta == 0) {
                double x = -b / (2 * a);
                JOptionPane.showMessageDialog(null, "The solution is: " + x, "Solution",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                JOptionPane.showMessageDialog(null, "The solutions are: " + x1 + " and " + x2, "Solution",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }

        System.exit(0);
    }
}
