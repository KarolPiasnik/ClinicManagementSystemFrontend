package main;

import javax.swing.*;
import java.awt.*;

public class PersonalDataPanel extends JPanel {

    private JPanel PersonalDataPanel;
    private JPanel toolbarPanel;
    private JPanel titlePanel;
    private JPanel parentPanel;

    public PersonalDataPanel(){
        super();
        this.PersonalDataPanel = this;
        this.toolbarPanel = new ToolbarPanel();
        this.setLayout(new FlowLayout());
        this.toolbarPanel = new ToolbarPanel();
        this.createHeader();
        this.createPanels();
    }

    // tworzy tytuł strony
    private void createHeader() {
        JLabel title = new JLabel("<html><div style='display: block; margin: 0 auto; text-align: center; margin: 40px 0px 0px 0px; font-size: 18px'>Dane konta</div></html>");
        titlePanel = new JPanel();
        titlePanel.setLayout(new GridLayout(1,1));
        titlePanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        titlePanel.setBackground(new Color(255, 228, 188));
        titlePanel.add(title);
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
}
