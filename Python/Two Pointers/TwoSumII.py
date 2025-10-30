from typing import List


class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        # non decreasing order means it can look something like this
        # 1 3 3 4 5 7 9

        # i think we can start with l at 0 and r at len(numbers), check how close the number is to target
        # if target is == obviosuly return [l, r]
        # if num[l] + num[r] < target, increase l so that we use larger numbers 
        # if num[l] + num[r] > target, decrease r so that we use smaller numbers
        l, r = 0, len(numbers) - 1

        while l < r:
            summ = numbers[l] + numbers[r]
            if summ == target:
                return [l + 1, r + 1]
            if summ < target:
                l += 1
            #sum greater than target
            else:
                r -= 1
        
        return None

