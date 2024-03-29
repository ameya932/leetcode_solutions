class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int target = 0;
        Set<List<Integer>> s = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            int j = i+1;
            int k = n-1;
            while(j < k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum == target){
                    s.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }
                else if(sum < target){
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        ans.addAll(s);
        return ans;
    }
}