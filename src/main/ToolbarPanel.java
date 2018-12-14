package main;

import org.json.simple.JSONObject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolbarPanel extends JPanel {

    private JPanel toolbarPanel;
    private JToolBar toolbar;
    private JButton logoutButton;
    private JButton personalDataButton;
    private JButton userListButton;

    public ToolbarPanel(){
        super();
        this.toolbarPanel = this;
        this.createToolbar();
    }

    // tworzy toolbar na górze widoku
    private void createToolbar(){
        this.toolbar = new JToolBar();
        toolbar.setFloatable( false);
        toolbar.addSeparator();
        personalDataButton = new PersonalData();
        toolbar.add(personalDataButton);
        userListButton = new UserList();
        toolbar.add(userListButton);
        logoutButton = new Logout();
        toolbar.add(logoutButton);
        toolbarPanel.add(toolbar);
    }

    // klasa dla przycisku 'Wyloguj sie'
    class Logout extends JButton implements ActionListener {
        Logout(){
            super("Wyloguj sie");
            addActionListener(this);
        }

        public void actionPerformed(ActionEvent e) {
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(toolbarPanel);
            JScrollPane scroll = new JScrollPane(new LoginPanel(), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            topFrame.getContentPane().removeAll();
            topFrame.getContentPane().add(scroll);
            topFrame.invalidate();
            topFrame.validate();
            topFrame.repaint();
            topFrame.setTitle("Logowanie");
        }
    }

    // klasa dla przycisku 'Twoje dane'
    class PersonalData extends JButton implements ActionListener {
        PersonalData(){
            super("Twoje dane");
            addActionListener(this);
        }

        public void actionPerformed(ActionEvent e) {
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(toolbarPanel);
            JScrollPane scroll = new JScrollPane(new PersonalDataPanel(), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            topFrame.getContentPane().removeAll();
            topFrame.getContentPane().add(scroll);
            topFrame.invalidate();
            topFrame.validate();
            topFrame.repaint();
            topFrame.setTitle("Twoje dane");
        }
    }

    // klasa dla przycisku 'Lista użytkowników'
    class UserList extends JButton implements ActionListener {
        UserList(){
            super("Lista uzytkownikow");
            addActionListener(this);
        }

        public void actionPerformed(ActionEvent e) {
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(toolbarPanel);
            JScrollPane scroll = new JScrollPane(new UserListPanel(), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            topFrame.getContentPane().removeAll();
            topFrame.getContentPane().add(scroll);
            topFrame.invalidate();
            topFrame.validate();
            topFrame.repaint();
            topFrame.setTitle("Lista użytkowników");
        }
    }

//    private JSONObject getUsers(){
//
//    }
}
