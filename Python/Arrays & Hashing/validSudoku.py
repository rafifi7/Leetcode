from collections import defaultdict
from typing import List


# NOTE: this could be done more optimally using checking boxes less using a differnt math formulas and less string concatenation
# However this has the same overall time complexity of O(n^2) where n is the length and height of the grid 

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        # im thinking we can do this in one pass through the n^2
        # we can iterate through the the first row with ij and the first column with ji 
        length = len(board[0])        
        box = defaultdict(set)

        for i in range(length):
            col, row = set(), set()
            for j in range(length):
                #we can iterate through
                if board[i][j] in row:
                    return False
                if board[j][i] in col:
                    return False

                if board[i][j] != ".":    
                    row.add(board[i][j])
                if board[j][i] != ".":
                    col.add(board[j][i])      

                # figure out box situation
                # we can do it a cool way like this:
                # we get i / 3 which will be 0 1 or 2
                # next we get j / 3 which will also be 0 1 or 2
                # create a string key of both to look like "00" or "02"
                iKey = int(i / 3)
                jKey = int(j / 3)
                key = str(iKey) + str(jKey)
                if key in box:
                    #check box[key]
                    if board[i][j] in box[key]:
                        return False
                    else:
                        # need to add to the box
                        if board[i][j] != ".":
                            box[key].add(board[i][j])
                else:
                    #if not a period add the number to the set. (the value of the key value pair)
                    if board[i][j] != ".":
                        box[key].add(board[i][j])


        #figure out box after we figure out cols and rows validation


        return True