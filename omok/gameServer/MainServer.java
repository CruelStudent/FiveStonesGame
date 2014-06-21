package gameServer;

import java.awt.Container;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MainServer {
	
	private static final int PORT = 9999;
	
	public static final double VERSION = 1.01;
	private ServerSocket serverSocket;
	private LobbyInterface lobby;
	private boolean flag = true;
	
	
	public MainServer() throws IOException {
		serverSocket = new ServerSocket(PORT);
		lobby = new Lobby();
		Socket socket = new Socket();
		
		System.out.println("Main Server Start!");
		LogFrame.print("Main Server Start!");
		while (flag) {
			try {
				socket = serverSocket.accept();
				lobby.addGamer(new GameServer( socket, lobby));
					
			} catch (IOException e) {
				System.out.println(e);
				e.printStackTrace();
			} 
		}
		
		try{} catch( Exception e ) {} finally {
			socket.close();
		}
		
		serverSocket.close();
		System.out.println("Server End!!");
		LogFrame.print("Server End!!");
	}
	
	public static void main(String[] args) {
		new LogFrame();
		
		try {
			new MainServer(); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

//class LogFrame extends JFrame {
class LogFrame { 

//	private static final long serialVersionUID = 1L;
//	private Container cp = this.getContentPane();
//	private static JTextArea logWin = new JTextArea();
//	private JScrollPane sc;
//	private JScrollBar m_vScroll;
	
	public LogFrame() {
		/* 20140317 gui �� �ٿ��� �ʵ��� ����
		super("Server : Version : " + MainServer.VERSION);
		
//		cp.setLayout(null);
		
		sc =  new JScrollPane(logWin,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		m_vScroll = sc.getVerticalScrollBar();
		m_vScroll.addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent e) {
//				System.out.println("************** EVENT!!!" + e.getValueIsAdjusting());
				if(!e.getValueIsAdjusting()) m_vScroll.setValue(m_vScroll.getMaximum());
//				m_vScroll.removeAdjustmentListener(this);
				
			}
		});
//		logWin.setBounds(0,0,295,350);
		logWin.setEditable(false);
		cp.add(sc);
		
		this.setSize(300,400);
		this.setVisible(true);

		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		*/
			
	}
	
	// Frame ������ ��¾ȵǵ��� ������.
	public static void print(String str) {
//		logWin.append(str + "\n");
	}
}