package modele.metier;

/**
 *
 * @author anais
 */
public class Suivre {
    private String codeSal; // Référence au salarié
    //private String codeFormation; // Référence à la formation
    private Salarie salarie;
    private Formation formation;

    // Constructeur
    public Suivre(String codeSal, Formation formation) {
        this.codeSal = codeSal;
        this.formation = formation;        
    }

    // Getter pour la formation
    public String getSalarie() {
        return codeSal;
    }

    public Formation getFormation() {
        return formation;
    }
    
}
