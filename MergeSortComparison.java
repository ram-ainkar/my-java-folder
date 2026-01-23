
import java.util.Random;

class MergeSort {

    // Function to merge two halves
    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[mid + 1 + j];
        }

        // Merge the temp arrays
        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Recursive Merge Sort
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
}

// ---------------------------------------------------------------
class MultiThreadedMergeSort extends Thread {

    private int[] arr;
    private int left;
    private int right;

    public MultiThreadedMergeSort(int[] arr, int left, int right) {
        this.arr = arr;
        this.left = left;
        this.right = right;
    }

    @Override
    public void run() {
        if (left < right) {
            int mid = (left + right) / 2;

            MultiThreadedMergeSort leftSorter = new MultiThreadedMergeSort(arr, left, mid);
            MultiThreadedMergeSort rightSorter = new MultiThreadedMergeSort(arr, mid + 1, right);

            leftSorter.start();
            rightSorter.start();

            try {
                leftSorter.join();
                rightSorter.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            MergeSort.merge(arr, left, mid, right);
        }
    }
}

// ---------------------------------------------------------------
public class MergeSortComparison {

    public static void main(String[] args) {
        int n = 100000;  // size of the array (you can increase it)
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        Random rand = new Random();

        // Generate random array
        for (int i = 0; i < n; i++) {
            int num = rand.nextInt(1000000);
            arr1[i] = num;
            arr2[i] = num;
        }

        System.out.println("=== MERGE SORT PERFORMANCE COMPARISON ===");
        System.out.println("Array size: " + n + "\n");

        // ------------------------------------------------
        // Normal Merge Sort
        long startTime = System.currentTimeMillis();
        MergeSort.mergeSort(arr1, 0, arr1.length - 1);
        long endTime = System.currentTimeMillis();
        long normalTime = endTime - startTime;

        System.out.println("Normal Merge Sort Time: " + normalTime + " ms");

        // ------------------------------------------------
        // Multithreaded Merge Sort
        startTime = System.currentTimeMillis();
        MultiThreadedMergeSort threadSort = new MultiThreadedMergeSort(arr2, 0, arr2.length - 1);
        threadSort.start();
        try {
            threadSort.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        endTime = System.currentTimeMillis();
        long multiTime = endTime - startTime;

        System.out.println("Multithreaded Merge Sort Time: " + multiTime + " ms");

        // ------------------------------------------------
        // Comparison
        System.out.println("\n=== RESULT ANALYSIS ===");
        if (multiTime < normalTime) {
            System.out.println("✅ Multithreaded Merge Sort is faster by " + (normalTime - multiTime) + " ms");
        } else {
            System.out.println("⚠️ Normal Merge Sort is faster by " + (multiTime - normalTime) + " ms");
        }

        System.out.println("\nBest Case: Already sorted array → O(n log n)");
        System.out.println("Worst Case: Reverse sorted array → O(n log n)");
        System.out.println("Multithreading helps most for large arrays with multiple CPU cores.");
    }
}
