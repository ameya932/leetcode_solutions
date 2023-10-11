class Solution {
    private int search(int[] arr, int target) {
        int low = 0, high = arr.length-1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(target >= arr[mid]){
                low = mid+1;
            } 
            else{
                high = mid-1;
            }
        }
        return high+1;
    } 
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n = flowers.length;
        int[] bloom = new int[n];
        int[] out = new int[n];
        for(int i=0; i<n; i++){
            bloom[i] = flowers[i][0];
            out[i] = flowers[i][1];
        }
        Arrays.sort(bloom);
        Arrays.sort(out);
        n = people.length;
        int[] res = new int[n];
        for(int i=0; i<n; i++){
            int bloomed = search(bloom, people[i]);
            int bloomedOut = search(out, people[i]-1);
            res[i] = bloomed-bloomedOut;
        }
        return res;
    }
}