class Solution {

    public static void main(String[] args) {
        trap(new int[] { 0, 2, 0, 3, 1, 0, 1, 3, 2, 1 });
    }

    public static int trap(int[] height) {
        int[] levels = new int[height.length];
        int water = 0;

        int left = 0;
        int right = height.length - 1;


        int level = 0;
        while (left < right) {
            int h1 = height[left];
            int h2 = height[right];

            level = Math.max(level, Math.min(h1, h2));
            levels[left] = level;
            levels[right] = level;

            if (h1 < h2) {
                water += Math.max(0, level - h1);
                left++;
            }
            else {
                water += Math.max(0, level - h2);
                right--;
            }

        }

        System.out.println(Arrays.toString(levels));
        System.out.println(water);
        return water;
    }
}