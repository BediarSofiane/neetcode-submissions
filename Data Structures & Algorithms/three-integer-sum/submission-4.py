class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        res = []
        for i in range(0, len(nums) - 2):
            if i > 0 and nums[i] == nums[i-1]:
                continue
            first = nums[i]
            left = i+1
            right = len(nums) - 1
            while left < right:
                sum = nums[left] + nums[right]
                if sum == -first:
                    res.append([first, nums[left], nums[right]])
                    left += 1
                    while nums[left] == nums[left -1] and left < right:
                        left += 1
                elif sum < -first:
                    left += 1
                else:
                    right -= 1
        return res
        