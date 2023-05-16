class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if (k<=0 || total%k!=0) {
            return false;
        }
        int target = total/k;
        boolean[] visited = new boolean[nums.length];
        return backtrack(nums, k, 0, 0, target, visited);
    }
    private boolean backtrack(int[] nums, int k, int start, int curr, int target, boolean[] visited) {
        if (k == 1) {
            return true;
        }
        if (curr == target) {
            return backtrack(nums, k - 1, 0, 0, target, visited);
        }
        for (int i = start; i<nums.length; i++) {
            if (!visited[i] && curr+nums[i]<=target) {
                visited[i] = true;
                if (backtrack(nums, k, i+1, curr+nums[i], target, visited)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
}