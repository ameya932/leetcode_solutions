class Solution {
    public String sortVowels(String s) {
        int length = s.length();
        ArrayList<Character> vowelsList = new ArrayList<>();
        ArrayList<Integer> vowelPositions = new ArrayList<>();
        for (int i=0; i<length; i++){
            char currentChar = s.charAt(i);
            if (currentChar=='a' || currentChar=='e' || currentChar=='i' || 
                currentChar=='o' || currentChar=='u' || currentChar=='A' || 
                currentChar=='E' || currentChar=='I' || currentChar=='O' || 
                currentChar=='U') {
                vowelsList.add(currentChar);
                vowelPositions.add(i);
            }
        }
        Collections.sort(vowelsList);
        char[] resultArray = s.toCharArray();
        for (int i=0; i<vowelPositions.size(); i++) {
            resultArray[vowelPositions.get(i)] = vowelsList.get(i);
        }
        return new String(resultArray);
    }
}