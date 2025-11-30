import heapq
from typing import List


class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        
        # function to find distance from 0,0
        def findDistance(x, y):
            return x ** 2 +  y ** 2

        #min heap
        heap = []
        for i, point in enumerate(points):
            # we want to add a tuple of index and distance to the heap and sort by distance
            tup = ( findDistance(point[0], point[1]), i )
            
            heapq.heappush(heap, tup)

        ret = []

        # get smallest distance's index k times
        for _ in range(k):
            value, index = heapq.heappop(heap)
            ret.append(points[index])

        return ret