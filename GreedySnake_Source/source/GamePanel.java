package source;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	//基本数据
	private int len = 3;
	private int delay = 100;
	private int[] snakex = new int[500];
	private int[] snakey = new int[500];
	private String dir = "R"; 	//蛇头朝向UP,DOWN,LEFT,RIGHT
	private Timer timer = new Timer(100, this);
	private boolean isFail = false;		//游戏是否失败
	private boolean isPause = true;		//游戏是否暂停
	private int foodx = 0;
	private int foody = 0;
	private Random rand = new Random();
	private int score = 0;	//游戏得分
	private int step = 20;
	
	//传送门
	private int gate1x = 80, gate1y = 80;
	private int gate2x = 400, gate2y = 400;
	//障碍
	private int[] barrierx = new int[55];
	private int[] barriery = new int[55];
	private int blen = 0;
	
	//设置操作变量
	public boolean isWASD = false;
	private boolean isRestart = false;
	public boolean hasGate = false;
	public boolean randomBarrier = false;
	public boolean randomDelay = false;
	
	//数据暂存变量
	private int tempSnakeLen = 3;
	private int tempBarrierNum = 0;
	
	public void init() {	//初始化数据
		len = tempSnakeLen;			
		dir = "R";
		blen = tempBarrierNum;
		snakex[0] = 200;			snakey[0] = 200;
		for(int i = 1; i < len; i++) {
			snakex[i] = snakex[i-1] - step;
			snakey[i] = 200;
		}
//		snakex[1] = 200 - step;		snakey[1] = 200;
//		snakex[2] = 200 - 2 * step;	snakey[2] = 200;
		
		do {	//生成位置,判定是否与蛇身冲突
			foodx = rand.nextInt(45) * 20;
			foody = rand.nextInt(35) * 20 + 80;
		}while(isConflict(foodx, foody, snakex, snakey, len));
		
		if(hasGate) {
			do {
				gate1x = rand.nextInt(45) * 20;
				gate1y = rand.nextInt(35) * 20 + 80;
			}while(isConflict(gate1x, gate1y, snakex, snakey, len) 
					|| gate1x == foodx && gate1y == foody);
			
			do {
				gate2x = rand.nextInt(45) * 20;
				gate2y = rand.nextInt(35) * 20 + 80;
			}while(isConflict(gate2x, gate2y, snakex, snakey, len) 
					|| gate2x == foodx && gate2y == foody
					|| gate2x == gate1x && gate2y == gate1y);
		}

		if(randomBarrier) {
			blen = rand.nextInt(50) + 1;
		}
//		if(randomBarrier) {
			
			for(int i = 0; i < blen; i++) {
				do {
					barrierx[i] = rand.nextInt(45) * 20;
					barriery[i] = rand.nextInt(35) * 20 + 80;
				}while(isConflict(barrierx[i], barriery[i], snakex, snakey, len) 
						|| barrierx[i] == foodx && barriery[i] == foody);
			}
//		}
		
		isFail = false;
		score = 0;
		delay = 100;
		timer.setDelay(delay);
	}
	
	public GamePanel() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		this.setBackground(Color.DARK_GRAY);
		
		init();
		this.setFocusable(true);
		this.addKeyListener(this);
		timer.start();
		
	}
	
	//从MainPage获取指令（菜单栏），响应相应操作
	public void command(int cmd) {	
		switch(cmd) {
		case 1: isRestart = true;		break;
		case 2: isPause = !isPause;		break;
		case 3: isPause = true;			break;
		case 4: isWASD = false;			break;
		case 5: isWASD = true;			break;
		case 6: hasGate = false;		break;
		case 7: hasGate = true;			break;
		case 8: randomBarrier = false;	break;
		case 9: randomBarrier = true;	break;
		case 10: randomDelay = false;	break;
		case 11: randomDelay = true;	break;
		}
		
	}
	
	public void setSankeLen(int setlen) {
		tempSnakeLen = setlen;
	}
	
	public int getSnakeLen() {
		return len;
	}
	
	public void setBarrierNum(int setnum) {
		tempBarrierNum = setnum;
	}
	
	public int getBarrierNum() {
		return blen;
	}
	
	
	//判定位置是否与蛇身冲突
	public boolean isConflict(int x, int y, int[] arrx, int[] arry, int arrlen) {
		for(int i = 0; i < arrlen; i++) {
			if(arrx[i] == x && arry[i] == y)
				return true;
		}
		return false;
	}
	
	
	//绘制游戏中的组件
	@Override
	protected void paintComponent(Graphics g) {		
		// TODO Auto-generated method stub
		super.paintComponent(g);
//		this.setBackground(Color.WHITE);
		
		g.setColor(Color.ORANGE);
		g.fillRect(0, 0, 900, 80);
		
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 80, 900, 720);
		
