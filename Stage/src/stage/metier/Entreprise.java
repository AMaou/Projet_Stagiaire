/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stage.metier;

/**
 *
 * @author 
 */
public class Entreprise {
  private int idEnt;
  private String raisonSociale, Ville, Rue, CP, Tel ;
  private SecteurActivite secteur;

  public Entreprise(){}
    /**
     * @return the idEnt
     */
    public int getIdEnt() {
        return idEnt;
    }

    /**
     * @param idEnt the idEnt to set
     */
    public void setIdEnt(int idEnt) {
        this.idEnt = idEnt;
    }

   

    /**
     * @return the raisonSociale
     */
    public String getRaisonSociale() {
        return raisonSociale;
    }

    /**
     * @param raisonSociale the raisonSociale to set
     */
    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    /**
     * @return the Ville
     */
    public String getVille() {
        return Ville;
    }

    /**
     * @param Ville the Ville to set
     */
    public void setVille(String Ville) {
        this.Ville = Ville;
    }

    /**
     * @return the Rue
     */
    public String getRue() {
        return Rue;
    }

    /**
     * @param Rue the Rue to set
     */
    public void setRue(String Rue) {
        this.Rue = Rue;
    }

    /**
     * @return the CP
     */
    public String getCP() {
        return CP;
    }

    /**
     * @param CP the CP to set
     */
    public void setCP(String CP) {
        this.CP = CP;
    }

    /**
     * @return the Tel
     */
    public String getTel() {
        return Tel;
    }

    /**
     * @param Tel the Tel to set
     */
    public void setTel(String Tel) {
        this.Tel = Tel;
    }

    /**
     * @return the secteur
     */
    public SecteurActivite getSecteur() {
        return secteur;
    }

    /**
     * @param secteur the secteur to set
     */
    public void setSecteur(SecteurActivite secteur) {
        this.secteur = secteur;
    }
    
    public String toString(){
        return raisonSociale;
    }
}
