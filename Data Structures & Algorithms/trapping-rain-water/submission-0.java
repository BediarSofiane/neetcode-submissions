class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left = -1;
        int[] lefts = new int[n];
        for(int i=0; i<n; i++){
            if(height[i] >= left){
                lefts[i] = -1;
                left = height[i];
            } else {
                lefts[i] = left;
            }
        }
        int right = -1;
        int[] rights = new int[n];
        for(int j=n-1; j>=0; j--){
            if(height[j] >= right){
                rights[j] = -1;
                right = height[j];
            } else {
                rights[j] = right;
            }
        }
        int trapped = 0;
        for(int i=0; i< n; i++){
            if(lefts[i] == -1 || rights[i] == -1){
                continue;
            }
            trapped += Math.min(lefts[i], rights[i]) - height[i];
        }
        return trapped;
        
    }
}
