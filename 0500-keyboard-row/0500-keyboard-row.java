class Solution {
    public String[] findWords(String[] words) {
        String r1 = "qwertyuiop";
        String r2 = "asdfghjkl";
        String r3 = "zxcvbnm";
        ArrayList<String> result = new ArrayList<>();
        for(String word : words){
            String lower = word.toLowerCase();
            boolean row1 = true;
            boolean row2 = true;
            boolean row3 = true;
            for(char c : lower.toCharArray()){
                if(!r1.contains(String.valueOf(c))){
                    row1 = false;
                }
                if(!r2.contains(String.valueOf(c))){
                    row2 = false;
                }
                if(!r3.contains(String.valueOf(c))){
                    row3 = false;
                }
            }
            if(row1 || row2 || row3){
                result.add(word);
            }
        }
        return result.toArray(new String[result.size()]);
    }
}