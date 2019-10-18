package main.java.views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import main.java.util.Register;

public class RegisterGUI extends JFrame {
	private static final long serialVersionUID = 3250371445038102261L;
	private JPanel contentJPanel;
	private JTextField idJTextField;
	private JTextField nametextField;
	private JTextField passwordTextField;

	public void registerGUI() {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					RegisterGUI frame = new RegisterGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

	}

	public RegisterGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 400);
		contentJPanel = new JPanel();
		contentJPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentJPanel);
		contentJPanel.setLayout(null);

		JLabel nameLabel = new JLabel("please input your username");
		nameLabel.setBounds(102, 91, 151, 23);
		contentJPanel.add(nameLabel);

		JLabel IDlabel = new JLabel("Please input user ID");// 设置提示ID输入标签
		IDlabel.setBounds(102, 160, 151, 23);
		contentJPanel.add(IDlabel);

		JLabel passwdlaber = new JLabel("Please input user password");// 设置提示密码输入标签
		passwdlaber.setBounds(102, 224, 163, 23);
		contentJPanel.add(passwdlaber);

		idJTextField = new JTextField();
		idJTextField.setBounds(271, 161, 92, 21);
		contentJPanel.add(idJTextField);
		idJTextField.setColumns(8);

		nametextField = new JTextField(); // 普通文本输入框
		nametextField.setBounds(271, 92, 92, 21); // 设置位置及大小
		contentJPanel.add(nametextField);
		nametextField.setColumns(10); // 设置长度

		passwordTextField = new JTextField();
		passwordTextField.setBounds(271, 225, 92, 21);
		contentJPanel.add(passwordTextField);
		passwordTextField.setColumns(10);

		JButton registerButton = new JButton("sign up");

		registerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name = nametextField.getText();
				String id = idJTextField.getText();
				String password = passwordTextField.getText();
				if (Register.checkId(id) == null) {
					if (Register.checkPasswd(password) == null) {
						String srt = Register.register(id, name, password);
						JOptionPane.showMessageDialog(contentJPanel, srt, "information", JOptionPane.PLAIN_MESSAGE);
						setVisible(false);
						new IndexGUI().init();
					} else {
						JOptionPane.showMessageDialog(contentJPanel, Register.checkPasswd(password), "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(contentJPanel, Register.checkId(id), "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		registerButton.setBounds(321, 305, 93, 23);
		contentJPanel.add(registerButton);

		JButton backButton = new JButton("back");
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				IndexGUI.init();
				setVisible(false);
			}

		});
		backButton.setBounds(531, 305, 93, 23);
		contentJPanel.add(backButton);

		JLabel label = new JLabel("Welcome to use KnowYou"); // 欢迎标题
		label.setFont(new Font("字体", Font.BOLD | Font.ITALIC, 30));
		label.setBounds(143, 26, 374, 35);
		contentJPanel.add(label);

		JLabel lblNewLabel = new JLabel("(There are 1 to 8 numbers)");
		lblNewLabel.setBounds(373, 164, 163, 15);
		contentJPanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("(There are 6 to 15 numbers)");
		lblNewLabel_1.setBounds(373, 228, 163, 15);
		contentJPanel.add(lblNewLabel_1);
	}
}
