package Recursion.Medium;

public class WordSearch {

    public static void main(String[] args) {
//        Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
//        Output: true


//        Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
//        Output: false
    }

    static class Solution {
        public boolean exist(char[][] board, String word) {
            int rows = board.length;
            int cols = board[0].length;
            boolean[][] visited = new boolean[rows][cols];

            for(int row = 0; row < rows; row++){
                for(int col = 0; col < cols; col++){
                    if(board[row][col] == word.charAt(0)){
                        visited[row][col] = true;
                        if(f(board, word, 1, row, col, visited)){
                            return true;
                        }
                        visited[row][col] = false;
                    }
                }
            }

            return false;
        }

        public boolean f(char[][] board, String word, int idx, int row, int col, boolean[][] visited) {
            //base condition
            if(idx == word.length())
                return true;

            // down
            if (row + 1 < board.length && word.charAt(idx) == board[row + 1][col] && !visited[row + 1][col]) {
                visited[row + 1][col] = true;
                if (f(board, word, idx + 1, row + 1, col, visited))
                    return true;
                visited[row + 1][col] = false;
            }

            // up
            if (row - 1 >= 0 && word.charAt(idx) == board[row - 1][col] && !visited[row - 1][col]) {
                visited[row - 1][col] = true;
                if (f(board, word, idx + 1, row - 1, col, visited))
                    return true;
                visited[row - 1][col] = false;
            }

            //right
            if (col + 1 < board[0].length && word.charAt(idx) == board[row][col + 1] && !visited[row][col + 1]) {
                visited[row][col + 1] = true;
                if (f(board, word, idx + 1, row, col + 1, visited))
                    return true;
                visited[row][col + 1] = false;
            }

            // left
            if (col - 1 >= 0 && word.charAt(idx) == board[row][col - 1] && !visited[row][col - 1]) {
                visited[row][col - 1] = true;
                if (f(board, word, idx + 1, row, col - 1, visited))
                    return true;
                visited[row][col - 1] = false;
            }

            return false;
        }
    }
}
