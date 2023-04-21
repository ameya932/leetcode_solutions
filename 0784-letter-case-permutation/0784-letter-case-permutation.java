class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        if(s == null){
            return result;
        }
        generatePermutations(s.toCharArray(), 0, result);
        return result;
    }
    private static void generatePermutations(char[] s, int index, List<String> result){
        if(index == s.length){
            result.add(new String(s));
            return;
        }
        if(Character.isLetter(s[index])){
            s[index] = Character.toLowerCase(s[index]);
            generatePermutations(s, index+1, result);
            s[index] = Character.toUpperCase(s[index]);
            generatePermutations(s, index+1, result);
        }
        else{
            generatePermutations(s, index+1, result);
        }
    }
}