

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import java.math.*;

public class AddEvent2 extends Frame {
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize(); 
	
	Panel p1;
	Label scoreL, hpL;
	int score, hp;
	
	Image imgMain, imgSub, imgBack;
	JOptionPane jp1;
	int to_x, to_y;
	int main_x_pos, main_y_pos, sub_x_pos, sub_y_pos;
	int main_speed, sub_speed;
	double speedUP;
	int keyCode;

	AddEvent2(String title){
		super(title);
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
		
		p1 = new Panel();
		p1.setBounds(7, 30, 400, 30);
		p1.setLayout(new GridLayout(1, 2, 5, 5));
		p1.setBackground(Color.black);
		
		score = 0;
		scoreL = new Label();
		scoreL.setText(" score : " + score);
		scoreL.setForeground(Color.white);
		scoreL.setFont(new Font("SansSerif", Font.BOLD, 15));
//		scoreL.setBackground(Color.red);
		
		hp = 1;
		hpL = new Label();
		hpL.setText(" hp : " + hp);
		hpL.setForeground(Color.white);
		hpL.setFont(new Font("SansSerif", Font.BOLD, 15));
//		hpL.setBackground(Color.yellow);

		p1.add(scoreL);
		p1.add(hpL);
		
		add(p1);
		
		// 이미지 호출
        imgMain = tk.getImage("AddEvent2_img/imgM.png");
        imgSub = tk.getImage("AddEvent2_img/imgS.png");
        imgBack = tk.getImage("AddEvent2_img/imgB.png");
		
		// 캐릭터
		main_x_pos = 200 - 50;
		main_y_pos = 600 - 110;
		to_x = 0;
		main_speed = 1;
		
		// 아이템
		sub_x_pos = (int)(Math.random() * (400 - 50));
		sub_y_pos = 0;
		sub_speed = 15;
		
		// 캐릭터 이동 활성화
		addKeyListener(new KeyListener() {
			
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}
			
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				switch (keyCode) {
				case KeyEvent.VK_LEFT :
					to_x -= main_speed;
					break;
				case KeyEvent.VK_RIGHT :
					to_x += main_speed;
					break;
				}
				main_x_pos += to_x;
				if (main_x_pos < 0)
					main_x_pos = 0;
				if (main_x_pos > 400 - 100)
					main_x_pos = 400 - 100;
				repaint();
			}

			public void keyReleased(KeyEvent e) {
				int keyCode = e.getKeyCode();
				switch (keyCode) {
				case KeyEvent.VK_LEFT :
					to_x = 0;
					break;
				case KeyEvent.VK_RIGHT :
					to_x = 0;
					break;
				}
				main_x_pos += to_x;
				if (main_x_pos < 0)
					main_x_pos = 0;
				if (main_x_pos > 400 - 100)
					main_x_pos = 400 - 100;
				repaint();
			}
		});
				
        Timer timer = new Timer(20, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                // 캐릭터 이동
                main_x_pos += to_x;
                if (main_x_pos < 0)
                    main_x_pos = 0;
                if (main_x_pos > 400 - 100)
                    main_x_pos = 400 - 100;

                // 아이템 이동
                sub_y_pos += sub_speed;
                if (sub_y_pos > 600) {
                    sub_x_pos = (int) (Math.random() * (400 - 100));
                    sub_y_pos = 0;
                }
                
                // 아이템 충돌 처리
                if (getSub()) {
                    sub_x_pos = (int) (Math.random() * (400 - 100));
                    sub_y_pos = 0;
                    score += 100;
                    scoreL.setText(" score : " + score);
                    
                    if (score % 10000 == 0)
	                    speedUP = 0.2 * (score / 2500);
	                    sub_speed += speedUP;
                } 
                
                if (sub_y_pos == 600 && score >= 1000) {
                	hp -= 1;
            		hpL.setText(" hp : " + hp);
                	if (hp == 0)
                	{
//                		newTitle();
                		JOptionPane.showMessageDialog(null, 
                				"Total score : " + score + "\n오늘 하루는 사람들이 무지개를 볼 수 있겠다!");
                		dispose();
                	}
                }

                repaint();
            }
        });

        timer.start();
		
		addWindowListener(new WindowAdapter() { // 프레임 닫기 이벤트
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		this.setVisible(true);
	}
	
//	public void newTitle() {
//		this.setTitle("실수해도 괜찮아");
//	}
	
    public void update(Graphics g) {
        Image bufferImage = createImage(getWidth(), getHeight());
        Graphics bufferGraphics = bufferImage.getGraphics();
        paint(bufferGraphics);
        g.drawImage(bufferImage, 0, 0, this);
    }

	// 이미지 그리기
    public void paint(Graphics g) {
        g.drawImage(imgBack, 0, 0, this);
    	g.drawImage(imgMain, main_x_pos, main_y_pos, this);
        g.drawImage(imgSub, sub_x_pos, sub_y_pos, this);
    }

    public boolean getSub() {
        Rectangle mainRect = new Rectangle(main_x_pos, main_y_pos, 
        		imgMain.getWidth(this), imgMain.getHeight(this));
        Rectangle subRect = new Rectangle(sub_x_pos, sub_y_pos, 
        		imgSub.getWidth(this), imgSub.getHeight(this));
        return mainRect.intersects(subRect);
    }

//	public static void main(String[] args) {
//		new AddEvent2("못해도 괜찮아");
//	}
}
