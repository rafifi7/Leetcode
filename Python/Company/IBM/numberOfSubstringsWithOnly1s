class Solution:
    def numSub(self, s: str) -> int:
        
        # first idea is to use a dictionary and keep a count of the frequency of consecutive 1 lengths
        # eg 1: x, 2: y, 3: z, 

        # then sum it all up at the end
        # this would be O(n) as it takes n time to pass through the array and n time to pass through the dictionary
        # each time you add another to the consecutive you can iterate from 1 to kth consecutive integer and add to your counts
        # cant think of other ways honestly

        count = 0
        currCount = 0
        for num in s:
            if num == "1" and currCount > 0:
                currCount += 1
                count += currCount
            elif num == "1" and currCount == 0:
                currCount += 1
                count += 1
            # case where let = 0
            else:
                # set currCount to 0
                currCount = 0
        mod = 1000000007
        return count % mod
