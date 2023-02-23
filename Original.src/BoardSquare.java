import javax.swing.JLabel;
import javax.swing.JPanel;

public class BoardSquare extends JPanel{
    private static BoardSquare instance = null;
    private int row;
    private int col;
    private ChessGamePiece piece;
    private JLabel imageLabel;

    private BoardSquare(int row, int col, ChessGamePiece piece) {
        super();
        this.row = row;
        this.col = col;
        this.piece = piece;
        updateImage();
    }

    public static BoardSquare getInstance(int row, int col, ChessGamePiece piece) {
        if (instance == null) {
            instance = new BoardSquare(row, col, piece);
        }
        return instance;
    }

    private void updateImage(){
        if (imageLabel != null){
            removeAll();
        }
        if (piece != null){
            imageLabel = new JLabel();
            imageLabel.setIcon(piece.getImage());
            add(imageLabel);
        }
        revalidate();
    }

    public int getRow(){
        return row;
    }

    public int getColumn(){
        return col;
    }

    public ChessGamePiece getPieceOnSquare(){
        return piece;
    }

    public void setPieceOnSquare(ChessGamePiece p){
        piece = p;
        updateImage();
    }

    public void clearSquare(){
        piece = null;
        removeAll();
    }
}