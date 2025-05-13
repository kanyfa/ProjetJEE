package sn.isep.dbe.modele;

public class Note {
    private Integer id;
    private String matiere;
    private Float noteObtenue;
    private String description;
    private String evenement;

    // Getters et setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public Float getNoteObtenue() {
        return noteObtenue;
    }

    public void setNoteObtenue(Float noteObtenue) {
        if (noteObtenue >= 0 && noteObtenue <= 20) {
            this.noteObtenue = noteObtenue;
        } else {
            throw new IllegalArgumentException("La note doit être entre 0 et 20");
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEvenement() {
        return evenement;
    }

    public void setEvenement(String evenement) {
        this.evenement = evenement;
    }
}
