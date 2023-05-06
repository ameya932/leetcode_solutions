class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        while(left<=right){
            int pivot = partition(nums, left, right);
            if(pivot == n-k){
                return nums[pivot];
            }
            else if(pivot<n-k){
                left = pivot+1;
            }
            else{
                right = pivot-1;
            }
        }
        return -1;
    }
    private int partition(int[] nums, int left, int right){
        int pivot = right;
        int val = nums[pivot];
        int i = left;
        for(int j=left; j<right; j++){
            if(nums[j]<val){
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, pivot);
        return i;
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}