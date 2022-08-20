#slow solution at O(n^2) time at O(1) space
def containsDuplicate(self, nums):
        for x in nums:
            for y in nums:
                if x == y:
                    return True
        return False

#faster solution at O(nlogn) time at O(1) space
#faster because sorting takes less time than double for loop
#slow because checking every pair of values in array
def containsDuplicate1(self, nums):
    nums.sort()
    numnums = len(nums) - 1
    for z in range(numnums):
        if nums[z] == nums[z+1]:
            return True
    return False

#fastest solution at O(n) time at O(n) space

def containDuplicate2(self, nums):
    #creates hashmap
    hashset = set()
    #for loop through nums array
    for n in nums:
        if n in hashset:
            return True
        #adds to hashmap if its not in there
        hashset.add(n)
    return False