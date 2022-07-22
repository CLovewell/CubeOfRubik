import java.util.Random;
import java.awt.Color;
import java.io.PrintWriter;

/** This class knows how to solve a 3x3x3 Rubik's cube.
  */
public class CubeSolver{
  //The cube this cube solver will work on
  private CubeOfRubik3 cube;
  
  /** Constructs a new cube solver with the
    * given 3x3x3 Rubik's cube.
    * @param c the Rubik's cube
    */
  public CubeSolver(CubeOfRubik3 c){
    cube = c;
  }
  
  /** Solves the cube by the layer method.
    * @param p the PrintWriter to use to catalog the solution
    */
  public void layerSolve(PrintWriter p){
    solveThirdLayer(solveSecondLayer(solveFirstLayer(p), p), p);
    p.println("The Rubik's cube has been solved.");
  }
  
  /** Solves the first layer of the cube by the layer method.
    * @return the color of the first layer solved
    * @param p the PrintWriter to use to catalog the solution
    */
  private CubeColor solveFirstLayer(PrintWriter p){
    CubeColor side1 = chooseFirstSide();
    CubeColor side2 = chooseSecondSide(side1);
    CubeColor side3 = CubeColor.getCubeColor(side1.getNeighbors()[(side1.getIndexOfNeighbor(side2) + 1) % 4]);
    CubeColor side4 = CubeColor.getCubeColor(side1.getNeighbors()[(side1.getIndexOfNeighbor(side2) + 2) % 4]);
    CubeColor side5 = CubeColor.getCubeColor(side1.getNeighbors()[(side1.getIndexOfNeighbor(side2) + 3) % 4]);
    placeEdges(side1, side2, side3, side4, side5, p);
    placeCorners(side1, side2, side3, side4, side5, p);
    p.println("First layer solved.");
    return side1;
  }
  
  /** Solves the second layer of the cube by the layer method.
    * @param firstLayer the color of the first layer solved
    * @param p the PrintWriter to use to catalog the solution
    * @return the color of the first layer solved
    */
  private CubeColor solveSecondLayer(CubeColor firstLayer, PrintWriter p){
    Random chooser = new Random();
    int i = chooser.nextInt(4);
    CubeColor side1 = CubeColor.getCubeColor(firstLayer.getNeighbors()[i]);
    CubeColor side2 = CubeColor.getCubeColor(firstLayer.getNeighbors()[(i + 1) % 4]);
    CubeColor side3 = CubeColor.getCubeColor(firstLayer.getNeighbors()[(i + 2) % 4]);
    CubeColor side4 = CubeColor.getCubeColor(firstLayer.getNeighbors()[(i + 3) % 4]);
    placeFrontAndUp(side1, firstLayer, p);
    placeSecondLayerCubie(cube.findCubie(cube.cubieOfColors(side1, side2)), p);
    p.println("First edge cubie of second layer placed.");
    cube.ZInv(p);
    placeSecondLayerCubie(cube.findCubie(cube.cubieOfColors(side2, side3)), p);
    p.println("Second edge cubie of second layer placed.");
    cube.ZInv(p);
    placeSecondLayerCubie(cube.findCubie(cube.cubieOfColors(side3, side4)), p);
    p.println("Third edge cubie of second layer placed.");
    cube.ZInv(p);
    placeSecondLayerCubie(cube.findCubie(cube.cubieOfColors(side4, side1)), p);
    p.println("Fourth edge cubie of second layer placed.");
    p.println("Second layer solved.");
    return CubeColor.opposite(firstLayer);
  }
  
  /** Solves the third layer of the cube by the layer method.
    * @param firstLayer the color of the first layer solved
    * @param p the PrintWriter to use to catalog the solution
    */
  private void solveThirdLayer(CubeColor thirdLayer, PrintWriter p){
    Random chooser = new Random();
    int i = chooser.nextInt(4);
    placeFrontAndUp(CubeColor.getCubeColor(thirdLayer.getNeighbors()[i]), thirdLayer, p);
    makeCross(thirdLayer, p);
    placeThirdLayerCorners(p);
    orientThirdLayerCorners(p);
    placeThirdLayerEdges(p);
    p.println("Third layer solved.");
  }
  
