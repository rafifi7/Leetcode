// O(n^2) sliding window problem
//  
 
class Solution {
    public int lengthOfLongestSubstring(String s) {

        int maxCount = 0;

        // idea is to iterate through and keep adding to count as long as the next letter is not the same
        // if next is same, update maxCount and reset count 
        // NOTE not repeating consecutively but duplicate meaning the current string doesn't have chars 
        // we can use a similar approach with a hashset 

        // dvdf doesnt work on this currenlty
        // so what im thinking is that i have to 


        // sliding window approach
        // d v d f
        // lr            count = 1 set = [d]
        // l r        cont =  2 set = [d, v]
        // l   r      count = 2 set = [v, d]
        //   l   r       count = 3 set = [v, d, f]

        HashSet<Character> letters = new HashSet();

        int l = 0;
        int r = 0;

        while (r < s.length()) {
            Character let = s.charAt(r);
            while (letters.contains(let)) {
                maxCount = Math.max(r - l, maxCount);
                letters.remove(s.charAt(l));
                l++;
            } 

            letters.add(let);
            r++;
        }
        maxCount = Math.max(r - l, maxCount);

        return maxCount;
    }
}