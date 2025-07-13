class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int [2];

        HashMap<Integer, Integer> numToIdx = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int answer = target - nums[i];

            if (numToIdx.containsKey(answer) && i != numToIdx.get(answer)) {
                ret[0] = i;
                ret[1] = numToIdx.get(answer);
                return ret;
            } 

            numToIdx.put(nums[i], i);
        }
        return ret;
       
    }
}