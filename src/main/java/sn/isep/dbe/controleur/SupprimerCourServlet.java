package sn.isep.dbe.controleur;

import sn.isep.dbe.service.CourService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cours/supprimer")
public class SupprimerCourServlet extends HttpServlet {
    private CourService courService;

    @Override
    public void init() throws ServletException {
        this.courService = new CourService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");

        if (idParam == null || idParam.trim().isEmpty()) {
            resp.sendRedirect(req.getContextPath() + "/cours/lister");
            return;
        }

        int id = Integer.parseInt(idParam);
        courService.supprimerCours(id);

        resp.sendRedirect(req.getContextPath() + "/cours/lister");
    }
}
