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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(root.val == key){
            return f(root);
        }
        TreeNode dummy = root;
        while(root != null){
            if(root.val > key){
                if(root.left!=null && root.left.val==key){
                    root.left = f(root.left);
                    break;
                }
                else{
                    root = root.left;
                }
            }
            else{
                if(root.right!=null && root.right.val==key){
                    root.right = f(root.right);
                    break;
                }
                else{
                    root = root.right;
                }
            }
        }
        return dummy;
    }
    public TreeNode f(TreeNode root){
        if(root.left == null){
            return root.right;
        }
        else if(root.right == null){
            return root.left;
        }
        else{
            TreeNode rChild = root.right;
            TreeNode lRight = lastRight(root.left);
            lRight.right = rChild;
            return root.left;
        }
    }
    public TreeNode lastRight(TreeNode root){
        if(root.right == null){
            return root;
        }
        return lastRight(root.right);
    }
}