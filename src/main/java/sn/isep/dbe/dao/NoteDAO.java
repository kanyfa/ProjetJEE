package sn.isep.dbe.dao;

import sn.isep.dbe.modele.Note;
import sn.isep.dbe.util.ConnexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NoteDAO {

    // Récupérer toutes les notes
    public List<Note> findAll() {
        List<Note> notes = new ArrayList<>();
        String sql = "SELECT * FROM notes";

        try (Connection connection = ConnexionBD.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                notes.add(mapResultSetToNote(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return notes;
    }

    // Récupérer une note par son ID
    public Note findById(int id) {
        Note note = null;
        String sql = "SELECT * FROM notes WHERE id = ?";

        try (Connection conn = ConnexionBD.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                note = mapResultSetToNote(rs);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return note;
    }

    // Sauvegarder une nouvelle note
    public Note save(Note note) {
        String sql = "INSERT INTO notes (matiere, note_obtenue, description, evenement) VALUES (?, ?, ?, ?)";

        try (Connection connection = ConnexionBD.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            setPreparedStatementParameters(statement, note);
            statement.executeUpdate();

            // Récupérer l'ID généré après l'insertion
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                note.setId(generatedKeys.getInt(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return note;
    }

    // Mettre à jour une note
    public Note update(Note note) {
        String sql = "UPDATE notes SET matiere = ?, note_obtenue = ?, description = ?, evenement = ? WHERE id = ?";

        try (Connection conn = ConnexionBD.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            setPreparedStatementParameters(statement, note);
            statement.setInt(5, note.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return note;
    }

    // Supprimer une note
    public void delete(int id) {
        String sql = "DELETE FROM notes WHERE id = ?";

        try (Connection conn = ConnexionBD.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Mapper un ResultSet vers un objet Note
    private Note mapResultSetToNote(ResultSet rs) throws SQLException {
        Note note = new Note();
        note.setId(rs.getInt("id"));
        note.setMatiere(rs.getString("matiere"));
        note.setNoteObtenue(rs.getFloat("note_obtenue"));
        note.setDescription(rs.getString("description"));
        note.setEvenement(rs.getString("evenement"));
        return note;
    }

    // Définir les paramètres d'un PreparedStatement pour une Note
    private void setPreparedStatementParameters(PreparedStatement statement, Note note) throws SQLException {
        statement.setString(1, note.getMatiere());
        statement.setFloat(2, note.getNoteObtenue());
        statement.setString(3, note.getDescription());
        statement.setString(4, note.getEvenement());
    }
}
