class Solution {
    public int reverse(int x) {
        boolean neg = false;
        long rev = 0;
        if(x < 0){
            neg = true;
            x = -x;
        }
        while(x > 0){
            int rem = x%10;
            rev = rev*10+rem;
            x = x/10;
        }
        if(rev > Integer.MAX_VALUE){
            return 0;
        }
        return (int)(neg ? -rev : rev);
    }
}