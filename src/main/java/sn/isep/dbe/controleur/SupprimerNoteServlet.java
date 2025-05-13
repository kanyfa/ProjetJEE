package sn.isep.dbe.controleur;

import sn.isep.dbe.service.NoteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/notes/supprimer")
public class SupprimerNoteServlet extends HttpServlet {
    private NoteService noteService;

    @Override
    public void init() throws ServletException {
        this.noteService = new NoteService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");

        if (idParam == null || idParam.trim().isEmpty()) {
            resp.sendRedirect(req.getContextPath() + "/notes/lister");
            return;
        }

        int id = Integer.parseInt(idParam);
        noteService.supprimerNote(id);

        resp.sendRedirect(req.getContextPath() + "/notes/lister");
    }
}
