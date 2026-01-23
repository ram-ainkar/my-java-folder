
import java.util.ArrayList;
import java.util.List;

//     public static int countPaths(int i, int j, int n, int m){
//         if(i == n || j == m){
//             return 0;
//         }
//         if(i == n-1 && j == m-1){
//             return 1;
//         }
//         //move downwords 
//         int downPaths = countPaths(i+1, j, n, m);
//         // move right
//         int rightPaths = countPaths(i, j+1, n, m);
//         return downPaths + rightPaths;
//     }
//     public static void main(String args[]){
//         int n =4  , m=4;
//         int totalPaths = countPaths(0, 0, n, m);
//         System.out.println(totalPaths);
//     }
//   public static int placeTiles(int n, int m){
//     if(n == m){
//         return 2;
//     }
//     if(n < m){
//         return 1;
//     }
//     // vertical 
//     int vertPlacements = placeTiles(n-m, m);
//     //horizomtally
//     int horiPlacements = placeTiles(n-1, m);
//     return vertPlacements + horiPlacements;
//   }
//   public static void main(String args[]){
//     int n =4, m=2;
//     int str = placeTiles(n, m);
//     System.out.println(str);
//   }
//  public class recursion1 {
//       public static void printSubset(ArrayList<Integer> subset){
//          for(int i =0; i<subset.size(); i++){
//              System.out.print(subset.get(i)+" ");
//          }
//          System.out.println();
//       }
//       public static void findSubsets(int n, ArrayList<Integer> subset){
//           if( n == 0){
//              printSubset(subset);
//              return;
//           }
//          // add 
//          subset.add(n);
//          findSubsets(n-1, subset);
//          //remove
//          subset.remove(subset.size()-1);
//          findSubsets(n-1, subset);
//       }
//       public static void main(String args[]){
//          int n =3 ;
//          ArrayList<Integer> subset = new ArrayList<>();
//          findSubsets(n, subset);
//       }
//  }
//Backtracing question
/**
 * recursion1
 */
public class Recursion1 {

    public boolean isSafe(int row, int col, char[][] board) {
        //horizontal
        for (int j = 0; j < board.length; j++) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }
        //vertical 
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        //upper left
        int r = row;
        for (int c = col; c >= 0 && r >= 0; c--, r--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }
        //upper right
        r = row;
        for (int c = col; c < board.length && r >= 0; r--, c++) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }
        //Lower left
        for (int c = col; c >= 0 && r < board.length; r++, c--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        //Lower right 
        for (int c = col; c < board.length && r < board.length; c++, r++) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public void saveBoard(char[][] board, List<List<String>> allBoards) {
        String row = "";
        List<String> newBoard = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            row = "";
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'Q') {
                    row += 'Q'; 
                }else {
                    row += ".";
                }

            }
            newBoard.add(row);
        }

        allBoards.add(newBoard);
    }

    public void helper(char[][] boards, List<List<String>> allBoards, int col) {
        if (col == board.length) {
            saveBoard(board, allBoards);
            return;
        }
        for (int row = 0; row < board.length; row++) {
            if (isSafe(row, col, boards)) {
                board[row][col] = 'Q';
                helper(boards, allBoards, col + 1);
                board[row][col] = '.';

            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> allBoards = new ArrayList<>();
        char[][] boards = new char[n][n];

        helper(boards, allBoards, 0);
        return allBoards;

    }
}
