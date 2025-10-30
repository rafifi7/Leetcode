class Solution:
    def isPalindrome(self, s: str) -> bool:
        # two ideas
        # idea one is to transform string s into a lowercase no spaces string with no commas or anything
        # then have a l pointer at 0 and r pointer at len(s) - 1 and continue checking until the until the index is equal
        # solution is O(n) + O(n/2)

        # idea two is to start with the l pointer at 0 and r pointer at len(s) - 1
        # then convert every letter to lowercase when comparing to the other pointer
        # skip over anything that isn't a letter using while loop
        # this solution is technically between O(n) and O(n/2) but worst case is O(n)

        l, r = 0, len(s) - 1
        while l < r:
            # while its not in the alphabet we should skip it
            while l < r and not s[l].isalnum():
                l+=1
            
            while l < r and not s[r].isalnum():
                r-=1

            if s[l].lower() != s[r].lower():
                return False
            
            #continue by increment l decrement r
            l+=1
            r-=1
        
        return True