from typing import List


class Solution:
    def findMin(self, nums: List[int]) -> int:
        # this way we can only care about nums greater than length 2
        if len(nums) == 1:
            return nums[0]
        if len(nums) == 2:
            return min(nums[0], nums[1])

        # find minimum element in rotated sorted array
        

        # minimum element will only be when preceding element is not less than it

        # what if we check the ends of the window that we are in
        # [4, 5, 6, 7, 0, 1, 2]
        # [5, 6, 7, 0, 1, 2, 4]
        # [1, 2, 4, 5, 6, 7, 0]

        # we can check the middle and compare to either end to know where the minimum would be
        # because 

        l, r = 0, len(nums) - 1

        if nums[l] < nums[r]:
            return nums[l]
        while l <= r:
            m = l + ((r - l) // 2)
            # first check left neighbor of m
            # when a number is less than the one before it we know this is the min
            if m > 0 and nums[m] < nums[m - 1]:
                return nums[m]
            if m < len(nums) - 1 and nums[m + 1] < nums[m]:
                return nums[m + 1]

            # compare mid to left left should be less than the middle if its sorted
            if nums[m] > nums[l]:
                # check if right neighbor of l is less than l
                if nums[l] > nums[l + 1]:
                    return nums[l + 1]
                if l > 0 and nums[l - 1] > nums[l]:
                    return nums[l]
                l = m + 1
            elif nums[m] < nums[r]:
                # check if left neighbor of r larger than r
                if nums[r] < nums[r - 1]:
                    return nums[r]
                if r < len(nums) - 1 and nums[r + 1] < nums[r]:
                    return nums[r + 1]
                r = m - 1


            # [0 2 1]

        return nums[m]

