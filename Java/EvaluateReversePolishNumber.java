import java.util.Stack;
class Solution {
    public int evalRPN(String[] tokens) {
        

        // create a stack and iterate through tokens array and add values to it, everytime we run into a
        // math symbol 
        Stack<String> tokenStack = new Stack();

        // create hashset of math symbols
        HashSet<String> symbols = new HashSet();
        symbols.add("+");
        symbols.add("-");
        symbols.add("*");
        symbols.add("/");



        for (int i = 0; i < tokens.length; i++) {
            if (symbols.contains(tokens[i])) {
                String secondNum = tokenStack.pop();
                String firstNum = tokenStack.pop();
                int newNum = 0;
                if (tokens[i].equals("+")) {
                    newNum = Integer.parseInt(firstNum) + Integer.parseInt(secondNum);
                } else if (tokens[i].equals("-")) {
                    newNum = Integer.parseInt(firstNum) - Integer.parseInt(secondNum);
                } else if (tokens[i].equals("*")) {
                    newNum = Integer.parseInt(firstNum) * Integer.parseInt(secondNum);
                } else {// it will be '/' or division
                    newNum = Integer.parseInt(firstNum) / Integer.parseInt(secondNum);
                }
                
                tokenStack.add(Integer.toString(newNum));
                
            } else {
                // push number to stack
                tokenStack.add(tokens[i]);
            }

        }

        // 2 1 + 3 *
        // i = 0; stack = 2
        // i = 1; stack = 2, 1
        // i = 2; stack = 3
        // i = 3; stack = 3, 3
        // i = 4; stack = 9



        // 4 13 5 / +
        // i = 0; stack = 4
        // i = 1; stack = 4 13
        // i = 2; stack = 4 13 5
        // i = 3; stack = 4 2
        // i = 4; stack = 6


        return Integer.parseInt(tokenStack.pop());

        

    }
}