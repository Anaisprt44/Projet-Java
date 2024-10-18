package modele.metier;

/**
 * Classe métier Service
 * @author btssio
 */
public class Service {
    private int code;
    private String designation;
    private String email;
    private String telephone;

    /**
     * Constructeur service
     * @param code
     * @param designation 
     */
    public Service(int code, String designation) {
        this.code = code;
        this.designation = designation;
        this.email = "";
        this.telephone = "";
    }
    
    /**
     * Constructeur complet
     * @param code
     * @param designation
     * @param email
     * @param telephone 
     */
    public Service(int code, String designation, String email, String telephone) {
        this.code = code;
        this.designation = designation;
        this.email = email;
        this.telephone = telephone;
    }

    //ACCESSEURS ET MUTATEURS
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return designation;
    }
    
    public String toStringEtat() {
        return "Service{" + "code=" + code + ", designation=" + designation + ", email=" + email + ", telephone=" + telephone + '}';
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Service other = (Service) obj;
        return this.code == other.code;
    }
    
    
    
}
