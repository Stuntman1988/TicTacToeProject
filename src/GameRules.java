public class GameRules {


public boolean isValidMove(int X, int Y, char[][] board){

    return false;
}

public char isGameEnd(char[][] board, char playerMark){
    if(checkWinner(board, playerMark)){
        return playerMark;
    } else if(isBoardFull(board)){
        return 'D';
    }
    else return 'C';
}

private boolean isBoardFull(char[][] board){
    return false;

}

private boolean checkWinner(char[][] board, char mark){
return false;
}


}
//[][][]
//[][][]
//[][][]
