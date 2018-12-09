package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
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
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import main.LoginPanel.Login;

public class RegisterPanel extends JPanel {

	public static final int HEIGHT = 600;
	public static final int WIDTH = 1024;
	
	private JButton registerButton;						//przycisk "Zarejestruj"
	private JButton loginPanelButton;					//przycisk "Przejdz do logowania"
	private JPanel titlePanel;							// panel na tytu³
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
		// this.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));
		createHeader();
		createButtons();
		createFields();
		createPanels();
	}
	
	private void createHeader() {
		JLabel title = new JLabel("<html><div style='font-size: 30px; text-align: center;'>Clinic Management System</div></html>");
		// title.setFont(new Font("Calibri", Font.PLAIN,30));
		titlePanel = new JPanel();
		titlePanel.setLayout(new GridLayout(1,1));
		titlePanel.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 0));
		titlePanel.add(title);
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
		emailInput.setFont(new Font("Arial", Font.PLAIN,15));
		emailInput.setPreferredSize(new Dimension(200,40));
		emailInput.setMargin(new Insets(0, 10, 0, 10));
		
		passwordInput = new JPasswordField();
		passwordInput.setFont(new Font("Arial", Font.PLAIN,15));
		passwordInput.setMargin(new Insets(0, 10, 0, 10));
		
		firstNameInput = new JTextField();
		firstNameInput.setFont(new Font("Arial", Font.PLAIN,15));
		firstNameInput.setPreferredSize(new Dimension(200,20));
		firstNameInput.setMargin(new Insets(0, 10, 0, 10));
		
		lastNameInput = new JTextField();
		lastNameInput.setFont(new Font("Arial", Font.PLAIN,15));
		lastNameInput.setPreferredSize(new Dimension(200,20));
		lastNameInput.setMargin(new Insets(0, 10, 0, 10));
		
		peselInput = new JTextField();
		peselInput.setFont(new Font("Arial", Font.PLAIN,15));
		peselInput.setPreferredSize(new Dimension(200,20));
		peselInput.setMargin(new Insets(0, 10, 0, 10));
		
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
		buttonPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		parentPanel = new JPanel();
		parentPanel.setLayout(new BorderLayout());
		
		parentPanel.add(inputPanel, BorderLayout.CENTER);
		parentPanel.add(buttonPanel, BorderLayout.SOUTH);
		parentPanel.add(titlePanel, BorderLayout.NORTH);
		add(parentPanel);
	}
	
	// klasa dla przycisku 'Zarejestruj'
	class Register extends JButton implements ActionListener {

		Register() {
			super("Zarejestruj");
			addActionListener(this);
			this.setMargin(new Insets(10, 0, 10, 0));
			this.setBackground(new Color(0, 155, 255));
			// event po najechaniu i zjechaniu myszk¹ z przycisku
			this.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	registerButton.setBackground(new Color(99, 194, 255));
			    	registerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			    }

			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	registerButton.setBackground(new Color(0, 155, 255));
			    }
			});
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
