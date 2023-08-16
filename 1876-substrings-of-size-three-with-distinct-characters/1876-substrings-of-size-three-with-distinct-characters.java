class Solution {
    public int countGoodSubstrings(String str) {
        int count = 0;
        for(int i=0; i<str.length()-2; i++){
            String temp = str.substring(i, i+3);
            if(temp.charAt(0)!=temp.charAt(1) && temp.charAt(0)!=temp.charAt(2) && temp.charAt(1)!=temp.charAt(2)){
                count++;
            }
        }
        return count;
    }
}