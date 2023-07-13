class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int ans[] = new int[3];
        for(var s : triplets){
            if(s[0]<=target[0] && s[1]<=target[1] && s[2]<=target[2]){
                ans = new int[]{Math.max(ans[0],s[0]), Math.max(ans[1],s[1]), Math.max(ans[2],s[2])};
            }
        }
        return Arrays.equals(ans, target);
    }
}