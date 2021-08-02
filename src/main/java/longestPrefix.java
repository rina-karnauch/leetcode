import java.util.Arrays;
import java.util.Comparator;

public class longestPrefix {

    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs, Comparator.comparingInt(String::length));
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            String word = strs[i];
            for (int j = 0; j < prefix.length(); j++) {
                if (word.charAt(j) != prefix.charAt(j)) {
                    prefix = prefix.substring(0, j);
                    break;
                }
            }
            if (prefix.length() == 0) {
                return "";
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }

}
