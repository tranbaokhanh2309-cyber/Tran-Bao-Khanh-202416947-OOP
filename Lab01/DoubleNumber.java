import javax.swing.JOptionPane;

public class DoubleNumber {
    public static void main(String[] args) {
        // Nhập số thứ nhất dưới dạng String
        String strNum1 = JOptionPane.showInputDialog(null, 
            "Please input the first number: ", "Input first number", 
            JOptionPane.INFORMATION_MESSAGE);
        
        // Nhập số thứ hai dưới dạng String
        String strNum2 = JOptionPane.showInputDialog(null, 
            "Please input the second number: ", "Input second number", 
            JOptionPane.INFORMATION_MESSAGE);

        // Chuyển đổi String sang double
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        // Tính toán các giá trị
        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;
        
        String result = "Results for " + num1 + " and " + num2 + ":\n";
        result += "Sum: " + sum + "\n";
        result += "Difference: " + difference + "\n";
        result += "Product: " + product + "\n";

        // Kiểm tra số chia trước khi tính thương (tránh chia cho 0)
        if (num2 != 0) {
            double quotient = num1 / num2;
            result += "Quotient: " + quotient;
        } else {
            result += "Quotient: Cannot divide by zero!";
        }

        // Hiển thị kết quả ra màn hình
        JOptionPane.showMessageDialog(null, result, 
            "Calculation Results", JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }
}