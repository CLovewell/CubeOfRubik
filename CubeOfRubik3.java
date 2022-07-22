import java.util.Random;
import java.io.PrintWriter;
/** A class to represent a 3x3x3 Rubik's Cube.
  */
public class CubeOfRubik3{
  
  /* We define here the terms 'cubicle' and 'cubie' and
   * aim to clarify the difference between them. A Rubik's
   * cube is a collection of 27 smaller cubes arranged in
   * a 3x3x3 grid. Of these, 26 are on the surface of the
   * overall cube and visible to the cuber. These are called
   * cubies. They consist of twelve edge cubies, eight corner
   * cubies, and six center cubies. Edge cubies have two
   * visible faces, corner cubies have three, and center cubies
   * have one. Hence the cube has a total of
   * 12*2 + 8*3 + 6*1 = 54 cubie faces.
   * A cubicle is not a physical object, but a location in
   * the cube in which a physical cubie may reside. There is
   * one cubicle for every cubie. When the cuber performs a
   * move on the cube, she moves cubies, but she does not
   * move cubicles. In fact, she moves cubies from one
   * cubicle to another. For example, there is a cubicle
   * called 'fur' which designates the location in the
   * corner of the cube where the front face, right face,
   * and top face intersect. The cubicle corresponding to
   * the corner where the front face, top face, and left
   * face intersect is called 'flu'. When the front face
   * of the cube is rotated clockwise (a move called 'F'),
   * the cubie in the cubicle flu is moved to the cubicle
   * fur. For reference, the names of each cubicle are
   * displayed in the diagram of an unfolded cube below.
   *                 ____ ____ ____
   *                |ulb |ub  |ubr |
   *                |____|____|____| 
   *                |ul  |u   |ur  |
   *                |____|____|____|
   *                |flu |fu  |fur |
   *  ____ ____ ____|____|____|____|____ ____ ____ ____ ____ ____
   * |ulb |ul  |flu |flu |fu  |fur |fur |ur  |ubr |ubr |ub  |ulb |
   * |____|____|____|____|____|____|____|____|____|____|____|____|
   * |bl  |l   |fl  |fl  |f   |fr  |fr  |r   |rb  |rb  |b   |bl  |
   * |____|____|____|____|____|____|____|____|____|____|____|____|
   * |bld |dl  |fdl |fdl |fd  |frd |frd |rd  |rbd |rbd |bd  |bld |
   * |____|____|____|____|____|____|____|____|____|____|____|____|
   *                |fdl |fd  |frd |
   *                |____|____|____|
   *                |dl  |d   |rd  |
   *                |____|____|____|
   *                |bld |bd  |rbd |
   *                |____|____|____|
   */
  
    /** Objects of this class represent corner cubies
     * of the Rubik's cube.
     */
private class CornerCubie{
  //The three cubie faces in this corner cubie
  private CubieFace[] faces = new CubieFace[3];  
  
  /** Creates a new corner cubie from an ordered list of
    * three cubie faces.
    * @param cf1 the first cubie face
    * @param cf2 the second cubie face
    * @param cf3 the third cubie face
    */
  private CornerCubie(CubieFace cf1, CubieFace cf2, CubieFace cf3){
    faces[0] = cf1;
    faces[1] = cf2;
    faces[2] = cf3;
  }
  
  /** Returns the array of cubie faces in this corner cubie.
    * @return the array of cubie faces
    */
  private CubieFace[] getFaces(){
    return faces;
  }
}
    
  
  /** Objects of this class represent corner cubicles
   * of the Rubik's cube.
   */
public class CornerCubicle{
  //The name given to this corner cubicle
  private String name;
  //The corner cubie in this corner cubicle
  private CornerCubie cubie;
  
  /** Creates a corner cubicle, names it, and
    * places an initial corner cubie inside it.
    * @param cc the initial corner cubie in this corner cubicle
    * @param s this cubicle's name
    */
  private CornerCubicle(CornerCubie cc, String s){
    cubie = cc;
    name = s;
  }
  
  /** Returns the corner cubie in this corner cubicle.
    * @return the corner cubie
    */
  public CornerCubie getCubie(){
    return cubie;
  }
  
  /** Returns the name of this corner cubicle.
    * @return this corner cubicle's name
    */
  public String getName(){
    return name;
  }
  
  /** Changes the corner cubie in this corner cubicle.
    * @param cc the new corner cubie
    */
  private void setCubie(CornerCubie cc){
    cubie = cc;
  }
}

/** Objects of this class represent center cubies
  * of the Rubik's cube.
  */
private class CenterCubie{
  //The single cubie face in this center cubie,
  //stored in an array for consistency
  private CubieFace[] faces = new CubieFace[1];  
  
  /** Creates a new center cubie from a single cubie face.
    * @param cf the cubie face
    */
  private CenterCubie(CubieFace cf){
    faces[0] = cf;
  }
  
  /** Returns the array containing the cubie face
    * in this center cubie.
    * @return the array containing the cubie face
    */
  private CubieFace[] getFaces(){
    return faces;
  }
}

/** Objects of this class represent center cubicles
  * of the Rubik's cube.
  */
public class CenterCubicle{
  //The name given to this center cubicle
  private String name;
  //The center cubie located in this center cubicle
  private CenterCubie cubie;
  
  /** Creates a center cubicle, names it,
    * and places an initial center cubie inside it.
    * @param cc the initial center cubie
    * @param s this center cubicle's name
    */
  private CenterCubicle(CenterCubie cc, String s){
    cubie = cc;
    name = s;
  }
  
  /** Returns the center cubie in this center cubicle.
    * @return the center cubie
    */
  public CenterCubie getCubie(){
    return cubie;
  }
  
  /** Returns the name of this center cubicle.
    * @return this center cubicle's name
    */
  public String getName(){
    return name;
  }
  
  /** Changes the center cubie in this center cubicle.
    * @param cc the new center cubie
    */
  private void setCubie(CenterCubie cc){
    cubie = cc;
  }
}

/** Objects of this class represent edge cubicles
  * of the Rubik's cube.
  */
  public class EdgeCubicle{
  //The name given this cubicle
  private String name;
  //The edge cubie in this edge cubicle
  private EdgeCubie cubie;
  
  /** Creates an edge cubicle, names it, and places 
    * an initial edge cubie in it.
    * @param ec the initial edge cubie in this edge cubicle
    * @param s this cubicle's name
    */
  private EdgeCubicle(EdgeCubie ec, String s){
    cubie = ec;
    name = s;
  }
  
  /** Returns the edge cubie in this edge cubicle.
    * @return the edge cubie
    */
  public EdgeCubie getCubie(){
    return cubie;
  }
  
  /** Returns the name of this edge cubicle.
    * @return this edge cubicle's name
    */
  public String getName(){
    return name;
  }
  
  /** Changes the edge cubie in this edge cubicle.
    * @param ec the new edge cubie
    */
  private void setCubie(EdgeCubie ec){
    cubie = ec;
  }
}

  /** Objects of this class represent edge cubies
  * of the Rubik's cube.
  */
private class EdgeCubie{
  //The two cubie faces in this edge cubie
  private CubieFace[] faces = new CubieFace[2];
  
  /** Creates a new edge cubie from an ordered list of
    * two cubie faces.
    * @param cf1 the first cubie face
    * @param cf2 the second cubie face
    */
  private EdgeCubie(CubieFace cf1, CubieFace cf2){
    faces[0] = cf1;
    faces[1] = cf2;
  }
  
