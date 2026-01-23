
import java.util.Scanner;

public class FibonacciProgram {

    // Recursive function
    static int fibRec(int n) {
        if (n < 0) {
            return -1; // negative number
        }
        if (n == 0 || n == 1) {
            return n;
        } else {
            return fibRec(n - 1) + fibRec(n - 2);
        }
    }

    // Iterative function
    static int fibIter(int n) {
        if (n < 0) {
            return -1; // negative number
        }
        if (n == 0 || n == 1) {
            return n;
        }

        int a = 0, b = 1, c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    // Print Fibonacci series
    static void printFibSeries(int n) {
        if (n < 0) {
            System.out.println("Enter positive number");
            return;
        }
        if (n == 0) {
            System.out.println("0");
            return;
        }
        if (n == 1) {
            System.out.println("0 1");
            return;
        }

        int a = 0, b = 1;
        System.out.print(a + " " + b + " ");
        for (int i = 2; i <= n; i++) {
            int c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
        System.out.println();
    }

    // Main menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Fibonacci Menu =====");
            System.out.println("1. Find nth Fibonacci number (Recursive)");
            System.out.println("2. Find nth Fibonacci number (Iterative)");
            System.out.println("3. Print Fibonacci Series");
            System.out.print("Enter option: ");
            int op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.print("Enter n: ");
                    int n1 = sc.nextInt();
                    int res1 = fibRec(n1);
                    System.out.println("Result: " + res1);
                    break;
                case 2:
                    System.out.print("Enter n: ");
                    int n2 = sc.nextInt();
                    int res2 = fibIter(n2);
                    System.out.println("Result: " + res2);
                    break;
                case 3:
                    System.out.print("Enter n: ");
                    int n3 = sc.nextInt();
                    printFibSeries(n3);
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
