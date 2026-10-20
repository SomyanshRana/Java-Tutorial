
public class MultiplyStrings {

    public static String multiply(String num1, String num2) {

        // If either number is zero, the answer is zero
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int m = num1.length();
        int n = num2.length();

        // Store the answer's digits
        int[] result = new int[m + n];

        // Multiply digits from right to left
        for (int i = m - 1; i >= 0; i--) {

            for (int j = n - 1; j >= 0; j--) {

                // Convert characters into integer digits
                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';

                // Multiply the two digits
                int product = digit1 * digit2;

                // Add the existing digit at this position
                int sum = product + result[i + j + 1];

                // Store the current digit
                result[i + j + 1] = sum % 10;

                // Add the carry to the left position
                result[i + j] += sum / 10;
            }
        }

        // Convert the result array into a string
        StringBuilder answer = new StringBuilder();

        for (int digit : result) {

            // Skip leading zeros
            if (answer.length() > 0 || digit != 0) {
                answer.append(digit);
            }
        }

        // Handle the case where the result is zero
        if (answer.length() == 0) {
            return "0";
        }

        return answer.toString();
    }

    public static void main(String[] args) {

        String num1 = "123";
        String num2 = "456";

        String answer = multiply(num1, num2);

        System.out.println("First number: " + num1);
        System.out.println("Second number: " + num2);
        System.out.println("Product: " + answer);
    }
}
