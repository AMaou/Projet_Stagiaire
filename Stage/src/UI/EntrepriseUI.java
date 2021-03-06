/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import dao.EntrepriseDAO;
import dao.SecteurActiviteDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import net.miginfocom.swing.MigLayout;
import stage.metier.*;

/**
 *
 * @author aya
 */
public class EntrepriseUI extends JPanel  {
    
    private JTextField raisonSocialeField = new JTextField(30);
    private JTextField villeField = new JTextField(30);
    private JTextField rueField = new JTextField(30);
    private JTextField cpField = new JTextField(30);
    private JTextField telField = new JTextField(30);
    private JTextField secteurField = new JTextField(30);
    private JList list;
    
    private JButton sendButton = new JButton("Envoyer");
    private JButton cancelButton = new JButton("Annuler");
    
    private EntrepriseDAO eDAO = new EntrepriseDAO();
    private SecteurActiviteDAO saDAO = new SecteurActiviteDAO();
    
    /**
     * Creates new form EntrepriseUI
     */
    public EntrepriseUI() {
        //initComponents();
        //setBackground(Color.BLACK);
        setBorder(new TitledBorder(new EtchedBorder(),"Nouvelle Entreprise"));
        setLayout(new BorderLayout(5, 5));
        add(initFields(), BorderLayout.NORTH);
        add(initButtons(), BorderLayout.CENTER); 
        setBackground(Color.decode("#73f1d2"));
        //setFieldData(uneEntreprise.moveFirst());
    }
    
    private JPanel initButtons() {
      JPanel panel = new JPanel();
      panel.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));
      panel.add(sendButton);
      panel.add(cancelButton);
      
      
      sendButton.addActionListener(new ButtonHandler());
      cancelButton.addActionListener(new ButtonHandler());
      //list.addListSelectionListener(new OffreSelectionListener());
      //Image background = Toolkit.getDefaultToolkit().createImage("Background.png");
      //panel.drawImage(background, 0, 0, null);
      panel.setBackground(Color.decode("#73f1d2"));
      return panel;
   }

     private JPanel initFields() {
      JPanel panel = new JPanel();
      panel.setBackground(Color.decode("#73f1d2"));

      panel.setLayout(new MigLayout());
      
      JLabel raisonSocialeLabel = new JLabel("Raison Sociale");
      raisonSocialeLabel.setBorder(new RoundedBorder(Color.BLACK, 15));
      panel.add(raisonSocialeLabel, "align label");
      panel.add(raisonSocialeField, "wrap");
      //raisonSocialeField.setEnabled(false);
      
      JLabel villeLabel =  new JLabel("Ville");
      villeLabel.setBorder(new RoundedBorder(Color.BLACK, 15));
      panel.add(villeLabel, "align label");
      panel.add(villeField, "wrap");
      //villeField.setEnabled(false);
     
      JLabel rueLabel =  new JLabel("Rue");
      rueLabel.setBorder(new RoundedBorder(Color.BLACK, 15));
      panel.add(rueLabel, "align label");
      panel.add(rueField, "wrap");
      //rueField.setEnabled(false);
      
      JLabel cpLabel =  new JLabel("CP");
      cpLabel.setBorder(new RoundedBorder(Color.BLACK, 15));
      panel.add(cpLabel, "align label");
      panel.add(cpField, "wrap"); 
      //cpField.setEnabled(false);
      
      JLabel telLabel =  new JLabel("Tel");
      telLabel.setBorder(new RoundedBorder(Color.BLACK, 15));
      panel.add(telLabel, "align label");
      panel.add(telField, "wrap");
      //telField.setEnabled(false);
      
      DefaultListModel dlm = new DefaultListModel();
      for(SecteurActivite unSecteur : saDAO.findAll() ){
            dlm.addElement(unSecteur);
      }    
      list = new JList(dlm);
      list.setCellRenderer(new SecteurRenderer());
      JScrollPane sp1 = new JScrollPane(list);
      sp1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
      
      JLabel secteurLabel =  new JLabel("Secteur");
      //secteurLabel.setOpaque(true);
      //secteurLabel.setBackground(Color.cyan);
      secteurLabel.setBorder(new RoundedBorder(Color.black, 15));
      panel.add(secteurLabel, "align label");
      panel.add(sp1, "wrap");
      //panel.setBackground(Color.cyan);
      //Image background = Toolkit.getDefaultToolkit().createImage("Background.png");
      //g.drawImage(image, 0, 0, null);
      return panel;
   }
     
   private Entreprise getFieldData() {
       if (!isEmptyFieldData()){
      Entreprise e = new Entreprise();
      e.setRaisonSociale(raisonSocialeField.getText());
      e.setVille(villeField.getText());
      e.setRue(rueField.getText());
      e.setCP(cpField.getText());
      e.setTel(telField.getText());
      //list.getSelectedValue()
      e.setSecteur((SecteurActivite)list.getSelectedValue());
      return e;
       }
       else {
           return null;
       }
      
   }

   private void setFieldData(Entreprise e) {
      raisonSocialeField.setText(e.getRaisonSociale());
      villeField.setText(e.getVille());
      rueField.setText(e.getRue());
      cpField.setText(e.getCP());
      telField.setText(e.getTel());
      secteurField.setText(String.valueOf(e.getSecteur().getIdSecteur()));
   }
    
    private boolean isEmptyFieldData() {
      if ( raisonSocialeField.getText().equals("") | villeField.getText().equals("") ||
      rueField.getText().equals("") || cpField.getText().equals("") || telField.getText().equals("") || list.isSelectionEmpty()/*|| secteurField.getText().equals("")*/){
          return true;
      }else{
          return false;
      }
    
   }

    private class ButtonHandler implements ActionListener {
      @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            Entreprise entreprise = getFieldData();
         String command = ((JButton) e.getSource()).getActionCommand();
         switch (command) {
         case "Envoyer":
            if (isEmptyFieldData()) {
               JOptionPane.showMessageDialog(null,
               "Cannot create an empty record");
               return;
            }
            if (eDAO.create(entreprise) != null)
               JOptionPane.showMessageDialog(null,
               "Nouvelle Entreprise créee avec succés.");
               break;
         case "Annuler":
            System.exit(0);
         default:
            JOptionPane.showMessageDialog(null,
            "invalid command");
         }
        }
   }
    
    public class SecteurRenderer extends JLabel implements ListCellRenderer<SecteurActivite> {
 
        public SecteurRenderer() {
        setOpaque(true);
        }
        
        public Component getListCellRendererComponent(JList<? extends SecteurActivite> list, SecteurActivite sa, int index,
        boolean isSelected, boolean cellHasFocus) {
             setText(sa.getLibelleS());
        
            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }
            return this;
        }
    }   
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(286, Short.MAX_VALUE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(196, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    // End of variables declaration//GEN-END:variables
}
