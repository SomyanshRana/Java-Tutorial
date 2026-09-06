public class SqrtX {

    public static int mySqrt(int x) {

        if (x < 2) {
            return x;
        }

        int left = 1;
        int right = x;
        int answer = 0;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Avoid overflow
            if (mid <= x / mid) {

                answer = mid;
                left = mid + 1;

            } else {

                right = mid - 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        System.out.println("sqrt(4) = " + mySqrt(4));
        System.out.println("sqrt(8) = " + mySqrt(8));
        System.out.println("sqrt(16) = " + mySqrt(16));
        System.out.println("sqrt(25) = " + mySqrt(25));
        System.out.println("sqrt(2147395599) = " + mySqrt(2147395599));
    }
}