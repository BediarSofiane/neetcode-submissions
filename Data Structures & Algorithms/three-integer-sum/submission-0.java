class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int first = nums[i];
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    while(nums[left] == nums[left -1] && left < right){
                        left++;
                    }
                } else if (sum < 0) {
                    left++;
                     while(nums[left] == nums[left -1] && left < right){
                        left++;
                    }
                } else {
                    right--;
                    while (nums[right] == nums[right + 1] && left < right) {
                        right--;
                    }
                }
            }

        }
        return result;
    }
}
