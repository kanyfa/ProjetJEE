package sn.isep.dbe.controleur;

import sn.isep.dbe.modele.Etudiant;
import sn.isep.dbe.service.EtudiantService;
import sn.isep.dbe.util.ConnexionBD;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/etudiants/lister")
public class  ListeEtudiantControleur extends HttpServlet {

    private EtudiantService etudiantService;

    @Override
    public void init() throws ServletException {
        super.init();
        etudiantService = new EtudiantService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Etudiant> etudiants = etudiantService.getAllEtudiants();

        req.setAttribute("etudiants", etudiants);
        req.getRequestDispatcher("/WEB-INF/views/liste-etudiant.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
