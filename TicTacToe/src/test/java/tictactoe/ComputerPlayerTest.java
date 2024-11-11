/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package tictactoe;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mongisa
 */
public class ComputerPlayerTest {
    
    public ComputerPlayerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    /**
     * Test constructor
     */
    @Test
    public void testConstructor() {
        System.out.println("Test constructor");
        
        int mark = Board.CELL_O;
        ComputerPlayer cp = new ComputerPlayer(mark, 6);
        assertEquals(cp.getMark(), mark);
        
        mark = Board.CELL_X;
        cp = new ComputerPlayer(mark, 6);
        assertEquals(cp.getMark(), mark);
    }

    /**
     * Test of chooseMove method, of class ComputerPlayer.
     */
    @Test
    public void testChooseMove() {
        System.out.println("chooseMove");
        
        //Testing livello 0 - Mossa valida
        Board board = new Board();
        ComputerPlayer instance = new ComputerPlayer(Board.CELL_O, 0);
        boolean expResult = true;
        boolean result = board.isValidMove(instance.chooseMove(board));
        assertEquals(expResult, result);
        
        //Testing livello 1 - Vittoria immediata
        // X|O|X
        // X|O|
        //  |7|
        //Dovrebbe posizionare O in 7
        board = new Board();
        instance = new ComputerPlayer(Board.CELL_O, 1);
      
        board.applyMove(0); //X
        board.applyMove(1); //O
        board.applyMove(2); //X
        board.applyMove(4); //O
        board.applyMove(3); //X
        
        instance.makeMove(board);
        assertEquals(board.getCellContent(7), Board.CELL_O);
        
        //Testing livello 2 - Evita vittoria avversario
        // X|X|2
        //  |O|
        //  | |
        //Dovrebbe posizionare O in 2
        board = new Board();
        instance = new ComputerPlayer(Board.CELL_O, 2);
        
        board.applyMove(0);
        board.applyMove(4);
        board.applyMove(1);
        
        instance.makeMove(board);
        assertEquals(board.getCellContent(2), Board.CELL_O);
        
        //Testing livello 3 - Mossa che assicura vittoria
        // 0|1|X
        //  |X|O
        // O| |
        //Dovrebbe posizionare X in 0 o in 1
        board = new Board();
        instance = new ComputerPlayer(Board.CELL_X, 3);
        
        board.applyMove(2); //X
        board.applyMove(5); //O
        board.applyMove(4); //X
        board.applyMove(6); //O
        
        instance.makeMove(board);
        assertEquals(board.getCellContent(0)==Board.CELL_X || board.getCellContent(1)==Board.CELL_X, true);
    }
    
}
