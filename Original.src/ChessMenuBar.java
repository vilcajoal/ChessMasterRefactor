import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class ChessMenuBar extends JMenuBar {
    
    private static ChessMenuBar instance;
    
    private ChessMenuBar() {
        String[] menuCategories = { "File", "Options", "Help" };
        String[] menuItemLists =
        { "New game/restart,Exit", "Toggle graveyard,Toggle game log",
          "About" };
        for ( int i = 0; i < menuCategories.length; i++ ) {
            JMenu currMenu = new JMenu( menuCategories[i] );
            String[] currMenuItemList = menuItemLists[i].split( "," );
            for ( int j = 0; j < currMenuItemList.length; j++ ) {
                JMenuItem currItem = new JMenuItem( currMenuItemList[j] );
                currItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        String buttonName = ((JMenuItem) event.getSource()).getText();
                        switch (buttonName) {
                            case "About":
                                aboutHandler();
                                break;
                            case "New game/restart":
                                restartHandler();
                                break;
                            case "Toggle game log":
                                toggleGameLogHandler();
                                break;
                            case "Exit":
                                exitHandler();
                                break;
                            default:
                                toggleGraveyardsHandler();
                                break;
                        }
                    }
                });
                currMenu.add( currItem );
            }
            add( currMenu );
        }
    }
    
    public static ChessMenuBar getInstance() {
        if (instance == null) {
            instance = new ChessMenuBar();
        }
        return instance;
    }
    
    private void aboutHandler() {
        JOptionPane.showMessageDialog(
            getParent(),
            "YetAnotherChessGame v1.0 by:\nBen Katz\nMyles David\n"
                + "Danielle Bushrow\n\nFinal Project for CS2114 @ VT" );
    }
   
    private void restartHandler() {
        ((ChessPanel) getParent()).getGameEngine().reset();
    }
    
    private void exitHandler() {
        JOptionPane.showMessageDialog(getParent(), "Thanks for leaving, quitter! >:(");
        ChessPanel chessPanel = (ChessPanel) getParent();
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(chessPanel);
        frame.setVisible(false);
        frame.dispose();
    }}
