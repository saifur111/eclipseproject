package MyGame;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class main {
     

	public static void main(String[] args) {
		JFrame ob=new JFrame();
		GameRun obj=new GameRun();
		int width=700,height=600;
		ob.setBounds(10,10,width,height);
        ob.setTitle("Brick Breaker");
        ob.setResizable(true);
        ob.setVisible(true);
        /////////This Code For Windows Center........
        int scrWidth=(int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int scrHeight=(int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        ob.setSize(width, height);
        ob.setLocation((scrWidth/2)-(width/2), (scrHeight/2)-(height/2));
        
        
        ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ////////Adding Game Run Class here..........
        ob.add(obj);
	}

}
