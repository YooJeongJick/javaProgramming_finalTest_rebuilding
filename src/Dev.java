import java.awt.*;
import java.awt.event.*;

import javax.swing.ImageIcon;

public class Dev extends Frame{
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize(); 
	// 화면에 너비, 높이 정보를 screenSize에 대입 

	Image img;
	
	Dev(String title) {
		super(title);
		
		setLocation(screenSize.width / 2 - 480, screenSize.height / 2 - 270);
		setSize(960, 540); 
		setIconImage(new ImageIcon("images/icon.png").getImage());
		setResizable(false);

		img = tk.getImage("images/dev.png");
		
		addWindowListener(new WindowAdapter() { // 프레임 닫기 이벤트
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		setVisible(true);
	}

	// paint() 호출 시점 3가지
	// 1. 화면이 처음 보여지는 순간
	// 2. 화면이 다른 화면에 가려졌다가 다시 보여지는 순간
	// 3. 최소화에서 다시 화면에 다시 보여지는 순간
	
	public void paint(Graphics g) { // 오버라이딩
		g.drawImage(img, 0, 0, this);
	}
	
//	public static void main(String[] args) {
//		new Dev("개발자 소개");
//	}
	
}
