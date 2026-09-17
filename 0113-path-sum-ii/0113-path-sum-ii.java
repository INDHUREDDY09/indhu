import java.util.*;

class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        findPaths(root, targetSum, path, result);

        return result;
    }

    private void findPaths(TreeNode root, int targetSum,
                            List<Integer> path,
                            List<List<Integer>> result) {

        // Empty node
        if (root == null) {
            return;
        }

        // Add current node to path
        path.add(root.val);

        // Check if it is a leaf
        if (root.left == null && root.right == null) {

            if (targetSum == root.val) {
                result.add(new ArrayList<>(path));
            }
        }

        // Go to left and right
        findPaths(root.left, targetSum - root.val, path, result);
        findPaths(root.right, targetSum - root.val, path, result);

        // Backtrack
        path.remove(path.size() - 1);
    }
}