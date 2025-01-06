package test.dao;

import java.io.IOException;
import modele.dao.ConnexionBDD;
import modele.dao.DaoSalarie;
import java.sql.SQLException;
import java.util.ArrayList;
import modele.metier.Salarie;

/**
 * Test unitaire de la classe DaoCSalarie
 *
 * @author btssio
 */
public class TestDaoSalarie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String idRecherche;
        int idService;
        System.out.println("TEST DAO SALARIE");
        // Test 1 getOneById
        System.out.println("\n Test 1 : DaoSalarie.getOneById");
        try {
            idRecherche = "S06";
            Salarie sal = DaoSalarie.getOneById(idRecherche);
            if (sal != null) {
                System.out.println("Salarie d'id " + idRecherche + " trouvé : \n" + sal.toString());
            } else {
                System.out.println("Salarie d'id " + idRecherche + " non trouvé : \n");
            }

        } catch (SQLException | IOException ex) {
            System.out.println("TestDaoSalarie - échec getOneById : " + ex.getMessage());
        }
        // Test 2 getAll
        System.out.println("\n Test 2 : DaoSalarie.getAll");
        try {
            ArrayList<Salarie> lesSalaries = DaoSalarie.getAll();
            for (Salarie sal : lesSalaries) {
                System.out.println(sal);
            }
            System.out.println(lesSalaries.size() + " salariés trouvés");
        } catch (SQLException | IOException ex) {
            System.out.println("TestDaoSalarie - échec getAll : " + ex.getMessage());
        }

        // Test 3 getAllByService
        System.out.println("\n Test 3 : DaoSalarie.getAllByService");
        try {
            idService = 3;
            ArrayList<Salarie> lesSalaries = DaoSalarie.getAllByService(idService);
            for (Salarie sal : lesSalaries) {
                System.out.println(sal);
            }
            System.out.println(lesSalaries.size() + " salariés trouvés");
        } catch (SQLException | IOException ex) {
            System.out.println("TestDaoSalarie - échec getAllByService : " + ex.getMessage());
        }

        // Test 4 deleteById
        System.out.println("\n Test 4 : DaoSalarie.delete");
        try {
            idRecherche = "S15"; // PETIT Sylvie
            int nb = DaoSalarie.deleteById(idRecherche);
            Salarie sal = DaoSalarie.getOneById(idRecherche);
            if (sal == null) {
                System.out.println("Réussite de la suppression du salarie  d'id "  + idRecherche + "\n" + nb + " enregistrements supprimé(s)" );
             } else {
               System.out.println("Echec de la suppression : salarie d'id " + idRecherche + " trouvé : \n" + sal.toString() + " \n " + nb + " enregistrements supprimé(s)" );
            }
        } catch (SQLException | IOException ex) {
            System.out.println("TestDaoSalarie - échec delete : " + ex.getMessage());
        }

        // Fermeture de la connexion
        try {
            ConnexionBDD.getConnexion().close();
            System.out.println("\nConnexion à la BDD fermée");
        } catch (SQLException | IOException ex) {
            System.out.println("TestDaoSalarie - échec de la fermeture de la connexion : " + ex.getMessage());
        }
    }

}
