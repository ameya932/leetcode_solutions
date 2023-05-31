class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int count = k;
        for(int num : nums){
            if(num == 0){
                count++;
            }
            else{
                if(count<k){
                    return false;
                }
                count = 0;
            }
        }
        return true;
    }
}