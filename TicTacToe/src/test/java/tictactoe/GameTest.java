/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package tictactoe;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
public class GameTest {
    
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    
    public GameTest() {
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
     * Test of play method, of class Game.
     */
    @Test
    public void testPlay() {
        System.out.println("play");
        TestUserInterface tui = new TestUserInterface(Board.CELL_X,8);
        Game instance = new Game(tui);
        
        System.setOut(new PrintStream(outputStreamCaptor));
        instance.play();
        System.setOut(originalOut);
        
        String expected = "È finita in parità. Il prossimo match sarà decisivo!\n";
        
        assertEquals(outputStreamCaptor.toString().equals(expected),true);
    }
    
}
