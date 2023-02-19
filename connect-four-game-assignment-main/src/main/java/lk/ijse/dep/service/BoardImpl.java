package lk.ijse.dep.service;

public class BoardImpl implements Board {
    private Piece piece[][];
    private BoardUI boardUI;

    public BoardImpl() {
    }

    public BoardImpl(BoardUI boardUI) {
        this.boardUI = boardUI;
    }

    @Override
    public BoardUI getBoardUI() {
        return null;
    }

    @Override
    public int findNextAvailableSpot(int col) {

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
    }

    @Override
    public void updateMove(int col, int row, Piece move) {

    }

    @Override
    public Winner findWinner() {
        return null;
    }
}
