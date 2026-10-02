class Solution {
       boolean[][] palindromes;

    public List<List<String>> partition(String s) {
        return partitionWithPalindromDP(s);
    }
     public List<List<String>> partitionWithPalindromDP(String s) {
        
        palindromes = new boolean[s.length()][s.length()];
        initPalindromes(s);
        List<List<String>> result = new ArrayList<>();
        backtrackDP(s, 0, new ArrayList<>(), result);
        return result;
    }
    private void backtrackDP(String s, int start, List<String> currentList, List<List<String>> result) {
        if (start >= s.length()) {
            result.add(new ArrayList(currentList));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (palindromes[start][i]) {
                currentList.add(s.substring(start, i+1));
                backtrackDP(s, i + 1, currentList, result);
                currentList.remove(currentList.size() - 1);
            } else {
                continue;
            }
        }
    }
    
    private void initPalindromes(String s) {
        for (int i = 0; i < palindromes.length-1; i++) {
            palindromes[i][i] = true;
            palindromes[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }
        palindromes[s.length() - 1][s.length() - 1]= true;
        int j= 2;
        while(j<s.length()){
            for(int i=0; i + j < s.length(); i++){
                palindromes[i][i+j] = s.charAt(i) == s.charAt(i+j) && palindromes[i + 1][i+j - 1];
            }
            j++;
        }
    }
}
