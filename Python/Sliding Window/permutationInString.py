from collections import defaultdict


class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        # if s2 smaller than s1, s1 cannot be in s2
        if len(s2) < len(s1):
            return False        

        # we must do the method of creating two hashmaps with the counts of each
        oneDict = defaultdict(int)
        twoDict = defaultdict(int)

        #to populate our dicts, we must add all letters to dict
        a = 'a'
        #O(26)
        for i in range(26):
            oneDict[a] = 0
            twoDict[a] = 0
            # increments a by one
            a = chr(ord(a) + 1)
        matches = 0
        # get our two frequencies charts and add 
        #O(len(s1))        
        for i in range(len(s1)):
            #increment the count of char at i
            oneDict[s1[i]] += 1
            twoDict[s2[i]] += 1
        # get current matches count
        #O (26)
        a = 'a'
        for i in range(26):
            if oneDict[a] == twoDict[a]:
                matches += 1
            a = chr(ord(a) + 1)
        
        # set up is done

        
        # now we must use the sliding window technique on s2 to increment l or r
        l = 0
        #O(len(s2) - len(s1))
        # window size is fixed because we want to see if s1 is actually in s2 
        for r in range(len(s1), len(s2)):
            if matches == 26:
                return True
            #else we must increment both l and r
            #r first because we are starting after the length of s1 / we technically incremented r

            # add new letter to dict
            twoDict[s2[r]] += 1
            # check if this affects matches
            if twoDict[s2[r]] - 1 == oneDict[s2[r]]:
                matches -= 1
            elif twoDict[s2[r]] == oneDict[s2[r]]:
                matches += 1

            # remove letter from dict
            twoDict[s2[l]] -= 1
            # check if this affects matches
            # if they were equal before decrement matches
            if twoDict[s2[l]] + 1 == oneDict[s2[l]]:
                matches-=1
            # if they are now equal increment matches
            elif twoDict[s2[l]] == oneDict[s2[l]]:
                matches+=1
            l += 1

        return matches == 26

        # a b
        # e i d b a o o o 


        

