import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.awt.event.MouseEvent;

public class ChessGameEngine {
private static ChessGameEngine instance = null;
private ChessGamePiece currentPiece;
private boolean firstClick;
private int currentPlayer;
private ChessGameBoard board;
private King king1;
private King king2;

private ChessGameEngine(ChessGameBoard board) {
    firstClick = true;
    currentPlayer = 1;
    this.board = board;
    this.king1 = (King) board.getCell(7, 3).getPieceOnSquare();
    this.king2 = (King) board.getCell(0, 3).getPieceOnSquare();
    ((ChessPanel) board.getParent()).getGameLog().clearLog();
    ((ChessPanel) board.getParent()).getGameLog().addToLog(
            "A new chess "
            + "game has been started. Player 1 (white) will play "
            + "against Player 2 (black). BEGIN!");
}

public static ChessGameEngine getInstance(ChessGameBoard board) {
    if (instance == null) {
        instance = new ChessGameEngine(board);
    }
    return instance;
}

public void reset() {
    firstClick = true;
    currentPlayer = 1;
    ((ChessPanel) board.getParent()).getGraveyard(1).clearGraveyard();
    ((ChessPanel) board.getParent()).getGraveyard(2).clearGraveyard();
    ((ChessPanel) board.getParent()).getGameBoard().initializeBoard();
    ((ChessPanel) board.getParent()).revalidate();
    this.king1 = (King) board.getCell(7, 3).getPieceOnSquare();
    this.king2 = (King) board.getCell(0, 3).getPieceOnSquare();
    ((ChessPanel) board.getParent()).getGameLog().clearLog();
    ((ChessPanel) board.getParent()).getGameLog().addToLog(
            "A new chess "
            + "game has been started. Player 1 (white) will play "
            + "against Player 2 (black). BEGIN!");
}

private void nextTurn() {
    currentPlayer = (currentPlayer == 1) ? 2 : 1;
    ((ChessPanel) board.getParent()).getGameLog().addToLog(
            "It is now Player " + currentPlayer + "'s turn.");
}

public int getCurrentPlayer() {
    return currentPlayer;
}

public boolean playerHasLegalMoves(int playerNum) {
    ArrayList<ChessGamePiece> pieces;
    if (playerNum == 1) {
        pieces = board.getAllWhitePieces();
    } else if (playerNum == 2) {
        pieces = board.getAllBlackPieces();
    } else {
        return false;
    }
    for (ChessGamePiece currPiece : pieces) {
        if (currPiece.hasLegalMoves(board)) {
            return true;
        }
    }
    return false;
}

private boolean selectedPieceIsValid() {
    if (currentPiece == null) // user tried to select an empty square
    {
        return false;
    }
    if (currentPlayer == 2) // black player
    {
        if (currentPiece.getColorOfPiece() == ChessGamePiece.BLACK) {
            return true;
        }
        return false;
    } else // white player
    {
        if (currentPiece.getColorOfPiece() == ChessGamePiece.WHITE) {
            return true;
        }
        return false;
    }
}

public class ChessGame {
    private static ChessGame instance = null;
    private Board board;
    private int currentPlayer;
    private ChessGamePiece currentPiece;
    private boolean firstClick;

    private ChessGame() {
        this.board = new Board();
        this.currentPlayer = 1;
        this.currentPiece = null;
        this.firstClick = true;
    }

    public static ChessGame getInstance() {
        if (instance == null) {
            instance = new ChessGame();
        }
        return instance;
    }

    public void start() {
        board.setUpBoard();
        board.displayBoard();
    }

    private boolean selectedPieceIsValid() {
        return currentPiece != null && currentPiece.getPlayer() == currentPlayer;
    }

    private void askUserToPlayAgain(String message) {
        int playAgain = JOptionPane.showConfirmDialog(
                board.getParent(),
                message + " Do you want to play again?",
                "Game over",
                JOptionPane.YES_NO_OPTION
        );
        if (playAgain == JOptionPane.YES_OPTION) {
            board.resetBoard();
            start();
        } else {
            System.exit(0);
        }
    }

    private void checkGameConditions() {
        int origPlayer = currentPlayer;
        for (int i = 0; i < 2; i++) {
            int gameLostRetVal = determineGameLost();
            if (gameLostRetVal < 0) {
                askUserToPlayAgain("Game over - STALEMATE. You should both go"
                        + " cry in a corner!");
                return;
            } else if (gameLostRetVal > 0) {
                askUserToPlayAgain("Game over - CHECKMATE. " + "Player "
                        + gameLostRetVal + " loses and should go"
                        + " cry in a corner!");
                return;
            } else if (board.isKingInCheck(currentPlayer)) {
                JOptionPane.showMessageDialog(
                        board.getParent(),
                        "Be careful player " + currentPlayer + ", " +
                                "your king is in check! Your next move must get " +
                                "him out of check or you're screwed.",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
            }
            currentPlayer = currentPlayer == 1 ? 2 : 1;
        }
        currentPlayer = origPlayer;
        nextTurn();
    }

    private int determineGameLost() {
        if (board.isKingChecked(currentPlayer) && !board.playerHasLegalMoves(currentPlayer)) {
            return currentPlayer;
        }
        if ((board.getAllWhitePieces().size() == 1 && board.getAllBlackPieces().size() == 1) ||
                (!board.isKingChecked(1) && !board.playerHasLegalMoves(1)) ||
                (!board.isKingChecked(2) && !board.playerHasLegalMoves(2))) {
            return -1;
        }
        return 0;
    }
