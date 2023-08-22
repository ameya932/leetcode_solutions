class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int diff = 2*(numRows-1);
        int diagDiff = diff;
        for(int i=0; i<numRows; i++){
            int ind = i;
            while(ind < n){
                sb.append(s.charAt(ind));
                if(i!=0 && i!=numRows-1){
                    diagDiff = diff-2*i;
                    int sec = ind+diagDiff;
                    if(sec < n){
                        sb.append(s.charAt(sec));
                    }
                }
                ind += diff;
            }
        }
        return sb.toString();
    }
}