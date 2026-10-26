public class LC297_SerializeAndDeserializeBinaryTree {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#,");
            return;
        }
        sb.append(node.val).append(',');
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    public TreeNode deserialize(String data) {
        int[] index = new int[1];
        return deserializeHelper(data, index);
    }

    private TreeNode deserializeHelper(String data, int[] index) {
        if (index[0] >= data.length()) {
            return null;
        }
        if (data.charAt(index[0]) == '#') {
            index[0] += 2;
            return null;
        }

        int sign = 1;
        if (data.charAt(index[0]) == '-') {
            sign = -1;
            index[0]++;
        }

        int val = 0;
        while (data.charAt(index[0]) != ',') {
            val = val * 10 + (data.charAt(index[0]) - '0');
            index[0]++;
        }
        index[0]++;

        TreeNode node = new TreeNode(sign * val);
        node.left = deserializeHelper(data, index);
        node.right = deserializeHelper(data, index);
        return node;
    }
}
