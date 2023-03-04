//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.function.Executable;
//import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import static org.junit.Assert.*;


import java.util.ArrayList;



public class ChessGameBoardTest {




    @Test
    public void ResetBoardTest()
    {
        //setup
        ChessGameBoard testBoard = new ChessGameBoard();

        //apply method
        testBoard.resetBoard(false);

        //assert
        BoardSquare[][] chessCells = testBoard.getCells();

        for ( int i = 0; i < chessCells.length; i++ ) {
            for (int j = 0; j < chessCells[0].length; j++) {
                assertNotNull(testBoard.getCell(i, j));
                //not checking GUI related attributes (Background color + Mouse listener)
            }
        }

    }

    @Test
    public void InitializeBoardTest()
    {
        //setup
        ChessGameBoard testBoard = new ChessGameBoard();

        //apply method
            //initialize called in constructor

        //assert

        //NOTE:: assumes chess game board layout for 8x8 GameBoard
        BoardSquare[][] squares = testBoard.getCells();
        assertEquals(squares.length, 8);
        assertEquals(squares[0].length, 8);

        //Test Rooks placed correctly
        //White
        assertEquals(testBoard.getCell(0,0).getPieceOnSquare().getClass(), Rook.class);
        assertEquals(testBoard.getCell(0,7).getPieceOnSquare().getClass(), Rook.class);
        //Black
        assertEquals(testBoard.getCell(7,0).getPieceOnSquare().getClass(), Rook.class);
        assertEquals(testBoard.getCell(7,7).getPieceOnSquare().getClass(), Rook.class);

        //Test Knight placed correctly
        //White
        assertEquals(testBoard.getCell(0,1).getPieceOnSquare().getClass(), Knight.class);
        assertEquals(testBoard.getCell(0,6).getPieceOnSquare().getClass(), Knight.class);
        //Black
        assertEquals(testBoard.getCell(7,1).getPieceOnSquare().getClass(), Knight.class);
        assertEquals(testBoard.getCell(7,6).getPieceOnSquare().getClass(), Knight.class);

        //Test Bishop placed correctly
        //White
        assertEquals(testBoard.getCell(0,2).getPieceOnSquare().getClass(), Bishop.class);
        assertEquals(testBoard.getCell(0,5).getPieceOnSquare().getClass(), Bishop.class);
        //Black
        assertEquals(testBoard.getCell(7,2).getPieceOnSquare().getClass(), Bishop.class);
        assertEquals(testBoard.getCell(7,5).getPieceOnSquare().getClass(), Bishop.class);

        //Test King & Queen placed correctly
        //White
        assertEquals(testBoard.getCell(0,3).getPieceOnSquare().getClass(), King.class);
        assertEquals(testBoard.getCell(0,4).getPieceOnSquare().getClass(), Queen.class);
        //Black
        assertEquals(testBoard.getCell(7,3).getPieceOnSquare().getClass(), King.class);
        assertEquals(testBoard.getCell(7,4).getPieceOnSquare().getClass(), Queen.class);

        //Test Pawns placed correctly
        //White
        assertEquals(testBoard.getCell(1,0).getPieceOnSquare().getClass(), Pawn.class);
        assertEquals(testBoard.getCell(1,1).getPieceOnSquare().getClass(), Pawn.class);
        assertEquals(testBoard.getCell(1,2).getPieceOnSquare().getClass(), Pawn.class);
        assertEquals(testBoard.getCell(1,3).getPieceOnSquare().getClass(), Pawn.class);
        assertEquals(testBoard.getCell(1,4).getPieceOnSquare().getClass(), Pawn.class);
        assertEquals(testBoard.getCell(1,5).getPieceOnSquare().getClass(), Pawn.class);
        assertEquals(testBoard.getCell(1,6).getPieceOnSquare().getClass(), Pawn.class);
        assertEquals(testBoard.getCell(1,7).getPieceOnSquare().getClass(), Pawn.class);
        //Black
        assertEquals(testBoard.getCell(6,0).getPieceOnSquare().getClass(), Pawn.class);
        assertEquals(testBoard.getCell(6,1).getPieceOnSquare().getClass(), Pawn.class);
        assertEquals(testBoard.getCell(6,2).getPieceOnSquare().getClass(), Pawn.class);
        assertEquals(testBoard.getCell(6,3).getPieceOnSquare().getClass(), Pawn.class);
        assertEquals(testBoard.getCell(6,4).getPieceOnSquare().getClass(), Pawn.class);
        assertEquals(testBoard.getCell(6,5).getPieceOnSquare().getClass(), Pawn.class);
        assertEquals(testBoard.getCell(6,6).getPieceOnSquare().getClass(), Pawn.class);
        assertEquals(testBoard.getCell(6,7).getPieceOnSquare().getClass(), Pawn.class);
    }




    //@DisplayName("Validate Board Coordinates test")
    @Test
    public void InvalidCoordinatesTest()
    {
        //setup
        ChessGameBoard testBoard = new ChessGameBoard();

        //apply method

        //assert
        assertNull(testBoard.getCell(-1,0));//negative (preceding bounds)
        assertNull(testBoard.getCell(0,-1));//negative (preceding bounds)
        assertNull(testBoard.getCell(8,0));//exceeding bounds
        assertNull(testBoard.getCell(0,8));//exceeding bounds
    }
}
  




