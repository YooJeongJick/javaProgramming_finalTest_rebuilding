

import java.awt.*;
import java.awt.event.*;

import javax.swing.ImageIcon;

public class Event1 extends Frame {
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize(); 
	
	Event1(String title) {
		super(title);
		setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200); 
		setSize(600, 400);
		setIconImage(new ImageIcon("images/icon.png").getImage());

		setBackground(Color.white);
		setLayout(null);
		setResizable(false);
		
		Button b1 = new Button("Python");
		b1.setBounds(50, 80, 200, 100);
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setFont(new Font("Serif", Font.BOLD, 20));
		
		Choice ch1 = new Choice();
		ch1.setBounds(300, 80, 100, 30);
		ch1.add("Python");
		ch1.add("Java");
		ch1.add("C");
		
		List l1 = new List();
		l1.setBounds(450, 80, 100, 100);
		l1.add("P");
		l1.add("Y");
		l1.add("T");
		l1.add("H");
		l1.add("O");
		l1.add("N");
		l1.add("!");
		l1.setMultipleMode(false);
		
		Label lal = new Label("Python");
		lal.setBounds(300, 200, 250, 30);
		lal.setBackground(Color.black);
		lal.setForeground(Color.white);
		lal.setFont(new Font("SansSerif", Font.BOLD, 15));
		lal.setAlignment(Label.CENTER);
		
		TextArea tal = new TextArea();
		tal.setBounds(300, 230, 250, 120);
		tal.setText("Hello World!");
		tal.setEditable(true);

		add(b1);
		add(ch1);
		add(l1);
		add(lal);
		add(tal);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		setVisible(true);

	}
	
//	public static void main(String[] args) {
//		new Test1("Test1");
//	}

}
