package sn.isep.dbe.modele;

public class Etudiant {
    private Integer id;
    private String matricule;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String filiere;
    private String numeroCarteEtudiant; // Ajout du numéro de carte étudiant

    // Getters et Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
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

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public String getNumeroCarteEtudiant() {
        return numeroCarteEtudiant;
    }

    public void setNumeroCarteEtudiant(String numeroCarteEtudiant) {
        this.numeroCarteEtudiant = numeroCarteEtudiant;
    }
}
