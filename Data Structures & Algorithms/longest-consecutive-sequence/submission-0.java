class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        int longestSequence = 0;
        Set<Integer> numsSet = new HashSet();
        for(int i=0; i< n; i++){
            numsSet.add(nums[i]);
        }
        for(int num : numsSet){
            int sequenceLength = 1;
            while(numsSet.contains(num + sequenceLength)){
                sequenceLength++;
            }
            longestSequence = Math.max(longestSequence, sequenceLength);
        }
        return longestSequence;
    }
}
