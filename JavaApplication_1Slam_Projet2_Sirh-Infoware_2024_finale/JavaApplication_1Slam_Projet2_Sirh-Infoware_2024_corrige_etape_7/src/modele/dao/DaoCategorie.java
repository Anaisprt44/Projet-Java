package modele.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modele.metier.Categorie;

/**
 * Classe DAO : liaison classe métier Categorie / table CATEGORIE
 * @author btssio
 */
public class DaoCategorie {

    /**
     * Rechercher un enregistrement dans la table CATEGORIE d'après son code (String)
     * et en faire un objet de type Categorie
     *
     * @param id code de la catégorie recherchée
     * @return objet de type Categorie si trouvé dans la BDD, null sinon
     * @throws SQLException
     */
    public static Categorie getOneById(String id) throws SQLException, IOException {
        Categorie categorieTrouvee = null;
        Connection cnx = ConnexionBDD.getConnexion();
        PreparedStatement pstmt = cnx.prepareStatement("SELECT * FROM Categorie WHERE Code = ?");
        pstmt.setString(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            categorieTrouvee = new Categorie(
                    id,
                    rs.getString("Libelle"),
                    rs.getDouble("salaireMini"),
                    rs.getString("CaisseDeRetraite"),
                    rs.getInt("PrimeResultat")
            );
        }
        return categorieTrouvee;
    }

    /**
     * Extraire l'ensemble des enregistrements de la table CATEGORIE
     * @return liste d'objets de type Categorie
     * @throws SQLException 
     */
    public static ArrayList<Categorie> getAll() throws SQLException, IOException {
        ArrayList<Categorie> lesCategorieTrouvees = new ArrayList<>();
        Connection cnx = ConnexionBDD.getConnexion();
        PreparedStatement pstmt = cnx.prepareStatement("SELECT * FROM Categorie");
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Categorie uneCategorie = new Categorie(
                    rs.getString("Code"),
                    rs.getString("Libelle"),
                    rs.getDouble("salaireMini"),
                    rs.getString("CaisseDeRetraite"),
                    rs.getInt("PrimeResultat")
            );
            lesCategorieTrouvees.add(uneCategorie);
        }
        return lesCategorieTrouvees;
    }

}
