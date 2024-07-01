// Brute Force method with insertion sort (very slow but in place)
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        if (nums.length < 2)
            return nums.length;
        int largestNum = nums[nums.length - 1];
        for (i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j > i && nums[j] == nums[i]) {
                    nums[j] = 101;    
                } 
            }        
        }
        System.out.println(Arrays.toString(nums));
        int size = 0;
        
        
        nums = insertionSort(nums);
        System.out.println(Arrays.toString(nums));
        for (i = 0; i < nums.length; i++) {
            if (nums[i] <= largestNum)
                size++;
        }
        return size;
    }
    
    public void swap(int[] c, int a, int b) {
        int temp = c[b];
        c[b] = c[a];
        c[a] = temp;
    }
    
    public int[] insertionSort(int[] c) {
        int j = 0;        
        for (int i = 1; i < c.length; i++) {
            j = i - 1;
            while (j >= 0 && c[j] > c[j + 1]) {
                swap(c, j, j + 1);
                j = j - 1;
            }
        }
        return c;
    }        
}
