class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < strs.length ; i++) {
            boolean added = false;
            for (List<String> list : result) {
                if (isAnagram(strs[i], list.get(0))){
                    list.add(strs[i]);
                    added = true;
                    break;
                }
            }
            if (!added) {
                List<String> innerList = new ArrayList<>();
                innerList.add(strs[i]);
                result.add(innerList);
            }
        }
        return result;
    }

     public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i=0; i < s.length(); i++){
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            sMap.put(sc, sMap.getOrDefault(sc, 0) + 1);
            tMap.put(tc, tMap.getOrDefault(tc, 0) + 1);
        }
        return sMap.equals(tMap);
    }
}
