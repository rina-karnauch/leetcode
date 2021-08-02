import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static int romanToInt(String s) {

        if (s.isEmpty()) {
            return 0;
        }

        Map<String, Integer> map = new HashMap<>() {{
            put("I", 1);
            put("V", 5);
            put("X", 10);
            put("L", 50);
            put("C", 100);
            put("D", 500);
            put("M", 1000);
            put("IV", 4);
            put("IX", 9);
            put("XL", 40);
            put("XC", 90);
            put("CD", 400);
            put("CM", 900);
        }};

        char[] chars = s.toCharArray();
        int i = 0, num = 0;
        while (i < s.length()) {
            if (chars[i] == 'I') {
                if (i + 1 < s.length() && chars[i + 1] == 'V') {
                    num = num + 4;
                    i = i + 1;
                } else if (i + 1 < s.length() && chars[i + 1] == 'X') {
                    num = num + 9;
                    i = i + 1;
                } else {
                    num = num + map.get("I");
                }
            } else if (chars[i] == 'X') {
                if (i + 1 < s.length() && chars[i + 1] == 'L') {
                    num = num + 40;
                    i = i + 1;
                } else if (i + 1 < s.length() && chars[i + 1] == 'C') {
                    num = num + 90;
                    i = i + 1;
                } else {
                    num = num + map.get("X");
                }

            } else if (chars[i] == 'C') {
                if (i + 1 < s.length() && chars[i + 1] == 'D') {
                    num = num + 400;
                    i = i + 1;
                } else if (i + 1 < s.length() && chars[i + 1] == 'M') {
                    num = num + 900;
                    i = i + 1;
                } else {
                    num = num + map.get("C");
                }
            } else {
                num = num + map.get("" + chars[i]);
            }
            i = i + 1;
        }

        return num;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}

