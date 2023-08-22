class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> mpp = new HashMap<>();
        int i = 0;
        int j = 0;
        int max = 0;
        while(j < n){
            mpp.put(s.charAt(j), mpp.getOrDefault(s.charAt(j), 0)+1);
            if(mpp.size() == j-i+1){
                max = Math.max(max, j-i+1);
                j++;
            }
            else if(mpp.size() < j-i+1){
                while(mpp.size() < j-i+1){
                    mpp.put(s.charAt(i), mpp.get(s.charAt(i))-1);
                    if(mpp.get(s.charAt(i)) == 0){
                        mpp.remove(s.charAt(i));
                    }
                    i++;
                }
                j++;
            }
        }
        return max;
    }
}