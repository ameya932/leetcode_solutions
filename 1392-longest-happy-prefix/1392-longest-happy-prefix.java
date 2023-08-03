class Solution {
    public String longestPrefix(String s) {
        int n = s.length();
        int dp[] = new int[n];
        int j = 0;
        for(int i=1; i<n; ++i){
            if(s.charAt(i) == s.charAt(j)){
                dp[i] = ++j;
            }
            else if(j > 0){
                j = dp[j-1];
                --i;
            }
        }
        return s.substring(0, j);
    }
}