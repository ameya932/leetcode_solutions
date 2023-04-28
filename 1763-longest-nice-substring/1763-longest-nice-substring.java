class Solution {
    public String longestNiceSubstring(String s) {
        String longestNiceSubstring = "";
        for(int i=0; i<s.length(); i++){
            for(int j=i+1; j<=s.length(); j++){
                String substring = s.substring(i, j);
                if(isNice(substring) && substring.length()>longestNiceSubstring.length()){
                    longestNiceSubstring = substring;
                }
            }
        }
        return longestNiceSubstring;
    }
    private boolean isNice(String s) {
        Set<Character> upperCaseChars = new HashSet<>();
        Set<Character> lowerCaseChars = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upperCaseChars.add(c);
            } else {
                lowerCaseChars.add(c);
            }
        }
        for (char c : upperCaseChars) {
            if (!lowerCaseChars.contains(Character.toLowerCase(c))) {
                return false;
            }
        }
        for (char c : lowerCaseChars) {
            if (!upperCaseChars.contains(Character.toUpperCase(c))) {
                return false;
            }
        }
        return true;
    }
}