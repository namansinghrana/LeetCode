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

    public int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        int listLength = getLength(head);
        int partSize = listLength / k;
        int extraNodes = listLength % k;
        
        ListNode[] result = new ListNode[k];
        ListNode curr = head;
        
        for (int i = 0; i < k; i++) {
            ListNode partHead = curr;
            ListNode partTail = null;
            
            int eachPartSize = partSize;
            if (extraNodes > 0) {
                eachPartSize++;
                extraNodes--;
            }
            
            while (eachPartSize > 0 && curr != null) {
                partTail = curr;
                curr = curr.next;
                eachPartSize--;
            }
            
            if (partTail != null) {
                partTail.next = null; // Cut off the current part
            }
            
            result[i] = partHead; // Assign the head of the current part
        }
        
        return result;
    }
}