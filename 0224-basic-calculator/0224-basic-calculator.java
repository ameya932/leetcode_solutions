class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<Integer>();
        int result = 0, num = 0, sign = 1;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num*10+(int)(c-'0');
            }
            if(c == '+'){
                result += sign*num;
                num = 0;
                sign = 1;
            }
            else if(c == '-'){
                result += sign*num;
                num = 0;
                sign = -1;
            }
            else if(c == '('){
                st.push(result);
                st.push(sign);
                result = 0;
                sign = 1;
            }
            else if(c == ')'){
                result += sign*num;
                num = 0;
                result *= st.pop();
                result += st.pop();
            }
        }
        if(num != 0){
            result += sign*num;
        }
        return result;
    }
}