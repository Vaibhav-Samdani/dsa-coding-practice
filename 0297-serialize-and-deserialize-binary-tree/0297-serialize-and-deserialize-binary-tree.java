/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder st = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = q.poll();

                if (node == null) {
                    st.append("null,");
                    continue;
                }

                st.append(node.val).append(",");

                q.offer(node.left);
                q.offer(node.right);
            }
        }

        return st.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        String[] values = data.split(",");
        int k = 1;
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while (!q.isEmpty() && k < values.length) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                TreeNode node = q.poll();

                
                if (k < values.length && !values[k].equals("null")) {
                    node.left = new TreeNode(Integer.parseInt(values[k]));
                    q.offer(node.left);
                }
                k++;
                if (k < values.length && !values[k].equals("null")) {
                    node.right = new TreeNode(Integer.parseInt(values[k]));
                    q.offer(node.right);
                }
                k++;
            }
        }
        return root;
    }
}
// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
