// На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
// И вывести Доску.
// Пример вывода доски 8x8

// 0x000000
// 0000x000
// 00x00000

public class task3 {
    private int[][] board;
    private int size;

    public task3(int size) {
        this.board = new int[size][size];
        this.size = size;
    }

    private boolean isSafe(int row, int col) {
        for (int i = 0; i < size; i++) {
            if (board[row][i] == 1 || board[i][col] == 1) {
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    private boolean placeQueens(int col) {
        if (col == size) {
            return true;
        }
        for (int i = 0; i < size; i++) {
            if (isSafe(i, col)) {
                board[i][col] = 1;
                if (placeQueens(col + 1)) {
                    return true;
                }
                board[i][col] = 0;
            }
        }
        return false;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        task3 board = new task3(8);
        board.placeQueens(0);
        board.printBoard();
    }
}
