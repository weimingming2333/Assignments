package source;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;

public class MainPage extends JFrame {

	private GamePanel gPanel;
	private Settings settings;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					MainPage frame = new MainPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainPage() {
		setResizable(false);
		setTitle("\u8D2A\u5403\u86C7");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 920, 851);
		
		gPanel = new GamePanel();
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("  \u6E38\u620F(G) ");
		mnNewMenu.setMnemonic('G');		//…Ë÷√»»º¸
		mnNewMenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u5F00\u5C40(S)");
		mntmNewMenuItem.setMnemonic('S');
		mntmNewMenuItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		mnNewMenu.add(mntmNewMenuItem);
		//ø™æ÷
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gPanel.command(1);
			}
		});
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u6682\u505C/\u7EE7\u7EED\u6E38\u620F(P)");
		mntmNewMenuItem_1.setMnemonic('P');
		mntmNewMenuItem_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		mnNewMenu.add(mntmNewMenuItem_1);
		//‘›Õ£/ºÃ–¯”Œœ∑
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gPanel.command(2);
			}
		});
		
		mnNewMenu.addSeparator();	//∑÷∏Óœﬂ
		
//		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u6392\u884C\u699C(R)");
//		mntmNewMenuItem_2.setMnemonic('R');
//		mntmNewMenuItem_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
//		mnNewMenu.add(mntmNewMenuItem_2);
//		//≈≈––∞Ò
//		mntmNewMenuItem_2.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				
//			}
//		});
//		
//		mnNewMenu.addSeparator();	//∑÷∏Óœﬂ
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u9000\u51FA(E)");
		mntmNewMenuItem_3.setMnemonic('E');
		mntmNewMenuItem_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		mnNewMenu.add(mntmNewMenuItem_3);
		//ÕÀ≥ˆ
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		JMenu mnNewMenu_1 = new JMenu(" \u9009\u9879(O) ");
		mnNewMenu_1.setMnemonic('O');
		mnNewMenu_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		menuBar.add(mnNewMenu_1);
		
