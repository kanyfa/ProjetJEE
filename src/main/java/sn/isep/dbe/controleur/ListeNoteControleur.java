package sn.isep.dbe.controleur;

import sn.isep.dbe.modele.Note;
import sn.isep.dbe.service.NoteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/notes/lister")
public class ListeNoteControleur extends HttpServlet {

    private NoteService noteService;

    @Override
    public void init() throws ServletException {
        super.init();
        noteService = new NoteService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Note> notes = noteService.getAllNotes();

        req.setAttribute("notes", notes);
        req.getRequestDispatcher("/WEB-INF/views/liste-note.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
