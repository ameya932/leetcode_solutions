//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];

        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[][] grid = IntMatrix.input(br, n, n);
            
            Solution obj = new Solution();
            int res = obj.largestIsland(n, grid);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution{
    int dfs(int i, int j, int N, int[][] grid, int[][] visited, int ind){
        if(i<0 || i>=N || j>=N || j<0 || visited[i][j]==1 || grid[i][j]==0){
            return 0;
        }
        visited[i][j] = 1;
        grid[i][j] = ind;
        int a = dfs(i+1, j, N, grid, visited, ind);
        int b = dfs(i, j+1, N, grid, visited, ind);
        int c = dfs(i-1, j, N, grid, visited, ind);
        int d = dfs(i, j-1, N, grid, visited, ind);
        return a+b+c+d+1;
    }
    public int largestIsland(int N, int[][] grid) 
    {
        int[][] visited = new int[N][N];
        int ind = 1;
        int maxa = 0;
        ArrayList<Integer> sz = new ArrayList<>();
        sz.add(0);
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(visited[i][j]==0 && grid[i][j]==1){
                     int temp = dfs(i, j, N, grid, visited, ind);  
                     sz.add(temp);
                     maxa = Math.max(maxa, temp);
                     ind++;
                }   
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(grid[i][j] == 0){
                    int sumo = 1;
                    int a=0, b=0, c=0, d=0;
                    if(i>0 && grid[i-1][j]!=0){
                        a = grid[i-1][j];
                    }
                    if(i<N-1 && grid[i+1][j]!=0){
                        b = grid[i+1][j];
                    }
                    if(j>0 && grid[i][j-1]!=0){
                        c = grid[i][j-1];
                    }
                    if(j<N-1 && grid[i][j+1]!=0){
                        d = grid[i][j+1];
                    }
                    sumo += sz.get(a);
                    if(b != a){
                        sumo += sz.get(b);
                    }
                    if(c!=b && c!=a){
                        sumo += sz.get(c);
                    }
                    if(d!=c && d!=b && d!=a){
                        sumo += sz.get(d);
                    }
                    maxa = Math.max(maxa, sumo);
                }
            }
        }
        return maxa;
    }
}