  /** Places the edge cubies of the first layer of the cube
    * solved under the layer method into the correct positions.
    * @param side1 the color of the first layer solved
    * @param side2 a randomly chosen neighboring color of side1
    * @param side3 the color clockwise from side2, looking from side1
    * @param side4 the color opposite side2
    * @param side5 the color counterclockwise from side2, looking from side1
    * @param p the PrintWriter to use to catalog the solution
    */
  private void placeEdges(CubeColor side1, CubeColor side2, CubeColor side3,
                                          CubeColor side4, CubeColor side5,
                                          PrintWriter p){
    CubeOfRubik3.EdgeCubicle cubicle;
    placeFrontAndUp(side1, side2, p);
    cubicle = cube.findCubie(cube.cubieOfColors(side1, side2));
    placeFirstLayerEdge(cubicle, p);
    orientFirstLayerEdge(p);
    p.println("First edge cubie of first layer placed.");
    cube.XInv(p);
    cubicle = cube.findCubie(cube.cubieOfColors(side1, side3));
    placeFirstLayerEdge(cubicle, p);
    orientFirstLayerEdge(p);
    p.println("Second edge cubie of first layer placed.");
    cube.XInv(p);
    cubicle = cube.findCubie(cube.cubieOfColors(side1, side4));
    placeFirstLayerEdge(cubicle, p);
    orientFirstLayerEdge(p);
    p.println("Third edge cubie of first layer placed.");
    cube.XInv(p);
    cubicle = cube.findCubie(cube.cubieOfColors(side1, side5));
    placeFirstLayerEdge(cubicle, p);
    orientFirstLayerEdge(p);
    p.println("Fourth edge cubie of first layer placed.");
  }
  
  /** Places the cubie currently in the given
    * edge cubicle into the edge cubicle fu using
    * legal cube moves, and without disturbing the
    * cubies in cubicles fr, fd, and fl, unless one
    * of these cubicles contains the target cubie.
    * @param cubicle the edge cubicle containing the target cubie
    * @param p the PrintWriter to use to catalog the solution
    */
  private void placeFirstLayerEdge(CubeOfRubik3.EdgeCubicle cubicle, PrintWriter p){
    if (cubicle == cube.getEdges()[1]){
      cube.R(p);
      cube.U(p);
    }
    else if (cubicle == cube.getEdges()[2]){
      cube.D(p);
      cube.D(p);
      cube.B(p);
      cube.B(p);
      cube.U(p);
      cube.U(p);
    }
    else if (cubicle == cube.getEdges()[3]){
      cube.LInv(p);
      cube.UInv(p);
    }
    else if (cubicle == cube.getEdges()[4]){
      cube.UInv(p);
    }
    else if (cubicle == cube.getEdges()[5]){
      cube.U(p);
    }
    else if (cubicle == cube.getEdges()[6]){
      cube.D(p);
      cube.B(p);
      cube.B(p);
      cube.U(p);
      cube.U(p);
      cube.DInv(p);
    }
    else if (cubicle == cube.getEdges()[7]){
      cube.DInv(p);
      cube.B(p);
      cube.B(p);
      cube.U(p);
      cube.U(p);
      cube.D(p);
    }
    else if (cubicle == cube.getEdges()[8]){
      cube.U(p);
      cube.U(p);
    }
    else if (cubicle == cube.getEdges()[9]){
      cube.B(p);
      cube.U(p);
      cube.U(p);
    }
    else if (cubicle == cube.getEdges()[10]){
      cube.B(p);
      cube.B(p);
      cube.U(p);
      cube.U(p);
    }
    else if (cubicle == cube.getEdges()[11]){
      cube.BInv(p);
      cube.U(p);
      cube.U(p);
    }
  }
  
  /** Correctly orients the cubie in
    * cubicle fu using legal cube moves
    * and without disturbing the cubies
    * in cubicles fr, fd, and fl.
    * @param p the PrintWriter to use to catalog the solution
    */
  private void orientFirstLayerEdge(PrintWriter p){
    if (cube.getEdgeFace(0, 0).getColor()
          != cube.getCenterFace(0).getColor()){
      cube.UInv(p);
      cube.R(p);
      cube.B(p);
      cube.RInv(p);
      cube.U(p);
      cube.U(p);
    }
  }
  
