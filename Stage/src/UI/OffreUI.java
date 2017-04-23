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
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.ListIterator;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
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
public class OffreUI extends javax.swing.JPanel {

    private JTextField nomEntrepriseField = new JTextField(30);
    private JTextField villeField = new JTextField(30);
    private JTextField domaineField = new JTextField(30);
    private JTextField libelleField = new JTextField(30);
    private JTextField dateDebutField = new JTextField(30);
    private JTextField dureeStageField = new JTextField(30);
    private JTextField descriptifField = new JTextField(30);
    private JCheckBox valide = new JCheckBox();
    
    private JButton suivantButton = new JButton("Suivant");
    private JButton precedentButton = new JButton("Precedent");
    private JButton cancelButton = new JButton("Annuler");
   
    private OffreStageDAO osDAO = new OffreStageDAO();
    private EntrepriseDAO eDAO = new EntrepriseDAO();
    private DomaineOffreDAO doDAO = new DomaineOffreDAO();
    
    private OffreIterator iterator = new OffreIterator(osDAO.findAll());
        
    /**
     * Creates new form OffreUI
     */
    public OffreUI() {
        //initComponents();
        setBorder(new TitledBorder(new EtchedBorder(),"Consulter les Offres"));
        setLayout(new BorderLayout(5, 5));
        add(initFields(), BorderLayout.NORTH);
        add(initButtons(), BorderLayout.CENTER);        
        //setFieldData(uneEntreprise.moveFirst());
    }
    
    private JPanel initButtons() {
      JPanel panel = new JPanel();
      panel.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));
      panel.add(precedentButton);
      panel.add(suivantButton);
      panel.add(cancelButton);
      
      precedentButton.addActionListener(new ButtonHandler());
      suivantButton.addActionListener(new ButtonHandler());
      cancelButton.addActionListener(new ButtonHandler());
      //list.addListSelectionListener(new OffreSelectionListener());
      
      return panel;
   }
    
     private JPanel initFields() {
      JPanel panel = new JPanel();
      panel.setLayout(new MigLayout());
      
      panel.add(new JLabel("Nom de l'entreprise"), "align label");
      panel.add(nomEntrepriseField, "wrap");
      //raisonSocialeField.setEnabled(false);
      
      panel.add(new JLabel("Ville du Stage"), "align label");
      panel.add(villeField, "wrap");
      //villeField.setEnabled(false);
      
      panel.add(new JLabel("Domaine offre"), "align label");
      panel.add(domaineField, "wrap");
      //rueField.setEnabled(false);
      
      panel.add(new JLabel("Libellé de l'offre"), "align label");
      panel.add(libelleField, "wrap");
      //cpField.setEnabled(false);
      
      panel.add(new JLabel("Date de début du stage"), "align label");
      panel.add(dateDebutField, "wrap");
      //telField.setEnabled(false);
      
      panel.add(new JLabel("Durée du stage"), "align label");
      panel.add(dureeStageField, "wrap");
      //telField.setEnabled(false);

      return panel;
   }

   

   private void setFieldData(OffreStage o) {
      nomEntrepriseField.setText(o.getEntreprise().getRaisonSociale());
      villeField.setText(o.getEntreprise().getVille());
      domaineField.setText(o.getDomaine().getLibelleDomaine());
      libelleField.setText(o.getLibelleO());
      dateDebutField.setText(o.getDateDebutO().toString());
      dureeStageField.setText(String.valueOf(o.getDureeO()));
      descriptifField.setText(o.getDescriptiFo());
   }
    

    private class ButtonHandler implements ActionListener {
      @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
         String command = ((JButton) e.getSource()).getActionCommand();
         switch (command) {
         case "Precedent":
            setFieldData(iterator.precedent()); 
            break;
         case "Suivant":
            setFieldData(iterator.suivant()); 
            break;
         case "Annuler":
            System.exit(0);
         default:
            JOptionPane.showMessageDialog(null,
            "invalid command");
         }
        }
   }
    
     private class OffreIterator {
         private ArrayList<OffreStage> lesOffres;
         private ListIterator<OffreStage> iterator;
         private OffreStage current;
         
         public OffreIterator(ArrayList<OffreStage> desOffres){
             lesOffres=desOffres;
             iterator = lesOffres.listIterator();
        }
         
         public OffreStage suivant(){
             if (iterator.hasNext()){
                current = iterator.next();
                return current;
             }
             else {
                 return current;
             }
         }
         
         public OffreStage precedent(){
             if (iterator.hasPrevious()){
                current = iterator.previous();
                return current;
             }
             else {
                 return current;
             }
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
