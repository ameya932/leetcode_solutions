class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for(String ops : operations){
            if(ops.equals("C")){
                if(!stack.isEmpty()){
                    sum -= stack.pop();
                }
            }
            else if(ops.equals("D")){
                if(!stack.isEmpty()){
                    int score = stack.peek()*2;
                    stack.push(score);
                    sum += score;
                }
            }
            else if(ops.equals("+")){
                if(stack.size()>=2){
                    int score1 = stack.pop();
                    int score2 = stack.peek();
                    stack.push(score1);
                    stack.push(score1+score2);
                    sum += score1+score2;
                }
            }
            else{
                int score = Integer.parseInt(ops);
                stack.push(score);
                sum += score;
            }
        }
        return sum;
    }
}