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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        f(root, res, 0);
        return res;
    }
    public void f(TreeNode curr, List<Integer> res, int depth){
        if(curr == null){
            return;
        }
        if(depth == res.size()){
            res.add(curr.val);
        }
        f(curr.right, res, depth+1);
        f(curr.left, res, depth+1);
    }
}