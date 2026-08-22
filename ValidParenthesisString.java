public class ValidParenthesisString {

    public static boolean checkValidString(String s) {

        int low = 0;
        int high = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                low++;
                high++;
            }

            else if (ch == ')') {
                low--;
                high--;
            }

            else { // '*'
                low--;
                high++;
            }

            if (high < 0) {
                return false;
            }

            if (low < 0) {
                low = 0;
            }
        }

        return low == 0;
    }

    public static void main(String[] args) {

        String s1 = "()";
        String s2 = "(*)";
        String s3 = "(*))";
        String s4 = ")(";
        String s5 = "((*)";

        System.out.println(s1 + " -> " + checkValidString(s1));
        System.out.println(s2 + " -> " + checkValidString(s2));
        System.out.println(s3 + " -> " + checkValidString(s3));
        System.out.println(s4 + " -> " + checkValidString(s4));
        System.out.println(s5 + " -> " + checkValidString(s5));
    }
}