// O(2n) solution

class Solution {
    public int compress(char[] chars) {
        if (chars.length == 1) return chars.length;
        StringBuilder ret = new StringBuilder("");

        int count = 1;
        char curr = chars[0];

        for (int i = 1; i < chars.length; i++) {
            // on change it will add the letter and the count if greater than 1 to ret
            if (curr != chars[i]) {
                ret.append(curr);
                if (count > 1) {
                    ret.append(String.valueOf(count));
                }
                curr = chars[i];
                count = 1;
            } else // if the letter is not changed it will simply increment count
                count++;
        }
        ret.append(curr);
        if (count > 1) {
            ret.append(count);
        }

        // Copy the compressed string back to chars array
        String compressed = ret.toString();
        for (int i = 0; i < compressed.length(); i++) {
            chars[i] = compressed.charAt(i);
        }

        return compressed.length();
    }
}