class Solution {
    public int calc(int arr[]){
        int n = arr.length;
        int right[] = new int[n];
        int left[] = new int[n];
        Stack<Integer> st = new Stack<>();
        right[n-1] = n;
        st.push(n-1);
        for(int i=n-2; i>=0; i--){
            if(arr[st.peek()] < arr[i]){
                right[i] = st.peek();
            }
            else{
                while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    right[i] = n;
                }
                else{
                    right[i] = st.peek();
                }
            }
            st.push(i);
        }
        st.clear();
        left[0] = -1;
        st.push(0);
        for(int i=1; i<n; i++){
            if(arr[st.peek()] < arr[i]){
                left[i] = st.peek();
            }
            else{
                while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    left[i] = -1;
                }
                else{
                    left[i] = st.peek();
                }
            }
            st.push(i);
        }
        int ans = 0;
        for(int i=0; i<n; i++){
           int area = arr[i]*(right[i]-left[i]-1);
           ans = Math.max(area, ans);
        }
       return ans;
    }
    public int largestRectangleArea(int[] arr) {
        return calc(arr);
    }
}