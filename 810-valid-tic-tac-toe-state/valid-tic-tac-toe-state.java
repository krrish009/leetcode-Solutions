class Solution {
    public boolean validTicTacToe(String[] board) {
        
        int countX = 0;
        int countO = 0;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                char ch = board[i].charAt(j);
                if(ch =='X') countX++;
                if(ch =='O') countO++;
            }
        }
        if(countX - countO != 0 && countX - countO != 1) return false;

        boolean xWin = isWinner(board, 'X');
        boolean oWin = isWinner(board, 'O');
        
        if(xWin && oWin) return false;
        if(xWin && countX != countO + 1) return false;
        if(oWin && countX != countO) return false;
        return true;
    }

     private boolean isWinner(String[] board, char p) {

        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == p && board[i].charAt(1) == p && board[i].charAt(2) == p) return true; // Rows.
            if (board[0].charAt(i) == p && board[1].charAt(i) == p && board[2].charAt(i) == p) return true; // Colums.
        }
  
        if (board[0].charAt(0) == p && board[1].charAt(1) == p && board[2].charAt(2) == p) return true;
        if (board[0].charAt(2) == p && board[1].charAt(1) == p && board[2].charAt(0) == p) return true;
        
        return false;
    }
}