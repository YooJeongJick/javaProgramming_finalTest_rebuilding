

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddEvent2_Open2 extends Frame {
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize(); 
	
	Label l1;
	TextField tfid1;
	Button b1;

	AddEvent2_Open2(String title) {
		super(title);
		setLocation(screenSize.width / 2 - 200, screenSize.height / 2 - 150); 
		setSize(400, 300);
		setIconImage(new ImageIcon("images/icon.png").getImage());

		setLayout(null);
		setResizable(false);
		
		try {
		    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			//
		}

		l1 = new Label("겨울은", Label.CENTER);
		l1.setFont(new Font("Monospaced", Font.BOLD, 30));
		l1.setBounds(0, 0, 400, 150);
		
		tfid1 = new TextField(10);
		tfid1.setFont(new Font("Monospaced", Font.PLAIN, 20));
		tfid1.setBounds(100, 150, 200, 30);
		
		b1 = new Button("맞지?");
		b1.setBounds(175, 200, 50, 30);
		b1.setSize(50, 25);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tfid1.getText().equals("강철로 된 무지개")) {
					closeOpen();
					JOptionPane.showMessageDialog(null, "맞아! 오늘도 열심히 일해보자");
					new AddEvent2("못해도 괜찮아");
				}
			}
		});
		
		add(l1);
		add(tfid1);
		add(b1);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		setVisible(true);

	}
	
	public void closeOpen() {
		setVisible(false);
	}

	
//	public static void main(String[] args) {
//		new AddEvent2_Open2("264");
//	}
}
