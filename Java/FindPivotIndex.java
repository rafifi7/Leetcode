// I think its the most optimal solution O(2n) 
// add everthing to the right of the first element to secondSum and iterate through adding ith element to left Sum and subtracting i+1th element to right Sum 

class Solution {
    public int pivotIndex(int[] nums) {
        int firstSum = 0, secondSum = 0;
        int pivot = 0;
       
        for (int i = 1; i < nums.length; i++) {
            secondSum += nums[i];
        }

        while (pivot < nums.length - 1) {
            if (firstSum == secondSum)
                return pivot;
            else {
                firstSum += nums[pivot++];
                secondSum -= nums[pivot];
            }
        }
        if (firstSum == secondSum)
            return pivot;
        return -1;
    }
}