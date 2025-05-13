package sn.isep.dbe.controleur;

import sn.isep.dbe.modele.Etudiant;
import sn.isep.dbe.service.EtudiantService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/etudiants/ajouter")
public class AjoutEtudiantServlet extends HttpServlet {
    private EtudiantService etudiantService;

    @Override
    public void init() throws ServletException {
        super.init();
        etudiantService = new EtudiantService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/ajout-etudiant.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String matricule = req.getParameter("matricule");
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        String email = req.getParameter("email");
        String telephone = req.getParameter("telephone");
        String filiere = req.getParameter("filiere");
        String numeroCarteEtudiant = req.getParameter("numeroCarteEtudiant"); // Ajout du champ

        Etudiant etudiant = new Etudiant();
        etudiant.setMatricule(matricule);
        etudiant.setNom(nom);
        etudiant.setPrenom(prenom);
        etudiant.setEmail(email);
        etudiant.setTelephone(telephone);
        etudiant.setFiliere(filiere);
        etudiant.setNumeroCarteEtudiant(numeroCarteEtudiant);

        etudiantService.ajoutEtudiant(etudiant);

        resp.sendRedirect(req.getContextPath() + "/etudiants/lister");
    }
}
