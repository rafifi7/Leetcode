//quickest solution using stringbuilder O(n)

class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder ret = new StringBuilder();
        int i = 0, j = 0;
        while (i < word1.length() && j < word2.length()) {
            ret.append(word1.charAt(i++));
            ret.append(word2.charAt(j++));
        }
        if (i >= word1.length() && j < word2.length()) {
            ret.append(word2.substring(j));
        } else if (i < word1.length() && j >= word2.length()) {
            ret.append(word1.substring(i));
        } 

        return ret.toString();
    }
}