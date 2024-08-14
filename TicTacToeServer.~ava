import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class Game {
    
  private Player[] board = {      //Alle Quadrate auf NULL setzten
        null, null, null,
        null, null, null,
        null, null, null};

    //Aktueller player
  Player currentPlayer;

    // Gewinner 
  public boolean gewinner() {    //Gewinnroutine
    return
    (board[0] != null && board[0] == board[1] && board[0] == board[2])
    ||(board[3] != null && board[3] == board[4] && board[3] == board[5])
    ||(board[6] != null && board[6] == board[7] && board[6] == board[8])
    ||(board[0] != null && board[0] == board[3] && board[0] == board[6])
    ||(board[1] != null && board[1] == board[4] && board[1] == board[7])
    ||(board[2] != null && board[2] == board[5] && board[2] == board[8])
    ||(board[0] != null && board[0] == board[4] && board[0] == board[8])
    ||(board[2] != null && board[2] == board[4] && board[2] == board[6]);
  }

    
  public boolean fillPanel() {
    for (int i = 0; i < board.length; i++) {
      if (board[i] == null) {
        return false;
      }
    }
    return true;
  }
    // Überprüfung des Zuges Eines spielers
  public synchronized boolean legalMove(int zug, Player player) {           //synchronized Um die methode zu Locken!  für den Thread
    if (player == currentPlayer && board[zug] == null) {
      board[zug] = currentPlayer;
      currentPlayer = currentPlayer.gegner;
      currentPlayer.gegnerSpielerZug(zug);
      return true;
    }
    return false;
  }
  class Player extends Thread {
    char mark;
    Player gegner;
    Socket socket;
    BufferedReader input;
    PrintWriter output;
        // Threadhandler zum Initialisieren von Streamfeldern
    public Player(Socket socket, char mark) {
      this.socket = socket;
      this.mark = mark;
      try {
        input = new BufferedReader(
        new InputStreamReader(socket.getInputStream()));
        output = new PrintWriter(socket.getOutputStream(), true);
        output.println("WELCOME " + mark);
        output.println("MESSAGE auf den Gegner warten");
      } catch (IOException e) {
        System.out.println("Spieler Connect Fehler: " + e);
      }
    }
        //Benachrichtigung.
    public void setGegner(Player gegner) {
      this.gegner = gegner;      
    }

        
         //Spieler 2 Movement. 
    public void gegnerSpielerZug(int zug) {
      output.println("OPPONENT_MOVED " + zug);
      output.println(
      gewinner() ? "DEFEAT" : fillPanel() ? "TIE" : "");
    }
    
    public void run() {
      try {
      
        output.println("MESSAGE Alle Spieler Sind Verbunden");
        
        
        if (mark == 'X') {
          output.println("MESSAGE Dein Zug");
        }
        
        // Holt sich wiederholt Befehle vom Client und verarbeitet die Befehle.
        while (true) {
          String command = input.readLine();
          if (command.startsWith("MOVE")) {
            int zug = Integer.parseInt(command.substring(5));
            if (legalMove(zug, this)) {
              output.println("VALID_MOVE");
              output.println(gewinner() ? "VICTORY"
              : fillPanel() ? "TIE"
              : "");
            } else {
              output.println("MESSAGE Unbekannter Fehler Serverneustarten/Du bist nicht an der Reihe ...");
            }
          } else if (command.startsWith("QUIT")) {  //Beenden
            return;
          }
        }
      } catch (IOException e) {
        System.out.println("Spieler Connect Fehler: " + e);
      } finally {
        try {
        socket.close();
        } catch (IOException e) 
        {
          System.out.println(e);
        }
      }
    }
  }
}

