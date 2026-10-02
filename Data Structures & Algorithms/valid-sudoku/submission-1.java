class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][10];
        boolean[][] columns = new boolean[9][10];
        boolean[][] boxes = new boolean[9][10];
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == '.'){
                    continue;
                }
                int value = board[i][j] - '0';
                if(rows[i][value] || columns[j][value] || boxes[3*(i / 3) + j/3][value]){
                    return false;
                }
                rows[i][value] = true;
                columns[j][value] = true;
                boxes[3*(i/3) + j/3][value] = true;
            }
        }
        return true;
    }

    /*
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][10];
        boolean[][] columns = new boolean[9][10];
        boolean[][] boxes = new boolean[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char current = board[i][j];
                if (current == '.') {
                    continue;
                }
                int currentAsInt = current - '0';
                if (rows[i][currentAsInt] || columns[j][currentAsInt] || boxes[i / 3 + 3 * (j / 3)][currentAsInt]) {
                    return false;
                } else {
                    rows[i][currentAsInt] = true;
                    columns[j][currentAsInt] = true;
                    boxes[i / 3 + 3 * (j / 3)][currentAsInt] = true;
                }
            }
        }
        return true;
    }
    */
}
