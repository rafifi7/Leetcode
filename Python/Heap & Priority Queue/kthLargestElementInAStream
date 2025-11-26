import heapq
from typing import List


class KthLargest:

    # kth largest really means the smallest out of k elements
    # so we can keep our heap size at k elements
    # and return whenever we surpass it

    def __init__(self, k: int, nums: List[int]):
        self.heap = nums
        self.k = k
        # by default this is a min heap
        heapq.heapify(self.heap)

        while len(self.heap) > k:
            heapq.heappop(self.heap)
        

        
    def add(self, val: int) -> int:

        heapq.heappush(self.heap, val)

        if len(self.heap) > self.k:
            heapq.heappop(self.heap)
        return self.heap[0]

# Your KthLargest object will be instantiated and called as such:
# obj = KthLargest(k, nums)
# param_1 = obj.add(val)