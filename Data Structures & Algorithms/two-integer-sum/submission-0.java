class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[] {Integer.MAX_VALUE,0};
        for(int i=0 ; i < nums.length; i++) {
            Integer j = map.get(target - nums[i]);
            if(j != null && j < result[0]){
                result = new int []{j, i};
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
