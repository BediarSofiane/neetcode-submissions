class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int min = Integer.MAX_VALUE;
        while (left <= right) {
            int middle = (left + right) / 2;
            min = Math.min(min, nums[middle]);
            if (nums[middle] < nums[right]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return min;

    }
}
