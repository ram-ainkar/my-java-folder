public class array{
    public static void print3largest(int arr[], int arr_size) {
        int i, first, second, third;
        if(arr_size < 3) {
            System.out.print("invalid input");
            return;
        }
        third = first = second = Integer.MIN_VALUE;
        for(i=0; i< arr_size; i++){
            if(arr[i]> first) {
                third = second;
                second = first;
                first = arr[i];

            }
            else if(arr[i] > second) {
                third = second ;
                second = arr[i];
            

            }
            else if(arr[i] > third);
                 third = arr[i];

            
        }
        System.out.println("three largest element are:" + first +" " + second+" " + " "+ third );
    }
    public static void main(String args[]){
        int arr[] = {12, 13 , 1, 10, 34, 1};
        int n = arr.length;
        print3largest(arr, n);

    }
}