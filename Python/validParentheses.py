
#O(n) time       
def isValid(self, s):
    stack = []
    closetoOpen = {")" : "(", "]" : "[", "}" : "{"}

    for x in s:
        if x in closetoOpen:
            if stack and stack[-1] == closetoOpen.get(x):
                stack.pop()
            else:
                return False
        else:
            return True;
