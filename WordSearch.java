public class WordSearch {
    char[][] matrix;
    char[] letters;
    boolean[][] visited;

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        char[][] board = {{'A', 'B', 'C', 'E' }, {'S', 'F', 'C', 'S' }, {'A', 'D', 'E', 'E' }};
        char[][] matrix = {{'A', 'B', 'C', 'E' }, {'S', 'F', 'C', 'S' }, {'A', 'D', 'E', 'E' }};
        String word = "ABCCED";
        String str = "ABCB";
        wordSearch.exist(matrix, str);
    }

    public boolean exist(char[][] board, String word) {
        int rowLen = board.length, colLen = board[0].length;
        letters = word.toCharArray();
        matrix = board;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (matrix[i][j] == letters[0]) {
                    visited = new boolean[rowLen][colLen];
                    boolean res = dfs(i, j, 0);
                    if (res == true) {
                        System.out.println(true);
                        return true;
                    }
                }
            }
        }
        System.out.println(false);
        return false;
    }

    private boolean dfs(int curRow, int curCol, int curIndex) {
        // base cases
        if (curIndex == letters.length) return true;
        if (curRow < 0 || curRow >= matrix.length || curCol < 0 || curCol >= matrix[0].length) return false;
//        if (curCol < 0 || curCol >= matrix[0].length) return false;
        if (visited[curRow][curCol] == true) return false;
        if (matrix[curRow][curCol] != letters[curIndex]) return false;

        visited[curRow][curCol] = true;

        // dfs for all 4 directions
        boolean top = dfs(curRow - 1, curCol, curIndex + 1);
        boolean down = dfs(curRow + 1, curCol, curIndex + 1);
        boolean left = dfs(curRow, curCol - 1, curIndex + 1);
        boolean right = dfs(curRow, curCol + 1, curIndex + 1);

        boolean ans = top || down || left || right;

        if (ans == false) {
            visited[curRow][curCol] = false;
        }
        return ans;
    }
}