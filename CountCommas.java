public class CountCommas {

    public static int countCommas(int n) {
        return Math.max(0, n - 999);
    }

    public static void main(String[] args) {

        System.out.println("n = 998 -> " + countCommas(998));
        System.out.println("n = 1000 -> " + countCommas(1000));
        System.out.println("n = 1002 -> " + countCommas(1002));
        System.out.println("n = 50000 -> " + countCommas(50000));
        System.out.println("n = 100000 -> " + countCommas(100000));
    }
}