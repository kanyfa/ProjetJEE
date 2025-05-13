package sn.isep.dbe.controleur;

import sn.isep.dbe.modele.Filiere;
import sn.isep.dbe.service.FiliereService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/filieres/modifier")
public class ModifierFiliereServlet extends HttpServlet {
FiliereService filiereService;

    @Override
    public void init() throws ServletException {
        this.filiereService = new FiliereService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idParam= req.getParameter("id");
        if (idParam == null) {
            resp.sendRedirect(req.getContextPath() + "/filieres/lister");
            return;
        }
        int id  =Integer.parseInt(idParam);
        Filiere filiere = filiereService.getFiliereById(id);

        req.setAttribute("item", filiere);
        req.getRequestDispatcher("/WEB-INF/views/modifier-filiere.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // verifie si l element existe
        String idParam = req.getParameter("id");
        System.out.println("########## " + idParam);

        if (idParam == null) {
            resp.sendRedirect(req.getContextPath() + "/filieres/lister");
            return;
        }

        int id = Integer.parseInt(idParam);

        // si oui recuperer les donnees
        Filiere filiereExistant = filiereService.getFiliereById(id);
        if (filiereExistant == null) {
            resp.sendRedirect(req.getContextPath() + "/filieres/lister");
            return;
        }

        // recuperer les nouvelles donnees
        String code = req.getParameter("code");
        String nom = req.getParameter("nom");
        String departement = req.getParameter("departement");
        String nomResponsable = req.getParameter("nomResponsable");
        String prenomResponsable = req.getParameter("prenomResponsable");
        String capacite = req.getParameter("capacite");

        // modfier les donnees
        filiereExistant.setCode(code);
        filiereExistant.setNom(nom);
        filiereExistant.setDepartement(departement);
        filiereExistant.setNomResponsable(nomResponsable);
        filiereExistant.setPrenomResponsable(prenomResponsable);
        filiereExistant.setCapacite(Integer.parseInt(capacite));


        filiereService.modifierFiliere(filiereExistant);


        resp.sendRedirect(req.getContextPath() + "/filieres/lister");
    }
}
