from typing import List


class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        for token in tokens:
            if token.isnumeric() or len(token) > 1 and token[1:].isnumeric():
                stack.append(int(token))
            else:
                num = 0
                # operator
                match token:
                    case '/':
                        second = stack.pop()
                        first = stack.pop()
                        num = int(first / second)
                    case '-':
                        second = stack.pop()
                        first = stack.pop()
                        num = int(first - second)
                    case '*':
                        second = stack.pop()
                        first = stack.pop()
                        num = int(first * second)
                    case '+':
                        second = stack.pop()
                        first = stack.pop()
                        num = int(first + second)
                stack.append(num)
        
        # at the end there should be just one value left
        return stack[0]