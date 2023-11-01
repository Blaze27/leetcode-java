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
    public int[] findMode(TreeNode root) {
        List<TreeNode> queue = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        // map stores element and the frequency  
        Map<Integer,Integer> map = new HashMap<>();
        if (root.left == null && root.right == null) {
            return new int[]{root.val};
        }
        queue.add(root);
        while (queue.size() > 0) {
            int size = queue.size();

            while (size-- > 0) {
                TreeNode temp = queue.remove(0);
                if (map.containsKey(temp.val)) {
                    int t = map.get(temp.val);
                    t += 1;
                    map.put(temp.val, t);
                }
                else {
                    map.put(temp.val, 1);
                }
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }


        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Comparator<Map.Entry<Integer, Integer>> valueComparator = (entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue());

        list.sort(valueComparator);

        int first_freq = -1;
        for (Map.Entry<Integer, Integer> entry : list) {
            if (first_freq == -1) {
                ans.add((Integer)entry.getKey());
                first_freq = (Integer)entry.getValue();
            }
            else if (first_freq == (Integer)entry.getValue()) {
                ans.add((Integer)entry.getKey());
            }
            else {
                break;
            }
                
        }
        int[] a = new int[ans.size()];
        for (int i = 0; i < a.length; i++) {
            a[i] = ans.get(i);
        }

        return a;
        
    }
}
