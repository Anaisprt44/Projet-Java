package test.metier;

import java.util.ArrayList;
import java.util.Date;
import modele.metier.Formation;

/**
 * Classe de test pour la classe Formation
 * @author anais
 */
public class TestFormation {
    public static void main(String[] args) {

        // Créer des instances de Formation          
        Formation formation1 = new Formation("F001", "Formation Java", new Date(), 5, 200.0);
        Formation formation2 = new Formation("F002", "Formation SQL", new Date(), 3, 150.0);
        Formation formation3 = new Formation("F003", "Formation Python", new Date(), 7, 250.0);

        // Afficher les noms des formations
        System.out.println("Nom de la formation 1: " + formation1.getNom());
        System.out.println("Nom de la formation 2: " + formation2.getNom());
        System.out.println("Nom de la formation 3: " + formation3.getNom());

        // Tester la méthode toString()
        System.out.println("Détails de la formation 1: " + formation1);
        System.out.println("Détails de la formation 2: " + formation2);
        System.out.println("Détails de la formation 3: " + formation3);

        // Ajouter les formations à une liste pour simuler l'utilisation dans Salarie
        ArrayList<Formation> formations = new ArrayList<>();
        formations.add(formation1);
        formations.add(formation2);
        formations.add(formation3);

        // Vérifier le nombre de formations dans la liste
        System.out.println("Nombre de formations suivies: " + formations.size());

        // Parcourir et afficher les formations
        for (Formation formation : formations) {
            System.out.println("Formation suivie: " + formation.getNom());
        }
    }
}
