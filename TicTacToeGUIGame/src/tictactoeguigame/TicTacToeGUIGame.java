/*
Author: Kundan Kumar
About Author: Founder & CEO of Let's Code Bootcamp
Web: https://www.letscodebootcamp.com
Email: info@letscodebootcamp.com  or kundan.kumar011@gmail.com
Created on: 05/02/2017
 */
package tictactoeguigame;
import games.board.*;
import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// JFrame will Ensure the Game is hosted in a Java window
public class TicTacToeGUIGame extends JFrame 
{
        private Board gb;
        private int turn;
        private  Outcome outcome; // i have created now
        private void takeTurn(Cell c) 
        {
            Mark curMark = (turn % 2 == 0)?Mark.NOUGHT : Mark.CROSS;
          try
          {
            gb.setCell(curMark,c.getRow(),c.getColumn());
            turn++;//Pass the trun on successful mark of cell on Board
          }
          catch(games.board.IllegalArgumentException iae)
          {
              //System.err.println(iae.getIllegalArgumentExceptionMessage());
              JOptionPane.showMessageDialog (this, iae.getIllegalArgumentExceptionMessage());
          }        
          outcome = gb.getOutcome();
            switch (outcome) 
            {
                case PLAYER1_WIN:
                    JOptionPane.showMessageDialog (this, "PLAYER 1 WIN.");
                    this.setVisible(false);
                    new TicTacToeGUIGame();
                    break;
                case PLAYER2_WIN:
                   JOptionPane.showMessageDialog (this, "PLAYER 2 WIN.");
                   this.setVisible(false);
                    new TicTacToeGUIGame();
                   break;
                case TIE:
                     JOptionPane.showMessageDialog (this,"TIE.");
                     this.setVisible(false);
                    new TicTacToeGUIGame();
                     break;
                case CONTINUE:
                {
                    //JOptionPane.showMessageDialog (this,"CONTINUE.");
                    break;
                }
            }
        } 
        private TicTacToeGUIGame() 
        {
            gb = new Board(3,3,new ActionListener()
            {
                public void actionPerformed(ActionEvent ae) 
                {
                    Cell c = (Cell) ae.getSource();
                    takeTurn(c);
                }
            });
            this.add(gb);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setTitle("TIC-TAC-TOE(https://www.letscodebootcamp.com [Kundan Kumar])");
            this.setSize(800, 800);

            // Get the size of the screen
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

            // Determine the new location of the window
            int w = this.getSize().width;
            int h = this.getSize().height;
            int x = (dim.width-w)/2;
            int y = (dim.height-h)/2;

            // Move the window to the center of screen
            this.setLocation(x, y);
            this.setVisible(true);                     
        }
        // method named getOutcome that returns an Outcome enumeration.
      
    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater( new Runnable () 
        {
            public void run() 
            { 
                new TicTacToeGUIGame(); 
            }
        }
        );
    } 
}
