package sn.isep.dbe.controleur;

import sn.isep.dbe.modele.Note;
import sn.isep.dbe.service.NoteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/notes/ajouter")
public class AjoutNoteServlet extends HttpServlet {
    private NoteService noteService;

    @Override
    public void init() throws ServletException {
        super.init();
        noteService = new NoteService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/ajout-note.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String matiere = req.getParameter("matiere");
        String noteObtenue = req.getParameter("noteObtenue");
        String description = req.getParameter("description");
        String evenement = req.getParameter("evenement");

        if (matiere == null || noteObtenue == null || matiere.trim().isEmpty() || noteObtenue.trim().isEmpty()) {
            req.setAttribute("erreur", "Les champs 'Matière' et 'Note obtenue' sont obligatoires !");
            req.getRequestDispatcher("/WEB-INF/views/ajout-note.jsp").forward(req, resp);
            return;
        }

        try {
            float noteValue = Float.parseFloat(noteObtenue);
            if (noteValue < 0 || noteValue > 20) {
                throw new NumberFormatException("La note doit être comprise entre 0 et 20.");
            }

            Note note = new Note();
            note.setMatiere(matiere);
            note.setNoteObtenue(noteValue);
            note.setDescription(description);
            note.setEvenement(evenement);

            noteService.ajoutNote(note);

            resp.sendRedirect(req.getContextPath() + "/notes/lister");

        } catch (NumberFormatException e) {
            req.setAttribute("erreur", "La note doit être un nombre valide entre 0 et 20.");
            req.getRequestDispatcher("/WEB-INF/views/ajout-note.jsp").forward(req, resp);
        }
    }
}
