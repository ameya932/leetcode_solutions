class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int max = 0;
        int prev = 0;
        for (int j=1; j<values.length; j++) {
            max = Math.max(max, values[prev]+values[j]+prev-j);
            if (values[j]+j > values[prev]+prev) {
                prev = j;
            }
        }
        return max;
    }
}