class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        for(String str : path.split("/")){
            if("".equals(str) || ".".equals(str)){
                continue;
            }
            if("..".equals(str)){
                stack.pollLast();
            }
            else{
                stack.offerLast(str);
            }
        }
        return "/" + String.join("/", stack);
    }
}