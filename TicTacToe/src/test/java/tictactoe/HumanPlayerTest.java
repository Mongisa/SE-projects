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
public class HumanPlayerTest {
    
    public HumanPlayerTest() {
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
        UserInterface tui = new TestUserInterface(Board.CELL_X, 4);
        
        assertEquals(tui.askDifficultyLevel(8), 4);
        
        HumanPlayer hp = new HumanPlayer(Board.CELL_O, tui);
        assertEquals(hp.getMark(), Board.CELL_O);
        
        hp = new HumanPlayer(Board.CELL_X, tui);
        assertEquals(hp.getMark(), Board.CELL_X);
    }

    /**
     * Test of chooseMove method, of class HumanPlayer.
     */
    @Test
    public void testChooseMove() {
        System.out.println("chooseMove");
        Board board = new Board();
        TestUserInterface tui = new TestUserInterface(Board.CELL_X, 6);
        HumanPlayer hp = new HumanPlayer(tui.askMark(), tui);
        
        tui.setNextMove(2);
        hp.makeMove(board);
        
        board.applyMove(3);
        tui.setNextMove(4);
        hp.makeMove(board);
        for(int i=0;i<=8;i++) {
            int r = board.getCellContent(i);
            
            if(i==2 || i==4) {
                assertEquals(r,Board.CELL_X);
            } else if(i==3) {
                assertEquals(r,Board.CELL_O);
            } else {
                assertEquals(r,Board.CELL_NONE);
            }
        }
    }
    
}
