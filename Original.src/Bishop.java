import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Bishop extends ChessGamePiece implements Cloneable {

    public Bishop(ChessGameBoard board, int row, int col, int color) {
        super(board, row, col, color);
    }

    @Override
    protected ArrayList<String> calculatePossibleMoves(ChessGameBoard board) {
        ArrayList<String> northEastMoves = calculateNorthEastMoves(board, 8);
        ArrayList<String> northWestMoves = calculateNorthWestMoves(board, 8);
        ArrayList<String> southEastMoves = calculateSouthEastMoves(board, 8);
        ArrayList<String> southWestMoves = calculateSouthWestMoves(board, 8);
        ArrayList<String> allMoves = new ArrayList<String>();
        allMoves.addAll(northEastMoves);
        allMoves.addAll(northWestMoves);
        allMoves.addAll(southEastMoves);
        allMoves.addAll(southWestMoves);
        return allMoves;
    }

    @Override
    public ImageIcon createImageByPieceType() {
        if (getColorOfPiece() == ChessGamePiece.WHITE) {
            return new ImageIcon(getClass().getResource("chessImages/WhiteBishop.gif"));
        } else if (getColorOfPiece() == ChessGamePiece.BLACK) {
            return new ImageIcon(getClass().getResource("chessImages/BlackBishop.gif"));
        } else {
            return new ImageIcon(getClass().getResource("chessImages/BlackBishop.gif"));
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        ChessGamePiece clonedPiece = (ChessGamePiece) super.clone();
        Bishop clonedBishop = new Bishop(clonedPiece.getBoard(), clonedPiece.getRow(), clonedPiece.getColumn(),
                clonedPiece.getColorOfPiece());
        return clonedBishop;
    }
}



