class Solution {
    public int countNegatives(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        int c = 0;
        int r = rows-1;
        while(r>=0 && c<cols){
            if(grid[r][c]<0){
                count += cols-c;
                r--;
            }
            else{
                c++;
            }
        }
        return count;
    }
}