import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 07.11.2019
 * @author 
 */

public class DB_Erstellen extends JFrame {
  // Anfang Attribute
  private Connection verbindung = null;
  private String db = "jdbc:mysql://localhost/nordwind";
  private String user = "root";
  private String pw = "";  
  private String insert[] = new String [7];
  private String drop[] = new String [2];
  private JProgressBar Ladenbar = new JProgressBar();
  // Ende Attribute
  
  public DB_Erstellen() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 211; 
    int frameHeight = 96;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("DB_Erstellen");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    Ladenbar.setBounds(10, 13, 177, 33);
    Ladenbar.setStringPainted(true);
    cp.add(Ladenbar);
    // Ende Komponenten
    
    setVisible(true);
    test();
  } // end of public Topliste
  
  // Anfang Methoden
 
  //////////////////////////////////////
  public static void main(String[] args) {
    new DB_Erstellen();
    
  } // end of main
  public void test() {
    ///////////////////////////////////////
    try {
      // Treiber laden
      Class.forName("com.mysql.jdbc.Driver");
    }
    catch (Exception e) {
      System.err.println("Kann Treiber nicht laden: " + e);
    } 
    try {
      // Verbindung herstellen                                                 
      verbindung = DriverManager.getConnection(db, user, pw);
      
      // Query ausführen
      Statement stm = verbindung.createStatement();
      drop[0] = "DROP Database IF EXISTS `tic_tac_toe`;" ;
      drop[1] = "DROP TABLE IF EXISTS `toplist`;";
      String sql = "Create Database tic_tac_toe;";
      String use = "use tic_tac_toe";
      String table = "CREATE TABLE `toplist`  (`ID` int(11) NOT NULL AUTO_INCREMENT,`Name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,`Punkte` int(11) NULL DEFAULT NULL,`Credits` int(5) NULL DEFAULT NULL,PRIMARY KEY (`ID`) USING BTREE) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;";
      insert[0] = "INSERT INTO `toplist` VALUES ('1', 'Pascal', '25', '70')"; 
      insert[1] = "INSERT INTO `toplist` VALUES ('3', 'Luisa', '5', '50')"; 
      insert[2] = "INSERT INTO `toplist` VALUES ('4', 'Lisa', '-10', '-20')"; 
      insert[3] = "INSERT INTO `toplist` VALUES ('5', 'Koenig', '30', '80')"; 
      insert[4] = "INSERT INTO `toplist` VALUES ('6', 'Loewe', '15', '55')"; 
      insert[5] = "INSERT INTO `toplist` VALUES ('7', 'Petter', '-18', '-15')";
      insert[6] = "SET FOREIGN_KEY_CHECKS = 1;";
      for (int j =0 ;j<drop.length; j++) {
        stm.execute(drop[j]);  
      } 
      stm.execute(sql);
      stm.execute(use);
      stm.execute(table);
      for (int i =0 ;i<insert.length; i++) {
        stm.execute(insert[i]);  
      }
      // end of for
      Thread t1 = new Thread(new Laden());
      t1.start();
    }
    catch (Exception e) {
      System.err.println("DB  nix" + e.getMessage());
    } 
  }
  class Laden implements Runnable{

    public void run(){
      for (int i=0; i < 100; i++) {
        try {
          Thread.sleep(50); 
          
          Ladenbar.setValue(i+1);
          if (Ladenbar.getValue()==100) {
            JOptionPane.showMessageDialog(null,"Datenbank erfolgreich angelegt!","Erfolg!",JOptionPane.INFORMATION_MESSAGE);
            dispose();
          }
          
        } catch(Exception e) {
          System.out.println(e);                                     
        }  // end of try 
      }
    }
  }
  // Ende Methoden
} // end of class Topliste