  /** Returns the array of cubie faces in this edge cubie.
    * @return the array of cubie faces
    */
  private CubieFace[] getFaces(){
    return faces;
  }
}
  
/* The twelve edge cubies of a Rubik's cube. Use precedence
   * WBRYGO to determine which cubie face comes first when declaring
   * edge cubies.
   */
  public final EdgeCubie EC1 = new EdgeCubie(CubieFace.W2, CubieFace.B8);
  public final EdgeCubie EC2 = new EdgeCubie(CubieFace.W6, CubieFace.R4);
  public final EdgeCubie EC3 = new EdgeCubie(CubieFace.W8, CubieFace.G2);
  public final EdgeCubie EC4 = new EdgeCubie(CubieFace.W4, CubieFace.O6);
  public final EdgeCubie EC5 = new EdgeCubie(CubieFace.B4, CubieFace.O2);
  public final EdgeCubie EC6 = new EdgeCubie(CubieFace.B6, CubieFace.R2);
  public final EdgeCubie EC7 = new EdgeCubie(CubieFace.R8, CubieFace.G6);
  public final EdgeCubie EC8 = new EdgeCubie(CubieFace.G4, CubieFace.O8);
  public final EdgeCubie EC9 = new EdgeCubie(CubieFace.B2, CubieFace.Y2);
  public final EdgeCubie EC10 = new EdgeCubie(CubieFace.R6, CubieFace.Y4);
  public final EdgeCubie EC11 = new EdgeCubie(CubieFace.Y8, CubieFace.G8);
  public final EdgeCubie EC12 = new EdgeCubie(CubieFace.Y6, CubieFace.O4);

//The six center (middle) cubies of a Rubik's cube.
  public final CenterCubie MC1 = new CenterCubie(CubieFace.W5);
  public final CenterCubie MC2 = new CenterCubie(CubieFace.B5);
  public final CenterCubie MC3 = new CenterCubie(CubieFace.R5);
  public final CenterCubie MC4 = new CenterCubie(CubieFace.Y5);
  public final CenterCubie MC5 = new CenterCubie(CubieFace.G5);
  public final CenterCubie MC6 = new CenterCubie(CubieFace.O5);  

/* The eight corner cubies of a Rubik's cube. Use precedence
   * WBRYGO to determine which cubie face comes first when
   * declaring corner cubies, then move clockwise to determine
   * the second and third faces.
   */
  public final CornerCubie CC1 = new CornerCubie(CubieFace.W3, CubieFace.B9, CubieFace.R1);
  public final CornerCubie CC2 = new CornerCubie(CubieFace.W9, CubieFace.R7, CubieFace.G3);
  public final CornerCubie CC3 = new CornerCubie(CubieFace.W7, CubieFace.G1, CubieFace.O9);
  public final CornerCubie CC4 = new CornerCubie(CubieFace.W1, CubieFace.O3, CubieFace.B7);
  public final CornerCubie CC5 = new CornerCubie(CubieFace.B3, CubieFace.Y1, CubieFace.R3);
  public final CornerCubie CC6 = new CornerCubie(CubieFace.R9, CubieFace.Y7, CubieFace.G9);
  public final CornerCubie CC7 = new CornerCubie(CubieFace.Y9, CubieFace.O7, CubieFace.G7);
  public final CornerCubie CC8 = new CornerCubie(CubieFace.B1, CubieFace.O1, CubieFace.Y3);

  //The twelve edge cubicles of this Rubik's cube
  private EdgeCubicle[] edges = new EdgeCubicle[12];
  //The eight corner cubicles of this Rubik's cube
  private CornerCubicle[] corners = new CornerCubicle[8];
  //The six center cubicles of this Rubik's cube
  private CenterCubicle[] centers = new CenterCubicle[6];
  
  /* This diagram shows the initial position of each cubie in the
   * Rubik's cube. The definitions of the cubies are provided in
   * the classes CenterCubie, EdgeCubie, and CornerCubie.
   * 
   *                 ____ ____ ____
   *                |CC8 |EC9 |CC5 |
   *                |____|____|____| 
   *                |EC5 |MC2 |EC6 |
   *                |____|____|____|
   *                |CC4 |EC1 |CC1 |
   *  ____ ____ ____|____|____|____|____ ____ ____ ____ ____ ____
   * |CC8 |EC5 |CC4 |CC4 |EC1 |CC1 |CC1 |EC6 |CC5 |CC5 |EC9 |CC8 |
   * |____|____|____|____|____|____|____|____|____|____|____|____|
   * |EC12|MC6 |EC4 |EC4 |MC1 |EC2 |EC2 |MC3 |EC10|EC10|MC4 |EC12|
   * |____|____|____|____|____|____|____|____|____|____|____|____|
   * |CC7 |EC8 |CC3 |CC3 |EC3 |CC2 |CC2 |EC7 |CC6 |CC6 |EC11|CC7 |
   * |____|____|____|____|____|____|____|____|____|____|____|____|
   *                |CC3 |EC3 |CC2 |
   *                |____|____|____|
   *                |EC8 |MC5 |EC7 |
   *                |____|____|____|
   *                |CC7 |EC11|CC6 |
   *                |____|____|____|
   */
  
  
  
  /** Creates a cube and initializes it to the solved 
    * position. By default, this method places the white
    * face of the cube into the front cubicles, the blue
    * face into the up cubicles, and the red face into
    * the right cubicles.
    */
  public CubeOfRubik3(){
    //Initialize the cubies in the center cubicles, and name the cubicles
    centers[0] = new CenterCubicle(MC1, "f");
    centers[1] = new CenterCubicle(MC2, "u");
    centers[2] = new CenterCubicle(MC3, "r");
    centers[3] = new CenterCubicle(MC4, "b");
    centers[4] = new CenterCubicle(MC5, "d");
    centers[5] = new CenterCubicle(MC6, "l");
    
    //Initialize the cubies in the edge cubicles, and name the cubicles
    edges[0] = new EdgeCubicle(EC1, "fu");
    edges[1] = new EdgeCubicle(EC2, "fr");
    edges[2] = new EdgeCubicle(EC3, "fd");
    edges[3] = new EdgeCubicle(EC4, "fl");
    edges[4] = new EdgeCubicle(EC5, "ul");
    edges[5] = new EdgeCubicle(EC6, "ur");
    edges[6] = new EdgeCubicle(EC7, "rd");
    edges[7] = new EdgeCubicle(EC8, "dl");
    edges[8] = new EdgeCubicle(EC9, "ub");
    edges[9] = new EdgeCubicle(EC10, "rb");
    edges[10] = new EdgeCubicle(EC11, "bd");
    edges[11] = new EdgeCubicle(EC12, "bl");
    
    //Initialize the cubies in the corner cubicles, and name the cubicles
    corners[0] = new CornerCubicle(CC1, "fur");
    corners[1] = new CornerCubicle(CC2, "frd");
    corners[2] = new CornerCubicle(CC3, "fdl");
    corners[3] = new CornerCubicle(CC4, "flu");
    corners[4] = new CornerCubicle(CC5, "ubr");
    corners[5] = new CornerCubicle(CC6, "rbd");
    corners[6] = new CornerCubicle(CC7, "bld");
    corners[7] = new CornerCubicle(CC8, "ulb");
  }
  
