class Solution:
    def isValid(self, s: str) -> bool:
        # create list 
        stack = []

        opens = set()
        opens.add("(")
        opens.add("{")
        opens.add("[")

        pairs = {}
        pairs[")"] = "("
        pairs["}"] = "{"
        pairs["]"] = "["


        #iterate through s 
        for char in s:
            #as we iterate, we can add chars if they are open
            if char in opens or len(stack) == 0:
                stack.append(char)
            else:
                # it must be a close
                if stack[-1] == pairs[char]:
                    stack.pop()
                else:
                    return False
                    
        return len(stack) == 0

                    