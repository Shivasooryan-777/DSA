public class LC213_HouseRobberII {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        return Math.max(robLinear(nums, 0, nums.length - 2), robLinear(nums, 1, nums.length - 1));
    }

    private int robLinear(int[] nums, int start, int end) {
        int robPrev2 = 0;
        int robPrev1 = 0;

        for (int i = start; i <= end; i++) {
            int current = Math.max(robPrev1, robPrev2 + nums[i]);
            robPrev2 = robPrev1;
            robPrev1 = current;
        }

        return robPrev1;
    }
}