//		JCheckBoxMenuItem chckbxmntmNewCheckItem = new JCheckBoxMenuItem("\u97F3\u4E50(M)");
//		chckbxmntmNewCheckItem.setMnemonic('M');
//		chckbxmntmNewCheckItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
//		mnNewMenu_1.add(chckbxmntmNewCheckItem);
//		//“Ù¿÷
//		chckbxmntmNewCheckItem.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//			}
//		});
//		
//		
//		mnNewMenu_1.addSeparator();	//∑÷∏Óœﬂ
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u8BBE\u7F6E(E)");
		mntmNewMenuItem_5.setMnemonic('E');
		mntmNewMenuItem_5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		mnNewMenu_1.add(mntmNewMenuItem_5);
		//…Ë÷√ΩÁ√Ê
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gPanel.command(3);
//				settings.main(null);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
								UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
								Settings frame = new Settings();
								frame.setVisible(true);
						} catch (Exception e) {
								e.printStackTrace();
							}
					}
				});
			}
		});
		
		JMenu mnNewMenu_2 = new JMenu(" \u5E2E\u52A9(H) ");
		mnNewMenu_2.setMnemonic('H');
		mnNewMenu_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u5982\u4F55\u6E38\u73A9?(T)");
		mntmNewMenuItem_4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		mntmNewMenuItem_4.setMnemonic('T');
		mnNewMenu_2.add(mntmNewMenuItem_4);
		//»Á∫Œ”ŒÕÊΩÁ√Ê
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HowToPlay.main(null);
			}
		});
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("\u5173\u4E8E(A)");
		mntmNewMenuItem_6.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		mntmNewMenuItem_6.setMnemonic('A');
		mnNewMenu_2.add(mntmNewMenuItem_6);
		//πÿ”⁄ΩÁ√Ê
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gPanel.command(3);
				AboutPage.main(null);
			}
		});
		
		getContentPane().add(gPanel);
	}
	
	
	//ƒ⁄≤ø¿‡
	//…Ë÷√¥∞ø⁄
	class Settings extends JFrame implements ActionListener{

		private JPanel contentPane;
		private JTextField textField_1;
		private JTextField textField_2;
		private int getlen = 3;
		private int getnum = 0;

		/**
		 * Launch the application.
		 */
//		public static void main(String[] args) {
//			EventQueue.invokeLater(new Runnable() {
//				public void run() {
//					try {
//						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//						Settings frame = new Settings();
//						frame.setVisible(true);
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//				}
//			});
//		}

		/**
		 * Create the frame.
		 */
		public Settings() {
			int[] cmd = new int[4];
			
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setResizable(false);
			setTitle("\u6E38\u620F\u8BBE\u7F6E");
			setBounds(100, 100, 450, 533);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("\u63A7\u5236\u8BBE\u7F6E");
			lblNewLabel.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
			lblNewLabel.setBounds(28, 23, 72, 18);
			contentPane.add(lblNewLabel);
			
			JRadioButton rb11 = new JRadioButton("\u4F7F\u7528\u2191\u2193\u2190\u2192\u952E\u63A7\u5236");
			rb11.setSelected(!gPanel.isWASD);
			rb11.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
			rb11.setBounds(38, 50, 157, 27);
			contentPane.add(rb11);
			rb11.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					cmd[0] = 4;
				}
			});
			
			JRadioButton rb12 = new JRadioButton("\u4F7F\u7528WASD\u952E\u63A7\u5236");
			rb12.setSelected(gPanel.isWASD);
			rb12.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
			rb12.setBounds(227, 51, 157, 27);
			contentPane.add(rb12);
			rb12.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					cmd[0] = 5;
				}
			});
			ButtonGroup bg1 = new ButtonGroup();
			bg1.add(rb11);
			bg1.add(rb12);
			
			JLabel lblNewLabel_1 = new JLabel("\u96BE\u5EA6\u8BBE\u7F6E");
			lblNewLabel_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
			lblNewLabel_1.setBounds(28, 103, 72, 18);
			contentPane.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("\u754C\u9762\u5237\u65B0\u65F6\u95F4");
			lblNewLabel_2.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
			lblNewLabel_2.setBounds(38, 134, 98, 18);
			contentPane.add(lblNewLabel_2);
			
			JRadioButton rb21 = new JRadioButton("\u9ED8\u8BA4 100ms");
			rb21.setSelected(!gPanel.randomDelay);
			rb21.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
			rb21.setBounds(38, 159, 113, 27);
			contentPane.add(rb21);
			rb21.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					cmd[1] = 10;
				}
			});
			
			JRadioButton rb22 = new JRadioButton("\u968F\u673A");
			rb22.setSelected(gPanel.randomDelay);
			rb22.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
			rb22.setBounds(227, 159, 157, 27);
			contentPane.add(rb22);
			rb22.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					cmd[1] = 11;
				}
			});
			ButtonGroup bg2 = new ButtonGroup();
			bg2.add(rb21);
			bg2.add(rb22);
			
			JLabel lblNewLabel_3 = new JLabel("\u4F20\u9001\u95E8");
			lblNewLabel_3.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
			lblNewLabel_3.setBounds(38, 202, 72, 18);
			contentPane.add(lblNewLabel_3);
			
			JRadioButton rb31 = new JRadioButton("\u5173\u95ED");
			rb31.setSelected(!gPanel.hasGate);
			rb31.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
			rb31.setBounds(38, 229, 157, 27);
			contentPane.add(rb31);
			rb31.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					cmd[2] = 6;
				}
			});
			
			JRadioButton rb32 = new JRadioButton("\u5F00\u542F");
			rb32.setSelected(gPanel.hasGate);
			rb32.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
			rb32.setBounds(227, 230, 157, 27);
			contentPane.add(rb32);
			rb32.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					cmd[2] = 7;
				}
			});
			ButtonGroup bg3 = new ButtonGroup();
			bg3.add(rb31);
			bg3.add(rb32);
			
			JLabel label = new JLabel("\u969C\u788D\u7269");
			label.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
			label.setBounds(38, 271, 72, 18);
			contentPane.add(label);
			
			JRadioButton rb41 = new JRadioButton("ƒ¨»œ");
			rb41.setSelected(!gPanel.randomBarrier);
			rb41.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
			rb41.setBounds(38, 298, 62, 27);
			contentPane.add(rb41);
			rb41.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					cmd[3] = 8;
