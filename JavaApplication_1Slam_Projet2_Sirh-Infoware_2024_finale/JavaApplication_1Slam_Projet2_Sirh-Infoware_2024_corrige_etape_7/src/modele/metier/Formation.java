package modele.metier;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author anais
 */
public class Formation {
    public String code;
    public  String nom; 
    public Date dateDebut; 
    private int nbreJours; 
    private double coutJourForm; 
    
    
    // lien  avec la classe Salarie
    private ArrayList<Suivre> lesFormationsSuivies = new ArrayList<>();

    public Formation(String code, String nom, Date dateDebut, int nbreJours, double coutJourForm) {
        this.code = code;
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.nbreJours = nbreJours;
        this.coutJourForm = coutJourForm;
    }
    public Formation() {
        
    }
    public Formation(String nom) {
        this.nom = nom; 
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public int getNbreJours() {
        return nbreJours;
    }

    public void setNbreJours(int nbreJours) {
        this.nbreJours = nbreJours;
    }

    public double getCoutJourForm() {
        return coutJourForm;
    }

    public void setCoutJourForm(double coutJourForm) {
        this.coutJourForm = coutJourForm;
    }

    public ArrayList<Suivre> getLesFormationsSuivies() {
        return lesFormationsSuivies;
    }    

    public void setLesFormationsSuivies(ArrayList<Suivre> lesFormationsSuivies) {
        this.lesFormationsSuivies = lesFormationsSuivies;
    }
    
    @Override
    public String toString() {
        return nom; 
    }

    public String toStringEtat() {
        return ""; 
    }    
}
