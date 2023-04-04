class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maximum = nums[0];
        int minimum = nums[0];
        int result = nums[0];
        for(int i=1; i<n; i++){
            int temp = maximum;
            maximum = Math.max(Math.max(maximum*nums[i], minimum*nums[i]), nums[i]);
            minimum = Math.min(Math.min(temp*nums[i], minimum*nums[i]), nums[i]);
            result = Math.max(result, maximum);
        }
        return result;
    }
}