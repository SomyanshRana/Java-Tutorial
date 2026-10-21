
public class MinOprToSort {

    public static int minOperations(String s) {
        int n = s.length();

        boolean sorted = true;
        char min = s.charAt(0);
        char max = s.charAt(0);

        // Step 1: Find min, max, and check sorted order
        for (int i = 1; i < n; i++) {
            char ch = s.charAt(i);

            if (ch < s.charAt(i - 1)) {
                sorted = false;
            }

            if (ch < min) {
                min = ch;
            }

            if (ch > max) {
                max = ch;
            }
        }

        // Step 2: Already sorted
        if (sorted) {
            return 0;
        }

        // Step 3: Cannot sort an unsorted 2-character string
        if (n == 2) {
            return -1;
        }

        // Step 4: One operation is enough
        if (s.charAt(0) == min || s.charAt(n - 1) == max) {
            return 1;
        }

        // Step 5: Check the middle characters
        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == min || s.charAt(i) == max) {
                return 2;
            }
        }

        // Step 6: Otherwise, three operations are needed
        return 3;
    }

    public static void main(String[] args) {
        String s1 = "dog";
        String s2 = "card";
        String s3 = "gf";
        String s4 = "abc";

        System.out.println("dog  -> " + minOperations(s1));
        System.out.println("card -> " + minOperations(s2));
        System.out.println("gf   -> " + minOperations(s3));
        System.out.println("abc  -> " + minOperations(s4));
    }
}
