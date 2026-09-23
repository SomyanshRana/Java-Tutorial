import java.util.*;

public class ZigZagTraversal {

    // Binary Tree Node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        // Empty tree
        if (root == null) {
            return result;
        }

        // Queue for BFS
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        // First level goes from left to right
        boolean leftToRight = true;

        while (!queue.isEmpty()) {

            // Number of nodes in current level
            int size = queue.size();

            List<Integer> currentLevel = new ArrayList<>();

            // Process current level
            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();

                // Add current node
                currentLevel.add(node.val);

                // Add left child
                if (node.left != null) {
                    queue.offer(node.left);
                }

                // Add right child
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            // If direction is right to left,
            // reverse the current level
            if (!leftToRight) {
                Collections.reverse(currentLevel);
            }

            // Add current level to answer
            result.add(currentLevel);

            // Change direction
            leftToRight = !leftToRight;
        }

        return result;
    }

    public static void main(String[] args) {

        /*
                 3
                / \
               9   20
                  /  \
                 15   7
        */

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> answer = zigzagLevelOrder(root);

        System.out.println("Zigzag Level Order: " + answer);
    }
}
