class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        // Find the middle node
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Disconnect the left half
        if (prev != null) {
            prev.next = null;
        }

        TreeNode root = new TreeNode(slow.val);

        // Build left and right subtrees
        root.left = sortedListToBST(head == slow ? null : head);
        root.right = sortedListToBST(slow.next);

        return root;
    }
}