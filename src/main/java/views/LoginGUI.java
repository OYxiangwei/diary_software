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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import main.java.util.JDOM;

public class LoginGUI extends JFrame {
	private final static long serialVersionUID = 4994949944841194839L;
	private JPanel contJPanel;
	private JLabel passwordLabel;
	private JTextField passwordTextField;
	private JTextField idTextField;
	private JButton loginButton;
	private JButton backButton;

	public void loginGUI() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 400);
		contJPanel = new JPanel();
		contJPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contJPanel);
		contJPanel.setLayout(null);

		JLabel IDlabel = new JLabel("Please input ID");// ID标签
		IDlabel.setBounds(68, 170, 100, 39);
		contJPanel.add(IDlabel);

		idTextField = new JTextField();
		idTextField.setBounds(220, 179, 126, 21);
		contJPanel.add(idTextField);
		idTextField.setColumns(10);

		passwordLabel = new JLabel("Please input password");
		passwordLabel.setBounds(68, 219, 150, 50);
		contJPanel.add(passwordLabel);

		passwordTextField = new JPasswordField();
		passwordTextField.setBounds(220, 234, 126, 21);
		contJPanel.add(passwordTextField);

		loginButton = new JButton("login");

		loginButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				event_login();
			}

		});

		loginButton.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					event_login();
				}
			}

		});
		loginButton.setBounds(239, 310, 93, 23);
		contJPanel.add(loginButton);

		backButton = new JButton("BACK");
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				IndexGUI.init();
				setVisible(false);
			}
		});
		backButton.setBounds(507, 310, 93, 23);
		contJPanel.add(backButton);

		// 标题
		JLabel label = new JLabel("Welcome to use KnowYou");
		label.setFont(new Font("字体", Font.BOLD | Font.ITALIC, 30));
		label.setBounds(142, 54, 386, 35);
		contJPanel.add(label);
	}

	private void event_login() {
		String id = idTextField.getText();
		String password = passwordTextField.getText();
		String flag = JDOM.read(id, password);
		if (flag.contains("Successful landing")) {
			String[] bufs = flag.split("/");
			String name = bufs[1];
			JOptionPane.showMessageDialog(contJPanel, "Welcome: " + name, "Welcome", JOptionPane.PLAIN_MESSAGE);
			UsersGUI.init(name);
			setVisible(false);
		} else {
			JOptionPane.showMessageDialog(contJPanel, flag, "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
}
