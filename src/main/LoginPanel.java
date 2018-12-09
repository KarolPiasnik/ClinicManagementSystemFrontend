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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class LoginPanel extends JPanel{
	private JButton loginButton;								//przycisk "Zaloguj sie"
	private JButton registerPanelButton;						//przycisk "PrzejdŸ do rejestracji"
	private JTextField emailInput; 								//input na maila
	private JPasswordField passwordInput; 						//input na has³o
	private JPanel loginPanel;
	private JPanel titlePanel;
	private JPanel inputPanel;
	private JPanel buttonPanel;
	private JPanel parentPanel;
	
	public LoginPanel() {
		loginPanel = this;
		this.setLayout(new FlowLayout());
		
		this.createTitlePanel();
		this.createInputs();
		this.createButtons();
		this.drawLoginPanel();	
	}
	//funkcja tworz¹ca nag³ówek
	private void createTitlePanel() {
		JLabel title = new JLabel("<html><div style='font-size: 30px; text-align: center;'>Clinic Management System</div>"
				+ "<div style='text-align: center; margin: 40px 0px 0px 0px; font-size: 16px'>Zaloguj siê, aby przejœæ dalej:</div></html>");
		this.titlePanel = new JPanel();
		this.titlePanel.setLayout(new GridLayout(1,1));
		this.titlePanel.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 0));
		this.titlePanel.setBackground(new Color(255, 228, 188));
		this.titlePanel.add(title);
	}	
	//funkcja tworz¹ca inputy z labelkami
	private void createInputs() {
		JLabel email = new JLabel("E-mail: ");										//label dla maila	
		email.setFont(new Font("Arial", Font.PLAIN,20));
		
		JLabel password = new JLabel("Haslo: ");									//label dla hasla
		password.setFont(new Font("Arial", Font.PLAIN,20));
		
		this.emailInput = new JTextField();											//input dla maila
		this.emailInput.setFont(new Font("Arial", Font.PLAIN,15));
		this.emailInput.setPreferredSize(new Dimension(200,40));
		this.emailInput.setMargin(new Insets(0, 10, 0, 10));
		
		this.passwordInput = new JPasswordField();									//input dla has³a
		this.passwordInput.setFont(new Font("Arial", Font.PLAIN,15));
		this.passwordInput.setPreferredSize(new Dimension(200,40));
		this.passwordInput.setMargin(new Insets(0, 10, 0, 10));
		
		this.inputPanel = new JPanel();												//panel do inputów
		this.inputPanel.setLayout(new GridLayout(2,2,10,10));
		this.inputPanel.setBackground(new Color(255, 228, 188));
		this.inputPanel.add(email);
		this.inputPanel.add(this.emailInput);
		this.inputPanel.add(password);
		this.inputPanel.add(this.passwordInput);
	}
	//funkcja tworz¹ca inputy z labelkami
	private void createButtons() {
		this.loginButton = new Login();												//przycisk do logowania
		this.registerPanelButton = new DrawRegisterForm();							//prxycisk do wyswietlenia rejestracji
		
		this.buttonPanel = new JPanel();											//panel do przycisków
		this.buttonPanel.setLayout(new GridLayout(2,1,10,10));
		this.buttonPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		this.buttonPanel.setBackground(new Color(255, 228, 188));
		this.buttonPanel.add(this.loginButton);
		this.buttonPanel.add(this.registerPanelButton);
	}
	//funkcja rysuj¹ca panel logowania
	private void drawLoginPanel() {
		this.parentPanel = new JPanel();											//kontener dla przycisków i inputów
		this.parentPanel.setLayout(new BorderLayout());
		this.parentPanel.setBackground(new Color(255, 228, 188));
		this.parentPanel.add(this.titlePanel, BorderLayout.NORTH);
		this.parentPanel.add(this.inputPanel, BorderLayout.CENTER);
		this.parentPanel.add(this.buttonPanel, BorderLayout.SOUTH);	
		this.add(parentPanel);
		this.setBackground(new Color(255, 228, 188));
	}
	class Login extends JButton implements ActionListener {

		Login() {
			super("Zaloguj");
			addActionListener(this);
			this.setMargin(new Insets(10, 0, 10, 0));
			this.setBackground(new Color(198, 89, 0));
			this.setForeground(new Color(246, 246, 246));
			Border emptyBorder = BorderFactory.createEmptyBorder(10,10,10,10);
			this.setBorder(emptyBorder);
			// event po najechaniu i zjechaniu myszk¹ z przycisku
			this.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	loginButton.setBackground(new Color(255, 114, 0	));
			    	loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			    }

			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	loginButton.setBackground(new Color(198, 89, 0));
			    }
			});
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Podany mail: " + emailInput.getText());
			System.out.println("Podane has³o: " + passwordInput.getText());
		}
	}

	class DrawRegisterForm extends JButton implements ActionListener {

		DrawRegisterForm() {
			super("PrzejdŸ do rejestracji");
			addActionListener(this);
			setBackground(new Color(188, 214, 255));
			Border emptyBorder = BorderFactory.createEmptyBorder(10,10,10,10);
			this.setBorder(emptyBorder);
			// event po najechaniu i zjechaniu myszk¹ z przycisku
			this.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	registerPanelButton.setBackground(new Color(211, 228, 255));
			    	registerPanelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			    }

			    public void mouseExited(java.awt.event.MouseEvent evt) {
			    	registerPanelButton.setBackground(new Color(188, 214, 255));
			    }
			});
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
			System.out.println("Wyœwietlenie formularza rejestracji.");
		}
	}
}
