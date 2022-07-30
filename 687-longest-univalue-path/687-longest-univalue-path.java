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
    private int longest = 0;
    
    public int longestUnivaluePath(TreeNode root) {
        if (root == null)
            return 0;
        path(root, root.val);
        return longest;
    }
    
    private int path(TreeNode root, int value) {
        if (root == null)
            return 0;
        
        int left = path(root.left, root.val);
        int right = path(root.right, root.val);
        
        longest = Math.max(left + right, longest);
        if (value == root.val)
            return Math.max(left, right) + 1;
        return 0;
    }
}