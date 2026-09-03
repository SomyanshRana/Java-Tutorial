public class ConstructUniformParityArrayII {

    public static boolean uniformArray(int[] nums1) {

        int minOdd = Integer.MAX_VALUE;

        // Find the smallest odd number
        for (int num : nums1) {
            if (num % 2 == 1) {
                minOdd = Math.min(minOdd, num);
            }
        }

        // If there are no odd numbers, all are even
        if (minOdd == Integer.MAX_VALUE) {
            return true;
        }

        // Check if any even number is smaller than the smallest odd
        for (int num : nums1) {
            if (num % 2 == 0 && num < minOdd) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 4, 7};
        int[] nums2 = {2, 3};
        int[] nums3 = {4, 6};
        int[] nums4 = {5, 8, 11};
        int[] nums5 = {8, 2, 5};

        System.out.println("Example 1: " + uniformArray(nums1));
        System.out.println("Example 2: " + uniformArray(nums2));
        System.out.println("Example 3: " + uniformArray(nums3));
        System.out.println("Example 4: " + uniformArray(nums4));
        System.out.println("Example 5: " + uniformArray(nums5));
    }
}