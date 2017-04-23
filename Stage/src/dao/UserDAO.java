/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import stage.metier.OffreStage;
import stage.metier.User;

/**
 *
 * @author Aya
 */
public class UserDAO extends DAO<User>{
    
    public boolean verifierLogin(User u){
        boolean flag=false;
        try {
	        PreparedStatement pstat=connect.prepareStatement("SELECT * FROM users WHERE login = ? and password = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstat.setString(1, u.getLogin());
            pstat.setString(2, u.getPassword());
            ResultSet rs=pstat.executeQuery();
            if(rs.next()){
		 flag = true; 
	        }
            rs.close();
        } catch (Exception e) {
	    e.printStackTrace();
	    }
        
        return flag;
    }

    @Override
    public User find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<User> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User create(User obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User update(User obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(User obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
