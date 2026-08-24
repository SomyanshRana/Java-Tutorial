public class JumpGame {

    public static boolean canJump(int[] nums) {

        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {

            if (i > maxReach) {
                return false;
            }

            maxReach = Math.max(maxReach, i + nums[i]);
        }

        return true;
    }

    public static void main(String[] args) {

        int[] nums1 = {2, 3, 1, 1, 4};
        int[] nums2 = {3, 2, 1, 0, 4};
        int[] nums3 = {2, 0, 0};
        int[] nums4 = {0};
        int[] nums5 = {1, 2, 0, 1};

        System.out.println("Example 1: " + canJump(nums1));
        System.out.println("Example 2: " + canJump(nums2));
        System.out.println("Example 3: " + canJump(nums3));
        System.out.println("Example 4: " + canJump(nums4));
        System.out.println("Example 5: " + canJump(nums5));
    }
}