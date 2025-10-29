from collections import defaultdict
from typing import List


class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # better than O(n logn) which means it should be O(n)

        # one pass through should get the frequencies into a dictionary
        ret = []
        freq = defaultdict(int)
        for i in nums:
            freq[i] += 1
        # we have frequencies, now we must get top k frequencies
        # im thinking we can do another loop through mapping the frequency to a list of a values
        count_to_elements = defaultdict(list)
        for key, value in freq.items():
            # adds makes key the value and value the key
            count_to_elements[value].append(key)

        # we can iterate through the length of nums because at max, one frequency will be the largest
        i = len(nums)
        # len(ret) must be less than k in order to get the top k frequent elements
        while i > 0 and len(ret) < k:
            # check items to see if the current max number exists
            if i in count_to_elements:
                # we want to get every element that has a count of i
                for x in count_to_elements[i]:
                    if len(ret) < k:
                        ret.append(x)
                    else:
                        #break because we are going past k elements if we dont
                        break
            i-=1
        return ret