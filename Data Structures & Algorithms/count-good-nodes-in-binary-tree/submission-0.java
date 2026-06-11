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
    public int goodNodes(TreeNode root) {
        if (root == null)
            return 0;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> mstack = new Stack<>();
        int good = 0;

        TreeNode current = root;
        int max = root.val;
        
        while (current != null || !stack.isEmpty()) {
            // Go all the way down the rigth side (until there is a null)
            while (current != null) {
                max = Math.max(max,current.val);
                stack.push(current);
                mstack.push(max);
                current = current.left;
            }
            
            // Process the current node (furthest left node)
            current = stack.pop();
            max = mstack.pop();
            if (current.val >= max){
                System.out.print(current.val);
                good++;

            }
            
            // Move to the right subtree
            // We can ignore null since it will become the next in the stack on line 15
            current = current.right;
        }
        
        return good;
    }
}