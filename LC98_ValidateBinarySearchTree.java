public class LC98_ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private boolean validate(TreeNode node, Long min, Long max) {
        if (node == null) {
            return true;
        }

        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }

        return validate(node.left, min, (long) node.val) && validate(node.right, (long) node.val, max);
    }
}

