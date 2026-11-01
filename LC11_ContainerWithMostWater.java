public class LC11_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int currentHeight = Math.min(height[left], height[right]);
            int width = right - left;
            maxArea = Math.max(maxArea, currentHeight * width);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}

