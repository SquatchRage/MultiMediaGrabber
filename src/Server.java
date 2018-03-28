
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Server extends JFrame implements ActionListener{
	
Talker talk;
private Socket socket;
private ServerSocket serverSocket;
Container cp;
String message;
JPanel panel;
JButton killButton, traverseButton, messageButotn;
ButtonGroup group;
Server server;
String ID = "I am from the server";
private String killCommand = "Kill Program";
private String showMessage= "Show Message";
private String searchCommand = "Get Files";

 public Server() throws Throwable{
	 
	

	panel = new JPanel(new GridBagLayout());
	killButton = new JButton("Kill Program");
	killButton.addActionListener(this);
	killButton.setActionCommand("Kill Program");
	
	messageButotn = new JButton("Show Message");
	messageButotn.addActionListener(this);
	messageButotn.setActionCommand("Show Message");
	
	traverseButton = new JButton("Get Files");
	traverseButton.addActionListener(this);
	traverseButton.setActionCommand("Get Files");
			
	GridBagConstraints gbc = new GridBagConstraints();

	gbc.insets = new Insets(4, 4, 4, 4);

	gbc.gridx = 0;
	gbc.gridy = 0;
	gbc.weightx = 1;
	panel.add(traverseButton, gbc);

	gbc.gridx = 0;
	gbc.gridy = 1;
	gbc.weightx = 1;
	panel.add(messageButotn, gbc);

	gbc.gridx = 0;
	gbc.gridy = 2;
	gbc.weightx = 1;
	panel.add(killButton, gbc);
	
	cp = getContentPane();
	cp.setSize(200,200);
    setDefaultLookAndFeelDecorated(true);
	cp.add(panel, BorderLayout.CENTER);
	setUp();
	
	serverSocket = new ServerSocket(1201);
	socket = serverSocket.accept();
	talk = new Talker( socket,  ID);
	//talk.send(ID);
	
	while(true){
	message = talk.recieve(ID);
	}
	
 }	

		@Override
		public void actionPerformed(ActionEvent AE) {

			 if(AE.getActionCommand().equals("Kill Program")){
				
				try {
					talk.send(killCommand);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			 else if(AE.getActionCommand().equals("Get Files")){
				 

					try {
						talk.send(searchCommand);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				 
			 }
			 
			 else if(AE.getActionCommand().equals("Show Message")){
				 
					try {
						talk.send(showMessage);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 
			 }
			
		}

		
		 void setUp ()
		 {
		     Toolkit tk;
		     Dimension d;
		     
		     setDefaultCloseOperation (EXIT_ON_CLOSE);
		     
		     tk = Toolkit.getDefaultToolkit ();
		     d = tk.getScreenSize ();
		     
		     setSize (d.width/6, d.height/5);
		     setLocation (d.width/4, d.height/4);
		     setTitle ("Application");
		     setVisible (true);
		 	}

public static void main(String[] args) throws Throwable{
	
	new Server();
	}
}
