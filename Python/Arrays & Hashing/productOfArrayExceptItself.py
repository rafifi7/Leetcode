from typing import List


class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        # we want O(1) extra space complexity 
        # not counting the return array

        # 1, 2, 3, 4 is what we're given
        # 24, 12, 8, 6 is what we return

        # i think we do two passes
        # one with a variable starting at the front
        # like this:
        # x = 1 nums[x]


        ret = [0] * len(nums)
        prefixVar = 1
        for i, num in enumerate(nums):
            ret[i] = prefixVar
            prefixVar *= num

        postfixVar = 1
        #reverse order 
        for i in range(len(nums) - 1, -1, -1):
            # get number from nums list
            num = nums[i]
            # multiply by 1 on first iteration
            ret[i] *= postfixVar
            # then multiply the multiplier so that it get everything up to index in list
            postfixVar *= num

        return ret