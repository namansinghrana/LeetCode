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
    public int kthSmallest(TreeNode root, int k) {
        TreeNode ptr = root;
        Stack<TreeNode> stack = new Stack<>();

        while(ptr != null || !stack.isEmpty()){
            while(ptr != null){
                stack.add(ptr);
                ptr = ptr.left;
            }
            ptr = stack.pop();
            k--;
            if(k == 0){ 
                return ptr.val;
            }
            ptr = ptr.right;
        }
        return -1;
    }
}