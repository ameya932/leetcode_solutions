class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[] = new int[n+1];
        for(int i=n-1; i>=0; i--) {
            int[] curr = new int[n+1];
            for(int j=0; j<=i; j++){
                curr[j] = triangle.get(i).get(j)+Math.min(dp[j], dp[j+1]); 
            }
            dp = curr;
        }
        return dp[0];
    }
}