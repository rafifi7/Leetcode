import heapq
from typing import List


class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        heap = []

        # creates a max heap
        for stone in stones:
            heapq.heappush(heap, -1 * stone)

        while len(heap) > 1:
            # we can pop the root to get the largest
            # and pop the next root to get the second largest
            # this will be O(logn) for both
            large = heapq.heappop(heap)
            small = heapq.heappop(heap)
            if large == small:
                continue
            else:
                # we can add the difference
                difference = large - small
                # 8 and 7
                # -8 - -7 the difference is 1 
                # but we will do -1 because 
                heapq.heappush(heap, difference)
        
        if heap:
            return heap[0] * -1
        return 0

