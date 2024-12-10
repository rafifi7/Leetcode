// O(n) solution very hard but simple medium for some reason
class Solution {
    public int longestOnes(int[] nums, int k) {
        //IDEA: keep track of non 1's
        int maxCount = 0,  zeroes = 0;
        if (nums.length == 0) return 0;
        int l = 0, r = 0;
        while (r < nums.length) {
            if (nums[r] == 0) {
                zeroes++;
            }

            while (zeroes > k) {
                if (nums[l] == 0) {
                    zeroes--;
                }
                l++;
            }

            maxCount = Math.max(r++ - l + 1, maxCount);
        }
        return maxCount;

    }
}