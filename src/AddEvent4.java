

import java.io.*;

import java.awt.*;
import java.awt.event.*;

import javax.sound.sampled.*;

import javax.swing.*;
import javax.swing.event.*;

public class AddEvent4 extends Frame{
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize(); 
	
	Label l1, l2_1, l2_2, l3;
	Panel p1, p2;
	Button bArr[] = new Button[4];

	Label p2_1[] = new Label[5];
	Label p2_2, p2_3;
	
	CheckboxGroup cbg[] = new CheckboxGroup[4];
	Checkbox cb1[] = new Checkbox[4];
	Checkbox cb2[] = new Checkbox[4];

	AddEvent4(String title){
		super(title);
		setLocation(screenSize.width / 2 - 200, screenSize.height / 2 - 300); 
		setSize(400, 600);
		setIconImage(new ImageIcon("images/icon.png").getImage());

		setLayout(null);
		setResizable(false);
		
		l1 = new Label("좋아하는 음악과 함께 드럼을 연주하세요!", Label.CENTER);
		l1.setBounds(20, 50, 360, 50);
		l1.setFont(new Font("Monospaced", Font.BOLD, 15));
		l1.setBackground(Color.black);
		l1.setForeground(Color.white);
		add(l1);
		
		l2_1 = new Label("< 연주 방법 >", Label.CENTER);
		l2_1.setBounds(40, 120, 320, 30);
		l2_1.setFont(new Font("Monospaced", Font.PLAIN, 15));
		add(l2_1);

		l2_2 = new Label("버튼 클릭 / 키보드 방향키", Label.CENTER);
		l2_2.setBounds(40, 150, 320, 25);
		l2_2.setFont(new Font("Monospaced", Font.PLAIN, 15));
		add(l2_2);
		
		//
		
		p1 = new Panel();
		p1.setBounds(50, 190, 300, 150);
		p1.setLayout(null);
		p1.setBackground(Color.black);
		add(p1);
		
		for (int i = 0; i < 4; i++)
		{
			bArr[i] = new Button();
			bArr[i].setBackground(Color.black);
			bArr[i].setForeground(Color.white);
			bArr[i].setFont(new Font("Monospaced", Font.PLAIN, 15));
			bArr[i].addActionListener(new Click());
			bArr[i].setFocusable(false);
		}
		
		bArr[0].setLocation(0, 0);
		bArr[0].setSize(75, 150);
		bArr[0].setLabel("◀");

		bArr[1].setLocation(75, 0);
		bArr[1].setSize(150, 75);
		bArr[1].setLabel("▲");

		bArr[2].setLocation(75, 75);
		bArr[2].setSize(150, 75);
		bArr[2].setLabel("▼");
		
		bArr[3].setLocation(225, 0);
		bArr[3].setSize(75, 150);
		bArr[3].setLabel("▶");
		
		for (int i = 0; i < 4; i++)
			p1.add(bArr[i]);
		
		//
		
		l3 = new Label("자신만의 드럼 소리를 설정하세요!", Label.CENTER);
		l3.setBounds(20, 375, 360, 25);
		l3.setFont(new Font("Monospaced", Font.PLAIN, 15));
		add(l3);
		
		p2 = new Panel();
		p2.setBounds(50, 415, 300, 150);
		p2.setLayout(new GridLayout(3, 5));
		p2.setBackground(Color.black);
		add(p2);
		
		for (int i = 0; i < 5; i++) {
			p2_1[i] = new Label();
			p2_1[i].setForeground(Color.white);
			p2.add(p2_1[i]);
		}
		
		p2_1[1].setText("◀");
		p2_1[2].setText("▲");
		p2_1[3].setText("▼");
		p2_1[4].setText("▶");

		for (int i = 0; i < 4; i++)
			cbg[i] = new CheckboxGroup();
		p2_2 = new Label("1", Label.CENTER);
		p2_2.setFont(new Font("Monospaced", Font.BOLD, 15));
		p2_2.setForeground(Color.white);
		p2.add(p2_2);
		cb1[0] = new Checkbox("", cbg[0], true);
		cb1[1] = new Checkbox("", cbg[1], true);
		cb1[2] = new Checkbox("", cbg[2], true);
		cb1[3] = new Checkbox("", cbg[3], true);
		for (int i = 0; i < 4; i++)
		{
			cb1[i].setFocusable(false);
			p2.add(cb1[i]);
		}

		p2_3 = new Label("2", Label.CENTER);
		p2_3.setFont(new Font("Monospaced", Font.BOLD, 15));
		p2_3.setForeground(Color.white);
		p2.add(p2_3);
		cb2[0] = new Checkbox("", cbg[0], false);
		cb2[1] = new Checkbox("", cbg[1], false);
		cb2[2] = new Checkbox("", cbg[2], false);
		cb2[3] = new Checkbox("", cbg[3], false);
		for (int i = 0; i < 4; i++)
		{
			cb2[i].setFocusable(false);
			p2.add(cb2[i]);
		}
		
	    setFocusable(true);
	    requestFocusInWindow();
	    
	    addKeyListener(new KeyAdapter() {
	        public void keyPressed(KeyEvent e) {
	            int keyCode = e.getKeyCode();
	            switch (keyCode) {
	                case KeyEvent.VK_LEFT :
	    				if (cb1[0].getState())
	    					Play("music/1_1.wav");
	    				else
	    					Play("music/2_1.wav");
	                    break;
	                case KeyEvent.VK_UP :
	    				if (cb1[1].getState())
	    					Play("music/1_2.wav");
	    				else
	    					Play("music/2_2.wav");
	                    break;
	                case KeyEvent.VK_DOWN :
	    				if (cb1[2].getState())
	    					Play("music/1_3.wav");
	    				else
	    					Play("music/2_3.wav");
	                    break;
	                case KeyEvent.VK_RIGHT :
	    				if (cb1[3].getState())
	    					Play("music/1_4.wav");
	    				else
	    					Play("music/2_4.wav");
	                    break;
	            }
	        }
	    });
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		setVisible(true);
	}
	
	class Click implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Button b = (Button)e.getSource();
			String bstr = b.getLabel();
			
			if (bstr.equals("◀"))
				if (cb1[0].getState())
					Play("music/1_1.wav");
				else
					Play("music/2_1.wav");
			if (bstr.equals("▲"))
				if (cb1[1].getState())
					Play("music/1_2.wav");
				else
					Play("music/2_2.wav");
			if (bstr.equals("▼"))
				if (cb1[2].getState())
					Play("music/1_3.wav");
				else
					Play("music/2_3.wav");
			if (bstr.equals("▶"))
				if (cb1[3].getState())
					Play("music/1_4.wav");
				else
					Play("music/2_4.wav");
		}
	}
	
    public void Play(String fileName)
    {
        try
        {
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File(fileName));
            Clip clip = AudioSystem.getClip();
            clip.stop();
            clip.open(ais);
            clip.start();
        }
        catch (Exception ex)
        {
        	ex.printStackTrace();
        }
    }
	
//	public static void main(String[] args) {
//		new AddEvent4("함께라 괜찮아");
//	}
}

