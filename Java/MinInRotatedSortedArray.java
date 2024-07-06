import java.util.Arrays;

public class MinInRotatedSortedArray {
    public int findMin(int[] nums) {

        // O(logn) time means binary search
        // first idea: find smallest number using version of binary search

        // RULES
        // if the num2 to the right of a num1 is < num1, num1 is max and num2 is min

        if (nums.length == 1)
            return nums[0];
        // indices
        int mid = nums.length/2;
        int low = 0;
        int high = nums.length - 1;

        int min = Integer.MAX_VALUE;

        if (nums[low] < nums[high]) //edge case where in order
            return nums[low];
        int i = nums.length;

        while (i > 0) { // idk yet
            i /= 2;
            // at mid, check left and check right to know where to go?
            // or maybe check low and high to see


            // if low < mid it means everything is in order from low to mid
            //this means that low is the current min so set min var to nums[low]
            if (nums[low] < nums[mid]) { // cut off first half
                if (nums[low] < min)
                    min = nums[low];
                low = mid; //update low so now you can search between low and high
                mid = (high + low)/2;
            } else if (nums[low] > nums[mid]) { //cut off second half
                // 5, 1, 2, 3, 4
                // 4, 5, 1, 2, 3
                // 3, 4, 5, 1, 2
                // 2, 3, 4, 5, 1


                // 5, 6, 7, 1, 2, 3, 4
                if (nums[mid] < min)
                    min = nums[mid];
                high = mid + 1;
                mid = (high + low)/2;
            } else if (low == mid) {
                if (nums[low] < nums[low + 1]) {
                    return nums[low];
                } else {
                    return nums[low + 1];
                }
            }
        }


        return min;
    }
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        int[] arr1 = {4, 5, 6, 7, 0, 1, 2};
        int[] arr2 = {11, 13, 15, 17};

        int[] arr3 = new int[20];
        int j = 0;
        int i = 15;
        for (; i < 20; i++)
            arr3[j++] = i + 1;
        for (i = 0; i < 15; i++)
            arr3[j++] = i + 1;


        System.out.println(findMin(arr));
        System.out.println(findMin(arr1));
        System.out.println(findMin(arr2));
        System.out.println(Arrays.toString(arr3));
        System.out.println(findMin(arr3));


    }
}