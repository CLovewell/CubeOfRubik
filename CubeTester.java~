import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.JLabel;

public class CubeTester{    
  public static void main(String[] Args){
    //CubeCreator creator = new CubeCreator("Fill in the cube.");
    //creator.displayCubeCreator();
    JFrame window = new JFrame("test");
    CubeDisplayFrame scaffold = new CubeDisplayFrame(CubieFace.CUBIE_FACE_DIMENSION);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.getContentPane().setLayout(new BoxLayout(window.getContentPane(), BoxLayout.X_AXIS));
    Box scaffoldHolder = new Box(BoxLayout.Y_AXIS);
    JLabel pic = new JLabel(scaffold);
    scaffoldHolder.add(Box.createVerticalStrut(10));
    scaffoldHolder.add(pic);
    scaffoldHolder.add(Box.createVerticalStrut(10));
    window.getContentPane().add(Box.createHorizontalStrut(10));
    window.getContentPane().add(scaffoldHolder);
    window.getContentPane().add(Box.createHorizontalStrut(10));
    window.pack();
    window.setVisible(true);
  }
}