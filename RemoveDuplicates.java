class Solution {
    public int removeElement(int[] nums, int val) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val)
                nums[i] = 101;
        }
        System.out.println(Arrays.toString(nums));
        
        quicksort(nums, 0, nums.length - 1);
        
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 101)
                size++;
        }
        return size;
    }
    
    public void quicksort(int[] array, int firstIdx, int lastIdx) {
        if (firstIdx >= lastIdx) // base case that returns if first index is higher than last index
            return;
        int pivotIdx = new Random().nextInt(lastIdx - firstIdx) + firstIdx;
        int pivot = array[pivotIdx]; // selects random pivot between the indices
        swap(array, pivotIdx, lastIdx);
        
        int left = firstIdx; //pointer to first index of array
        int right = lastIdx; // pointer to last index
        
        while (left < right) {
            while (array[left] <= pivot && left < right) 
                left++;
            while (array[right] >= pivot && left < right) 
                right--;
            swap(array, left, right);
        }
        swap(array, left, lastIdx);
        System.out.println(Arrays.toString(array));
        
        quicksort(array, firstIdx, left - 1);
        quicksort(array, left + 1, lastIdx);
    }
    
    public void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
    
}
