import math
from typing import List


class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        # how to incorporate binary search here

        # l r 

        # n piles of bananas 
        # h is the limit of hours

        # i think we can set the l to 0 and r to h
        # then have our rate checker tell us whether or not the number works

        # set l to minimum rate
        l = 1
        r = 0
        for pile in piles:
            r = max(r, pile)
        
        def rateChecker(bananaRate: int):
            hourCount = 0
            for pile in piles:
                #integer division to find num hours to eat each pile (round up)
                numHours = math.ceil(pile / bananaRate)
                hourCount += numHours
                if hourCount > h:
                    return False
            
            return hourCount <= h

        
        minHours = float("inf")
        # do our binary search

        # [3, 6, 7, 11] h = 8

        # mid = 4
        # we called rateChecker(4) -> hourCount = 1, hourCount = 3, hourCount = 7   


        while l <= r:
            mid = l + ((r - l) // 2)
            worked = rateChecker(mid)

            if worked:
                minHours = mid
                r = mid - 1
            else:
                l = mid + 1

        return minHours
