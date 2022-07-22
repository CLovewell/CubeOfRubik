import java.awt.Color;

/** A class to represent a color on a Rubik's cube.
  * An object of this class contains a color and
  * a list of four other colors which correspond
  * to the four colors on a cube which neighbor
  * the given color.
  */
public class CubeColor{
  //This object's color. One may think of this object as a
  //single face of the solved cube.
  private Color color;
  //The four colors of the neighboring objects (solved faces).
  private Color[] neighbors = new Color[4];
  
  /* These six arrays of Colors represent the neighboring
   * cube colors for each of the six colors on a Rubik's
   * cube.
   */
  public static final Color[] blueNeighbors =
    {Color.ORANGE, Color.YELLOW, Color.RED, Color.WHITE};  
  public static final Color[] greenNeighbors =
    {Color.ORANGE, Color.WHITE, Color.RED, Color.YELLOW};  
  public static final Color[] orangeNeighbors =
    {Color.BLUE, Color.WHITE, Color.GREEN, Color.YELLOW};
  public static final Color[] redNeighbors =
    {Color.BLUE, Color.YELLOW, Color.GREEN, Color.WHITE};  
  public static final Color[] whiteNeighbors =
    {Color.BLUE, Color.RED, Color.GREEN, Color.ORANGE};  
  public static final Color[] yellowNeighbors =
    {Color.BLUE, Color.ORANGE, Color.GREEN, Color.RED};
  
  /* The six colors of a Rubik's cube.
   */
  public static final CubeColor blue = new CubeColor(Color.BLUE, blueNeighbors);
  public static final CubeColor green = new CubeColor(Color.GREEN, greenNeighbors);
  public static final CubeColor orange = new CubeColor(Color.ORANGE, orangeNeighbors);
  public static final CubeColor red = new CubeColor(Color.RED, redNeighbors);
  public static final CubeColor white = new CubeColor(Color.WHITE, whiteNeighbors);
  public static final CubeColor yellow = new CubeColor(Color.YELLOW, yellowNeighbors);
  
  /* A constant array filled with the colors of a Rubik's
   * cube, stored as CubeColor objects.
   */
  public static final CubeColor[] cubeColors =
    {blue, green, orange, red, white, yellow};
  
  /** Creates a new CubeColor
    * @param colorParm this CubeColor's color
    * @param neighborsParm this CubeColor's neighbors' colors
    */
  private CubeColor(Color colorParm, Color[] neighborsParm){
    color = colorParm;
    for(int i=0; i<=3; i++){
      neighbors[i] = neighborsParm[i];
    }
  }
  
  /** Returns the index in this cube color's
    * array of neighbors of the given color. Returns
    * -1 if the given color does not neighbor this color.
    * @param c the neighboring color whose index is sought
    * @return the index of c in this.neighbors
    */
  public int getIndexOfNeighbor(CubeColor c){
    if (neighbors[0] == c.getColor()){
      return 0;
    }
    else if (neighbors[1] == c.getColor()){
      return 1;
    }
    else if (neighbors[2] == c.getColor()){
      return 2;
    }
    else if (neighbors[3] == c.getColor()){
      return 3;
    }
    else{
      System.out.println("The given color does not neighbor this color.");
      return -1;
    }
  }
  
  /** Returns the color of the opposite face of the Rubik's
    * cube of the given color.
    * @param color the color of the face whose opposite is sought
    * @return the color of the opposite face
    */
  public static CubeColor opposite(CubeColor color){
    if (color == blue){
      return green;
    }
    else if (color == green){
      return blue;
    }
    else if (color == red){
      return orange;
    }
    else if (color == orange){
      return red;
    }
    else if (color == white){
      return yellow;
    }
    else{
      return white;
    }
  }
  
  /** Returns the color of the calling CubeColor.
    * @return this CubeColor's color
    */
  public Color getColor(){
    return color; 
  }
  
  /** Returns the array containing the neighboring
    * colors of the calling CubeColor.
    * @return this CubeColor's neighbors' colors
    */
  public Color[] getNeighbors(){
    return neighbors; 
  }
  
  /** Returns a string representation of this CubeColor.
    * This method is intended for debugging purposes.
    * @return the string representation
    */
  public String toString(){
    String string1 = color.toString();
    String string2;
    if (color == Color.BLUE){
      string2 = "Blue";
    }
    else if (color == Color.GREEN){
      string2 = "Green";
    }
    else if (color == Color.ORANGE){
      string2 = "Orange";
    }
    else if (color == Color.RED){
      string2 = "Red";
    }
    else if (color == Color.WHITE){
      string2 = "White";
    }
    else if (color == Color.YELLOW){
      string2 = "Yellow";
    }
    else{
      string2 = "Not a valid cube color.";
    }
    return string1 + '\n' + string2;
  }
  
  /** Transforms a given Color into the
    * corresponding CubeColor.
    * @param c the given Color
    * @return the corresponding CubeColor
    */
  public static CubeColor getCubeColor(Color c){
    if (c == Color.BLUE){
      return CubeColor.blue; 
    }
    else if (c == Color.GREEN){
      return CubeColor.green; 
    }
    else if (c == Color.ORANGE){
      return CubeColor.orange; 
    }
    else if (c == Color.RED){
      return CubeColor.red; 
    }
    else if (c == Color.WHITE){
      return CubeColor.white; 
    }
    else if (c == Color.YELLOW){
      return CubeColor.yellow; 
    }
    else{
      return null; 
    }
  }
}