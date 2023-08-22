class Solution {
    public boolean check(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxi = 0;
        int start = 0;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(check(s, i, j)){
                    if(j-i+1 > maxi){
                        maxi = j-i+1;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start+maxi);
    }
}