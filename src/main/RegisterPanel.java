package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import main.LoginPanel.Login;

public class RegisterPanel extends JPanel {

	public static final int HEIGHT = 400;
	public static final int WIDTH = 700;
	
	private JButton registerButton;						//przycisk "Zarejestruj"
	private JButton loginPanelButton;					//przycisk "Przejdz do panelu logowania"
	private JPanel inputPanel;
	private JPanel buttonPanel;
	private JPanel parentPanel;
	private JTextField firstNameInput; 					//input na imie
	private JTextField lastNameInput; 					//input na nazwisko
	private JTextField emailInput; 						//input na maila
	private JPasswordField passwordInput; 				//input na has³o
	private JTextField peselInput; 						//input na pesel
	private JPanel registerPanel;
	
	public RegisterPanel() {
		registerPanel = this;
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setLayout(new FlowLayout());
		this.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));
		
		registerButton = new Register();
		loginPanelButton = new LoginPanelButton();
		
		createFields();
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(2,1));
		buttonPanel.add(registerButton);
		buttonPanel.add(loginPanelButton);
		
		parentPanel = new JPanel();
		parentPanel.setLayout(new BorderLayout());
		parentPanel.add(inputPanel, BorderLayout.CENTER);
		parentPanel.add(buttonPanel, BorderLayout.SOUTH);
		add(parentPanel);
	}
	
	private void createFields() {
		JLabel firstName = new JLabel("Imiê: ");
		firstName.setFont(new Font("Arial", Font.PLAIN,20));
		JLabel lastName = new JLabel("Nazwisko: ");
		lastName.setFont(new Font("Arial", Font.PLAIN,20));
		JLabel email = new JLabel("E-mail: ");
		email.setFont(new Font("Arial", Font.PLAIN,20));
		JLabel password = new JLabel("Haslo: ");
		password.setFont(new Font("Arial", Font.PLAIN,20));
		JLabel pesel = new JLabel("PESEL: ");
		pesel.setFont(new Font("Arial", Font.PLAIN,20));
		
		emailInput = new JTextField();
		emailInput.setFont(new Font("Arial", Font.PLAIN,20));
		emailInput.setPreferredSize(new Dimension(200,20));
		passwordInput = new JPasswordField();
		passwordInput.setFont(new Font("Arial", Font.PLAIN,20));
		firstNameInput = new JTextField();
		firstNameInput.setFont(new Font("Arial", Font.PLAIN,20));
		firstNameInput.setPreferredSize(new Dimension(200,20));
		lastNameInput = new JTextField();
		lastNameInput.setFont(new Font("Arial", Font.PLAIN,20));
		lastNameInput.setPreferredSize(new Dimension(200,20));
		peselInput = new JTextField();
		peselInput.setFont(new Font("Arial", Font.PLAIN,20));
		peselInput.setPreferredSize(new Dimension(200,20));
		
		inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(2,5));
		inputPanel.add(firstName);
		inputPanel.add(firstNameInput);
		inputPanel.add(lastName);
		inputPanel.add(lastNameInput);
		inputPanel.add(email);
		inputPanel.add(emailInput);
		inputPanel.add(password);
		inputPanel.add(passwordInput);
		inputPanel.add(pesel);
		inputPanel.add(peselInput);
	}
	
	class Register extends JButton implements ActionListener {

		Register() {
			super("Zarejestruj");
			addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Funkcja rejestracji.");
		}
	}
	
	class LoginPanelButton extends JButton implements ActionListener{
		LoginPanelButton(){
			super("Przejdz do strony logowania");
			addActionListener(this);
		}
		
		public void actionPerformed(ActionEvent e) {
			JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(registerPanel);
			topFrame.getContentPane().removeAll();
			topFrame.getContentPane().add(new LoginPanel());
			topFrame.invalidate();
			topFrame.validate();
			topFrame.repaint();
			topFrame.setTitle("Logowanie");
			System.out.println("Funkcja przejœcia do okna logowania.");
		}
	}

}
