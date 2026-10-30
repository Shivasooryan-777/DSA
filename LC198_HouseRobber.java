public class LC198_HouseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int robPrev2 = 0;
        int robPrev1 = 0;

        for (int num : nums) {
            int current = Math.max(robPrev1, robPrev2 + num);
            robPrev2 = robPrev1;
            robPrev1 = current;
        }

        return robPrev1;
    }
}

