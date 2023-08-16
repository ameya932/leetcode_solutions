class Solution {
    public int maximumWealth(int[][] accounts) {
        int largest = accounts[0][0];
        for(int customer[] : accounts){
            int curr = 0;
            for(int wealth : customer){
                curr += wealth;
            }
            largest = Math.max(largest, curr);
        }
        return largest;
    }
}