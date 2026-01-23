
import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[low], i = low, j = high;
        while (i < j) {
            while (i <= high - 1 && arr[i] <= pivot) {
                i++;
            }
            while (j >= low + 1 && arr[j] > pivot) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, low, j);
        return j;
    }

    static int randomPartition(int[] arr, int low, int high) {
        int rand = low + (int) (Math.random() * (high - low + 1));
        swap(arr, low, rand);
        return partition(arr, low, high);
    }

    static void quickSort(int[] arr, int low, int high, boolean random) {
        if (low < high) {
            int p = random ? randomPartition(arr, low, high) : partition(arr, low, high);
            quickSort(arr, low, p - 1, random);
            quickSort(arr, p + 1, high, random);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("1.Deterministic  2.Randomized : ");
        int ch = sc.nextInt();

        System.out.println("Before sort: " + Arrays.toString(arr));

        quickSort(arr, 0, n - 1, ch == 2);
        System.out.println("After sort: " + Arrays.toString(arr));
    }
}
