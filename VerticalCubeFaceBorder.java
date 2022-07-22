import javax.swing.Icon;
import java.awt.Component;
import java.awt.Color;
import java.awt.Graphics;

/** This class represents some of the graphical elements of
  * a Rubik's Cube display, in particular the border lines
  * that run vertically.
  */
public class VerticalCubeFaceBorder implements Icon{
  
  //The height of this vertical border line
  private int height;
  
  /** Creates a new VerticalCubeFaceBorder object.
    * @param h the height of this vertical border
    */
  public VerticalCubeFaceBorder(int h){
    height = h;
  }
  
  /** Returns the height of this vertical border.
    * @return the height
    */
  public int getIconHeight(){
    return height;
  }
  
  /** Returns the width of this vertical border.
    * @return the width
    */
  public int getIconWidth(){
    return CubePrinter.BORDER_THICKNESS;
  }
  
  /** Paints this vertical border line.
    * @param c the component on which to paint
    * @param g the graphics context to perform the painting
    * @param x the x coordinate of the location at which to paint
    * @param y the y coordinate of the location at which to paint
    */
  public void paintIcon(Component c,
                        Graphics g,
                        int x,
                        int y){
    g.setColor(Color.BLACK);
    g.fillRect(x, y, x + CubePrinter.BORDER_THICKNESS, y + height);
  }
}