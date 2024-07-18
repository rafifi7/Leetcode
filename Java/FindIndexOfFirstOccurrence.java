class Solution {
    public int strStr(String haystack, String needle) {
        
        if (haystack.equals(needle)) {
            return 0;
        }        
        
        int idx = 0; //tracker of index to be checked in haystack
        int j = 0; // iterate needle

        while (idx <= haystack.length() - needle.length()) { //iterates through haystack at each possible needle index
            if (needle.charAt(0) == haystack.charAt(idx)) { //want to check first letter of needle with x letter of hay
                // haystack = "mississippi" needle = "issip"
                // call match function
                if (match(needle, haystack, idx))
                    return idx;

            }
            idx++;
        }
    
        return -1;
    }



    public boolean match(String needle, String haystack, int idx) {
        int i = idx;
        for (int j = 0; j < needle.length(); j++) {
            if (needle.charAt(j) != haystack.charAt(i++)) {
                return false;
            }
        }
        return true;
    }
}