

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import java.math.*;

import java.io.*;
import javax.sound.sampled.*;

public class AddEvent5 extends Frame{
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize(); 

	Label l1, l2, l3, l4, l5;
	
	Panel p1;
	Label pl1;
	Label lt1;

	Button b1;
	Label lc1;
	
	int total;
	int x, y;
	int check;
	
	int time;
	
	AddEvent5(String title){
		super(title);
		setLocation(screenSize.width / 2 - 200, screenSize.height / 2 - 300); 
		setSize(400, 600);
		setIconImage(new ImageIcon("images/icon.png").getImage());
		
		setLayout(null);
		setResizable(false);
		setBackground(Color.black);
		
		try {
		    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			//
		}

		l1 = new Label("- 마우스 클릭을 통해 미래에 있는");
		l1.setBounds(30, 60, 360, 25);
		l1.setFont(new Font("Monospaced", Font.PLAIN, 15));
		l1.setForeground(Color.white);
		add(l1);
		
		l2 = new Label("  가능성을 찾을 수 있습니다");
		l2.setBounds(30, 85, 360, 25);
		l2.setFont(new Font("Monospaced", Font.PLAIN, 15));
		l2.setForeground(Color.white);
		add(l2);
		
		l3 = new Label("- 가능성은 미래에 무작위로 숨겨져 있으며,");
		l3.setBounds(30, 120, 360, 25);
		l3.setFont(new Font("Monospaced", Font.PLAIN, 15));
		l3.setForeground(Color.white);
		add(l3);

		l4 = new Label("  보이지 않습니다");
		l4.setBounds(30, 145, 360, 25);
		l4.setFont(new Font("Monospaced", Font.PLAIN, 15));
		l4.setForeground(Color.white);
		add(l4);
		
		l5 = new Label("< 미래 >", Label.CENTER);
		l5.setBounds(20, 200, 360, 50);
		l5.setFont(new Font("Monospaced", Font.BOLD, 20));
		l5.setForeground(Color.white);
		add(l5);

		//
		
		p1 = new Panel();
		p1.setBounds(50, 250, 300, 200);
		p1.setLayout(null);
		p1.setBackground(Color.white);
		add(p1);
		
		x = (int)(Math.random() * (201));
		y = (int)(Math.random() * (101));
		pl1 = new Label();
		pl1.setBounds(x, y, 100, 100);
		pl1.setBackground(Color.white);
		p1.add(pl1);
		
		//
		
		total = 0;
		lt1 = new Label("가능성 : " + total, Label.CENTER);
		lt1.setBounds(20, 450, 360, 50);
		lt1.setFont(new Font("Monospaced", Font.PLAIN, 20));
		lt1.setForeground(Color.white);
		add(lt1);
		
		//		
		
		pl1.addMouseListener(new MouseAdapter() { 
            public void mouseClicked(MouseEvent e) { 
        		total += 1;
        		lt1.setText("가능성 : " + total);
				Play("sound.wav");

        		x = (int)(Math.random() * (201));
        		y = (int)(Math.random() * (101));
        		pl1.setLocation(x, y);
        		
        		if (total > 10 && total % 10 == 1)
        			changeColor();
            }          
        });
				
        //
		
		b1 = new Button("가능성은 어디에?");
		b1.setBounds(140, 510, 120, 25);
		b1.setBackground(Color.white);
		b1.setForeground(Color.black);
		b1.setFont(new Font("Monospaced", Font.PLAIN, 10));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check = x + 50;
				if (check <= 150)
	        		JOptionPane.showMessageDialog(null, "내 가슴이 뛰는 곳!");
				else
	        		JOptionPane.showMessageDialog(null, "내가 옳다고 생각하는 곳!");
			}
		});
		add(b1);
		
		lc1 = new Label("00 : 00", Label.CENTER);
		lc1.setBounds(20, 540, 360, 25);
		lc1.setFont(new Font("Monospaced", Font.PLAIN, 15));
		lc1.setForeground(Color.white);
		add(lc1);
		
		time = 0;
		
        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	time += 1;
            	if (time < 10)
                	lc1.setText("00 : 0" + time);
            	else if (time < 60) {  
                    lc1.setText("00 : " + time);
                } else {
                    int minutes = time / 60;
                    int seconds = time % 60;
                    lc1.setText(String.format("%02d : %02d", minutes, seconds));
                }
            }
        });
        
        timer.start();
        
		//
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		setVisible(true);
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
    
    public void changeColor() {
		int r = (int)(Math.random() * 256); 
		int g = (int)(Math.random() * 256); 
		int b = (int)(Math.random() * 256); 
		Color c = new Color(r, g, b);
		setBackground(c);
		l1.setBackground(c);
		l2.setBackground(c);
		l3.setBackground(c);
		l4.setBackground(c);
		l5.setBackground(c);
		lt1.setBackground(c);
		lc1.setBackground(c);
    }

//	public static void main(String[] args) {
//		new AddEvent5("언제든 괜찮아");
//	}
}
