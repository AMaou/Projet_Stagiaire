/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stage;

import UI.*;
import dao.DomaineOffreDAO;
import dao.EntrepriseDAO;
import dao.OffreStageDAO;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import stage.metier.Entreprise;
import stage.metier.SecteurActivite;

/**
 *
 * @author 
 */
public class Stage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame f=new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
        f.getContentPane().add(new EntrepriseUI());
        f.setSize(600, 500);
        f.setVisible(true);
        
        JFrame f1=new JFrame();
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
        f1.getContentPane().add(new OffreUI());
        f1.setSize(600, 400);
        f1.setVisible(true);
        
        JFrame f2=new JFrame();
        f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f2.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
        f2.getContentPane().add(new AccueilUI());
        f2.setSize(600, 400);
        f2.setVisible(true);
    }
    
}
