class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        // Check whether the current node is a leaf
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        int remainingSum = targetSum - root.val;

        return hasPathSum(root.left, remainingSum)
            || hasPathSum(root.right, remainingSum);
    }
}