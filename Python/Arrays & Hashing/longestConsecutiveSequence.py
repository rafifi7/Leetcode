from typing import List

#O(n) to make the set + O(n) to visit each number in set to find consecutive
class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if len(nums) == 0: 
            return 0
        maxL = 0

        numbers = set()
        # would like to do one pass because constraint is O(n)
        # but am going to attempt doing two passes because one is to add to set 
         
        # find max and min and add all numbers to a set
        for i in nums:
            numbers.add(i)

        for i in numbers:
            # skip if there is a lower consecutive number in the set
            if i - 1 in numbers:
                continue
            else:
                # this means it is a consecutive minimum so we can iterate up until we can't
                r = i + 1
                while r in numbers:
                    r += 1
                maxL = max(maxL, r - i)

        return maxL
    
# this was also O(2n) but slightly less efficient due to having to remove from the set anytime we increment or decrement from a num in numbers
class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if len(nums) == 0: 
            return 0
        maxL = 0

        numbers = set()
        # would like to do one pass because constraint is O(n)
        # but am going to attempt doing two passes because one is to add to set 
         
        # find max and min and add all numbers to a set
        for i in nums:
            numbers.add(i)

        # the other pass is to find the longest sequence
        for i in nums:
            if i in numbers:
                numbers.remove(i)
                # number one to the left of i

                l = i - 1
                while l in numbers:
                    #remove from numbers
                    numbers.remove(l)
                    #decrement by one so that we keep going until we find the correct number
                    l -= 1

                # number one to the right of i
                r = i + 1

                # do same loop for above num i
                while r in numbers:
                    numbers.remove(r)
                    r+= 1

                # find length between r and l
                maxL = max(maxL, r - l - 1)





        return maxL