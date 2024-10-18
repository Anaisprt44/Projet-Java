package test.metier;

import modele.metier.Categorie;

/**
 * Classe de test unitaire de la classe Categorie
 * @author btssio
 */
public class TestCategorie {

    public static void main(String[] args) {
        
        System.out.println("TestCategorie");
        Categorie uneCategorie = new Categorie("C1", "Cadre moyen", 1900.0, "AGIRC", 1);
        System.out.println(uneCategorie.toStringEtat());
    }

}
