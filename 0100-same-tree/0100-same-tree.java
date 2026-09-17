class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        // Both nodes are empty
        if (p == null && q == null) {
            return true;
        }

        // One node is empty and the other is not
        if (p == null || q == null) {
            return false;
        }

        // Values are different
        if (p.val != q.val) {
            return false;
        }

        // Check left subtree and right subtree
        return isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
    }
}