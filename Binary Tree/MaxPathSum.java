public class MaxPathSum {

    // Binary Tree Node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Stores the maximum path sum found so far
    static int maxSum = Integer.MIN_VALUE;

    // Returns the maximum one-sided path sum
    // that can be passed to the parent
    static int maxGain(TreeNode node) {

        // Base case
        if (node == null) {
            return 0;
        }

        // Find maximum gain from left subtree
        // Ignore it if it is negative
        int leftGain = Math.max(0, maxGain(node.left));

        // Find maximum gain from right subtree
        // Ignore it if it is negative
        int rightGain = Math.max(0, maxGain(node.right));

        // Maximum path passing through current node
        int currentPath = node.val + leftGain + rightGain;

        // Update global maximum
        maxSum = Math.max(maxSum, currentPath);

        // Return only ONE side to parent
        return node.val + Math.max(leftGain, rightGain);
    }

    static int maxPathSum(TreeNode root) {

        // Reset maxSum
        maxSum = Integer.MIN_VALUE;

        // Calculate maximum path
        maxGain(root);

        return maxSum;
    }

    public static void main(String[] args) {

        /*
                 -10
                 /  \
                9    20
                    /  \
                   15   7
        */

        TreeNode root = new TreeNode(-10);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int answer = maxPathSum(root);

        System.out.println("Maximum Path Sum = " + answer);
    }
}