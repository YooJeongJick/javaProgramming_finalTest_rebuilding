

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class AddEvent3 extends Frame {
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize(); 
	
	Choice c1_1, c1_2, c2_1, c2_2;
	Panel p1_1, p1_2, p1_3;
	Label l1_1, l1_2, l1_3;
	Label l3_1, l3_2, l3_3;
	Button b1;
	
	Label n1[] = new Label[8];
	Label n2[] = new Label[4];
	Label n3[] = new Label[3];
	Label n4[] = new Label[2];
	
	Label null2[] = new Label[3];
	Label null3[] = new Label[2];
	Label null4;
	
	Panel p2_1, p2_2, p2_3, p2_4;
	
	AddEvent3(String title){
		super(title);
		setLocation(screenSize.width / 2 - 200, screenSize.height / 2 - 300); 
		setSize(400, 600);
		setIconImage(new ImageIcon("images/icon.png").getImage());

		setLayout(null);
		setResizable(false);
		
		// 1. 
		p1_1 = new Panel();
		p1_1.setBounds(40, 30, 320, 50);
		p1_1.setLayout(new GridLayout(1, 3, 5, 5));
		add(p1_1);
		
		l1_1 = new Label("나의 생일", Label.CENTER);
		l1_1.setFont(new Font("Monospaced", Font.PLAIN, 20));
		p1_1.add(l1_1);
		
		c1_1 = new Choice();
		choice1Add(c1_1);
		c1_1.addItemListener(new visible1());
		p1_1.add(c1_1);
		
		c1_2 = new Choice();
		choice2Add(c1_2);
		p1_1.add(c1_2);

		//
		
		p1_2 = new Panel();
		p1_2.setBounds(40, 80, 320, 50);
		p1_2.setLayout(new GridLayout(1, 3, 5, 5));
		add(p1_2);
		
		l1_2 = new Label("너의 생일", Label.CENTER);
		l1_2.setFont(new Font("Monospaced", Font.PLAIN, 20));
		p1_2.add(l1_2);
		
		c2_1 = new Choice();
		choice1Add(c2_1);
		c2_1.addItemListener(new visible2());
		p1_2.add(c2_1);
		
		c2_2 = new Choice();
		choice2Add(c2_2);
		p1_2.add(c2_2);

		//
		
		p1_3 = new Panel();
		p1_3.setBounds(40, 130, 320, 25);
		add(p1_3);
		
		b1 = new Button("조합 점수 확인");
		b1.setFont(new Font("Monospaced", Font.PLAIN, 10));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result();
			}
		});
		p1_3.add(b1);

		// 2.
		p2_1 = new Panel();
		p2_1.setBounds(40, 170, 320, 40);
		p2_1.setLayout(new GridLayout(1, 8));
		
		for (int i = 0; i < 8; i++) {
			n1[i] = new Label("?", Label.CENTER);
			p2_1.add(n1[i]);
		}
		
		n1[1].setBackground(Color.pink);
		n1[2].setBackground(Color.pink);
		n1[5].setBackground(Color.pink);
		n1[6].setBackground(Color.pink);
		
		add(p2_1);

		//
		
		p2_2 = new Panel();
		p2_2.setBounds(60, 250, 280, 40);
		p2_2.setLayout(new GridLayout(1, 7));
		p2_2.setBackground(Color.pink);
		
		for (int i = 0; i < 3; i++) {
			n2[i] = new Label("?", Label.CENTER);
			null2[i] = new Label(" ", Label.CENTER);
			p2_2.add(n2[i]);
			p2_2.add(null2[i]);
		}

		n2[3] = new Label("?", Label.CENTER);
		p2_2.add(n2[3]);
		add(p2_2);
		
		//

		p2_3 = new Panel();
		p2_3.setBounds(100, 330, 200, 40);
		p2_3.setLayout(new GridLayout(1, 5));
		p2_3.setBackground(Color.pink);
		
		for (int i = 0; i < 2; i++) {
			n3[i] = new Label("?", Label.CENTER);
			null3[i] = new Label(" ", Label.CENTER);
			p2_3.add(n3[i]);
			p2_3.add(null3[i]);
		}

		n3[2] = new Label("?", Label.CENTER);
		p2_3.add(n3[2]);
		add(p2_3);
		
		//
		
		p2_4 = new Panel();
		p2_4.setBounds(140, 410, 120, 40);
		p2_4.setLayout(new GridLayout(1, 3));
		p2_4.setBackground(Color.pink);

		n4[0] = new Label("?", Label.CENTER);
		null4 = new Label(" ", Label.CENTER);
		n4[1] = new Label("?", Label.CENTER);
		p2_4.add(n4[0]);
		p2_4.add(null4);
		p2_4.add(n4[1]);
		add(p2_4);

		// 3.
		l3_1 = new Label("우리의 조합 점수는?", Label.CENTER);
		l3_1.setBounds(40, 470, 320, 40);
		l3_1.setFont(new Font("Monospaced", Font.BOLD, 20));
		add(l3_1);
		
		l3_2 = new Label("(원점수)00점 + (추가점수)00점 = 000점", Label.CENTER);
		l3_2.setBounds(40, 510, 320, 30);
		l3_2.setFont(new Font("Monospaced", Font.PLAIN, 15));
		add(l3_2);

		l3_3 = new Label(" ", Label.CENTER);
		l3_3.setBounds(40, 540, 320, 30);
		l3_3.setFont(new Font("Monospaced", Font.PLAIN, 15));
		l3_3.setVisible(false);
		add(l3_3);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		setVisible(true);
	}
	
	// 1.
	void choice1Add(Choice c)
	{
		for (int i = 0; i < 12; i++)
			c.add((i +1) + "월");
	}
	
	void choice2Add(Choice c)
	{
		for (int i = 0; i < 31; i++)
			c.add((i +1) + "일");
	}
	
	class visible1 implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			c1_2.removeAll();
			
			String checkMonth = c1_1.getSelectedItem();
			int day;
			
			int month = Integer.parseInt(checkMonth.substring(0, checkMonth.length() - 1));
			day = setDay(month);
			
			for (int i = 0; i < day; i++)
				c1_2.add((i +1) + "일");
		}
	}
	
	class visible2 implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			c2_2.removeAll();
			
			String checkMonth = c2_1.getSelectedItem();
			int day;
			
			int month = Integer.parseInt(checkMonth.substring(0, checkMonth.length() - 1));
			day = setDay(month);
			
			for (int i = 0; i < day; i++)
				c2_2.add((i +1) + "일");
		}
	}

	int setDay(int month) {
		switch (month) {
		case 2 : return 28;
		case 4 :
		case 6 :
		case 9 :
		case 11 : return 30;
		default : return 31;
		}
	}

	// 2.
	void result() {
		String c1_1_Month;
		String c1_1_Month1;
		String c1_1_Month2;
		
		String c1_2_day;
		String c1_2_day1;
		String c1_2_day2;
		
		String c2_1_Month;
		String c2_1_Month1;
		String c2_1_Month2;
		
		String c2_2_day;
		String c2_2_day1;
		String c2_2_day2;

		if (c1_1.getSelectedItem() == c1_1.getItem(9)
				|| c1_1.getSelectedItem() == c1_1.getItem(10)
				|| c1_1.getSelectedItem() == c1_1.getItem(11)) 
		{
			c1_1_Month = c1_1.getSelectedItem();
			c1_1_Month1 = c1_1_Month.substring(0, 1);
			c1_1_Month2 = c1_1_Month.substring(1, 2);
		}
		else
		{
			c1_1_Month1 = "0";
			c1_1_Month2 = c1_1.getSelectedItem();
			c1_1_Month2 = c1_1_Month2.substring(0, 1);
		}
		n1[0].setText(c1_1_Month1);
		n1[2].setText(c1_1_Month2);

		if (c1_2.getSelectedItem() == c1_2.getItem(0)
				|| c1_2.getSelectedItem() == c1_2.getItem(1)
				|| c1_2.getSelectedItem() == c1_2.getItem(2)
				|| c1_2.getSelectedItem() == c1_2.getItem(3)
				|| c1_2.getSelectedItem() == c1_2.getItem(4)
				|| c1_2.getSelectedItem() == c1_2.getItem(5)
				|| c1_2.getSelectedItem() == c1_2.getItem(6)
				|| c1_2.getSelectedItem() == c1_2.getItem(7)
				|| c1_2.getSelectedItem() == c1_2.getItem(8))
		{
			c1_2_day1 = "0";
			c1_2_day2 = c1_2.getSelectedItem();
			c1_2_day2 = c1_2_day2.substring(0, 1);
		}
		else 
		{
			c1_2_day = c1_2.getSelectedItem();
			c1_2_day1 = c1_2_day.substring(0, 1);
			c1_2_day2 = c1_2_day.substring(1, 2);
		}
		n1[4].setText(c1_2_day1);
		n1[6].setText(c1_2_day2);
		
		//
		
		if (c2_1.getSelectedItem() == c2_1.getItem(9)
				|| c2_1.getSelectedItem() == c2_1.getItem(10)
				|| c2_1.getSelectedItem() == c2_1.getItem(11)) 
		{
			c2_1_Month = c2_1.getSelectedItem();
			c2_1_Month1 = c2_1_Month.substring(0, 1);
			c2_1_Month2 = c2_1_Month.substring(1, 2);
		}
		else
		{
			c2_1_Month1 = "0";
			c2_1_Month2 = c2_1.getSelectedItem();
			c2_1_Month2 = c2_1_Month2.substring(0, 1);
		}
		n1[1].setText(c2_1_Month1);
		n1[3].setText(c2_1_Month2);
		
		if (c2_2.getSelectedItem() == c2_2.getItem(0)
				|| c2_2.getSelectedItem() == c2_2.getItem(1)
				|| c2_2.getSelectedItem() == c2_2.getItem(2)
				|| c2_2.getSelectedItem() == c2_2.getItem(3)
				|| c2_2.getSelectedItem() == c2_2.getItem(4)
				|| c2_2.getSelectedItem() == c2_2.getItem(5)
				|| c2_2.getSelectedItem() == c2_2.getItem(6)
				|| c2_2.getSelectedItem() == c2_2.getItem(7)
				|| c2_2.getSelectedItem() == c2_2.getItem(8))
		{
			c2_2_day1 = "0";
			c2_2_day2 = c2_2.getSelectedItem();
			c2_2_day2 = c2_2_day2.substring(0, 1);
		}
		else 
		{
			c2_2_day = c2_2.getSelectedItem();
			c2_2_day1 = c2_2_day.substring(0, 1);
			c2_2_day2 = c2_2_day.substring(1, 2);
		}
		n1[5].setText(c2_2_day1);
		n1[7].setText(c2_2_day2);
		
		//
		
		int num1[] = new int[8];
		for (int i = 0; i < 8; i++)
			num1[i] = Integer.parseInt(n1[i].getText());
		
		int num2[] = new int[4];
		for (int i = 0; i < 4; i++) {
			num2[i] = num1[i * 2] + num1[i * 2 + 1];
			
			if (num2[i] == 10)
				num2[i] = 0;
			if (num2[i] > 10)
				num2[i] -= 10;
		}

		String num2_s[] = new String[4];
		for (int i = 0; i < 4; i++) {
			num2_s[i] = String.valueOf(num2[i]);
			n2[i].setText(num2_s[i]);
		}
		
		//

		int num3[] = new int[3];
		for (int i = 0; i < 3; i++) {
			num3[i] = num2[i] + num2[i + 1];
			
			if (num3[i] == 10)
				num3[i] = 0;
			if (num3[i] > 10)
				num3[i] -= 10;
		}
		String num3_s[] = new String[3];
		for (int i = 0; i < 3; i++) {
			num3_s[i] = String.valueOf(num3[i]);
			n3[i].setText(num3_s[i]);
		}
		
		//
						
		if (num3[0] == 1 && num3[1] == 0 && num3[2] == 0) {
			for (int i = 0; i < 2; i++) 
				n4[i].setText(" ");
			
			l3_3.setVisible(true);
			l3_2.setText("(원점수)000점 + (추가점수)00점 = 000점");
			l3_3.setText("(원점수)100점 + (추가점수)00점 = 100점");
		}
		else {
			int num4[] = new int[2];
			for (int i = 0; i < 2; i++) {
				num4[i] = num3[i] + num3[i + 1];
				
				if (num4[i] == 10)
					num4[i] = 0;
				if (num4[i] > 10)
					num4[i] -= 10;
			}
			String num4_s[] = new String[2];
			for (int i = 0; i < 2; i++) {
				num4_s[i] = String.valueOf(num4[i]);
				n4[i].setText(num4_s[i]);				
			}
			
			String totalNum_s = num4_s[0] + num4_s[1];	
			int totalNum = Integer.parseInt(totalNum_s);
			int bounsNum = 100 - totalNum;
			String bounsNum_s = String.valueOf(bounsNum);
			if (bounsNum < 10)
				bounsNum_s = "0" + bounsNum_s;
			
			l3_3.setVisible(true);
			l3_2.setText("(원점수)00점 + (추가점수)00점 = 000점");
			l3_3.setText("(원점수)" + totalNum_s + "점 + (추가점수)" + bounsNum_s + "점 = 100점");
			if (bounsNum == 100) 
			{
				l3_2.setText("(원점수)00점 + (추가점수)000점 = 000점");
				l3_3.setText("(원점수)00점 + (추가점수)100점 = 100점");
			}
		}
	}
	
//	public static void main(String[] args) {
//		new AddEvent3("너라서 괜찮아");
//	}
}
