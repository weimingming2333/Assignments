package source;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.FlowLayout;

public class HowToPlay extends JFrame {

	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					HowToPlay frame = new HowToPlay();
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
	public HowToPlay() {
		setTitle("\u5982\u4F55\u6E38\u73A9");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelCenter = new JPanel();
		CardLayout card = new CardLayout(5, 5);
		contentPane.add(panelCenter);
		panelCenter.setLayout(card);
		
//		JPanel page1 = null, page2 = null, page3 = null;
		
		JPanel page1 = new JPanel();
		JLabel img1 = new JLabel();
		img1.setIcon(new ImageIcon("help\\p1.png"));
		page1.add(img1);
		panelCenter.add(page1);
		
		JPanel page2 = new JPanel();
		JLabel img2 = new JLabel();
		img2.setIcon(new ImageIcon("help\\p2.png"));
		page2.add(img2);
		panelCenter.add(page2);
		
		JPanel page3 = new JPanel();
		JLabel img3 = new JLabel();
		img3.setIcon(new ImageIcon("help\\p3.png"));
		page3.add(img3);
		panelCenter.add(page3);
		
		JPanel page4 = new JPanel();
		JLabel img4 = new JLabel();
		img4.setIcon(new ImageIcon("help\\p4.png"));
		page4.add(img4);
		panelCenter.add(page4);
		
		JPanel page5 = new JPanel();
		JLabel img5 = new JLabel();
		img5.setIcon(new ImageIcon("help\\p5.png"));
		page5.add(img5);
		panelCenter.add(page5);
		
		JPanel page6 = new JPanel();
		JLabel img6 = new JLabel();
		img6.setIcon(new ImageIcon("help\\p6.png"));
		page6.add(img6);
		panelCenter.add(page6);
		
		JPanel page7 = new JPanel();
		JLabel img7 = new JLabel();
		img7.setIcon(new ImageIcon("help\\p7.png"));
		page7.add(img7);
		panelCenter.add(page7);
		
		JPanel panelSouth = new JPanel();
		contentPane.add(panelSouth, BorderLayout.SOUTH);
		panelSouth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btn_pre = new JButton("< ÉÏÒ»Ò³");
		btn_pre.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		panelSouth.add(btn_pre);
		btn_pre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.previous(panelCenter);
			}
		});
		
		JButton start = new JButton("¿ªÊ¼ÓÎÏ·");
		start.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		panelSouth.add(start);
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton btn_next = new JButton("ÏÂÒ»Ò³  >");
		btn_next.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		panelSouth.add(btn_next);
		btn_next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.next(panelCenter);
			}
		});
	}

}
