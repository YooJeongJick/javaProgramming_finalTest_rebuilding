import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddEvent2 extends Frame {
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize(); 
	
	Image img;
	Button b1;

	AddEvent2(String title) {
		super(title);
		setLocation(screenSize.width / 2 - 240, screenSize.height / 2 - 360); 
		setSize(480, 720);
		setIconImage(new ImageIcon("images/icon.png").getImage());
		setLayout(null);
		setResizable(false);
		
		img = tk.getImage("AddEvent2_img/open_img.png");
		
		b1 = new Button("네!");
		b1.setBounds(190, 620, 100, 60);
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setFont(new Font("Monospaced", Font.BOLD, 30));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddEvent2_1("264");
				closeOpen();
			}
		});
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
	
	public void paint(Graphics g) { // 오버라이딩
		g.drawImage(img, 0, 0, this);
	}

//	public static void main(String[] args) {
//		new AddEvent2("못해도 괜찮아");
//	}

}
