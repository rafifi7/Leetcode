//naive solution probably slow and too much memory O(4n) time
//nvm this is the best solution maybe better usage of memory doable but i will not
class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> oneSet = new HashSet<>();
        HashSet<Integer> twoSet = new HashSet<>();

        List<Integer> oneList = new ArrayList<>();
        List<Integer> twoList = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            oneSet.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            twoSet.add(nums2[i]);
        }
        for (int num : oneSet) {
            if (!twoSet.contains(num)) // if a num from nums1 is not present in nums2
                oneList.add(num);
        }
        for (int num : twoSet) {
            if (!oneSet.contains(num)) // if a num from nums2 is not present in nums1
                twoList.add(num);
        }
        

        return List.of(oneList, twoList);
    }
}



