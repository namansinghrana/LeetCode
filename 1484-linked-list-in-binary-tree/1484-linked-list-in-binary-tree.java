/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    List<TreeNode> storingList = new ArrayList<>();
    public boolean isSubPath(ListNode head, TreeNode root) {

        StoredList(head,root);
        for(TreeNode element : storingList){
            if(CheckList(head, element)){
                return true;
            }
        }
        return false;
    }

    public void StoredList(ListNode head, TreeNode root){
        if(head == null || root == null) return;

        if(head.val == root.val){
            storingList.add(root);
        }
        StoredList(head, root.left);
        StoredList(head, root.right);
    }


    public boolean CheckList(ListNode head,TreeNode node){
        if(head == null) return true;
        if(node == null) return false;

        if(head.val == node.val){
            return (CheckList(head.next, node.left) || CheckList(head.next, node.right));
        }
        return false;
    }
}