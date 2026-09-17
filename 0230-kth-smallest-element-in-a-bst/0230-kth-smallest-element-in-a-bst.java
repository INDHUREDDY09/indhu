import java.util.*;

class Solution {

    public int kthSmallest(TreeNode root, int k) {

        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {

            // Go to the leftmost node
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            // Visit node
            root = stack.pop();
            k--;

            // kth smallest found
            if (k == 0) {
                return root.val;
            }

            // Go to right subtree
            root = root.right;
        }

        return -1;
    }
}