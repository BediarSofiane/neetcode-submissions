class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return new ArrayList();
        }
        Map<Character, List<Character>> digitsToChars = new HashMap();
        fillMap(digitsToChars);
        Queue<String> queue = new LinkedList<>();
        queue.offer("");
        int i = 0;
        while (i < digits.length()) {
            char currentDigit = digits.charAt(i++);
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String currentString = queue.poll();
                for (char c : digitsToChars.get(currentDigit)) {
                    queue.offer(currentString + c);
                }
            }
        }
        return new ArrayList<>(queue);
    }
    private void fillMap(Map<Character, List<Character>> digitsToChars) {
        digitsToChars.put('2', Arrays.asList('a', 'b', 'c'));
        digitsToChars.put('3', Arrays.asList('d', 'e', 'f'));
        digitsToChars.put('4', Arrays.asList('g', 'h', 'i'));
        digitsToChars.put('5', Arrays.asList('j', 'k', 'l'));
        digitsToChars.put('6', Arrays.asList('m', 'n', 'o'));
        digitsToChars.put('7', Arrays.asList('p', 'q', 'r', 's'));
        digitsToChars.put('8', Arrays.asList('t', 'u', 'v'));
        digitsToChars.put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }
}
