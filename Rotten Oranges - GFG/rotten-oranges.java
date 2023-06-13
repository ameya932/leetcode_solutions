//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Solution {
  public int orangesRotting(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    Queue <Pair> q = new LinkedList<>();
    int[][] vis = new int[n][m];
    int fresh = 0;
    for(int i=0; i<n; i++) {
      for (int j=0; j<m; j++) {
        if (grid[i][j] == 2){
          q.add(new Pair(i, j, 0));
          vis[i][j] = 2;
        }
        else{
          vis[i][j] = 0;
        }
        if(grid[i][j] == 1){
            fresh++;
        }
      }
    }
    int time = 0;
    int drow[] = {-1, 0, +1, 0};
    int dcol[] = {0, 1, 0, -1}; 
    int count = 0;
    while (!q.isEmpty()) {
      int r = q.peek().row;
      int c = q.peek().col;
      int t = q.peek().time;
      time = Math.max(time, t);
      q.remove();
      for (int i=0; i<4; i++) {
        int nrow = r+drow[i];
        int ncol = c+dcol[i];
        if (nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1) {
          q.add(new Pair(nrow, ncol, t+1));
          vis[nrow][ncol] = 2;
          count++;
        }
      }
    }
    if (count != fresh){
        return -1;
    }
    return time;
  }
  public static void main(String[] args) {
     int[][] grid =  {{0,1,2},{0,1,2},{2,1,1}};
    Solution obj = new Solution();
    int ans = obj.orangesRotting(grid);
    System.out.println(ans);
  }
}
class Pair {
  int row;
  int col;
  int time;
  Pair(int _row, int _col, int _time) {
    this.row = _row;
    this.col = _col;
    this.time = _time;
  }
}