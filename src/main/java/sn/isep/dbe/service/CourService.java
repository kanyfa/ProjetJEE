package sn.isep.dbe.service;

import sn.isep.dbe.dao.CourDAO;
import sn.isep.dbe.modele.Cour;

import java.util.List;

public class CourService {
    private CourDAO courDAO = new CourDAO(); // Correction du nom de la variable

    public List<Cour> getAllCours() {
        return courDAO.findAll(); // Correction du nom de l'objet DAO
    }

    public Cour ajoutCours(Cour cour) {
        return courDAO.save(cour); // Correction du nom de la variable DAO
    }

    public Cour getCourById(int id) {
        return courDAO.findById(id);
    }

    public Cour modifierCours(Cour cour) { // Correction du paramètre pour éviter l'erreur
        return courDAO.update(cour); // Correction de l'erreur où `cour` n'était pas initialisé
    }

    public void supprimerCours(int id) {
        courDAO.delete(id);
    }
}