  /** Creates a new Rubik's Cube in a starting configuration
    * specified by the user.
    */
  public CubeOfRubik3(CubeColor f2, CubeColor u8,
                      CubeColor f6, CubeColor r4,
                      CubeColor f8, CubeColor d2,
                      CubeColor f4, CubeColor l6,
                      CubeColor u4, CubeColor l2,
                      CubeColor u6, CubeColor r2,
                      CubeColor r8, CubeColor d6,
                      CubeColor d4, CubeColor l8,
                      CubeColor u2, CubeColor b2,
                      CubeColor r6, CubeColor b4,
                      CubeColor b8, CubeColor d8,
                      CubeColor b6, CubeColor l4,
                      CubeColor f3, CubeColor u9, CubeColor r1,
                      CubeColor f9, CubeColor r7, CubeColor d3,
                      CubeColor f7, CubeColor d1, CubeColor l9,
                      CubeColor f1, CubeColor l3, CubeColor u7,
                      CubeColor u3, CubeColor b1, CubeColor r3,
                      CubeColor r9, CubeColor b7, CubeColor d9,
                      CubeColor b9, CubeColor l7, CubeColor d7,
                      CubeColor u1, CubeColor l1, CubeColor b3){
    
    centers[0] = new CenterCubicle(MC1, "f");
    centers[1] = new CenterCubicle(MC2, "u");
    centers[2] = new CenterCubicle(MC3, "r");
    centers[3] = new CenterCubicle(MC4, "b");
    centers[4] = new CenterCubicle(MC5, "d");
    centers[5] = new CenterCubicle(MC6, "l");
    
    edges[0] = new EdgeCubicle(cubieOfColors(f2, u8), "fu");
    edges[1] = new EdgeCubicle(cubieOfColors(f6, r4), "fr");
    edges[2] = new EdgeCubicle(cubieOfColors(f8, d2), "fd");
    edges[3] = new EdgeCubicle(cubieOfColors(f4, l6), "fl");
    edges[4] = new EdgeCubicle(cubieOfColors(u4, l2), "ul");
    edges[5] = new EdgeCubicle(cubieOfColors(u6, r2), "ur");
    edges[6] = new EdgeCubicle(cubieOfColors(r8, d6), "rd");
    edges[7] = new EdgeCubicle(cubieOfColors(d4, l8), "dl");
    edges[8] = new EdgeCubicle(cubieOfColors(u2, b2), "ub");
    edges[9] = new EdgeCubicle(cubieOfColors(r6, b4), "rb");
    edges[10] = new EdgeCubicle(cubieOfColors(b8, d8), "bd");
    edges[11] = new EdgeCubicle(cubieOfColors(b6, l4), "bl");
    
    corners[0] = new CornerCubicle(cubieOfColors(f3, u9, r1), "fur");
    corners[1] = new CornerCubicle(cubieOfColors(f9, r7, d3), "frd");
    corners[2] = new CornerCubicle(cubieOfColors(f7, d1, l9), "fdl");
    corners[3] = new CornerCubicle(cubieOfColors(f1, l3, u7), "flu");
    corners[4] = new CornerCubicle(cubieOfColors(u3, b1, r3), "ubr");
    corners[5] = new CornerCubicle(cubieOfColors(r9, b7, d9), "rbd");
    corners[6] = new CornerCubicle(cubieOfColors(b9, l7, d7), "bld");
    corners[7] = new CornerCubicle(cubieOfColors(u1, l1, b3), "ulb");    
    
    if (edges[0].getCubie().getFaces()[0].getColor() != f2.getColor()){
      flipCubie(edges[0].getCubie());
    }
    if (edges[1].getCubie().getFaces()[0].getColor() != f6.getColor()){
      flipCubie(edges[1].getCubie());
    }
    if (edges[2].getCubie().getFaces()[0].getColor() != f8.getColor()){
      flipCubie(edges[2].getCubie());
    }
    if (edges[3].getCubie().getFaces()[0].getColor() != f4.getColor()){
      flipCubie(edges[3].getCubie());
    }
    if (edges[4].getCubie().getFaces()[0].getColor() != u4.getColor()){
      flipCubie(edges[4].getCubie());
    }
    if (edges[5].getCubie().getFaces()[0].getColor() != u6.getColor()){
      flipCubie(edges[5].getCubie());
    }
    if (edges[6].getCubie().getFaces()[0].getColor() != r8.getColor()){
      flipCubie(edges[6].getCubie());
    }
    if (edges[7].getCubie().getFaces()[0].getColor() != d4.getColor()){
      flipCubie(edges[7].getCubie());
    }
    if (edges[8].getCubie().getFaces()[0].getColor() != u2.getColor()){
      flipCubie(edges[8].getCubie());
    }
    if (edges[9].getCubie().getFaces()[0].getColor() != r6.getColor()){
      flipCubie(edges[9].getCubie());
    }
    if (edges[10].getCubie().getFaces()[0].getColor() != b8.getColor()){
      flipCubie(edges[10].getCubie());
    }
    if (edges[11].getCubie().getFaces()[0].getColor() != b6.getColor()){
      flipCubie(edges[11].getCubie());
    }
    if (corners[0].getCubie().getFaces()[0].getColor() != f3.getColor()){
      if (corners[0].getCubie().getFaces()[0].getColor() != u9.getColor()){
        rotateCubieCounterclockwise(corners[0].getCubie());
      }
      else {
        rotateCubieClockwise(corners[0].getCubie());
      }
    }
    if (corners[1].getCubie().getFaces()[0].getColor() != f9.getColor()){
      if (corners[1].getCubie().getFaces()[0].getColor() != r7.getColor()){
        rotateCubieCounterclockwise(corners[1].getCubie());
      }
      else {
        rotateCubieClockwise(corners[1].getCubie());
      }
    }
    if (corners[2].getCubie().getFaces()[0].getColor() != f7.getColor()){
      if (corners[2].getCubie().getFaces()[0].getColor() != d1.getColor()){
        rotateCubieCounterclockwise(corners[2].getCubie());
      }
      else {
        rotateCubieClockwise(corners[2].getCubie());
      }
    }
    if (corners[3].getCubie().getFaces()[0].getColor() != f1.getColor()){
      if (corners[3].getCubie().getFaces()[0].getColor() != l3.getColor()){
        rotateCubieCounterclockwise(corners[3].getCubie());
      }
      else {
        rotateCubieClockwise(corners[3].getCubie());
      }
    }
    if (corners[4].getCubie().getFaces()[0].getColor() != u3.getColor()){
      if (corners[4].getCubie().getFaces()[0].getColor() != b1.getColor()){
        rotateCubieCounterclockwise(corners[4].getCubie());
      }
      else {
        rotateCubieClockwise(corners[4].getCubie());
      }
    }
    if (corners[5].getCubie().getFaces()[0].getColor() != r9.getColor()){
      if (corners[5].getCubie().getFaces()[0].getColor() != b7.getColor()){
        rotateCubieCounterclockwise(corners[5].getCubie());
      }
      else {
        rotateCubieClockwise(corners[5].getCubie());
      }
    }
    if (corners[6].getCubie().getFaces()[0].getColor() != b9.getColor()){
      if (corners[6].getCubie().getFaces()[0].getColor() != l7.getColor()){
        rotateCubieCounterclockwise(corners[6].getCubie());
      }
      else {
        rotateCubieClockwise(corners[6].getCubie());
      }
    }
    if (corners[7].getCubie().getFaces()[0].getColor() != u1.getColor()){
      if (corners[7].getCubie().getFaces()[0].getColor() != l1.getColor()){
        rotateCubieCounterclockwise(corners[7].getCubie());
      }
      else {
        rotateCubieClockwise(corners[7].getCubie());
      }
    }
  }
 
  /** Rotates the back face of the cube 90 degrees clockwise,
    * with clockwise defined by a viewer looking directly at
    * the back face. The method catalogs the move by printing
    * "B" to the file associated with the PrintWriter p.
    * @param p the PrintWriter to use to catalog this move
    */
  public void B(PrintWriter p){
    rotateEdges(edges[8], edges[11], edges[10], edges[9]);
    rotateCorners(corners[7], corners[6], corners[5], corners[4]);
    flipCubie(edges[11].getCubie());
    flipCubie(edges[9].getCubie());
    rotateCubieClockwise(corners[7].getCubie());
    rotateCubieClockwise(corners[6].getCubie());
    rotateCubieClockwise(corners[5].getCubie());
    p.println('B');
  }
  
  /** Rotates the down face of the cube 90 degrees clockwise,
    * with clockwise defined by a viewer looking directly at
    * the down face. The method catalogs the move by printing
    * "D" to the file associated with the PrintWriter p.
    * @param p the PrintWriter to use to catalog this move
    */
  public void D(PrintWriter p){
    rotateEdges(edges[2], edges[6], edges[10], edges[7]);
    rotateCorners(corners[2], corners[1], corners[5], corners[6]);
    flipCubie(edges[7].getCubie());
    flipCubie(edges[2].getCubie());
    rotateCubieCounterclockwise(corners[2].getCubie());
    rotateCubieClockwise(corners[1].getCubie());
    p.println('D');
  }
  
