from collections import Counter, deque
import heapq
from typing import List


class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        # lets make a queue of tasks 
        # we can also use a pq to organize them where each element 

        count = Counter(tasks)
        maxHeap = [ -cnt for cnt in count.values()]

        heapq.heapify(maxHeap)
        time = 0
        q = deque() # pair of [-cnt, idleTime]
        while maxHeap or q:
            time += 1

            if maxHeap:
                taskCount = heapq.heappop(maxHeap) + 1
                if taskCount != 0:
        # append a tuple of taskcount and the next time this will be available for completion
                    q.append([ taskCount , time + n])
            
            if q and q[0][1] == time:
                heapq.heappush(maxHeap, q.popleft()[0])
                
        return time