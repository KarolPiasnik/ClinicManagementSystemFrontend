package main;

import javax.swing.*;

public class MainFrame extends JFrame {

	public MainFrame() {
		super("Logowanie");

		JPanel loginPanel = new LoginPanel();
		add(loginPanel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	public static void main(String[] args) {
		new MainFrame();
	}
}
