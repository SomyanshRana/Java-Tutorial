import java.util.*;

public class RightSideView {

    // ==========================================
    // TreeNode class
    // ==========================================

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }


    // ==========================================
    // Solution class
    // ==========================================

    static class Solution {

        public List<Integer> rightSideView(TreeNode root) {

            List<Integer> result = new ArrayList<>();

            // If tree is empty
            if (root == null) {
                return result;
            }

            // Queue for BFS
            Queue<TreeNode> queue = new LinkedList<>();

            // Add root
            queue.offer(root);


            // ======================================
            // BFS
            // ======================================

            while (!queue.isEmpty()) {

                // Number of nodes in current level
                int size = queue.size();


                // Process current level
                for (int i = 0; i < size; i++) {

                    TreeNode node = queue.poll();


                    // Last node of this level
                    // is visible from right side
                    if (i == size - 1) {
                        result.add(node.val);
                    }


                    // Add left child
                    if (node.left != null) {
                        queue.offer(node.left);
                    }


                    // Add right child
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }

            return result;
        }
    }


    // ==========================================
    // MAIN METHOD
    // ==========================================

    public static void main(String[] args) {

        /*
                 1
                / \
               2   3
              / \   \
             4   5   6
        */


        // Create root
        TreeNode root = new TreeNode(1);


        // Level 2
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);


        // Level 3
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(6);


        // Create solution object
        Solution solution = new Solution();


        // Find right side view
        List<Integer> answer =
                solution.rightSideView(root);


        // Print answer
        System.out.println("Right side view:");
        System.out.println(answer);
    }
}