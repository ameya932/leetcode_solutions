class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int a = nums1.length;
        int b = nums2.length;
        int ans = 0;
        int dp[][] = new int[a+1][b+1];
        for(int i=1; i<=a; i++){
            for(int j=1; j<=b; j++){
                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = 1+dp[i-1][j-1];
                    ans = Math.max(ans, dp[i][j]);
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }
}