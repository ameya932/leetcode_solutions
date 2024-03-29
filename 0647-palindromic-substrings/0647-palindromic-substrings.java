class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        int ans = 0;
        for(int i=0; i<len; i++){
            int j = i-1;
            int k = i;
            while(k<len-1 && s.charAt(k)==s.charAt(k+1)){
                k++;
            }
            ans += (k-j)*(k-j+1)/2;
            i = k++;
            while(j>=0 && k<len && s.charAt(k++)==s.charAt(j--)){
                ans++;
            }
        }
        return ans;
    }
}