  /** Places the corner cubies of the first layer of the cube
    * solved under the layer method into the correct positions
    * without disturbing the edge cubies of this layer.
    * @param side1 the color of the first layer solved
    * @param side2 a randomly chosen neighboring color of side1
    * @param side3 the color clockwise from side2, looking from side1
    * @param side4 the color opposite side2
    * @param side5 the color counterclockwise from side2, looking from side1
    * @param p the PrintWriter to use to catalog the solution
    */
  private void placeCorners(CubeColor side1, CubeColor side2, CubeColor side3,
                                CubeColor side4, CubeColor side5, PrintWriter p){
    CubeOfRubik3.CornerCubicle cubicle;
    placeFrontAndUp(side1, side2, p);
    cubicle = cube.findCubie(cube.cubieOfColors(side1, side2, side3));
    placeFirstLayerCorner(cubicle, p);
    orientFirstLayerCorner(p);
    p.println("First corner cubie of first layer placed.");
    cube.XInv(p);
    cubicle = cube.findCubie(cube.cubieOfColors(side1, side3, side4));
    placeFirstLayerCorner(cubicle, p);
    orientFirstLayerCorner(p);
    p.println("Second corner cubie of first layer placed.");
    cube.XInv(p);
    cubicle = cube.findCubie(cube.cubieOfColors(side1, side4, side5));
    placeFirstLayerCorner(cubicle, p);
    orientFirstLayerCorner(p);
    p.println("Third corner cubie of first layer placed.");
    cube.XInv(p);
    cubicle = cube.findCubie(cube.cubieOfColors(side1, side5, side2));
    placeFirstLayerCorner(cubicle, p);
    orientFirstLayerCorner(p);
    p.println("Fourth corner cubie  of first layer placed.");
  }
  
  /** Places the cubie currently in the given
    * corner cubicle into the corner cubicle fur using
    * legal cube moves, and without disturbing the
    * cubies in any of the front cubicles, unless one
    * of these cubicles contains the target cubie.
    * @param cubicle the corner cubicle containing the target cubie
    * @param p the PrintWriter to use to catalog the solution
    */
  private void placeFirstLayerCorner(CubeOfRubik3.CornerCubicle cubicle, PrintWriter p){
    if (cubicle == cube.getCorners()[1]){
      cube.D(p);
      cube.B(p);
      cube.DInv(p);
      cube.UInv(p);
      cube.BInv(p);
      cube.U(p);
    }
    else if (cubicle == cube.getCorners()[2]){
      cube.DInv(p);
      cube.BInv(p);
      cube.BInv(p);
      cube.D(p);
      cube.BInv(p);
      cube.UInv(p);
      cube.B(p);
      cube.U(p);
    }
    else if (cubicle == cube.getCorners()[3]){
      cube.LInv(p);
      cube.BInv(p);
      cube.L(p);
      cube.UInv(p);
      cube.BInv(p);
      cube.U(p);
    }
    else if (cubicle == cube.getCorners()[4]){
      cube.UInv(p);
      cube.BInv(p);
      cube.U(p);
    }
    else if (cubicle == cube.getCorners()[5]){
      cube.B(p);
      cube.UInv(p);
      cube.BInv(p);
      cube.U(p);
    }
    else if (cubicle == cube.getCorners()[6]){
      cube.B(p);
      cube.B(p);
      cube.UInv(p);
      cube.BInv(p);
      cube.U(p);
    }
    else if (cubicle == cube.getCorners()[7]){
      cube.BInv(p);
      cube.UInv(p);
      cube.BInv(p);
      cube.U(p);
    }
  }
  
  /** Correctly orients the corner cubie in cubicle
    * fur without disturbing any other cubies in the
    * front face of the cube.
    * @param p the PrintWriter to use to catalog the solution
    */
  private void orientFirstLayerCorner(PrintWriter p){
    if (cube.getCornerFace(0, 1).getColor()
          == cube.getCenterFace(0).getColor()){
      cube.R(p);
      cube.BInv(p);
      cube.RInv(p);
      cube.UInv(p);
      cube.BInv(p);
      cube.U(p);
    }
    else if (cube.getCornerFace(0, 2).getColor()
               == cube.getCenterFace(0).getColor()){
      cube.UInv(p);
      cube.B(p);
      cube.U(p);
      cube.R(p);
      cube.B(p);
      cube.RInv(p);
    }
  }
  
