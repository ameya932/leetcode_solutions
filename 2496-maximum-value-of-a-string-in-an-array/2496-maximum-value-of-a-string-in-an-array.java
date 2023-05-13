class Solution {
    public int maximumValue(String[] strs) {
        int maxVal = 0;
        for(String str : strs){
            int val = 0;
            for(char c : str.toCharArray()){
                if(Character.isDigit(c)){
                    val = val*10+(c-'0');
                }
                else{
                    val = str.length();
                    break;
                }
            }
            maxVal = Math.max(maxVal, val);
        }
        return maxVal;
    }
}