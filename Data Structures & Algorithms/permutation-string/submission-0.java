class Solution {
    public boolean checkInclusion(String s1, String s2) {
         int n1 = s1.length();
        int n2 = s2.length();
        Map<Character, Integer> s1Frequencies = new HashMap();
        Map<Character, Integer> s2Count = new HashMap();
        for (char c : s1.toCharArray()) {
            s1Frequencies.put(c, s1Frequencies.getOrDefault(c, 0) + 1);
        }
        int i = 0;
        int count = 0;
        int lastStart = 0;
        while (i < n2) {
            if(count == 0){
                lastStart = i;
            }
            char current = s2.charAt(i);
            Integer frequencyInS1 = s1Frequencies.getOrDefault(current, 0);
            int frequencySoFar = s2Count.getOrDefault(current, 0);
            if (frequencySoFar < frequencyInS1) {
                s2Count.put(current, frequencySoFar + 1);
                count++;
                if (count == n1) {
                    return true;
                }
            } else {
                if (count > 0 && frequencyInS1 > 0) {
                    i = lastStart;
                }
                count = 0;
                s2Count.clear();
            }
            i++;
        }

        return false;
    }
}
