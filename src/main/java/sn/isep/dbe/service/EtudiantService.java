package sn.isep.dbe.service;

import sn.isep.dbe.dao.EtudiantDAO;
import sn.isep.dbe.modele.Etudiant;

import java.util.List;

public class EtudiantService {
    private final EtudiantDAO etudiantDAO = new EtudiantDAO();

    // Récupérer tous les étudiants
    public List<Etudiant> getAllEtudiants() {
        return etudiantDAO.findAll();
    }

    // Ajouter un nouvel étudiant
    public Etudiant ajoutEtudiant(Etudiant etudiant) {
        return etudiantDAO.save(etudiant);
    }

    // Récupérer un étudiant par son ID
    public Etudiant getEtudiantById(int id) {
        return etudiantDAO.findById(id);
    }

    // Modifier un étudiant
    public Etudiant modifierEtudiant(Etudiant etudiant) {
        return etudiantDAO.update(etudiant);
    }

    // Supprimer un étudiant
    public void supprimerEtudiant(int id) {
        etudiantDAO.delete(id);
    }
}
