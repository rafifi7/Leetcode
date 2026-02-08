class Solution:
    def longestPalindrome(self, s: str) -> str:
        # we want to keep track of current longest palindrome
        longest = ""
        # then we can iterate through each starting letter and do a pal check if i and j are the same in a double for loop
        # n^2 * n to do the check time complexity so probably not amazing
        for i in range(len(s)):
            for j in range(i, len(s)):
                # check if letters are the same (first check for valid pal) and length is greater (we want the longest pal)
                if s[i] == s[j] and j - i + 1 > len(longest):
                    if self.palChecker(s[i:j + 1]):
                        longest = s[i:j + 1]
        return longest




    def palChecker(self, s: str) -> bool:
        l, r = 0, len(s) - 1

        while l < r:
            if s[l] != s[r]:
                return False
            l += 1
            r -= 1
        return True

#n^3 brute force


class Solution:
    def longestPalindrome(self, s: str) -> str:
        # idea is to iterate through s and treat each letter as the center of palindrome

        longest = ""

        for i in range(len(s)):
            j, k = i, i
            # guaranteed to be true at least once in each iteration
            while j >= 0 and k < len(s) and s[j] == s[k]:
                if k - j + 1 > len(longest):
                    longest = s[j: k + 1]
                j -= 1
                k += 1
            
            # even
            j, k = i, i + 1
            while j >= 0 and k < len(s) and s[j] == s[k]:
                if k - j + 1 > len(longest):
                    longest = s[j: k + 1]
                j -= 1
                k += 1
        return longest