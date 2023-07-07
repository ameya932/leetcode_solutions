class Solution {
    public int rob(int[] nums) {
        int prev = 0;
        int prev2 = 0;
        for(int num : nums){
            int dp = Math.max(prev, prev2+num);
            prev2 = prev;
            prev = dp;
        }
        return prev;
    }
}