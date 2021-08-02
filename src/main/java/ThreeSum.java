import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> l = new ArrayList<>();
        Set<Set<Integer>> s = new HashSet<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int index = Arrays.binarySearch(nums, j + 1, nums.length, -1 * (nums[i] + nums[j]));
                if (!(index < 0)) {
                    List<Integer> newL = Arrays.asList(nums[i], nums[j], nums[index]);
                    HashSet<Integer> newS = new HashSet<>(newL);
                    if (!s.contains(newS)) {
                        s.add(newS);
                        l.add(newL);
                    }
                }
            }
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
