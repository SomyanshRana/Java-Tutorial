import java.util.Arrays;

public class NonOverlappingIntervals {

    public static int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int removed = 0;

        int lastEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] >= lastEnd) {

                lastEnd = intervals[i][1];

            } else {

                removed++;
            }
        }

        return removed;
    }

    public static void main(String[] args) {

        int[][] intervals1 = {
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 3}
        };

        int[][] intervals2 = {
                {1, 2},
                {1, 2},
                {1, 2}
        };

        int[][] intervals3 = {
                {1, 100},
                {2, 3},
                {3, 4},
                {4, 5}
        };

        System.out.println("Example 1: " +
                eraseOverlapIntervals(intervals1));

        System.out.println("Example 2: " +
                eraseOverlapIntervals(intervals2));

        System.out.println("Example 3: " +
                eraseOverlapIntervals(intervals3));
    }
}