import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuStart extends Frame{
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize(); 
	Image img;

	MenuStart(String title) {
		super(title);
		
		setLocation(screenSize.width / 2 - 480, screenSize.height / 2 - 270);
		setSize(960, 540); 
		setIconImage(new ImageIcon("images/icon.png").getImage());
		setResizable(false);
		
		img = tk.getImage("images/menu.png");
		
		MenuBar mb = new MenuBar();
		
		Menu mFile = new Menu("File");
		MenuItem miExit = new MenuItem("Exit", new MenuShortcut('E'));
		miExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		mFile.add(miExit);
		
		Menu mEvent1 = new Menu("Event");
		MenuItem miEvent1 = new MenuItem("Event1");
		miEvent1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Event1("Event1");
			}
		});
		
		MenuItem miEvent2 = new MenuItem("Event2");
		miEvent2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Event2("Event2");
			}
		});
		
		MenuItem miEvent3 = new MenuItem("Event3");
		miEvent3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Event3("Event3");
			}
		});
		
		mEvent1.add(miEvent1);
		mEvent1.add(miEvent2);
		mEvent1.add(miEvent3);
		
		Menu mEvent2 = new Menu("AddEvent");

		MenuItem miAddEvent1 = new MenuItem("AddEvent1");
		miAddEvent1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddEvent1("달라도 괜찮아");
			}
		});
		mEvent2.add(miAddEvent1);
		
		MenuItem miAddEvent2 = new MenuItem("AddEvent2");
		miAddEvent2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddEvent2("못해도 괜찮아");
			}
		});
		mEvent2.add(miAddEvent2);

		MenuItem miAddEvent3 = new MenuItem("AddEvent3");
		miAddEvent3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddEvent3("너라서 괜찮아");
			}
		});
		mEvent2.add(miAddEvent3);

		MenuItem miAddEvent4 = new MenuItem("AddEvent4");
		miAddEvent4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddEvent4("함께라 괜찮아");
			}
		});
		mEvent2.add(miAddEvent4);

		MenuItem miAddEvent5 = new MenuItem("AddEvent5");
		miAddEvent5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddEvent5("언제든 괜찮아");
			}
		});
		mEvent2.add(miAddEvent5);
		
		//
		
		Menu mHelp = new Menu("Help");
		MenuItem miHelp = new MenuItem("프로그램 소개");
		miHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Help("프로그램 소개");
			}
		});
		
		MenuItem miDev = new MenuItem("개발자 소개");
		miDev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Dev("개발자 소개");
			}
		});

		
		mHelp.add(miHelp);
		mHelp.add(miDev);

		// 메뉴바에 메뉴 붙이기
		mb.add(mFile);
		mb.add(mEvent1);
		mb.add(mEvent2);
		mb.add(mHelp);
		
		addWindowListener(new WindowAdapter() { // 프레임 닫기 이벤트
			public void windowClosing(WindowEvent e) {
				System.exit(0); 
			}
		});
		
		setMenuBar(mb);

		setVisible(true);
	}
	
	public void paint(Graphics g) { // 오버라이딩
		g.drawImage(img, 0, 30, this);
	}

	public static void main(String[] args) {
		new MenuStart("Java Project 유정");
	}
}
