import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PhoneCombinations {
    public static List<String> letterCombinations(String digits) {

        List<String> l = new ArrayList<>();
        HashMap<String, ArrayList<String>> pm = phoneMapping();
        return helper(digits, pm);
    }

    public static HashMap<String, ArrayList<String>> phoneMapping() {
        return new HashMap<>() {{
            put("1", new ArrayList<>());
            put("2", new ArrayList<String>(Arrays.asList("a", "b", "c")));
            put("3", new ArrayList<String>(Arrays.asList("d", "e", "f")));
            put("4", new ArrayList<String>(Arrays.asList("g", "h", "i")));
            put("5", new ArrayList<String>(Arrays.asList("j", "k", "l")));
            put("6", new ArrayList<String>(Arrays.asList("m", "n", "o")));
            put("7", new ArrayList<String>(Arrays.asList("p", "q", "r", "s")));
            put("8", new ArrayList<String>(Arrays.asList("t", "u", "v")));
            put("9", new ArrayList<String>(Arrays.asList("w", "x", "y", "z")));
        }};
    }


    public static List<String> helper(String digits, HashMap<String, ArrayList<String>> phoneMap) {
        int len = digits.length();
        if (len == 0) {
            return new ArrayList<String>();
        } else if (len == 1) {
            return phoneMap.get(digits.substring(0, 1));
        } else {
            List<String> h = helper(digits.substring(0, len - 1), phoneMap);
            String lastChar = digits.substring(len - 1);
            List<String> lhNew = new ArrayList<String>();
            for (String s : h) {
                for (String charOption : phoneMap.get(lastChar)) {
                    lhNew.add(s.concat(charOption));
                }
            }
            return lhNew;
        }
    }


    public static void main(String[] args) {
        System.out.println(letterCombinations(""));
    }

}