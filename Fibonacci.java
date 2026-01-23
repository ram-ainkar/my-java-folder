package fibonacci;

public class Fibonacci {

    static int fibrec(int n) {
        if (n <= 1) {
            return n;
        }
        return fibrec(n - 1) + fibrec(n - 2);
    }

    static int fibnonrec(int n) {
        int curr = 0;
        if (n == 0 || n == 1) {
            System.out.println("Fibonacci number is " + n);
        } else {

            for (int i = 2; i <= n; i++) {
                curr = prev1 + prev2;

                return curr;
            } 
 	

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(
        "Enter number to calculate fibonacci 
value(Greater than or equal to 0)");  	 	int n=sc.nextInt(); 
 	 	 
 	 	System.out.println();
        System.out.println("Recursive");
        int result = fibrec(n);
        System.out.println("Fibonacci number is " + result);
        System.out.println();
        System.out.println("Non Recursive");
        int res = fibnonrec(n);
        System.out.println("Fibonacci number is " + res);
    }
}
