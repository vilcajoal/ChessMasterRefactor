import javax.swing.JLabel;
import javax.swing.JPanel;

public class BoardSquare extends JPanel implements Cloneable {
private int row;
private int col;
private ChessGamePiece piece;
private JLabel imageLabel;
public BoardSquare(int row, int col, ChessGamePiece piece){
    super();
    this.row = row;
    this.col = col;
    this.piece = piece;
    updateImage();
}

public BoardSquare(BoardSquare square) {
    super();
    this.row = square.getRow();
    this.col = square.getColumn();
    if (square.getPieceOnSquare() != null) {
        this.piece = (ChessGamePiece) square.getPieceOnSquare().clone();
    }
    updateImage();
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

private void updateImage() {
    if (imageLabel != null) {
        removeAll();
    }
    if (piece != null) {
        imageLabel = new JLabel();
        imageLabel.setIcon(piece.getImage());
        add(imageLabel);
    }
    revalidate();
}

@Override
protected Object clone() throws CloneNotSupportedException {
    return new BoardSquare(this);
}
}
