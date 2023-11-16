class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<nums.length; i++){
            char curr = nums[i].charAt(i);
            char oppo = (curr=='0')?'1':'0';
            ans.append(oppo);
        }
        return ans.toString();
    }
}