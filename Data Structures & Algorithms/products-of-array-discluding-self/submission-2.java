class Solution {
    public int[] productExceptSelf(int[] nums) {
        int max = 1;
        int maxNonZero =1;
        int zeros =0;
        for (int i : nums ){
            max*=i;
            if (i !=0 ){
                maxNonZero*=i;
            } else {
                zeros++;
            }
        }
        for (int i =0; i < nums.length; i++){
            if (zeros > 1){
                nums[i] = 0;
            } else if (nums[i] != 0 )
                nums[i]=max / nums[i];
            else {
                nums[i] = maxNonZero;
            } 
        }
        return nums;
    }
}  
