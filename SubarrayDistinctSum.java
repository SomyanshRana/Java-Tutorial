
import java.util.HashSet;

public class SubarrayDistinctSum {

    public static int sumCounts(int[] nums) {
        int n = nums.length;
        int ans = 0;

        // Choose the starting index
        for (int i = 0; i < n; i++) {

            // Store distinct elements
            HashSet<Integer> set = new HashSet<>();

            // Choose the ending index
            for (int j = i; j < n; j++) {

                // Add the current element
                set.add(nums[j]);

                // Count distinct elements
                int count = set.size();

                // Add the square to the answer
                ans = ans + count * count;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};

        int result = sumCounts(nums);

        System.out.println("Answer: " + result);
    }
}
