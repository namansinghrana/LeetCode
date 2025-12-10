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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length != postorder.length) return null;
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<inorder.length;i++) hm.put(inorder[i], i);
        return buildTree(inorder,postorder,0,inorder.length-1,0,postorder.length-1,hm);
    }

    private TreeNode buildTree(int[]inorder,int[]postorder,int is,int ie,int ps,int pe,Map<Integer, Integer> hm){
        if(is > ie || ps > pe) return null;
        TreeNode root = new TreeNode(postorder[pe]);
        int inRoot = hm.get(postorder[pe]);
        int numsLeft = inRoot - is;

        root.left = buildTree(inorder,postorder,is,inRoot-1,ps,ps+numsLeft-1,hm);
        root.right = buildTree(inorder,postorder,inRoot+1,ie,ps+numsLeft, pe-1, hm);

        return root;
    }
}