  /** Rotates the front face of the cube 90 degrees clockwise,
    * with clockwise defined by a viewer looking directly at
    * the front face. The method catalogs the move by printing
    * "F" to the file associated with the PrintWriter p.
    * @param p the PrintWriter to use to catalog this move
    */
  public void F(PrintWriter p){
    rotateEdges(edges[0], edges[1], edges[2], edges[3]);
    rotateCorners(corners[0], corners[1], corners[2], corners[3]);
    p.println('F');
  }
  
  /** Rotates the left face of the cube 90 degrees clockwise,
    * with clockwise defined by a viewer looking directly at
    * the left face. The method catalogs the move by printing
    * "L" to the file associated with the PrintWriter p.
    * @param p the PrintWriter to use to catalog this move
    */
  public void L(PrintWriter p){
    rotateEdges(edges[3], edges[7], edges[11], edges[4]);
    rotateCorners(corners[3], corners[2], corners[6], corners[7]);
    rotateCubieClockwise(corners[2].getCubie());
    rotateCubieCounterclockwise(corners[6].getCubie());
    p.println('L');
  }
  
  /** Rotates the right face of the cube 90 degrees clockwise,
    * with clockwise defined by a viewer looking directly at
    * the right face. The method catalogs the move by printing
    * "R" to the file associated with the PrintWriter p.
    * @param p the PrintWriter to use to catalog this move
    */
  public void R(PrintWriter p){
    rotateEdges(edges[1], edges[5], edges[9], edges[6]);
    rotateCorners(corners[0], corners[4], corners[5], corners[1]);
    flipCubie(edges[9].getCubie());
    flipCubie(edges[1].getCubie());
    rotateCubieClockwise(corners[5].getCubie());
    rotateCubieClockwise(corners[1].getCubie());
    rotateCubieClockwise(corners[0].getCubie());
    p.println('R');
  }
  
  /** Rotates the up face of the cube 90 degrees clockwise,
    * with clockwise defined by a viewer looking directly at
    * the up face. The method catalogs the move by printing
    * "U" to the file associated with the PrintWriter p.
    * @param p the PrintWriter to use to catalog this move
    */
  public void U(PrintWriter p){
    rotateEdges(edges[0], edges[4], edges[8], edges[5]);
    rotateCorners(corners[0], corners[3], corners[7], corners[4]);
    flipCubie(edges[4].getCubie());
    flipCubie(edges[0].getCubie());
    rotateCubieClockwise(corners[3].getCubie());
    rotateCubieClockwise(corners[7].getCubie());
    rotateCubieClockwise(corners[0].getCubie());
    p.println('U');
  }
  
  /** Rotates the back face of the cube 90 degrees counterclockwise,
    * with counterclockwise defined by a viewer looking directly at
    * the back face. The method catalogs the move by printing
    * "B inverse" to the file associated with the PrintWriter p.
    * @param p the PrintWriter to use to catalog this move
    */
  public void BInv(PrintWriter p){
    rotateEdges(edges[9], edges[10], edges[11], edges[8]);
    rotateCorners(corners[4], corners[5], corners[6], corners[7]);
    flipCubie(edges[10].getCubie());
    flipCubie(edges[8].getCubie());
    rotateCubieCounterclockwise(corners[4].getCubie());
    rotateCubieCounterclockwise(corners[6].getCubie());
    rotateCubieCounterclockwise(corners[7].getCubie());
    p.println("B inverse");
  }
  
  /** Rotates the down face of the cube 90 degrees counterclockwise,
    * with counterclockwise defined by a viewer looking directly at
    * the down face. The method catalogs the move by printing
    * "D inverse" to the file associated with the PrintWriter p.
    * @param p the PrintWriter to use to catalog this move
    */
  public void DInv(PrintWriter p){
    rotateEdges(edges[7], edges[10], edges[6], edges[2]);
    rotateCorners(corners[6], corners[5], corners[1], corners[2]);
    flipCubie(edges[7].getCubie());
    flipCubie(edges[10].getCubie());
    rotateCubieCounterclockwise(corners[2].getCubie());
    rotateCubieClockwise(corners[6].getCubie());
    p.println("D inverse");
  }
  
  /** Rotates the front face of the cube 90 degrees counterclockwise,
    * with counterclockwise defined by a viewer looking directly at
    * the front face. The method catalogs the move by printing
    * "F inverse" to the file associated with the PrintWriter p.
    * @param p the PrintWriter to use to catalog this move
    */
  public void FInv(PrintWriter p){
    rotateEdges(edges[3], edges[2], edges[1], edges[0]);
    rotateCorners(corners[3], corners[2], corners[1], corners[0]);
    p.println("F inverse");
  }
  
  /** Rotates the left face of the cube 90 degrees counterclockwise,
    * with counterclockwise defined by a viewer looking directly at
    * the left face. The method catalogs the move by printing
    * "L inverse" to the file associated with the PrintWriter p.
    * @param p the PrintWriter to use to catalog this move
    */
  public void LInv(PrintWriter p){
    rotateEdges(edges[4], edges[11], edges[7], edges[3]);
    rotateCorners(corners[7], corners[6], corners[2], corners[3]);
    rotateCubieClockwise(corners[2].getCubie());
    rotateCubieCounterclockwise(corners[3].getCubie());
    p.println("L inverse");
  }
  
  /** Rotates the right face of the cube 90 degrees counterclockwise,
    * with counterclockwise defined by a viewer looking directly at
    * the right face. The method catalogs the move by printing
    * "R inverse" to the file associated with the PrintWriter p.
    * @param p the PrintWriter to use to catalog this move
    */
  public void RInv(PrintWriter p){
    rotateEdges(edges[6], edges[9], edges[5], edges[1]);
    rotateCorners(corners[1], corners[5], corners[4], corners[0]);
    flipCubie(edges[6].getCubie());
    flipCubie(edges[5].getCubie());
    rotateCubieCounterclockwise(corners[5].getCubie());
    rotateCubieCounterclockwise(corners[1].getCubie());
    rotateCubieCounterclockwise(corners[4].getCubie());
    p.println("R inverse");
  }
  
  /** Rotates the up face of the cube 90 degrees counterclockwise,
    * with counterclockwise defined by a viewer looking directly at
    * the up face. The method catalogs the move by printing
    * "U inverse" to the file associated with the PrintWriter p.
    * @param p the PrintWriter to use to catalog this move
    */
  public void UInv(PrintWriter p){
    rotateEdges(edges[5], edges[8], edges[4], edges[0]);
    rotateCorners(corners[4], corners[7], corners[3], corners[0]);
    flipCubie(edges[5].getCubie());
    flipCubie(edges[0].getCubie());
    rotateCubieCounterclockwise(corners[3].getCubie());
    rotateCubieCounterclockwise(corners[4].getCubie());
    rotateCubieCounterclockwise(corners[0].getCubie());
    p.println("U inverse");
  }
  
  /** Rotates the entire cube clockwise about the x axis,
    * where the x axis runs through the faces front and back,
    * with front being in the positive direction, and clockwise
    * is defined from the direction of the positive x axis.
    * The method catalogs the pseudomove by printing
    * "X" to the file associated with the PrintWriter p.
    * @param p the PrintWriter to use to catalog this move
    */
  public void X(PrintWriter p){
    FNoPrinting();
    BInvNoPrinting();
    cX();
    p.println('X');
  }
  
  /** Rotates the entire cube counterclockwise about the x axis,
    * where the x axis runs through the faces front and back,
    * with front being in the positive direction, and counterclockwise
    * is defined from the direction of the positive x axis.
    * The method catalogs the pseudomove by printing
    * "X inverse" to the file associated with the PrintWriter p.
    * @param p the PrintWriter to use to catalog this move
    */
  public void XInv(PrintWriter p){
    FInvNoPrinting();
    BNoPrinting();
    cXInv();
    p.println("X inverse");
  }
  
