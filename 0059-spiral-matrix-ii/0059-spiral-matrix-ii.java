class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        int rstart = 0;
        int rend = n-1;
        int cstart = 0;
        int cend = n-1;
        while(rstart<=rend && cstart<=cend){
            for(int i=cstart; i<=cend; i++){
                matrix[rstart][i] = num++;
            }
            rstart++;
            for(int i=rstart; i<=rend; i++){
                matrix[i][rend] = num++;
            }
            cend--;
            if(rstart<=rend){
                for(int i=cend; i>=cstart; i--){
                    matrix[rend][i] = num++;
                }
                rend--;
            }
            if(cstart<=cend){
                for(int i=rend; i>=rstart; i--){
                    matrix[i][cstart] = num++;
                }
                cstart++;
            }
        }
        return matrix;
    }
}