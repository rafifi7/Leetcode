class Solution {
    public int reverse(int x) {
        //Naive Solution
        int y = 0;
        String s = Integer.toString(x);
        // converting to string to store each number 
        // going to traverse string S in reverse order
        String reverseS = "";
        if (s.charAt(0) == '-') {
            reverseS += "-";
            s = s.substring(1);
        }

        for (int i = s.length() - 1; i > -1; i--) {
            reverseS += s.charAt(i);
        }

        //attempt to convert using parse Int
        try {
            y = Integer.parseInt(reverseS);
        } catch (Exception e) {
            y = 0;
        }

        return y;   
    }

    public int reverse2(int x) {
        //Optimal Solution
        long reversed = 0;  // using long to prevent overflow

        while (x != 0) {
            reversed = reversed * 10 + x % 10;  // Multiply existing reversed by 10 and add the last digit of x
            x /= 10;  // Remove the last digit from x

            // Check for overflow by comparing with Integer.MAX_VALUE and Integer.MIN_VALUE
            if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
                return 0;  
            }
        }

        return (int) reversed;
    }
}