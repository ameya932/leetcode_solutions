//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Pair{
    int first = 0;
    int second = 0;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    // Function to find the number of islands.
    private void bfs(int r, int c, int[][] vis, char[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        vis[r][c] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r, c));
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();
            for(int delrow=-1; delrow<=1; delrow++){
                for(int delcol = -1; delcol<=1; delcol++){
                    int nrow = row+delrow;
                    int ncol = col+delcol;
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]=='1' && vis[nrow][ncol]==0){
                        vis[nrow][ncol] = 1;
                        q.add(new Pair(nrow, ncol));
                    }
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int count = 0;
        for(int row=0; row<n; row++){
            for(int col=0; col<m; col++){
                if(vis[row][col]==0 && grid[row][col]=='1'){
                    count++;
                    bfs(row, col, vis, grid);
                }
            }
        }
        return count;
    }
}