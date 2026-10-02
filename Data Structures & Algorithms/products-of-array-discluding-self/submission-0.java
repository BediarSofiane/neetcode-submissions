class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] prefixes = new int[n + 1];
        int[] suffixes = new int[n + 1];
        prefixes[0] = 1;
        suffixes[n] = 1;
        
        for (int i = 0; i < n; i++) {
            prefixes[i + 1] = prefixes[i] * nums[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            suffixes[i] = suffixes[i + 1] * nums[i];
        }
        
        for (int i = 0; i < n; i++) {
            result[i] = prefixes[i] * suffixes[i + 1];
        }

        return result;
    }
    
}  
