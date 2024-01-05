

import java.awt.*;
import java.awt.event.*;

import javax.swing.ImageIcon;

public class Event2 extends Frame {
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize(); 

	Event2(String title) {
		super(title);
		setLocation(screenSize.width / 2 - 200, screenSize.height / 2 - 250); 
		setSize(400, 500);
		setIconImage(new ImageIcon("images/icon.png").getImage());

		setLayout(null);
		setBackground(Color.BLACK);
		setResizable(false);

		Label l1 = new Label("How is the cat now?", Label.CENTER);
		l1.setBounds(50, 80, 300, 50);
		l1.setBackground(Color.WHITE);
		l1.setFont(new Font("Serif", Font.BOLD, 20));

		Panel p1 = new Panel();
		p1.setLayout(new GridLayout(2, 1));
		p1.setBounds(50, 150, 300, 150);
		p1.setBackground(Color.white);
		
		CheckboxGroup cbg = new CheckboxGroup();
		Checkbox cb1 = new Checkbox("alive", cbg, false);
		Checkbox cb2 = new Checkbox("dead", cbg, false);
		
		p1.add(cb1);
		p1.add(cb2);
		
		Panel p2 = new Panel();
		p2.setLayout(null);
		p2.setBounds(50, 330, 300, 120);
		p2.setBackground(Color.WHITE);
		
		Button b1 = new Button("box1");
		Button b2 = new Button("box2");
		Button b3 = new Button("box3");
		
		b1.setBounds(30, 50, 70, 50);
		b2.setBounds(115, 20, 70, 50);
		b3.setBounds(200, 60, 70, 50);

		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
		
		add(l1);
		add(p1);
		add(p2);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		setVisible(true);

	}

//	public static void main(String[] args) {
//		new Test2("Test2");
//	}
	
}
