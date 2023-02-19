package lk.ijse.dep.service;

public class BoardImpl implements Board {
    private Piece piece[][];
    private BoardUI boardUI;

    public BoardImpl() {
    }

    public BoardImpl(BoardUI boardUI) {

        this.boardUI = boardUI;
        piece=new Piece[NUM_OF_COLS][NUM_OF_ROWS];

        for (int i = 0; i < piece.length; i++) {
            for (int j = 0; j < piece[i].length; j++) {
                piece[i][j]=Piece.EMPTY;
            }
        }
    }

    @Override
    public BoardUI getBoardUI() {
        return boardUI;
    }

    @Override
    public int findNextAvailableSpot(int col) {
        int filled = 0;
        for (int i = 0; i < piece[i].length; i++) {
            if (piece[col][i] != Piece.EMPTY) {
                filled++;
            }
        }
        if (filled >= 5) {
            filled = -1;
        }
        return filled;
    }

    @Override
    public boolean isLegalMove(int col) {
        boolean move = true;
        int count = findNextAvailableSpot(col);
        if (count == -1) {
            move = false;
        }
        return move;
    }

    @Override
    public boolean existLegalMoves() {
        return false;
    }

    @Override
    public void updateMove(int col, Piece move) {
        piece[col][findNextAvailableSpot(col)] = move;
    }

    @Override
    public void updateMove(int col, int row, Piece move) {

    }

    @Override
    public Winner findWinner() {
        Piece winningPiece = Piece.EMPTY;

        int col1 = 0;
        int col2 = 0;
        int row1 = 0;
        int row2 = 0;

        for (int i = 0; i < piece.length; i++) {
            if (findNextAvailableSpot(i) == 4 || findNextAvailableSpot(i) == -1) {
                if (piece[i][0] == piece[i][1] && piece[i][1] == piece[i][2] && piece[i][2] == piece[i][3]) {
                    winningPiece = piece[i][0];
                    col1 = i;
                    col2 = i;
                    row1 = 0;
                    row2 = 3;
                } else if (piece[i][1] == piece[i][2] && piece[i][2] == piece[i][3] && piece[i][3] == piece[i][4]) {
                    winningPiece = piece[i][1];
                    col1 = i;
                    col2 = i;
                    row1 = 1;
                    row2 = 4;
                }
            }
        }

        for (int i = 0; i < piece[i].length; i++) {
            if (findAvailability(i) == 4 || findAvailability(i) == 5 || findAvailability(i) == -1) {
                if (piece[i][0] == piece[i][1] && piece[i][1] == piece[i][2] && piece[i][2] == piece[i][3]) {
                    winningPiece = piece[0][i];
                    col1 = 0;
                    col2 = 3;
                    row1 = i;
                    row2 = i;
                } else if (piece[i][1] == piece[i][2] && piece[i][2] == piece[i][3] && piece[i][3] == piece[i][4]) {
                    winningPiece = piece[1][i];
                    col1 = 1;
                    col2 = 4;
                    row1 = i;
                    row2 = i;
                } else if (piece[i][2] == piece[i][3] && piece[i][3] == piece[i][4] && piece[i][4] == piece[i][5]) {
                    winningPiece = piece[1][i];
                    col1 = 2;
                    col2 = 5;
                    row1 = i;
                    row2 = i;
                }
            }
        }

        Winner winner;
        if (winningPiece == Piece.EMPTY) {
            winner = new Winner(winningPiece);
        } else {
            winner = new Winner(winningPiece, col1, col2, row1, row2);
        }
        return winner;
    }

    private int findAvailability(int row) {
        int count = 6;
        for (int i = 0; i < piece.length; i++) {
            if (piece[i][row] == Piece.EMPTY) {
                count--;
            }
        }
        if (count == 6) {
            count = -1;
        }
        return count;
    }


}
