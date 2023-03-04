import javax.swing.ImageIcon;
import java.util.ArrayList;

public class Rook extends ChessGamePiece {
    
    public Rook(ChessGameBoard board, int row, int col, int color) {
        super(board, row, col, color);
    }
    
    protected ArrayList<String> calculatePossibleMoves(ChessPieceAdapter adapter) {
        ArrayList<String> northMoves = adapter.getMovesInDirection(getPieceRow(), getPieceColumn(), -1, 0, 8);
        ArrayList<String> southMoves = adapter.getMovesInDirection(getPieceRow(), getPieceColumn(), 1, 0, 8);
        ArrayList<String> westMoves = adapter.getMovesInDirection(getPieceRow(), getPieceColumn(), 0, -1, 8);
        ArrayList<String> eastMoves = adapter.getMovesInDirection(getPieceRow(), getPieceColumn(), 0, 1, 8);
        ArrayList<String> allMoves = new ArrayList<String>();
        allMoves.addAll(northMoves);
        allMoves.addAll(southMoves);
        allMoves.addAll(westMoves);
        allMoves.addAll(eastMoves);
        return allMoves;
    }

    public ImageIcon createImageByPieceType() {
        if (getColorOfPiece() == ChessGamePiece.WHITE) {
            return new ImageIcon(getClass().getResource("chessImages/WhiteRook.gif"));
        } else if (getColorOfPiece() == ChessGamePiece.BLACK) {
            return new ImageIcon(getClass().getResource("chessImages/BlackRook.gif"));
        } else {
            return new ImageIcon(getClass().getResource("chessImages/default-Unassigned.gif"));
        }
    }
}
public interface ChessPieceAdapter {
    ArrayList<String> getMovesInDirection(int row, int col, int rowIncrement, int colIncrement, int maxSteps);
}
public class ChessGameBoard implements ChessPieceAdapter {
    
    // ... (otros métodos y propiedades)
    
    @Override
    public ArrayList<String> getMovesInDirection(int row, int col, int rowIncrement, int colIncrement, int maxSteps) {
        ArrayList<String> moves = new ArrayList<String>();
        int currRow = row + rowIncrement;
        int currCol = col + colIncrement;
        int count = 0;
        while (currRow >= 0 && currRow < NUM_ROWS && currCol >= 0 && currCol < NUM_COLS && count < maxSteps) {
            ChessGamePiece piece = getCell(currRow, currCol).getPieceOnSquare();
            if (piece == null) {
                moves.add(currRow + "," + currCol);
            } else if (piece.getColorOfPiece() != getCell(row, col).getPieceOnSquare().getColorOfPiece()) {
                moves.add(currRow + "," + currCol);
                break;
            } else {
                break;
            }}}}
  

