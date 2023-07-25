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
    private TreeNode build(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, HashMap<Integer, Integer> mpp){
        if(is>ie || ps>pe){
            return null;
        }
        TreeNode root = new TreeNode(postorder[pe]);
        int inRoot = mpp.get(postorder[pe]);
        int numsLeft = inRoot-is;
        root.left = build(inorder, is, inRoot-1, postorder, ps, ps+numsLeft-1, mpp);
        root.right = build(inorder, inRoot+1, ie, postorder, ps+numsLeft, pe-1, mpp);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null || postorder==null || inorder.length!=postorder.length){
            return null;
        }
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            mpp.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, mpp);
    }
}