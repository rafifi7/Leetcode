import heapq
from typing import List
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        # without sorting

        # lets try a minheap
        # heapify is n time
        heapq.heapify(nums)
        

        # n is total # of nums
        # k is the largest element we want
        # n - k is the smallest number
        small = len(nums) - k

        # now we can pop until small = 0
        while small > 0 and nums:
            small -= 1
            heapq.heappop(nums)

        return nums[0]