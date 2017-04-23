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
import stage.metier.Entreprise;
import stage.metier.OffreStage;

/**
 *
 * @author Aya
 */
public class OffreStageDAO extends DAO<OffreStage>{

    @Override
    public OffreStage find(int id) {
        OffreStage offre=null;
        DomaineOffreDAO domaineDAO = new DomaineOffreDAO();
        EntrepriseDAO entrepriseDAO = new EntrepriseDAO();
        SecteurActiviteDAO secteurDAO = new SecteurActiviteDAO();
	    try {
	        PreparedStatement pstat=connect.prepareStatement("SELECT * FROM offrestage WHERE idoffre = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstat.setInt(1, id);
            ResultSet rs=pstat.executeQuery();
            if(rs.first()){
		        offre = new OffreStage();
		
		        offre.setIdOffre(rs.getInt("idoffre"));
                        offre.setDomaine(domaineDAO.find(rs.getInt("iddomaine")));
                        offre.setEntreprise(entrepriseDAO.find(rs.getInt("ident")));
                        offre.setDureeO(rs.getInt("dureeo"));
                        offre.setRemuneration(rs.getInt("remuneration"));
                        offre.setLibelleO(rs.getString("libelleo"));
                        offre.setDescriptiFo(rs.getString("descriptifo"));
                        offre.setValide(rs.getBoolean("valide"));
                        offre.setDateDebutO(rs.getDate("datedebuto"));  
	        }
            rs.close();
        } catch (Exception e) {
	    e.printStackTrace();
	    }

	    return offre;
    }

    @Override
    public ArrayList<OffreStage> findAll() {
	ArrayList<OffreStage> lesOffres = new ArrayList<OffreStage>();
        DomaineOffreDAO domaineDAO = new DomaineOffreDAO();
        EntrepriseDAO entrepriseDAO = new EntrepriseDAO();
        String requete = "select * from offrestage";
        ResultSet rs= null;
        try{
        rs = this.connect.createStatement().executeQuery(requete);
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        try {
            while (rs.next()) {
                OffreStage uneOffre = new OffreStage();
                uneOffre.setIdOffre(rs.getInt("idoffre"));
                uneOffre.setDomaine(domaineDAO.find(rs.getInt("iddomaine")));
                uneOffre.setEntreprise(entrepriseDAO.find(rs.getInt("ident")));
                uneOffre.setDureeO(rs.getInt("dureeo"));
                uneOffre.setRemuneration(rs.getInt("remuneration"));
                uneOffre.setLibelleO(rs.getString("libelleo"));
                uneOffre.setDescriptiFo(rs.getString("descriptifo"));
                uneOffre.setValide(rs.getBoolean("valide"));
                uneOffre.setDateDebutO(rs.getDate("datedebuto"));                
                lesOffres.add(uneOffre);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DomaineOffreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lesOffres;
    }

    @Override
    public OffreStage create(OffreStage obj) {
        try {

            PreparedStatement pstat = connect.prepareStatement("INSERT INTO offrestage (IdEnt, LibelleO, DescriptifO, DateDebutO, DureeO, Remuneration, Valide, IdDomaine) VALUES\n" +
"(?, ?, ?, ?, ?, ?, ?, ?)"); 
            pstat.setInt(1, obj.getEntreprise().getIdEnt());
            pstat.setString(2, obj.getLibelleO());
            pstat.setString(3, obj.getDescriptiFo());
            pstat.setDate(4, new java.sql.Date(obj.getDateDebutO().getTime()));
            pstat.setInt(5, obj.getDureeO());
            pstat.setInt(6, obj.getRemuneration());
            pstat.setBoolean(7, obj.isValide());
            pstat.setInt(8, obj.getDomaine().getIdDomaine());
            pstat.executeUpdate();
            pstat.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public OffreStage update(OffreStage obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(OffreStage obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
