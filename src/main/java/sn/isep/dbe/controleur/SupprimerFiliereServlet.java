package sn.isep.dbe.controleur;

import sn.isep.dbe.service.FiliereService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/filieres/supprimer")
public class SupprimerFiliereServlet extends HttpServlet {
    private FiliereService filiereService;

    @Override
    public void init() throws ServletException {
        this.filiereService = new FiliereService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");

        if (idParam == null || idParam.trim().isEmpty()) {
            resp.sendRedirect(req.getContextPath() + "/filieres/lister");
            return;
        }

        int id = Integer.parseInt(idParam);
        filiereService.supprimerFiliere(id);

        resp.sendRedirect(req.getContextPath() + "/filieres/lister");
    }
}
