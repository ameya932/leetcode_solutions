class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] mat = new int[m][n];
        for(int i=0; i<indices.length; i++){
            int a = indices[i][0];
            int b = indices[i][1];
            for(int j=0; j<n; j++){
                mat[a][j] += 1;
            }
            for(int j=0; j<m; j++){
                mat[j][b] += 1;
            }
        }
        int odd = 0;
        for(int[] row : mat){
            for(int num : row){
                if(num%2 == 1){
                    odd++;
                }
            }
        }
        return odd;
    }    
}