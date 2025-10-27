from collections import defaultdict


class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        if len(s) < 2:
            return 1

        # sliding window technique

        # A B A B k = 2
        # l r

        #most frequent char 
        mostF = 0

        l, r = 0, 1
        # max length with replacements
        res = 0

        freq = defaultdict(int)
        # idea is to get a frequency table of alphabet, 
        # add first one 
        freq[s[l]] = 1

        while r < len(s):
            freq[s[r]] += 1
            # updates mostF as we iterate through array and we keep our current count of most common
            if mostF < freq[s[r]]:
                mostF = freq[s[r]]
                #CHECK length between (r - l + 1) - mostF to find the number of replacements we must do.
            while r - l + 1 - mostF > k:
                # we have to slide the left edge
                freq[s[l]] -= 1
                l += 1
            # else:
                # result is the max between current res and the current length
            res = max(res, r - l + 1)
            r += 1

        return res