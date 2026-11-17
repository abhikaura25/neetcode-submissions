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
    public ListNode swapPairs(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode curr = dummyNode;

        while (curr.next != null && curr.next.next != null) {

            ListNode first = curr.next;
            ListNode second = first.next;
            
            first.next = second.next;
            second.next = first;
            curr.next = second;

            curr = first;

        }

        return dummyNode.next;
    }
}
