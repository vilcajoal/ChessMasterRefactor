import java.util.ArrayList;

public class King extends ChessGamePiece {
    private ChessPieceImage whitePieceImage;
    private ChessPieceImage blackPieceImage;
    private MoveCalculator moveCalculator;

    public King(ChessGameBoard board, int row, int col, int color) {
        super(board, row, col, color, false);
        this.whitePieceImage = new WhiteKingPieceImage();
        this.blackPieceImage = new BlackKingPieceImage();
        this.moveCalculator = new MoveCalculator();
    }

    protected ArrayList<String> calculatePossibleMoves(ChessGameBoard board) {
        ArrayList<String> allMoves = new ArrayList<String>();
        allMoves.addAll(moveCalculator.calculateNorthEastMoves(board, 1));
        allMoves.addAll(moveCalculator.calculateNorthWestMoves(board, 1));
        allMoves.addAll(moveCalculator.calculateSouthEastMoves(board, 1));
        allMoves.addAll(moveCalculator.calculateNorthWestMoves(board, 1));
        allMoves.addAll(moveCalculator.calculateNorthEastMoves(board, 1));
        allMoves.addAll(moveCalculator.calculateNorthEastMoves(board, 1));
        allMoves.addAll(moveCalculator.calculateNorthEastMoves(board, 1));
        allMoves.addAll(moveCalculator.calculateNorthEastMoves(board, 1));
        return allMoves;
    }

    public boolean isChecked(ChessGameBoard board) {
        return getCurrentAttackers(board).size() > 0;
    }

    @Override
    public ImageIcon createImageByPieceType() {
        if (getColorOfPiece() == ChessGamePiece.WHITE) {
            return whitePieceImage.getImage();
        } else if (getColorOfPiece() == ChessGamePiece.BLACK) {
            return blackPieceImage.getImage();
        } else {
            return new DefaultPieceImage().getImage();
        }
    }

    private interface ChessPieceImage {
        ImageIcon getImage();
    }

    private class WhiteKingPieceImage implements ChessPieceImage {
        @Override
        public ImageIcon getImage() {
            return new ImageIcon(getClass().getResource("chessImages/WhiteKing.gif"));
        }
    }

    private class BlackKingPieceImage implements ChessPieceImage {
        @Override
        public ImageIcon getImage() {
            return new ImageIcon(getClass().getResource("chessImages/BlackKing.gif"));
        }
    }

    private class DefaultPieceImage implements ChessPieceImage {
        @Override
        public ImageIcon getImage() {
            return new ImageIcon(getClass().getResource("chessImages/default-Unassigned.gif"));
        }
    }

    private class MoveCalculator {
        public ArrayList<String> calculateNorthEastMoves(ChessGameBoard board, int distance) {
            // código para calcular movimientos al noreste
        }

        public ArrayList<String> calculateNorthWestMoves(ChessGameBoard board, int distance) {
            // código para calcular movimientos al noroeste
        }

        public ArrayList<String> calculateSouthEastMoves(ChessGameBoard board, int distance) {
            // código para calcular movimientos al sureste
        }

