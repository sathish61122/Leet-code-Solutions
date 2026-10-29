class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next;
            ListNode prev = dummy;

            // Find the correct insertion position
            while (prev.next != null &&
                   prev.next.val <= curr.val) {
                prev = prev.next;
            }

            // Insert current node into sorted list
            curr.next = prev.next;
            prev.next = curr;

            curr = nextNode;
        }

        return dummy.next;
    }
}