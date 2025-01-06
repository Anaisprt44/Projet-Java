package modele.metier;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Classe métier Categorie de salarié
 * @author btssio
 */
public class Categorie {
    private String code;
    private String libelle;
    private double salaireMini;
    private String caisseRetraite;
    private int prime;
    private ArrayList<Salarie> categorie = new ArrayList<>();

    public Categorie(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
        this.salaireMini = 0.0;
        this.caisseRetraite = "";
        this.prime = 0;
    }
    public Categorie(String code, String libelle, double salaireMini, String caisseRetraite, int prime) {
        this.code = code;
        this.libelle = libelle;
        this.salaireMini = salaireMini;
        this.caisseRetraite = caisseRetraite;
        this.prime = prime;
    }

    /**
     * toString complet (tous les attributs)
     * @return état complet de l'objet
     */
    public String toStringEtat() {
        return "Categorie{" + "code=" + code + ", libelle=" + libelle + ", salaireMini=" + salaireMini + ", caisseRetraite=" + caisseRetraite + ", prime=" + prime + '}';
    }
    
    /**
     * toString court, pour affichage dans les listes déroulantes
     * @return état de l'objet
     */
    @Override
    public String toString() {
        return libelle;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Categorie other = (Categorie) obj;
        return Objects.equals(this.code, other.code);
    }
    
    
}
