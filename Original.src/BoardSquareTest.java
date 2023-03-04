//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import javax.swing.*;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.Test;
import static org.junit.Assert.*;

public class BoardSquareTest {


    @Test
    public void getPieceOnSquareTest(){
        int expectedRow = 1;
        int expectedCol = 1;

        //setup
        ChessGameBoard chessBoard = new ChessGameBoard();
        Knight testKnight = new Knight(chessBoard, expectedRow, expectedCol, 1);
        BoardSquare testSquare = new BoardSquare(expectedRow, expectedCol, testKnight);

        //
        assertEquals(testSquare.getPieceOnSquare(), testKnight);
    }

    @Test
    public void setPieceOnSquareTest(){
        int expectedRow = 1;
        int expectedCol = 1;
        ChessGamePiece expectedGP = null;

        //setup
        BoardSquare testSquare = new BoardSquare(expectedRow, expectedCol, expectedGP);
        ChessGameBoard chessBoard = new ChessGameBoard();
        Knight testKnight = new Knight(chessBoard, expectedRow, expectedCol, 1);

        //
        testSquare.setPieceOnSquare(testKnight);

        //
        assertEquals(testSquare.getPieceOnSquare(), testKnight);

    }

    @Test
    public void clearSquareTest(){
        int expectedRow = 1;
        int expectedCol = 1;

        //setup
        ChessGameBoard chessBoard = new ChessGameBoard();
        Knight testKnight = new Knight(chessBoard, expectedRow, expectedCol, 1);
        BoardSquare testSquare = new BoardSquare(expectedRow, expectedCol, testKnight);

        //
        testSquare.clearSquare();

        //
        assertNull(testSquare.getPieceOnSquare());
    }
}