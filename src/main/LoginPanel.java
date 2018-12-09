package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class LoginPanel extends JPanel{
	private JButton loginButton;						//przycisk "Zaloguj sie"
	private JButton registerButton;						//przycisk "Przejd� do rejestracji"
	private JTextField emailInput; 						//input na maila
	private JPasswordField passwordInput; 				//input na has�o
	private JPanel loginPanel;

	public LoginPanel() {
		loginPanel = this;
		this.setLayout(new FlowLayout());
		this.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));
		
		loginButton = new Login();										//przycisk do logowania
		registerButton = new DrawRegisterForm();						//prxycisk do wyswietlenia rejestracji
		
		JLabel email = new JLabel("E-mail: ");							//ustawiania input�w		
		email.setFont(new Font("Arial", Font.PLAIN,20));
		JLabel password = new JLabel("Haslo: ");
		password.setFont(new Font("Arial", Font.PLAIN,20));
		emailInput = new JTextField();
		emailInput.setFont(new Font("Arial", Font.PLAIN,20));
		emailInput.setPreferredSize(new Dimension(200,20));
		passwordInput = new JPasswordField();
		passwordInput.setFont(new Font("Arial", Font.PLAIN,20));
		
		JPanel inputPanel = new JPanel();				//panel do input�w
		inputPanel.setLayout(new GridLayout(2,2));
		inputPanel.add(email);
		inputPanel.add(emailInput);
		inputPanel.add(password);
		inputPanel.add(passwordInput);
		
		JPanel buttonPanel = new JPanel();				//panel do przycisk�w
		buttonPanel.setLayout(new GridLayout(2,1));
		buttonPanel.add(loginButton);
		buttonPanel.add(registerButton);

		JPanel parentPanel = new JPanel();				//kontener dla przycisk�w i input�w
		parentPanel.setLayout(new BorderLayout());
		parentPanel.add(inputPanel, BorderLayout.CENTER);
		parentPanel.add(buttonPanel, BorderLayout.SOUTH);
		add(parentPanel);
	}
	
	class Login extends JButton implements ActionListener {

		Login() {
			super("Zaloguj");
			addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Podany mail: " + emailInput.getText());
			System.out.println("Podane has�o: " + passwordInput.getText());
		}
	}

	class DrawRegisterForm extends JButton implements ActionListener {

		DrawRegisterForm() {
			super("Przejd� do rejestracji");
			addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(loginPanel);
			JScrollPane scroll = new JScrollPane(new RegisterPanel(), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			topFrame.getContentPane().removeAll();
			topFrame.getContentPane().add(scroll);
			topFrame.invalidate();
			topFrame.validate();
			topFrame.repaint();
			topFrame.setTitle("Rejestracja");
			System.out.println("Wy�wietlenie formularza rejestracji.");
		}
	}
}
