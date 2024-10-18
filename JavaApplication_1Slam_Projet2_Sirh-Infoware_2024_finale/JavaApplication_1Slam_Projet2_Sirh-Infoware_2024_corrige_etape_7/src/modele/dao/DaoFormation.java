package modele.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import modele.metier.Formation;

public class DaoFormation {

    /**
     * Rechercher une formation dans la table FORMATION d'après son code
     * 
     * @param code code de la formation recherchée
     * @return objet de type Formation si trouvé, null sinon
     * @throws SQLException
     * @throws IOException
     */
    public static Formation getOneById(String code) throws SQLException, IOException {
        Formation formationTrouvee = null;
        Connection cnx = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            cnx = ConnexionBDD.getConnexion();
            pstmt = cnx.prepareStatement("SELECT * FROM Formation WHERE Code = ?");
            pstmt.setString(1, code);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                formationTrouvee = creerFormation(rs);
            }
        } catch (SQLException e) {
            // Log the exception (consider using a logging framework)
            e.printStackTrace();  // For demonstration, use logging in production
        } finally {
            // Close resources in reverse order of their opening
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (cnx != null) {
                cnx.close();
            }
        }
        return formationTrouvee;
    }
    
    /**
     * 
     * @param codeSalarie
     * @return
     * @throws SQLException
     * @throws IOException 
     */
     public static ArrayList<Formation> getFormationsBySalarie(String codeSalarie) throws SQLException, IOException {
        Connection cnx = ConnexionBDD.getConnexion(); // Assurez-vous que la connexion est ouverte
        ArrayList<Formation> formations = new ArrayList<>();
        String sql = "SELECT f.Nom " +
                     "FROM Formation f " +
                     "JOIN Suivre s ON f.Code = s.CodeForm " +
                     "JOIN Salarie sa ON s.CodeSal = sa.Code " +
                     "WHERE sa.Code = ?"; // Utiliser le code salarié comme paramètre

        try (PreparedStatement pstmt = cnx.prepareStatement(sql)) {
            pstmt.setString(1, codeSalarie); // Remplacer le paramètre par le code du salarié
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String nomFormation = rs.getString("Nom");
                formations.add(new Formation(nomFormation)); // Assurez-vous d'utiliser le bon constructeur
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des formations : " + e.getMessage());
            throw e; // Rethrow pour gérer les erreurs ailleurs si nécessaire
        }
        
        return formations; // Retourne la liste des formations
    }
     
     /**
      * 
      * @return
      * @throws SQLException
      * @throws IOException 
      */
     public static ArrayList<Formation> getAllFormations() throws SQLException, IOException {
        Connection cnx = ConnexionBDD.getConnexion();
        ArrayList<Formation> formations = new ArrayList<>();
        String sql = "SELECT f.Nom FROM Formation f"; 

        try (PreparedStatement pstmt = cnx.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String nomFormation = rs.getString("Nom");
                formations.add(new Formation(nomFormation)); 
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des formations : " + e.getMessage());
            throw e; // Rethrow pour gérer les erreurs ailleurs si nécessaire
        }

        return formations;
    }


    /**
     * Extraire l'ensemble des enregistrements de la table FORMATION
     * 
     * @return liste d'objets de type Formation
     * @throws SQLException
     * @throws IOException
     */
    public static ArrayList<Formation> getAll() throws SQLException, IOException {
        Connection cnx = null;
        ArrayList<Formation> formations = new ArrayList<>();
        try {
            // Ouverture de la connexion
            cnx = ConnexionBDD.getConnexion();

            String query = "SELECT code, nom, dateDebut, nbreJours, coutJourForm FROM Formation";
            PreparedStatement pstmt = cnx.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // Utilisation du constructeur de la classe Formation
                Formation formation = new Formation(
                    rs.getString("code"),            // Code de la formation
                    rs.getString("nom"),             // Nom de la formation
                    rs.getDate("dateDebut"),         // Date de début
                    rs.getInt("nbreJours"),          // Nombre de jours
                    rs.getDouble("coutJourForm")     // Coût par jour
                );
                formations.add(formation);
            }
        } catch (SQLException ex) {
            throw new SQLException("Erreur lors de la récupération des formations", ex);
        } finally {
            if (cnx != null) {
                cnx.close();  // Fermeture de la connexion
            }
        }
        return formations;
    }
    
    /**
     * 
     * @return
     * @throws SQLException
     * @throws IOException 
     */
    public static ArrayList<String> getAllFormationNames() throws SQLException, IOException {
        Connection cnx = null;
        ArrayList<String> formationNames = new ArrayList<>();
        try {
            // Ouverture de la connexion
            cnx = ConnexionBDD.getConnexion();

            // Requête pour récupérer uniquement les noms des formations
            String query = "SELECT nom FROM Formation";
            PreparedStatement pstmt = cnx.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            // Récupération des noms des formations
            while (rs.next()) {
                String nomFormation = rs.getString("nom");
                formationNames.add(nomFormation);
            }
        } catch (SQLException ex) {
            throw new SQLException("Erreur lors de la récupération des noms des formations", ex);
        } finally {
            if (cnx != null) {
                cnx.close();  // Fermeture de la connexion
            }
        }
        return formationNames;
    }


    /**
     * Transforme un enregistrement de la table FORMATION en instance de Formation
     * 
     * @param rs jeu d'enregistrements ; l'enregistrement courant est concerné
     * @return instance de Formation
     * @throws SQLException
     * @throws IOException
     */
    private static Formation creerFormation(ResultSet rs) throws SQLException, IOException {
        return new Formation(
                rs.getString("Code"),
                rs.getString("Nom"),
                new Date(rs.getDate("DateDebut").getTime()),  // Conversion de java.sql.Date à java.util.Date
                rs.getInt("Nbrejours"),  // Changed from NbJours to Nbrejours
                rs.getDouble("CoutJourForm")  // Changed from CoutJourFormation to CoutJourForm
        );
    }
    
    public static void ajouterFormationPourSalarie(String codeSalarie, String nomFormation) throws SQLException, IOException {
        Connection cnx = ConnexionBDD.getConnexion(); // Assurez-vous que la connexion est ouverte
        String sql = "INSERT INTO Suivre (CodeSal, CodeForm) VALUES (?, (SELECT Code FROM Formation WHERE Nom = ?))";

        try (PreparedStatement pstmt = cnx.prepareStatement(sql)) {
            pstmt.setString(1, codeSalarie); // Remplace le paramètre par le code du salarié
            pstmt.setString(2, nomFormation); // Remplace le paramètre par le nom de la formation
            pstmt.executeUpdate(); // Exécute l'insertion
            System.out.println("Formation ajoutée pour le salarié " + codeSalarie);
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout de la formation : " + e.getMessage());
            throw e; // Rethrow pour gérer les erreurs ailleurs si nécessaire
        }
    }  
      
    

   /**
   * Supprime une formation de la table FORMATION d'après son code
   * @param  codeSalrie 
   * @param nomFormation
   */
   public static void supprimerFormationPourSalarie(String codeSalarie, String nomFormation) throws SQLException, IOException {
        Connection cnx = ConnexionBDD.getConnexion(); // Assurez-vous que la connexion est ouverte
        String sql = "DELETE FROM Suivre WHERE CodeSal = ? AND CodeForm = (SELECT Code FROM Formation WHERE Nom = ?)";

        try (PreparedStatement pstmt = cnx.prepareStatement(sql)) {
            // Remplacer les paramètres par le code du salarié et le nom de la formation
            pstmt.setString(1, codeSalarie);
            pstmt.setString(2, nomFormation);

            // Exécuter la suppression
            int rowsAffected = pstmt.executeUpdate();

            // Vérifier si une ligne a été affectée
            if (rowsAffected > 0) {
                System.out.println("Formation supprimée pour le salarié " + codeSalarie);
            } else {
                throw new SQLException("Aucune formation trouvée à supprimer pour le salarié " + codeSalarie + " avec la formation " + nomFormation);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression de la formation : " + e.getMessage());
            throw e; // Rethrow pour gérer les erreurs ailleurs si nécessaire
        }
        }
    }
