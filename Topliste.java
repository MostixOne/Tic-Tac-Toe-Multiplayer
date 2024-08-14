import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 07.11.2019
 * @author 
 */

public class Topliste extends JFrame {
  // Anfang Attribute
  private Connection verbindung = null;
  private String db = "jdbc:mysql://localhost/tic_tac_toe";
  private String user = "root";
  private String pw = "";  
  private JList Toplist = new JList<>();
    private DefaultListModel ToplistModel = new DefaultListModel();
    private JScrollPane ToplistScrollPane = new JScrollPane(Toplist);
  // Ende Attribute
  
  public Topliste() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 436; 
    int frameHeight = 378;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Topliste");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    Toplist.setModel(ToplistModel);
    ToplistScrollPane.setBounds(2, 3, 420, 340);
    cp.add(ToplistScrollPane);
    // Ende Komponenten
    
    setVisible(true);
    DB_auslesen();
  } // end of public Topliste
  
  // Anfang Methoden
 
  //////////////////////////////////////
  public static void main(String[] args) {
    new Topliste();
    
  } // end of main
  public void DB_auslesen() {
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
      String sql = "SELECT * FROM toplist order by Punkte desc";
      ResultSet ergebnis = stm.executeQuery(sql);
      ToplistModel.clear();
      // Ergebnis drucken
      int Platz = 0 ;
      String Name;
      String Punkte;
      ToplistModel.clear(); 
      //reparedStmt.execute();                                                           
      //jTextArea1.setText("");
      while (ergebnis.next() == true) {
        Platz++;
        Name = ergebnis.getString("name");
        Punkte = ergebnis.getString("Punkte");
        ToplistModel.addElement("<<Platz :"+Platz+" >>     <<  Name : "+Name+ ">>     << Credits :"  +Punkte+ ">>" );
      }
      verbindung.close();
    }
    catch (Exception e) {
      System.err.println("DB  nix" + e.getMessage());
      ToplistModel.addElement(e.getMessage());
    } 
  }
  // Ende Methoden
} // end of class Topliste

