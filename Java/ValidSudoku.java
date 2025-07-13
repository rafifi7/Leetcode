class Solution {
    public boolean isValidSudoku(char[][] board) {
        // no repition in rows
        // no repetition in cols
        // no repetition in 3x3 boxes

        // each box is 0 1 2 and 3, 4, 5 and 6, 7,8 in rows and cols

        // use hashset to keep track of what numbers are in where if hashset contains number already, return false

        // each list has 9 hashsets one for each row, col, or box
        List<HashSet<Character>> rows = new ArrayList<>();
        List<HashSet<Character>> cols = new ArrayList<>();
        List<HashSet<Character>> boxes = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            boxes.add(new HashSet<>());
        }


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // add to rows if it doesn't contain
                if (rows.get(i).contains(board[i][j])) {
                    return false;
                } else {
                    // add the value at board[i][j] to rows
                    if (board[i][j] != '.')
                        rows.get(i).add(board[i][j]);
                }

                if (cols.get(j).contains(board[i][j])) {
                    return false;
                } else {
                    // add the value at board[i][j] to cols
                    if (board[i][j] != '.')
                        cols.get(j).add(board[i][j]);
                }

                int boxRow = i / 3;
                int boxCol = j / 3;
                // board[boxRow][boxCol] is the top left corner of box
                if (boxRow == 0) {
                    if (boxCol == 0) {
                        if (boxes.get(0).contains(board[i][j])) return false;
                        if (board[i][j] != '.') boxes.get(0).add(board[i][j]);
                    }
                    if (boxCol == 1) {
                        if (boxes.get(1).contains(board[i][j])) return false;
                        if (board[i][j] != '.') boxes.get(1).add(board[i][j]);
                    }
                    if (boxCol == 2) {
                        if (boxes.get(2).contains(board[i][j])) return false;
                        if (board[i][j] != '.') boxes.get(2).add(board[i][j]);
                    }
                } else if (boxRow == 1) {
                    if (boxCol == 0) {
                        if (boxes.get(3).contains(board[i][j])) return false;
                        if (board[i][j] != '.') boxes.get(3).add(board[i][j]);
                    }
                    if (boxCol == 1) {
                        if( boxes.get(4).contains(board[i][j])) return false;
                        if (board[i][j] != '.') boxes.get(4).add(board[i][j]);
                    }
                    if (boxCol == 2) {
                        if (boxes.get(5).contains(board[i][j])) return false;
                        if (board[i][j] != '.') boxes.get(5).add(board[i][j]);
                    }
                } else if (boxRow == 2) {
                    if (boxCol == 0) {
                        if (boxes.get(6).contains(board[i][j])) return false;
                        if (board[i][j] != '.') boxes.get(6).add(board[i][j]);
                    }
                    if (boxCol == 1) {
                        if (boxes.get(7).contains(board[i][j])) return false;
                        if (board[i][j] != '.') boxes.get(7).add(board[i][j]);
                    }
                    if (boxCol == 2) {
                        if (boxes.get(8).contains(board[i][j])) return false;
                        if (board[i][j] != '.') boxes.get(8).add(board[i][j]);
                    }
                }




            }
        }

        return true;





    }
}