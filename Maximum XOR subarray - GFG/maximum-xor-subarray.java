//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            

            Solution ob = new Solution();
            
            System.out.println(ob.maxSubarrayXOR(N,arr));
            
            
        }
    }
}

// } Driver Code Ends


class Solution{
    static class Node{
        Node[] children = new Node[2];
        int val;
        
        public Node(){
            val = 0;    
            for(int i=0; i<2;i++){
                children[i] = null;
            }
        }
    }
    
    static void insert(Node n, int val){
        
        Node temp = n;
        
        for(int i=31; i>=0;i--){
            
            int digit = (val & (1<<i))>=1 ? 1:0;
            
            if(temp.children[digit]==null){
                temp.children[digit] = new Node();
            }
            
            temp = temp.children[digit];
            
        }
        
        temp.val = val;
        
    }
    
    static int search(Node n, int val){
        
        Node temp = n;
        
        for(int i=31;i>=0;i--){
            int digit = (val & (1<<i))>=1 ? 1:0;
            
            //find for an opposite child
            if(temp.children[1-digit]!=null){
                temp = temp.children[1-digit];
            }
            
            else{
                
                temp = temp.children[digit];
            }
        }
        
        return val^(temp.val);
    }
    static int maxSubarrayXOR(int N, int arr[]){
            
        Node n = new Node();
        
        insert(n,0);
        
        int xor = 0;
        int result = Integer.MIN_VALUE;
        
        for(int i : arr){
            xor = xor^i;
            insert(n, xor);  
            result = Math.max(result, search(n,xor));
        }
        return result;
    }
}