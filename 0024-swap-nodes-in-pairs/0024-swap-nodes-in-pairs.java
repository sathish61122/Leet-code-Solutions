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
        // Create a dummy node to act as the predecessor of the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Ensure there are at least two nodes to swap
        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = prev.next.next;

            // Swapping logic
            // 1. Point first node to the node after the pair
            first.next = second.next;
            // 2. Point second node back to the first node
            second.next = first;
            // 3. Point the previous node (or dummy) to the new first node (second)
            prev.next = second;

            // Move the prev pointer two nodes ahead for the next iteration
            prev = first;
        }

        return dummy.next;
    }
}
