package sn.isep.dbe.controleur;

import sn.isep.dbe.modele.Etudiant;
import sn.isep.dbe.service.EtudiantService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/etudiants/modifier")
public class ModifierEtudiantServlet extends HttpServlet {
    private EtudiantService etudiantService;

    @Override
    public void init() throws ServletException {
        this.etudiantService = new EtudiantService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Récupérer l'étudiant ayant l'ID donné en paramètre
        String idParam = req.getParameter("id");
        if (idParam == null) {
            resp.sendRedirect(req.getContextPath() + "/etudiants/lister");
            return;
        }
        int id = Integer.parseInt(idParam);
        Etudiant etudiant = etudiantService.getEtudiantById(id);

        req.setAttribute("item", etudiant);
        req.getRequestDispatcher("/WEB-INF/views/modifier-etudiant.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Vérifier si l'élément existe
        String idParam = req.getParameter("id");
        System.out.println("########## " + idParam);

        if (idParam == null) {
            resp.sendRedirect(req.getContextPath() + "/etudiants/lister");
            return;
        }

        int id = Integer.parseInt(idParam);

        // Si oui, récupérer les données
        Etudiant etudiantExistant = etudiantService.getEtudiantById(id);
        if (etudiantExistant == null) {
            resp.sendRedirect(req.getContextPath() + "/etudiants/lister");
            return;
        }

        // Récupérer les nouvelles données
        String matricule = req.getParameter("matricule");
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        String email = req.getParameter("email");
        String telephone = req.getParameter("telephone");
        String filiere = req.getParameter("filiere");
        String numeroCarteEtudiant = req.getParameter("numeroCarteEtudiant"); // Ajout du champ numéro de carte

        // Modifier les données
        etudiantExistant.setMatricule(matricule);
        etudiantExistant.setNom(nom);
        etudiantExistant.setPrenom(prenom);
        etudiantExistant.setEmail(email);
        etudiantExistant.setTelephone(telephone);
        etudiantExistant.setFiliere(filiere);
        etudiantExistant.setNumeroCarteEtudiant(numeroCarteEtudiant); // Ajout du numéro de carte étudiant

        // Effectuer les changements dans la BD
        etudiantService.modifierEtudiant(etudiantExistant);

        // Retourner vers la liste
        resp.sendRedirect(req.getContextPath() + "/etudiants/lister");
    }
}
