/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<List<Integer>> lst = new ArrayList<>();
        if(root == null){
            return lst;
        }
        q.offer(root);
        boolean flag = true;
        while(!q.isEmpty()){
            int level = q.size();
            ArrayList<Integer> sub = new ArrayList<Integer>(level);
            for(int i=0; i<level; i++){
                int ind = i;
                if(q.peek().left != null){
                    q.offer(q.peek().left);
                }
                if(q.peek().right != null){
                    q.offer(q.peek().right);
                }
                if(flag == true){
                    sub.add(q.poll().val);
                }
                else{
                    sub.add(0, q.poll().val);
                }
            }
            flag = !flag;
            lst.add(sub);
        }
        return lst;
    }
}