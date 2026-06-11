class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);

        dfs(candidates, target, 0, 0, new ArrayList<>(), res);
        return res;
    }

    public void dfs(int[] nums, int target, int i, int sum, List<Integer> cur, List<List<Integer>> res){
        if (sum == target) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (sum > target || i == nums.length){
            return;
        }

        int num = nums[i];

        cur.add(nums[i]);
        dfs(nums,target, i + 1, sum + num, cur, res); //branch that continues to use the the current num 
        cur.remove(cur.size()-1);

        //skip to the next
        while (i + 1 < nums.length && nums[i + 1] == num) {
            i++;
        }

        dfs(nums,target, i + 1, sum, cur, res);       //branch that does not contain any more of the current num
    }
}