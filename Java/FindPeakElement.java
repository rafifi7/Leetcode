// O (log(n)) solution 

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        if (high == 0) { // length == 1
            return 0;
        }

        if (nums[low + 1] < nums[low] ) { // left edge bigger than one to the right of it
            return low;
        }
        if (nums[high - 1] < nums[high]) { // right edge bigger than one to the left of it
            return high;
        }
        // necessary edge cases for the literal edge and for size 2 or smaller

        // how can we use binary search here
        // no sorting because answer must be O (log n)

        // we have to find where there is an increasing pattern and where it stops
        // so we will look at every three elements in mid
        // if the i + 1 element is larger than ith element we will set low to the i + 1 element
        low++;
        high--;
        int mid;
        int l;
        int r;
        while (low <= high) {
            mid = low + (high - low) / 2;
            l = mid - 1;
            r = mid + 1;
            if (nums[l] < nums[mid] && nums[mid] > nums[r]) {
                //peak
                return mid;
            } else if (nums[l] < nums[mid] && nums[mid] < nums[r]) {
                // increasing
                // set low to mid + 1
                low = mid + 1;
            } else if (nums[l] > nums[mid] && nums[mid] > nums[r]) {
                //decreasing
                high = mid - 1;
            } else {
                // nums[mid] is less than both?
                // what should you do in this case
                // flip a coin and add or subtract one from low or high depending on which one
                low++;
            }
        }
        return -1;
    }
}