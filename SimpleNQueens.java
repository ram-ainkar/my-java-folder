
public class SimpleNQueens {

    static int N;

    // Function to print the board
    static void printSolution(int board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Check if a queen can be placed on board[row][col]
    static boolean isSafe(int board[][], int row, int col) {
        int i, j;

        // Check this column on upper side
        for (i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        // Check upper diagonal on left side
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check upper diagonal on right side
        for (i = row, j = col; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    // Recursive function to solve N-Queen problem
    static boolean solveNQUtil(int board[][], int row) {
        // If all queens are placed
        if (row >= N) {
            return true;
        }

        // Skip row if queen already placed
        boolean queenInThisRow = false;
        for (int j = 0; j < N; j++) {
            if (board[row][j] == 1) {
                queenInThisRow = true;
            }
        }

        if (queenInThisRow) {
            return solveNQUtil(board, row + 1);
        }

        // Try placing a queen in all columns one by one
        for (int i = 0; i < N; i++) {
            if (isSafe(board, row, i)) {
                board[row][i] = 1; // place queen

                if (solveNQUtil(board, row + 1)) {
                    return true;
                }

                board[row][i] = 0; // backtrack
            }
        }

        return false;
    }

    static void solveNQ(int firstRow, int firstCol) {
        int board[][] = new int[N][N];

        // Place the first queen
        board[firstRow][firstCol] = 1;

        if (!solveNQUtil(board, 0)) {
            System.out.println("Solution does not exist");
            return;
        }

        printSolution(board);
    }

    public static void main(String args[]) {
        N = 8; // You can change N here

        int firstRow = 0; // row index for first queen
        int firstCol = 0; // column index for first queen

        System.out.println("N-Queens solution with first queen at (" + firstRow + "," + firstCol + "):");
        solveNQ(firstRow, firstCol);
    }
}
