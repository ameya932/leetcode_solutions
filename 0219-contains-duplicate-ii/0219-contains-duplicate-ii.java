class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> mpp = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(!mpp.containsKey(nums[i])){
                mpp.put(nums[i], i);
            }
            else{
                int last = mpp.get(nums[i]);
                if(Math.abs(last-i) <= k){
                    return true;
                }
                else{
                    mpp.put(nums[i], i);
                }
            }
        }
        return false;
    }
}