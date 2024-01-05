

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class AddEvent1 extends Frame {
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize(); 
	
	Panel p0, p1, p2, p3;
	Choice c1, c2;
	Label l1, l2, l3;
	Button bArr[] = new Button[13];
	Button b1, b2;
	
	Panel 
	body, 
	left_eye, right_eye, left_eye_plus, right_eye_plus, 
	nose, mouse,
	deco_1, deco_2,
	left_hand, right_hand, left_arm, right_arm;

	AddEvent1(String title){
		super(title);
		setGUI();
		setSnow();
		setEvent();
	}
	
	public void setGUI() {
		setLocation(screenSize.width / 2 - 200, screenSize.height / 2 - 300); 
		setSize(400, 600);
		setIconImage(new ImageIcon("images/icon.png").getImage());

		setLayout(null);
		setResizable(false);

		try {
		    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			//
		}

		p0 = new Panel();
		p0.setBounds(0, 0, 400, 200);
		p0.setBackground(Color.lightGray);
		p0.setLayout(null);
		
		p1 = new Panel();
		p1.setBounds(25, 200, 350, 50);
		p1.setLayout(new GridLayout(1, 2, 5, 5));
		
		c1 = new Choice();
		c1.add("눈");
		c1.add("코");
		c1.add("입");
		c1.add("팔");
		c1.add("손");
		c1.add("몸");
		c1.add("장식");
		c1.add("배경");
		c1.addItemListener(new visible());
		p1.add(c1);
		
		c2 = new Choice();
		c2.add("양쪽");
		c2.add("왼쪽");
		c2.add("오른쪽");
		c2.addItemListener(new visible());
		p1.add(c2);
		
		l1 = new Label("< 기본 색상 >", Label.CENTER);
		l1.setBounds(0, 250, 400, 50);
		l1.setFont(new Font("Monospaced", Font.PLAIN, 20));
		
		p2 = new Panel();
		p2.setBounds(25, 300, 350, 150);
		p2.setLayout(new GridLayout(3, 5, 5, 5));
		for (int i = 0; i < 10; i++) {
			bArr[i] = new Button();
			p2.add(bArr[i]);
		}
		l2 = new Label();
		p2.add(l2);
		for (int i = 0; i < 3; i++) {
			bArr[10 + i] = new Button();
			p2.add(bArr[10 + i]);
		}
		
		l3 = new Label("< 특수 색상 >", Label.CENTER);
		l3.setBounds(0, 450, 400, 50);
		l3.setFont(new Font("Monospaced", Font.PLAIN, 20));
		
		p3 = new Panel();
		p3.setBounds(25, 500, 350, 50);
		p3.setLayout(new GridLayout(1, 2, 5, 5));
		
		b1 = new Button("맞춤 색상");
		b1.addActionListener(new color_bClick2());
		p3.add(b1);
		
		b2 = new Button("무작위 색상");
		b2.addActionListener(new color_bClick3());
		p3.add(b2);

		bArr[0].setBackground(Color.white);
		bArr[1].setBackground(Color.lightGray);
		bArr[2].setBackground(Color.gray);
		bArr[3].setBackground(Color.darkGray);
		bArr[4].setBackground(Color.black);

		bArr[5].setBackground(Color.pink);
		bArr[6].setBackground(Color.magenta);
		bArr[7].setBackground(Color.cyan);
		bArr[8].setBackground(Color.orange);
		bArr[9].setBackground(Color.yellow);

		bArr[10].setBackground(Color.red);
		bArr[11].setBackground(Color.blue);
		bArr[12].setBackground(Color.green);

		add(p0);
		add(p1);
		add(l1);
		add(p2);
		add(l3);
		add(p3);
		
		this.setVisible(true);
	}
	
	public void setSnow() {
		body = new Panel();
		body.setBounds(150, 40, 100, 150);
		body.setBackground(Color.white);
		body.setLayout(null);
		
		// 얼굴
		left_eye = new Panel();
		left_eye.setBounds(30, 15, 5, 15);
		left_eye.setBackground(Color.black);
		left_eye.setLayout(null);
		body.add(left_eye);
		
		right_eye = new Panel();
		right_eye.setBounds(65, 15, 5, 15);
		right_eye.setBackground(Color.black);
		right_eye.setLayout(null);
		body.add(right_eye);

		nose = new Panel();
		nose.setBounds(40, 25, 20, 10);
		nose.setBackground(Color.orange);
		body.add(nose);

		mouse = new Panel();
		mouse.setBounds(35, 40, 30, 2);
		mouse.setBackground(Color.black);
		body.add(mouse);

		// 장식
		deco_1 = new Panel();
		deco_1.setBounds(0, 55, 110, 15);
		deco_1.setBackground(Color.gray);
		body.add(deco_1);

		deco_2 = new Panel();
		deco_2.setBounds(55, 70, 30, 30);
		deco_2.setBackground(Color.gray);
		body.add(deco_2);

		// 손
		left_hand = new Panel();
		left_hand.setBounds(125, 95, 5, 5);
		left_hand.setBackground(Color.black);

		right_hand = new Panel();
		right_hand.setBounds(270, 95, 5, 5);
		right_hand.setBackground(Color.black);

		left_arm = new Panel();
		left_arm.setBounds(130, 97, 20, 2);
		left_arm.setBackground(Color.black);

		right_arm = new Panel();
		right_arm.setBounds(250, 97, 20, 2);
		right_arm.setBackground(Color.black);

		p0.add(body);
		p0.add(left_hand);
		p0.add(right_hand);
		p0.add(left_arm);
		p0.add(right_arm);
	}
	
	public void setEvent() {
		addWindowListener(new WindowAdapter() { 
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		for (int i = 0; i < 13; i++)
			bArr[i].addActionListener(new color_bClick1());
	}
	
	class visible implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			if (c1.getSelectedItem() == c1.getItem(0)
					|| c1.getSelectedItem() == c1.getItem(3)
					|| c1.getSelectedItem() == c1.getItem(4))
				c2.setEnabled(true);
			else
				c2.setEnabled(false);
		}
	}
	
	public void changeColor(Color c) {
		if (c1.getSelectedItem() == c1.getItem(0)
				&& c2.getSelectedItem() == c2.getItem(0)) {
			left_eye.setBackground(c);
			right_eye.setBackground(c);
		}
		
		if (c1.getSelectedItem() == c1.getItem(0)
				&& c2.getSelectedItem() == c2.getItem(1)) {
			left_eye.setBackground(c);
		}
		
		if (c1.getSelectedItem() == c1.getItem(0)
				&& c2.getSelectedItem() == c2.getItem(2)) {
			right_eye.setBackground(c);
		}

		
		if (c1.getSelectedItem() == c1.getItem(1)) {
			nose.setBackground(c);
		}

		if (c1.getSelectedItem() == c1.getItem(2)) {
			mouse.setBackground(c);
		}
		
		if (c1.getSelectedItem() == c1.getItem(3)
				&& c2.getSelectedItem() == c2.getItem(0)) {
			left_arm.setBackground(c);
			right_arm.setBackground(c);
		}

		if (c1.getSelectedItem() == c1.getItem(3)
				&& c2.getSelectedItem() == c2.getItem(1)) {
			left_arm.setBackground(c);
		}
		
		if (c1.getSelectedItem() == c1.getItem(3)
				&& c2.getSelectedItem() == c2.getItem(2)) {
			right_arm.setBackground(c);
		}

		if (c1.getSelectedItem() == c1.getItem(4)
				&& c2.getSelectedItem() == c2.getItem(0)) {
			left_hand.setBackground(c);
			right_hand.setBackground(c);
		}
		
		if (c1.getSelectedItem() == c1.getItem(4)
				&& c2.getSelectedItem() == c2.getItem(1)) {
			left_hand.setBackground(c);
		}
		
		if (c1.getSelectedItem() == c1.getItem(4)
				&& c2.getSelectedItem() == c2.getItem(2)) {
			right_hand.setBackground(c);
		}

		
		if (c1.getSelectedItem() == c1.getItem(5)) {
			body.setBackground(c);
		}

		if (c1.getSelectedItem() == c1.getItem(6)) {
			deco_1.setBackground(c);
			deco_2.setBackground(c);
		}
		
		if (c1.getSelectedItem() == c1.getItem(7)) {
			p0.setBackground(c);
		}
	}
	
	class color_bClick1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Button b = (Button)e.getSource();
			Color c = b.getBackground();
			changeColor(c);
		}
	}
	
	class color_bClick2 implements ActionListener {
        JColorChooser chooser=new JColorChooser();

		public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
            if(cmd.equals(b1.getLabel())){
                Color c = chooser.showDialog(null, b1.getLabel(), Color.white);
                if(c != null)
        			changeColor(c);
            }
		}
	}
	
	class color_bClick3 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int r = (int)(Math.random() * 256); 
			int g = (int)(Math.random() * 256); 
			int b = (int)(Math.random() * 256); 
			Color c = new Color(r, g, b);
			changeColor(c);
		}
	}
	
//	public static void main(String[] args) {
//		new AddEvent1("달라도 괜찮아");
//	}

}
