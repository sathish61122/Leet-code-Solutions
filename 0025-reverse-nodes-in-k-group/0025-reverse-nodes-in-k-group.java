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
    public ListNode reverseKGroup(ListNode head, int k) {
        // 1. Check if there are at least k nodes left in the list
        ListNode curr = head;
        int count = 0;
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        // 2. If we have k nodes, reverse them
        if (count == k) {
            ListNode prev = null;
            ListNode current = head;
            ListNode next = null;
            
            // Standard linked list reversal for k nodes
            for (int i = 0; i < k; i++) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }

            // 3. After reversal, 'head' is now the tail of this group.
            // Recursively call for the rest of the list and connect it.
            if (next != null) {
                head.next = reverseKGroup(next, k);
            }

            // 'prev' is the new head of this reversed group
            return prev;
        }

        // 4. If there are fewer than k nodes, return head as is (base case)
        return head;
    }
}
