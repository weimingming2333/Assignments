package source;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class AboutPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					AboutPage frame = new AboutPage();
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
	public AboutPage() {
		setResizable(false);
		setTitle("\u5173\u4E8E\u672C\u6E38\u620F");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 528, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uD83D\uDC0D");
		lblNewLabel.setForeground(new Color(50, 205, 50));
		lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 47));
		lblNewLabel.setBounds(44, 13, 74, 76);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u8D2A\u5403\u86C7");
		lblNewLabel_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));
		lblNewLabel_1.setBounds(132, 13, 137, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Greedy Snake");
		lblNewLabel_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));
		lblNewLabel_2.setBounds(132, 44, 137, 33);
		contentPane.add(lblNewLabel_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		textArea.setText("\u7248\u672C\uFF1A0.3\r\n\u6700\u540E\u4FEE\u6539\u65E5\u671F\uFF1A2022/11/27\r\n\u4F5C\u8005\uFF1A\u672A\u547D\u540D\r\n\r\n\u66F4\u65B0\u5185\u5BB9 ver0.3:\r\n\u8BBE\u7F6E\u9762\u677F\u53EF\u8BBE\u5B9A\u969C\u788D\u7269\u4E2A\u6570\u548C\u521D\u59CB\u86C7\u957F\r\n\r\n\u66F4\u65B0\u5185\u5BB9 ver0.2\uFF1A\r\n\u89E3\u51B3\u6E38\u620F\u5931\u8D25\u540E\u53C8\u663E\u793A\u6682\u505C\u4FE1\u606F\u7684\u95EE\u9898\r\n\r\n\u53C2\u8003\uFF1A\r\nhttps://www.jb51.net/article/186780.htm\r\nhttps://blog.csdn.net/lm12032015/article/\r\ndetails/123068630\r\n");
		textArea.setBounds(41, 102, 377, 164);
		contentPane.add(textArea);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(41, 102, 433, 164);
		contentPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		btnNewButton.setBounds(197, 279, 113, 27);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
	}
}
