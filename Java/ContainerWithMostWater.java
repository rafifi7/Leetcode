//brute force O(n^2) method 
class Solution {
    public int maxArea(int[] height) {
        // brute force
        int max = 0;

        for (int i = 0; i < height.length - 1; i++) {
            for (int j = 1; j < height.length; j++) {
               int width = j - i;
               int length = Math.min(height[i], height[j]);
               int area = width * length;
               if (area > max) max = area;
            }            
        }
        return max;

    }
}

//Optimal solution  O (n) two pointer solution
class Solution {
    public int maxArea(int[] height) {
        int max = 0;

        int l = 0, r = height.length - 1;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l) ; // bottleneck times the difference between l and r
            max = Math.max(area, max);
            if (height[l] > height[r])
                r--;
            else
                l++;
        }

        return max;
    }


}