from collections import defaultdict


class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        
        sFreq = defaultdict(int)
        tFreq = defaultdict(int)

        # add each to dict

        for i in range(len(s)):
            sFreq[s[i]] += 1
            tFreq[t[i]] += 1
        
        return sFreq == tFreq