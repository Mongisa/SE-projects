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
public class BoardTest {
    
    public BoardTest() {
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
     * Test default constructor
     */
    @Test
    public void testDefaultConstructor() {
        System.out.println("Default constructor");
        Board instance = new Board();
        
        for(int i=0;i<=8;i++)
            assertEquals(instance.getCellContent(i), Board.CELL_NONE);
    }
    
    /**
     * Test copy constructor
     */
    @Test
    public void testCopyConstructor() {
        System.out.println("Copy Constructor");
        Board instance = new Board();
        
        instance.applyMove(0); //X
        instance.applyMove(5); //O
        instance.applyMove(1); //X
        
        Board copy = new Board(instance);
        
        for(int i=0;i<=8;i++) {
            assertEquals(instance.getCellContent(i), copy.getCellContent(i));
        }
        
        assertEquals(instance.getNextMark(), copy.getNextMark());
    }

    /**
     * Test of getNextMark method, of class Board.
     */
    @Test
    public void testGetNextMark() {
        System.out.println("getNextMark");
        Board instance = new Board();
        int expResult = Board.CELL_X;
        int result = instance.getNextMark();
        assertEquals(expResult, result);
        
        instance.applyMove(0);
        instance.applyMove(1);
        result = instance.getNextMark();
        
        assertEquals(expResult, result);
        
        instance.applyMove(8);
        expResult = Board.CELL_O;
        result = instance.getNextMark();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getCellContent method, of class Board.
     */
    @Test
    public void testGetCellContent() {
        System.out.println("getCellContent");
 
        Board instance = new Board();
        instance.applyMove(0); //X
        instance.applyMove(5); //O
        
        for(int i=0;i<=8;i++) {
            int result = instance.getCellContent(i);
            
            if(i==0) {
                assertEquals(result, Board.CELL_X);
            } else if(i==5) {
                assertEquals(result, Board.CELL_O);
            } else {
                assertEquals(result, Board.CELL_NONE);
            }
        }
    }

    /**
     * Test of isValidMove method, of class Board.
     */
    @Test
    public void testIsValidMove() {
        System.out.println("isValidMove");
        int move = 2;
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.isValidMove(move);
        assertEquals(expResult, result);
        instance.applyMove(move);
        result = instance.isValidMove(move);
        expResult = false;
        assertEquals(expResult, result);
    }

    /**
     * Test of applyMove method, of class Board.
     */
    @Test
    public void testApplyMove() {
        System.out.println("applyMove");
        int move = 0;
        Board instance = new Board();
        instance.applyMove(move);
        int expResult = Board.CELL_X;
        int result = instance.getCellContent(move);
        assertEquals(result, expResult);
    }

    /**
     * Test of isEnded method, of class Board.
     */
    @Test
    public void testIsEnded() {
        System.out.println("isEnded");
        Board instance = new Board();
        
        instance.applyMove(0);
        instance.applyMove(3);
        instance.applyMove(1);
        
        boolean expResult = false;
        boolean result = instance.isEnded();
        assertEquals(expResult, result);
        
        instance.applyMove(4);
        instance.applyMove(2);
        
        expResult = true;
        result = instance.isEnded();
        
        assertEquals(expResult, result);
        assertEquals(instance.getWinner(), Board.CELL_X);
    }

    /**
     * Test of getWinner method, of class Board.
     */
    @Test
    public void testGetWinner() {
        System.out.println("getWinner");
        Board instance = new Board();
        int expResult = Board.CELL_X;
        
        //Vittoria X
        instance.applyMove(0);
        instance.applyMove(3);
        instance.applyMove(1);
        instance.applyMove(4);
        instance.applyMove(2);
        
        int result = instance.getWinner();
        assertEquals(expResult, result);
        
        instance = new Board();
        
        //Pareggio
        instance.applyMove(0);
        instance.applyMove(1);
        instance.applyMove(2);
        instance.applyMove(3);
        instance.applyMove(5);
        instance.applyMove(4);
        instance.applyMove(6);
        instance.applyMove(8);
        instance.applyMove(7);
        
        expResult = Board.CELL_NONE;
        result = instance.getWinner();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getOpponentMark method, of class Board.
     */
    @Test
    public void testGetOpponentMark() {
        System.out.println("getOpponentMark");
        int mark = Board.CELL_X;
        int expResult = Board.CELL_O;
        int result = Board.getOpponentMark(mark);
        assertEquals(expResult, result);
        
        mark = Board.CELL_O;
        expResult = Board.CELL_X;
        result = Board.getOpponentMark(mark);
        assertEquals(expResult, result);
    }
    
}
