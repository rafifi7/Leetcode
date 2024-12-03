import java.util.Collections;
import java.util.HashSet;

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        StringBuilder gcd = new StringBuilder(); // Use StringBuilder for efficient concatenation
        int i = 0, j = 0;
        String result = ""; // To store the valid GCD string

        while (i < str1.length() && j < str2.length() && str1.charAt(i) == str2.charAt(j)) {
            gcd.append(str1.charAt(i)); // Append matching characters to gcd
            
            // Check if the gcd can fully divide both strings
            String candidate = gcd.toString();
            if (str1.replaceAll(candidate, "").isEmpty() && str2.replaceAll(candidate, "").isEmpty()) {
                result = candidate; // Update the result if valid
            }
            
            i++;
            j++;
        }

        return result;
    }
}
