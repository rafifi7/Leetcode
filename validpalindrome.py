class Solution(object):
    def isPalindrome(self, s): #O(n) speed
        s = s.lower() #converting all letters to lowercase
        s = re.sub(r'[^a-zA-Z0-9]', '', s) #removes all non-alphanumeric letters
        if (len(s) % 2) == 0:            #checks to see if the length is even or not
            first_half = s[:int(len(s)/2)]  #splits string from start to middle
            second_half = s[int(len(s)/2):] #splits string from middle to end
        else:
            first_half = s[:int(len(s)/2)]  #splits string from start to middle 
            second_half = s[int(len(s)/2) + 1:] #splits string from middle +1 to end
        first_half = first_half[::-1]  #reverses string
        if first_half == second_half: #checks if first half is equal to second half
            return True
        return False

#less memory used using pointers O(n) speed
def isPalindrome2(self, s):
    l, r = 0, len(s) - 1
    while l < r:
        while l < r and not self.alphaNum(s[l]):
            l += 1
        while l < r and not self.alphaNum(s[r]):
            r -= 1
        if s[l].lower() != s[r].lower():
            return False
        l, r = l + 1, r - 1
    return True

def alphaNum(self, c):
    return (ord('A') <= ord(c) <= ord('Z') or
            ord('a') <= ord(c) <= ord('z') or
            ord('0') <= ord(c) <= ord(9) )