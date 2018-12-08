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
	private JButton loginPanelButton;					//przycisk "Przejdz do logowania"
	private JPanel inputPanel;							// panel na pola
	private JPanel buttonPanel;							// panel na przyciski
	private JPanel parentPanel;							// panel na panele pól i przycisków
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
		
		createButtons();
		createFields();
		createPanels();
	}
	
    // tworzy przyciski	
	private void createButtons() {
		registerButton = new Register();				// przycisk do rejestracji
		loginPanelButton = new LoginPanelButton();		// przycisk do przejœcia do logowania
	}
	
	// tworzy labelki wraz z inputami
	private void createFields() {
		JLabel firstName = new JLabel("Imiê: ");
		firstName.setFont(new Font("Arial", Font.PLAIN,20));
		JLabel lastName = new JLabel("Nazwisko: ");
		lastName.setFont(new Font("Arial", Font.PLAIN,20));
		JLabel email = new JLabel("E-mail: ");
		email.setFont(new Font("Arial", Font.PLAIN,20));
		JLabel password = new JLabel("Has³o: ");
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
		inputPanel.setLayout(new GridLayout(5,2));
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
	
	// tworzy panel przycisków i parent panel
	private void createPanels() {
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
	
	// klasa dla przycisku 'Zarejestruj'
	class Register extends JButton implements ActionListener {

		Register() {
			super("Zarejestruj");
			addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Imiê: " + getFirstName());
			System.out.println("Nazwisko: " + getLastName());
			System.out.println("Email: " + getEmail());
			System.out.println("Has³o: " + getPassword());
			System.out.println("PESEL: " + getPesel());
		}
	}
	
	// klasa dla przycisku 'Przejdz do logowania'
	class LoginPanelButton extends JButton implements ActionListener{
		LoginPanelButton(){
			super("PrzejdŸ do logowania");
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

	// gettery dla wszystkich inputów
	public String getFirstName() {
		return firstNameInput.getText();
	}
	public String getLastName() {
		return lastNameInput.getText();
	}
	public String getEmail() {
		return emailInput.getText();
	}
	public String getPassword() {
		String password = "";
		char[] pass = passwordInput.getPassword();
		for(int i = 0; i < pass.length; i++) {
			password += pass[i];
		}
		return password;
	}
	public String getPesel() {
		return peselInput.getText();
	}
	
}
