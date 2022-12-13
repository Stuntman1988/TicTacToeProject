public class GameRules {


    public boolean isValidMove(int X, int Y, char[][] board) {
        return board[X][Y] != 'X' && board[X][Y] != 'O';
    }

    public char isGameEnd(char[][] board, char playerMark) {
        if (checkWinner(board, playerMark)) {
            return playerMark;
        } else if (isBoardFull(board)) {
            return 'D';
        } else return 'C';
    }

    private boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != 'X' || board[i][j] != 'O') {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkWinner(char[][] board, char mark) {



    }
}
//[][][]
//[][][]
//[][][]
