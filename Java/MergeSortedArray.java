 class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /*  
            nums1 = [4, 5, 6, 0, 0, 0] nums2 = [1, 2, 3]

            step1: create 3 pointers: midx for end of nums1, nidx for end of nums2, r for end of return array
            
            step2: once, midx is less than 0, you will simply set index r to nidx and decrement both


        */

        int r  = n + m - 1;
        int mIdx = m - 1;
        int nIdx = n - 1;

        while (mIdx > -1 && nIdx > -1) {
            if (nums1[mIdx] > nums2[nIdx]) {
                nums1[r--] = nums1[mIdx--]; // nums1[r] is now nums1[mIdx] but nums1[mIdx] doesnt change
            } else if (nums1[mIdx] <= nums2[nIdx]) {
                nums1[r--] = nums2[nIdx--];
            } 
            // if they are equal what do we do?
            // a: doesn't matter if we account for it later, we just choose one and go with it
            // so we chose to take from the nums2 array, so
        }

        while (nIdx > -1) { // fill remaining r with nIdx
            nums1[r--] = nums2[nIdx--];
        }
    }
}