  /** Places the given edge cubie in the cubicle fl
    * with correct orientation during the second layer
    * phase of the layer method of solving the Rubik's cube.
    * The Rubik's cube is assumed to be oriented so that
    * fl is indeed the correct location for the given cubie.
    * @param cubie the edge cubie to place
    * @param p the PrintWriter to use to catalog the solution
    */
  private void placeSecondLayerCubie(CubeOfRubik3.EdgeCubicle cubicle, PrintWriter p){
    if (cubicle == cube.getEdges()[1]){
      cube.Z(p);
      secondLayerCubieFromFront(p);
      cube.ZInv(p);
      cubicle = cube.getEdges()[7];
    }
    else if (cubicle == cube.getEdges()[9]){
      cube.Z(p);
      cube.Z(p);
      secondLayerCubieFromFront(p);
      cube.ZInv(p);
      cube.ZInv(p);
      cubicle = cube.getEdges()[2];
    }
    else if (cubicle == cube.getEdges()[11]){
      cube.ZInv(p);
      secondLayerCubieFromFront(p);
      cube.Z(p);
      cubicle = cube.getEdges()[6];
    }
    else if (cubicle == cube.getEdges()[3]
               && cube.getEdgeFace(3, 0).getColor()
               != cube.getCenterFace(0).getColor()){
      secondLayerCubieFromFront(p);
      cubicle = cube.getEdges()[10];
    }
    if (cubicle == cube.getEdges()[6]){
      cube.DInv(p);
      cubicle = cube.getEdges()[2];
    }
    else if (cubicle == cube.getEdges()[10]){
      cube.D(p);
      cubicle = cube.getEdges()[7];
    }
    if (cubicle == cube.getEdges()[2]){
      if (cube.getEdgeFace(2, 0).getColor()
            == cube.getCenterFace(0).getColor()){
        secondLayerCubieFromFront(p);
      }
      else{
        cube.DInv(p);
        secondLayerCubieFromLeft(p);
      }
    }
    else if (cubicle == cube.getEdges()[7]){
      if (cube.getEdgeFace(7, 1).getColor()
            == cube.getCenterFace(5).getColor()){
        secondLayerCubieFromLeft(p);
      }
      else{
        cube.D(p);
        secondLayerCubieFromFront(p);
      }
    }
  }
    
  /** Moves the edge cubie in cubicle fd to cubicle
    * fl such that the color in the front face remains
    * constant and no cubies in the top or middle layer
    * of the Rubik's cube are disturbed.
    * @param p the PrintWriter to use to catalog the solution
    */
  private void secondLayerCubieFromFront(PrintWriter p){
    cube.D(p);
    cube.L(p);
    cube.DInv(p);
    cube.LInv(p);
    cube.DInv(p);
    cube.FInv(p);
    cube.D(p);
    cube.F(p);
  }
  
  /** Moves the edge cubie in cubicle dl to cubicle
    * fl such that the color in the left face remains
    * constant and no cubies in the top or middle layer
    * of the Rubik's cube are disturbed.
    * @param p the PrintWriter to use to catalog the solution
    */
  private void secondLayerCubieFromLeft(PrintWriter p){
    cube.DInv(p);
    cube.FInv(p);
    cube.D(p);
    cube.F(p);
    cube.D(p);
    cube.L(p);
    cube.DInv(p);
    cube.LInv(p);
  }
  
