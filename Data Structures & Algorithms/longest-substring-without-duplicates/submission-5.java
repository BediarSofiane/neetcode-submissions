class Solution {
    //Naive solution (Brute force): 
    //compute the max length of substring without duplicates that can START by each of the characters of the string, and keep tracking the max length you can get. O(n^2)

    //Pattern: 
    //Slidiing window -> Cue : a continguous substring as a result

    //Intuition: 
    //1. Use two pointers (sliding windo), that both start at 0, 
    //2. advance the right one as long as the resulting substring does not contain duplicates, 
    //3. when you see the first new character that result in a substring with duplicate, stop and start moving the left pointer until the risk of duplicate disappears (the curren character is not in the selected substring), 
    //4. keep tracking the maximum size of substring before you shrink any window.
    
    //Complexity:
    //Time: O(n) -> In worst case, we go through the characters of the list 2 times, one with right and one with left -> O(2n) = O(n), where n is the number of characters in the list.
    //Space: O(n) -> The hashset grows linearly with n, n being the size of the input string.
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int result = 0;
        int left = 0;
        int right = 0;
        Set<Character> seen = new HashSet<>();
        while(right < n) {
            char current = s.charAt(right);
            if(seen.contains(current)){
                result = Math.max(result, right - left);
            }
            while(seen.contains(current)){
                seen.remove(s.charAt(left));
                left++;
            }
            seen.add(s.charAt(right));
            right++;
        }
        result = Math.max(result, right - left);
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
