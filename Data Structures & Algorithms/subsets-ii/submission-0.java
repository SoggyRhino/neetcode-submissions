class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<>();

        rec(nums, 0, new ArrayList<>(), set);


        return new ArrayList(set);
    }

    public void rec(int[] nums, int i, List<Integer> cur, HashSet<List<Integer>> res){
        System.out.println(cur);

        // end subset here
        res.add(new ArrayList(cur));

        if (i == nums.length)
            return;


        // do not add element
        rec(nums,i+1,cur,res);

        // add element
        cur.add(nums[i]);
        rec(nums,i+1,cur,res);
        cur.remove(cur.size()-1);

        

    }
}