  /** Correctly orients the edge cubies of the third layer of the
    * Rubik's cube solved under the layer method, without placing
    * them in the correct cubicles.
    * @param thirdLayer the color of the third layer of the cube solved
    * @param p the PrintWriter to use to catalog the solution
    */
  private void makeCross(CubeColor thirdLayer, PrintWriter p){
    if (cube.getEdgeFace(4, 0).getColor() != thirdLayer.getColor()
          && cube.getEdgeFace(8, 0).getColor() != thirdLayer.getColor()
          && cube.getEdgeFace(5, 0).getColor() != thirdLayer.getColor()){
      crossFromLine(p);
    }
    if (cube.getEdgeFace(4, 0).getColor()
          == cube.getEdgeFace(5, 0).getColor()
          && cube.getEdgeFace(8, 0).getColor() != thirdLayer.getColor()){
      crossFromLine(p);
    }
    else if (cube.getEdgeFace(8, 0).getColor()
               == cube.getEdgeFace(0, 1).getColor()
               && cube.getEdgeFace(4, 0).getColor() != thirdLayer.getColor()){
      cube.Z(p);
      crossFromLine(p);
    }
    else if (cube.getEdgeFace(4, 0).getColor()
               == cube.getEdgeFace(8, 0).getColor()
               && cube.getEdgeFace(5, 0).getColor() != thirdLayer.getColor()){
      crossFromAngle(p);
    }
    else if (cube.getEdgeFace(8, 0).getColor()
               == cube.getEdgeFace(5, 0).getColor()
               && cube.getEdgeFace(4, 0).getColor() != thirdLayer.getColor()){
      cube.ZInv(p);
      crossFromAngle(p);
    }
    else if (cube.getEdgeFace(5, 0).getColor()
               == cube.getEdgeFace(0, 1).getColor()
               && cube.getEdgeFace(4, 0).getColor() != thirdLayer.getColor()){
      cube.Z(p);
      cube.Z(p);
      crossFromAngle(p);
    }
    else if (cube.getEdgeFace(0, 1).getColor()
               == cube.getEdgeFace(4, 0).getColor()
               && cube.getEdgeFace(5, 0).getColor() != thirdLayer.getColor()){
      cube.Z(p);
      crossFromAngle(p);
    }
    p.println("Third layer edge cubies correctly oriented.");
  }
  
  /** Orients the edge cubies of the third layer of the Rubik's cube
    * solved under the layer method when correctly oriented edge cubies
    * form a horizontal line across the up face of the cube.
    * @param p the PrintWriter to use to catalog the solution
    */
  private void crossFromLine(PrintWriter p){
    cube.F(p);
    cube.R(p);
    cube.U(p);
    cube.RInv(p);
    cube.UInv(p);
    cube.FInv(p);
  }
  
  /** Orients the edge cubies of the third layer of the Rubik's cube
    * solved under the layer method when correctly oriented edge cubies
    * form an angle open to the top-left of the up face of the cube.
    * @param p the PrintWriter to use to catalog the solution
    */
  private void crossFromAngle(PrintWriter p){
    cube.F(p);
    cube.U(p);
    cube.R(p);
    cube.UInv(p);
    cube.RInv(p);
    cube.FInv(p);
  }
  
