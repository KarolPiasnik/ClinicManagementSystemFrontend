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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel extends JPanel{
	public static final int HEIGHT = 400;
	public static final int WIDTH = 700;
	private JButton loginButton;						//przycisk "Zaloguj sie"
	private JButton registerButton;						//przycisk "PrzejdŸ do rejestracji"
	private JTextField emailInput; 						//input na maila
	private JPasswordField passwordInput; 				//input na has³o
	//private JPanel loginPanel;

	public LoginPanel() {
		//loginPanel = this;
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setLayout(new FlowLayout());
		this.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));
		
		loginButton = new Login();										//przycisk do logowania
		registerButton = new DrawRegisterForm();						//prxycisk do wyswietlenia rejestracji
		
		JLabel email = new JLabel("E-mail: ");							//ustawiania inputów		
		email.setFont(new Font("Arial", Font.PLAIN,20));
		JLabel password = new JLabel("Haslo: ");
		password.setFont(new Font("Arial", Font.PLAIN,20));
		emailInput = new JTextField();
		emailInput.setFont(new Font("Arial", Font.PLAIN,20));
		emailInput.setPreferredSize(new Dimension(200,20));
		passwordInput = new JPasswordField();
		passwordInput.setFont(new Font("Arial", Font.PLAIN,20));
		
		JPanel inputPanel = new JPanel();				//panel do inputów
		inputPanel.setLayout(new GridLayout(2,2));
		inputPanel.add(email);
		inputPanel.add(emailInput);
		inputPanel.add(password);
		inputPanel.add(passwordInput);
		
		JPanel buttonPanel = new JPanel();				//panel do przycisków
		buttonPanel.setLayout(new GridLayout(2,1));
		buttonPanel.add(loginButton);
		buttonPanel.add(registerButton);

		JPanel parentPanel = new JPanel();				//kontener dla przycisków i inputów
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
			System.out.println("Funkcja logowania.");
		}
	}

	class DrawRegisterForm extends JButton implements ActionListener {

		DrawRegisterForm() {
			super("PrzejdŸ do rejestracji");
			addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Wyœwietlenie formularza rejestracji.");
		}
	}
}
