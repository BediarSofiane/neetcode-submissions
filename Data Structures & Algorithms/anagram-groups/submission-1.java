class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> resultMap = new HashMap<>();
        for (String str : strs) {
            int[] alphabetCount = new int[26];
            char[] charArray = str.toCharArray();
            for (char c : charArray) {
                alphabetCount[c - 'a'] ++;
            }
            String alphabetCountString = Arrays.toString(alphabetCount);
            resultMap.putIfAbsent(alphabetCountString, new ArrayList<>());
            resultMap.get(alphabetCountString).add(str);
        }
        return new ArrayList<>(resultMap.values());
    }
}
