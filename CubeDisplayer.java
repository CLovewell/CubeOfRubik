import javax.swing.JFrame;
import javax.swing.BoxLayout;
import java.io.File;
import javax.swing.JTextField;

/**This class knows how to display a Rubik's Cube
  * on the screen. The style of display is to present
  * a two-dimensional image which uses perspective to
  * give the illusion of depth. Only three sides of
  * the cube are visible at any time.
  */
public class CubeDisplayer{
  //The Rubik's cube this cube printer will print
  private CubeOfRubik3 cube;
  //private CubeSolver solver;
  private File solution;
  private JFrame cubeDisplayFrame;
  //The thickness in pixels of border elements of the cube display
  public static final int BORDER_THICKNESS = 2;
  // A pop-up text window telling the user the filepath of the text
  // file to which a cube's solution is printed
  private static JFrame solutionPath;
  // A text field containing the filepath of the solution file
  private JTextField solutionFilepath;
  
  /** Create a new CubeDisplayer object.
   *  @param theCube the Rubik's Cube this cube printer will print
   */
  public CubeDisplayer(CubeOfRubik3 theCube){
    cube = theCube;
    //solver = new CubeSolver(cube);
    solution = new File("C:\\Users\\Carnahan\\Java Programs\\CubeOfRubik\\cubeSolution.txt");    
    solutionFilepath = new JTextField(solution.getPath());
    solutionPath = new JFrame("Solution File");
    solutionPath.getContentPane().setLayout(new BoxLayout(solutionPath.getContentPane(), BoxLayout.Y_AXIS));
    solutionPath.add(new JTextField("The solution you requested was printed to the file in the following location:"));
    solutionPath.add(solutionFilepath);
    solutionPath.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  }

  
  /** Displays a colored two dimensional representation of the
    * Rubik's Cube in a JFrame.
    * @param label the label displayed in the top banner of the JFrame
    */
  public void DisplayCube(String label){
    
}
}