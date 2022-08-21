#Solution1 (brute force method) uses a nested for loop to iterate 
# through every possible combination O(n^2) time O(1) memory
def twoSum(self, nums, target):
        for x in range(len(nums)):
            for y in range(len(nums)):
                if nums[x] + nums[y] == target:
                    return [x,y]



#Solution2 hashmap solution O(n) time and O(n) memory
def twoSum1(self, nums, target):
    hashmap = {}
    #this line creates a for loop that allows us to retrieve the index (x) of the number
    # and the number(n) itself in nums
    for x, n in enumerate(nums):
        #creates a number that is the difference between target and the number in nums array
        diff = target - n
        if diff in hashmap:
            return [hashmap[diff], x]
        #adds the index to match each value of nums to the hashmap
        hashmap[n] = x
    return