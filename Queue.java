import java.util.Scanner;

public class Queue{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("how many rows you want in this pattern?");
        int rows = sc.nextInt();
        System.out.println("here is your pattern......!");
        //upper half
        for(int i=rows; i>=1; i--){
            for(int j=1; j<=i; j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
        //lower half
        for(int i=2; i<=rows; i++){
            for(int j=1; j<=i; j++ ){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}