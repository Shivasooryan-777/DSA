public class LC105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private int preIndex = 0;
    private int inIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        inIndex = 0;
        return build(preorder, inorder, Long.MAX_VALUE);
    }

    private TreeNode build(int[] preorder, int[] inorder, long stop) {
        if (preIndex >= preorder.length) {
            return null;
        }
        if (inIndex < inorder.length && inorder[inIndex] == stop) {
            inIndex++;
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex++]);
        root.left = build(preorder, inorder, root.val);
        root.right = build(preorder, inorder, stop);
        return root;
    }
}
