from typing import List


class Solution:
    def maxArea(self, height: List[int]) -> int:

        l, r = 0, len(height) - 1
        maxL, maxR = height[l], height[r]
        maxA = min(height[l], height[r]) * (r - l)

        while l < r:
            # limiting factor will be height so i'd say we increase or decrease based on which pointer is shorter
            # only check when one of the heights increases 
            if height[l] <= height[r]:
                #increase l
                l += 1
            elif height[l] > height[r]:
                # increase r
                r -= 1

            # if the height has increased, we can do a check
            #skip any time the height does not increase because we are going inwards
            # this will make area less if height does not increase
            if maxL < height[l]:
                maxL = height[l]
                # get max between current area and max area
                maxA = max(maxA, min(height[l], height[r]) * (r - l))
            elif maxR < height[r]:
                maxL = height[l]
                # get max between current area and max area
                maxA = max(maxA, min(height[l], height[r]) * (r - l))
      

        return maxA