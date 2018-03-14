import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;
import javax.swing.*;

public class Frame extends JFrame implements MouseListener{
	
	Container cp;
	private int row = 50;
	private int col = 50;
	JPanel gridPanel;
	JPanel panels;
    static Random r = new Random();

	
	public Frame(){
		
		gridPanel = new JPanel(new GridLayout(row, col));
		gridPanel.setBorder(BorderFactory.createLineBorder(Color.red));
		gridPanel.setBackground(Color.yellow);

		 for (int i = 0; i < row; i++) {
		      for (int j = 0; j < col; j++) {

		    	  	panels = new JPanel();
	            	panels.setBorder(BorderFactory.createLineBorder(Color.black));
	            	panels.setBackground(Color.darkGray);
	            	panels.addMouseListener(this);
                    gridPanel.add(panels);

	            }
	        }

		cp = getContentPane();
		cp.setSize(900, 900);
	    setDefaultLookAndFeelDecorated(true);
		cp.add(gridPanel, BorderLayout.CENTER);
		setUp();
	}
	
	

	 void setUp ()
	 {
	     Toolkit tk;
	     Dimension d;
	     
	     setDefaultCloseOperation (EXIT_ON_CLOSE);
	     
	     tk = Toolkit.getDefaultToolkit ();
	     d = tk.getScreenSize ();
	     
	     setSize (d.width/2, d.height/2);
	     setLocation (d.width/4, d.height/4);
	     setTitle ("Application");
	     setVisible (true);
	 	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	((JPanel) e.getSource()).setBackground(randomColor());
	
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public static Color randomColor(){

		Color col = new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256),r.nextInt(256));
		return col; 
	}
}
