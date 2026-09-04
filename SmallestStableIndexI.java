public class SmallestStableIndexI {

    public static int firstStableIndex(int[] nums, int k) {

        int n = nums.length;

        int[] suffixMin = new int[n];
        suffixMin[n - 1] = nums[n - 1];

        // Build suffix minimum array
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(nums[i], suffixMin[i + 1]);
        }

        int prefixMax = 0;

        // Find first stable index
        for (int i = 0; i < n; i++) {

            prefixMax = Math.max(prefixMax, nums[i]);

            int score = prefixMax - suffixMin[i];

            if (score <= k) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] nums1 = {5, 0, 1, 4};
        int[] nums2 = {3, 2, 1};
        int[] nums3 = {0};

        System.out.println("Example 1: " + firstStableIndex(nums1, 3));
        System.out.println("Example 2: " + firstStableIndex(nums2, 1));
        System.out.println("Example 3: " + firstStableIndex(nums3, 0));
    }
}