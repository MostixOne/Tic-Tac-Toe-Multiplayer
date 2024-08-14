/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 17.11.2019
 * @author 
 */
 import java.sql.*;
public class Coins {
  protected static int getConinsByNameSP1;
  protected static int getConinsByNameSP2;
  protected static Connection verbindung = null;
  public Coins() {
    try {
      // Treiber laden
      Class.forName("com.mysql.jdbc.Driver");    
    }
    catch (Exception e) {
      System.err.println("Kann Treiber nicht laden: " + e);         //Feher ausgabe
    } 
    System.out.println();
    
  }
    
  public static int getCoins() {
    // StartMenu.SP1;
    try { 
      
      verbindung = DriverManager.getConnection(StartMenu.db,StartMenu.user,StartMenu.pw);
      Statement smtgetCoins = verbindung.createStatement();
      String Coins1 = "SELECT Credits,Punkte FROM toplist where name = '"+StartMenu.SP1+"'";
      ResultSet CoisRes = smtgetCoins.executeQuery(Coins1);
      while (CoisRes.next()) {
        getConinsByNameSP1 = CoisRes.getInt("Credits") ;
        checkGewinn.points[0] = CoisRes.getInt("Punkte") ;
      }
      verbindung.close();
      
    } catch(Exception e) {
      System.out.println(e);
    }
    
    return getConinsByNameSP1;
    
  }
  public static int getCoins2() {
    try { 
      
      verbindung = DriverManager.getConnection(StartMenu.db,StartMenu.user,StartMenu.pw);
      Statement smtgetCoins = verbindung.createStatement();
      String Coins2 = "SELECT Credits,Punkte FROM toplist where name = '"+StartMenu.SP2+"'";
      ResultSet CoisRes2 = smtgetCoins.executeQuery(Coins2);
      while (CoisRes2.next()) {
        getConinsByNameSP2 = CoisRes2.getInt("Credits") ;
        checkGewinn.points[1] = CoisRes2.getInt("Punkte") ;
      }
      verbindung.close();
    } catch(Exception e) {
      System.out.println(e);
    }  
    
    return getConinsByNameSP2;
  }

} // end of class Coins

