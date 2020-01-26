package MyGame;

import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

import javax.swing.JPanel;


public class GameRun extends JPanel implements KeyListener,ActionListener {
    private boolean play=false;
    private int score=0;
    private int totalBricks=21;
    private Timer timer;
    private int dealy=8;
    private int playerX=310;
    private int ballposX=350;
    private int ballposY=500;
    private int ballXdir=-1;
    private int ballYdir=-2;
    private AreaGenerator map_obj;
	private int brickWideth;
	private int count=1;
    
    ////////constructor
    
    public GameRun() {
    	///////Send the parametar values map method
    	map_obj = new AreaGenerator(3,7);
    	addKeyListener(this);
    	setFocusable(true);
    	setFocusTraversalKeysEnabled(false);
    	timer=new Timer(dealy,this);
    	timer.start();
    }
    
    
    
    
    public void paint(Graphics g) {
    ///////BackGround 
    	g.setColor(Color.black);
    	g.fillRect(1, 1, 692, 592);
    	
    	
    //////// Calling the draw Function 
		map_obj.draw((Graphics2D)g); //converting 2D graphics....
		
    	
    //////////Borders
    	g.setColor(Color.yellow);
    	g.fillRect(0, 0, 3, 592);
    	g.fillRect(0, 0, 692,3);
    	g.fillRect(691, 0, 3,592);
    	
    //////////Add the Score...
    	g.setColor(Color.white);
    	g.setFont(new Font("serif",Font.BOLD,24));
    	g.drawString(""+score, 590, 30);
    	
    //////////Paddle
    	g.setColor(Color.green);
    	g.fillRect(playerX, 550, 100, 8);
    //////////The Ball
    	g.setColor(Color.yellow);
    	g.fillOval(ballposX, ballposY, 20, 20);
    	
    //////////Finished the total bricks.....
    	
    	if(totalBricks<=0) {
    		play=false;
    		ballYdir=0;
    		ballYdir=0;
    		g.setColor(Color.GREEN);
    		g.setFont(new Font("serif",Font.BOLD,30));
    		g.drawString("Level 2 ", 270, 300);
    		g.drawString("Your Scores: "+score, 235, 340);
    		
    		//Level 2;
    		play=true;
    		dealy=7;
			playerX=310;
		    ballposX=350;
			ballposY=500;
		    ballXdir=-1;
			ballYdir=-2;
			playerX=310;
			//score=0;
			totalBricks=32;
			map_obj=new AreaGenerator(4,8);
			repaint();
			count=2;
				   if(totalBricks<=0) {
						///Level 3;
						play=false;
						ballYdir=0;
						ballYdir=0;
						g.setColor(Color.GREEN);
						g.setFont(new Font("serif",Font.BOLD,30));
						g.drawString("Level 3 ", 270, 300);
						g.drawString("Your Scores: "+score, 235, 340);
						
						play=true;
						dealy=6;
						playerX=310;
					    ballposX=350;
						ballposY=500;
					    ballXdir=-1;
						ballYdir=-2;
						playerX=310;
						//score=0;
						totalBricks=40;
						map_obj=new AreaGenerator(5,8);
						repaint();
						count=3;
			
						if(totalBricks<=0){
								   
								///Level 4;
								
								
								play=false;
					    		ballYdir=0;
					    		ballYdir=0;
					    		g.setColor(Color.GREEN);
					    		g.setFont(new Font("serif",Font.BOLD,30));
					    		g.drawString("Level 4 ", 270, 300);
					    		g.drawString("Your Scores: "+score, 235, 340);
								
								play=true;
								dealy=5;
								playerX=310;
							    ballposX=350;
								ballposY=500;
							    ballXdir=-1;
								ballYdir=-2;
								playerX=310;
								//score=0;
								totalBricks=45;
								map_obj=new AreaGenerator(5,9);
								repaint();
								count=4;
										if(totalBricks<=0){
												   
												///Level 4;
												
												
												play=false;
									    		ballYdir=0;
									    		ballYdir=0;
									    		g.setColor(Color.GREEN);
									    		g.setFont(new Font("serif",Font.BOLD,30));
									    		g.drawString("Level 5 ", 270, 300);
									    		g.drawString("Your Scores: "+score, 235, 340);
												
												play=true;
												dealy=4;
												playerX=310;
											    ballposX=350;
												ballposY=500;
											    ballXdir=-1;
												ballYdir=-2;
												playerX=310;
												//score=0;
												totalBricks=50;
												map_obj=new AreaGenerator(5,10);
												repaint();
												count=5;
									}
			
			                  }
						
			            }
				
			
			     }
			
			
    		/*g.setFont(new Font("serif",Font.BOLD,20));
    		g.drawString("Press Enter To Restarting Game.", 200, 370);*/
    	

    	
    ///////////Scoreing and Game over Function..........
    	if(ballposY>570) {
    		play=false;
    		ballYdir=0;
    		ballYdir=0;
    		g.setColor(Color.GREEN);
    		g.setFont(new Font("serif",Font.BOLD,30));
    		g.drawString("Game Over ", 270, 300);
    		g.drawString("Your Scores: "+score, 235, 340);
    		
    		g.setFont(new Font("serif",Font.BOLD,20));
    		g.drawString("Press Enter To Restarting Game.", 200, 370);
    	}
    	
    	g.dispose();
    	
    }
	
