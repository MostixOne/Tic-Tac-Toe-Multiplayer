

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
  
  static Image bx, bo;

  public ImageLoader() {
    try {
      bx = ImageIO.read(new File("img/x.png"));  //Image "img/x.png"Laden
      bo = ImageIO.read(new File("img/o.png"));  //Image "img/o.png"Laden
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
