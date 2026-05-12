package hust.soict.dsai.lab01;
// import javax.swing.JOptionPane;

// public class ChoosingOption {
//     public static void main(String[] args){
//         int option = JOptionPane.showConfirmDialog(null, "Do you want to change to the first class ticket ?");
//         JOptionPane.showMessageDialog(null, "You've chosen: " + (option == JOptionPane.YES_OPTION ? "YES" : "NO"));
//         System.exit(0);
//     }
// }
// To customize the message dialog, use the following code:
import javax.swing.JOptionPane;

public class ChoosingOption {
    public static void main(String[] args){
        String[] options = {"Yes, I do", "No, I don't"};
        int option = JOptionPane.showInternalOptionDialog(null, "Do you want to change to the first class ticket ? ", null, 0, 0, null, options, null);
        JOptionPane.showMessageDialog(null, "You've chosen: " + options[option]);
        System.exit(0);
    }
}

