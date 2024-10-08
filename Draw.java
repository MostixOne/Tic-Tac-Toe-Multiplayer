

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.BasicStroke;

import javax.swing.JLabel;

public class Draw extends JLabel {

  
  protected static boolean debug = false;    
  protected static int getPosX;
  protected static int getPosY;
  public void paintComponent(Graphics g) {
    
    super.paintComponent(g);

    Graphics2D g2d = (Graphics2D) g;
    
  
    
    // draw///
    
    //g.setColor(new Color(66, 206, 245));   // Hintergrund farbe
    //g.fillRect(0, 0, 800, 541);
    
    g.setColor(Color.RED);    //Line farben
    g2d.setStroke(new BasicStroke(5));
    // Vertikal
    
    g.drawLine(425, 50, 425, 500);
    g.drawLine(575, 50, 575, 500);
    
    // Horizontal
    
    g.drawLine(275, 200, 725, 200);
    g.drawLine(275, 350, 725, 350);
    g2d.draw3DRect(SpielFenster.posX[0] , SpielFenster.posX[8],SpielFenster.posY[0],SpielFenster.posY[8],true);
    
    //drawImage(Bild datei, x, y, bild Breite,bild H�he, NULL);
    //status[0],status[1],status[2] 1.Spalte
    //status[3],status[4],status[5] 2.Spalte
    //status[6],status[7],status[8] 3.Spalte
    if (SpielFenster.status[0] == 1) {
      g.drawImage(ImageLoader.bx,SpielFenster.posX[0],SpielFenster.posY[0], 150, 150, null);
      getPosX = SpielFenster.posX[0];
      getPosY = SpielFenster.posY[0];
      if (debug == true) {
        System.out.println("PosX: "+SpielFenster.posX[0]+ " PosY: "+SpielFenster.posY[0]);
      }
      
    } else if (SpielFenster.status[0] == 2) {
      
      g.drawImage(ImageLoader.bo,SpielFenster.posX[0],SpielFenster.posY[0], 150, 150, null);
      getPosX = SpielFenster.posX[0];
      getPosY = SpielFenster.posY[0];
      if (debug == true) {
        System.out.println("PosX: "+SpielFenster.posX[0]+ " PosY: "+SpielFenster.posY[0]);
      }
    }
    
    if (SpielFenster.status[1] == 1) {
      g.drawImage(ImageLoader.bx,SpielFenster.posX[1],SpielFenster.posY[1], 150, 150, null);
      getPosX = SpielFenster.posX[1];
      getPosY = SpielFenster.posY[1];
      if (debug == true) {      
        System.out.println("PosX: "+SpielFenster.posX[1]+ " PosY: "+SpielFenster.posY[1]);
      }                 
    } else if (SpielFenster.status[1] == 2) {
      
      g.drawImage(ImageLoader.bo,SpielFenster.posX[1],SpielFenster.posY[1], 150, 150, null);
      getPosX = SpielFenster.posX[1];
      getPosY = SpielFenster.posY[1];
      if (debug == true) {
        System.out.println("PosX: "+SpielFenster.posX[1]+ " PosY: "+SpielFenster.posY[1]);
      }
      
    }
    
    if (SpielFenster.status[2] == 1) {
      g.drawImage(ImageLoader.bx,SpielFenster.posX[2],SpielFenster.posY[2], 150, 150, null);
      getPosX = SpielFenster.posX[2];
      getPosY = SpielFenster.posY[2];
      if (debug == true) {
        System.out.println("PosX: "+SpielFenster.posX[2]+ " PosY: "+SpielFenster.posY[2]);
      }
    } else if (SpielFenster.status[2] == 2) {
      g.drawImage(ImageLoader.bo,SpielFenster.posX[2],SpielFenster.posY[2], 150, 150, null);
      getPosX = SpielFenster.posX[2];
      getPosY = SpielFenster.posY[2];
      if (debug == true) {
        System.out.println("PosX: "+SpielFenster.posX[2]+ " PosY: "+SpielFenster.posY[2]);
      }
      
    }
    
    if (SpielFenster.status[3] == 1) {
      g.drawImage(ImageLoader.bx,SpielFenster.posX[3],SpielFenster.posY[3], 150, 150, null);
      getPosX = SpielFenster.posX[3];
      getPosY = SpielFenster.posY[3];
      if (debug == true) {
        System.out.println("PosX: "+SpielFenster.posX[3]+ " PosY: "+SpielFenster.posY[3]);
      }
    } else if (SpielFenster.status[3] == 2) {
      getPosX = SpielFenster.posX[3];
      getPosY = SpielFenster.posY[3];
      g.drawImage(ImageLoader.bo,SpielFenster.posX[3],SpielFenster.posY[3], 150, 150, null);
      if (debug == true) {
        System.out.println("PosX: "+SpielFenster.posX[3]+ " PosY: "+SpielFenster.posY[3]);
      }
      
    }
    
    if (SpielFenster.status[4] == 1) {
      g.drawImage(ImageLoader.bx,SpielFenster.posX[4],SpielFenster.posY[4], 150, 150, null);
      getPosX = SpielFenster.posX[4];
      getPosY = SpielFenster.posY[4];
      if (debug == true) {
        System.out.println("PosX: "+SpielFenster.posX[4]+ " PosY: "+SpielFenster.posY[4]);
      }
    } else if (SpielFenster.status[4] == 2) {
      g.drawImage(ImageLoader.bo,SpielFenster.posX[4],SpielFenster.posY[4], 150, 150, null);
      getPosX = SpielFenster.posX[4];
      getPosY = SpielFenster.posY[4];
      if (debug == true) {
        System.out.println("PosX: "+SpielFenster.posX[4]+ " PosY: "+SpielFenster.posY[4]);
      }     
      
    }
    
    if (SpielFenster.status[5] == 1) {
      g.drawImage(ImageLoader.bx,SpielFenster.posX[5],SpielFenster.posY[5], 150, 150, null);
      getPosX = SpielFenster.posX[5];
      getPosY = SpielFenster.posY[5];
      if (debug == true) {
        System.out.println("PosX: "+SpielFenster.posX[5]+ " PosY: "+SpielFenster.posY[5]);
      }
    } else if (SpielFenster.status[5] == 2) {
      g.drawImage(ImageLoader.bo,SpielFenster.posX[5],SpielFenster.posY[5], 150, 150, null);
      getPosX = SpielFenster.posX[5];
      getPosY = SpielFenster.posY[5];
      if (debug == true) {
        System.out.println("PosX: "+SpielFenster.posX[5]+ " PosY: "+SpielFenster.posY[5]);
      }
      
    }
    
    if (SpielFenster.status[6] == 1) {
      g.drawImage(ImageLoader.bx,SpielFenster.posX[6],SpielFenster.posY[6], 150, 150, null);
      getPosX = SpielFenster.posX[6];
      getPosY = SpielFenster.posY[6];
      if (debug == true) {
        System.out.println("PosX: "+SpielFenster.posX[6]+ " PosY: "+SpielFenster.posY[6]);
      }
    } else if (SpielFenster.status[6] == 2) {
      g.drawImage(ImageLoader.bo,SpielFenster.posX[6],SpielFenster.posY[6], 150, 150, null);
      getPosX = SpielFenster.posX[6];
      getPosY = SpielFenster.posY[6];
      if (debug == true) {
        System.out.println("PosX: "+SpielFenster.posX[6]+ " PosY: "+SpielFenster.posY[6]);
      }
      
    }
    
    if (SpielFenster.status[7] == 1) {
      g.drawImage(ImageLoader.bx,SpielFenster.posX[7],SpielFenster.posY[7], 150, 150, null);
      getPosX = SpielFenster.posX[7];
      getPosY = SpielFenster.posY[7];
      if (debug == true) {
        System.out.println("PosX: "+SpielFenster.posX[7]+ " PosY: "+SpielFenster.posY[7]);
      }
    } else if (SpielFenster.status[7] == 2) {
      g.drawImage(ImageLoader.bo,SpielFenster.posX[7],SpielFenster.posY[7], 150, 150, null);
      if (debug == true) {
        System.out.println("PosX: "+SpielFenster.posX[7]+ " PosY: "+SpielFenster.posY[7]);
      }
      
    }
    
    if (SpielFenster.status[8] == 1) {
      g.drawImage(ImageLoader.bx,SpielFenster.posX[8],SpielFenster.posY[8], 150, 150, null);
      getPosX = SpielFenster.posX[8];
      getPosY = SpielFenster.posY[8];
      if (debug == true) {
        System.out.println("PosX: "+SpielFenster.posX[8]+ " PosY: "+SpielFenster.posY[8]);
      }
    } else if (SpielFenster.status[8] == 2) {
      g.drawImage(ImageLoader.bo,SpielFenster.posX[8],SpielFenster.posY[8], 150, 150, null);
      getPosX = SpielFenster.posX[8];
      getPosY = SpielFenster.posY[8];
      if (debug == true) {
        System.out.println("PosX: "+SpielFenster.posX[8]+ " PosY: "+SpielFenster.posY[8]);
      }
      
    }
    repaint();
  }
}
