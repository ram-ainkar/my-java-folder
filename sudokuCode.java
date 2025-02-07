

public class sudokuCode {
//     public  boolean isSafe(char[][] board, int  row, int col, int number) {
//         //column
//         for(int i=0; i<board.length; i++) {
//             if(board[i][col] == (char)(number+'0')){
//                 return false;

//             }
//         }
//         //row 
//         for(int j=0; j<board.length; j++) {
//             if(board[row][j] == (char)(number+'0')) {
//                 return false;
//             } 

//         }

//         //grid
//         int sr = 3 * (row/3);
//         int sc = 3 * (col/3);

//         for(int i=sr; i<sr+3; i++){
//             for(int j=sc; j<sc+3; j++) {
//                 if(board[i][j] == (char)(number+'0')) {
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }
//     public boolean helperSc(char[][] board, int row, int col) {
//        if(row == board.length){
//         return true;
//        }
//         int nrow = 0;
//         int ncol = 0;

//         if(col == board.length-1) {
//             nrow = row + 1;
//             ncol = 0;

//         } else{
//             nrow = row;
//             ncol = col + 1;
//         }

//         if(board[row][col] != '.') {
//             if(helperSc(board, nrow, ncol)) {
//                 return true;
//             } else{
//                 //fill the place 
//                 for(int i=1; i<=9; i++) {
//                     if(isSafe(board, row, col, i)) {
//                         board[row][col] = (char)(i+'0');
//                         if(helperSc(board, nrow, ncol))
//                             return true;
//                     else
//                              board[row][col] = '.';
                        
//                     }
//                 }
//             }
//             return false;
//         }
//     }
//     public void solveSudoku(char[][] board){
//        helperSc(board, 0, 0);
//     }
// }

    public boolean isSafe(int[][] b, int r, int c, int n)  
    {  
    // the loop takes care of the clash in the row of the grid  
    for (int d = 0; d < b.length; d++)  
    {  
      
    // if the number that we have inserted is already   
    // present in that row then return false  
    if (b[r][d] == n)   
    {  
    return false;  
    }  
    }  
      
    // the loop takes care of the clash in the column of the grid  
    for (int r1 = 0; r1 < b.length; r1++)  
    {  
      
    // if the number that we have inserted is already   
    // present in that column then return false  
    if (b[r1][c] == n)  
    {  
    return false;  
    }  
    }  
      
    // the loop takes care of the clash in the sub-grid that is present in the grid  
    int sqt = (int)Math.sqrt(b.length);  
    int boxRowSt = r - r % sqt;  
    int boxColSt = c - c % sqt;  
      
    for (int r1 = boxRowSt; r1 < boxRowSt + sqt; r1++)  
    {  
    for (int d = boxColSt; d < boxColSt + sqt; d++)  
    {  
    // if the number that we have inserted is already   
    // present in that sub-grid then return false  
    if (b[r1][d] == n)  
    {  
    return false;  
    }  
    }  
    }  
      
    // if there is no clash in the grid, then it is safe and   
    // true is returned  
    return true;  
    }  
      
    public boolean solveSudoku(int[][] b, int num)  
    {  
    int r = -1;  
    int c = -1;  
    boolean isVacant = true;  
    for (int i = 0; i < num; i++)  
    {  
    for (int j = 0; j < num; j++)  
    {  
    if (b[i][j] == 0)  
    {  
    r = i;  
    c = j;  
      
    // false value means   
    // there is still some   
    // vacant cells in the grid  
    isVacant = false;  
    break;  
    }  
    }  
      
    if (!isVacant)   
    {  
    break;  
    }  
    }  
      
    // there is no empty space left  
    // in the grid  
    if (isVacant)  
    {  
    return true;  
    }  
      
    // otherwise for each row do the backtracking  
    for (int no = 1; no <= num; no++)  
    {  
    if (isSafe(b, r, c, no))  
    {  
    b[r][c] = no;  
    if (solveSudoku(b, num))  
    {  
    // display(board, num);  
    return true;  
    }  
    else  
    {  
      
    b[r][c] = 0;  
    }  
    }  
    }  
    return false;  
    }  
      
    public void display(int[][] b, int n)  
    {  
      
    // We have got the solution, just display it  
    for (int i = 0; i < n; i++)  
    {  
    for (int d = 0; d < n; d++)  
    {  
    System.out.print(b[i][d]);  
    System.out.print(" ");  
    }  
      
    System.out.print("\n");  
      
    if ((i + 1) % (int)Math.sqrt(n) == 0)  
    {  
    System.out.print("");  
    }  
    }  
    }  
      
    // main method  
    public static void main(String argvs[])  
    {  
      
    // the 9 x 9  grid   
    int[][] b = new int[][] { { 7, 0, 0, 0, 0, 0, 2, 0, 0 },   
                                            { 4, 0, 2, 0, 0, 0, 0, 0, 3 },   
                                            { 0, 0, 0, 2, 0, 1, 0, 0, 0 },   
                                            { 3, 0, 0, 1, 8, 0, 0, 9, 7 },   
                                            { 0, 0, 9, 0, 7, 0, 6, 0, 0 },   
                                            { 6, 5, 0, 0, 3, 2, 0, 0, 1 },   
                                            { 0, 0, 0, 4, 0, 9, 0, 0, 0 },   
                                            { 5, 0, 0, 0, 0, 0, 1, 0, 6 },   
                                            { 0, 0, 6, 0, 0, 0, 0, 0, 8 }   
                                         } ;  
      
    // creating an object of the class SudokuPuzzle  
    sudokuCode obj = new sudokuCode();  
      
    // computing the size of the grid  
    int size = b.length;  
      
    System.out.println("The grid is: ");  
    for(int i = 0; i < size; i++)  
    {  
    for(int j = 0; j < size; j++)  
    {  
    System.out.print(b[i][j] + " ");    
    }  
      
    System.out.println();  
    }  
    System.out.println();  
    if (obj.solveSudoku(b, size))  
    {  
    // display solution  
      
    System.out.println("The solution of the grid is: ");  
    obj.display(b, size);  
    }  
    else   
    {  
    System.out.println("There is no solution available.");  
    }  
    }  
}