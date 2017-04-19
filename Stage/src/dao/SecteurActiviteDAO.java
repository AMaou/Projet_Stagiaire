/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import stage.metier.DomaineOffre;
import stage.metier.SecteurActivite;

/**
 *
 * @author 
 */
public class SecteurActiviteDAO extends DAO<SecteurActivite> {

    @Override
    public SecteurActivite find(int id) {
        SecteurActivite secteur=null;
	    try {
	        PreparedStatement pstat=connect.prepareStatement("SELECT * FROM secteuractivite WHERE idsecteur = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstat.setInt(1, id);
            ResultSet rs=pstat.executeQuery();
            if(rs.first()){
		        secteur = new SecteurActivite();
		
		        secteur.setIdSecteur(rs.getInt("idsecteur"));
                        secteur.setLibelleS(rs.getString("libelles"));
	        }
            rs.close();
        } catch (Exception e) {
	    e.printStackTrace();
	    }

	    return secteur;
    }

    @Override
    public ArrayList<SecteurActivite> findAll() {
        ArrayList<SecteurActivite> lesSecteurs = new ArrayList<SecteurActivite>();
        String requete = "select * from secteuractivite";
        ResultSet rs= null;
        try{
        rs = this.connect.createStatement().executeQuery(requete);
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        try {
            while (rs.next()) {
                SecteurActivite unSecteur = new SecteurActivite();
                unSecteur.setIdSecteur(rs.getInt("idsecteur"));
                unSecteur.setLibelleS(rs.getString("libelles"));
                lesSecteurs.add(unSecteur);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DomaineOffreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lesSecteurs;
    }

    @Override
    public SecteurActivite create(SecteurActivite obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SecteurActivite update(SecteurActivite obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(SecteurActivite obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
