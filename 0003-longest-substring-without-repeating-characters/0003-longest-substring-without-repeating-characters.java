class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastOccurence = new int[256];
        Arrays.fill(lastOccurence, -1);
        int maxLength = 0;
        int start = 0;
        for(int end=0; end<s.length(); end++){
            char c = s.charAt(end);
            int lastIndex = lastOccurence[c];
            if(lastIndex!=-1 && lastIndex>=start){
                start = lastIndex+1;
            }
            lastOccurence[c] = end;
            maxLength = Math.max(maxLength, end-start+1);
        }
        return maxLength;
    }
}