package BackTracking;

import java.util.ArrayList;

public class RatInMaze {

  static boolean[][] visited = new boolean[5][5];
  static ArrayList<String> result = new ArrayList<>();

  static void path(int[][] maze, int x, int y, String dir, int n){
      if(x == n-1 && y == n-1){
        result.add(dir);
        return;
      }

      if(maze[x][y] == 0 || visited[x][y]){
        return;
      }
      visited[x][y] = true;

      if(x > 0){
        path(maze, x-1, y, dir + "U", n);
      }
      if(x < n-1){
        path(maze, x+1, y, dir + "D", n);
      }
      if(y > 0){
        path(maze, x, y-1, dir + "L", n);
      }
      if(y < n-1){
        path(maze, x, y+1, dir + "R", n);
      }

      visited[x][y] = false;
  }

  static ArrayList<String> findPath(int[][] maze, int n){
    if(maze[0][0] == 0 || maze[n-1][n-1] == 0){
      return result;
    }
    path(maze, 0, 0, "", n);
    return result;
  }

  public static void main(String[] args) {
    int[][] maze = {
      {1, 0, 0, 0},
      {1, 1, 0, 0},
      {1, 1, 0, 0},
      {0, 1, 1, 1}
    };

    System.out.println(findPath(maze, 4));
  }

}
