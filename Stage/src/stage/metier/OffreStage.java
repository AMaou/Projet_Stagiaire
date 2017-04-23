/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stage.metier;

import java.util.Date;

/**
 *
 * @author Aya
 */
public class OffreStage {
    private int idOffre, dureeO, remuneration;
    private Entreprise entreprise;
    private DomaineOffre domaine;
    private String libelleO, descriptiFo;
    private Date dateDebutO;
    private boolean valide;
    
    public OffreStage(){}

    /**
     * @return the idOffre
     */
    public int getIdOffre() {
        return idOffre;
    }

    /**
     * @param idOffre the idOffre to set
     */
    public void setIdOffre(int idOffre) {
        this.idOffre = idOffre;
    }

    /**
     * @return the dureeO
     */
    public int getDureeO() {
        return dureeO;
    }

    /**
     * @param dureeO the dureeO to set
     */
    public void setDureeO(int dureeO) {
        this.dureeO = dureeO;
    }

    /**
     * @return the remuneration
     */
    public int getRemuneration() {
        return remuneration;
    }

    /**
     * @param remuneration the remuneration to set
     */
    public void setRemuneration(int remuneration) {
        this.remuneration = remuneration;
    }

    /**
     * @return the entreprise
     */
    public Entreprise getEntreprise() {
        return entreprise;
    }

    /**
     * @param entreprise the entreprise to set
     */
    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    /**
     * @return the domaine
     */
    public DomaineOffre getDomaine() {
        return domaine;
    }

    /**
     * @param domaine the domaine to set
     */
    public void setDomaine(DomaineOffre domaine) {
        this.domaine = domaine;
    }

    /**
     * @return the libelleO
     */
    public String getLibelleO() {
        return libelleO;
    }

    /**
     * @param libelleO the libelleO to set
     */
    public void setLibelleO(String libelleO) {
        this.libelleO = libelleO;
    }

    /**
     * @return the descriptiFo
     */
    public String getDescriptiFo() {
        return descriptiFo;
    }

    /**
     * @param descriptiFo the descriptiFo to set
     */
    public void setDescriptiFo(String descriptiFo) {
        this.descriptiFo = descriptiFo;
    }

    /**
     * @return the dateDebutO
     */
    public Date getDateDebutO() {
        return dateDebutO;
    }

    /**
     * @param dateDebutO the dateDebutO to set
     */
    public void setDateDebutO(Date dateDebutO) {
        this.dateDebutO = dateDebutO;
    }

    /**
     * @return the valide
     */
    public boolean isValide() {
        return valide;
    }

    /**
     * @param valide the valide to set
     */
    public void setValide(boolean valide) {
        this.valide = valide;
    }
}
