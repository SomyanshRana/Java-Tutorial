public class ConstructUniformParityArray {

    public static boolean uniformArray(int[] nums1) {
        return true;
    }

    public static void main(String[] args) {

        int[] nums1 = {2, 3};
        int[] nums2 = {4, 6};
        int[] nums3 = {1, 3, 5};
        int[] nums4 = {2, 5, 8, 9};

        System.out.println("Example 1: " + uniformArray(nums1));
        System.out.println("Example 2: " + uniformArray(nums2));
        System.out.println("Example 3: " + uniformArray(nums3));
        System.out.println("Example 4: " + uniformArray(nums4));
    }
}