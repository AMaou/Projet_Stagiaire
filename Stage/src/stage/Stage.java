package stage;
 
import UI.EntrepriseUI;
import UI.InsertOffreUI;
import UI.OffreUI;
import dao.OffreStageDAO;
import dao.UserDAO;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import stage.metier.User;
 
public class Stage implements ItemListener {
    JPanel cards; //a panel that uses CardLayout
    final static String creerEntreprise = "Creer une entreprise";
    final static String creerOffre = "Saisir une offre";
    final static String consulterOffres = "Consulter les offres";
    private UserDAO uDAO = new UserDAO();
     
    public void addComponentToPane(Container pane) {
        //Put the JComboBox in a JPanel to get a nicer look.
        JPanel comboBoxPane = new JPanel(); //use FlowLayout
        String comboBoxItems[] = { creerEntreprise, creerOffre, consulterOffres };
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);
         
        //Create the "cards".
        JPanel card1 = new EntrepriseUI();
         
        JPanel card2 = new InsertOffreUI();
        
        JPanel card3 = new OffreUI();
         
        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(card1, creerEntreprise);
        cards.add(card2, creerOffre);
        cards.add(card3, consulterOffres);
         
        pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
        
        JPanel userPanel = new JPanel();
        userPanel.setLayout(new GridLayout(2,2));
        
        JLabel usernameLbl = new JLabel("Username:");
        JLabel passwordLbl = new JLabel("Password:");
        JTextField username = new JTextField();
        JPasswordField passwordFld = new JPasswordField();
        
        userPanel.add(usernameLbl);
        userPanel.add(username);
        userPanel.add(passwordLbl);
        userPanel.add(passwordFld);
        
        boolean checkLogin = false;
        while (checkLogin != true){
            int input = JOptionPane.showConfirmDialog(pane, userPanel, "Enter your password:"
                            ,JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (input == 0){
                User u = new User();
                u.setLogin(username.getText());
                u.setPassword(passwordFld.getText());
                if (uDAO.verifierLogin(u)){
                    checkLogin=true;
                }
            }else {
                System.exit(0);
            }
        }
    }
     
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }
     
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Gestion des Offres de stage");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        //Create and set up the content pane.
        Stage demo = new Stage();
        demo.addComponentToPane(frame.getContentPane());
         
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
     
    public static void main(String[] args) {
        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
         
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}