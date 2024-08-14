import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.JOptionPane;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 17.11.2019
 * @author 
 */

public class SpielFenster extends JFrame {
  // Anfang Attribute
  private JButton linksOben = new JButton();
  private JButton linksMitte = new JButton();
  private JButton linksUnten = new JButton();
  private JButton mitteOben = new JButton();
  private JButton mitte = new JButton();
  private JButton mitteUnten = new JButton();
  private JButton obenRechts = new JButton();
  private JButton mitteRechts = new JButton();
  private JButton rechtsUnten = new JButton();
  private JButton bReset = new JButton();
  private JLabel jLabel1 = new JLabel();
  private JLabel jLabel2 = new JLabel();
  protected static JTextArea SpielLog = new JTextArea("");
  private JScrollPane SpielLogScrollPane = new JScrollPane(SpielLog);
  private JLabel anzeige = new JLabel();
  private JButton bCoinsSetzen1 = new JButton();
  // Ende Attribute
  //Zeichnen 
  Draw zeichnen;
  //Buttonstatus
  static int status[] = new int[9];// 9x Button
  //status[0],status[1],status[2] 1.Reihe
  //status[3],status[4],status[5] 2.Reihe
  //status[6],status[7],status[8] 3.Reihe
  
  private int spieler = 0;
  protected static int sieger = 0;
  protected static int posX[] = new int[9];   //POSX Array
  protected static int posY[] = new int[9];    //POSY ARRAY
  protected int Set_Coins_ply = 0;      //Feld sperre      SP1
  protected int Set_Coins_ply_2 = 0;  //Feld sperre        SP2
  protected static int Abzug[] = new int [2];   //Cois/Credits abziehen  Array
  protected static int voucher = 40;      //Zu bezahlende Coins &
  protected static int WinCoins = 30;
  
  
  //posX Von allen buttons
  
  
  