  /** Rotates the entire cube clockwise about the y axis,
    * where the y axis runs through the faces right and left,
    * with right being in the positive direction, and clockwise
    * is defined from the direction of the positive y axis.
    * The method catalogs the pseudomove by printing
    * "Y" to the file associated with the PrintWriter p.
    * @param p the PrintWriter to use to catalog this move
    */
  public void Y(PrintWriter p){
    RNoPrinting();
    LInvNoPrinting();
    cY();
    p.println('Y');
  }
  
  /** Rotates the entire cube counterclockwise about the y axis,
    * where the y axis runs through the faces right and left,
    * with right being in the positive direction, and counterclockwise
    * is defined from the direction of the positive y axis.
    * The method catalogs the pseudomove by printing
    * "Y inverse" to the file associated with the PrintWriter p.
    * @param p the PrintWriter to use to catalog this move
    */
  public void YInv(PrintWriter p){
    RInvNoPrinting();
    LNoPrinting();
    cYInv();
    p.println("Y inverse");
  }
  
  /** Rotates the entire cube clockwise about the z axis,
    * where the z axis runs through the faces up and down,
    * with up being in the positive direction, and clockwise
    * is defined from the direction of the positive z axis.
    * The method catalogs the pseudomove by printing
    * "Z" to the file associated with the PrintWriter p.
    * @param p the PrintWriter to use to catalog this move
    */
  public void Z(PrintWriter p){
    UNoPrinting();
    DInvNoPrinting();
    cZ();
    p.println('Z');
  }
  
  /** Rotates the entire cube counterclockwise about the z axis,
    * where the z axis runs through the faces up and down,
    * with up being in the positive direction, and counterclockwise
    * is defined from the direction of the positive z axis.
    * The method catalogs the pseudomove by printing
    * "Z inverse" to the file associated with the PrintWriter p.
    * @param p the PrintWriter to use to catalog this move
    */
  public void ZInv(PrintWriter p){
    UInvNoPrinting();
    DNoPrinting();
    cZInv();
    p.println("Z inverse");
  }
  
  /** Returns the edge cubicle of this cube which contains
    * the given edge cubie.
    * @param cubie the edge cubie
    * @return the edge cubicle containing cubie
    */
  public EdgeCubicle findCubie(EdgeCubie cubie){
    int i = 0;
    try{
      while (edges[i].getCubie() != cubie){
        i++;
      }
    }
    catch(ArrayIndexOutOfBoundsException e){
      System.out.println("An edge cubie was sought in a cube which does not contain it.");
    }
    return edges[i];
  }
  
  /** Returns the corner cubicle of this cube which
    * contains the given corner cubie.
    * @param cubie the corner cubie
    * @return the corner cubicle containing cubie
    */
  public CornerCubicle findCubie(CornerCubie cubie){
    int i = 0;
    try{
      while (corners[i].getCubie() != cubie){
        i++;
      }
    }
    catch (ArrayIndexOutOfBoundsException e){
      System.out.println("A corner cubie was sought in a cube which does not contain it.");
    }
    return corners[i];
  }
  
  /** Returns the center cubicle of this cube which contains
    * the given center cubie.
    * @param cubie the center cubie
    * @return the center cubicle containing cubie
    */
  public CenterCubicle findCubie(CenterCubie cubie){
    int i = 0;
    try{
      while (centers[i].getCubie() != cubie){
        i++;
      }
    }
    catch(ArrayIndexOutOfBoundsException e){
      System.out.println("A center cubie was sought in a cube which does not contain it.");
    }
    return centers[i];
  }
  
  /** Permutes the edge cubies in four edge
    * cubicles in a manner corresponding to
    * the order in which the edge cubicles
    * are given.
    * @param ec1 the first edge cubicle
    * @param ec2 the second edge cubicle
    * @param ec3 the third edge cubicle
    * @param ec4 the fourth edge cubicle
    */
  private static void rotateEdges(EdgeCubicle ec1,
                                  EdgeCubicle ec2,
                                  EdgeCubicle ec3,
                                  EdgeCubicle ec4){
    EdgeCubie temp = ec1.getCubie();
    ec1.setCubie(ec4.getCubie());
    ec4.setCubie(ec3.getCubie());
    ec3.setCubie(ec2.getCubie());
    ec2.setCubie(temp);
  }
  
  /** Permutes the corner cubies in four corner
    * cubicles in a manner corresponding to the
    * order in which the corner cubicles are
    * given.
    * @param cc1 the first corner cubicle
    * @param cc2 the second corner cubicle
    * @param cc3 the third corner cubicle
    * @param cc4 the fourth corner cubicle
    */
  private static void rotateCorners(CornerCubicle cc1,
                                    CornerCubicle cc2,
                                    CornerCubicle cc3,
                                    CornerCubicle cc4){
    CornerCubie temp = cc1.getCubie();
    cc1.setCubie(cc4.getCubie());
    cc4.setCubie(cc3.getCubie());
    cc3.setCubie(cc2.getCubie());
    cc2.setCubie(temp);
  }
  
  /** Permutes the center cubies in four center
    * cubicles in a manner corresponding to the
    * order in which the center cubicles are
    * given.
    * @param cc1 the first center cubicle
    * @param cc2 the second center cubicle
    * @param cc3 the third center cubicle
    * @param cc4 the fourth center cubicle
    */
  private static void rotateCenters(CenterCubicle cc1,
                                    CenterCubicle cc2,
                                    CenterCubicle cc3,
                                    CenterCubicle cc4){
    CenterCubie temp = cc1.getCubie();
    cc1.setCubie(cc4.getCubie());
    cc4.setCubie(cc3.getCubie());
    cc3.setCubie(cc2.getCubie());
    cc2.setCubie(temp);
  }
  
  /** Rotates the center layer of the cube in the
    * yz plane clockwise 90 degrees about
    * the x axis, with clockwise as defined
    * from the direction of the positive x axis.
    */
  private void cX(){
    rotateEdges(edges[4], edges[5], edges[6], edges[7]);
    flipCubie(edges[5].getCubie());
    flipCubie(edges[4].getCubie());
    rotateCenters(centers[2], centers[4], centers[5], centers[1]);
  }
  
  /** Rotates the center layer of the cube in the
    * yz plane counterclockwise 90 degrees about
    * the x axis, with counterclockwise as defined
    * from the direction of the positive x axis.
    */
  private void cXInv(){
    rotateEdges(edges[7], edges[6], edges[5], edges[4]);
    flipCubie(edges[4].getCubie());
    flipCubie(edges[7].getCubie());
    rotateCenters(centers[1], centers[5], centers[4], centers[2]);
  }
  
  /** Rotates the center layer of the cube in the
    * xz plane clockwise 90 degrees about
    * the y axis, with clockwise as defined
    * from the direction of the positive y axis.
    */
  private void cY(){
    rotateEdges(edges[0], edges[8], edges[10], edges[2]);
    flipCubie(edges[0].getCubie());
    flipCubie(edges[2].getCubie());
    rotateCenters(centers[0], centers[1], centers[3], centers[4]);
  }
  
  /** Rotates the center layer of the cube in the
    * xz plane counterclockwise 90 degrees about
    * the y axis, with counterclockwise as defined
    * from the direction of the positive y axis.
    */
  private void cYInv(){
    rotateEdges(edges[2], edges[10], edges[8], edges[0]);
    flipCubie(edges[2].getCubie());
    flipCubie(edges[10].getCubie());
    rotateCenters(centers[4], centers[3], centers[1], centers[0]);
  }
  
  /** Rotates the center layer of the cube in the
    * xy plane clockwise 90 degrees about
    * the z axis, with clockwise as defined
    * from the direction of the positive z axis.
    */
  private void cZ(){
    rotateEdges(edges[1], edges[3], edges[11], edges[9]);
    flipCubie(edges[3].getCubie());
    flipCubie(edges[11].getCubie());
    rotateCenters(centers[0], centers[5], centers[3], centers[2]);
  }
  
