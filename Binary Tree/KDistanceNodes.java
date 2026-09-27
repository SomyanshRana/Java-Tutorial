import java.util.*;

public class KDistanceNodes {

    // TreeNode class
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static class Solution {

        public List<Integer> distanceK(
                TreeNode root,
                TreeNode target,
                int k) {

            // ==========================================
            // STEP 1: Create parent map
            // ==========================================

            Map<TreeNode, TreeNode> parentMap = new HashMap<>();

            makeParentMap(root, null, parentMap);


            // ==========================================
            // STEP 2: BFS from target
            // ==========================================

            Queue<TreeNode> queue = new LinkedList<>();

            Set<TreeNode> visited = new HashSet<>();

            queue.offer(target);
            visited.add(target);

            int distance = 0;


            // ==========================================
            // STEP 3: BFS
            // ==========================================

            while (!queue.isEmpty()) {

                // We reached required distance
                if (distance == k) {

                    List<Integer> result = new ArrayList<>();

                    for (TreeNode node : queue) {
                        result.add(node.val);
                    }

                    return result;
                }


                // Number of nodes at current distance
                int size = queue.size();


                // Process current level
                for (int i = 0; i < size; i++) {

                    TreeNode current = queue.poll();


                    // ----------------------------------
                    // Move to LEFT child
                    // ----------------------------------

                    if (current.left != null &&
                            !visited.contains(current.left)) {

                        visited.add(current.left);
                        queue.offer(current.left);
                    }


                    // ----------------------------------
                    // Move to RIGHT child
                    // ----------------------------------

                    if (current.right != null &&
                            !visited.contains(current.right)) {

                        visited.add(current.right);
                        queue.offer(current.right);
                    }


                    // ----------------------------------
                    // Move to PARENT
                    // ----------------------------------

                    TreeNode parent = parentMap.get(current);

                    if (parent != null &&
                            !visited.contains(parent)) {

                        visited.add(parent);
                        queue.offer(parent);
                    }
                }


                // Move to next distance
                distance++;
            }

            return new ArrayList<>();
        }


        // ==========================================
        // Create child -> parent mapping
        // ==========================================

        private void makeParentMap(
                TreeNode node,
                TreeNode parent,
                Map<TreeNode, TreeNode> parentMap) {

            if (node == null) {
                return;
            }

            // Store parent
            parentMap.put(node, parent);

            // Process left subtree
            makeParentMap(node.left, node, parentMap);

            // Process right subtree
            makeParentMap(node.right, node, parentMap);
        }
    }


    // ==============================================
    // MAIN METHOD
    // ==============================================

    public static void main(String[] args) {

        /*
                 3
                / \
               5   1
              / \ / \
             6  2 0  8
               / \
              7   4
        */


        // Create nodes
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);


        // Target = node 5
        TreeNode target = root.left;

        // Distance
        int k = 2;


        // Create solution object
        Solution solution = new Solution();


        // Find nodes
        List<Integer> answer =
                solution.distanceK(root, target, k);


        // Print result
        System.out.println("Nodes at distance " + k +
                " from target " + target.val + ":");

        System.out.println(answer);
    }
}