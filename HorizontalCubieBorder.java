import java.awt.Component;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.Icon;

/** This class represents some of the graphical elements of a
  * Rubik's Cube display, in particular the border lines
  * that run horizontally.
  */
public class HorizontalCubieBorder implements Icon{
  
  /** Create a new HorizontalCubieBorder object.
    */
  public HorizontalCubieBorder(){
  }
  
  /** Returns the height in pixels of a horizontal
    * border line.
    * @return the height
    */
  public int getIconHeight(){
    return CubePrinter.BORDER_THICKNESS;
  }
  
  /** Returns the width in pixels of a horizontal border
    * line, defined to be the width of a cubie face.
    * @return the width
    */
  public int getIconWidth(){
    return CubieFace.CUBIE_FACE_DIMENSION;
  }
  
  /** Paints this horizontal border line.
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
    g.fillRect(x, y, x + getIconWidth(), y + CubePrinter.BORDER_THICKNESS);
  }
}