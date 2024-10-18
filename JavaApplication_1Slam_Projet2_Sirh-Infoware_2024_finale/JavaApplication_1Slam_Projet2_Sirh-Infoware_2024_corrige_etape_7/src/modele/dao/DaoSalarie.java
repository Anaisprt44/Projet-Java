package modele.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modele.metier.*;

/**
 * Classe DAO : liaison classe métier Salarie / table SALARIE
 *
 * @author btssio
 */
public class DaoSalarie {

    /**
     * Rechercher un enregistrement dans la table SALARIE d'après son code
     * (String) et en faire un objet de type Salarie
     *
     * @param id code du salarie recherché
     * @return objet de type Salarie si trouvé dans la BDD, null sinon
     * @throws SQLException
     * @throws IOException
     */
    public static Salarie getOneById(String id) throws SQLException, IOException {
        Salarie salarieTrouve = null;
        Connection cnx = ConnexionBDD.getConnexion();
        PreparedStatement pstmt = cnx.prepareStatement("SELECT * FROM Salarie WHERE Code = ?");
        pstmt.setString(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            salarieTrouve = creerSalarie(rs);
        }
        return salarieTrouve;
    }

    /**
     * Extraire l'ensemble des enregistrements de la table SALARIE
     *
     * @return liste d'objets de type Salarie
     * @throws SQLException
     * @throws IOException
     */
    public static ArrayList<Salarie> getAll() throws SQLException, IOException {
        ArrayList<Salarie> lesSalariesTrouves = new ArrayList<>();
        Connection cnx = ConnexionBDD.getConnexion();
        PreparedStatement pstmt = cnx.prepareStatement("SELECT * FROM Salarie");
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Salarie unSalarie = creerSalarie(rs);
            lesSalariesTrouves.add(unSalarie);
        }
        return lesSalariesTrouves;
    }

    /**
     * Extraire les enregistrements de la table SALARIE liés à un service donné
     *
     * @param idService code du service à filtrer
     * @return liste d'objets de type Salarie
     * @throws SQLException
     * @throws IOException
     */
    public static ArrayList<Salarie> getAllByService(int idService) throws SQLException, IOException {
        ArrayList<Salarie> lesSalariesTrouves = new ArrayList<>();
        Connection cnx = ConnexionBDD.getConnexion();
        PreparedStatement pstmt = cnx.prepareStatement("SELECT * FROM Salarie WHERE CodeServ = ?");
        pstmt.setInt(1, idService);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Salarie unSalarie = creerSalarie(rs);
            lesSalariesTrouves.add(unSalarie);
        }
        return lesSalariesTrouves;
    }

    /**
     * Transforme un enregistrement de la table SALARIE en instance de Salarie
     *
     * @param rs jeu d'enregistrements ; l'enregistrement courant est concerné
     * @return instance de Salarie
     * @throws SQLException
     * @throws IOException
     */
    private static Salarie creerSalarie(ResultSet rs) throws SQLException, IOException {
        Salarie unSalarie = null;
        // Récupération du service du salarié
        Service unService = DaoService.getOneById(rs.getInt("CodeServ"));
        Categorie uneCateg = DaoCategorie.getOneById(rs.getString("NumCat"));
        unSalarie = new Salarie(
                rs.getString("Code"),
                rs.getString("Nom"),
                rs.getString("Prenom"),
                (java.util.Date) rs.getDate("DateNaiss"),
                (java.util.Date) rs.getDate("DateEmbauche"),
                rs.getString("Fonction"),
                rs.getDouble("TauxHoraire"),
                rs.getString("situationFamiliale"),
                rs.getInt("NbrEnfants"),
                unService,
                uneCateg
        );
        return unSalarie;
    }

    /**
     * Supprime un enegistrement de la table SALARIE
     *
     * @param codeSalarie
     * @return nombre d'enregistrements concernés
     * @throws SQLException
     * @throws IOException
     */
    public static int deleteById(String codeSalarie) throws SQLException, IOException {
        int retour;
        Connection cnx = ConnexionBDD.getConnexion();
        PreparedStatement pstmt = cnx.prepareStatement("DELETE FROM Salarie WHERE Code = ?");
        pstmt.setString(1, codeSalarie);
        retour = pstmt.executeUpdate();
         return retour;
    }

}
