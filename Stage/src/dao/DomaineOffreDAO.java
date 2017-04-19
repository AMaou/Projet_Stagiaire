/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import stage.metier.DomaineOffre;

/**
 *
 * @author
 */
public class DomaineOffreDAO extends DAO<DomaineOffre>{
    

    @Override
    public DomaineOffre find(int id) {
        DomaineOffre domaine=null;
	    try {
	        PreparedStatement pstat=connect.prepareStatement("SELECT * FROM domaineoffre WHERE iddomaine = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstat.setInt(1, id);
            ResultSet rs=pstat.executeQuery();
            if(rs.first()){
		        domaine = new DomaineOffre();
		
		        domaine.setIdDomaine(rs.getInt("iddomaine"));
		        domaine.setLibelleDomaine(rs.getString("libelledomaine"));
	        }
            rs.close();
        } catch (Exception e) {
	    e.printStackTrace();
	    }

	    return domaine;
    }

    @Override
    public ArrayList<DomaineOffre> findAll() {
        ArrayList<DomaineOffre> lesDomaines = new ArrayList<DomaineOffre>();
        String requete = "select * from domaineoffre";
        ResultSet rs= null;
        try{
        rs = this.connect.createStatement().executeQuery(requete);
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        try {
            while (rs.next()) {
                DomaineOffre unDomaine = new DomaineOffre();
                unDomaine.setIdDomaine(rs.getInt("iddomaine"));
                unDomaine.setLibelleDomaine( rs.getString("libelledomaine"));
                lesDomaines.add(unDomaine);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DomaineOffreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lesDomaines;
    }

    @Override
    public DomaineOffre create(DomaineOffre obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DomaineOffre update(DomaineOffre obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(DomaineOffre obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
