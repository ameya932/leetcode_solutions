class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0){
            return ans;
        }
        String arr[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder str = new StringBuilder("");
        solve(digits, 0, arr, ans, str);
        return ans;
    }
    public void solve(String digits, int idx, String arr[], List<String> ans, StringBuilder str){
        if(idx == digits.length()){
            ans.add(str.toString());
            return;
        }
        int val = digits.charAt(idx)-'0';
        for(int i=0; i<arr[val].length(); i++){
            str.append(arr[val].charAt(i));
            solve(digits, idx+1, arr, ans, str);
            str.deleteCharAt(str.length()-1);
        }
    }
}