public class myAtoi {
    public static int myAtoiFunction(String s) {

        if (s.isEmpty()) {
            return 0;
        }

        boolean flagNegative = false;
        // ignoring leading whitespaces
        int startIndex = 0;
        while ((startIndex < s.length() && (s.charAt(startIndex) == ' '))) {
            startIndex += 1;
        }

        // if reached the end
        if (startIndex == s.length()) {
            return 0;
        } else if (s.charAt(startIndex) == '-') {
            // negative
            flagNegative = true;
            startIndex += 1;
        } else if (s.charAt(startIndex) == '+') {
            // positive but with +
            startIndex += 1;
        }
        // if reached the end after - or +, or if we a none digit char.
        if (startIndex == s.length() || !Character.isDigit(s.charAt(startIndex))) {
            return 0;
        }

        // looking for last appearance of digit.
        int endIndex = startIndex;
        while ((endIndex < s.length())) {
            if (Character.isDigit(s.charAt(endIndex))) {
                endIndex += 1;
            } else {
                break;
            }
        }

        // substring of digits.
        String rest = s.substring(startIndex, endIndex);

        try {
            int num = Integer.parseInt(rest);
            if (flagNegative) {
                num = -1 * num;
            }
//            if (num < -2147483648 || num > 2147483647) {
//                throw new NumberFormatException();
//            }
            return num;
        } catch (NumberFormatException e) {
            if (flagNegative) {
                return -2147483648;
            } else {
                return 2147483647;
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(myAtoiFunction("+"));
    }
}
