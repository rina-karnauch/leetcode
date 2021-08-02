import java.util.HashMap;

public class IntegerToRoman {

    public static String intToRoman(int num) {
        String S = "";
        HashMap<Integer, String> map = createDictionary();

        while (num > 0) {
            int closestKey = getClosestKey(num, map);
            S = S.concat(map.get(closestKey));
            num = num - closestKey;
        }
        return S;
    }

    public static HashMap<Integer, String> createDictionary() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
        return map;
    }

    public static int getClosestKey(int num, HashMap<Integer, String> map) {
        int diff = Integer.MAX_VALUE;
        int lastKey = -1;
        for (int key : map.keySet()) {
            int newDiff = num - key;
            if (newDiff < diff && newDiff >= 0) {
                diff = newDiff;
                lastKey = key;
            }
        }
        return lastKey;

    }

    public static void main(String[] args) {
        System.out.println(intToRoman(10994));
    }
}
