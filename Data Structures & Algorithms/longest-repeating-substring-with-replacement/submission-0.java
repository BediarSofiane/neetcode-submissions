class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int left = 0;
        int right = 0;
        Map<Character, Integer> frequencies = new HashMap();
        int maxFrequency = 0;
        while (right < n) {
            char current = s.charAt(right);
            frequencies.put(current, frequencies.getOrDefault(current, 0) + 1);
            maxFrequency = Math.max(maxFrequency, frequencies.get(current));
            if (maxFrequency + k < right - left + 1) {
                char toRemove = s.charAt(left);
                frequencies.put(toRemove, frequencies.get(toRemove) - 1);
                left++;
            }
            right++;
        }
        return Math.min(maxFrequency + k, n);
    }
}
