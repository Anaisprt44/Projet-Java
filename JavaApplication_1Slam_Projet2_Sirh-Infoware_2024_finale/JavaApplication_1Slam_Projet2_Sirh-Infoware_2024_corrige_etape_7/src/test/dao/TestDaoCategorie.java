package test.dao;

import java.io.IOException;
import modele.dao.*;
import java.sql.SQLException;
import java.util.ArrayList;
import modele.metier.Categorie;

/**
 * Test unitaire de la classe DaoCategorie
 * @author btssio
 */
public class TestDaoCategorie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Test 1 getOneById
        System.out.println("\n Test 1 : DaoCategorie.getOneById");
        try {
            String idRecherche = "C2";
            Categorie categ = DaoCategorie.getOneById(idRecherche);
            if(categ != null){
                System.out.println("Categorie d'id "+idRecherche+" trouvée : \n"+categ.toStringEtat());
            }else{
                System.out.println("Categorie d'id "+idRecherche+" non trouvée : \n");
            }
            
        } catch (SQLException ex) {
            System.out.println("TestDaoCategorie - échec getOneById : " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("TestDaoCategorie - échec getOneById : " + ex.getMessage());
        }
        // Test 2 getAll
        System.out.println("\n Test 2 : DaoCategorie.getAll");
        try {
            ArrayList<Categorie> lesCategories = DaoCategorie.getAll();
            for (Categorie categ : lesCategories) {
                System.out.println(categ.toStringEtat());
            }
            System.out.println(lesCategories.size()+" catégories trouvées");
        } catch (SQLException | IOException ex) {
            System.out.println("TestDaoCategorie - échec getAll : " + ex.getMessage());
        }
        
        // Fermeture de la connexion
        try {
            ConnexionBDD.getConnexion().close();
            System.out.println("\nConnexion à la BDD fermée");
        } catch (SQLException ex) {
            System.out.println("TestDaoCategorie - échec de la fermeture de la connexion : " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("TestDaoCategorie - échec de la fermeture de la connexion : " + ex.getMessage());
        }
    }

}
