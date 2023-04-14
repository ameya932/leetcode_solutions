class Solution {
    public int[] leftRigthDifference(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int[] preSum = new int[n];
        int[] sufSum = new int[n];
        preSum[0] = nums[0];
        for(int i=1; i<n; i++){
            preSum[i] = preSum[i-1]+nums[i];
        }
        sufSum[n-1] = nums[n-1];
        for(int i=n-2; i>=0; i--){
            sufSum[i] = sufSum[i+1]+nums[i];
        }
        for(int i=0; i<n; i++){
            int leftSum = (i==0) ? 0 : preSum[i-1];
            int rightSum = (i==n-1) ? 0 : sufSum[i+1];
            answer[i] = Math.abs(leftSum-rightSum);
        }
        return answer;
    }
}