import java.util.*;

public class InsertInterval {

    public static int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();

        for (int[] interval : intervals) {

            // Case 1: No overlap, interval comes before newInterval
            if (interval[1] < newInterval[0]) {
                result.add(interval);
            }

            // Case 2: No overlap, interval comes after newInterval
            else if (interval[0] > newInterval[1]) {
                result.add(newInterval);
                newInterval = interval;
            }

            // Case 3: Overlap
            else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }

        result.add(newInterval);

        return result.toArray(new int[result.size()][]);
    }

    public static void printIntervals(int[][] intervals) {
        System.out.print("[");
        for (int i = 0; i < intervals.length; i++) {
            System.out.print(Arrays.toString(intervals[i]));
            if (i != intervals.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {

        int[][] intervals1 = {{1,3},{6,9}};
        int[] newInterval1 = {2,5};

        int[][] result1 = insert(intervals1, newInterval1);

        System.out.print("Example 1: ");
        printIntervals(result1);

        int[][] intervals2 = {
                {1,2},
                {3,5},
                {6,7},
                {8,10},
                {12,16}
        };

        int[] newInterval2 = {4,8};

        int[][] result2 = insert(intervals2, newInterval2);

        System.out.print("Example 2: ");
        printIntervals(result2);
    }
}