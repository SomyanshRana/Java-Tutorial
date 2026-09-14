public class RectangleOverlap {

    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {

        int overlapWidth =
                Math.min(rec1[2], rec2[2])
                - Math.max(rec1[0], rec2[0]);

        int overlapHeight =
                Math.min(rec1[3], rec2[3])
                - Math.max(rec1[1], rec2[1]);

        return overlapWidth > 0 && overlapHeight > 0;
    }

    public static void main(String[] args) {

        // Example 1
        int[] rec1 = {0, 0, 2, 2};
        int[] rec2 = {1, 1, 3, 3};

        System.out.println(
                "Example 1: "
                + isRectangleOverlap(rec1, rec2)
        );

        // Example 2 - Only touching
        int[] rec3 = {0, 0, 1, 1};
        int[] rec4 = {1, 0, 2, 1};

        System.out.println(
                "Example 2: "
                + isRectangleOverlap(rec3, rec4)
        );

        // Example 3 - Completely separate
        int[] rec5 = {0, 0, 1, 1};
        int[] rec6 = {2, 2, 3, 3};

        System.out.println(
                "Example 3: "
                + isRectangleOverlap(rec5, rec6)
        );
    }
}