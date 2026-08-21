public class LemonadeChange {

    public static boolean lemonadeChange(int[] bills) {

        int five = 0;
        int ten = 0;

        for (int bill : bills) {

            if (bill == 5) {
                five++;
            }

            else if (bill == 10) {

                if (five == 0) {
                    return false;
                }

                five--;
                ten++;
            }

            else { // bill == 20

                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                }

                else if (five >= 3) {
                    five -= 3;
                }

                else {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[] bills1 = {5, 5, 5, 10, 20};
        System.out.println("Example 1: " + lemonadeChange(bills1));

        int[] bills2 = {5, 5, 10, 10, 20};
        System.out.println("Example 2: " + lemonadeChange(bills2));

        int[] bills3 = {5, 5, 10};
        System.out.println("Example 3: " + lemonadeChange(bills3));

        int[] bills4 = {10, 10};
        System.out.println("Example 4: " + lemonadeChange(bills4));
    }
}