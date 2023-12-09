class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        int peek = -1;
        while(left <= right){
            int mid = left+(right-left)/2;
            if(arr[mid+1] < arr[mid]){
                  peek = mid;
                  right = mid-1;
            }
            else if(arr[mid+1] > arr[mid]){
                  left = mid+1;
            }
        }
        return peek;
    }
}