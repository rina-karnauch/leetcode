public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        String p2, xs = Integer.toString(x);
        int len = xs.length();

        if (len == 1) {
            return true;
        }

        String p1 = xs.substring(0, len / 2);
        if (len % 2 == 0) {
            p2 = xs.substring(len / 2);
        } else {
            p2 = xs.substring(len / 2 + 1);
        }
        p2 = new StringBuilder(p2).reverse().toString();
        return p1.equals(p2);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(0));
    }
}
