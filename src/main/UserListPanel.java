package main;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserListPanel extends JPanel {

    private JSONObject list;
    private JPanel UserListPanel;
    private JPanel titlePanel;							// panel na tytuł
    private JPanel parentPanel;							// panel na panele
    private JPanel toolbarPanel;
    private JToolBar toolbar;

    private JButton logoutButton;

    public UserListPanel(JSONObject list){
        this.list = list;
        this.UserListPanel = this;
        this.setLayout(new FlowLayout());
        this.createToolbar();
        this.createHeader();
        this.createUserList();
        this.createPanels();
    }

    // tworzy toolbar na górze widoku
    private void createToolbar(){
        toolbarPanel = new JPanel();
        this.toolbar = new JToolBar();
        toolbar.setFloatable( false);
        toolbar.add(new JButton("Lista uzytkownikow"));
        toolbar.addSeparator();
        toolbar.add(new JButton("Twoje dane"));
        logoutButton = new Logout();
        toolbar.add(logoutButton);
        toolbarPanel.add(toolbar);
    }

    // tworzy tytuł strony
    private void createHeader() {
        JLabel title = new JLabel("<html><div style='font-size: 30px; text-align: center;'>Clinic Management System</div>"
                + "<div style='text-align: center; margin: 40px 0px 0px 0px; font-size: 16px'>Lista uzytkownikow systemu:</div></html>");
        titlePanel = new JPanel();
        titlePanel.setLayout(new GridLayout(1,1));
        titlePanel.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 0));
        titlePanel.setBackground(new Color(255, 228, 188));
        titlePanel.add(title);
    }

    private void createUserList(){
        Object _embedded = this.list.get("_embedded");
        System.out.println(_embedded);
        JSONParser parser = new JSONParser();
        try {
            JSONObject doctors = (JSONObject) parser.parse(_embedded.toString());
            Object doctor = doctors.get("doctor");
            System.out.println(doctor);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    // tworzy panel przycisków i parent panel
    private void createPanels() {
        parentPanel = new JPanel();
        parentPanel.setLayout(new BorderLayout());
        parentPanel.setBackground(new Color(255, 228, 188));
        parentPanel.add(toolbarPanel, BorderLayout.NORTH);
        parentPanel.add(titlePanel, BorderLayout.CENTER);
        add(parentPanel);
        setBackground(new Color(255, 228, 188));
    }

    // klasa dla przycisku 'Wyloguj sie'
    class Logout extends JButton implements ActionListener {
        Logout(){
            super("Wyloguj sie");
            addActionListener(this);
        }

        public void actionPerformed(ActionEvent e) {
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(UserListPanel);
            JScrollPane scroll = new JScrollPane(new LoginPanel(), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            topFrame.getContentPane().removeAll();
            topFrame.getContentPane().add(scroll);
            topFrame.invalidate();
            topFrame.validate();
            topFrame.repaint();
            topFrame.setTitle("Logowanie");
        }
    }

}
