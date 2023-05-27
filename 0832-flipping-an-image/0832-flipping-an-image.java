class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        int[][] flip = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                flip[i][j] = image[i][n-1-j];
            }
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                flip[i][j] = (flip[i][j]==0) ? 1 : 0;
            }
        }
        return flip;
    }
}