public class ReverseInteger {
    public int reverse(int x) {
        try {
            int val = 0;
            if (x == 0) {
                return val;
            } else if (x < 0) {
                x = -1 * x;
                String xs = Integer.toString(x);
                xs = new StringBuilder(xs).reverse().toString();
                val = -1 * Integer.parseInt(xs);
            } else {
                String xs = Integer.toString(x);
                xs = new StringBuilder(xs).reverse().toString();
                val = Integer.parseInt(xs);
            }
            return val;
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
