public class maxAreaProblem {
    public static int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int minimalH = Math.min(height[i], height[j]);
                if (minimalH * (j - i) > maxArea) {
                    maxArea = minimalH * (j - i);
                }
            }
        }
        return maxArea;
    }

    public int maxAreaEfficient(int[] height) {
        int maxArea = 0;
        // pointers, lets
        int lp = 0, rp = height.length - 1;
        while (lp < rp) {
            int minimal = Math.min(height[rp], height[lp]);
            int area = minimal * (rp - lp);
            if (area > maxArea) {
                maxArea = area;
            }
            // we are greedy, we want bigger container, so we want to make it bigger by finding better lp/rp
            if (height[rp] > height[lp]) {

                lp += 1;
            } else {
                rp -= 1;
            }

        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 2, 1}));
    }
}
