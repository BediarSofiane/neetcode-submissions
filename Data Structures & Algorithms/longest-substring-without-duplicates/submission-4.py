class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        n= len(s)
        left, right, res = 0, 0, 0
        seen = set()
        while right < n:
            current = s[right]
            if current in seen :
                res = max(res, right - left)
            while(current in seen):
                seen.remove(s[left])
                left += 1
            seen.add(current)
            right += 1
        res = max(res, right - left)
        return res;
        