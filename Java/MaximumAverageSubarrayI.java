// non optimal solution doesn't even pass leetcode because its so slow lol O(n^2)
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double average = 0;
        double max = Integer.MIN_VALUE;

        if (nums.length == 1) {
            return (double) nums[0];
        }

        for (int i = 0; i < nums.length - k + 1; i++) { //from every thing in nums that is possible to get a k size subarray from
            for (int j = 0; j < k; j++) { // go from 0 to k
                average += nums[i + j];                
            }
            average = average / (double) k;
            System.out.println(average);
            if (max < average) max = average;
            average = 0;
        }

        return max;
    }
}

//optimal solution using sliding glass principle
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double max = 0;
        for (int i = 0; i < k; i++) {
            max += nums[i];
        }
        // first subarray 
        double curr_sum = max;
        for (int i = k; i < nums.length; i++) {
            curr_sum += nums[i] - nums[i - k]; // remove i - kth 
            max = Math.max(max, curr_sum);
        }

        return  max / k;

    }
}
