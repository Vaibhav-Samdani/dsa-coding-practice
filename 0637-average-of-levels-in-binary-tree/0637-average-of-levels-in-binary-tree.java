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

    static {
        for(int i = 0; i<500;i++){
            averageOfLevels(new TreeNode(-1));
        }
    }
    public static List<Double> averageOfLevels(TreeNode root) {
        if(root == null) return null;

        List<Double> ans = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){
            int len = q.size();
            long sum = 0;
            for(int i = 0; i<len;i++){
                TreeNode temp = q.poll();

                sum += temp.val;

                if(temp.left != null){
                    q.offer(temp.left);
                }
                if(temp.right != null){
                    q.offer(temp.right);
                }
            }

            ans.add(sum/(double)len);
        }

        return ans;

    }
}