//		右边界和下边界
		g.setColor(Color.MAGENTA);
		g.fillRect(0, 780, 900, 20);
		
		g.setColor(Color.MAGENTA);
		g.fillRect(900, 80, 20, 720);
		
		//画蛇头
		g.setColor(new Color(2, 101, 211));
		g.fillRect(snakex[0], snakey[0], step, step);
		//画蛇身
		for(int i = 1; i < len ;i++) {
			g.setColor(new Color(21, 145, 216));
			g.fillRect(snakex[i], snakey[i], step, step);
		}
		
		//画果子
		g.setColor(new Color(252, 25, 68));
		g.fillOval(foodx, foody, step, step);
		
		//画传送门
		if(hasGate) {
			g.setColor(Color.GREEN);
			g.fillRect(gate1x, gate1y, 20, 20);
			g.setColor(Color.DARK_GRAY);
			g.fillRect(gate1x + 5, gate1y + 5, 10, 10);

			g.setColor(Color.GREEN);
			g.fillRect(gate2x, gate2y, 20, 20);
			g.setColor(Color.DARK_GRAY);
			g.fillRect(gate2x + 5, gate2y + 5, 10, 10);
		}
		
		//画障碍
//		if(randomBarrier) {
			for(int i = 0; i < blen; i++) {
				g.setColor(Color.YELLOW);
				g.fillRect(barrierx[i], barriery[i], step, step);
			}
//		}
		
		//绘制提示信息
		g.setColor(Color.WHITE);
		g.setFont(new Font("微软雅黑", Font.BOLD, 20));
		g.drawString("得分：" + score, 700, 30);
		g.drawString("界面刷新时间：" + timer.getDelay() + " ms", 20, 30);
		if(isWASD) {
			g.drawString("使用WASD控制", 20, 60);
		}else {
			g.drawString("使用↑↓←→控制", 20, 60);
		}
		g.drawString("障碍数：" + blen, 300, 30);
		g.drawString("长度：" + len, 300, 60);
		
		if(isPause && !isFail) {
			g.setColor(Color.WHITE);
			g.setFont(new Font("微软雅黑", Font.PLAIN, 30));
			g.drawString("游戏暂停  按Space或P键以继续", 220, 120);
		}
		if(isFail) {
			g.setColor(Color.WHITE);
			g.setFont(new Font("微软雅黑", Font.PLAIN, 30));
			g.drawString("游戏失败  按Space或P键重新开始", 220, 120);
		}
	}

	//定时器操作
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//吃果子判定
		if(snakex[0] == foodx && snakey[0] == foody) {
			len++;
			score++;
			do {	//生成位置,判定是否与蛇身冲突
				foodx = rand.nextInt(45) * 20;
				foody = rand.nextInt(35) * 20 + 80;
			}while(isConflict(foodx, foody, snakex, snakey, len) ||
					isConflict(foodx, foody, barrierx, barriery, blen));
		}
		
		//蛇的移动
		if(!isFail && !isPause) {
			for(int i = len-1; i > 0 ; i--) {
				snakex[i] = snakex[i-1];
				snakey[i] = snakey[i-1];
			}
			if(dir.equals("U"))
				snakey[0] -= step;
			else if(dir.equals("D"))
				snakey[0] += step;
			else if(dir.equals("L"))
				snakex[0] -= step;
			else if(dir.equals("R"))
				snakex[0] += step;
		}


		//碰撞判定
		if(snakex[0] >= 900 || snakex[0] < 0 ||
				snakey[0] >= 780 || snakey[0] < 80) {
			isFail = true;
		}
		for(int i = 1; i < len; i++) {
			if(snakex[0] == snakex[i] && snakey[0] == snakey[i])
				isFail = true;
		}
		
		//传送门判定
		if(snakex[0] == gate1x && snakey[0] == gate1y && hasGate) {
			snakex[0] = gate2x;
			snakey[0] = gate2y;
		}
		else if(snakex[0] == gate2x && snakey[0] == gate2y && hasGate) {
			snakex[0] = gate1x;
			snakey[0] = gate1y;
		}
		
		//障碍判定
		for(int i = 0; i < blen; i++) {
			if(snakex[0] == barrierx[i] && snakey[0] == barriery[i])
				isFail = true;
		}
		
