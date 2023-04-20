class Solution {
    private int[] nums;
    private Random rand;
    public Solution(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }
    
    public int[] reset() {
        return nums;
    }
    
    public int[] shuffle() {
        int[] shuffled = nums.clone();
        for(int i=shuffled.length-1; i>0; i--){
            int j = rand.nextInt(i+1);
            int temp = shuffled[i];
            shuffled[i] = shuffled[j];
            shuffled[j] = temp;
        }
        return shuffled;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */