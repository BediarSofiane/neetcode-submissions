class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return permuteUsingArrays(nums);
    }

    public List<List<Integer>> permuteUsingArrays(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(nums, result, new int[nums.length], 0);
        return result;
    }

    //Naive version
    private void backTrack(int[] nums, List<List<Integer>> result, int[] currentPermutation, int index) {
        if (index == currentPermutation.length) {
            result.add(Arrays.stream(currentPermutation).boxed().toList());
        }
        for (int i = 0; i < nums.length; i++) {
            currentPermutation[index] = nums[i];
            int[] remaining = new int[nums.length - 1];
            int k = 0;
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                    remaining[k] = nums[j];
                    k++;
                }
            }
            backTrack(remaining, result, currentPermutation, index + 1);
        }
    }
}
