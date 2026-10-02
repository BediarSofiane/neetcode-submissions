class Solution {
    public int lengthOfLongestSubstring(String s) {
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
    }
}
