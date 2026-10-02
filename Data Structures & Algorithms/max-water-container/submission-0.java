class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int maxArea = 0;
        int maxSmall = 0;
        while (left < right) {
            if (height[left] <= maxSmall) {
                left++;
                continue;
            }
            if (height[right] <= maxSmall) {
                right--;
                continue;
            }
            int newArea = 0;
            if (height[left] < height[right]) {
                newArea = height[left] * (right - left);
                maxSmall = Math.max(maxSmall, height[left]);
                left++;
            } else if (height[left] > height[right]) {
                newArea = height[right] * (right - left);
                maxSmall = Math.max(maxSmall, height[right]);
                right--;
            } else {
                newArea = height[right] * (right - left);
                maxSmall = Math.max(maxSmall, height[right]);
                left++;
                right--;
            }
            maxArea = Math.max(maxArea, newArea);
        }
        return maxArea;
    }
}