  /** Places the corner cubies of the third layer of the Rubik's
    * cube solved under the layer method into the correct cubicles.
    * @param p the PrintWriter to use to catalog the solution
    */
  private void placeThirdLayerCorners(PrintWriter p){
    CubeOfRubik3.CornerCubicle cubicle = cube.findCubie(cube.cubieOfColors(CubeColor.getCubeColor(cube.getCenterFace(0).getColor()),
                                CubeColor.getCubeColor(cube.getCenterFace(1).getColor()),
                                CubeColor.getCubeColor(cube.getCenterFace(2).getColor())));
    while (cubicle != cube.getCorners()[0]){
      cube.U(p);
      cubicle = cube.findCubie(cube.cubieOfColors(CubeColor.getCubeColor(cube.getCenterFace(0).getColor()),
                                CubeColor.getCubeColor(cube.getCenterFace(1).getColor()),
                                CubeColor.getCubeColor(cube.getCenterFace(2).getColor())));
    }
    if (cube.getCorners()[3].getCubie()
          != cube.cubieOfColors(CubeColor.getCubeColor(cube.getCenterFace(0).getColor()),
                                       CubeColor.getCubeColor(cube.getCenterFace(5).getColor()),
                                       CubeColor.getCubeColor(cube.getCenterFace(1).getColor()))){
      if (cube.getCorners()[7].getCubie()
            != cube.cubieOfColors(CubeColor.getCubeColor(cube.getCenterFace(1).getColor()),
                                         CubeColor.getCubeColor(cube.getCenterFace(5).getColor()),
                                         CubeColor.getCubeColor(cube.getCenterFace(3).getColor()))){
        if (cube.getCorners()[4].getCubie()
              == cube.cubieOfColors(CubeColor.getCubeColor(cube.getCenterFace(1).getColor()),
                                         CubeColor.getCubeColor(cube.getCenterFace(3).getColor()),
                                           CubeColor.getCubeColor(cube.getCenterFace(2).getColor()))){
          
        cube.Z(p);
        cube.Z(p);
        swapThirdLayerCorners(p);
        }
        else if (cube.getCorners()[4].getCubie()
              == cube.cubieOfColors(CubeColor.getCubeColor(cube.getCenterFace(1).getColor()),
                                         CubeColor.getCubeColor(cube.getCenterFace(5).getColor()),
                                           CubeColor.getCubeColor(cube.getCenterFace(3).getColor()))){
          cube.Z(p);
          cube.Z(p);
          swapThirdLayerCorners(p);
          cube.ZInv(p);
          swapThirdLayerCorners(p);
        }
        else{
          cube.Z(p);
          swapThirdLayerCorners(p);
          cube.Z(p);
          swapThirdLayerCorners(p);
        }
      }
      else{
        cube.U(p);
        cube.Z(p);
        swapThirdLayerCorners(p);
        cube.Z(p);
        cube.Z(p);
        swapThirdLayerCorners(p);
      }
    }
    else if (cube.getCorners()[7].getCubie()
          != cube.cubieOfColors(CubeColor.getCubeColor(cube.getCenterFace(1).getColor()),
                                       CubeColor.getCubeColor(cube.getCenterFace(5).getColor()),
                                       CubeColor.getCubeColor(cube.getCenterFace(3).getColor()))){
      cube.Z(p);
      swapThirdLayerCorners(p);
    }
    p.println("Third layer corner cubies in correct cubicles.");
  }
  
  /** Swaps the cubies in cubicles fur and ubr
    * @param p the PrintWriter to use to catalog the solution
    */
  private void swapThirdLayerCorners(PrintWriter p){
    cube.L(p);
    cube.UInv(p);
    cube.RInv(p);
    cube.U(p);
    cube.LInv(p);
    cube.UInv(p);
    cube.R(p);
    cube.U(p);
    cube.U(p);
  }
  
