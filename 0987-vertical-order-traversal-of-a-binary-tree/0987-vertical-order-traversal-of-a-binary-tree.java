import java.util.*;

class Solution {

    class Pair {
        TreeNode node;
        int row;
        int col;

        Pair(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        // col -> row -> values
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map
            = new TreeMap<>();

        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(root, 0, 0));

        while (!queue.isEmpty()) {

            Pair current = queue.poll();

            TreeNode node = current.node;
            int row = current.row;
            int col = current.col;

            // Create column if not present
            map.putIfAbsent(col, new TreeMap<>());

            // Create row if not present
            map.get(col).putIfAbsent(row, new PriorityQueue<>());

            // Add node value
            map.get(col).get(row).add(node.val);

            // Left child
            if (node.left != null) {
                queue.add(new Pair(node.left, row + 1, col - 1));
            }

            // Right child
            if (node.right != null) {
                queue.add(new Pair(node.right, row + 1, col + 1));
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        // Read columns from left to right
        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {

            List<Integer> column = new ArrayList<>();

            // Read rows from top to bottom
            for (PriorityQueue<Integer> values : rows.values()) {

                // Values at same row and column are sorted
                while (!values.isEmpty()) {
                    column.add(values.poll());
                }
            }

            result.add(column);
        }

        return result;
    }
}
