/*
Author: Kundan Kumar
About Author: Founder & CEO of Let's Code Bootcamp
Web: https://www.letscodebootcamp.com
Email: info@letscodebootcamp.com  or kundan.kumar011@gmail.com
Created on: 25/07/2019
 */
package games.board;
import java.awt.*;
import javax.swing.*;

// The JButton class. This action will ensure that each cell on 
// the board has the look and feel of a standard Java button.
public class Cell extends JButton
{
    private Mark content; //content of this cell of type Mark. To Take a value of Mark.EMPTY, Mark.CROSS, or Mark.NOUGHT
    private int row,column; // row and column of this cell
   
    /** Constructor to initialize this cell */
    public Cell(int row, int column)  
    {
        this.row=row;
       this.column=column;
       content=Mark.EMPTY;    //Clear the cell content to EMPTY
       
    }
    public Mark getContent()
    {
        return content;
    }
    public void setContent(Mark content)
    {
        this.content=content;
    }
    public int getRow()
    {
        return row;
    }
    public int getColumn()
    {
        return column;
    }
    
    //Override the paintComponent method in the Cell
    public void paintComponent(Graphics g) 
    {
        //paint the basic button first
        super.paintComponent(g);
        int offset = 5;
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5));
        switch(content) 
        {
            case NOUGHT:
                g2.setColor(Color.RED);  // Set Oval Color to red
                //Draw O
                g2.drawOval(offset, offset, this.getWidth() - offset * 2, this.getHeight() - offset * 2);
                break;

            case CROSS:
                g2.setColor(Color.BLACK);  // Set cross color to Black
                //Draw X
                g2.drawLine(offset, offset, this.getWidth() - offset , this.getHeight() - offset );
                g2.drawLine(this.getWidth() - offset, offset , offset, this.getHeight()- offset);
                break;
        }
    }
}
