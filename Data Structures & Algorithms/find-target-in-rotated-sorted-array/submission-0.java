class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            if (nums[middle] < nums[right]) {
                if (nums[right] == target) {
                    return right;
                }
                if (target < nums[middle] || target > nums[right]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else {
                if (nums[left] == target) {
                    return left;
                }
                if (target > nums[middle] || target < nums[left]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }
        return -1;
    }
}
