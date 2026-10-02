class Solution {
         public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int i = 0; i< nums.length; i++){
            dfs(nums, i, result, new ArrayList());
        }
        return result;
    }

    private void dfs(int[] nums, int index, List<List<Integer>> result, List<Integer> subset) {
        subset.add(nums[index]);
        result.add(new ArrayList<>(subset));
        for (int i = index + 1; i < nums.length; i++) {
            dfs(nums, i, result, new ArrayList(subset));
        }
    }
}
