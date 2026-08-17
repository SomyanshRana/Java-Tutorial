import java.util.*;

public class MaximumPointsFromCards {

    public static int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;

        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }

        int maxSum = sum;

        for (int i = 1; i <= k; i++) {

            sum = sum - cardPoints[k - i];
            sum = sum + cardPoints[n - i];

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of cards: ");
        int n = sc.nextInt();

        int[] cardPoints = new int[n];

        System.out.println("Enter card points:");

        for (int i = 0; i < n; i++) {
            cardPoints[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        int ans = maxScore(cardPoints, k);

        System.out.println("Maximum Score = " + ans);

        sc.close();
    }
}