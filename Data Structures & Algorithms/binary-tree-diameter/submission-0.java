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
    public int diameterOfBinaryTree(TreeNode root) {
        HashMap<TreeNode, int[]> visited = new HashMap<>();
        visited.put(null, new int[]{0,0});

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode current = stack.peek();

            if (current.left != null && !visited.containsKey(current.left)){
                stack.push(current.left);
            } else if (current.right != null && !visited.containsKey(current.right)){
                stack.push(current.right);
            } else {
                current = stack.pop();
                
                int[] left = visited.get(current.left);
                int[] right = visited.get(current.right);

                int height = 1 + Math.max(left[0], right[0]);
                int diameter = Math.max(left[0] + right[0], Math.max(left[1], right[1]));

                visited.put(current, new int[]{height, diameter});
            }

        }

        return visited.get(root)[1];
    }
}
