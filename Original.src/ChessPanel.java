import java.awt.BorderLayout;

import javax.swing.JPanel;

public class ChessPanel extends JPanel implements Cloneable {
private ChessMenuBar menuBar;
private ChessGameBoard gameBoard;
private ChessGameLog gameLog;
private ChessGraveyard playerOneGraveyard;
private ChessGraveyard playerTwoGraveyard;
private ChessGameEngine gameEngine;
public ChessPanel() {
    this.setLayout(new BorderLayout());
    menuBar = new ChessMenuBar();
    gameBoard = new ChessGameBoard();
    gameLog = new ChessGameLog();
    playerOneGraveyard = new ChessGraveyard("Player 1's graveyard");
    playerTwoGraveyard = new ChessGraveyard("Player 2's graveyard");
    this.add(menuBar, BorderLayout.NORTH);
    this.add(gameBoard, BorderLayout.CENTER);
    this.add(gameLog, BorderLayout.SOUTH);
    this.add(playerOneGraveyard, BorderLayout.WEST);
    this.add(playerTwoGraveyard, BorderLayout.EAST);
    this.setPreferredSize(new Dimension(800, 600));
    gameEngine = new ChessGameEngine(gameBoard); // start the game
}

public ChessPanel(ChessPanel panel) {
    this.setLayout(new BorderLayout());
    this.menuBar = (ChessMenuBar) panel.menuBar.clone();
    this.gameBoard = (ChessGameBoard) panel.gameBoard.clone();
    this.gameLog = (ChessGameLog) panel.gameLog.clone();
    this.playerOneGraveyard = (ChessGraveyard) panel.playerOneGraveyard.clone();
    this.playerTwoGraveyard = (ChessGraveyard) panel.playerTwoGraveyard.clone();
    this.add(menuBar, BorderLayout.NORTH);
    this.add(gameBoard, BorderLayout.CENTER);
    this.add(gameLog, BorderLayout.SOUTH);
    this.add(playerOneGraveyard, BorderLayout.WEST);
    this.add(playerTwoGraveyard, BorderLayout.EAST);
    this.setPreferredSize(new Dimension(800, 600));
    gameEngine = new ChessGameEngine(gameBoard);
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
    if (whichPlayer == 1) {
        return playerOneGraveyard;
    } else if (whichPlayer == 2) {
        return playerTwoGraveyard;
    } else {
        return null;
    }
}

public ChessGameEngine getGameEngine() {
    return gameEngine;
}

@Override
protected Object clone() throws CloneNotSupportedException {
    return new ChessPanel(this);
}
}