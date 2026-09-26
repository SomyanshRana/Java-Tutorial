public class CompleteTreeNodes {

    // TreeNode class
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Solution class
    static class Solution {

        public int countNodes(TreeNode root) {

            // If tree is empty
            if (root == null) {
                return 0;
            }

            // Find height by going left
            int leftHeight = getLeftHeight(root);

            // Find height by going right
            int rightHeight = getRightHeight(root);

            // If both heights are same,
            // tree is perfect
            if (leftHeight == rightHeight) {
                return (1 << leftHeight) - 1;
            }

            // Otherwise recursively count
            // left and right subtrees
            return 1 + countNodes(root.left)
                     + countNodes(root.right);
        }

        // Calculate leftmost height
        private int getLeftHeight(TreeNode node) {

            int height = 0;

            while (node != null) {
                height++;
                node = node.left;
            }

            return height;
        }

        // Calculate rightmost height
        private int getRightHeight(TreeNode node) {

            int height = 0;

            while (node != null) {
                height++;
                node = node.right;
            }

            return height;
        }
    }

    public static void main(String[] args) {

        /*
                 1
                / \
               2   3
              / \  /
             4  5 6
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);

        // Create Solution object
        Solution solution = new Solution();

        // Count nodes
        int answer = solution.countNodes(root);

        // Print answer
        System.out.println("Number of nodes = " + answer);
    }
}