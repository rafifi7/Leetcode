from typing import List

# most efficient because it uses the same list during the dfs decision making
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        ret = []
        path = []
        def dfs(i):
            if i == len(nums):
                ret.append(path.copy())
                return
        
            # Include nums[i]
            path.append(nums[i])
            dfs(i + 1)

            # Don't include nums[i]
            path.pop()
            dfs(i + 1)
            
            
        
        dfs(0)
        return ret