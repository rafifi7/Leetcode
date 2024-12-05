// O(n^2) solution but not fast enough for leetcode
class Solution {
    public int[] productExceptSelf(int[] nums) {
        // simple solution is to go O(n^2)
        int[] ret = new int[nums.length]; 
        int one = 1; //will be the multiplier
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j == i)
                    continue;
                else
                    one *= nums[j];
            }
            ret[i] = one;
            one = 1;
        }

        return ret;

    }
}

// more optimal O(n) solution using postfix but still has issues with O(n) memory
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int [nums.length];
        int[] postfix = new int [nums.length]; 

        for (int i = 0; i < nums.length; i++) { // prefix array
             if (i == 0) {
                prefix[i] = nums[i];
             } else {
                prefix[i] = nums[i] * prefix[i - 1];
             }
        }

        for (int i = nums.length - 1; i >= 0; i--) { //postfix array
            if (i == nums.length - 1) {
                postfix[i] = nums[i];
            } else {
                postfix[i] = nums[i] * postfix[i + 1];
            }
        }
        
        int[] out = new int [nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                out[i] = postfix[i + 1];
            } else if (i == nums.length - 1) {
                out[i] = prefix[i - 1];
            } else {
                out[i] = prefix[i - 1] * postfix[i + 1];
            }
            

        }
        return out;
    }
}


// best solution is to use the same array ur returning as the ones you complete pre and post fix on:

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prefix = 1;
        int postfix = 1;
        int[] out = new int [nums.length];

        out[0] = 1;
        for (int i = 1; i < nums.length; i++) { // prefix loop
            prefix *= nums[i - 1];
            out[i] = prefix;    
        }

        for (int i = nums.length - 1; i >= 0; i--) { //postfix loop
            out[i] *= postfix;
            postfix *= nums[i];
        }

        return out;
    }
}

