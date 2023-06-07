class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] total = new int[n];
        for(int[] booking : bookings){
            int first = booking[0]-1;
            int last = booking[1]-1;
            int seats = booking[2];
            total[first] += seats;
            if(last+1 < n){
                total[last+1] -= seats;
            }
        }
        for(int i=1; i<n; i++){
            total[i] += total[i-1];
        }
        return total;
    }
}