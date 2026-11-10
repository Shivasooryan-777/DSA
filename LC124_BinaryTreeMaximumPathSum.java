public class LC124_BinaryTreeMaximumPathSum {
    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Only contribute positive paths, ignore negative ones
        int leftGain = Math.max(0, maxGain(node.left));
        int rightGain = Math.max(0, maxGain(node.right));

        // Price to start a new path where `node` is the highest ancestor
        int currentPathSum = node.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, currentPathSum);

        // Return the max contribution if continuing through the parent
        return node.val + Math.max(leftGain, rightGain);
    }
}

