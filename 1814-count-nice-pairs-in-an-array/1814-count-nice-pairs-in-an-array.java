class Solution {
    public int countNicePairs(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = nums.length;
        int sum = 0;
        int mod = (int)1e9+7;
        for(int i=0; i<n; i++){
            StringBuilder sb = new StringBuilder(""+nums[i]);
            sb = sb.reverse();
            int rev = Integer.parseInt(sb.toString());
            int diff = nums[i]-rev;
            int val = hm.getOrDefault(diff, 0);
            hm.put(diff, val+1);
            sum = (sum+val)%mod;
        }
        return sum;
    }
}