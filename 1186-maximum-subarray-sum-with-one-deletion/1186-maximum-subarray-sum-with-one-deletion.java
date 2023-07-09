class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        int[] f = new int[n];
        int[] b = new int[n];
        int maxSum = arr[0];
        f[0] = arr[0];
        for(int i=1; i<n; i++){
            f[i] = Math.max(arr[i], f[i-1]+arr[i]);
            maxSum = Math.max(maxSum, f[i]);
        }
        b[n-1] = arr[n-1];
        for(int i=n-2; i>=0; i--){
            b[i] = Math.max(arr[i], b[i+1]+arr[i]);
        }
        for(int i=1; i<n-1; i++){
            maxSum = Math.max(maxSum, f[i-1]+b[i+1]);
        }
        return maxSum;
    }
}