class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        maxP = 0
        l, r = 0, 1
        #sliding window technique
        while (r < len(prices)):
            if prices[r] > prices[l]:
                maxP = max(prices[r] - prices[l], maxP)
            else:
                l = r
            r += 1
            #every time that prices[r] > prices[l]:
                # maxP = max(prices[r] - prices[l], maxP)
                # r +=1 #increase this to widen the window to look for greater maximum stock price

            # if prices[l] if buy prices is greater than r we don't want to stay at this because that means 
            #buy price could be relatively high
        return maxP