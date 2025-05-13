package sn.isep.dbe.controleur;

import sn.isep.dbe.service.EtudiantService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/etudiants/supprimer")
public class SupprimerEtudiantServlet extends HttpServlet {
    private EtudiantService etudiantService;

    @Override
    public void init() throws ServletException {
        this.etudiantService = new EtudiantService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");

        if (idParam == null || idParam.trim().isEmpty()) {
            resp.sendRedirect(req.getContextPath() + "/etudiants/lister");
            return;
        }

        int id = Integer.parseInt(idParam);
        etudiantService.supprimerEtudiant(id);

        resp.sendRedirect(req.getContextPath() + "/etudiants/lister");
    }
}
