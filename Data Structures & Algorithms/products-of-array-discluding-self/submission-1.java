class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftToRightCumProduct = new int[n];
        int[] rightToLeftCumProduct = new int[n];
        leftToRightCumProduct[0] = nums[0];
        rightToLeftCumProduct[n-1] = nums[n-1];
        for(int i =1; i<n-1; i++){
            leftToRightCumProduct[i] = leftToRightCumProduct[i-1] * nums[i];
            rightToLeftCumProduct[n-1-i] = rightToLeftCumProduct[n-1-i+1] * nums[n-1-i];
        }
        int[] res = new int[n];
        res[0] = rightToLeftCumProduct[1];
        res[n-1] = leftToRightCumProduct[n-2]; 
        for(int i=1; i<n-1; i++){
            res[i] = leftToRightCumProduct[i-1] * rightToLeftCumProduct[i+1];
        }
        return res;
    }

    /*
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
    */
    
}  
