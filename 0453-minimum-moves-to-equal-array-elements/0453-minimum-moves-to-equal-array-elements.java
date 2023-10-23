class Solution {
    public int minMoves(int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for(int n : nums){
            sum += n;
            min = Math.min(n, min);
        }
        return sum-min*nums.length;
    }
}