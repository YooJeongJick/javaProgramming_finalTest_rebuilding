

import java.awt.*;
import java.awt.event.*;

import javax.swing.ImageIcon;

public class Event3 extends Frame {
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize(); 

	Event3(String title) {
		super(title);
		setLocation(screenSize.width / 2 - 250, screenSize.height / 2 - 200); 
		setSize(500, 400);
		setIconImage(new ImageIcon("images/icon.png").getImage());

		setLayout(null);
		setResizable(false);

		Label l1 = new Label("Mouse Pointer Location : ");
		l1.setBounds(7, 30, 200, 20);
		l1.setBackground(Color.black);
		l1.setForeground(Color.white);
		
		add(l1);
		
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				l1.setText
				("Mouse Pointer Location : " 
				+ "(" + e.getX() + ", " + e.getY() + ")");
			}
		});
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		setVisible(true);

	}
	
//	public static void main(String[] args) {
//		new Test3("Test3");
//	}
	
}	

	
	
	
	
	
	
	
	
	
	