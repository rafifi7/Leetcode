from collections import deque
from typing import List


class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        # if k < len(nums) treat it normally
        ret = []
        dq = deque()

        #monotonically decreasing queue
        # deque will always be decreasing
        # if it is not decreasing, we will remove all elemnts to the left of the higher number to make deque decreasing
        l= 0
        for i in range(k):
            # if dq empty or last element is not less than this one
            if len(dq) == 0 or dq[-1] >= nums[i]:
                dq.append(nums[i])
            # if last element is less than this, we can remove it
            else:
                while len(dq) > 0 and dq[-1] < nums[i]:
                    dq.pop()
                dq.append(nums[i])

        #largest number

        ret.append(dq[0])
        for r in range(k, len(nums)):
            
            if dq[0] == nums[l]:
                dq.popleft()
            # shift left edge
            l += 1
            
            # shift right edge
            if len(dq) == 0 or dq[-1] >= nums[r]:
                dq.append(nums[r])
            else:
                while len(dq) > 0 and dq[-1] < nums[r]:
                    dq.pop()
                dq.append(nums[r])
            ret.append(dq[0])

        return ret