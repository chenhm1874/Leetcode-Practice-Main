package Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Nqueen {
    List<List<String>> ans=new LinkedList<>();
    public List<List<String>> solveNQueens(int n){
        List<String> board=new LinkedList<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(".");
        }
        for(int i=0;i<n;i++){
            board.add(sb.toString());
        }
        backtrack(board,0);
        return ans;
    }
    private void backtrack(List<String> board,int row){
        if(row==board.size()){
            ans.add(new ArrayList<>(board));
            return;
        }
        int n=board.get(row).length();
        for(int col=0;col<n;col++){
            if(!isValid(board,row,col)){
                continue;
            }
            char[] arr=board.get(row).toCharArray();
            arr[col]='q';
            board.set(row,arr.toString());
            backtrack(board,row+1);
            arr[col]='.';
            board.set(row,arr.toString());
        }
    }
    private boolean isValid(List<String> board, int row, int col) {
        int n = board.size();

        // 检查列是否有皇后互相冲突
        for (int i = 0; i <= row; i++) {
            if (board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }

        // 检查右上方是否有皇后互相冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        return true;
    }

}
