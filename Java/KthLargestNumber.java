// O(n) + O(n) because loads all nums into a hashmap that contains counts of each
// then it iterates down from the highest number and checks the hashmaps for the counts
// everytime we add the count of an integer n we find the x largest integer where x is the sum of all the counts

class Solution {
    public int findKthLargest(int[] nums, int k) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        int largestK = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            //load nums into map with counts
            counts.put(nums[i], counts.getOrDefault(nums[i], 0) + 1);
            largestK = Math.max(nums[i], largestK);
        }

        int numCount = 0;
        while (numCount < k) { // the number of k's are greater than 
            if (counts.containsKey(largestK)) {
                numCount += counts.get(largestK);
            }
            largestK--;
        }

        return largestK + 1;
    }
}