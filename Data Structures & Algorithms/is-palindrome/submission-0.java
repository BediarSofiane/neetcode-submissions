class Solution {
    public boolean isPalindrome(String s) {
        int left=0;
        int right = s.length() - 1;
        s= s.toLowerCase();
        while(left<right){
            if(!isAlphanumeric(s.codePointAt(left))){
                left++;
                continue;
            }
            if(!isAlphanumeric(s.codePointAt(right))){
                right--;
                continue;
            }
            if(s.charAt(left) != s.charAt(right)){
                System.out.println(left + " " + right);
                System.out.println(s.charAt(left) + " " + s.charAt(right));
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isAlphanumeric(int c){
        return c >= 48 && c <= 57 || c >= 65 && c <= 90 || c >= 97 && c <= 122;
    }
}
