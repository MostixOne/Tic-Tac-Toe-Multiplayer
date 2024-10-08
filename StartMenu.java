import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


public class StartMenu extends JFrame {
  // Anfang Attribute
  private JButton bSpielStarten = new JButton();
  private JButton bTopliste = new JButton();
  private JButton bDatenbankerstellen = new JButton();
  private Connection verbindung = null;
  //Strings
  static String SP1;        //Spieler 1 
  static String SP2;        //Spieler 2
  protected static String db = "jdbc:mysql://localhost/tic_tac_toe";    // Pfad Zur Datenbank und Zum Host
  protected static String user = "root"; //User name von Dem Mysql Server
  protected static String pw = ""; //MYQL Server  "" = Kein passwort
  private String SP1Name= "Name Spieler 1";  // Inputdialog Text Spieler1
  private String SP2Name= "Name Spieler 2";  // Inputdialog Text Spieler2
  private int Wiederaufnehmen = 0;
  private JButton bMultiplayerServerStarten = new JButton();
  private JButton bMultiplayerClientStart = new JButton();
  private TimerTask task;
  private String hostx ="";//Leer lassen Wenn Localhost (Online nicht Getestet sollte aber auch gehen)
  protected static boolean Debug = false ;
  // Ende Attribute
  public StartMenu() {                                        
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 305; 
    int frameHeight = 321;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("StartMenu");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    
    bSpielStarten.setBounds(64, 16, 145, 33);
    bSpielStarten.setText("Spiel Starten");
    bSpielStarten.setMargin(new Insets(2, 2, 2, 2));
    bSpielStarten.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bSpielStarten_ActionPerformed(evt);
      }
    });
    cp.add(bSpielStarten);
    bTopliste.setBounds(64, 64, 145, 33);
    bTopliste.setText("Topliste");
    bTopliste.setMargin(new Insets(2, 2, 2, 2));
    bTopliste.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bTopliste_ActionPerformed(evt);
      }
    });
    cp.add(bTopliste);
    bDatenbankerstellen.setBounds(64, 112, 147, 33);
    bDatenbankerstellen.setText("Topliste:Credits");
    bDatenbankerstellen.setMargin(new Insets(2, 2, 2, 2));
    bDatenbankerstellen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bDatenbankerstellen_ActionPerformed(evt);
      }
    });
    bDatenbankerstellen.setText("Datenbank erstellen");
    cp.add(bDatenbankerstellen);
    
    setVisible(true);
    // Anfang Komponenten
    bMultiplayerServerStarten.setBounds(56, 160, 163, 33);
    bMultiplayerServerStarten.setText("Multiplayer Server Starten!");
    bMultiplayerServerStarten.setMargin(new Insets(2, 2, 2, 2));
    bMultiplayerServerStarten.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bMultiplayerServerStarten_ActionPerformed(evt);
      }
    });
    cp.add(bMultiplayerServerStarten);
    bMultiplayerClientStart.setBounds(64, 208, 147, 41);
    bMultiplayerClientStart.setText("Multiplayer Client Start");
    bMultiplayerClientStart.setMargin(new Insets(2, 2, 2, 2));
    bMultiplayerClientStart.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bMultiplayerClientStart_ActionPerformed(evt);
      }
    });
    cp.add(bMultiplayerClientStart);
    // Ende Komponenten
  } 
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new StartMenu();
  } 
  
  public void bSpielStarten_ActionPerformed(ActionEvent evt) {
    
    try {
      // Treiber laden
      Class.forName("com.mysql.jdbc.Driver");    
    }
    catch (Exception e) {
      System.err.println("Kann Treiber nicht laden: " + e);         //Feher ausgabe
    } 
    
    if (Wiederaufnehmen == 0) {
      SP1=JOptionPane.showInputDialog(SP1Name);    //Inputdialog anzeigen falls       Wiederaufnehmen ==0 ist
      SP2=JOptionPane.showInputDialog(SP2Name);   //Inputdialog anzeigen falls       Wiederaufnehmen ==0 ist  
    } // end of if
    
    
    
    try {
      if (SP1.isEmpty()==true && SP2.isEmpty()==true) {
        bSpielStarten_ActionPerformed(evt); 
      } 
        else if (SP1.isEmpty()==true || SP2.isEmpty()==true) {
          bSpielStarten_ActionPerformed(evt); 
        }
          else if (SP1.length() <=3 ) {
            SP1Name = "Name Spieler 1 muss mehr als 3 zeichen haben!!!!!!!!!!!!!";
            bSpielStarten_ActionPerformed(evt);  //actionPerformed(); Wieder aufrufen
            //System.out.println(SP1.length());
          }
            else if (SP2.length() <=3 ) {
              SP2Name = "Name Spieler 2 muss mehr als 3 zeichen haben!!!!!!!!!!!!!";
              bSpielStarten_ActionPerformed(evt);
            }
              else if (SP1.length() <=3 && SP2.length() <=3 ) {
                SP1Name = "Name Spieler 1 muss mehr als 3 zeichen haben!!!!!!!!!!!!!";
                SP2Name = "Name Spieler 2 muss mehr als 3 zeichen haben!!!!!!!!!!!!!";
                bSpielStarten_ActionPerformed(evt);
              }else if (SP1.equals(SP2)) {
                  bSpielStarten_ActionPerformed(evt);
                }
                  else if (SP1.length() >3 && SP2.length() >3){
                    
                    // end of if-else
                    try{
                      // Verbindung herstellen   
                      
                      verbindung = DriverManager.getConnection(db, user, pw);   // verbindung herstellen
                      int z1 = 0 ; 
                      int z2 = 0 ;
                      // Query ausf�hren
                      //////////////////////////////////////////// Leider muss man f�r Jede Query ein Eigenes Statement machen :( Java halt :D
                      Statement stmCount = verbindung.createStatement();
                      Statement stmCount2 = verbindung.createStatement();
                      Statement stmSqlRes = verbindung.createStatement();
                      Statement stmSqlRes2 = verbindung.createStatement();
                      
                      
                      //////////////////////////////////////////
                      String conut1 = "SELECT count(name) as z FROM toplist where name = '"+SP1+"'";
                      String sql = "SELECT name FROM toplist where name = '"+SP1+"'";
                      String erstellen1 = "INSERT INTO toplist (name,punkte,credits) Values ('"+SP1+"','0','50')";
                      ResultSet ergebnis = stmCount.executeQuery(conut1);
                      ResultSet SqlRes = stmSqlRes.executeQuery(sql);
                      String getNameSP1 ;
                      
                      
                      while (ergebnis.next()) {
                        z1 = ergebnis.getInt("z") ;
                      }
                      
                      
                      if (z1 == 0) {   //wenn keine ergebnisse
                        stmCount.execute(erstellen1) ;
                        JOptionPane.showMessageDialog(null, SP1 +" Deine Daten wurden Erstellt","Erfolgreich",JOptionPane.INFORMATION_MESSAGE);
                        
                      } else {
                        
                        while (SqlRes.next()) {
                          getNameSP1 = SqlRes.getString("name") ;
                          JOptionPane.showMessageDialog(null, getNameSP1 +" Deine Daten wurde geladen  ("+Coins.getCoins()+")","Erfolgreich",JOptionPane.INFORMATION_MESSAGE); 
                          
                          
                          
                        } 
                      }
                      ///////////////////////////////////////////////////////////////////////
                      String conut2 = "SELECT count(name) as z2 FROM toplist where name = '"+SP2+"'";
                      String sql2 = "SELECT name FROM toplist where name = '"+SP2+"'";
                      String erstellen2 = "INSERT INTO toplist (name,punkte,credits) Values ('"+SP2+"','0','50')";
                      ResultSet ergebnis2= stmCount.executeQuery(conut2);
                      ResultSet SqlRes2 = stmSqlRes2.executeQuery(sql2);
                      String getNameSP2;
                      while (ergebnis2.next()) {
                        z2 = ergebnis2.getInt("z2") ;
                      }           
                      if (z2 == 0) {   //wenn keine ergebniss
                        stmCount2.execute(erstellen2) ;   
                        JOptionPane.showMessageDialog(null,SP2 +" Deine Daten wurden Erstellt","Erfolgreich",JOptionPane.INFORMATION_MESSAGE);
                        
                      }else {
                        while (SqlRes2.next()) {
                          getNameSP2 = SqlRes2.getString("name") ;
                          JOptionPane.showMessageDialog(null, getNameSP2 +"Deine Daten wurde geladen","Erfolgreich",JOptionPane.INFORMATION_MESSAGE);
                          
                          
                        }
                        
                      }          
                      //////////////////////////////////////////////////////////////////
                      
                      
                      
                      bSpielStarten.setText("Spiel wiederaufnehmen"); 
                      Wiederaufnehmen = 1;                      
                      LoadInterface();
                      verbindung.close(); 
                      
                    }    
                    
                    
                    
                    catch (Exception e) {
                      System.out.println(e);
                      JOptionPane.showMessageDialog(null,"Fehler mit der Datenbank spiel konnte nicht Gestartet werden.....","Fehler",JOptionPane.ERROR_MESSAGE);
                      
                      
                    }
                    
                  }
    } catch(Exception e) {
      System.out.println(e);
    }
  }
  
  
  public void bTopliste_ActionPerformed(ActionEvent evt) {
    
    Topliste NTopliste = new Topliste();
  }
  
  public void bDatenbankerstellen_ActionPerformed(ActionEvent evt) {
    
    DB_Erstellen NDB = new DB_Erstellen();
  } 
  public void LoadInterface() {
    new SpielFenster();
    new ImageLoader();
    new Draw();
    new Coins();
    new checkGewinn();
  }
  public void bMultiplayerServerStarten_ActionPerformed(ActionEvent evt) {
    new FrameTicServer();
  } 
  
  public void bMultiplayerClientStart_ActionPerformed(ActionEvent evt) {
    /*
    Methode TicTacToeClient(serverAddress) eine Exception wirft (throws Exception).
    Im Timer musst du die Exception dann verarbeiten
    */
    
    Timer timer = new Timer();
    task = new TimerTask() {
      public void run() {
        try {
          while (true) {          
            
            String serverAddress = (hostx.isEmpty()) ? "localhost" : hostx;
            TicTacToeClient client = new TicTacToeClient(serverAddress);
            client.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            client.frame.setSize(800, 600);
            client.frame.setVisible(true);
            client.frame.setResizable(false);
            client.play();
            if (!client.newTry()) {
              break;
            }
            
          }
          timer.cancel();
          timer.purge();
          task.cancel();
          if (Debug) 
            System.out.println("L�uft");
        } catch (Exception e) {
          System.out.println("Exception caught: " + e);
          JOptionPane.showMessageDialog(null, "Host nicht Gefunden/Server Offline","Keine Verbindung",JOptionPane.ERROR_MESSAGE);
          timer.cancel();
          timer.purge();
          task.cancel();
        }
        if (Debug)
          System.out.println("Task completed");
        
      }
    };
    timer.schedule(task, 0, 1000);
    // 
  }
  
  
  
  // Ende Methoden
}
  
          