  /** Rotates the center layer of the cube in the
    * xy plane counterclockwise 90 degrees about
    * the z axis, with counterclockwise as defined
    * from the direction of the positive z axis.
    */
  private void cZInv(){
    rotateEdges(edges[9], edges[11], edges[3], edges[1]);
    flipCubie(edges[1].getCubie());
    flipCubie(edges[3].getCubie());
    rotateCenters(centers[2], centers[3], centers[5], centers[0]);
  }
  
  /** Returns the array of center cubicles of this Rubik's cube.
    * @return the array of center cubicles
    */
  public CenterCubicle[] getCenters(){
    return centers;
  }
  
  /** Returns the array of edge cubicles of this Rubik's cube.
    * @return the array of edge cubicles
    */
  public EdgeCubicle[] getEdges(){
    return edges;
  }
  
  /** Returns the array of corner cubicles of this Rubik's cube.
    * @return the array of corner cubicles
    */
  public CornerCubicle[] getCorners(){
    return corners;
  }
  
  /** Rotates the back face of the cube 90 degrees clockwise,
    * with clockwise defined by a viewer looking directly at
    * the back face.
    */
  public void BNoPrinting(){
    rotateEdges(edges[8], edges[11], edges[10], edges[9]);
    rotateCorners(corners[7], corners[6], corners[5], corners[4]);
    flipCubie(edges[11].getCubie());
    flipCubie(edges[9].getCubie());
    rotateCubieClockwise(corners[7].getCubie());
    rotateCubieClockwise(corners[6].getCubie());
    rotateCubieClockwise(corners[5].getCubie());
  }
  
  /** Rotates the down face of the cube 90 degrees clockwise,
    * with clockwise defined by a viewer looking directly at
    * the down face.
    */
  public void DNoPrinting(){
    rotateEdges(edges[2], edges[6], edges[10], edges[7]);
    rotateCorners(corners[2], corners[1], corners[5], corners[6]);
    flipCubie(edges[7].getCubie());
    flipCubie(edges[2].getCubie());
    rotateCubieCounterclockwise(corners[2].getCubie());
    rotateCubieClockwise(corners[1].getCubie());
  }
  
  /** Rotates the front face of the cube 90 degrees clockwise,
    * with clockwise defined by a viewer looking directly at
    * the front face.
    */
  public void FNoPrinting(){
    rotateEdges(edges[0], edges[1], edges[2], edges[3]);
    rotateCorners(corners[0], corners[1], corners[2], corners[3]);
  }
  
  /** Rotates the left face of the cube 90 degrees clockwise,
    * with clockwise defined by a viewer looking directly at
    * the left face.
    */
  public void LNoPrinting(){
    rotateEdges(edges[3], edges[7], edges[11], edges[4]);
    rotateCorners(corners[3], corners[2], corners[6], corners[7]);
    rotateCubieClockwise(corners[2].getCubie());
    rotateCubieCounterclockwise(corners[6].getCubie());
  }
  
  /** Rotates the right face of the cube 90 degrees clockwise,
    * with clockwise defined by a viewer looking directly at
    * the right face.
    */
  public void RNoPrinting(){
    rotateEdges(edges[1], edges[5], edges[9], edges[6]);
    rotateCorners(corners[0], corners[4], corners[5], corners[1]);
    flipCubie(edges[9].getCubie());
    flipCubie(edges[1].getCubie());
    rotateCubieClockwise(corners[5].getCubie());
    rotateCubieClockwise(corners[1].getCubie());
    rotateCubieClockwise(corners[0].getCubie());
  }
  
  /** Rotates the up face of the cube 90 degrees clockwise,
    * with clockwise defined by a viewer looking directly at
    * the up face.
    */
  public void UNoPrinting(){
    rotateEdges(edges[0], edges[4], edges[8], edges[5]);
    rotateCorners(corners[0], corners[3], corners[7], corners[4]);
    flipCubie(edges[4].getCubie());
    flipCubie(edges[0].getCubie());
    rotateCubieClockwise(corners[3].getCubie());
    rotateCubieClockwise(corners[7].getCubie());
    rotateCubieClockwise(corners[0].getCubie());
  }
  
  /** Rotates the back face of the cube 90 degrees counterclockwise,
    * with counterclockwise defined by a viewer looking directly at
    * the back face.
    */
  public void BInvNoPrinting(){
    rotateEdges(edges[9], edges[10], edges[11], edges[8]);
    rotateCorners(corners[4], corners[5], corners[6], corners[7]);
    flipCubie(edges[10].getCubie());
    flipCubie(edges[8].getCubie());
    rotateCubieCounterclockwise(corners[4].getCubie());
    rotateCubieCounterclockwise(corners[6].getCubie());
    rotateCubieCounterclockwise(corners[7].getCubie());
  }
  
  /** Rotates the down face of the cube 90 degrees counterclockwise,
    * with counterclockwise defined by a viewer looking directly at
    * the down face.
    */
  public void DInvNoPrinting(){
    rotateEdges(edges[7], edges[10], edges[6], edges[2]);
    rotateCorners(corners[6], corners[5], corners[1], corners[2]);
    flipCubie(edges[7].getCubie());
    flipCubie(edges[10].getCubie());
    rotateCubieCounterclockwise(corners[2].getCubie());
    rotateCubieClockwise(corners[6].getCubie());
  }
  
  /** Rotates the front face of the cube 90 degrees counterclockwise,
    * with counterclockwise defined by a viewer looking directly at
    * the front face.
    */
  public void FInvNoPrinting(){
    rotateEdges(edges[3], edges[2], edges[1], edges[0]);
    rotateCorners(corners[3], corners[2], corners[1], corners[0]);
  }
  
  /** Rotates the left face of the cube 90 degrees counterclockwise,
    * with counterclockwise defined by a viewer looking directly at
    * the left face.
    */
  public void LInvNoPrinting(){
    rotateEdges(edges[4], edges[11], edges[7], edges[3]);
    rotateCorners(corners[7], corners[6], corners[2], corners[3]);
    rotateCubieClockwise(corners[2].getCubie());
    rotateCubieCounterclockwise(corners[3].getCubie());
  }
  
  /** Rotates the right face of the cube 90 degrees counterclockwise,
    * with counterclockwise defined by a viewer looking directly at
    * the right face.
    */
  public void RInvNoPrinting(){
    rotateEdges(edges[6], edges[9], edges[5], edges[1]);
    rotateCorners(corners[1], corners[5], corners[4], corners[0]);
    flipCubie(edges[6].getCubie());
    flipCubie(edges[5].getCubie());
    rotateCubieCounterclockwise(corners[5].getCubie());
    rotateCubieCounterclockwise(corners[1].getCubie());
    rotateCubieCounterclockwise(corners[4].getCubie());
  }
  
  /** Rotates the up face of the cube 90 degrees counterclockwise,
    * with counterclockwise defined by a viewer looking directly at
    * the up face.
    */
  public void UInvNoPrinting(){
    rotateEdges(edges[5], edges[8], edges[4], edges[0]);
    rotateCorners(corners[4], corners[7], corners[3], corners[0]);
    flipCubie(edges[5].getCubie());
    flipCubie(edges[0].getCubie());
    rotateCubieCounterclockwise(corners[3].getCubie());
    rotateCubieCounterclockwise(corners[4].getCubie());
    rotateCubieCounterclockwise(corners[0].getCubie());
  }
  
  public void XNoPrinting(){
    FNoPrinting();
    BInvNoPrinting();
    cX();
  }
  
  public void YNoPrinting(){
    RNoPrinting();
    LInvNoPrinting();
    cY();
  }
  
  public void ZNoPrinting(){
    UNoPrinting();
    DInvNoPrinting();
    cZ();
  }
  
  public void XInvNoPrinting(){
    FInvNoPrinting();
    BNoPrinting();
    cXInv();
  }
  
  public void YInvNoPrinting(){
    RInvNoPrinting();
    LNoPrinting();
    cYInv();
  }
  
