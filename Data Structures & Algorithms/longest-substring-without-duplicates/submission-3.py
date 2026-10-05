class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        n= len(s)
        left, right, res = 0, 0, 0
        seen = set()
        while right < n:
            current = s[right]
            while(current in seen):
                seen.remove(s[left])
                left += 1
            seen.add(current)
            res = max(res, right - left + 1)
            right += 1
        return res;
        