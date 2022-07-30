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
    private int maxi = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        findPathSum(root);
        return maxi;
    }
    
    private int findPathSum(TreeNode root) {
        if (root == null)
            return 0;
        
        int left = Math.max(findPathSum(root.left), 0);
        int right = Math.max(findPathSum(root.right), 0);
        
        int curr = root.val + left + right;
        maxi = Math.max(maxi, curr);
        
        return root.val + Math.max(left, right);
    }
}