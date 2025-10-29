from collections import defaultdict
from typing import List


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        if len(strs) <= 1:
            return [strs]
        
        ret = []
        #by default it will create a list for each key
        dct = defaultdict(list)

        # idea is to sort each string to be in alphabetical order and that will be the key we use to add to this
        # in this scenario we would be sorting at a rate of n log n for each string of length n * m strings so
        #O(n^2 logn) bad time complexity 

        # we could also use a key being frequency (dict) of letters and value being list of words
        # to create each dictionary for each word would be O(n string lengths) * O(m) number of strings

        #second option slightly more optimal

        # after finding out that you cannot use dictionaries as a key but instead would have to convert
        # dict to a frozenset, the second option is not more optimal because converting to a frozenset would
        # become O(n) + O(n) which is technically better than the sorting way but 
        #NVM frozenset was not what i thought it was, it literally is just a set that is immutable
        # DONOT USE IT frozenset being the key would not work because it doesn't account for the frequency of letters

        # ok now im realizing that we have to do a .join on the sorted list which is O(nlogn + n) which is worse 



        for string in strs:
            key = ''.join(sorted(string))
            # the sorted string is a key and will be the same for any anagram, thus we can now add everything to dict
            dct[key].append(string)

        # go through dict of key : list of anagrams
        for x in dct:
            ret.append(dct[x])

        return ret