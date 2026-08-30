public class RemovingMinAndMax {

    public static int minimumDeletions(int[] nums) {

        int n = nums.length;

        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 1; i < n; i++) {

            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }

            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        int left = Math.min(minIndex, maxIndex);
        int right = Math.max(minIndex, maxIndex);

        int removeFront = right + 1;
        int removeBack = n - left;
        int removeBoth = (left + 1) + (n - right);

        return Math.min(removeFront,
                Math.min(removeBack, removeBoth));
    }

    public static void main(String[] args) {

        int[] nums1 = {2, 10, 7, 5, 4, 1, 8, 6};
        int[] nums2 = {0, -4, 19, 1, 8, -2, -3, 5};
        int[] nums3 = {101};

        System.out.println("Example 1: " + minimumDeletions(nums1));
        System.out.println("Example 2: " + minimumDeletions(nums2));
        System.out.println("Example 3: " + minimumDeletions(nums3));
    }
}