import java.util.*;

public class Recursion01{
    private static void swap(char[] c, int i, int j){
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }
    public static void revers(char[] c , int l,int h){
         if(l < h){
            swap(c, l, h);
            revers(c, l+1, h-1);
         }
    }
   public static void main(String args[]) {
        String str = "tony stark";
        char[] c = str.toCharArray();
        }
}