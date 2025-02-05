 
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null){ return true; }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        if(Math.abs(leftDepth-rightDepth) > 1){ return false; }
        return isBalanced(root.left) && isBalanced(root.right);
    }
    public static int maxDepth(TreeNode node){
        if(node == null){ return 0; }
        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right)); 
    }
}