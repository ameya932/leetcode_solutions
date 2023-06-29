class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String token : tokens){
            if(token.equals("+")){
                int x = st.pop();
                int y = st.pop();
                st.push(y+x);
            }
            else if(token.equals("-")){
                int x = st.pop();
                int y = st.pop();
                st.push(y-x);
            }
            else if(token.equals("*")){
                int x = st.pop();
                int y = st.pop();
                st.push(y*x);
            }
            else if(token.equals("/")){
                int x = st.pop();
                int y = st.pop();
                st.push(y/x);
            }
            else{
                st.push(Integer.parseInt(token));
            }
        }
        return st.peek();
    }
}