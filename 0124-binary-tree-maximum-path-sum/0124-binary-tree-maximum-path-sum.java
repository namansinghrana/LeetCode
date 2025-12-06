// New code with understading of calculating the maximum path along with calculating height and handling negative values.

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
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        height(root, max);
        return max[0];
    }

    private int height(TreeNode root,int[] max){
        if(root == null) return 0;
        
        //go left and then right
        int left = Math.max(0, height(root.left, max));
        int right = Math.max(0, height(root.right, max));

        // now at every moment check if you found out the max path.
        max[0] = Math.max(max[0], left + right + root.val);

        return root.val + Math.max(left, right);
    }
}
