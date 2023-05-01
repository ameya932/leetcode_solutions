class Solution {
    public int longestPalindrome(String s) {
        int[] counts = new int[128];
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            counts[c]++;
        }
        int length = 0;
        boolean oddFreq = false;
        for(int count : counts){
            if(count%2==0){
                length += count;
            }
            else{
                length += count-1;
                oddFreq = true;
            }
        }
        if(oddFreq){
            length++;
        }
        return length;
    }
}