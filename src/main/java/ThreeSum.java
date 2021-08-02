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

    public static List<List<Integer>> threeSumEfficient(int[] nums) {

        List<List<Integer>> l = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                // no dupes
                continue;
            }
            // greedy solution: lets assume we need the biggest nums[k]
            int j = i + 1, k = nums.length - 1;
            while(j<k){
                if(j > i+1 && nums[j] == nums[j-1]){
                    j++;
                    continue;
                }
                int z = nums[i] + nums[j] + nums[k];
                if(z>0){
                    k-=1;
                }else if(z<0){
                    j+=1;
                }else{
                    l.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                }
            }
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(threeSumEfficient(new int[]{0,0,0}));
    }
}
