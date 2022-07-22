import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.Box;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class CubeCreator{

  public static final CubieFace GRAY_CUBIE_FACE = new CubieFace(Color.GRAY, 5, CubieFace.CUBIE_FACE_DIMENSION);
  private CubeOfRubik3 cube;
  private boolean colorSelected;
  private boolean[] mouseInNonCentralCubies = new boolean[48];
  private Color selectedColor;
  final private JFrame cubeDisplayFrame;
  final private JLabel l1 = new JLabel(GRAY_CUBIE_FACE);
  final private JLabel l2 = new JLabel(GRAY_CUBIE_FACE);
  final private JLabel l3 = new JLabel(GRAY_CUBIE_FACE);
  final private JLabel l4 = new JLabel(GRAY_CUBIE_FACE);
  final private JLabel l5 = new JLabel(CubieFace.O5);
  final private JLabel l6 = new JLabel(GRAY_CUBIE_FACE);
  final private JLabel l7 = new JLabel(GRAY_CUBIE_FACE);
  final private JLabel l8 = new JLabel(GRAY_CUBIE_FACE);
  final private JLabel l9 = new JLabel(GRAY_CUBIE_FACE);
  final private JLabel u1 = new JLabel(GRAY_CUBIE_FACE);
  final private JLabel u2 = new JLabel(GRAY_CUBIE_FACE);
  final private JLabel u3 = new JLabel(GRAY_CUBIE_FACE);
  final private JLabel u4 = new JLabel(GRAY_CUBIE_FACE);
  final private JLabel u5 = new JLabel(CubieFace.B5);
  final private JLabel u6 = new JLabel(GRAY_CUBIE_FACE);
  final private JLabel u7 = new JLabel(GRAY_CUBIE_FACE);
  final private JLabel u8 = new JLabel(GRAY_CUBIE_FACE);
  final private JLabel u9 = new JLabel(GRAY_CUBIE_FACE);
  final private JLabel f1 = new JLabel(GRAY_CUBIE_FACE);
  final private JLabel f2 = new JLabel(GRAY_CUBIE_FACE);
  final private JLabel f3 = new JLabel(GRAY_CUBIE_FACE);
  final private JLabel f4 = new JLabel(GRAY_CUBIE_FACE);
  final private JLabel f5 = new JLabel(CubieFace.W5);
  final private JLabel f6 = new JLabel(GRAY_CUBIE_FACE);
  final private JLabel f7 = new JLabel(GRAY_CUBIE_FACE);
  final private JLabel f8 = new JLabel(GRAY_CUBIE_FACE);
  final private JLabel f9 = new JLabel(GRAY_CUBIE_FACE);
  final private JLabel d1 = new JLabel(GRAY_CUBIE_FACE);
  final private JLabel d2 = new JLabel(GRAY_CUBIE_FACE);
  final private JLabel d3 = new JLabel(GRAY_CUBIE_FACE);
  final private JLabel d4 = new JLabel(GRAY_CUBIE_FACE);
  final private JLabel d5 = new JLabel(CubieFace.G5);
  final private JLabel d6 = new JLabel(GRAY_CUBIE_FACE);
  final private JLabel d7 = new JLabel(GRAY_CUBIE_FACE);
  final private JLabel d8 = new JLabel(GRAY_CUBIE_FACE);
  final private JLabel d9 = new JLabel(GRAY_CUBIE_FACE);
  final private JLabel r1 = new JLabel(GRAY_CUBIE_FACE);
  final private JLabel r2 = new JLabel(GRAY_CUBIE_FACE);
  final private JLabel r3 = new JLabel(GRAY_CUBIE_FACE);
  final private JLabel r4 = new JLabel(GRAY_CUBIE_FACE);
  final private JLabel r5 = new JLabel(CubieFace.R5);
  final private JLabel r6 = new JLabel(GRAY_CUBIE_FACE);
  final private JLabel r7 = new JLabel(GRAY_CUBIE_FACE);
  final private JLabel r8 = new JLabel(GRAY_CUBIE_FACE);
  final private JLabel r9 = new JLabel(GRAY_CUBIE_FACE);
  final private JLabel b1 = new JLabel(GRAY_CUBIE_FACE);
  final private JLabel b2 = new JLabel(GRAY_CUBIE_FACE);
  final private JLabel b3 = new JLabel(GRAY_CUBIE_FACE);
  final private JLabel b4 = new JLabel(GRAY_CUBIE_FACE);
  final private JLabel b5 = new JLabel(CubieFace.Y5);
  final private JLabel b6 = new JLabel(GRAY_CUBIE_FACE);
  final private JLabel b7 = new JLabel(GRAY_CUBIE_FACE);
  final private JLabel b8 = new JLabel(GRAY_CUBIE_FACE);
  final private JLabel b9 = new JLabel(GRAY_CUBIE_FACE);
 
  public CubeCreator(String label){
    cube = new CubeOfRubik3();
    colorSelected = false;
    for (int i = 0; i <= 47; i++){
      mouseInNonCentralCubies[i] = false;
    }
    selectedColor = Color.GRAY;
    cubeDisplayFrame = new JFrame(label);
  } 
   
  private CubieFace getIcon(JLabel facePic){
    return (CubieFace) facePic.getIcon();
  }
  
  public void displayCubeCreator(){
    
    clearColorSelected();
    cubeDisplayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    cubeDisplayFrame.getContentPane().setLayout(new BoxLayout(cubeDisplayFrame.getContentPane(), BoxLayout.X_AXIS));
  
    cubeDisplayFrame.getContentPane().addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (!mouseInNonCentralCubies()){
          if (colorSelected){
            clearColorSelected();
          }
        }
      }
    });
    
    Box lb = new Box(BoxLayout.Y_AXIS);
    Box l = new Box(BoxLayout.Y_AXIS);
    Box lf = new Box(BoxLayout.Y_AXIS);
    Box ufdl = new Box(BoxLayout.Y_AXIS);
    Box ufd = new Box(BoxLayout.Y_AXIS);
    Box ufdr = new Box(BoxLayout.Y_AXIS);
    Box rf = new Box(BoxLayout.Y_AXIS);
    Box r = new Box(BoxLayout.Y_AXIS);
    Box rb = new Box(BoxLayout.Y_AXIS);
    Box br = new Box(BoxLayout.Y_AXIS);
    Box b = new Box(BoxLayout.Y_AXIS);
    Box bl = new Box(BoxLayout.Y_AXIS);
    Box colorChoices = new Box(BoxLayout.Y_AXIS);
    Box leftColorChoicesBorders = new Box(BoxLayout.Y_AXIS);
    Box rightColorChoicesBorders = new Box(BoxLayout.Y_AXIS);
    Box creationButtonBox = new Box(BoxLayout.Y_AXIS);
 
    l1.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (colorSelected){
          l1.setIcon(CubieFace.faceOfColor(selectedColor));
          clearColorSelected();
          l1.repaint();
        }
      }
      public void mouseEntered(MouseEvent e){
        mouseInNonCentralCubies[0] = true;
      }
      public void mouseExited(MouseEvent e){
        mouseInNonCentralCubies[0] = false;
      }
    });
        
    l2.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (colorSelected){
          l2.setIcon(CubieFace.faceOfColor(selectedColor));
          clearColorSelected();
          l2.repaint();
        }
      }
      public void mouseEntered(MouseEvent e){
        mouseInNonCentralCubies[1] = true;
      }
      public void mouseExited(MouseEvent e){
        mouseInNonCentralCubies[1] = false;
      }
    });
    
    l3.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (colorSelected){
          l3.setIcon(CubieFace.faceOfColor(selectedColor));
          clearColorSelected();
          l3.repaint();
        }
      }
      public void mouseEntered(MouseEvent e){
        mouseInNonCentralCubies[2] = true;
      }
      public void mouseExited(MouseEvent e){
        mouseInNonCentralCubies[2] = false;
      }
    });
    
    l4.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (colorSelected){
          l4.setIcon(CubieFace.faceOfColor(selectedColor));
          clearColorSelected();
          l4.repaint();
        }
      }
      public void mouseEntered(MouseEvent e){
        mouseInNonCentralCubies[3] = true;
      }
      public void mouseExited(MouseEvent e){
        mouseInNonCentralCubies[3] = false;
      }
    });
        
    l6.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (colorSelected){
          l6.setIcon(CubieFace.faceOfColor(selectedColor));
          clearColorSelected();
          l6.repaint();
        }
      }
      public void mouseEntered(MouseEvent e){
        mouseInNonCentralCubies[4] = true;
      }
      public void mouseExited(MouseEvent e){
        mouseInNonCentralCubies[4] = false;
      }
    });
    
    l7.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (colorSelected){
          l7.setIcon(CubieFace.faceOfColor(selectedColor));
          clearColorSelected();
          l7.repaint();
        }
      }
      public void mouseEntered(MouseEvent e){
        mouseInNonCentralCubies[5] = true;
      }
      public void mouseExited(MouseEvent e){
        mouseInNonCentralCubies[5] = false;
      }
    });
    
    l8.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (colorSelected){
          l8.setIcon(CubieFace.faceOfColor(selectedColor));
          clearColorSelected();
          l8.repaint();
        }
      }
      public void mouseEntered(MouseEvent e){
        mouseInNonCentralCubies[6] = true;
      }
      public void mouseExited(MouseEvent e){
        mouseInNonCentralCubies[6] = false;
      }
    });
    
    l9.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (colorSelected){
          l9.setIcon(CubieFace.faceOfColor(selectedColor));
          clearColorSelected();
          l9.repaint();
        }
      }
      public void mouseEntered(MouseEvent e){
        mouseInNonCentralCubies[7] = true;
      }
      public void mouseExited(MouseEvent e){
        mouseInNonCentralCubies[7] = false;
      }
    });
    
    u1.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (colorSelected){
          u1.setIcon(CubieFace.faceOfColor(selectedColor));
          clearColorSelected();
          u1.repaint();
        }
      }
      public void mouseEntered(MouseEvent e){
        mouseInNonCentralCubies[8] = true;
      }
      public void mouseExited(MouseEvent e){
        mouseInNonCentralCubies[8] = false;
      }
    });
    
    u2.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (colorSelected){
          u2.setIcon(CubieFace.faceOfColor(selectedColor));
          clearColorSelected();
          u2.repaint();
        }
      }
      public void mouseEntered(MouseEvent e){
        mouseInNonCentralCubies[9] = true;
      }
      public void mouseExited(MouseEvent e){
        mouseInNonCentralCubies[9] = false;
      }
    });
    
    u3.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (colorSelected){
          u3.setIcon(CubieFace.faceOfColor(selectedColor));
          clearColorSelected();
          u3.repaint();
        }
      }
      public void mouseEntered(MouseEvent e){
        mouseInNonCentralCubies[10] = true;
      }
      public void mouseExited(MouseEvent e){
        mouseInNonCentralCubies[10] = false;
      }
    });
    
    u4.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (colorSelected){
          u4.setIcon(CubieFace.faceOfColor(selectedColor));
          clearColorSelected();
          u4.repaint();
        }
      }
      public void mouseEntered(MouseEvent e){
        mouseInNonCentralCubies[11] = true;
      }
      public void mouseExited(MouseEvent e){
        mouseInNonCentralCubies[11] = false;
      }
    });
    
    u6.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (colorSelected){
          u6.setIcon(CubieFace.faceOfColor(selectedColor));
          clearColorSelected();
          u6.repaint();
        }
      }
      public void mouseEntered(MouseEvent e){
        mouseInNonCentralCubies[12] = true;
      }
      public void mouseExited(MouseEvent e){
        mouseInNonCentralCubies[12] = false;
      }
    });
    
    u7.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (colorSelected){
          u7.setIcon(CubieFace.faceOfColor(selectedColor));
          clearColorSelected();
          u7.repaint();
        }
      }
      public void mouseEntered(MouseEvent e){
        mouseInNonCentralCubies[13] = true;
      }
      public void mouseExited(MouseEvent e){
        mouseInNonCentralCubies[13] = false;
      }
    });
    
    u8.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (colorSelected){
          u8.setIcon(CubieFace.faceOfColor(selectedColor));
          clearColorSelected();
          u8.repaint();
        }
      }
      public void mouseEntered(MouseEvent e){
        mouseInNonCentralCubies[14] = true;
      }
      public void mouseExited(MouseEvent e){
        mouseInNonCentralCubies[14] = false;
      }
    });
    
    u9.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (colorSelected){
          u9.setIcon(CubieFace.faceOfColor(selectedColor));
          clearColorSelected();
          u9.repaint();
        }
      }
      public void mouseEntered(MouseEvent e){
        mouseInNonCentralCubies[15] = true;
      }
      public void mouseExited(MouseEvent e){
        mouseInNonCentralCubies[15] = false;
      }
    });
    
    f1.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (colorSelected){
          f1.setIcon(CubieFace.faceOfColor(selectedColor));
          clearColorSelected();
          f1.repaint();
        }
      }
      public void mouseEntered(MouseEvent e){
        mouseInNonCentralCubies[16] = true;
      }
      public void mouseExited(MouseEvent e){
        mouseInNonCentralCubies[16] = false;
      }
    });
    
    f2.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (colorSelected){
          f2.setIcon(CubieFace.faceOfColor(selectedColor));
          clearColorSelected();
          f2.repaint();
        }
      }
      public void mouseEntered(MouseEvent e){
        mouseInNonCentralCubies[17] = true;
      }
      public void mouseExited(MouseEvent e){
        mouseInNonCentralCubies[17] = false;
      }
    });
    
    f3.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (colorSelected){
          f3.setIcon(CubieFace.faceOfColor(selectedColor));
          clearColorSelected();
          f3.repaint();
        }
      }
      public void mouseEntered(MouseEvent e){
        mouseInNonCentralCubies[18] = true;
      }
      public void mouseExited(MouseEvent e){
        mouseInNonCentralCubies[18] = false;
      }
    });
    
    f4.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (colorSelected){
          f4.setIcon(CubieFace.faceOfColor(selectedColor));
          clearColorSelected();
          f4.repaint();
        }
      }
      public void mouseEntered(MouseEvent e){
        mouseInNonCentralCubies[19] = true;
      }
      public void mouseExited(MouseEvent e){
        mouseInNonCentralCubies[19] = false;
      }
    });
    
    f6.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (colorSelected){
          f6.setIcon(CubieFace.faceOfColor(selectedColor));
          clearColorSelected();
          f6.repaint();
        }
      }
      public void mouseEntered(MouseEvent e){
        mouseInNonCentralCubies[20] = true;
      }
      public void mouseExited(MouseEvent e){
        mouseInNonCentralCubies[20] = false;
      }
    });
    
    f7.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (colorSelected){
          f7.setIcon(CubieFace.faceOfColor(selectedColor));
          clearColorSelected();
          f7.repaint();
        }
      }
      public void mouseEntered(MouseEvent e){
        mouseInNonCentralCubies[21] = true;
      }
      public void mouseExited(MouseEvent e){
        mouseInNonCentralCubies[21] = false;
      }
    });
    
    f8.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (colorSelected){
          f8.setIcon(CubieFace.faceOfColor(selectedColor));
          clearColorSelected();
          f8.repaint();
        }
      }
      public void mouseEntered(MouseEvent e){
        mouseInNonCentralCubies[22] = true;
      }
      public void mouseExited(MouseEvent e){
        mouseInNonCentralCubies[22] = false;
      }
    });
    
    f9.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (colorSelected){
          f9.setIcon(CubieFace.faceOfColor(selectedColor));
          clearColorSelected();
          f9.repaint();
        }
      }
      public void mouseEntered(MouseEvent e){
        mouseInNonCentralCubies[23] = true;
      }
      public void mouseExited(MouseEvent e){
        mouseInNonCentralCubies[23] = false;
      }
    });
    
    d1.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (colorSelected){
          d1.setIcon(CubieFace.faceOfColor(selectedColor));
          clearColorSelected();
          d1.repaint();
        }
      }
      public void mouseEntered(MouseEvent e){
        mouseInNonCentralCubies[24] = true;
      }
      public void mouseExited(MouseEvent e){
        mouseInNonCentralCubies[24] = false;
      }
    });
    
    d2.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (colorSelected){
          d2.setIcon(CubieFace.faceOfColor(selectedColor));
          clearColorSelected();
          d2.repaint();
        }
      }
      public void mouseEntered(MouseEvent e){
        mouseInNonCentralCubies[25] = true;
      }
      public void mouseExited(MouseEvent e){
        mouseInNonCentralCubies[25] = false;
      }
    });
    
    d3.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (colorSelected){
          d3.setIcon(CubieFace.faceOfColor(selectedColor));
          clearColorSelected();
          d3.repaint();
        }
      }
      public void mouseEntered(MouseEvent e){
        mouseInNonCentralCubies[26] = true;
      }
      public void mouseExited(MouseEvent e){
        mouseInNonCentralCubies[26] = false;
      }
    });
    
    d4.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (colorSelected){
          d4.setIcon(CubieFace.faceOfColor(selectedColor));
          clearColorSelected();
          d4.repaint();
        }
      }
      public void mouseEntered(MouseEvent e){
        mouseInNonCentralCubies[27] = true;
      }
      public void mouseExited(MouseEvent e){
        mouseInNonCentralCubies[27] = false;
      }
    });
    
    d6.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (colorSelected){
          d6.setIcon(CubieFace.faceOfColor(selectedColor));
          clearColorSelected();
          d6.repaint();
        }
      }
      public void mouseEntered(MouseEvent e){
        mouseInNonCentralCubies[28] = true;
      }
      public void mouseExited(MouseEvent e){
        mouseInNonCentralCubies[28] = false;
      }
    });
    
    d7.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (colorSelected){
          d7.setIcon(CubieFace.faceOfColor(selectedColor));
          clearColorSelected();
          d7.repaint();
        }
      }
      public void mouseEntered(MouseEvent e){
        mouseInNonCentralCubies[29] = true;
      }
      public void mouseExited(MouseEvent e){
        mouseInNonCentralCubies[29] = false;
      }
    });
    
    d8.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (colorSelected){
          d8.setIcon(CubieFace.faceOfColor(selectedColor));
          clearColorSelected();
          d8.repaint();
        }
      }
      public void mouseEntered(MouseEvent e){
        mouseInNonCentralCubies[30] = true;
      }
      public void mouseExited(MouseEvent e){
        mouseInNonCentralCubies[30] = false;
      }
    });
    
    d9.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (colorSelected){
          d9.setIcon(CubieFace.faceOfColor(selectedColor));
          clearColorSelected();
          d9.repaint();
        }
      }
      public void mouseEntered(MouseEvent e){
        mouseInNonCentralCubies[31] = true;
      }
      public void mouseExited(MouseEvent e){
        mouseInNonCentralCubies[31] = false;
      }
    });
    
    r1.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (colorSelected){
          r1.setIcon(CubieFace.faceOfColor(selectedColor));
          clearColorSelected();
          r1.repaint();
        }
      }
      public void mouseEntered(MouseEvent e){
        mouseInNonCentralCubies[32] = true;
      }
      public void mouseExited(MouseEvent e){
        mouseInNonCentralCubies[32] = false;
      }
    });
    
    r2.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (colorSelected){
          r2.setIcon(CubieFace.faceOfColor(selectedColor));
          clearColorSelected();
          r2.repaint();
        }
      }
      public void mouseEntered(MouseEvent e){
        mouseInNonCentralCubies[33] = true;
      }
      public void mouseExited(MouseEvent e){
        mouseInNonCentralCubies[33] = false;
      }
    });
    
    r3.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (colorSelected){
          r3.setIcon(CubieFace.faceOfColor(selectedColor));
          clearColorSelected();
          r3.repaint();
        }
      }
      public void mouseEntered(MouseEvent e){
        mouseInNonCentralCubies[34] = true;
      }
      public void mouseExited(MouseEvent e){
        mouseInNonCentralCubies[34] = false;
      }
    });
    
    r4.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (colorSelected){
          r4.setIcon(CubieFace.faceOfColor(selectedColor));
          clearColorSelected();
          r4.repaint();
        }
      }
      public void mouseEntered(MouseEvent e){
        mouseInNonCentralCubies[35] = true;
      }
      public void mouseExited(MouseEvent e){
        mouseInNonCentralCubies[35] = false;
      }
    });
    
    r6.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (colorSelected){
          r6.setIcon(CubieFace.faceOfColor(selectedColor));
          clearColorSelected();
          r6.repaint();
        }
      }
      public void mouseEntered(MouseEvent e){
        mouseInNonCentralCubies[36] = true;
      }
      public void mouseExited(MouseEvent e){
        mouseInNonCentralCubies[36] = false;
      }
    });
    
    r7.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (colorSelected){
          r7.setIcon(CubieFace.faceOfColor(selectedColor));
          clearColorSelected();
          r7.repaint();
        }
      }
      public void mouseEntered(MouseEvent e){
        mouseInNonCentralCubies[37] = true;
      }
      public void mouseExited(MouseEvent e){
        mouseInNonCentralCubies[37] = false;
      }
    });
    
    r8.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (colorSelected){
          r8.setIcon(CubieFace.faceOfColor(selectedColor));
          clearColorSelected();
          r8.repaint();
        }
      }
      public void mouseEntered(MouseEvent e){
        mouseInNonCentralCubies[38] = true;
      }
      public void mouseExited(MouseEvent e){
        mouseInNonCentralCubies[38] = false;
      }
    });
    
    r9.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (colorSelected){
          r9.setIcon(CubieFace.faceOfColor(selectedColor));
          clearColorSelected();
          r9.repaint();
        }
      }
      public void mouseEntered(MouseEvent e){
        mouseInNonCentralCubies[39] = true;
      }
      public void mouseExited(MouseEvent e){
        mouseInNonCentralCubies[39] = false;
      }
    });
    
    b1.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (colorSelected){
          b1.setIcon(CubieFace.faceOfColor(selectedColor));
          clearColorSelected();
          b1.repaint();
        }
      }
      public void mouseEntered(MouseEvent e){
        mouseInNonCentralCubies[40] = true;
      }
      public void mouseExited(MouseEvent e){
        mouseInNonCentralCubies[40] = false;
      }
    });
    
    b2.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (colorSelected){
          b2.setIcon(CubieFace.faceOfColor(selectedColor));
          clearColorSelected();
          b2.repaint();
        }
      }
      public void mouseEntered(MouseEvent e){
        mouseInNonCentralCubies[41] = true;
      }
      public void mouseExited(MouseEvent e){
        mouseInNonCentralCubies[41] = false;
      }
    });
    
    b3.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (colorSelected){
          b3.setIcon(CubieFace.faceOfColor(selectedColor));
          clearColorSelected();
          b3.repaint();
        }
      }
      public void mouseEntered(MouseEvent e){
        mouseInNonCentralCubies[42] = true;
      }
      public void mouseExited(MouseEvent e){
        mouseInNonCentralCubies[42] = false;
      }
    });
    
    b4.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (colorSelected){
          b4.setIcon(CubieFace.faceOfColor(selectedColor));
          clearColorSelected();
          b4.repaint();
        }
      }
      public void mouseEntered(MouseEvent e){
        mouseInNonCentralCubies[43] = true;
      }
      public void mouseExited(MouseEvent e){
        mouseInNonCentralCubies[43] = false;
      }
    });
    
    b6.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (colorSelected){
          b6.setIcon(CubieFace.faceOfColor(selectedColor));
          clearColorSelected();
          b6.repaint();
        }
      }
      public void mouseEntered(MouseEvent e){
        mouseInNonCentralCubies[44] = true;
      }
      public void mouseExited(MouseEvent e){
        mouseInNonCentralCubies[44] = false;
      }
    });
    
    b7.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (colorSelected){
          b7.setIcon(CubieFace.faceOfColor(selectedColor));
          clearColorSelected();
          b7.repaint();
        }
      }
      public void mouseEntered(MouseEvent e){
        mouseInNonCentralCubies[45] = true;
      }
      public void mouseExited(MouseEvent e){
        mouseInNonCentralCubies[45] = false;
      }
    });
    
    b8.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (colorSelected){
          b8.setIcon(CubieFace.faceOfColor(selectedColor));
          clearColorSelected();
          b8.repaint();
        }
      }
      public void mouseEntered(MouseEvent e){
        mouseInNonCentralCubies[46] = true;
      }
      public void mouseExited(MouseEvent e){
        mouseInNonCentralCubies[46] = false;
      }
    });
    
    b9.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (colorSelected){
          b9.setIcon(CubieFace.faceOfColor(selectedColor));
          clearColorSelected();
          b9.repaint();
        }
      }
      public void mouseEntered(MouseEvent e){
        mouseInNonCentralCubies[47] = true;
      }
      public void mouseExited(MouseEvent e){
        mouseInNonCentralCubies[47] = false;
      }
    });
    
    JLabel horizontalBorder1 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder2 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder3 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder4 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder5 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder6 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder7 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder8 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder9 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder10 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder11 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder12 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder13 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder14 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder15 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder16 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder17 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder18 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder19 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder20 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder21 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder22 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder23 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder24 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder25 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder26 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder27 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder28 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder29 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder30 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder31 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder32 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder33 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder34 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder35 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder36 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder37 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder38 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder39 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder40 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder41 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder42 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder43 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder44 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder45 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder46 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder47 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder48 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder49 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder50 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder51 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder52 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder53 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder54 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder55 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder56 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder57 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder58 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder59 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder60 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder61 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder62 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder63 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder64 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder65 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder66 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder67 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder68 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder69 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder70 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder71 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder72 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder73 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder74 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder75 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder76 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder77 = new JLabel(new HorizontalCubieBorder());
    JLabel horizontalBorder78 = new JLabel(new HorizontalCubieBorder());
    
    JLabel verticalBorder1 = new JLabel(new VerticalCubeFaceBorder(CubieFace.CUBIE_FACE_DIMENSION * 3 
                                                                     + CubePrinter.BORDER_THICKNESS * 4));
    JLabel verticalBorder2 = new JLabel(new VerticalCubeFaceBorder(CubieFace.CUBIE_FACE_DIMENSION * 3
                                                                     + CubePrinter.BORDER_THICKNESS * 4));
    JLabel verticalBorder3 = new JLabel(new VerticalCubeFaceBorder(CubieFace.CUBIE_FACE_DIMENSION * 3
                                                                     + CubePrinter.BORDER_THICKNESS * 4));
    JLabel verticalBorder4 = new JLabel(new VerticalCubeFaceBorder(CubieFace.CUBIE_FACE_DIMENSION * 9
                                                                     + CubePrinter.BORDER_THICKNESS * 10));
    JLabel verticalBorder5 = new JLabel(new VerticalCubeFaceBorder(CubieFace.CUBIE_FACE_DIMENSION * 9
                                                                     + CubePrinter.BORDER_THICKNESS * 10));
    JLabel verticalBorder6 = new JLabel(new VerticalCubeFaceBorder(CubieFace.CUBIE_FACE_DIMENSION * 9
                                                                     + CubePrinter.BORDER_THICKNESS * 10));
    JLabel verticalBorder7 = new JLabel(new VerticalCubeFaceBorder(CubieFace.CUBIE_FACE_DIMENSION * 9
                                                                     + CubePrinter.BORDER_THICKNESS * 10));
    JLabel verticalBorder8 = new JLabel(new VerticalCubeFaceBorder(CubieFace.CUBIE_FACE_DIMENSION * 3
                                                                     + CubePrinter.BORDER_THICKNESS * 4));
    JLabel verticalBorder9 = new JLabel(new VerticalCubeFaceBorder(CubieFace.CUBIE_FACE_DIMENSION * 3
                                                                     + CubePrinter.BORDER_THICKNESS * 4));
    JLabel verticalBorder10 = new JLabel(new VerticalCubeFaceBorder(CubieFace.CUBIE_FACE_DIMENSION * 3
                                                                      + CubePrinter.BORDER_THICKNESS * 4));
    JLabel verticalBorder11 = new JLabel(new VerticalCubeFaceBorder(CubieFace.CUBIE_FACE_DIMENSION * 3
                                                                      + CubePrinter.BORDER_THICKNESS * 4));
    JLabel verticalBorder12 = new JLabel(new VerticalCubeFaceBorder(CubieFace.CUBIE_FACE_DIMENSION * 3
                                                                      + CubePrinter.BORDER_THICKNESS * 4));
    JLabel verticalBorder13 = new JLabel(new VerticalCubeFaceBorder(CubieFace.CUBIE_FACE_DIMENSION * 3
                                                                      + CubePrinter.BORDER_THICKNESS * 4));
    JLabel verticalBorder14 = new JLabel(new VerticalCubeFaceBorder(CubieFace.CUBIE_FACE_DIMENSION
                                                                      + CubePrinter.BORDER_THICKNESS * 2));
    JLabel verticalBorder15 = new JLabel(new VerticalCubeFaceBorder(CubieFace.CUBIE_FACE_DIMENSION
                                                                      + CubePrinter.BORDER_THICKNESS * 2));
    JLabel verticalBorder16 = new JLabel(new VerticalCubeFaceBorder(CubieFace.CUBIE_FACE_DIMENSION
                                                                      + CubePrinter.BORDER_THICKNESS * 2));
    JLabel verticalBorder17 = new JLabel(new VerticalCubeFaceBorder(CubieFace.CUBIE_FACE_DIMENSION
                                                                      + CubePrinter.BORDER_THICKNESS * 2));
    JLabel verticalBorder18 = new JLabel(new VerticalCubeFaceBorder(CubieFace.CUBIE_FACE_DIMENSION
                                                                      + CubePrinter.BORDER_THICKNESS * 2));
    JLabel verticalBorder19 = new JLabel(new VerticalCubeFaceBorder(CubieFace.CUBIE_FACE_DIMENSION
                                                                      + CubePrinter.BORDER_THICKNESS * 2));
    JLabel verticalBorder20 = new JLabel(new VerticalCubeFaceBorder(CubieFace.CUBIE_FACE_DIMENSION
                                                                      + CubePrinter.BORDER_THICKNESS * 2));
    JLabel verticalBorder21 = new JLabel(new VerticalCubeFaceBorder(CubieFace.CUBIE_FACE_DIMENSION
                                                                      + CubePrinter.BORDER_THICKNESS * 2));
    JLabel verticalBorder22 = new JLabel(new VerticalCubeFaceBorder(CubieFace.CUBIE_FACE_DIMENSION
                                                                      + CubePrinter.BORDER_THICKNESS * 2));
    JLabel verticalBorder23 = new JLabel(new VerticalCubeFaceBorder(CubieFace.CUBIE_FACE_DIMENSION
                                                                      + CubePrinter.BORDER_THICKNESS * 2));
    JLabel verticalBorder24 = new JLabel(new VerticalCubeFaceBorder(CubieFace.CUBIE_FACE_DIMENSION
                                                                      + CubePrinter.BORDER_THICKNESS * 2));
    JLabel verticalBorder25 = new JLabel(new VerticalCubeFaceBorder(CubieFace.CUBIE_FACE_DIMENSION
                                                                      + CubePrinter.BORDER_THICKNESS * 2));
    
    final JLabel blue = new JLabel(CubieFace.B5);
    final JLabel green = new JLabel(CubieFace.G5);
    final JLabel orange = new JLabel(CubieFace.O5);
    final JLabel red = new JLabel(CubieFace.R5);
    final JLabel white = new JLabel(CubieFace.W5);
    final JLabel yellow = new JLabel(CubieFace.Y5);
    
    blue.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        setColorSelected();
        selectedColor = Color.BLUE;
      }
    });
    
    green.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        setColorSelected();
        selectedColor = Color.GREEN;
      }
    });
    
    orange.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        setColorSelected();
        selectedColor = Color.ORANGE;
      }
    });
    
    red.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        setColorSelected();
        selectedColor = Color.RED;
      }
    });
    
    white.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        setColorSelected();
        selectedColor = Color.WHITE;
      }
    });
    
    yellow.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        setColorSelected();
        selectedColor = Color.YELLOW;
      }
    });
    
    JButton creationButton = new JButton("Create cube");
    creationButton.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (cubeFullyColored()){
          try{
            cubeFromImage();
            CubePrinter p = new CubePrinter(cube);
            cubeDisplayFrame.dispose();
            p.displayCube("Here is the cube you created.");
          }
          catch (NullPointerException npe){
            System.out.println("You tried to create an invalid cube.");
            System.out.println("You may have colored in the diagram incorrectly.");
          }
        }
        else{
          System.out.println("You haven't finished filling in the cube!");
        }
      }
    });
    
    JButton standard = new JButton("Standard cube");
    standard.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        cube = new CubeOfRubik3();
        CubePrinter p = new CubePrinter(cube);
        cubeDisplayFrame.dispose();
        p.displayCube("Here is a cube in the standard initial position.");
      }
    });
                                     
    creationButtonBox.add(creationButton);
    creationButtonBox.add(Box.createVerticalStrut(40));
    creationButtonBox.add(standard);
    
    Component leftSpace = Box.createHorizontalStrut(60);
    Component centerSpace = Box.createHorizontalStrut(60);
    Component rightSpace = Box.createHorizontalStrut(60);
    
    Component choiceSeparator1 = Box.createVerticalStrut(28);
    choiceSeparator1.setMaximumSize(new Dimension(CubieFace.CUBIE_FACE_DIMENSION + CubePrinter.BORDER_THICKNESS * 2,
                                                  28));
    Component choiceSeparator2 = Box.createVerticalStrut(28);
    choiceSeparator2.setMaximumSize(new Dimension(CubieFace.CUBIE_FACE_DIMENSION + CubePrinter.BORDER_THICKNESS * 2,
                                                  28));
    Component choiceSeparator3 = Box.createVerticalStrut(28);
    choiceSeparator3.setMaximumSize(new Dimension(CubieFace.CUBIE_FACE_DIMENSION + CubePrinter.BORDER_THICKNESS * 2,
                                                  28));
    Component choiceSeparator4 = Box.createVerticalStrut(28);
    choiceSeparator4.setMaximumSize(new Dimension(CubieFace.CUBIE_FACE_DIMENSION + CubePrinter.BORDER_THICKNESS * 2,
                                                  28));
    Component choiceSeparator5 = Box.createVerticalStrut(28);
    choiceSeparator5.setMaximumSize(new Dimension(CubieFace.CUBIE_FACE_DIMENSION + CubePrinter.BORDER_THICKNESS * 2,
                                                  28));
    
    Component leftChoiceBordersSeparator1 = Box.createVerticalStrut(28);
    leftChoiceBordersSeparator1.setMaximumSize(new Dimension(CubePrinter.BORDER_THICKNESS, 28));
    Component leftChoiceBordersSeparator2 = Box.createVerticalStrut(28);
    leftChoiceBordersSeparator2.setMaximumSize(new Dimension(CubePrinter.BORDER_THICKNESS, 28));
    Component leftChoiceBordersSeparator3 = Box.createVerticalStrut(28);
    leftChoiceBordersSeparator3.setMaximumSize(new Dimension(CubePrinter.BORDER_THICKNESS, 28));
    Component leftChoiceBordersSeparator4 = Box.createVerticalStrut(28);
    leftChoiceBordersSeparator4.setMaximumSize(new Dimension(CubePrinter.BORDER_THICKNESS, 28));
    Component leftChoiceBordersSeparator5 = Box.createVerticalStrut(28);
    leftChoiceBordersSeparator5.setMaximumSize(new Dimension(CubePrinter.BORDER_THICKNESS, 28));
    
    Component rightChoiceBordersSeparator1 = Box.createVerticalStrut(28);
    rightChoiceBordersSeparator1.setMaximumSize(new Dimension(CubePrinter.BORDER_THICKNESS, 28));
    Component rightChoiceBordersSeparator2 = Box.createVerticalStrut(28);
    rightChoiceBordersSeparator2.setMaximumSize(new Dimension(CubePrinter.BORDER_THICKNESS, 28));
    Component rightChoiceBordersSeparator3 = Box.createVerticalStrut(28);
    rightChoiceBordersSeparator3.setMaximumSize(new Dimension(CubePrinter.BORDER_THICKNESS, 28));
    Component rightChoiceBordersSeparator4 = Box.createVerticalStrut(28);
    rightChoiceBordersSeparator4.setMaximumSize(new Dimension(CubePrinter.BORDER_THICKNESS, 28));
    Component rightChoiceBordersSeparator5 = Box.createVerticalStrut(28);
    rightChoiceBordersSeparator5.setMaximumSize(new Dimension(CubePrinter.BORDER_THICKNESS, 28));
    
    Component glue1 = Box.createHorizontalGlue();
    Component glue2 = Box.createHorizontalGlue();
    
    lb.add(horizontalBorder1);
    lb.add(l1);
    lb.add(horizontalBorder2);
    lb.add(l4);
    lb.add(horizontalBorder3);
    lb.add(l7);
    lb.add(horizontalBorder4);
    l.add(horizontalBorder5);
    l.add(l2);
    l.add(horizontalBorder6);
    l.add(l5);
    l.add(horizontalBorder7);
    l.add(l8);
    l.add(horizontalBorder8);
    lf.add(horizontalBorder9);
    lf.add(l3);
    lf.add(horizontalBorder10);
    lf.add(l6);
    lf.add(horizontalBorder11);
    lf.add(l9);
    lf.add(horizontalBorder12);
    ufdl.add(horizontalBorder13);
    ufdl.add(u1);
    ufdl.add(horizontalBorder14);
    ufdl.add(u4);
    ufdl.add(horizontalBorder15);
    ufdl.add(u7);
    ufdl.add(horizontalBorder16);
    ufdl.add(f1);
    ufdl.add(horizontalBorder17);
    ufdl.add(f4);
    ufdl.add(horizontalBorder18);
    ufdl.add(f7);
    ufdl.add(horizontalBorder19);
    ufdl.add(d1);
    ufdl.add(horizontalBorder20);
    ufdl.add(d4);
    ufdl.add(horizontalBorder21);
    ufdl.add(d7);
    ufdl.add(horizontalBorder22);
    ufd.add(horizontalBorder23);
    ufd.add(u2);
    ufd.add(horizontalBorder24);
    ufd.add(u5);
    ufd.add(horizontalBorder25);
    ufd.add(u8);
    ufd.add(horizontalBorder26);
    ufd.add(f2);
    ufd.add(horizontalBorder27);
    ufd.add(f5);
    ufd.add(horizontalBorder28);
    ufd.add(f8);
    ufd.add(horizontalBorder29);
    ufd.add(d2);
    ufd.add(horizontalBorder30);
    ufd.add(d5);
    ufd.add(horizontalBorder31);
    ufd.add(d8);
    ufd.add(horizontalBorder32);
    ufdr.add(horizontalBorder33);
    ufdr.add(u3);
    ufdr.add(horizontalBorder34);
    ufdr.add(u6);
    ufdr.add(horizontalBorder35);
    ufdr.add(u9);
    ufdr.add(horizontalBorder36);
    ufdr.add(f3);
    ufdr.add(horizontalBorder37);
    ufdr.add(f6);
    ufdr.add(horizontalBorder38);
    ufdr.add(f9);
    ufdr.add(horizontalBorder39);
    ufdr.add(d3);
    ufdr.add(horizontalBorder40);
    ufdr.add(d6);
    ufdr.add(horizontalBorder41);
    ufdr.add(d9);
    ufdr.add(horizontalBorder42);
    rf.add(horizontalBorder43);
    rf.add(r1);
    rf.add(horizontalBorder44);
    rf.add(r4);
    rf.add(horizontalBorder45);
    rf.add(r7);
    rf.add(horizontalBorder46);
    r.add(horizontalBorder47);
    r.add(r2);
    r.add(horizontalBorder48);
    r.add(r5);
    r.add(horizontalBorder49);
    r.add(r8);
    r.add(horizontalBorder50);
    rb.add(horizontalBorder51);
    rb.add(r3);
    rb.add(horizontalBorder52);
    rb.add(r6);
    rb.add(horizontalBorder53);
    rb.add(r9);
    rb.add(horizontalBorder54);
    br.add(horizontalBorder55);
    br.add(b1);
    br.add(horizontalBorder56);
    br.add(b4);
    br.add(horizontalBorder57);
    br.add(b7);
    br.add(horizontalBorder58);
    b.add(horizontalBorder59);
    b.add(b2);
    b.add(horizontalBorder60);
    b.add(b5);
    b.add(horizontalBorder61);
    b.add(b8);
    b.add(horizontalBorder62);
    bl.add(horizontalBorder63);
    bl.add(b3);
    bl.add(horizontalBorder64);
    bl.add(b6);
    bl.add(horizontalBorder65);
    bl.add(b9);
    bl.add(horizontalBorder66);
    
    colorChoices.add(horizontalBorder67);
    colorChoices.add(blue);
    colorChoices.add(horizontalBorder68);
    colorChoices.add(choiceSeparator1);
    colorChoices.add(horizontalBorder69);
    colorChoices.add(green);
    colorChoices.add(horizontalBorder70);
    colorChoices.add(choiceSeparator2);
    colorChoices.add(horizontalBorder71);
    colorChoices.add(orange);
    colorChoices.add(horizontalBorder72);
    colorChoices.add(choiceSeparator3);
    colorChoices.add(horizontalBorder73);
    colorChoices.add(red);
    colorChoices.add(horizontalBorder74);
    colorChoices.add(choiceSeparator4);
    colorChoices.add(horizontalBorder75);
    colorChoices.add(white);
    colorChoices.add(horizontalBorder76);
    colorChoices.add(choiceSeparator5);
    colorChoices.add(horizontalBorder77);
    colorChoices.add(yellow);
    colorChoices.add(horizontalBorder78);
    
    leftColorChoicesBorders.add(verticalBorder14);
    leftColorChoicesBorders.add(leftChoiceBordersSeparator1);
    leftColorChoicesBorders.add(verticalBorder15);
    leftColorChoicesBorders.add(leftChoiceBordersSeparator2);
    leftColorChoicesBorders.add(verticalBorder16);
    leftColorChoicesBorders.add(leftChoiceBordersSeparator3);
    leftColorChoicesBorders.add(verticalBorder17);
    leftColorChoicesBorders.add(leftChoiceBordersSeparator4);
    leftColorChoicesBorders.add(verticalBorder18);
    leftColorChoicesBorders.add(leftChoiceBordersSeparator5);
    leftColorChoicesBorders.add(verticalBorder19);
    
    rightColorChoicesBorders.add(verticalBorder20);
    rightColorChoicesBorders.add(rightChoiceBordersSeparator1);
    rightColorChoicesBorders.add(verticalBorder21);
    rightColorChoicesBorders.add(rightChoiceBordersSeparator2);
    rightColorChoicesBorders.add(verticalBorder22);
    rightColorChoicesBorders.add(rightChoiceBordersSeparator3);
    rightColorChoicesBorders.add(verticalBorder23);
    rightColorChoicesBorders.add(rightChoiceBordersSeparator4);
    rightColorChoicesBorders.add(verticalBorder24);
    rightColorChoicesBorders.add(rightChoiceBordersSeparator5);
    rightColorChoicesBorders.add(verticalBorder25);
    
    cubeDisplayFrame.getContentPane().add(glue1);
    cubeDisplayFrame.getContentPane().add(leftSpace);
    cubeDisplayFrame.getContentPane().add(verticalBorder1);
    cubeDisplayFrame.getContentPane().add(lb);
    cubeDisplayFrame.getContentPane().add(verticalBorder2);
    cubeDisplayFrame.getContentPane().add(l);
    cubeDisplayFrame.getContentPane().add(verticalBorder3);
    cubeDisplayFrame.getContentPane().add(lf);
    cubeDisplayFrame.getContentPane().add(verticalBorder4);
    cubeDisplayFrame.getContentPane().add(ufdl);
    cubeDisplayFrame.getContentPane().add(verticalBorder5);
    cubeDisplayFrame.getContentPane().add(ufd);
    cubeDisplayFrame.getContentPane().add(verticalBorder6);
    cubeDisplayFrame.getContentPane().add(ufdr);
    cubeDisplayFrame.getContentPane().add(verticalBorder7);
    cubeDisplayFrame.getContentPane().add(rf);
    cubeDisplayFrame.getContentPane().add(verticalBorder8);
    cubeDisplayFrame.getContentPane().add(r);
    cubeDisplayFrame.getContentPane().add(verticalBorder9);
    cubeDisplayFrame.getContentPane().add(rb);
    cubeDisplayFrame.getContentPane().add(verticalBorder10);
    cubeDisplayFrame.getContentPane().add(br);
    cubeDisplayFrame.getContentPane().add(verticalBorder11);
    cubeDisplayFrame.getContentPane().add(b);
    cubeDisplayFrame.getContentPane().add(verticalBorder12);
    cubeDisplayFrame.getContentPane().add(bl);
    cubeDisplayFrame.getContentPane().add(verticalBorder13);
    cubeDisplayFrame.getContentPane().add(centerSpace);
    cubeDisplayFrame.getContentPane().add(leftColorChoicesBorders);
    cubeDisplayFrame.getContentPane().add(colorChoices);
    cubeDisplayFrame.getContentPane().add(rightColorChoicesBorders);
    cubeDisplayFrame.getContentPane().add(rightSpace);
    cubeDisplayFrame.getContentPane().add(creationButtonBox);
    cubeDisplayFrame.getContentPane().add(glue2);
    
    cubeDisplayFrame.pack();
    cubeDisplayFrame.setVisible(true);
  }
    
  private void setColorSelected(){
    colorSelected = true;
  }
  private void clearColorSelected(){
    colorSelected = false;
  }
  
  public boolean mouseInNonCentralCubies(){
    if (mouseInNonCentralCubies[0] || mouseInNonCentralCubies[1] || mouseInNonCentralCubies[2] ||
        mouseInNonCentralCubies[3] || mouseInNonCentralCubies[4] || mouseInNonCentralCubies[5] ||
        mouseInNonCentralCubies[6] || mouseInNonCentralCubies[7] || mouseInNonCentralCubies[8] ||
        mouseInNonCentralCubies[9] || mouseInNonCentralCubies[10] || mouseInNonCentralCubies[11] ||
        mouseInNonCentralCubies[12] || mouseInNonCentralCubies[13] || mouseInNonCentralCubies[14] ||
        mouseInNonCentralCubies[15] || mouseInNonCentralCubies[16] || mouseInNonCentralCubies[17] ||
        mouseInNonCentralCubies[18] || mouseInNonCentralCubies[19] || mouseInNonCentralCubies[20] ||
        mouseInNonCentralCubies[21] || mouseInNonCentralCubies[22] || mouseInNonCentralCubies[23] ||
        mouseInNonCentralCubies[24] || mouseInNonCentralCubies[25] || mouseInNonCentralCubies[26] ||
        mouseInNonCentralCubies[27] || mouseInNonCentralCubies[28] || mouseInNonCentralCubies[29] ||
        mouseInNonCentralCubies[30] || mouseInNonCentralCubies[31] || mouseInNonCentralCubies[32] ||
        mouseInNonCentralCubies[33] || mouseInNonCentralCubies[34] || mouseInNonCentralCubies[35] ||
        mouseInNonCentralCubies[36] || mouseInNonCentralCubies[37] || mouseInNonCentralCubies[38] ||
        mouseInNonCentralCubies[39] || mouseInNonCentralCubies[40] || mouseInNonCentralCubies[41] ||
        mouseInNonCentralCubies[42] || mouseInNonCentralCubies[43] || mouseInNonCentralCubies[44] ||
        mouseInNonCentralCubies[45] || mouseInNonCentralCubies[47] || mouseInNonCentralCubies[47]){
      return true;
    }
    else{
      return false;
    }
  }
  
  public void cubeFromImage(){
    cube = new CubeOfRubik3(CubeColor.getCubeColor(getIcon(f2).getColor()),
    CubeColor.getCubeColor(getIcon(u8).getColor()),
    CubeColor.getCubeColor(getIcon(f6).getColor()),
    CubeColor.getCubeColor(getIcon(r4).getColor()),
    CubeColor.getCubeColor(getIcon(f8).getColor()),
    CubeColor.getCubeColor(getIcon(d2).getColor()),
    CubeColor.getCubeColor(getIcon(f4).getColor()),
    CubeColor.getCubeColor(getIcon(l6).getColor()),
    CubeColor.getCubeColor(getIcon(u4).getColor()),
    CubeColor.getCubeColor(getIcon(l2).getColor()),
    CubeColor.getCubeColor(getIcon(u6).getColor()),
    CubeColor.getCubeColor(getIcon(r2).getColor()),                        
    CubeColor.getCubeColor(getIcon(r8).getColor()),
    CubeColor.getCubeColor(getIcon(d6).getColor()),
    CubeColor.getCubeColor(getIcon(d4).getColor()),
    CubeColor.getCubeColor(getIcon(l8).getColor()),
    CubeColor.getCubeColor(getIcon(u2).getColor()),
    CubeColor.getCubeColor(getIcon(b2).getColor()),
    CubeColor.getCubeColor(getIcon(r6).getColor()),
    CubeColor.getCubeColor(getIcon(b4).getColor()),
    CubeColor.getCubeColor(getIcon(b8).getColor()),
    CubeColor.getCubeColor(getIcon(d8).getColor()),
    CubeColor.getCubeColor(getIcon(b6).getColor()),
    CubeColor.getCubeColor(getIcon(l4).getColor()),
    CubeColor.getCubeColor(getIcon(f3).getColor()),
    CubeColor.getCubeColor(getIcon(u9).getColor()),
    CubeColor.getCubeColor(getIcon(r1).getColor()),
    CubeColor.getCubeColor(getIcon(f9).getColor()),
    CubeColor.getCubeColor(getIcon(r7).getColor()),
    CubeColor.getCubeColor(getIcon(d3).getColor()),
    CubeColor.getCubeColor(getIcon(f7).getColor()),
    CubeColor.getCubeColor(getIcon(d1).getColor()),
    CubeColor.getCubeColor(getIcon(l9).getColor()),
    CubeColor.getCubeColor(getIcon(f1).getColor()),
    CubeColor.getCubeColor(getIcon(l3).getColor()),
    CubeColor.getCubeColor(getIcon(u7).getColor()),
    CubeColor.getCubeColor(getIcon(u3).getColor()),
    CubeColor.getCubeColor(getIcon(b1).getColor()),
    CubeColor.getCubeColor(getIcon(r3).getColor()),
    CubeColor.getCubeColor(getIcon(r9).getColor()),
    CubeColor.getCubeColor(getIcon(b7).getColor()),
    CubeColor.getCubeColor(getIcon(d9).getColor()),
    CubeColor.getCubeColor(getIcon(b9).getColor()),
    CubeColor.getCubeColor(getIcon(l7).getColor()),
    CubeColor.getCubeColor(getIcon(d7).getColor()),
    CubeColor.getCubeColor(getIcon(u1).getColor()),
    CubeColor.getCubeColor(getIcon(l1).getColor()),
    CubeColor.getCubeColor(getIcon(b3).getColor()));
  }
  
  public CubeOfRubik3 getCube(){
    return cube;
  }
  
  public boolean cubeFullyColored(){
    if (getIcon(u1).getColor() == Color.GRAY ||
        getIcon(u2).getColor() == Color.GRAY ||
        getIcon(u3).getColor() == Color.GRAY ||
        getIcon(u4).getColor() == Color.GRAY ||
        getIcon(u6).getColor() == Color.GRAY ||
        getIcon(u7).getColor() == Color.GRAY ||
        getIcon(u8).getColor() == Color.GRAY ||
        getIcon(u9).getColor() == Color.GRAY ||
        getIcon(f1).getColor() == Color.GRAY ||
        getIcon(f2).getColor() == Color.GRAY ||
        getIcon(f3).getColor() == Color.GRAY ||
        getIcon(f4).getColor() == Color.GRAY ||
        getIcon(f6).getColor() == Color.GRAY ||
        getIcon(f7).getColor() == Color.GRAY ||
        getIcon(f8).getColor() == Color.GRAY ||
        getIcon(f9).getColor() == Color.GRAY ||
        getIcon(l1).getColor() == Color.GRAY ||
        getIcon(l2).getColor() == Color.GRAY ||
        getIcon(l3).getColor() == Color.GRAY ||
        getIcon(l4).getColor() == Color.GRAY ||
        getIcon(l6).getColor() == Color.GRAY ||
        getIcon(l7).getColor() == Color.GRAY ||
        getIcon(l8).getColor() == Color.GRAY ||
        getIcon(l9).getColor() == Color.GRAY ||
        getIcon(d1).getColor() == Color.GRAY ||
        getIcon(d2).getColor() == Color.GRAY ||
        getIcon(d3).getColor() == Color.GRAY ||
        getIcon(d4).getColor() == Color.GRAY ||
        getIcon(d6).getColor() == Color.GRAY ||
        getIcon(d7).getColor() == Color.GRAY ||
        getIcon(d8).getColor() == Color.GRAY ||
        getIcon(d9).getColor() == Color.GRAY ||
        getIcon(r1).getColor() == Color.GRAY ||
        getIcon(r2).getColor() == Color.GRAY ||
        getIcon(r3).getColor() == Color.GRAY ||
        getIcon(r4).getColor() == Color.GRAY ||
        getIcon(r6).getColor() == Color.GRAY ||
        getIcon(r7).getColor() == Color.GRAY ||
        getIcon(r8).getColor() == Color.GRAY ||
        getIcon(r9).getColor() == Color.GRAY ||
        getIcon(b1).getColor() == Color.GRAY ||
        getIcon(b2).getColor() == Color.GRAY ||
        getIcon(b3).getColor() == Color.GRAY ||
        getIcon(b4).getColor() == Color.GRAY ||
        getIcon(b6).getColor() == Color.GRAY ||
        getIcon(b7).getColor() == Color.GRAY ||
        getIcon(b8).getColor() == Color.GRAY ||
        getIcon(b9).getColor() == Color.GRAY){
      return false;
    }
    else{
      return true;
    }        
  }
}