  public SpielFenster()  { 
    // Frame-Initialisierung
    super();
    //super.paintComponent(g);
    posx_posY();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 865; 
    int frameHeight = 557;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("SpielFenster");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    linksOben.setBounds(261, 51, 161, 145);
    linksOben.setText("");
    linksOben.setMargin(new Insets(2, 2, 2, 2));
    linksOben.setFocusPainted(false);
    linksOben.setContentAreaFilled(false);
    linksOben.setBorder(null);
    
    linksOben.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        linksOben_ActionPerformed(evt);
      }
    });
    cp.add(linksOben);
    linksMitte.setBounds(posX[1], posY[1], 163, 141);
    linksMitte.setText("");
    linksMitte.setMargin(new Insets(2, 2, 2, 2));
    linksMitte.setFocusPainted(false);
    linksMitte.setContentAreaFilled(false);
    linksMitte.setBorder(null);
    linksMitte.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        linksMitte_ActionPerformed(evt);
      }
    });
    cp.add(linksMitte);
    linksUnten.setBounds(posX[2], posY[2], 163, 129);
    linksUnten.setText("");
    linksUnten.setMargin(new Insets(2, 2, 2, 2));
    linksUnten.setFocusPainted(false);
    linksUnten.setContentAreaFilled(false);
    linksUnten.setBorder(null);
    linksUnten.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        linksUnten_ActionPerformed(evt);
      }
    });
    cp.add(linksUnten);
    mitteOben.setBounds(posX[3], posY[3], 143, 145);
    mitteOben.setText("");
    mitteOben.setMargin(new Insets(2, 2, 2, 2));
    mitteOben.setFocusPainted(false);
    mitteOben.setContentAreaFilled(false);
    mitteOben.setBorder(null);
    mitteOben.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        mitteOben_ActionPerformed(evt);
      }
    });
    cp.add(mitteOben);
    mitte.setBounds(posX[4], posY[4], 144, 142);
    mitte.setText("");
    mitte.setMargin(new Insets(2, 2, 2, 2));
    mitte.setFocusPainted(false);
    mitte.setContentAreaFilled(false);
    mitte.setBorder(null);
    mitte.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        mitte_ActionPerformed(evt);
      }
    });
    cp.add(mitte);
    mitteUnten.setBounds(posX[5], posY[5], 139, 137);
    mitteUnten.setText("");
    mitteUnten.setMargin(new Insets(2, 2, 2, 2));
    mitteUnten.setFocusPainted(false);
    mitteUnten.setContentAreaFilled(false);
    mitteUnten.setBorder(null);
    mitteUnten.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        mitteUnten_ActionPerformed(evt);
      }
    });
    cp.add(mitteUnten);
    obenRechts.setBounds(posX[6], posY[6], 147, 145);
    obenRechts.setText("");
    obenRechts.setMargin(new Insets(2, 2, 2, 2));
    obenRechts.setFocusPainted(false);
    obenRechts.setContentAreaFilled(false);
    obenRechts.setBorder(null);
    obenRechts.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        obenRechts_ActionPerformed(evt);
      }
    });
    cp.add(obenRechts);
    mitteRechts.setBounds(posX[7], posY[7], 147, 145);
    mitteRechts.setText("");
    mitteRechts.setMargin(new Insets(2, 2, 2, 2));
    mitteRechts.setFocusPainted(false);
    mitteRechts.setContentAreaFilled(false);
    mitteRechts.setBorder(null);
    mitteRechts.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        mitteRechts_ActionPerformed(evt);
      }
    });
    cp.add(mitteRechts);
    rechtsUnten.setBounds(posX[8], posY[8], 147, 137);
    rechtsUnten.setText("");
    rechtsUnten.setMargin(new Insets(2, 2, 2, 2));
    rechtsUnten.setFocusPainted(false);
    rechtsUnten.setContentAreaFilled(false);
    rechtsUnten.setBorder(null);
    rechtsUnten.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        rechtsUnten_ActionPerformed(evt);
      }
    });
    cp.add(rechtsUnten);
    bReset.setBounds(16, 16, 129, 25);
    bReset.setText("Reset");
    bReset.setMargin(new Insets(2, 2, 2, 2));
    bReset.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bReset_ActionPerformed(evt);
      }
    });
    cp.add(bReset);
    jLabel1.setBounds(16, 64, 185, 17);
    jLabel1.setText("");
    cp.add(jLabel1);                                                                    
    jLabel2.setBounds(16, 120, 185, 21);
    jLabel2.setText("");
    cp.add(jLabel2);
    SpielLogScrollPane.setBounds(16, 152, 209, 273);
    SpielLog.setCursor(new Cursor(Cursor.HAND_CURSOR));
    SpielLog.setEditable(false);
    SpielLog.setFont(new Font("Arial", Font.BOLD, 14));
    cp.add(SpielLogScrollPane);
    anzeige.setBounds(265, 10, 457, 25);
    anzeige.setText("");
    cp.add(anzeige);
    bCoinsSetzen1.setBounds(16, 440, 201, 49);
    bCoinsSetzen1.setText("Coins Setzen");
    bCoinsSetzen1.setMargin(new Insets(2, 2, 2, 2));
    bCoinsSetzen1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bCoinsSetzen1_ActionPerformed(evt);
      }
    });
    cp.add(bCoinsSetzen1);
    // Ende Komponenten
    zeichnen = new Draw();
    zeichnen.setBounds(0,0,frameWidth,frameHeight);           
    zeichnen.setVisible(true);
    cp.add(zeichnen);
    setVisible(true);
    LogDesSpieles();
    jLabel1.setText("Spieler 1 : "+StartMenu.SP1+ " Coins : "+Coins.getCoins() );
    jLabel2.setText("Spieler 2 : "+StartMenu.SP2+ " Coins : " +Coins.getCoins2());
  } // end of public SpielFenster
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new SpielFenster();
  } // end of main
  
  public void linksOben_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen 
    if (Set_Coins_ply == 1 && Set_Coins_ply_2 == 2) {
      
      // end of if
      if (sieger == 0) {
        LogDesSpieles(); 
        if (status[0] == 0 && spieler == 0) {
          status[0] = 1;
          spieler = 1;
        } else if(status[0] == 0 && spieler == 1) {
          status[0] = 2;
          spieler = 0;
        }                
      }  
    } else {
      JOptionPane.showMessageDialog(null, "Erst Coins Setzen!","Fehler",JOptionPane.ERROR_MESSAGE); 
    } // end of if-else                   
  } // end of linksOben_ActionPerformed

  public void linksMitte_ActionPerformed(ActionEvent evt) {
    if (Set_Coins_ply == 1 && Set_Coins_ply_2 == 2) {
      if (sieger == 0) {
        LogDesSpieles(); 
        if (status[1] == 0 && spieler == 0) {
          status[1] = 1;
          spieler = 1;
        } else if(status[1] == 0 && spieler == 1) {
          status[1] = 2;
          spieler = 0;
        }                
      } 
    }else {
      JOptionPane.showMessageDialog(null, "Erst Coins Setzen!","Fehler",JOptionPane.ERROR_MESSAGE); 
    } // end of if-else 
  } // end of linksMitte_ActionPerformed

  public void linksUnten_ActionPerformed(ActionEvent evt) {
    if (Set_Coins_ply == 1 && Set_Coins_ply_2 == 2) {
      if (sieger == 0) {
        LogDesSpieles(); 
        if (status[2] == 0 && spieler == 0) {
          status[2] = 1;
          spieler = 1;
        } else if(status[2] == 0 && spieler == 1) {
          status[2] = 2;
          spieler = 0;
        }                
      }
    } else {
      JOptionPane.showMessageDialog(null, "Erst Coins Setzen!","Fehler",JOptionPane.ERROR_MESSAGE); 
    } 
    
  }

  public void mitteOben_ActionPerformed(ActionEvent evt) {
    if (Set_Coins_ply == 1 && Set_Coins_ply_2 == 2) {
      if (sieger == 0) {
        LogDesSpieles(); 
        if (status[3] == 0 && spieler == 0) {
          status[3] = 1;
          spieler = 1;
        } else if(status[3] == 0 && spieler == 1) {
          status[3] = 2;
          spieler = 0;
        }                
      }
    } else {
      JOptionPane.showMessageDialog(null, "Erst Coins Setzen!","Fehler",JOptionPane.ERROR_MESSAGE); 
    }  
    
  } // end of mitteOben_ActionPerformed

  public void mitte_ActionPerformed(ActionEvent evt) {
    if (Set_Coins_ply == 1 && Set_Coins_ply_2 == 2) {
      if (sieger == 0) {
        LogDesSpieles(); 
        if (status[4] == 0 && spieler == 0) {
          status[4] = 1;
          spieler = 1;
        } else if(status[4] == 0 && spieler == 1) {
          status[4] = 2;
          spieler = 0;
        }                
      } 
    } else {
      JOptionPane.showMessageDialog(null, "Erst Coins Setzen!","Fehler",JOptionPane.ERROR_MESSAGE); 
    } 
    
  } // end of mitte_ActionPerformed

  public void mitteUnten_ActionPerformed(ActionEvent evt) {
    if (Set_Coins_ply == 1 && Set_Coins_ply_2 == 2) {
      if (sieger == 0) {
        LogDesSpieles(); 
        if (status[5] == 0 && spieler == 0) {
          status[5] = 1;
          spieler = 1;
        } else if(status[5] == 0 && spieler == 1) {
          status[5] = 2;
          spieler = 0;
        }                
      }
    } else {
      JOptionPane.showMessageDialog(null, "Erst Coins Setzen!","Fehler",JOptionPane.ERROR_MESSAGE); 
    }  
    
  } // end of mitteUnten_ActionPerformed

  public void obenRechts_ActionPerformed(ActionEvent evt) {
    if (Set_Coins_ply == 1 && Set_Coins_ply_2 == 2) {
      if (sieger == 0) {
        LogDesSpieles(); 
        if (status[6] == 0 && spieler == 0) {
          status[6] = 1;
          spieler = 1;
        } else if(status[6] == 0 && spieler == 1) {
          status[6] = 2;
          spieler = 0;
        }                
      }
    } else {
      JOptionPane.showMessageDialog(null, "Erst Coins Setzen!","Fehler",JOptionPane.ERROR_MESSAGE); 
    }  
    
  } // end of obenRechts_ActionPerformed

  public void mitteRechts_ActionPerformed(ActionEvent evt) {
    if (Set_Coins_ply == 1 && Set_Coins_ply_2 == 2) {
      if (sieger == 0) {
        LogDesSpieles(); 
        if (status[7] == 0 && spieler == 0) {
          status[7] = 1;
          spieler = 1;
        } else if(status[7] == 0 && spieler == 1) {
          status[7] = 2;
          spieler = 0;
        }                
      } 
    } else {
      JOptionPane.showMessageDialog(null, "Erst Coins Setzen!","Fehler",JOptionPane.ERROR_MESSAGE); 
    } 
    
  } // end of mitteRechts_ActionPerformed

  public void rechtsUnten_ActionPerformed(ActionEvent evt) {
    if (Set_Coins_ply == 1 && Set_Coins_ply_2 == 2) {
      if (sieger == 0) {
        LogDesSpieles(); 
        if (status[8] == 0 && spieler == 0) {
          status[8] = 1;
          spieler = 1;
        } else if(status[8] == 0 && spieler == 1) {
          status[8] = 2;
          spieler = 0;
        }                
      } 
    } else {
      JOptionPane.showMessageDialog(null, "Erst Coins Setzen!","Fehler",JOptionPane.ERROR_MESSAGE); 
    } 
    
  } // end of rechtsUnten_ActionPerformed

  public void bReset_ActionPerformed(ActionEvent evt) {
    if (Set_Coins_ply == 1 && Set_Coins_ply_2 == 2) {
      // TODO hier Quelltext einfügen
      for (int i = 0 ;i < status.length; i++) {
        status[i]=0;
      } 
      LogDesSpieles();
      spieler = 0;
      sieger = 0;
      Set_Coins_ply = 0;
      Set_Coins_ply_2 = 0;
      jLabel1.setText("Spieler 1 : "+StartMenu.SP1+ " Coins : "+Coins.getCoins() );
      jLabel2.setText("Spieler 2 : "+StartMenu.SP2+ " Coins : "+Coins.getCoins2());
    } else {                                                   
      JOptionPane.showMessageDialog(null, "Erst Coins Setzen!","Fehler",JOptionPane.ERROR_MESSAGE); 
    } 
  } // end of bReset_ActionPerformed
  public void posx_posY(){
    //posX Von allen buttons
    posX[0] = 261;
    posX[1] = 258;
    posX[2] = 256;
    posX[3] = 429;
    posX[4] = 429;
    posX[5] = 432;
    posX[6] = 582;
    posX[7] = 584;
    posX[8] = 583;
    //posY-- Von allen buttons
    posY[0] = 51;
    posY[1] = 206;
    posY[2] = 360;
    posY[3] = 49;
    posY[4] = 200;
    posY[5] = 354;
    posY[6] = 48;
    posY[7] = 204;
    posY[8] = 355;   
    
  }
  
  public void bCoinsSetzen1_ActionPerformed(ActionEvent evt) {
    if (Set_Coins_ply == 0 && Set_Coins_ply_2 == 0) {
      Set_Coins_ply = 1;
      Set_Coins_ply_2 = 2;
      if (Coins.getCoins() <= 0 && Coins.getCoins2() <= 0) {
        SpielLog.append("Gratis Runde!\n");
      } // end of if
      else if (Coins.getCoins() <= 0 ) {
        Abzug[1] = Coins.getCoins2() - voucher; //Abzug von den akt. coins
        jLabel2.setText("Spieler 2 : "+StartMenu.SP2+ " Coins : " +Abzug[1] );
        SpielLog.append("Gratis Runde! für "+StartMenu.SP1+"\n");
      } else if (Coins.getCoins2() <= 0) {
        Abzug[0] = Coins.getCoins() - voucher; //Abzug von den akt. coins
        System.out.println(Abzug[0]);
        jLabel1.setText("Spieler 1 : "+StartMenu.SP1+ " Coins : "+Abzug[0]); 
         SpielLog.append("Gratis Runde! für "+StartMenu.SP2+"\n");
      }else {
        Abzug[0] = Coins.getCoins() - voucher;  //Abzug von den akt. coins
        Abzug[1] = Coins.getCoins2() - voucher;   //Abzug von den akt. coins
        jLabel1.setText("Spieler 1 : "+StartMenu.SP1+ " Coins : "+Abzug[0] );
        jLabel2.setText("Spieler 2 : "+StartMenu.SP2+ " Coins : " +Abzug[1]);
      } // end of if-else
      
      
    } // end of if
    
  }  
  public void LogDesSpieles() {
    if (Draw.debug == true){
      
      SpielLog.append("Position X: " +Draw.getPosX+ " Position Y: " +Draw.getPosY+ "\n"); 
    }
    if (spieler == 1) {
      anzeige.setText("Spieler : "+StartMenu.SP1+ " ist am zug");
    }else if (spieler == 0) {
      anzeige.setText("Spieler : "+StartMenu.SP2+ " ist am zug"); 
    }
    
    
    // Ende Methoden
  }
      
} // end of class SpielFenster
    
