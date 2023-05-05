class Solution {
    public int maxVowels(String s, int k) {
        int max = 0;
        int vowels = 0;
        for(int i=0; i<k; i++){
            char ch = s.charAt(i);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                vowels++;
            }
        }
        max = vowels;
        for(int i=k; i<s.length(); i++){
            char ch = s.charAt(i-k);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                vowels--;
            }
            ch = s.charAt(i);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                vowels++;
            }
            max = Math.max(max, vowels);
        }
        return max;
    }
}