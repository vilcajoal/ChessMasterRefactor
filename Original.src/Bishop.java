import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Bishop extends ChessGamePiece{
    private static Bishop instance = null;
   
    private Bishop( ChessGameBoard board, int row, int col, int color ){
        super( board, row, col, color );
    }
    
    public static Bishop getInstance(ChessGameBoard board, int row, int col, int color) {
        if (instance == null) {
            instance = new Bishop(board, row, col, color);
        }
        return instance;
    }
    
    @Override
    protected ArrayList<String> calculatePossibleMoves( ChessGameBoard board ){
        ArrayList<String> allMoves = new ArrayList<String>();
        allMoves.addAll( calculateNorthEastMoves( board, 8 ) );
        allMoves.addAll( calculateNorthWestMoves( board, 8 ) );
        allMoves.addAll( calculateSouthEastMoves( board, 8 ) );
        allMoves.addAll( calculateSouthWestMoves( board, 8 ) );
        return allMoves;
    }
    
    @Override
    public ImageIcon createImageByPieceType(){
        if ( getColorOfPiece() == ChessGamePiece.WHITE ){
            return new ImageIcon(
                getClass().getResource("chessImages/WhiteBishop.gif")
            );            
        }
        else {
            return new ImageIcon(
                getClass().getResource("chessImages/BlackBishop.gif")
            );
        }
    }
}
