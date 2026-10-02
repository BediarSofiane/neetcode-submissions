class Solution {
     public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrackV1(candidates, result, target, 0, new ArrayList<>());
        //backtrackV2(candidates, result, 0, target, 0, new ArrayList<>());
        return result;
    }

    // In this version we reduce the selected value from the searched target each
    // time we recurse.
    private void backtrackV1(int[] candidates, List<List<Integer>> result, int target, int index,
            List<Integer> currentList) {
        if (target == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if(target - candidates[i] < 0){
                break;
            }
            if( i > index && candidates[i] == candidates[i-1]){
                continue;
            }
            currentList.add(candidates[i]);
            backtrackV1(candidates, result, target - candidates[i], i+1, currentList);
            currentList.remove(currentList.size() - 1);
        }
    }
}
