from collections import defaultdict


class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if len(t) > len(s):
            return ""
        if t == "": return t
        # create hashmaps of t first
        tDict = defaultdict(int)
        need = 0
        for i in t:
            # add each letter to freq dict
            tDict[i] += 1
        need = len(tDict)

        sDict = defaultdict(int)

        # as we iterate s, any time there is something from t, we will add to sDict and check if the two dicts are equal 
        l = 0
        have = 0

        currMin = 1000000 # larger than 10^5 which is the max constraint
        currString = [-1, -1]


        for r in range(len(s)):
            sDict[s[r]] += 1
            if s[r] in tDict and sDict[s[r]] == tDict[s[r]]:
                have += 1

            while have == need:
                if currMin > r - l + 1:
                    currMin = r - l + 1
                    currString = [l, r + 1]
                # when can we slide left edge? we should slide when we can which is when have == need
                # update have whenever we get rid of l

                if s[l] in tDict and sDict[s[l]] == tDict[s[l]]:
                    have -= 1                    
                sDict[s[l]] -= 1
                l+=1
           
           
        
        if currMin == 1000000:
            return ""
        return s[currString[0]: currString[1]]

