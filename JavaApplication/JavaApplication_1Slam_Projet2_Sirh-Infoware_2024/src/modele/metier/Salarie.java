package modele.metier;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import modele.dao.DaoFormation;

/**
 * Classe métier
 * @author btssio
 */
public class Salarie {

    private String codeSal = "";
    private String nom = "";
    private String prenom = "";
    private Date dateNaiss;
    private Date dateEmbauche;
    private String fonction;
    private double tauxHoraire;
    private String situationFamiliale;
    private int nbrEnfants;
    private Service service;    
    private Categorie categorie; // Relation Many-to-One avec Categorie
    private ArrayList<Formation> lesFormationsSuivies; // Relation Many-to-One avec Formation
    // Relation avec la classe Suivre
    private ArrayList<Formation> formationsSuivies; // Une liste de Suivre
    private ArrayList<Suivre> suivis; // Liste des formations suivies
    private String code;

    /**
     * Classe salarié
     * @param code
     * @param nom
     * @param prenom
     * @param dateNaissance
     * @param dateEmbauche
     * @param fonction
     * @param tauxHoraire
     * @param situationFamiliale
     * @param nbrEnfants
     * @param categorie 
     */
     public Salarie(String code, String nom, String prenom, Date dateNaissance, Date dateEmbauche, 
                   String fonction, double tauxHoraire, String situationFamiliale, int nbrEnfants, 
                   Categorie categorie) {
        this.codeSal = code;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaiss = dateNaissance;
        this.dateEmbauche = dateEmbauche;
        this.fonction = fonction;
        this.tauxHoraire = tauxHoraire;
        this.situationFamiliale = situationFamiliale;
        this.nbrEnfants = nbrEnfants;
        this.categorie = categorie;
         
    }
     
     /**
      * charger les formations suivies par le salarié
      * @throws SQLException
      * @throws IOException 
      */
     public void chargerFormationsSuivies() throws SQLException, IOException {
        this.lesFormationsSuivies = DaoFormation.getFormationsBySalarie(this.code);
    }

    

    public void setLesFormationsSuivies(ArrayList<Formation> lesFormationsSuivies) {
        this.lesFormationsSuivies = lesFormationsSuivies;
    }

    /**
     * Constructeur du salarié sans service ni catégorie associés
     * @param code  matricule du salarié
     * @param nom   
     * @param prenom
     * @param dateNaiss    date de naissance du salarié
     * @param dateEmbauche date d'embauche du salarié
     * @param fonction     ex : Developpeur, Standardiste, ...
     * @param tauxHoraire  salaire horaire
     * @param situationFamiliale Marié, Célibataire, ...
     * @param nbrEnfants    nombre d'enfants
     */
    public Salarie(String code, String nom, String prenom, Date dateNaiss, Date dateEmbauche, String fonction, double tauxHoraire, String situationFamiliale, int nbrEnfants) {
        this.codeSal = code;
        this.nom = nom;
        this.prenom =prenom;
        this.dateNaiss = dateNaiss;
        this.dateEmbauche = dateEmbauche;
        this.fonction = fonction;
        this.tauxHoraire = tauxHoraire;
        this.situationFamiliale = situationFamiliale;
        this.nbrEnfants = nbrEnfants;
        this.service = null;
        this.categorie = null;
        this.formationsSuivies =new ArrayList<>();
    }
    
    /** 
     * Constructeur du salarié avec son service et sa catégorie
     * @param code  matricule du salarié
     * @param nom   
     * @param prenom
     * @param dateNaiss    date de naissance du salarié
     * @param dateEmbauche date d'embauche du salarié
     * @param fonction     ex : Developpeur, Standardiste, ...
     * @param tauxHoraire  salaire horaire
     * @param situationFamiliale Marié, Célibataire, ...
     * @param nbrEnfants    nombre d'enfants
     * @param serv          objet Service représentant le service danns lequel travaille le salarié
     */
    public Salarie(String code, String nom, String prenom, Date dateNaiss, Date dateEmbauche, String fonction, double tauxHoraire, 
            String situationFamiliale, int nbrEnfants, Service serv, Categorie categ) {
        this( code,  nom, prenom,  dateNaiss,  dateEmbauche,  fonction,  tauxHoraire,  situationFamiliale,  nbrEnfants);
        this.service = serv;
        this.categorie = categ;
    }

    @Override
    public String toString() {
        return "Salarie{" + "code=" + codeSal + ", nom=" + nom + ", prenom=" + prenom + ", dateNaiss=" + dateNaiss + ", dateEmbauche=" + dateEmbauche + ", fonction=" + fonction + ", tauxHoraire=" + tauxHoraire + ", situationFamiliale=" + situationFamiliale + ", nbrEnfants=" + nbrEnfants + ", service=" + service + ", categorie=" + categorie + ", lesFormationsSuivies=" + lesFormationsSuivies + '}';
    }
    
    
    //ACCESSEURS ET MUTATEURS
    public String getCode() {
        return codeSal;
    }

    public void setCode(String code) {
        this.codeSal = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(java.sql.Date dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public Date getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(java.sql.Date dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public double getTauxHoraire() {
        return tauxHoraire;
    }

    public void setTauxHoraire(double tauxHoraire) {
        this.tauxHoraire = tauxHoraire;
    }

    public String getSituationFamiliale() {
        return situationFamiliale;
    }

    public void setSituationFamiliale(String situationFamiliale) {
        this.situationFamiliale = situationFamiliale;
    }

    public int getNbrEnfants() {
        return nbrEnfants;
    }

    public void setNbrEnfants(int nbrEnfants) {
        this.nbrEnfants = nbrEnfants;
    }

    public String getCodeSal() {
        return codeSal;
    }

    public void setCodeSal(String codeSal) {
        this.codeSal = codeSal;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

     // Méthode pour ajouter une relation Suivre
    public void ajouterSuivre(Suivre suivre) {
        suivis.add(suivre); // Ajoute un suivi à la liste
    }    
    
    public ArrayList<Formation> getLesFormationsSuivies() {
        return lesFormationsSuivies;
    }
    
    public void setFormationsSuivies(ArrayList<Formation> formationsSuivies) {
        this.formationsSuivies = formationsSuivies;
    }
    
    public ArrayList<Suivre> getSuivis() {
        return suivis; // Renvoie la liste des suivis
    }

    /**
     * Ajouter une formation au salarié
     * @param formation 
     */
    public void ajouterFormation(Formation formation) {
        this.lesFormationsSuivies.add(formation);
    }  
}
