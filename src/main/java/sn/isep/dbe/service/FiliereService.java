package sn.isep.dbe.service;

import sn.isep.dbe.dao.FiliereDAO;
import sn.isep.dbe.modele.Filiere;

import java.util.List;

public class FiliereService {
    private final FiliereDAO filiereDAO = new FiliereDAO();

    // Récupérer toutes les filières
    public List<Filiere> getAllFilieres() {
        return filiereDAO.findAll();
    }

    // Ajouter une nouvelle filière
    public Filiere ajoutFiliere(Filiere filiere) {
        return filiereDAO.save(filiere);
    }

    // Récupérer une filière par son ID
    public Filiere getFiliereById(int id) {
        return filiereDAO.findById(id);
    }

    // Modifier une filière
    public Filiere modifierFiliere(Filiere filiere) {
        return filiereDAO.update(filiere);
    }

    // Supprimer une filière
    public void supprimerFiliere(int id) {
        filiereDAO.delete(id);  // Correction : Utilisation du bon DAO
    }
}
