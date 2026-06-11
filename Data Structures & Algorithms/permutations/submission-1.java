
public class Solution {
    // res will store all the permutations
    List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        // Initialize res as an empty list of lists
        res = new ArrayList<>();
        // Start the backtracking process with an empty permutation list, the input array nums, and a boolean array to track which numbers have been picked
        backtrack(new ArrayList<>(), nums, new boolean[nums.length]);
        // Return the list of all permutations
        return res;
    }

    public void backtrack(List<Integer> perm, int[] nums, boolean[] pick) {
        // Base case: If the current permutation has the same length as the input array, it's a complete permutation
        if (perm.size() == nums.length) {
            // Add a *copy* of the current permutation to the result list.  It's crucial to create a new ArrayList, otherwise all lists in `res` would point to the same `perm` object, which changes over the course of the backtracking.
            res.add(new ArrayList<>(perm));
            return; // Backtrack: no more choices to make at this level
        }

        // Iterate through all the numbers in the input array
        for (int i = 0; i < nums.length; i++) {
            // Check if the current number has been picked already
            if (!pick[i]) {
                // If the number hasn't been picked, add it to the current permutation
                perm.add(nums[i]);
                // Mark the number as picked
                pick[i] = true;
                // Recursively call backtrack to explore further permutations
                backtrack(perm, nums, pick);
                // Backtrack: Remove the last added number from the current permutation (for exploring other possibilities)
                perm.remove(perm.size() - 1);
                // Unmark the number as picked (for exploring other possibilities)
                pick[i] = false;
            }
        }
    }
}