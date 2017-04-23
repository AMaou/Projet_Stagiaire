/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stage.metier;

/**
 *
 * @author Aya
 */
public class SecteurActivite {
    private int idSecteur;
    private String libelleS;
    
    public SecteurActivite(){}

    /**
     * @return the idSecteur
     */
    public int getIdSecteur() {
        return idSecteur;
    }

    /**
     * @param idSecteur the idSecteur to set
     */
    public void setIdSecteur(int idSecteur) {
        this.idSecteur = idSecteur;
    }

    /**
     * @return the libelleS
     */
    public String getLibelleS() {
        return libelleS;
    }

    /**
     * @param libelleS the libelleS to set
     */
    public void setLibelleS(String libelleS) {
        this.libelleS = libelleS;
    }
}
