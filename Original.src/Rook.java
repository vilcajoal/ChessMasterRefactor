import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class ChessGamePiece {
    protected int pieceRow;
    protected int pieceColumn;
    protected int colorOfPiece;
    protected boolean isPieceOnScreen;
    protected boolean isKing;
    protected ArrayList<String> possibleMoves;
    protected ChessGameBoard gameBoard;
    private static final Map<String, ChessGamePiece> pieces = new HashMap<>();

    protected ChessGamePiece(ChessGameBoard board, int row, int col, int color, boolean isKing) {
        this.gameBoard = board;
        this.pieceRow = row;
        this.pieceColumn = col;
        this.colorOfPiece = color;
        this.isPieceOnScreen = true;
        this.isKing = isKing;
        this.possibleMoves = new ArrayList<String>();
    }

    protected ChessGamePiece(ChessGameBoard board, int row, int col, int color) {
        this(board, row, col, color, false);
    }

    public static ChessGamePiece getInstance(String type, ChessGameBoard board, int row, int col, int color) {
        String key = type + color;
        if (!pieces.containsKey(key)) {
            switch (type) {
                case "pawn":
                    pieces.put(key, new Pawn(board, row, col, color));
                    break;
                case "rook":
                    pieces.put(key, new Rook(board, row, col, color));
                    break;
                case "knight":
                    pieces.put(key, new Knight(board, row, col, color));
                    break;
                case "bishop":
                    pieces.put(key, new Bishop(board, row, col, color));
                    break;
                case "queen":
                    pieces.put(key, new Queen(board, row, col, color));
                    break;
                case "king":
                    pieces.put(key, new King(board, row, col, color));
                    break;
                default:
                    throw new IllegalArgumentException("Invalid piece type");
            }
        }
        return pieces.get(key);
    }

    public int getRow() {
        return pieceRow;
    }

    public int getColumn() {
        return pieceColumn;
    }

    public int getColorOfPiece() {
        return colorOfPiece;
    }

    public boolean isPieceOnScreen() {
        return isPieceOnScreen;
    }

    public boolean isKing() {
        return isKing;
    }

    public ArrayList<String> getPossibleMoves() {
        return possibleMoves;
    }

    public void setPossibleMoves(ArrayList<String> possibleMoves) {
        this.possibleMoves = possibleMoves;
    }}
