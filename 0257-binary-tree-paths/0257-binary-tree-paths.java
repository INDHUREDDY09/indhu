import java.util.*;

class Solution {

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> result = new ArrayList<>();

        findPaths(root, "", result);

        return result;
    }

    private void findPaths(TreeNode root, String path,
                            List<String> result) {

        if (root == null) {
            return;
        }

        // Add current node to path
        if (path.length() == 0) {
            path = String.valueOf(root.val);
        } else {
            path = path + "->" + root.val;
        }

        // If leaf, add path to result
        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }

        // Go left
        findPaths(root.left, path, result);

        // Go right
        findPaths(root.right, path, result);
    }
}