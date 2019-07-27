/*
Author: Kundan Kumar
About Author: Founder & CEO of Let's Code Bootcamp
Web: https://www.letscodebootcamp.com
Email: info@letscodebootcamp.com  or kundan.kumar011@gmail.com
Created on: 05/02/2017
 */
package games.board;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * The Board class models the game-board.
 */
public class Board extends JPanel
{
    // package access
    private Cell[][] cells; //a board composes of ROWS-by-COLS Cell instances
    private Outcome oc;
    private int TotalturnCounter;
    /** Constructor to initialize the game board */
    public Board(int rows,int columns, ActionListener ah)
    {
        cells =new Cell[rows][columns];   // allocate the array
        this.setLayout(new GridLayout(3,0));
        for(int r=0;r<cells.length;r++)
        {
            for(int c=0;c<cells[r].length;c++)
            {
                cells[r][c]=new Cell(r,c);  // allocate element of the array
                this.add(cells[r][c]);
                cells[r][c].addActionListener(ah);
            }
        }
    }
    /** Return true if it is a draw (i.e., no more EMPTY cell) */
    public void setCell(Mark mark,int row,int column) throws IllegalArgumentException
    {
        if (cells[row][column].getContent()==Mark.EMPTY) {
            cells[row][column].setContent(mark);   // an empty seed found, not a draw, exit
           // This counter is used to check if counter reaches to 9 and none of above condition met mean there is tie
            TotalturnCounter++;
        }else
            throw new IllegalArgumentException("Player already there!");  // no empty cell, it's a draw
    }
    public Cell getCell(int row,int column)
    {
        return cells[row][column];
    }

    public String toString()
    {
        StringBuilder str=new StringBuilder();

        for(int r=0;r<cells.length;r++)
        {
            str.append("|");
            for(int c=0;c<cells[r].length;c++)
            {
                switch(cells[r][c].getContent())
                {
                    case NOUGHT:
                        str.append("O");
                        break;
                    case CROSS:
                        str.append("X");
                        break;
                    case YELLOW:
                        str.append("Y");
                        break;
                    case RED:
                        str.append("R");
                        break;
                    case BLUE:
                        str.append("B");
                        break;
                    case GREEN:
                        str.append("G");
                        break;
                    case MAGENTA:
                        str.append("M");
                        break;
                    case ORANGE:
                        str.append("M");
                        break;
                    default:
                        //empty
                        str.append(" ");
                }
                str.append("|");
            }
            str.append("\n");
        }
        return str.toString();
    }
    public  Outcome getOutcome()
    {
        //Determine whether CROSS (X) or NOUGHT (O) won or there is a tie
        /*************** Starts NOUGHT Checking to win***********************/
        // Checking Rows wise to win NOUGHT
        if(cells[0][0].getContent()==Mark.NOUGHT && cells[0][1].getContent()==Mark.NOUGHT && cells[0][2].getContent()==Mark.NOUGHT )
            return oc.PLAYER1_WIN;
        if(cells[1][0].getContent()==Mark.NOUGHT && cells[1][1].getContent()==Mark.NOUGHT && cells[1][2].getContent()==Mark.NOUGHT )
            return oc.PLAYER1_WIN;
        if(cells[2][0].getContent()==Mark.NOUGHT && cells[2][1].getContent()==Mark.NOUGHT && cells[2][2].getContent()==Mark.NOUGHT )
            return oc.PLAYER1_WIN;
        // Checking Colums wise to win NOUGHT
        if(cells[0][0].getContent()==Mark.NOUGHT && cells[1][0].getContent()==Mark.NOUGHT && cells[2][0].getContent()==Mark.NOUGHT )
            return oc.PLAYER1_WIN;
        if(cells[0][1].getContent()==Mark.NOUGHT && cells[1][1].getContent()==Mark.NOUGHT && cells[2][1].getContent()==Mark.NOUGHT )
            return oc.PLAYER1_WIN;
        if(cells[0][2].getContent()==Mark.NOUGHT && cells[1][2].getContent()==Mark.NOUGHT && cells[2][2].getContent()==Mark.NOUGHT )
            return oc.PLAYER1_WIN;
        // Checking diagonal wise to win NOUGHT
        if(cells[0][0].getContent()==Mark.NOUGHT && cells[1][1].getContent()==Mark.NOUGHT && cells[2][2].getContent()==Mark.NOUGHT )
            return oc.PLAYER1_WIN;
        if(cells[0][2].getContent()==Mark.NOUGHT && cells[1][1].getContent()==Mark.NOUGHT && cells[2][0].getContent()==Mark.NOUGHT )
            return oc.PLAYER1_WIN;
        /*************** Ends NOUGHT Checking to win***********************/
        /*************** Starts CROSS Checking to win***********************/
        // Checking Rows wise to win CROSS
        if(cells[0][0].getContent()==Mark.CROSS && cells[0][1].getContent()==Mark.CROSS && cells[0][2].getContent()==Mark.CROSS )
            return oc.PLAYER2_WIN;
        if(cells[1][0].getContent()==Mark.CROSS && cells[1][1].getContent()==Mark.CROSS && cells[1][2].getContent()==Mark.CROSS )
            return oc.PLAYER2_WIN;
        if(cells[2][0].getContent()==Mark.CROSS && cells[2][1].getContent()==Mark.CROSS && cells[2][2].getContent()==Mark.CROSS )
            return oc.PLAYER2_WIN;
        // Checking Colums wise to win CROSS
        if(cells[0][0].getContent()==Mark.CROSS && cells[1][0].getContent()==Mark.CROSS && cells[2][0].getContent()==Mark.CROSS )
            return oc.PLAYER2_WIN;
        if(cells[0][1].getContent()==Mark.CROSS && cells[1][1].getContent()==Mark.CROSS && cells[2][1].getContent()==Mark.CROSS )
            return oc.PLAYER2_WIN;
        if(cells[0][2].getContent()==Mark.CROSS && cells[1][2].getContent()==Mark.CROSS && cells[2][2].getContent()==Mark.CROSS )
            return oc.PLAYER2_WIN;
        // Checking diagonal wise to win CROSS
        if(cells[0][0].getContent()==Mark.CROSS && cells[1][1].getContent()==Mark.CROSS && cells[2][2].getContent()==Mark.CROSS )
            return oc.PLAYER2_WIN;
        if(cells[0][2].getContent()==Mark.CROSS && cells[1][1].getContent()==Mark.CROSS && cells[2][0].getContent()==Mark.CROSS )
            return oc.PLAYER2_WIN;
        /* ************** Ends CROSS Checking to win********************** */

        if(TotalturnCounter==9)
            return oc.TIE;

        return oc.CONTINUE;
    }
}

