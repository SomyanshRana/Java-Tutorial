import java.util.*;

public class ScoreofParenthesis {

    static class Solution {

        public int scoreOfParentheses(String s) {

            // Stack stores the score of each level
            Stack<Integer> stack = new Stack<>();

            // Score outside all parentheses
            stack.push(0);

            // Process every character
            for (char ch : s.toCharArray()) {

                // =================================
                // Opening parenthesis
                // =================================

                if (ch == '(') {

                    // Start a new level
                    stack.push(0);
                }


                // =================================
                // Closing parenthesis
                // =================================

                else {

                    // Score inside current parentheses
                    int current = stack.pop();


                    // Calculate score
                    //
                    // ()     -> 1
                    // (A)    -> 2 * score(A)

                    int score = Math.max(2 * current, 1);


                    // Get score of previous level
                    int previous = stack.pop();


                    // Add current score to previous level
                    stack.push(previous + score);
                }
            }

            // Final score
            return stack.pop();
        }
    }


    public static void main(String[] args) {

        // Test case
        String s = "(()())";


        // Create solution object
        Solution solution = new Solution();


        // Calculate score
        int answer = solution.scoreOfParentheses(s);


        // Print answer
        System.out.println("String: " + s);
        System.out.println("Score: " + answer);
    }
}