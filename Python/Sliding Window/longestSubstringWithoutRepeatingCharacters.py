class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) < 2: 
            return len(s)
        # this is sliding window technique
        # this is how to do

        maxL = 0
        l, r = 0, 1

        # set to check with for if a char has been used
        letters = set()
        letters.add(s[l]) # add first letter to set

        # idea is to find window up until character is repeated
        # so we have to check if r and l are the same,
        # if they are the same, increment l until it is not the same as r


        while r < len(s):
            while s[r] in letters:
                # if the letters are repeating, we must increment l and update letters set
                letters.remove(s[l])
                l += 1
            #add letter at s[r] before incrementing it
            letters.add(s[r])
            r += 1
            # find max length between the set of unique chars or the current max L
            maxL = max(len(letters), maxL)

        
        return maxL