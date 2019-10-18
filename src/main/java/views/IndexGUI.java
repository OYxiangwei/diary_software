package main.java.views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class IndexGUI extends JFrame {
	private JPanel contentPane;
	private static IndexGUI frame;

	public static void main(String[] args) {
		init();
	}

	public static void init() {

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					frame = new IndexGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}

	public IndexGUI() {
		setTitle("diary software");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lbnewJLabel = new JLabel("welcome to use diary");
		lbnewJLabel.setBounds(132, 74, 396, 36);
		lbnewJLabel.setFont(new Font("×ÖÌå", Font.BOLD | getFont().ITALIC, 30));
		contentPane.add(lbnewJLabel);
		JButton login = new JButton("login");
		login.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				event_login();
			}

		});
		login.setBounds(65, 264, 124, 45);
		contentPane.add(login);
		JButton registerButton = new JButton("sign up");
		registerButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				event_register();
			}

		});
		registerButton.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					event_register();
				}
			}

		});
		registerButton.setBounds(400, 264, 109, 45);
		contentPane.add(registerButton);
	}

	private void event_login() {
		setVisible(false);
		new LoginGUI().loginGUI();
	}

	private void event_register() {
		setVisible(false);
		new RegisterGUI().registerGUI();
	}

}
