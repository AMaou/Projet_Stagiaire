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
import stage.metier.Entreprise;
import stage.metier.SecteurActivite;

/**
 *
 * @author 
 */
public class EntrepriseDAO extends DAO<Entreprise>{

    @Override
    public Entreprise find(int id) {
        Entreprise entreprise=null;
        SecteurActiviteDAO secteurDAO = new SecteurActiviteDAO();
	    try {
	        PreparedStatement pstat=connect.prepareStatement("SELECT * FROM entreprise WHERE ident = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstat.setInt(1, id);
            ResultSet rs=pstat.executeQuery();
            if(rs.first()){
		        entreprise = new Entreprise();
		
		        entreprise.setIdEnt(rs.getInt("ident"));
                        entreprise.setSecteur(secteurDAO.find(rs.getInt("idSecteur")));
                        entreprise.setCP(rs.getString("cp"));
                        entreprise.setRaisonSociale(rs.getString("raisonsociale"));
                        entreprise.setRue(rs.getString("rue"));
                        entreprise.setTel(rs.getString("tel"));
                        entreprise.setVille(rs.getString("ville"));
	        }
            rs.close();
        } catch (Exception e) {
	    e.printStackTrace();
	    }

	    return entreprise;
    }

    @Override
    public ArrayList<Entreprise> findAll() {
        ArrayList<Entreprise> lesEntreprises = new ArrayList<Entreprise>();
        SecteurActiviteDAO secteurDAO = new SecteurActiviteDAO();
        String requete = "select * from entreprise";
        ResultSet rs= null;
        try{
        rs = this.connect.createStatement().executeQuery(requete);
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        try {
            while (rs.next()) {
                Entreprise uneEntreprise = new Entreprise();
                uneEntreprise.setIdEnt(rs.getInt("ident"));
                uneEntreprise.setSecteur(secteurDAO.find(rs.getInt("idSecteur")));
                uneEntreprise.setCP(rs.getString("cp"));
                uneEntreprise.setRaisonSociale(rs.getString("raisonsociale"));
                uneEntreprise.setRue(rs.getString("rue"));
                uneEntreprise.setTel(rs.getString("tel"));
                uneEntreprise.setVille(rs.getString("ville"));
                lesEntreprises.add(uneEntreprise);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DomaineOffreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lesEntreprises;
    }

    @Override
    public Entreprise create(Entreprise obj) {
        try {

            PreparedStatement pstat = connect.prepareStatement("INSERT INTO entreprise (RaisonSociale, Ville, Rue, Cp, Tel, IdSecteur) VALUES\n" +
"(?, ?, ?, ?, ?, ?)"); 
            pstat.setString(1, obj.getRaisonSociale());
            pstat.setString(2, obj.getVille());
            pstat.setString(3, obj.getRue());
            pstat.setString(4, obj.getCP());
            pstat.setString(5, obj.getTel());
            pstat.setInt(6, obj.getSecteur().getIdSecteur());
            pstat.executeUpdate();
            pstat.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public Entreprise update(Entreprise obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Entreprise obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
