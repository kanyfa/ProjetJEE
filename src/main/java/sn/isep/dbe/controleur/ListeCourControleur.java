package sn.isep.dbe.controleur;

import sn.isep.dbe.modele.Cour;
import sn.isep.dbe.service.CourService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/cours/lister")
public class ListeCourControleur extends HttpServlet {

    private CourService courService;

    @Override
    public void init() throws ServletException {
        super.init();
        courService = new CourService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Cour> cour = courService.getAllCours();

        req.setAttribute("cours", cour);
        req.getRequestDispatcher("/WEB-INF/views/liste-cour.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
