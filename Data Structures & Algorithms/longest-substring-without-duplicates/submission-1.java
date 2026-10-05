class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int result = 0;
        int left = 0;
        int right = 0;
        Set<Character> seen = new HashSet<>();
        while(right < n) {
            char current = s.charAt(right);
            while(seen.contains(current)){
                seen.remove(s.charAt(left));
                left++;
            }
            seen.add(s.charAt(right));
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }

    /*public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0;
        int right = 0;
        Set<Character> visited = new HashSet();
        int length = 0;
        while (right < n) {
            while (visited.contains(s.charAt(right))) {
                visited.remove(s.charAt(left));
                left++;
            }
            visited.add(s.charAt(right));
            right++;
            length = Math.max(length, visited.size());
        }
        return length;
    }*/
}
