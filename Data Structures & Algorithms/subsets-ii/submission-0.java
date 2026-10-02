class Solution {
     public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        backTrack(nums, result, 0, new ArrayList<>());
        return result;
    }

    private void backTrack(int[] nums, List<List<Integer>> result, int index, List<Integer> currentList) {
        if(index > nums.length){
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            currentList.add(nums[i]);
            result.add(new ArrayList<>(currentList));
            backTrack(nums, result, i + 1, currentList);
            currentList.remove(currentList.size() - 1);
        }
    }
}