//					bblen = 
				}
			});
			
			textField_1 = new JTextField();
//			textField_1.setEditable(false);
			textField_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
			textField_1.setText(Integer.toString(gPanel.getBarrierNum()));
			textField_1.setBounds(109, 300, 62, 24);
			contentPane.add(textField_1);
			textField_1.setColumns(10);
			
			JLabel label_1 = new JLabel("\u4E2A");
			label_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
			label_1.setBounds(174, 303, 24, 18);
			contentPane.add(label_1);
			
			JRadioButton rb42 = new JRadioButton("\u968F\u673A\u4E2A\u6570\uFF081-50\uFF09");
			rb42.setSelected(gPanel.randomBarrier);
			rb42.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
			rb42.setBounds(227, 299, 157, 27);
			contentPane.add(rb42);
			rb42.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					cmd[3] = 9;
				}
			});
			ButtonGroup bg4 = new ButtonGroup();
			bg4.add(rb41);
			bg4.add(rb42);
			
			JButton btnNewButton = new JButton("\u786E\u8BA4\u5E76\u91CD\u65B0\u5F00\u59CB");
			btnNewButton.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
			btnNewButton.setBounds(132, 433, 157, 27);
			contentPane.add(btnNewButton);
			//»∑»œ∞¥≈•
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						getnum = Integer.parseInt(textField_1.getText());
						getlen = Integer.parseInt(textField_2.getText());
					} catch(Exception ex) {
						JOptionPane.showMessageDialog(contentPane,
		                        " ‰»Î”–ŒÛ£¨«ÎºÏ≤È≤¢÷ÿ–¬ÃÓ»Î(0<=À˘ÃÓ’œ∞≠ŒÔ ˝ƒø<=50,3<=≥ı º…ﬂ≥§<=100)",
		                        "Ã· æ",
		                        JOptionPane.INFORMATION_MESSAGE);
						textField_1.setText(Integer.toString(gPanel.getBarrierNum()));
						textField_2.setText(Integer.toString(gPanel.getSnakeLen()));
						return;
					}
					if(!(getnum>=0 && getnum<=50 && getlen>=3 && getlen <=100)) {
						JOptionPane.showMessageDialog(contentPane,
		                        " ‰»Î”–ŒÛ£¨«ÎºÏ≤È≤¢÷ÿ–¬ÃÓ»Î(0<=À˘ÃÓ’œ∞≠ŒÔ ˝ƒø<=50,3<=≥ı º…ﬂ≥§<=100)",
		                        "Ã· æ",
		                        JOptionPane.INFORMATION_MESSAGE);
						textField_1.setText(Integer.toString(gPanel.getBarrierNum()));
						textField_2.setText(Integer.toString(gPanel.getSnakeLen()));
						return;
					}
					
					dispose();
					for(int i = 0; i < 4; i++) {
						gPanel.command(cmd[i]);
					}
					gPanel.setBarrierNum(getnum);
					gPanel.setSankeLen(getlen);
					gPanel.command(1);
				}
			});
			
			JLabel label_2 = new JLabel("\u56FE\u50CF\u8BBE\u7F6E");
			label_2.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
			label_2.setBounds(28, 354, 72, 18);
			contentPane.add(label_2);
			
			JLabel lblNewLabel_4 = new JLabel("\u521D\u59CB\u957F\u5EA6");
			lblNewLabel_4.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
			lblNewLabel_4.setBounds(38, 385, 62, 18);
			contentPane.add(lblNewLabel_4);
			
			textField_2 = new JTextField();
//			textField_2.setEditable(false);
			textField_2.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
			textField_2.setText(Integer.toString(gPanel.getSnakeLen()));
			textField_2.setBounds(109, 382, 62, 24);
			contentPane.add(textField_2);
			textField_2.setColumns(10);
			
			JLabel lblNewLabel_5 = new JLabel("\u5355\u4F4D");
			lblNewLabel_5.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
			lblNewLabel_5.setBounds(174, 385, 72, 18);
			contentPane.add(lblNewLabel_5);
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
	
	
}
