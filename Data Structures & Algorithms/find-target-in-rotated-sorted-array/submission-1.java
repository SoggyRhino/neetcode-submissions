class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid = l + ((r - l) / 2);

            if (nums[mid] > nums[r])
                l = mid +1;
            else 
                r = mid;
            
        }


        int result= binarySearch(nums,0, l -1 ,target);
        if (result != -1)
            return result;


        return binarySearch(nums,l, nums.length-1,target);
    }



    public int binarySearch(int[] nums, int l, int r, int target){
        while (l <= r) {
            int mid = l + ((r - l) / 2);
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target )
                l = mid +1;
            else r = mid -1;
            
        }
        return -1;


    }
}