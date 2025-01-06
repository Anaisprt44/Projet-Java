import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import modele.dao.DaoFormation;
import modele.metier.Formation;

/**
 * Test DAO Formation
 * @author anais
 */
public class TestDaoFormation {
    
    /**
     * méthode main pour tester
     * @param args 
     */
    public static void main(String[] args) {
        try {
            
            // Test 1: Récupérer une formation par son code
            Formation formationById = DaoFormation.getOneById("F01");
            if (formationById != null) {
                System.out.println("Test 1 : DaoFormation.getOneById");
                System.out.println("Formation avec le code F01 trouvée : " + formationById.getNom());
            } else {
                System.out.println("Aucune formation trouvée avec le code F01.");
            }

             //Test 2: Récupérer les formations suivies par un salarié
            String codeSalarie = "S07"; // Changez cela avec un code valide pour le test
            ArrayList<Formation> formationsForSalarie = DaoFormation.getFormationsBySalarie(codeSalarie);
            
            System.out.println("Test 2 : Récupérer les formations pour le salarié " + codeSalarie);
            if (!formationsForSalarie.isEmpty()) {
                System.out.println(formationsForSalarie.size() + " formations trouvées pour le salarié " + codeSalarie + ":");
                for (Formation f : formationsForSalarie) {
                    System.out.println(f.getNom());
                }
            } else {
              System.out.println("Aucune formation trouvée pour le salarié " + codeSalarie + ".");
            }

           // Test 3: Récupérer les formations pour un salarié avec un code qui n'existe pas
            String codeSalarieInconnu = "S02"; // faut que ce code n'existe pas
            ArrayList<Formation> formationsInconnues = DaoFormation.getFormationsBySalarie(codeSalarieInconnu);            
            System.out.println("Test 3 : Récupérer les formations pour le salarié " + codeSalarieInconnu);
            if (formationsInconnues.isEmpty()) {
                System.out.println("Aucune formation trouvée pour le salarié " + codeSalarieInconnu + ".");
            } else {
                System.out.println("Des formations ont été trouvées pour le salarié " + codeSalarieInconnu + ".");
            }       
            

        } catch (SQLException | IOException e) {
            System.err.println("Erreur lors des tests : " + e.getMessage());
        }
    }
}
