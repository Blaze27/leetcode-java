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
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);

        List<Integer> ans = new ArrayList<>();
        while (queue.size() > 0) {
            int size = queue.size();
            int max_val = Integer.MIN_VALUE;
            while (size-- > 0) {
                TreeNode temp = queue.remove(0);
                max_val = Math.max(max_val, temp.val);

                if (temp.left != null) {
                    queue.add(temp.left);
                }

                if (temp.right != null) {
                    queue.add((temp.right));
                }
            }
            ans.add(max_val);
        }
        return ans;
    }
}
