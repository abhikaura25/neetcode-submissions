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

        if (head == null) {
            return null;
        }

        Set<Integer> hashSet = new HashSet<Integer>();
        for (Integer num: nums) {
            hashSet.add(num);
        }

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode curr = dummyNode;

        while (curr.next != null) {
            if (hashSet.contains(curr.next.val)) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return dummyNode.next;
        
    }
}
