import java.util.ArrayList;

public interface Piece {
    ArrayList<String> calculatePossibleMoves(ChessGameBoard board);
}

public class PieceAdapter extends ChessGamePiece implements Piece {

    public PieceAdapter(ChessGameBoard board, int row, int col, int color) {
        super(board, row, col, color, true);
    }

    @Override
    public ArrayList<String> calculatePossibleMoves(ChessGameBoard board) {
        ArrayList<String> moves = new ArrayList<String>();
        return moves;
    }

    @Override
    public ImageIcon createImageByPieceType() {
        if (getColorOfPiece() == ChessGamePiece.WHITE) {
            return new ImageIcon(getClass().getResource("chessImages/WhitePawn.gif"));
        } else if (getColorOfPiece() == ChessGamePiece.BLACK) {
            return new ImageIcon(getClass().getResource("chessImages/BlackPawn.gif"));
        } else {
            return new ImageIcon(getClass().getResource("chessImages/default-Unassigned.gif"));
        }
    }
}

public class Pawn extends PieceAdapter {

    private boolean notMoved;

    public Pawn(ChessGameBoard board, int row, int col, int color) {
        super(board, row, col, color);
        notMoved = true;
        possibleMoves = calculatePossibleMoves(board);
    }

    @Override
    public boolean move(ChessGameBoard board, int row, int col) {
        if (super.move(board, row, col)) {
            notMoved = false;
            possibleMoves = calculatePossibleMoves(board);
            if (getColorOfPiece() == ChessGamePiece.BLACK && row == 7 || getColorOfPiece() == ChessGamePiece.WHITE && row == 0) {
                board.getCell(row, col).setPieceOnSquare(new Queen(board, row, col, getColorOfPiece()));
            }
            return true;
        }
        return false;
    }
}
