package lk.ijse.dep.service;

public class BoardImpl implements Board{
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
        return 0;
    }

    @Override
    public boolean isLegalMove(int col) {
        return false;
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
