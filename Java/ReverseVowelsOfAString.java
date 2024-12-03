// O (2n) solution since I'm finding all the vowels first then iterating through the list backwards while going through list of indices

class Solution {
    public String reverseVowels(String s) {
        List<Integer> lst = new ArrayList<>();
        List<Character> vowels = new ArrayList<>();
        Set<Character> vowelSet = Set.of('a', 'e', 'i', 'o', 'u');
        for (int i = 0; i < s.length(); i++) {
            if (vowelSet.contains(Character.toLowerCase(s.charAt(i)))) {
                vowels.add(s.charAt(i));
                System.out.println(s.charAt(i));
                lst.add(i);
                System.out.println(i);
            }
        }
        //make a loop looping backwards through list of vowels
        int j = 0; // index going through lst

        StringBuilder sb = new StringBuilder(s);
        for (int i = vowels.size() - 1; i >= 0 && j < lst.size(); i--, j++) {
             // vowels.get(i) is the last vowel so it needs to go to the first index of the list of vowels
            sb.setCharAt(lst.get(j), vowels.get(i));
        }
        return sb.toString();

    }
}

// could be O(n) or maybe even O(n/2) because we can do a two pointer approach where one ptr starts at the head of the string
// while the other ptr starts at the tail of the string and it simply swaps each time both of them are vowels
class Solution {
    public String reverseVowels(String s) {
        Set<Character> vowelSet = Set.of('a', 'e', 'i', 'o', 'u');
        StringBuilder sb = new StringBuilder(s);

        //two pointers
        int i = 0;
        int j = s.length() - 1;
        Character temp = ' ';
        while (i < j) {
            boolean i_is_vowel = vowelSet.contains(Character.toLowerCase(s.charAt(i)));
            boolean j_is_vowel = vowelSet.contains(Character.toLowerCase(s.charAt(j)));
            if (i_is_vowel && j_is_vowel){ 
                // if i and j are both at a vowel we want to swap then move both ptrs
                temp = s.charAt(i);
                sb.setCharAt(i, s.charAt(j));
                sb.setCharAt(j, temp);
                i++;
                j--;
            } else if (i_is_vowel && !j_is_vowel) {
                j--;
            } else if (!i_is_vowel && j_is_vowel) {
                i++;
            } else {
                i++;
                j--;
            }
        }

        return sb.toString();

    }
}