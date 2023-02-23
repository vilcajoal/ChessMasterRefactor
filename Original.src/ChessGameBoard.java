import java.util.ArrayList;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class ChessGameBoard extends JPanel {
    private static ChessGameBoard instance;
    private BoardSquare[][] chessCells;
    private BoardListener listener;

    private ChessGameBoard() {
        this.setLayout(new GridLayout(8, 8, 1, 1));
        listener = new BoardListener();
        chessCells = new BoardSquare[8][8];
        resetBoard(false);
    }

    public static ChessGameBoard getInstance() {
        if (instance == null) {
            instance = new ChessGameBoard();
        }
        return instance;
    }

    public BoardSquare[][] getCells() {
        return chessCells;
    }

    private boolean validateCoordinates(int row, int col) {
        return chessCells.length > 0 && chessCells[0].length > 0 && row < chessCells.length && col < chessCells[0].length
                && row >= 0 && col >= 0;
    }

    public BoardSquare getCell(int row, int col) {
        if (validateCoordinates(row, col)) {
            return chessCells[row][col];
        }
        return null;
    }

    public void clearCell(int row, int col) {
        if (validateCoordinates(row, col)) {
            chessCells[row][col].clearSquare();
        } else {
            throw new IllegalStateException(
                    "Row " + row + " and column" + " " + col + " are invalid, or the board has not been"
                            + "initialized. This square cannot be cleared.");
        }
    }

    public ArrayList<ChessGamePiece> getAllWhitePieces() {
        ArrayList<ChessGamePiece> whitePieces = new ArrayList<ChessGamePiece>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessCells[i][j].getPieceOnSquare() != null
                        && chessCells[i][j].getPieceOnSquare().getColorOfPiece() == ChessGamePiece.WHITE) {
                    whitePieces.add(chessCells[i][j].getPieceOnSquare());
                }
            }
        }
        return whitePieces;
    }
    public class ChessBoard {
    private static ChessBoard instance = null;
    private BoardSquare[][] chessCells;
    private BoardListener listener;

    private ChessBoard() {
        listener = new BoardListener();
    }

    public static ChessBoard getInstance() {
        if (instance == null) {
            instance = new ChessBoard();
        }
        return instance;
    }

    public void resetBoard(boolean addAfterReset) {
        chessCells = new BoardSquare[8][8];
        removeAll();
        clearGraveyardsAndLog();
        initializeBoardSquares(addAfterReset);
        repaint();
    }

    private void clearGraveyardsAndLog() {
        if (getParent() instanceof ChessPanel) {
            ((ChessPanel) getParent()).getGraveyard(1).clearGraveyard();
            ((ChessPanel) getParent()).getGraveyard(2).clearGraveyard();
            ((ChessPanel) getParent()).getGameLog().clearLog();
        }
    }

    private void initializeBoardSquares(boolean addAfterReset) {
        for (int i = 0; i < chessCells.length; i++) {
            for (int j = 0; j < chessCells[0].length; j++) {
                initializeBoardSquare(i, j, addAfterReset);
            }
        }
    }

    private void initializeBoardSquare(int i, int j, boolean addAfterReset) {
        ChessGamePiece pieceToAdd = null;
        if (i == 1) {
            pieceToAdd = new Pawn(this, i, j, ChessGamePiece.BLACK);
        } else if (i == 6) {
            pieceToAdd = new Pawn(this, i, j, ChessGamePiece.WHITE);
        } else if (i == 0 || i == 7) {
            int colNum = i == 0 ? ChessGamePiece.BLACK : ChessGamePiece.WHITE;
            pieceToAdd = getPieceToAdd(i, j, colNum);
        }
        chessCells[i][j] = new BoardSquare(i, j, pieceToAdd);
        setColorForBoardSquare(i, j);
        if (addAfterReset) {
            chessCells[i][j].addMouseListener(listener);
            add(chessCells[i][j]);
        }
    }

    private ChessGamePiece getPieceToAdd(int i, int j, int colNum) {
        ChessGamePiece pieceToAdd;
        if (j == 0 || j == 7) {
            pieceToAdd = new Rook(this, i, j, colNum);
        } else if (j == 1 || j == 6) {
            pieceToAdd = new Knight(this, i, j, colNum);
        } else if (j == 2 || j == 5) {
            pieceToAdd = new Bishop(this, i, j, colNum);
        } else if (j == 3) {
            pieceToAdd = new King(this, i, j, colNum);
        } else {
            pieceToAdd = new Queen(this, i, j, colNum);
        }
        return pieceToAdd;
    }

    private void setColorForBoardSquare(int i, int j) {
        if ((i + j) % 2 == 0) {
            chessCells[i][j].setBackground(Color.WHITE);
        } else {
            chessCells[i][j].setBackground(Color.BLACK);
        }
    }

    public void initializeBoard() {
        resetBoard(false);
    }