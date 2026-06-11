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
    public boolean isValidBST(TreeNode node) {
        return rec (node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public boolean rec(TreeNode node, int min, int max) {
        if(node == null){
            //System.out.printf("case 1 %d min %d max %d", node.val, min, max );
            return true;
        }
        System.out.printf("%d min %d max %d   value %b\n", node.val, min, max, (node.val > min && node.val < max) );

        if (node.val > min && node.val < max){
            return rec(node.left, min, Math.min(node.val, max)) && rec(node.right, Math.max(node.val, min), max);
        }
        return false;
    }
    
}
