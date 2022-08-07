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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        HashMap<TreeNode, Integer> m = new HashMap<>();
        
        q.offer(root);
        m.put(root, 1);
        int curr = 0, res = 0;
        
        while (!q.isEmpty()) {
            int start = 0, end = 0;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                int idx = m.get(temp); //pos
                if (i == 0) start = idx;
                if (i == size - 1) end = idx;
                if (temp.left != null) {
                    m.put(temp.left, 2 * idx);
                    q.offer(temp.left);
                }
                if (temp.right != null) {
                    m.put(temp.right, 2 * idx + 1);
                    q.offer(temp.right);
                }
            }
            curr = end - start + 1;
            res = Math.max(curr, res);
        }
        
        return res;
    }
}