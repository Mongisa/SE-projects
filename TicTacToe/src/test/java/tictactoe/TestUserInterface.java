/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tictactoe;

/**
 * Test stub
 * @author mongisa
 */
public class TestUserInterface extends UserInterface {
    private final int mark;
    private final int difficultyLevel;
    private int nextMove;
    
    public TestUserInterface(int mark, int difficultyLevel) {
        this.mark = mark;
        this.difficultyLevel = difficultyLevel;
    }
    
    @Override
    public int askMark() {
        return this.mark;
    }
    
    @Override
    public int askDifficultyLevel(int maxLevel) {
        return this.difficultyLevel;
    }
    
    @Override
    public int askMove(Board board) {
        assert !board.isEnded();
        if(nextMove==0) {
            ComputerPlayer cp = new ComputerPlayer(this.mark, 8);
            return cp.chooseMove(board);
        } else return this.nextMove;
    }
    
    @Override
    public boolean askPlayAgain() {
        return false;
    }
    
    @Override
    public void showBoard(Board board) {
    }
    
    public void setNextMove(int move) {
        this.nextMove = move;
    }
}
