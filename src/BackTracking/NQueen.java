package BackTracking;

import java.util.LinkedList;
import java.util.List;

public class NQueen {
  static boolean[][] board;
  public static void main(String[] args) {
    board = new boolean[4][4];
   List<LinkedList<Integer>> res = findValidPlacements(0, 4);
   res.forEach(System.out::println);
  }

  static List<LinkedList<Integer>> findValidPlacements(int row, int n){
    List<LinkedList<Integer>> res = new LinkedList<>();
    for(int j = 0 ; j<n; j++){
        if(isSafe(row,j, n)){
          board[row][j] = true;
          List<LinkedList<Integer>> temp = new LinkedList<>();
          if(row != n-1) {
            temp = findValidPlacements(row +1, n);
          }else {
            LinkedList<Integer> q = new LinkedList<>();
            q.add(j+1);
            temp.add(q);
          }

          if(!temp.isEmpty()){
            for(LinkedList<Integer> arr : temp){
              if(row != n-1)
                arr.addFirst(j+1);
              res.add(arr);
            }
          }else
            board[row][j] = false;
        }
        board[row][j] = false;
      }

    return res;
  }

  static boolean isSafe(int row, int col, int n){

    for(int i = 0; i<n; i++){
      if(board[row][i]){
        return false;
      }
      if(board[i][col]){
        return false;
      }
    }
    int i = row, j = col;
    while (i>0 && j >0){
      if(board[--i][--j])
        return false;
    }
    i = row; j=col;
    while (i>0 && j < n-1){
      if(board[--i][++j])
        return false;
    }
    return true;
  }
}
