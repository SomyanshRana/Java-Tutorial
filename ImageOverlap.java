import java.util.HashMap;
import java.util.Map;

public class ImageOverlap {

    public static int largestOverlap(int[][] img1, int[][] img2) {

        int n = img1.length;

        Map<String, Integer> map = new HashMap<>();

        int answer = 0;

        // Pick every 1 from img1
        for (int r1 = 0; r1 < n; r1++) {
            for (int c1 = 0; c1 < n; c1++) {

                if (img1[r1][c1] == 0) {
                    continue;
                }

                // Compare with every 1 from img2
                for (int r2 = 0; r2 < n; r2++) {
                    for (int c2 = 0; c2 < n; c2++) {

                        if (img2[r2][c2] == 0) {
                            continue;
                        }

                        // Calculate shift
                        int dr = r2 - r1;
                        int dc = c2 - c1;

                        String key = dr + "," + dc;

                        // Count this shift
                        int count = map.getOrDefault(key, 0) + 1;

                        map.put(key, count);

                        // Update answer
                        answer = Math.max(answer, count);
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        int[][] img1 = {
            {1, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };

        int[][] img2 = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 1}
        };

        int answer = largestOverlap(img1, img2);

        System.out.println("Maximum Overlap = " + answer);
    }
}