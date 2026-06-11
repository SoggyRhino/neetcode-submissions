class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        dfs(nums,target, 0, 0, new ArrayList<>(), res);
        return res;
    }

    public void dfs(int[] nums, int target, int i, int sum, List<Integer> cur, List<List<Integer>> res){
        if (sum > target || i == nums.length){
            return;
        } if (sum == target) { 
            res.add(new ArrayList<>(cur));
            return;
        }
 
        cur.add(nums[i]);
        dfs(nums,target, i, sum + nums[i], cur, res); //branch that continues to use the the current num 

        cur.remove(cur.size()-1);
        dfs(nums,target, i + 1, sum, cur, res);       //branch that does not contain any more of the current num
    }
}