  /** Correctly orients the corner cubies of the third layer of the
    * Rubik's cube solved under the layer method.
    * @param p the PrintWriter to use to catalog the solution
    */
  private void orientThirdLayerCorners(PrintWriter p){
    if (cube.getCornerFace(0, 0).getColor()
          == cube.getCenterFace(0).getColor()
          && cube.getCornerFace(3, 0).getColor()
          == cube.getCenterFace(0).getColor()
          && cube.getCornerFace(4, 0).getColor()
          == cube.getCenterFace(1).getColor()
          && cube.getCornerFace(7, 0).getColor()
          == cube.getCenterFace(1).getColor()){
    }
    else if (cube.getCornerFace(0, 2).getColor()
          == cube.getCenterFace(0).getColor()
          || cube.getCornerFace(3, 2).getColor()
          == cube.getCenterFace(0).getColor()
          || cube.getCornerFace(4, 2).getColor()
          == cube.getCenterFace(1).getColor()
          || cube.getCornerFace(7, 2).getColor()
          == cube.getCenterFace(1).getColor()){
      while (cube.getCornerFace(0, 2).getColor()
               != cube.getCenterFace(0).getColor()){
        cube.Z(p);
      }
      if (cube.getCornerFace(3, 2).getColor()
            == cube.getCenterFace(0).getColor()){
        if (cube.getCornerFace(7, 0).getColor()
              == cube.getCenterFace(5).getColor()){
          cube.Z(p);
          cube.Z(p);
          thirdLayerCornersClockwise(p);
        }
        else if (cube.getCornerFace(7, 0).getColor()
                   == cube.getCenterFace(3).getColor()){
          thirdLayerCornersCounterclockwise(p);
          cube.ZInv(p);
          thirdLayerCornersCounterclockwise(p);
        }
        else{
          cube.ZInv(p);
          thirdLayerCornersClockwise(p);
        }
      }
      else if (cube.getCornerFace(3, 1).getColor()
                 == cube.getCenterFace(0).getColor()){
        if (cube.getCornerFace(7, 0).getColor()
              == cube.getCenterFace(5).getColor()){
          cube.Z(p);
          thirdLayerCornersClockwise(p);
          cube.Z(p);
          cube.Z(p);
          thirdLayerCornersClockwise(p);
        }
        else if (cube.getCornerFace(7, 0).getColor()
                   == cube.getCenterFace(3).getColor()){
          thirdLayerCornersCounterclockwise(p);        
          cube.Z(p);
          thirdLayerCornersCounterclockwise(p);
        }
        else{
          thirdLayerCornersClockwise(p);
          cube.Z(p);
          cube.Z(p);
          thirdLayerCornersCounterclockwise(p);
        }
      }
      else{
        if (cube.getCornerFace(7, 0).getColor()
              == cube.getCenterFace(5).getColor()){
          thirdLayerCornersClockwise(p);
        }
        else if (cube.getCornerFace(7, 0).getColor()
                   == cube.getCenterFace(3).getColor()){
          cube.ZInv(p);
          thirdLayerCornersClockwise(p);
          cube.ZInv(p);
          thirdLayerCornersCounterclockwise(p);
        }
        else{
          cube.Z(p);
          cube.Z(p);
          thirdLayerCornersClockwise(p);
          thirdLayerCornersCounterclockwise(p);
        }
      }
    }
    else{
      while (cube.getCornerFace(7, 1).getColor()
               != cube.getCenterFace(5).getColor()){
        cube.Z(p);
      }
      thirdLayerCornersCounterclockwise(p);
    }
    p.println("Third layer corner cubies correctly oriented.");
  }
  
  /** Places the edge cubies of the third layer of the Rubik's
    * cube solved under the layer method into the correct cubicles.
    * The cubies must already be correctly oriented.
    * @param p the PrintWriter to use to catalog the solution
    */
  private void placeThirdLayerEdges(PrintWriter p){
    if (CubeColor.getCubeColor(cube.getEdgeFace(0, 0).getColor())
          != CubeColor.getCubeColor(cube.getCenterFace(0).getColor())
          && CubeColor.getCubeColor(cube.getEdgeFace(4, 1).getColor())
          != CubeColor.getCubeColor(cube.getCenterFace(5).getColor())
          && CubeColor.getCubeColor(cube.getEdgeFace(5, 1).getColor())
          != CubeColor.getCubeColor(cube.getCenterFace(2).getColor())
          && CubeColor.getCubeColor(cube.getEdgeFace(8, 1).getColor())
          != CubeColor.getCubeColor(cube.getCenterFace(3).getColor())){
      thirdLayerEdgesClockwise(p);
    }
    //Why is the program getting hung up in this while loop?
    while (CubeColor.getCubeColor(cube.getEdgeFace(4, 1).getColor())
             != CubeColor.getCubeColor(cube.getCenterFace(5).getColor())){
      cube.Z(p);
    }
    if (CubeColor.getCubeColor(cube.getEdgeFace(5, 1).getColor())
          == CubeColor.getCubeColor(cube.getCenterFace(0).getColor())){
      thirdLayerEdgesClockwise(p);
    }
    else if (CubeColor.getCubeColor(cube.getEdgeFace(8, 1).getColor())
          == CubeColor.getCubeColor(cube.getCenterFace(0).getColor())){
      thirdLayerEdgesCounterclockwise(p);
    }
    p.println("Third layer edge cubies in correct cubicles.");
  }
  
  /** Rotates the corner cubies in cubicles ulb, ubr, and fur clockwise.
    * @param p the PrintWriter to use to catalog the solution
    */
  private void thirdLayerCornersClockwise(PrintWriter p){
    cube.R(p);
    cube.U(p);
    cube.RInv(p);
    cube.U(p);
    cube.R(p);
    cube.U(p);
    cube.U(p);
    cube.RInv(p);
    cube.U(p);
    cube.U(p);
  }
  
