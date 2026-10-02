class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        //Using visited matrix was the first naive solution before optimization.
        //boolean[][] visited = new boolean[m][n];
        boolean found = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //An optimiztion would be to not use visited matrix, and directly change in the original board;
                //found = backTrack(board, word, visited, i, j,0);
                found = backTrack(board, word, i, j,0);
                if (found) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean backTrack(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        if(i>= board.length || i< 0 || j>= board[0].length || j< 0){
            return false;
        }
        if (word.charAt(index) != board[i][j]) {
            return false;
        }
        char tmp = board[i][j];
        board[i][j] = '#';
        boolean found = backTrack(board, word, i, j+1, index+1) || 
                        backTrack(board, word, i, j-1, index+1) ||
                        backTrack(board, word, i+1, j, index+1) ||
                        backTrack(board, word, i-1, j, index+1);
        board[i][j] = tmp;
        return found;
    }
}
