from typing import List


class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stack = []
        ret = [0] * len(temperatures)
        # we create a stack and fill it with temperatures indices

        #iterate through temps and empty out any that are less than current
        # then add index to stack
        for i, temp in enumerate(temperatures):
            while stack and temperatures[stack[-1]] < temp:
                # temperature[stack[-1]] smaller temp
                # temp is larger temp
                # find diff in indices
                smallIdx = stack.pop()
                ret[smallIdx] = i - smallIdx
                
            # after we complete clearing out the the temps that are less than
            # the current temps we can now add the index to the stack
            stack.append(i)
        return ret
    
    