  /** Rotates the corner cubies in cubicles flu, fur, and ubr counterclockwise.
    * @param p the PrintWriter to use to catalog the solution
    */
  private void thirdLayerCornersCounterclockwise(PrintWriter p){
    cube.RInv(p);
    cube.UInv(p);
    cube.R(p);
    cube.UInv(p);
    cube.RInv(p);
    cube.U(p);
    cube.U(p);
    cube.R(p);
    cube.U(p);
    cube.U(p);
  }
    
  
  /** Cycles the edge cubies in cubicles ub, ur, and fu clockwise as
    * seen from the up face without changing the orientations of the cubies.
    * @param p the PrintWriter to use to catalog the solution
    */
  private void thirdLayerEdgesClockwise(PrintWriter p){
    cube.R(p);
    cube.R(p);
    cube.U(p);
    cube.F(p);
    cube.BInv(p);
    cube.R(p);
    cube.R(p);
    cube.FInv(p);
    cube.B(p);
    cube.U(p);
    cube.R(p);
    cube.R(p);
  }
  
  /** Cycles the edge cubies in cubicles ub, ur, and fu counterclockwise as
    * seen from the up face without changing the orientations of the cubies.
    * @param p the PrintWriter to use to catalog the solution
    */
  private void thirdLayerEdgesCounterclockwise(PrintWriter p){
    cube.R(p);
    cube.R(p);
    cube.UInv(p);
    cube.F(p);
    cube.BInv(p);
    cube.R(p);
    cube.R(p);
    cube.FInv(p);
    cube.B(p);
    cube.UInv(p);
    cube.R(p);
    cube.R(p);
  }
  
  /** Randomly chooses a cube color.
    * @return the randomly chosen cube color
    */
  private CubeColor chooseFirstSide(){
    Random chooser = new Random();
    return CubeColor.cubeColors[chooser.nextInt(6)];
  }
  
  /** Randomly chooses one of the neighboring cube
    * colors of the given cube color.
    * @param firstColor the first cube color chosen
    * @return a randomly chosen neighbor
    */
  private CubeColor chooseSecondSide(CubeColor firstColor){
    Random chooser = new Random();
    Color secondColor = firstColor.getNeighbors()[chooser.nextInt(4)];
    return CubeColor.getCubeColor(secondColor);
  }
  
  /** Orients the Rubik's cube so that the first
    * given color is facing front, and the second
    * given color is facing up.
    * @param color1 the color to place in front
    * @param color2 the color to place in up
    * @param p the PrintWriter to use to catalog the solution
    */
  public void placeFrontAndUp(CubeColor color1, CubeColor color2, PrintWriter p){
    if (CubeColor.getCubeColor(color1.getNeighbors()[0]) != color2
          && CubeColor.getCubeColor(color1.getNeighbors()[1]) != color2
          && CubeColor.getCubeColor(color1.getNeighbors()[2]) != color2
          && CubeColor.getCubeColor(color1.getNeighbors()[3]) != color2){
      p.println("You tried to put opposite colors front and up.");
      return;
    }
    else{
      CubeOfRubik3.CenterCubicle origin = cube.findCubie(cube.cubieOfColor(color1));
      
      if (origin == cube.getCenters()[1]){
        cube.YInv(p);
      }
      else if (origin == cube.getCenters()[2]){
        cube.Z(p);
      }
      else if (origin == cube.getCenters()[3]){
        cube.Z(p);
        cube.Z(p);
      }
      else if (origin == cube.getCenters()[4]){
        cube.Y(p);
      }
      else if (origin == cube.getCenters()[5]){
        cube.ZInv(p);
      }
      else{
      }
      origin = cube.findCubie(cube.cubieOfColor(color2));
      
      if (origin == cube.getCenters()[2]){
        cube.XInv(p);
      }
      else if (origin == cube.getCenters()[4]){
        cube.X(p);
        cube.X(p);
      }
      else if (origin == cube.getCenters()[5]){
        cube.X(p);
      }
    }
  }
  
  /** Returns the Rubik's cube this cube solver
    * works on.
    * @return the Rubik's cube
    */
  public CubeOfRubik3 getCube(){
    return cube;
  }
}