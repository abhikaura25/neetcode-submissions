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
    public ListNode swapNodes(ListNode head, int k) {

        if (head == null) {
            return null;
        }

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode curr = dummyNode;

        int length = 0;

        ListNode first = null;
    
        while (curr.next != null) {

            if (length == k-1) {
                first = curr.next;
            }
            length++;
            curr = curr.next;
        }

        int kFromEnd = length - k + 1;

        curr = dummyNode;
        length = 0;

        if ( k == kFromEnd) { // Early Exit
            return head;
        }

        ListNode second = null;
        
        while (curr.next != null) {

            if (length == kFromEnd - 1) {
                second = curr.next;
                break;
            }
            length++;
            curr = curr.next;
        }

        //Now do the swap
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        return dummyNode.next;

    }
}
