import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

public class ChessPanel extends JPanel implements Cloneable {
private static final int PLAYER_ONE = 1;
private static final int PLAYER_TWO = 2;

private ChessMenuBar menuBar;
private ChessGameBoard gameBoard;
private ChessGameLog gameLog;
private ChessGraveyard playerOneGraveyard;
private ChessGraveyard playerTwoGraveyard;
private ChessGameEngine gameEngine;

public ChessPanel(ChessMenuBar menuBar, ChessGameBoard gameBoard, ChessGameLog gameLog, ChessGraveyard playerOneGraveyard, ChessGraveyard playerTwoGraveyard) {
    this.menuBar = menuBar;
    this.gameBoard = gameBoard;
    this.gameLog = gameLog;
    this.playerOneGraveyard = playerOneGraveyard;
    this.playerTwoGraveyard = playerTwoGraveyard;
    initialize();
}

private void initialize() {
    this.setLayout(new BorderLayout());
    this.add(menuBar, BorderLayout.NORTH);
    this.add(gameBoard, BorderLayout.CENTER);
    this.add(gameLog, BorderLayout.SOUTH);
    this.add(playerOneGraveyard, BorderLayout.WEST);
    this.add(playerTwoGraveyard, BorderLayout.EAST);
    this.setPreferredSize(new Dimension(800, 600));
    gameEngine = new ChessGameEngine(gameBoard); // start the game
}

public ChessPanel(ChessPanel panel) {
    this(panel.menuBar, panel.gameBoard, panel.gameLog, panel.playerOneGraveyard, panel.playerTwoGraveyard);
}

public ChessMenuBar getMenuBar() {
    return menuBar;
}

public ChessGameBoard getGameBoard() {
    return gameBoard;
}

public ChessGameLog getGameLog() {
    return gameLog;
}

public ChessGraveyard getGraveyard(int whichPlayer) {
    switch (whichPlayer) {
        case PLAYER_ONE
