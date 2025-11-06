from typing import List


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        # essentially same as binary search except we have to find the range that works first
        # first we should go to the middle list of the matrix and make sure the target is >= first num and <= second num

        # r is number of lists - 1, l is beginning index of lists
        l, r = 0, len(matrix) - 1
        # print(r)
        i = 0
        while l <= r:
            # we need to check target based on the mid list
            mid = l + (r - l) // 2

            # now we need to ensure that edges of the mid list contain the target                   
            if target > matrix[mid][-1]:
                # if target is greater than the largest element in the middle list
                l = mid + 1
            elif target < matrix[mid][0]:
                # if target is less than the smallest element in the middle list
                r = mid - 1
            else:
                # target is inside window
                innerL, innerR = 0, len(matrix[0]) - 1
                # print("L", innerL)
                # print("R", innerR)
                while innerL <= innerR:
                    innerM = innerL + (innerR - innerL) // 2

                    # we want to choose the middle list which hasn't changed since being correct
                    # we want to use the innerM to see which pointer to increase

                    # target 13 [10, 11, 16, 20]

                    # l = 0, r = 3
                    # m = 1 13 > 11 -> l = 1 + 1
                    # l = 2 r = 3
                    # m = 2 13 < 16 -> r = 2 - 1 
                    # l = 2 r = 1  

                    # time limit excceds because it will continue to go through the target > matrix[mid][innerM] 
                    # because of target 13 being greater than innerM = 1 11
                    # so we have to do a check that checks if L and R are neighbors and target not either of them
                    if innerL == innerR or innerL + 1 == innerR:
                        if target == matrix[mid][innerR] or target == matrix[mid][innerL]:
                            return True
                        else: 
                            return False
                    
                    elif target > matrix[mid][innerM]:
                        # target is bigger so we have to increase L
                        innerL = innerM + 1
                    elif target < matrix[mid][innerM]:
                        # target is smaller so we have to decrease R
                        innerR = innerM - 1
                    else:
                        # we have hit the target
                        return True

        return False