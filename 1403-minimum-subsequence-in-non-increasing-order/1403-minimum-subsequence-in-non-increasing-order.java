class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        List<Integer> sub = new ArrayList<>();
        int subSum = 0;
        for (int i=nums.length-1; i>=0; i--) {
            subSum += nums[i];
            sub.add(nums[i]);
            if (subSum > total-subSum) {
                break;
            }
        }
        return sub;
    }
}