  public void ZInvNoPrinting(){
    UInvNoPrinting();
    DNoPrinting();
    cZInv();
  }
    
  
  /** Scrambles this Rubik's cube with a sequence of randomly
    * chosen moves of length given by the parameter 'moves'.
    * @param moves the number of moves to use to scramble this cube
    * @param p the PrintWriter to use to catalog this scramble
    */
  public void scramble(int moves, PrintWriter p){
    Random chooser = new Random();
    int counter = 1;
    while (counter <= moves){
      int i = chooser.nextInt(12);
      if (i == 0){
        B(p);
      }
      if (i == 1){
        D(p);
      }
      if (i == 2){
        F(p);
      }
      if (i == 3){
        L(p);
      }
      if (i == 4){
        R(p);
      }
      if (i == 5){
        U(p);
      }
      if (i == 6){
        BInv(p);
      }
      if (i == 7){
        DInv(p);
      }
      if (i == 8){
        FInv(p);
      }
      if (i == 9){
        LInv(p);
      }
      if (i == 10){
        RInv(p);
      }
      if (i == 11){
        UInv(p);
      }
      counter++;
    }
  }
  
  /** Rotates the cubie faces in the given
    * corner cubie clockwise.
    * @param c the corner cubie to rotate
    */
  private static void rotateCubieClockwise(CornerCubie c){
    CubieFace temp = c.getFaces()[0];
    c.getFaces()[0] = c.getFaces()[2];
    c.getFaces()[2] = c.getFaces()[1];
    c.getFaces()[1] = temp;
  }
  
  /** Rotates the cubie faces in the given
    * corner cubie counterclockwise.
    * @param c the corner cubie to rotate
    */
  private static void rotateCubieCounterclockwise(CornerCubie c){
    CubieFace temp = c.getFaces()[0];
    c.getFaces()[0] = c.getFaces()[1];
    c.getFaces()[1] = c.getFaces()[2];
    c.getFaces()[2] = temp;
  }
  
  /** Swaps the positions in the array faces[]
    * of the given edge cubie's two cubie faces,
    * in effect flipping the cubie.
    * @param c the edge cubie to flip
    */
  private static void flipCubie(EdgeCubie c){
    CubieFace temp = c.getFaces()[0];
    c.getFaces()[0] = c.getFaces()[1];
    c.getFaces()[1] = temp;
  }
  
  /** Returns the corner cubie of the given colors.
    * @param c1 the first color
    * @param c2 the second color
    * @param c3 the third color
    * @return the corner cubie of these colors
    */
  public CornerCubie cubieOfColors(CubeColor c1,
                                          CubeColor c2,
                                          CubeColor c3){
    if (c1 == CubeColor.white && c2 == CubeColor.blue && c3 == CubeColor.red){
      return CC1;
    }
    else if (c1 == CubeColor.blue && c2 == CubeColor.red && c3 == CubeColor.white){
      return CC1;
    }
    else if (c1 == CubeColor.red && c2 == CubeColor.white && c3 == CubeColor.blue){
      return CC1;
    }
    else if (c1 == CubeColor.white && c2 == CubeColor.red && c3 == CubeColor.green){
      return CC2;
    }
    else if (c1 == CubeColor.red && c2 == CubeColor.green && c3 == CubeColor.white){
      return CC2;
    }
    else if (c1 == CubeColor.green && c2 == CubeColor.white && c3 == CubeColor.red){
      return CC2;
    }
    else if (c1 == CubeColor.white && c2 == CubeColor.green && c3 == CubeColor.orange){
      return CC3;
    }
    else if (c1 == CubeColor.green && c2 == CubeColor.orange && c3 == CubeColor.white){
      return CC3;
    }
    else if (c1 == CubeColor.orange && c2 == CubeColor.white && c3 == CubeColor.green){
      return CC3;
    }
    else if (c1 == CubeColor.white && c2 == CubeColor.orange && c3 == CubeColor.blue){
      return CC4;
    }
    else if (c1 == CubeColor.orange && c2 == CubeColor.blue && c3 == CubeColor.white){
      return CC4;
    }
    else if (c1 == CubeColor.blue && c2 == CubeColor.white && c3 == CubeColor.orange){
      return CC4;
    }
    else if (c1 == CubeColor.blue && c2 == CubeColor.yellow && c3 == CubeColor.red){
      return CC5;
    }
    else if (c1 == CubeColor.yellow && c2 == CubeColor.red && c3 == CubeColor.blue){
      return CC5;
    }
    else if (c1 == CubeColor.red && c2 == CubeColor.blue && c3 == CubeColor.yellow){
      return CC5;
    }
    else if (c1 == CubeColor.red && c2 == CubeColor.yellow && c3 == CubeColor.green){
      return CC6;
    }
    else if (c1 == CubeColor.yellow && c2 == CubeColor.green && c3 == CubeColor.red){
      return CC6;
    }
    else if (c1 == CubeColor.green && c2 == CubeColor.red && c3 == CubeColor.yellow){
      return CC6;
    }
    else if (c1 == CubeColor.yellow && c2 == CubeColor.orange && c3 == CubeColor.green){
      return CC7;
    }
    else if (c1 == CubeColor.orange && c2 == CubeColor.green && c3 == CubeColor.yellow){
      return CC7;
    }
    else if (c1 == CubeColor.green && c2 == CubeColor.yellow && c3 == CubeColor.orange){
      return CC7;
    }
    else if (c1 == CubeColor.blue && c2 == CubeColor.orange && c3 == CubeColor.yellow){
      return CC8;
    }
    else if (c1 == CubeColor.orange && c2 == CubeColor.yellow && c3 == CubeColor.blue){
      return CC8;
    }
    else if (c1 == CubeColor.yellow && c2 == CubeColor.blue && c3 == CubeColor.orange){
      return CC8;
    }
    else{
      System.out.println("An invalid corner cubie was sought.");
    }
    return null;
  }
  
  /** Returns the center cubie of the given color.
    * @param c the color
    * @return the center cubie of this color
    */
  public CenterCubie cubieOfColor(CubeColor c){
    if (c == CubeColor.white){
      return MC1;
    }
    else if (c == CubeColor.blue){
      return MC2;
    }
    else if (c == CubeColor.red){
      return MC3;
    }
    else if (c == CubeColor.yellow){
      return MC4;
    }
    else if (c == CubeColor.green){
      return MC5;
    }
    else if (c == CubeColor.orange){
      return MC6;
    }
    else System.out.println("An invalid center cubie was sought.");
    return null;
  }
  
  /** Returns the edge cubie of the given colors.
    * @param c1 the first color
    * @param c2 the second color
    * @return the edge cubie of these colors
    */
  public EdgeCubie cubieOfColors(CubeColor c1, CubeColor c2){
    if (c1 == CubeColor.white && c2 == CubeColor.blue){
      return EC1;
    }
    else if (c1 == CubeColor.blue && c2 == CubeColor.white){
      return EC1;
    }
    else if (c1 == CubeColor.white && c2 == CubeColor.red){
      return EC2;
    }
    else if (c1 == CubeColor.red && c2 == CubeColor.white){
      return EC2;
    }
    else if (c1 == CubeColor.white && c2 == CubeColor.green){
      return EC3;
    }
    else if (c1 == CubeColor.green && c2 == CubeColor.white){
      return EC3;
    }
    else if (c1 == CubeColor.white && c2 == CubeColor.orange){
      return EC4;
    }
    else if (c1 == CubeColor.orange && c2 == CubeColor.white){
      return EC4;
    }
    else if (c1 == CubeColor.blue && c2 == CubeColor.orange){
      return EC5;
    }
    else if (c1 == CubeColor.orange && c2 == CubeColor.blue){
      return EC5;
    }
    else if (c1 == CubeColor.blue && c2 == CubeColor.red){
      return EC6;
    }
    else if (c1 == CubeColor.red && c2 == CubeColor.blue){
      return EC6;
    }
    else if (c1 == CubeColor.red && c2 == CubeColor.green){
      return EC7;
    }
    else if (c1 == CubeColor.green && c2 == CubeColor.red){
      return EC7;
    }
    else if (c1 == CubeColor.green && c2 == CubeColor.orange){
      return EC8;
    }
    else if (c1 == CubeColor.orange && c2 == CubeColor.green){
      return EC8;
    }
    else if (c1 == CubeColor.blue && c2 == CubeColor.yellow){
      return EC9;
    }
    else if (c1 == CubeColor.yellow && c2 == CubeColor.blue){
      return EC9;
    }
    else if (c1 == CubeColor.red && c2 == CubeColor.yellow){
      return EC10;
    }
    else if (c1 == CubeColor.yellow && c2 == CubeColor.red){
      return EC10;
    }
    else if (c1 == CubeColor.yellow && c2 == CubeColor.green){
      return EC11;
    }
    else if (c1 == CubeColor.green && c2 == CubeColor.yellow){
      return EC11;
    }
    else if (c1 == CubeColor.yellow && c2 == CubeColor.orange){
      return EC12;
    }
    else if (c1 == CubeColor.orange && c2 == CubeColor.yellow){
      return EC12;
    }
    else{
      System.out.println("An invalid edge cubie was sought.");
      return null;
    }
  }
  
