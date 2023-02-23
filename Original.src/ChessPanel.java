import java.awt.*;
import javax.swing.*;

public class ChessPanelSingleton extends JPanel {

    private static ChessPanelSingleton instance;
    private ChessMenuBar menuBar;
    private ChessGameBoard gameBoard;
    private ChessGameLog gameLog;
    private ChessGraveyard playerOneGraveyard;
    private ChessGraveyard playerTwoGraveyard;
    private ChessGameEngine gameEngine;

    private ChessPanelSingleton() {
        this.setLayout(new BorderLayout());
        menuBar = new ChessMenuBar();
        this.add(menuBar, BorderLayout.NORTH);
        this.setPreferredSize(new Dimension(800, 600));
    }

    public static ChessPanelSingleton getInstance() {
        if (instance == null) {
            instance = new ChessPanelSingleton();
            instance.init();
        }
        return instance;
    }

    private void init() {
        gameBoard = new ChessGameBoard();
        gameLog = new ChessGameLog();
        playerOneGraveyard = new ChessGraveyard("Player 1's graveyard");
        playerTwoGraveyard = new ChessGraveyard("Player 2's graveyard");
        this.add(gameBoard, BorderLayout.CENTER);
        this.add(gameLog, BorderLayout.SOUTH);
        this.add(playerOneGraveyard, BorderLayout.WEST);
        this.add(playerTwoGraveyard, BorderLayout.EAST);
        gameEngine = new ChessGameEngine(gameBoard); // start the game
    }

    public ChessGameLog getGameLog() {
        if (gameLog == null) {
            gameLog = new ChessGameLog();
        }
        return gameLog;
    }

    public ChessGameBoard getGameBoard() {
        if (gameBoard == null) {
            gameBoard = new ChessGameBoard();
        }
        return gameBoard;
    }

    public ChessGameEngine getGameEngine() {
        if (gameEngine == null) {
            gameEngine = new ChessGameEngine(getGameBoard());
        }
        return gameEngine;
    }

    public ChessGraveyard getGraveyard(int whichPlayer) {
        if (whichPlayer == 1) {
            if (playerOneGraveyard == null) {
                playerOneGraveyard = new ChessGraveyard("Player 1's graveyard");
            }
            return playerOneGraveyard;
        } else if (whichPlayer == 2) {
            if (playerTwoGraveyard == null) {
                playerTwoGraveyard = new ChessGraveyard("Player 2's graveyard");
            }
            return playerTwoGraveyard;
       
}}}
