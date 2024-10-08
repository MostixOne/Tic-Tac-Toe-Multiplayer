
import java.util.Timer;
import java.util.TimerTask;
import java.sql.*;
import javax.swing.JOptionPane;
public class checkGewinn {
  Timer time;
  protected static int points[] = new int [2]; //Variable zum Setzten der punkte
  protected static int gPoints = 5; //   Zugewinnende oder zuverlierende Punkte
  public checkGewinn() {
    time = new Timer();
    time.schedule(new TimerTask(){
      
      
      public void run() {
        
        if (SpielFenster.sieger == 0) {
          
          // Reihe 1 f�r X - Horizontal
          if (SpielFenster.status[0] == 1 && SpielFenster.status[1] == 1 && SpielFenster.status[2] == 1) {
            SpielFenster.sieger = 1;
            check();
            exchange();
          }
          // Reihe 2 f�r X - Horizontal
          else if (SpielFenster.status[3] == 1 && SpielFenster.status[4] == 1 && SpielFenster.status[5] == 1) {
            SpielFenster.sieger = 1;
            check();
            exchange();
          }
          
          // Reihe 3 f�r X - Horizontal
          else if (SpielFenster.status[6] == 1 && SpielFenster.status[7] == 1 && SpielFenster.status[8] == 1) {
            SpielFenster.sieger = 1;
            check();
            exchange();
          }
          
          // Reihe 1 f�r X - Vertikal
          else if (SpielFenster.status[0] == 1 && SpielFenster.status[3] == 1 && SpielFenster.status[6] == 1) {
            SpielFenster.sieger = 1;
            check();
            exchange();
          }
          
          // Reihe 2 f�r X - Vertikal
          else if (SpielFenster.status[1] == 1 && SpielFenster.status[4] == 1 && SpielFenster.status[7] == 1) {
            SpielFenster.sieger = 1;
            check();
            exchange();
          }
          
          // Reihe 3 f�r X - Vertikal
          else if (SpielFenster.status[2] == 1 && SpielFenster.status[5] == 1 && SpielFenster.status[8] == 1) {
            SpielFenster.sieger = 1;
            check();
            exchange();
          }
          
          // Diagonale links oben - rechts unten f�r X
          else if (SpielFenster.status[0] == 1 && SpielFenster.status[4] == 1 && SpielFenster.status[8] == 1) {
            SpielFenster.sieger = 1;
            check();
            exchange();
          }
          
          // Diagonale rechts oben - links unten f�r X
          else if (SpielFenster.status[2] == 1 && SpielFenster.status[4] == 1 && SpielFenster.status[6] == 1) {
            SpielFenster.sieger = 1;
            check();
            exchange();
          }
          
          ////////////////////////////////////////////////////////////////////////
          
          // Reihe 1 f�r O - Horizontal
          if (SpielFenster.status[0] == 2 && SpielFenster.status[1] == 2 && SpielFenster.status[2] == 2) {
            SpielFenster.sieger = 2;
            check();
            exchange();
          }
          // Reihe 2 f�r O - Horizontal
          else if (SpielFenster.status[3] == 2 && SpielFenster.status[4] == 2 && SpielFenster.status[5] == 2) {
            SpielFenster.sieger = 2;
            check();
            exchange();
          }
          
          // Reihe 3 f�r O - Horizontal
          else if (SpielFenster.status[6] == 2 && SpielFenster.status[7] == 2 && SpielFenster.status[8] == 2) {
            SpielFenster.sieger = 2;
            check();
            exchange();
          }
          
          // Reihe 1 f�r O - Vertikal
          else if (SpielFenster.status[0] == 2 && SpielFenster.status[3] == 2 && SpielFenster.status[6] == 2) {
            SpielFenster.sieger = 2;
            check();
            exchange();
          }
          
          // Reihe 2 f�r O - Vertikal
          else if (SpielFenster.status[1] == 2 && SpielFenster.status[4] == 2 && SpielFenster.status[7] == 2) {
            SpielFenster.sieger = 2;
            check();
            exchange();
          }
          
          // Reihe 3 f�r O - Vertikal
          else if (SpielFenster.status[2] == 2 && SpielFenster.status[5] == 2 && SpielFenster.status[8] == 2) {
            SpielFenster.sieger = 2;
            check();
            exchange();
          }
          
          // Diagonale links oben - rechts unten f�r O
          else if (SpielFenster.status[0] == 2 && SpielFenster.status[4] == 2 && SpielFenster.status[8] == 2) {
            SpielFenster.sieger = 2;
            check();
            exchange();
          }
          
          // Diagonale rechts oben - links unten f�r O
          else if (SpielFenster.status[2] == 2 && SpielFenster.status[4] == 2 && SpielFenster.status[6] == 2) {
            SpielFenster.sieger = 2;
            check();
            exchange();
          }
          
        }
        
      }
    }, 0, 150);
  }
  public void check() {
    if (SpielFenster.sieger == 1) {
      SpielFenster.SpielLog.append("Spieler "+StartMenu.SP1+" hat Gewonnen\n");
      points[0] = points[0] + gPoints;
      points[1] = points[1] - gPoints;
      SpielFenster.Abzug[0] = SpielFenster.voucher + SpielFenster.WinCoins;
      SpielFenster.SpielLog.append(StartMenu.SP1+" hat nun "+points[0]+" Punkte\nUnd deine Credits sind nun \nauf "+ SpielFenster.Abzug[0]+"\n"); 
      SpielFenster.SpielLog.append(StartMenu.SP2+" hat nun "+points[1]+" Punkte\nUnd deine Credits sind nun \nauf "+ SpielFenster.Abzug[1]+"\n"); 
      JOptionPane.showMessageDialog(null,StartMenu.SP1+" hat gewonnen","Wir haben einen Gewinner!!",JOptionPane.INFORMATION_MESSAGE);
      
    }else if (SpielFenster.sieger == 2) {
      SpielFenster.SpielLog.append("Spieler "+StartMenu.SP2+" hat Gewonnen\n");
      points[1] = points[1] + gPoints;
      points[0] = points[0] - gPoints;
      SpielFenster.Abzug[1] = SpielFenster.voucher + SpielFenster.WinCoins; 
      SpielFenster.SpielLog.append(StartMenu.SP2+" hat nun "+points[1]+" Punkte\nUnd deine Credits sind nun \nauf "+ SpielFenster.Abzug[1]+"\n"); 
      SpielFenster.SpielLog.append(StartMenu.SP1+" hat nun "+points[0]+" Punkte\nUnd deine Credits sind nun \nauf "+ SpielFenster.Abzug[0]+"\n"); 
      JOptionPane.showMessageDialog(null,StartMenu.SP2+" hat gewonnen","Wir haben einen Gewinner!!",JOptionPane.INFORMATION_MESSAGE);
    } // end of if
  }
  public void exchange() {
    try { 
      
      Coins.verbindung = DriverManager.getConnection(StartMenu.db,StartMenu.user,StartMenu.pw);
      Statement smtgetCoins = Coins.verbindung.createStatement();
      Statement smtgetCoins2 = Coins.verbindung.createStatement();
      String Coins2 = "Update toplist SET Punkte = '"+points[1]+"', Credits ='"+SpielFenster.Abzug[1]+"' WHERE Name = '"+StartMenu.SP2+"'";
      String Coins1 = "Update toplist SET Punkte = '"+points[0]+"', Credits ='"+SpielFenster.Abzug[0]+"' WHERE Name = '"+StartMenu.SP1+"'";
      
      
      smtgetCoins2.executeUpdate(Coins2);
      smtgetCoins.executeUpdate(Coins1);
      Coins.verbindung.close();
      
      
      
    } catch(Exception e) {
      System.out.println(e);
    }  
    
  }
}      