	@Override
	public void keyTyped(KeyEvent e) {}
	
	@Override
	public void keyReleased(KeyEvent e) {}
	////////////press Action here
	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		
		if(play) {
		//////////////Detecting the Paddle
			if(new Rectangle(ballposX,ballposY,20,20).intersects(new Rectangle(playerX,550,100,8))){
				ballYdir=-ballYdir;
			}
			
			
	   //////////////inter section the position of ball and bricks.......
			
			A: for(int i=0;i<map_obj.map.length;i++) {
				for(int j=0;j<map_obj.map[0].length;j++) {
					if(map_obj.map[i][j]>0) { 
						//////////Createing  variable .....
						
						int brickX=j*map_obj.brickWidth+80;
						int brickY=i*map_obj.brickHeight+50;
						int brickwidth=map_obj.brickWidth;
						int brickHeight=map_obj.brickHeight;
						
						//////////Createing ractangle function......
						Rectangle rect=new Rectangle(brickX,brickY,brickwidth,brickHeight);
						Rectangle ballRect=new Rectangle(ballposX,ballposY,20,20);
						Rectangle brickRect=rect;
						 
						if(ballRect.intersects(brickRect)) {
						/////////call the setBricks funcion (in AreaGame class)  and change the value to zero......
							map_obj.setBrickValue(0,i,j);
							
							
							totalBricks--;//////////Bricks Decrising......
							score+=5;///Bricks point (5)......
							
							if(ballposX+19<=brickRect.x || ballposX+1>=brickRect.x+brickRect.width) {
								ballXdir=-ballXdir;/////////move ball Opposite direction For x Axis........
							}
							else
							{
								ballYdir=-ballYdir;/////////move ball Opposite direction For y Axis........
							}
							break A;               /////////Break the outer loop.....
						}
					}
				}
			}
				
		    //////////ball Movement 		
			ballposX+=ballXdir;
			ballposY+=ballYdir;
			if(ballposX<0) {////////// Less then Zero move opposite dir of x axis....
				ballXdir=-ballXdir;
			}
			if(ballposY<0) {////////// Less then Zero move opposite dir of y axis....
				ballYdir=-ballYdir;
		    }
			if(ballposX>670) {
				ballXdir=-ballXdir;
		    }
	    }
		
		repaint();///////////Here  Again Call the paint method........
	}

    /////////////Key Pressed Event.....
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(playerX >=600)
			{
				playerX=600;
			}
			else
			{
				moveRight();
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			if(playerX <10)
			{
				playerX=10;
			}
			else
			{
				moveLeft();
			}
		}
		
		///// Enter Key Button To restarting Game again......
		
		if(e.getKeyChar()==KeyEvent.VK_ENTER) {
		   if(!play) {
				play=true;
				playerX=310;
			    ballposX=350;
				ballposY=500;
			    ballXdir=-1;
				ballYdir=-2;
				playerX=310;
				score=0;
				if(count==1) {
				totalBricks=21;
				map_obj=new AreaGenerator(3,7);//// Passing arguments AreaGenerator Constructor.......
				}
				
				if(count==2) {
					totalBricks=21;
					map_obj=new AreaGenerator(4,8);//// Passing arguments AreaGenerator Constructor.......
					}
				if(count==3) {
					totalBricks=21;
					map_obj=new AreaGenerator(5,8);//// Passing arguments AreaGenerator Constructor.......
					}
				if(count==4) {
					totalBricks=21;
					map_obj=new AreaGenerator(5,9);//// Passing arguments AreaGenerator Constructor.......
					}
				if(count==5) {
					totalBricks=21;
					map_obj=new AreaGenerator(5,10);//// Passing arguments AreaGenerator Constructor.......
					}
				repaint();///// Here  Again Call the paint method........
			}
		}
	}
	
	////move Right
	public void moveRight() {
		play=true;
		playerX+=30;
	}
	
   ////move Left
	public void moveLeft() {
		play=true;
		playerX-=30;
	}

	





}
