
#solution 1 is O(n) or O(s+t) because it iterates through both strings
from collections import Counter


def isAnagram(self, s, t):
        if (len(s) != len(t)):
            return False
        #past this point indicates that they are equal length

        countS, countT = {}, {}
        #forloop that iterates through s
        for x in range(len(s)):
            countS[s[x]] = 1 + countS.get(s[x], 0)
            countT[t[i]] = 1 + countT.get(t[x], 0)
        for y in countS:
            if countS[y] != countT.get(y, 0):
                return False
        return True


#solution 2 is the same as solution 2 but in less lines
def isAnagram1(self, s, t):
    return Counter(s) == Counter(t)

#solution 3 is O(1) memory but trades off in time complexity of the speed of the sorting algorithm
def isAnagram2(self, s, t):
    #sorts both strings alphabetically and automatically iterates 
    #compares each char of string s with string t
    return sorted(s) == sorted(t)