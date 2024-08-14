import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JFrame;

public class FrameTicServer extends JFrame  {

  // Anfang Attribute
  private JLabel lServerStatus = new JLabel();
  private JLabel lNA = new JLabel();
  private JButton bStarten = new JButton();
  private boolean Startcheck = false; //Button Status False = Start True = Stop
  private Thread t1 , t2 ;  //T1 = rgbwonder //T2 = rgbwonder_Stop 
  ServerSocket shark;   //Server Socket = Shark
  
  // Ende Attribute
  
  public FrameTicServer() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 364; 
    int frameHeight = 329;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("FrameTicServer");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    lServerStatus.setBounds(16, 24, 311, 63);
    lServerStatus.setText("ServerStatus");
    lServerStatus.setFont(new Font("Dialog", Font.BOLD, 50));
    cp.add(lServerStatus);
    lNA.setBounds(16, 104, 311, 63);
    lNA.setText("N/A");
    lNA.setFont(new Font("Dialog", Font.BOLD, 50));
    lNA.setHorizontalTextPosition(SwingConstants.CENTER);
    lNA.setHorizontalAlignment(SwingConstants.CENTER);
    cp.add(lNA);
    bStarten.setBounds(56, 248, 225, 33);
    bStarten.setText("Starten");
    bStarten.setMargin(new Insets(2, 2, 2, 2));
    bStarten.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bStarten_ActionPerformed(evt);
      }
    });
    bStarten.setForeground(Color.BLACK);
    bStarten.setCursor(new Cursor(Cursor.HAND_CURSOR));
    bStarten.setBorder(new javax.swing.border.LineBorder(Color.BLACK, 2, true));
    cp.add(bStarten);
    // Ende Komponenten
    
    setVisible(true);
    
    
  }
  
  // Anfang Methoden
  
  public static void main(String[] args)throws Exception {
    new FrameTicServer();
    
  }           
  
  
    
 //======================Threads=========================//


  class rgbwonder implements Runnable{
    public void run(){
      lNA.setText("");
      lNA.setForeground(Color.black);
      try { 
        shark = new ServerSocket(2590);//Socket Für den Server
        for (int i=1;i<=10 ;i++ ) {
          try {
            Thread.sleep(500);
            lNA.setText(lNA.getText()+"."); 
            if(StartMenu.Debug)  
               System.out.println(i);
            if (i == 10) {
              lNA.setText("ONLINE"); 
              lNA.setForeground(Color.green);
              try {
                
                while (true) {
                  Game game = new Game();       //Game 
                  Game.Player playerX = game.new Player(shark.accept(), 'X');     //Game Spieler zuweisen
                  Game.Player playerO = game.new Player(shark.accept(), 'O');     //Game Spieler zuweisen
                  playerX.setGegner(playerO);     //Game Spieler zuweisen
                  playerO.setGegner(playerX);      //Game Spieler zuweisen
                  game.currentPlayer = playerX;     //Game Spieler zuweisen
                  playerX.start();  //Game Spieler X Spiel Start
                  playerO.start(); //Game Spieler O Spiel Start
                  
                }
              } finally {
                shark.close();
                
              }
            } // end of if
            
          } catch(Exception e) {
            //System.out.println(e);
            System.out.println("Fehler in rgbwonder out loop: "+e);
          }
          
        } // end of for
        
        
      }catch(IOException e) {
        //System.out.println(e);
        System.out.println("Fehler in rgbwonder IOException: "+e);  
      }  
    }
  }
  

  class rgbwonder_Stop implements Runnable{

    public void run(){
      lNA.setText("");
      lNA.setForeground(Color.black);
      try { 
        for (int i=1;i<=10 ;i++ ) {
          try {
            Thread.sleep(250);
            lNA.setText(lNA.getText()+".");
            if(StartMenu.Debug)  
              System.out.println("Close  " +i);
            if (i == 10) {                              
              lNA.setText("OFFLINE"); 
              lNA.setForeground(Color.red);
              shark.close();
              bStarten.setText("Starten");
              Startcheck = false;
            }
            
          } catch(Exception e) {
            System.out.println("Fehler in rgbwonder_Stop in loop: "+e);
          }
          
        } // end of for
        
        
      }catch(Exception e) {
        System.out.println("Fehler in rgbwonder_Stop out loop: "+e);  
      }  
    }
  }
  
  
  
   //===============================================//




  public void bStarten_ActionPerformed(ActionEvent evt){
    if (!Startcheck) {
      try {
        Startcheck =true;
        bStarten.setText("Stoppen"); 
      ///  t2.stop();              
        t1 = new Thread(new rgbwonder());
        t1.start();      
        
      } catch(Exception e) {
          System.out.println(""+e);
      } finally {
        
      } // end of try
      
    } else {
      t1.stop();
      t2 = new Thread(new rgbwonder_Stop());  //Startet einen neuen Den Stop Thread                           
      t2.start();  
    } 
  }      
  

  // Ende Methoden
} // end of class FrameTicServer      
