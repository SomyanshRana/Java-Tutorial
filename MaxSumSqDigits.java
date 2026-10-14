
import java.util.Scanner;

public class MaxSumSqDigits {

    public static String maxSumOfSquares(int num, int sum) {

        // Check whether a valid number is possible
        if (sum > num * 9) {
            return "";
        }

        StringBuilder ans = new StringBuilder();

        // Build the answer one digit at a time
        for (int i = 0; i < num; i++) {

            // Choose the largest possible digit
            int digit = Math.min(9, sum);

            // Add the digit to the answer
            ans.append(digit);

            // Update the remaining sum
            sum = sum - digit;
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of digits: ");
        int num = sc.nextInt();

        System.out.print("Enter required digit sum: ");
        int sum = sc.nextInt();

        String result = maxSumOfSquares(num, sum);

        System.out.println("Answer: \"" + result + "\"");

        sc.close();
    }
}

