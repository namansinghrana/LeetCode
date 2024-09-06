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
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        while(head != null && set.contains(head.val)){
            head = head.next;
        }

        while(curr != null){
            
            if(set.contains(curr.val)){
                if(prev != null){
                    prev.next = curr.next;
                }
            }else{
                prev = curr;
            }

            curr = curr.next;
            }
        return head;
    }
}