//first sliding window problem very epic and cool O(n)
class Solution {
    public int maxVowels(String s, int k) {
        int maxCount = 0, currCount = 0;
        HashSet<Character> hs = new HashSet<>(Set.of('a', 'e', 'i', 'o', 'u'));
        // forloop for first k letters aka first window
        for (int i = 0; i < k; i++) {
            if (hs.contains(s.charAt(i)))
                currCount++;
        }
        maxCount = currCount;

        //window is from (i - k) to k
        for (int i = k; i < s.length(); i++) {
            if (hs.contains(s.charAt(i - k))) //removing first part of last window
                currCount--;
            if (hs.contains(s.charAt(i))) //adding last part of new window
                maxCount = Math.max(maxCount, ++currCount);
        }

        return maxCount;
    }
}