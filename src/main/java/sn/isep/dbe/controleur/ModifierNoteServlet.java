package sn.isep.dbe.controleur;

import sn.isep.dbe.modele.Note;
import sn.isep.dbe.service.NoteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/notes/modifier")
public class ModifierNoteServlet extends HttpServlet {
    private NoteService noteService;

    @Override
    public void init() throws ServletException {
        this.noteService = new NoteService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");

        if (idParam == null) {
            resp.sendRedirect(req.getContextPath() + "/notes/lister");
            return;
        }

        int id = Integer.parseInt(idParam);
        Note note = noteService.getNoteById(id);

        if (note == null) {
            resp.sendRedirect(req.getContextPath() + "/notes/lister");
            return;
        }

        req.setAttribute("item", note);
        req.getRequestDispatcher("/WEB-INF/views/modifier-note.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");

        if (idParam == null) {
            resp.sendRedirect(req.getContextPath() + "/notes/lister");
            return;
        }

        int id = Integer.parseInt(idParam);
        Note noteExistante = noteService.getNoteById(id);

        if (noteExistante == null) {
            resp.sendRedirect(req.getContextPath() + "/notes/lister");
            return;
        }

        // Récupérer les nouvelles données
        String matiere = req.getParameter("matiere");
        String noteObtenue = req.getParameter("noteObtenue");
        String description = req.getParameter("description");
        String evenement = req.getParameter("evenement");

        try {
            float noteValue = Float.parseFloat(noteObtenue);
            if (noteValue < 0 || noteValue > 20) {
                throw new NumberFormatException("La note doit être comprise entre 0 et 20.");
            }

            // Modifier les données
            noteExistante.setMatiere(matiere);
            noteExistante.setNoteObtenue(noteValue);
            noteExistante.setDescription(description);
            noteExistante.setEvenement(evenement);

            noteService.modifierNote(noteExistante);

            resp.sendRedirect(req.getContextPath() + "/notes/lister");

        } catch (NumberFormatException e) {
            req.setAttribute("erreur", "La note doit être un nombre valide entre 0 et 20.");
            req.getRequestDispatcher("/WEB-INF/views/modifier-note.jsp").forward(req, resp);
        }
    }
}
