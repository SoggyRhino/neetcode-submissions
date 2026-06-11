class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int n : nums){
            if(!set.add(n))
                return n;
        }
        return -1;
    }
}
