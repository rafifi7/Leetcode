// O(n) optimal solution

class Solution {
    public boolean increasingTriplet(int[] nums) {
        
        int i = Integer.MAX_VALUE, j = Integer.MAX_VALUE;
        for (int x = 0; x < nums.length; x++) {
            if (nums[x] <= i) {
                i = nums[x];
            } else if (nums[x] <= j) { //nums[x] is greater than i but less than j
                j = nums[x];
            } else  // nums[x] is greater than i and j so k must be larger
                return true;
        }
        return false;
    }
}