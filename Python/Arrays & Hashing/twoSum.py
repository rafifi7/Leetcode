from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        seen = {}
        # one pass
        for i in range(len(nums)):
            num = nums[i]
            if target - num in seen:
                return [seen[target - num], i]
            seen[num] = i
        return None