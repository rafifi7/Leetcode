// O(n) solution very optimal

class Solution {
    public int longestSubarray(int[] nums) {
        int l = 0, r = 0;
        int maxCount = 0, zero = -1;

        while (r < nums.length) {
            if (nums[r] == 0) { // if right ptr hits a zero
                l = zero + 1; //left will become 0 if its the first or will go past the last zero that was found
                zero = r;   //save index of next zero
            }
            maxCount = Math.max(r++ - l, maxCount);
        }
        return maxCount;
    }
}