class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] numsTwo = new int[nums.length * 2];
        int counter = 0;
        int j = nums.length;
        for (int i = 0; i < nums.length; i++) {
            numsTwo[i] = nums[i];
            numsTwo[j++] = nums[i];
        }
        return numsTwo;
    }
}
