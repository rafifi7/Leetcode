import heapq


class MedianFinder:

    def __init__(self):
        # max heap
        self.small = []
        # min heap
        self.large = []

    def addNum(self, num: int) -> None:
        heapq.heappush(self.small, -num)

        if self.small and self.large and -self.small[0] > self.large[0]:
            heapq.heappush(self.large, -heapq.heappop(self.small))

        
        # # Balance the heaps (small can have at most 1 more element than large)
        # if len(self.small) > len(self.large) + 1:
        #     val = -heapq.heappop(self.small)
        #     heapq.heappush(self.large, val)
        # elif len(self.large) > len(self.small):
        #     val = heapq.heappop(self.large)
        #     heapq.heappush(self.small, -val)


        if abs(len(self.small) - len(self.large)) > 1:
            larger = self.small if len(self.small) > len(self.large) else self.large
            smaller = self.large if len(self.small) > len(self.large) else self.small

            heapq.heappush(smaller, -heapq.heappop(larger))

        
  
    def findMedian(self) -> float:
        smallLen = len(self.small)
        largeLen = len(self.large)

        if smallLen > largeLen:
            return -self.small[0]
        if smallLen < largeLen:
            return self.large[0]
        

        
        avg = (-self.small[0] + self.large[0]) / 2
        return avg
    

# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()