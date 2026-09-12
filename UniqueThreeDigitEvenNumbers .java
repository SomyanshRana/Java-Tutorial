import java.util.HashSet;
import java.util.Set;

class UniqueThreeDigitEvenNumbers {

    public static int totalNumbers(int[] digits) {

        Set<Integer> set = new HashSet<>();

        int n = digits.length;

        // Choose hundreds digit
        for (int i = 0; i < n; i++) {

            // A 3-digit number cannot start with 0
            if (digits[i] == 0) {
                continue;
            }

            // Choose tens digit
            for (int j = 0; j < n; j++) {

                // Cannot use the same digit occurrence
                if (j == i) {
                    continue;
                }

                // Choose units digit
                for (int k = 0; k < n; k++) {

                    // Cannot reuse the same digit occurrence
                    if (k == i || k == j) {
                        continue;
                    }

                    // Number must be even
                    if (digits[k] % 2 != 0) {
                        continue;
                    }

                    int number = digits[i] * 100
                               + digits[j] * 10
                               + digits[k];

                    // HashSet automatically removes duplicates
                    set.add(number);
                }
            }
        }

        return set.size();
    }

    public static void main(String[] args) {

        int[] digits1 = {2, 1, 3, 0};
        int[] digits2 = {2, 2, 4};
        int[] digits3 = {0, 0, 1};
        int[] digits4 = {1, 2, 3, 4};

        System.out.println(
                "Example 1: " + totalNumbers(digits1)
        );

        System.out.println(
                "Example 2: " + totalNumbers(digits2)
        );

        System.out.println(
                "Example 3: " + totalNumbers(digits3)
        );

        System.out.println(
                "Example 4: " + totalNumbers(digits4)
        );
    }
}