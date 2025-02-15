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
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private static int dfs(TreeNode node, int max){
        if(node == null){ return 0; }

        int res = (node.val >= max) ? 1 : 0;
        max =  Math.max(max, node.val);
        res += dfs(node.left, max);
        res += dfs(node.right, max);
        return res;
    }
}