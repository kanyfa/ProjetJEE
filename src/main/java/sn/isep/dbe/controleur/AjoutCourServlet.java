package sn.isep.dbe.controleur;

import sn.isep.dbe.modele.Cour;
import sn.isep.dbe.service.CourService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cours/ajouter")
public class AjoutCourServlet extends HttpServlet {
    private CourService courService;

    @Override
    public void init() throws ServletException {
        super.init();
        courService = new CourService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/ajout-cour.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        String nom = req.getParameter("nom");
        String description = req.getParameter("description");
        String professeur = req.getParameter("professeur");
        String dureeStr = req.getParameter("duree");

        // Vérification des paramètres
        if (code == null || nom == null || description == null || professeur == null || dureeStr == null ||
                code.trim().isEmpty() || nom.trim().isEmpty() || description.trim().isEmpty() || professeur.trim().isEmpty() || dureeStr.trim().isEmpty()) {
            req.setAttribute("erreur", "Tous les champs sont obligatoires !");
            req.getRequestDispatcher("/WEB-INF/views/ajout-cour.jsp").forward(req, resp);
            return;
        }

        try {
            int duree = Integer.parseInt(dureeStr);
            if (duree <= 0) {
                throw new NumberFormatException("La durée doit être supérieure à 0");
            }

            // Création et ajout du cours
            Cour cours = new Cour();
            cours.setCode(code);
            cours.setNom(nom);
            cours.setDescription(description);
            cours.setProfesseur(professeur);
            cours.setDuree(duree);

            courService.ajoutCours(cours);

            resp.sendRedirect(req.getContextPath() + "/cours/lister");

        } catch (NumberFormatException e) {
            req.setAttribute("erreur", "La durée doit être un nombre valide et supérieur à 0.");
            req.getRequestDispatcher("/WEB-INF/views/ajout-cour.jsp").forward(req, resp);
        }
    }
}
