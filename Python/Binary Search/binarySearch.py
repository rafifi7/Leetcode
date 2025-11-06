from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        # we have a target 

        # we want to look in the middle to see if high or low

        l, r = 0, len(nums) - 1

        while l <= r:
           # to get mid point without going over
            mid = l + (r - l) // 2

            if nums[mid] > target:
                r = mid - 1
            elif nums[mid] < target:
                l = mid + 1
            else:
                return mid
        return -1



