class Solution {
    public int findMaxLength(int[] nums) {
        int len = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i=0; i<nums.length; i++){
            count += (nums[i]==1) ? 1 : -1;
            if(map.containsKey(count)){
                int subarr = i-map.get(count);
                len = Math.max(len, subarr);
            }
            else{
                map.put(count, i);
            }
        }
        return len;
    }
}