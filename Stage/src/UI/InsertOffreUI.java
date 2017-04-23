/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import dao.DomaineOffreDAO;
import dao.EntrepriseDAO;
import dao.OffreStageDAO;
import dao.SecteurActiviteDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.embed.swing.JFXPanel;
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
import stage.metier.DomaineOffre;
import stage.metier.Entreprise;
import stage.metier.OffreStage;
import stage.metier.SecteurActivite;

/**
 *
 * @author aya
 */
public class InsertOffreUI extends JPanel {

    private JTextField libelleField = new JTextField(30);
    private JTextField dateDebField = new JTextField(30);
    private JTextField dureeField = new JTextField(30);
    private JTextField descriptifField = new JTextField(30);
   
    private JList list1;
    private JList list2;
    
    private JButton sendButton = new JButton("Envoyer");
    private JButton cancelButton = new JButton("Annuler");
    
    private EntrepriseDAO eDAO = new EntrepriseDAO();
    private DomaineOffreDAO doDAO = new DomaineOffreDAO();
    private OffreStageDAO osDAO = new OffreStageDAO();
    
    /**
     * Creates new form EntrepriseUI
     */
    public InsertOffreUI() {
        //initComponents();
        setBorder(new TitledBorder(new EtchedBorder(),"Insertion d'une offre"));
        setLayout(new BorderLayout(5, 5));
        add(initFields(), BorderLayout.NORTH);
        add(initButtons(), BorderLayout.CENTER);        
        //setFieldData(uneEntreprise.moveFirst());
    }
    
    private JPanel initButtons() {
      JPanel panel = new JPanel();
      panel.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));
      panel.setBackground(Color.decode("#e8efed"));
      panel.add(sendButton);
      panel.add(cancelButton);
      
      sendButton.addActionListener(new ButtonHandler());
      cancelButton.addActionListener(new ButtonHandler());
      //list.addListSelectionListener(new OffreSelectionListener());
      panel.setBackground(Color.decode("#73f1d2"));
      return panel;
   }
    
     private JPanel initFields() {
         
        JPanel panel = new JPanel();
        panel.setBackground(Color.decode("#73f1d2"));
        panel.setLayout(new MigLayout());
        DefaultListModel dlm1 = new DefaultListModel();
        for(Entreprise uneEntreprise : eDAO.findAll() ){
            dlm1.addElement(uneEntreprise);
        }    
        list1 = new JList(dlm1);
        list1.setCellRenderer(new EntrepriseRenderer());
        JScrollPane sp1 = new JScrollPane(list1);
        sp1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        panel.add(new JLabel("Nom de l'entreprise"), "align label");
        panel.add(sp1, "wrap");
        
        DefaultListModel dlm2 = new DefaultListModel();
        for(DomaineOffre unDomaine : doDAO.findAll() ){
            dlm2.addElement(unDomaine);
        }    
        list2 = new JList(dlm2);
        list2.setCellRenderer(new DomaineOffreRenderer());
        JScrollPane sp2 = new JScrollPane(list2);
        sp2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        panel.add(new JLabel("Domaine de l'offre"), "align label");
        panel.add(sp2, "wrap");
        
        panel.add(new JLabel("Libellé de l'offre"), "align label");
        panel.add(libelleField, "wrap");
        //raisonSocialeField.setEnabled(false);
      
        panel.add(new JLabel("Date de début du stage (aaaa-mm-jj)"), "align label");
        panel.add(dateDebField, "wrap");
        //villeField.setEnabled(false);
      
        panel.add(new JLabel("Durée"), "align label");
        panel.add(dureeField, "wrap");
        //rueField.setEnabled(false);
      
        panel.add(new JLabel("Descriptif"), "align label");
        panel.add(descriptifField, "wrap");
        //cpField.setEnabled(false);
      
        return panel;
   }

   private OffreStage getFieldData() {
       if (!isEmptyFieldData()){
      OffreStage os = new OffreStage();
      os.setLibelleO(libelleField.getText());
      os.setDescriptiFo(descriptifField.getText());
      os.setDureeO(Integer.parseInt(dureeField.getText()));
      os.setDomaine((DomaineOffre)list2.getSelectedValue());
      os.setEntreprise((Entreprise) list1.getSelectedValue());
      
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        try {
            Date date = formatter.parse(dateDebField.getText());
            os.setDateDebutO(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

      
      return os;
       }
       else {
           return null;
       }
      
   }
    
    private boolean isEmptyFieldData() {
      if ( libelleField.getText().equals("") | descriptifField.getText().equals("") ||
      dateDebField.getText().equals("") || dureeField.getText().equals("") || list1.isSelectionEmpty() || list2.isSelectionEmpty()/*|| secteurField.getText().equals("")*/){
          return true;
      }else{
          return false;
      }
    
   }

    private class ButtonHandler implements ActionListener {
      @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            OffreStage os = getFieldData();
         String command = ((JButton) e.getSource()).getActionCommand();
         switch (command) {
         case "Envoyer":
            if (isEmptyFieldData()) {
               JOptionPane.showMessageDialog(null,
               "Cannot create an empty record");
               return;
            }
            if (osDAO.create(os) != null)
               JOptionPane.showMessageDialog(null,
               "Nouvelle Offre créee avec succés.");
               break;
         case "Annuler":
            System.exit(0);
         default:
            JOptionPane.showMessageDialog(null,
            "invalid command");
         }
        }
   }
    
    public class EntrepriseRenderer extends JLabel implements ListCellRenderer<Entreprise> {
 
        public EntrepriseRenderer() {
        setOpaque(true);
        }
        
        public Component getListCellRendererComponent(JList<? extends Entreprise> list, Entreprise e, int index,
        boolean isSelected, boolean cellHasFocus) {
            setText(e.getRaisonSociale());
        
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
    
    public class DomaineOffreRenderer extends JLabel implements ListCellRenderer<DomaineOffre> {
 
        public DomaineOffreRenderer() {
        setOpaque(true);
        }
        
        public Component getListCellRendererComponent(JList<? extends DomaineOffre> list, DomaineOffre d, int index,
        boolean isSelected, boolean cellHasFocus) {
            setText(d.getLibelleDomaine());
        
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
