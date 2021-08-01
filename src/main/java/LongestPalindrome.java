public class LongestPalindrome {
    public String longestPalindrome(String s) {
        boolean[][] P = new boolean[s.length()][s.length()];
        int maxI = -1, maxJ = -1;
        int maxLength = -1;
        for (int k = 0; k < s.length(); k++) {
            for (int i = 0; i < s.length(); i++) {
                if (i + k < s.length()) {
                    P[i + k][i] = (s.charAt(i) == s.charAt(i + k));
                    if (k > 1) {
                        P[i + k][i] = P[i + k][i] && (P[i + k - 1][i + 1]);
                    }
                }
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (P[j][i]) {
                    int length = j - i + 1;
                    if (length > maxLength) {
                        maxI = i;
                        maxJ = j;
                        maxLength = length;
                    }
                }
            }
        }
        return s.substring(maxI, maxJ + 1);
    }
}
