import java.util.Arrays;

public class Assign_Cookies {

    public static int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0; // Child pointer
        int j = 0; // Cookie pointer

        while (i < g.length && j < s.length) {

            if (s[j] >= g[i]) {
                i++; // Child is satisfied
            }

            j++; // Move to next cookie
        }

        return i;
    }

    public static void main(String[] args) {

        int[] greed = {1, 2, 3};
        int[] cookies = {1, 1};

        int ans = findContentChildren(greed, cookies);

        System.out.println("Maximum satisfied children = " + ans);

        // Example 2
        int[] greed2 = {1, 2};
        int[] cookies2 = {1, 2, 3};

        System.out.println("Maximum satisfied children = "
                + findContentChildren(greed2, cookies2));
    }
}