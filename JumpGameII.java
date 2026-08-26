public class JumpGameII {

    public static int jump(int[] nums) {

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            farthest = Math.max(farthest, i + nums[i]);

            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }

        return jumps;
    }

    public static void main(String[] args) {

        int[] nums1 = {2, 3, 1, 1, 4};
        int[] nums2 = {2, 3, 0, 1, 4};
        int[] nums3 = {1, 2, 1, 1, 1};
        int[] nums4 = {0};
        int[] nums5 = {1, 1, 1, 1};

        System.out.println("Example 1: " + jump(nums1));
        System.out.println("Example 2: " + jump(nums2));
        System.out.println("Example 3: " + jump(nums3));
        System.out.println("Example 4: " + jump(nums4));
        System.out.println("Example 5: " + jump(nums5));
    }
}