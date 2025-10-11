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
    public ListNode middleNode(ListNode head) {
        ListNode ptr = head;
        int n=0;
        while(ptr != null){ n++; ptr = ptr.next; }
        ListNode answer=new ListNode();
        ptr = head;
        int mid = n/2;
        while(mid-- > 0){ ptr =ptr.next;}
        return ptr;
    }
}