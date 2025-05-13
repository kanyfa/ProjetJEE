package sn.isep.dbe.modele;

import sn.isep.dbe.dao.CourDAO;

public class Cour {
    private Integer id;
    private String code;
    private String nom;
    private String description;
    private String professeur;
    private Integer duree;

    // Constructeur vide
    public Cour() {}

    // Constructeur avec paramètres
    public Cour(Integer id, String code, String nom, String description, String professeur, Integer duree) {
        this.id = id;
        this.code = code;
        this.nom = nom;
        this.description = description;
        this.professeur = professeur;
        setDuree(duree); // Vérification de la durée
    }

    // Getters et Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProfesseur() {
        return professeur;
    }

    public void setProfesseur(String professeur) {
        this.professeur = professeur;
    }

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        if (duree != null && duree > 0) {
            this.duree = duree;
        } else {
            throw new IllegalArgumentException("La durée doit être supérieure à 0");
        }
    }
}
