class Solution {
     public boolean isAnagram(String s, String t) {
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
