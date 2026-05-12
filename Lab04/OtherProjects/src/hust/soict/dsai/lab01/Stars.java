package hust.soict.dsai.lab01;
import java.util.Scanner;

public class Stars {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            for(int k = 0; k < 2 * i + 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        scanner.close();
    }
}

