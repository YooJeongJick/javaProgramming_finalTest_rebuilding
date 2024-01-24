import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class AddEvent1 extends Frame {
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize(); 
	
	Panel snow_BG, choice_BG, NC_BG, SC_BG;
	Choice choice_part, choice_LR;
	Label NC_title, NC_nullBG, SC_title;
	Button NC_button[] = new Button[13];
	Button SC_SButton, SC_RButton;
	
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

		snow_BG = new Panel();
		snow_BG.setBounds(0, 0, 400, 200);
		snow_BG.setBackground(Color.lightGray);
		snow_BG.setLayout(null);
		
		choice_BG = new Panel();
		choice_BG.setBounds(25, 200, 350, 50);
		choice_BG.setLayout(new GridLayout(1, 2, 5, 5));
		
		choice_part = new Choice();
		choice_part.add("눈");
		choice_part.add("코");
		choice_part.add("입");
		choice_part.add("팔");
		choice_part.add("손");
		choice_part.add("몸");
		choice_part.add("장식");
		choice_part.add("배경");
		choice_part.addItemListener(new choice_L());
		choice_BG.add(choice_part);
		
		choice_LR = new Choice();
		choice_LR.add("양쪽");
		choice_LR.add("왼쪽");
		choice_LR.add("오른쪽");
		choice_LR.addItemListener(new choice_L());
		choice_BG.add(choice_LR);
		
		//
		
		NC_title = new Label("< 기본 색상 >", Label.CENTER);
		NC_title.setBounds(0, 250, 400, 50);
		NC_title.setFont(new Font("Monospaced", Font.PLAIN, 20));
		
		NC_BG = new Panel();
		NC_BG.setBounds(25, 300, 350, 150);
		NC_BG.setLayout(new GridLayout(3, 5, 5, 5));
		
		for (int i = 0; i < 10; i++) {
			NC_button[i] = new Button();
			NC_BG.add(NC_button[i]);
		}
		
		NC_nullBG = new Label();
		NC_BG.add(NC_nullBG);
		
		for (int i = 0; i < 3; i++) {
			NC_button[10 + i] = new Button();
			NC_BG.add(NC_button[10 + i]);
		}
		
		NC_button[0].setBackground(Color.white);
		NC_button[1].setBackground(Color.lightGray);
		NC_button[2].setBackground(Color.gray);
		NC_button[3].setBackground(Color.darkGray);
		NC_button[4].setBackground(Color.black);
		NC_button[5].setBackground(Color.pink);
		NC_button[6].setBackground(Color.magenta);
		NC_button[7].setBackground(Color.cyan);
		NC_button[8].setBackground(Color.orange);
		NC_button[9].setBackground(Color.yellow);
		NC_button[10].setBackground(Color.red);
		NC_button[11].setBackground(Color.blue);
		NC_button[12].setBackground(Color.green);
		
		//
		
		SC_title = new Label("< 특수 색상 >", Label.CENTER);
		SC_title.setBounds(0, 450, 400, 50);
		SC_title.setFont(new Font("Monospaced", Font.PLAIN, 20));
		
		SC_BG = new Panel();
		SC_BG.setBounds(25, 500, 350, 50);
		SC_BG.setLayout(new GridLayout(1, 2, 5, 5));
		
		SC_SButton = new Button("맞춤 색상");
		SC_BG.add(SC_SButton);
		
		SC_RButton = new Button("무작위 색상");
		SC_BG.add(SC_RButton);

		add(snow_BG);
		add(choice_BG);
		add(NC_title);
		add(NC_BG);
		add(SC_title);
		add(SC_BG);
		
		setVisible(true);
	}
	
	public void setSnow() {
		body = new Panel();
		body.setBounds(150, 40, 100, 150);
		body.setBackground(Color.white);
		body.setLayout(null);
		
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

		deco_1 = new Panel();
		deco_1.setBounds(0, 55, 110, 15);
		deco_1.setBackground(Color.gray);
		body.add(deco_1);

		deco_2 = new Panel();
		deco_2.setBounds(55, 70, 30, 30);
		deco_2.setBackground(Color.gray);
		body.add(deco_2);

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

		snow_BG.add(body);
		snow_BG.add(left_hand);
		snow_BG.add(right_hand);
		snow_BG.add(left_arm);
		snow_BG.add(right_arm);
	}
	
	public void setEvent() {
		addWindowListener(new WindowAdapter() { 
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		for (int i = 0; i < 13; i++)
			NC_button[i].addActionListener(new NC_button_L());
		
		SC_SButton.addActionListener(new SC_SButton_L());

		SC_RButton.addActionListener(new SC_RButton_L());
	}
	
	class choice_L implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			if (choice_part.getSelectedItem() == choice_part.getItem(0)
					|| choice_part.getSelectedItem() == choice_part.getItem(3)
					|| choice_part.getSelectedItem() == choice_part.getItem(4))
				choice_LR.setEnabled(true);
			else
				choice_LR.setEnabled(false);
		}
	}
	
	class NC_button_L implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Button b = (Button)e.getSource();
			Color c = b.getBackground();
			changeColor(c);
		}
	}
	
	class SC_SButton_L implements ActionListener {
        JColorChooser chooser=new JColorChooser();

		public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
            if(cmd.equals(SC_SButton.getLabel())){
                Color c = chooser.showDialog(null, SC_SButton.getLabel(), Color.white);
                if(c != null)
        			changeColor(c);
            }
		}
	}
	
	class SC_RButton_L implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int r = (int)(Math.random() * 256); 
			int g = (int)(Math.random() * 256); 
			int b = (int)(Math.random() * 256); 
			Color c = new Color(r, g, b);
			changeColor(c);
		}
	}
	
	public void changeColor(Color c) {
		if (choice_part.getSelectedItem() == choice_part.getItem(0)
				&& choice_LR.getSelectedItem() == choice_LR.getItem(0)) {
			left_eye.setBackground(c);
			right_eye.setBackground(c);
		}
		
		if (choice_part.getSelectedItem() == choice_part.getItem(0)
				&& choice_LR.getSelectedItem() == choice_LR.getItem(1)) {
			left_eye.setBackground(c);
		}
		
		if (choice_part.getSelectedItem() == choice_part.getItem(0)
				&& choice_LR.getSelectedItem() == choice_LR.getItem(2)) {
			right_eye.setBackground(c);
		}

		
		if (choice_part.getSelectedItem() == choice_part.getItem(1)) {
			nose.setBackground(c);
		}

		if (choice_part.getSelectedItem() == choice_part.getItem(2)) {
			mouse.setBackground(c);
		}
		
		if (choice_part.getSelectedItem() == choice_part.getItem(3)
				&& choice_LR.getSelectedItem() == choice_LR.getItem(0)) {
			left_arm.setBackground(c);
			right_arm.setBackground(c);
		}

		if (choice_part.getSelectedItem() == choice_part.getItem(3)
				&& choice_LR.getSelectedItem() == choice_LR.getItem(1)) {
			left_arm.setBackground(c);
		}
		
		if (choice_part.getSelectedItem() == choice_part.getItem(3)
				&& choice_LR.getSelectedItem() == choice_LR.getItem(2)) {
			right_arm.setBackground(c);
		}

		if (choice_part.getSelectedItem() == choice_part.getItem(4)
				&& choice_LR.getSelectedItem() == choice_LR.getItem(0)) {
			left_hand.setBackground(c);
			right_hand.setBackground(c);
		}
		
		if (choice_part.getSelectedItem() == choice_part.getItem(4)
				&& choice_LR.getSelectedItem() == choice_LR.getItem(1)) {
			left_hand.setBackground(c);
		}
		
		if (choice_part.getSelectedItem() == choice_part.getItem(4)
				&& choice_LR.getSelectedItem() == choice_LR.getItem(2)) {
			right_hand.setBackground(c);
		}

		
		if (choice_part.getSelectedItem() == choice_part.getItem(5)) {
			body.setBackground(c);
		}

		if (choice_part.getSelectedItem() == choice_part.getItem(6)) {
			deco_1.setBackground(c);
			deco_2.setBackground(c);
		}
		
		if (choice_part.getSelectedItem() == choice_part.getItem(7)) {
			snow_BG.setBackground(c);
		}
	}
	
	
	public static void main(String[] args) {
		new AddEvent1("달라도 괜찮아");
	}

}
