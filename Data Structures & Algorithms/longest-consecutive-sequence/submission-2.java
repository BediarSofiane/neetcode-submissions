class Solution {
    public int longestConsecutive(int[] nums) {
       int longestSequence = 0;
       Set<Integer> set = new HashSet<>();
       for(int i=0; i<nums.length;i++){
        set.add(nums[i]);
       }
       for(int i=0; i<nums.length; i++){
        if(set.contains(nums[i] -1)){
            continue;
        }
        int sequenceLength = 1;
        while(set.contains(nums[i] + sequenceLength)){
            sequenceLength++;
        }
        longestSequence = Math.max(longestSequence, sequenceLength);
       }
       return longestSequence;
    }

    /*
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
    }*/
}
