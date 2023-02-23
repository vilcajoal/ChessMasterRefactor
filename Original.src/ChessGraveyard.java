import java.awt.GridLayout;
import javax.swing.*;

public class ChessGraveyard extends JPanel {
    private static ChessGraveyard instance;
    private String graveyardTitle;

    private ChessGraveyard(String graveyardTitle) {
        this.graveyardTitle = graveyardTitle;
        this.add(new JLabel(graveyardTitle));
        this.setLayout(new GridLayout(8, 0));
    }

    public static ChessGraveyard getInstance(String graveyardTitle) {
        if (instance == null) {
            instance = new ChessGraveyard(graveyardTitle);
        }
        return instance;
    }

    public void addPiece(ChessPiece piece) {
        piece.setPieceLocation(-1, -1);
        JLabel pieceLabel = new JLabel();
        pieceLabel.setIcon(piece.getImage());
        this.add(pieceLabel);
    }

    public void clearGraveyard() {
        this.removeAll();
        this.add(new JLabel(graveyardTitle));
    }
}
