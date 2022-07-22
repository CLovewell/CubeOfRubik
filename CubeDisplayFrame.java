import javax.swing.Icon;
import java.awt.Component;
import java.awt.Graphics;


public class CubeDisplayFrame implements Icon{
  private int dimension;


  public CubeDisplayFrame(int cubieFaceSize){
  dimension = cubieFaceSize;
  }
  
  public int getIconHeight(){
    return dimension;
  }
  
  public int getIconWidth(){
    return dimension;
  }
  
  public void paintIcon(Component c, Graphics g, int x, int y){
  }
}