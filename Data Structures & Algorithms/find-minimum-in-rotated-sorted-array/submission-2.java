class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        int num = nums[0];
        while (left <= right) {
            if (nums[left] < nums[right])
                return Math.min(num, nums[left]);

            int mid = left + ((right - left) / 2);

            num = Math.min(num,nums[mid]);

            if (nums[mid] >= nums[left])
                left = mid +1;
            else 
                right = mid-1;
        }
        return num;
    }
}
