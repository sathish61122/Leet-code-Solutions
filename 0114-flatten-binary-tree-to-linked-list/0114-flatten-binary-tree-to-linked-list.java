class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode leftSubtree = root.left;
        TreeNode rightSubtree = root.right;

        // Move the left subtree to the right
        root.left = null;
        root.right = leftSubtree;

        // Find the end of the moved subtree
        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }

        // Attach the original right subtree
        current.right = rightSubtree;
    }
}