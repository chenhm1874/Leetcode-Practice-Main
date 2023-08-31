package Backtracking;

public class solveSudoku {
    public void solveSudoku(char[][] board){
        backtrack(0,0,board);
    }
    private boolean backtrack(int i,int j,char[][] board){
        int m=9;
        int n=9;
        if(i==m){
            backtrack(i+1,0,board);
        }
        if(j==n){
            return true;
        }
        if(board[i][j]!='.'){
            backtrack(i,j+1,board);
        }
        for(char ch='1';ch<='9';ch++){
            if(!isValid(board,i,j,ch)){
                continue;
            }
            board[i][j]=ch;
            if(backtrack(i,j+1,board)){
                return true;
            }
            board[i][j]='.';
        }
        return false;
    }
    boolean isValid(char[][] board, int r, int c, char n) {
        for (int i = 0; i < 9; i++) {
            // 判断行是否存在重复
            if (board[r][i] == n) return false;
            // 判断列是否存在重复
            if (board[i][c] == n) return false;
            // 判断 3 x 3 方框是否存在重复
            if (board[(r/3)*3 + i/3][(c/3)*3 + i%3] == n)
                return false;
        }
        return true;
    }
}
