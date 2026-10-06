public class Main {

    static class MinAddforVaid {

        public int minAddToMakeValid(String s) {

            // Number of unmatched '('
            int open = 0;

            // Number of '(' we need to add
            // because of unmatched ')'
            int add = 0;


            // Process every character
            for (char ch : s.toCharArray()) {

                // =================================
                // Opening parenthesis
                // =================================

                if (ch == '(') {

                    open++;
                }


                // =================================
                // Closing parenthesis
                // =================================

                else {

                    // If we have an unmatched '(',
                    // this ')' can match it
                    if (open > 0) {

                        open--;
                    }

                    // Otherwise this ')' has no
                    // matching '('
                    else {

                        add++;
                    }
                }
            }


            // 'add' = '(' needed for unmatched ')'
            // 'open' = ')' needed for unmatched '('

            return add + open;
        }
    }


    public static void main(String[] args) {

        // Test case
        String s = "()))((";


        // Create Solution object
        Solution solution = new Solution();


        // Calculate answer
        int answer =
                solution.minAddToMakeValid(s);


        // Print result
        System.out.println("String: " + s);
        System.out.println("Minimum additions needed: " + answer);
    }
}