/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        rec(results, root, 0);
        return results;
    }

    public void rec(List<List<Integer>> results, TreeNode node, int level){
        if (node != null) {
            if (level == results.size())
                results.add(new ArrayList<Integer>());
            
            results.get(level).add(node.val);
            rec(results, node.left, level +1 );
            rec(results, node.right, level +1 );
        
        }
    }
}
