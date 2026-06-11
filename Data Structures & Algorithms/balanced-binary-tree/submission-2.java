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
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        HashMap<TreeNode, Integer> visited = new HashMap<>();
        visited.put(null, 0);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode current = stack.peek();

            if (current.left != null && !visited.containsKey(current.left)){
                stack.push(current.left);
            } else if (current.right != null && !visited.containsKey(current.right)){
                stack.push(current.right);
            } else {
                current = stack.pop();
                int left = visited.get(current.left), right = visited.get(current.right);
                if (Math.abs(left - right) > 1)
                    return false;
                visited.put(current, 1 + Math.max(left,right));
            }
        }
        return true;
    }
}
