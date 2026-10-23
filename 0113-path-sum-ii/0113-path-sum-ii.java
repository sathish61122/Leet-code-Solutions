import java.util.*;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        findPaths(root, targetSum, path, result);

        return result;
    }

    private void findPaths(TreeNode node, int targetSum,
                           List<Integer> path,
                           List<List<Integer>> result) {
        if (node == null) {
            return;
        }

        path.add(node.val);
        targetSum -= node.val;

        // Check if the node is a leaf and the sum matches
        if (node.left == null && node.right == null
                && targetSum == 0) {
            result.add(new ArrayList<>(path));
        } else {
            findPaths(node.left, targetSum, path, result);
            findPaths(node.right, targetSum, path, result);
        }

        // Backtrack
        path.remove(path.size() - 1);
    }
}