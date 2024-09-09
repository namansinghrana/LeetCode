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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] mat = new int[m][n];
        ListNode current = head;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                mat[i][j] = -1;
            }
        }

        int top=0,bottom=m-1,left=0,right=n-1;
        while(current != null && top <= bottom && left <= right){
               
                for(int i=left;i<=right && current!=null;i++){
                    mat[top][i] = current.val;
                    current = current.next;
                }
                top++;
                for(int i=top;i<=bottom && current!=null;i++){
                    mat[i][right]=current.val;
                    current = current.next;    
                }
                right--;

                for(int i=right;i>=left && current!=null;i--){
                    mat[bottom][i] = current.val;
                    current = current.next;
                }
                bottom--;
                
                for(int i=bottom;i>=top && current!=null;i--){
                    mat[i][left] = current.val;
                    current = current.next;
                }
                left++;

        }
        return mat;
    }
}