  /** Returns the cubie face residing in the given
    * face of the given corner cubicle of this cube.
    * @param cubicle the corner cubicle to query
    * @param face the face of the corner cubicle to query
    * @return the cubie face in the queried face of the queried corner cubicle
    */
  public CubieFace getCornerFace(int cubicle, int face){
    return getCorners()[cubicle].getCubie().getFaces()[face];
  }
  
  /** Returns the cubie face residing in the given
    * face of the given center cubicle of this cube.
    * @param cubicle the center cubicle to query
    * @return the cubie face in the queried center cubicle
    */
  public CubieFace getCenterFace(int cubicle){
    return getCenters()[cubicle].getCubie().getFaces()[0];
  }
  
  /** Returns the cubie face residing in the given
    * face of the given edge cubicle of this cube.
    * @param cubicle the edge cubicle to query
    * @param face the face of the edge cubicle to query
    * @return the cubie face in the queried face of the queried edge cubicle
    */
  public CubieFace getEdgeFace(int cubicle, int face){
    return getEdges()[cubicle].getCubie().getFaces()[face];
  }
  
  /** Prints a text diagram of this cube in its current
    * state to the console.
    */
  public void printCube(){
    System.out.println("                ____ ____ ____");
    System.out.println("               | "
                         + getCorners()[7].getCubie().getFaces()[0].toString()
                         + " | "
                         + getEdges()[8].getCubie().getFaces()[0].toString()
                         + " | "
                         + getCorners()[4].getCubie().getFaces()[0].toString()
                         + " |");
    System.out.println("               |____|____|____|");
    System.out.println("               | "
                         + getEdges()[4].getCubie().getFaces()[0].toString()
                         + " | "
                         + getCenters()[1].getCubie().getFaces()[0].toString()
                         + " | "
                         + getEdges()[5].getCubie().getFaces()[0].toString()
                         + " |");
    System.out.println("               |____|____|____|");
    System.out.println("               | "
                         + getCorners()[3].getCubie().getFaces()[2].toString()
                         + " | "
                         + getEdges()[0].getCubie().getFaces()[1].toString()
                         + " | "
                         + getCorners()[0].getCubie().getFaces()[1].toString()
                         + " |");
    System.out.println(" ____ ____ ____|____|____|____|____ ____ ____ ____ ____ ____");
    System.out.println("| "
                         + getCorners()[7].getCubie().getFaces()[1].toString()
                         + " | "
                         + getEdges()[4].getCubie().getFaces()[1].toString()
                         + " | "
                         + getCorners()[3].getCubie().getFaces()[1].toString()
                         + " | "
                         + getCorners()[3].getCubie().getFaces()[0].toString()
                         + " | "
                         + getEdges()[0].getCubie().getFaces()[0].toString()
                         + " | "
                         + getCorners()[0].getCubie().getFaces()[0].toString()
                         + " | "
                         + getCorners()[0].getCubie().getFaces()[2].toString()
                         + " | "
                         + getEdges()[5].getCubie().getFaces()[1].toString()
                         + " | "
                         + getCorners()[4].getCubie().getFaces()[2].toString()
                         + " | "
                         + getCorners()[4].getCubie().getFaces()[1].toString()
                         + " | "
                         + getEdges()[8].getCubie().getFaces()[1].toString()
                         + " | "
                         + getCorners()[7].getCubie().getFaces()[2].toString()
                         + " |");
    System.out.println("|____|____|____|____|____|____|____|____|____|____|____|____|");
    System.out.println("| "
                         + getEdges()[11].getCubie().getFaces()[1].toString()
                         + " | "
                         + getCenters()[5].getCubie().getFaces()[0].toString()
                         + " | "
                         + getEdges()[3].getCubie().getFaces()[1].toString()
                         + " | "
                         + getEdges()[3].getCubie().getFaces()[0].toString()
                         + " | "
                         + getCenters()[0].getCubie().getFaces()[0].toString()
                         + " | "
                         + getEdges()[1].getCubie().getFaces()[0].toString()
                         + " | "
                         + getEdges()[1].getCubie().getFaces()[1].toString()
                         + " | "
                         + getCenters()[2].getCubie().getFaces()[0].toString()
                         + " | "
                         + getEdges()[9].getCubie().getFaces()[0].toString()
                         + " | "
                         + getEdges()[9].getCubie().getFaces()[1].toString()
                         + " | "
                         + getCenters()[3].getCubie().getFaces()[0].toString()
                         + " | "
                         + getEdges()[11].getCubie().getFaces()[0].toString()
                         + " |");
    System.out.println("|____|____|____|____|____|____|____|____|____|____|____|____|");
    System.out.println("| "
                         + getCorners()[6].getCubie().getFaces()[1].toString()
                         + " | "
                         + getEdges()[7].getCubie().getFaces()[1].toString()
                         + " | "
                         + getCorners()[2].getCubie().getFaces()[2].toString()
                         + " | "
                         + getCorners()[2].getCubie().getFaces()[0].toString()
                         + " | "
                         + getEdges()[2].getCubie().getFaces()[0].toString()
                         + " | "
                         + getCorners()[1].getCubie().getFaces()[0].toString()
                         + " | "
                         + getCorners()[1].getCubie().getFaces()[1].toString()
                         + " | "
                         + getEdges()[6].getCubie().getFaces()[0].toString()
                         + " | "
                         + getCorners()[5].getCubie().getFaces()[0].toString()
                         + " | "
                         + getCorners()[5].getCubie().getFaces()[1].toString()
                         + " | "
                         + getEdges()[10].getCubie().getFaces()[0].toString()
                         + " | "
                         + getCorners()[6].getCubie().getFaces()[0].toString()
                         + " |");
    System.out.println("|____|____|____|____|____|____|____|____|____|____|____|____|");
    System.out.println("               | "
                         + getCorners()[2].getCubie().getFaces()[1].toString()
                         + " | "
                         + getEdges()[2].getCubie().getFaces()[1].toString()
                         + " | "
                         + getCorners()[1].getCubie().getFaces()[2].toString()
                         + " |");
    System.out.println("               |____|____|____|");
    System.out.println("               | "
                         + getEdges()[7].getCubie().getFaces()[0].toString()
                         + " | "
                         + getCenters()[4].getCubie().getFaces()[0].toString()
                         + " | "
                         + getEdges()[6].getCubie().getFaces()[1].toString()
                         + " |");
    System.out.println("               |____|____|____|"); 
    System.out.println("               | "
                         + getCorners()[6].getCubie().getFaces()[2].toString()
                         + " | "
                         + getEdges()[10].getCubie().getFaces()[1].toString()
                         + " | "
                         + getCorners()[5].getCubie().getFaces()[2].toString()
                         + " |");
    System.out.println("               |____|____|____|");
  }
}