class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // 1 indexed

        int l = 0;
        int r = numbers.length - 1;
        // two pointers l and r
        // 2, 3, 5, 8 , 10
        // target = 11
        // target = 13
        // target = 12
        // target = 10

        while (l <= r) {
            // check both sides
            

            int sum = numbers[l] + numbers[r];

            if (sum == target) {
                return new int[] {l + 1, r + 1};
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
        }
        return null;
    }
}