//		//吃果子判定
//		if(snakex[0] == foodx && snakey[0] == foody) {
//			len++;
//			score++;
//			do {	//生成位置,判定是否与蛇身冲突
//				foodx = rand.nextInt(45) * 20;
//				foody = rand.nextInt(35) * 20 + 80;
//			}while(isConflict(foodx, foody, snakex, snakey, len) ||
//					isConflict(foodx, foody, barrierx, barriery, blen));
//		}
		
		//随机速度
		if(randomDelay) {
			int num = rand.nextInt(180) + 1;
			int num2 = (num % 2 == 0)? num : num % 10;
			timer.setDelay(num2);
		}
		//重新开始
		if(isRestart) {
			timer.stop();
			int ans = JOptionPane.showConfirmDialog(null, "是否重新开始？", "提示",
					JOptionPane.YES_NO_OPTION);
			if(ans == JOptionPane.YES_OPTION) {
				isRestart = false;
				init();
				repaint();
			}
			timer.restart();
		}
		//随机步长
//		step = rand.nextInt(40) + 10;
		
		repaint();
		timer.start();
	}

	//键盘控制
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		//游戏开始/暂停时的操作
		if(keyCode == KeyEvent.VK_P || keyCode == KeyEvent.VK_SPACE) {
			timer.stop();
			if(isFail) {
				isFail = false;
				init();
			}
			else {
				isPause = !isPause;
			}
	
			repaint();
			timer.restart();
		}
		//重新开始
		if(keyCode == KeyEvent.VK_R) {
			timer.stop();
			int ans = JOptionPane.showConfirmDialog(null, "是否重新开始？", "提示",
					JOptionPane.YES_NO_OPTION);
			if(ans == JOptionPane.YES_OPTION) {
				init();
				repaint();
			}
			timer.restart();
		}
		//作弊机制
		//按,键，time-=10
		if(keyCode == KeyEvent.VK_COMMA && delay >= 0) {
			delay -= 10;
			timer.setDelay(delay);
		}else if(keyCode == KeyEvent.VK_PERIOD) {
			delay += 10;
			timer.setDelay(delay);
		}
		
		//蛇的移动（↑↓←→）
		if(!isPause && !isFail && !isWASD) {
			if(keyCode == KeyEvent.VK_UP && !dir.equals("D"))
				dir = "U";
			else if(keyCode == KeyEvent.VK_DOWN && !dir.equals("U"))
				dir = "D";
			else if(keyCode == KeyEvent.VK_LEFT && !dir.equals("R"))
				dir = "L";
			else if(keyCode == KeyEvent.VK_RIGHT && !dir.equals("L"))
				dir = "R";	
		}
		
		//蛇的移动（WASD）
		if(!isPause && !isFail && isWASD) {
			if(keyCode == KeyEvent.VK_W && !dir.equals("D"))
				dir = "U";
			else if(keyCode == KeyEvent.VK_S && !dir.equals("U"))
				dir = "D";
			else if(keyCode == KeyEvent.VK_A && !dir.equals("R"))
				dir = "L";
			else if(keyCode == KeyEvent.VK_D && !dir.equals("L"))
				dir = "R";	
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
