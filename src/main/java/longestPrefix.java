import java.util.Arrays;

public class longestPrefix {

    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs, new java.util.Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
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
