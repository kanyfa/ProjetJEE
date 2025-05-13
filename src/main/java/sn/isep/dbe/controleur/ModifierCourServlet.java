package sn.isep.dbe.controleur;

import sn.isep.dbe.modele.Cour;
import sn.isep.dbe.service.CourService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cours/modifier")
public class ModifierCourServlet extends HttpServlet {
    private CourService courService;

    @Override
    public void init() throws ServletException {
        this.courService = new CourService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        if (idParam == null) {
            resp.sendRedirect(req.getContextPath() + "/cours/lister");
            return;
        }

        int id = Integer.parseInt(idParam);
        Cour cour = courService.getCourById(id);

        if (cour == null) {
            resp.sendRedirect(req.getContextPath() + "/cours/lister");
            return;
        }

        req.setAttribute("item", cour);
        req.getRequestDispatcher("/WEB-INF/views/modifier-cour.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        if (idParam == null) {
            resp.sendRedirect(req.getContextPath() + "/cours/lister");
            return;
        }

        int id = Integer.parseInt(idParam);
        Cour coursExistant = courService.getCourById(id);

        if (coursExistant == null) {
            resp.sendRedirect(req.getContextPath() + "/cours/lister");
            return;
        }

        // Récupération des nouvelles données
        String code = req.getParameter("code");
        String nom = req.getParameter("nom");
        String description = req.getParameter("description");
        String professeur = req.getParameter("professeur");
        String duree = req.getParameter("duree");

        // Modification des données
        coursExistant.setCode(code);
        coursExistant.setNom(nom);
        coursExistant.setDescription(description);
        coursExistant.setProfesseur(professeur);
        coursExistant.setDuree(Integer.parseInt(duree));

        // Mise à jour du cours
        courService.modifierCours(coursExistant);

        resp.sendRedirect(req.getContextPath() + "/cours/lister");
    }
}
