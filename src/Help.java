import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

public class Help extends Frame{
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize(); 

	Image img1, img2, img3, img4, img5;
	JTabbedPane t;
	
	Help(String title) {
		super(title);
		
		setLocation(screenSize.width / 2 - 480, screenSize.height / 2 - 300);
		setSize(960, 600); 
		setIconImage(new ImageIcon("images/icon.png").getImage());
		setLayout(null);
		setResizable(false);

		try {
		    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			//
		}
		
        JPanel p1 = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image img1 = tk.getImage("images/help1.png");
                g.drawImage(img1, 0, 0, this);
            }
        };
        p1.setBounds(0, 0, 960, 540);
        
        JPanel p2 = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image img2 = tk.getImage("images/help2.png");
                g.drawImage(img2, 0, 0, this);
            }
        };
        p2.setBounds(0, 0, 960, 540);

        JPanel p3 = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image img3 = tk.getImage("images/help3.png");
                g.drawImage(img3, 0, 0, this);
            }
        };
        p3.setBounds(0, 0, 960, 540);

        JPanel p4 = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image img4 = tk.getImage("images/help4.png");
                g.drawImage(img4, 0, 0, this);
            }
        };
        p4.setBounds(0, 0, 960, 540);

        JPanel p5 = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image img5 = tk.getImage("images/help5.png");
                g.drawImage(img5, 0, 0, this);
            }
        };
        p5.setBounds(0, 0, 960, 540);
        
		t = new JTabbedPane();
		t.setBounds(10, 35, 960, 540);
		t.add("1", p1);
		t.add("2", p2);
		t.add("3", p3);
		t.add("4", p4);
		t.add("5", p5);
        add(t);

		addWindowListener(new WindowAdapter() { 
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		setVisible(true);
	}
	
//	public static void main(String[] args) {
//		new Help("프로그램 설명");
//	}
}
