import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket; //Server SOCKET UFF...
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TicTacToeClient {

    protected JFrame frame = new JFrame("Tic Tac Toe");
    protected JLabel messageLabel = new JLabel("");
    protected ImageIcon icon;
    protected ImageIcon opponentIcon;

    protected Qua[] board = new Qua[9];
    protected Qua currentQua;

    protected static int PORT = 2590;
    protected Socket socket;
    protected BufferedReader in;
    protected PrintWriter out;

    //TTT - Construct   
    public TicTacToeClient(String serverAddress) throws Exception {

       //Socket Einstellung
        socket = new Socket(serverAddress, PORT);
        in = new BufferedReader(new InputStreamReader(
            socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

        // Layout GUI
        messageLabel.setBackground(Color.lightGray);
        frame.getContentPane().add(messageLabel, "South");

        JPanel boardPanel = new JPanel();
        boardPanel.setBackground(Color.black);
        boardPanel.setLayout(new GridLayout(3, 3, 2, 2));
        for (int i = 0; i < board.length; i++) {
            final int j = i;
            board[i] = new Qua();
            board[i].addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    currentQua = board[j];
                    out.println("MOVE " + j);}});
            boardPanel.add(board[i]);
        }
        frame.getContentPane().add(boardPanel, "Center");
    }

   
    public void play() throws Exception {
        String response;
        try {
            response = in.readLine();
            if (response.startsWith("WELCOME")) {
                char mark = response.charAt(8);
                icon = new ImageIcon(mark == 'X' ? "img/x.png" : "img/o.png");
                opponentIcon  = new ImageIcon(mark == 'X' ? "img/o.png" : "img/x.png");
                frame.setTitle("Tic Tac Toe - Spieler " + mark);
            }
            while (true) {
                response = in.readLine();
                if (response.startsWith("VALID_MOVE")) {
                    messageLabel.setText("Warte auf Gültige eingabe");
                    currentQua.setIcon(icon);
                    currentQua.repaint();
                } else if (response.startsWith("OPPONENT_MOVED")) {
                    int loc = Integer.parseInt(response.substring(15));
                    board[loc].setIcon(opponentIcon);
                    board[loc].repaint();
                    messageLabel.setText("Gegner hat den zug Beendet, Du bist dran");
                } else if (response.startsWith("VICTORY")) {
                    messageLabel.setText("Du Hast Gewonnen");
                    break;
                } else if (response.startsWith("DEFEAT")) {
                    messageLabel.setText("Du hast Verloren KEKW");
                    break;
                } else if (response.startsWith("TIE")) {
                    messageLabel.setText("Tja, Beide Verloren");
                    break;
                } else if (response.startsWith("MESSAGE")) {
                    messageLabel.setText(response.substring(8));
                }
            }
            out.println("QUIT");
        }
        finally {
            socket.close();
        }
    }

    protected boolean newTry() {
        int response = JOptionPane.showConfirmDialog(frame,"Nochmal Spielen ?","- Tic Tac Toe -",JOptionPane.YES_NO_OPTION);
        frame.dispose();
        return response == JOptionPane.YES_OPTION;
    }

    //Grafische anpassungen  
    static class Qua extends JPanel {
        JLabel label = new JLabel((Icon)null);

        public Qua() {
            setBackground(Color.white);
            add(label);
        }

        public void setIcon(Icon icon) {
            label.setIcon(icon);
        }
    }

}
