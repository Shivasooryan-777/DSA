public class LC572_SubtreeOfAnotherTree {
    private int subHeight;
    private boolean found;

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        found = false;
        subHeight = getHeight(subRoot);
        checkSubtree(root, subRoot);
        return found;
    }

    private int checkSubtree(TreeNode node, TreeNode subRoot) {
        if (node == null || found) {
            return 0;
        }

        int left = checkSubtree(node.left, subRoot);
        int right = checkSubtree(node.right, subRoot);
        int currentHeight = 1 + Math.max(left, right);

        if (currentHeight == subHeight && !found) {
            if (isSame(node, subRoot)) {
                found = true;
            }
        }

        return currentHeight;
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.val != t.val) {
            return false;
        }
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}
