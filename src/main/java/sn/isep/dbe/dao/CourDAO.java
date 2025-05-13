package sn.isep.dbe.dao;

import sn.isep.dbe.modele.Cour;
import sn.isep.dbe.util.ConnexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourDAO {

    // Récupérer tous les cours
    public List<Cour> findAll() {
        List<Cour> coursList = new ArrayList<>();

        try (Connection connection = ConnexionBD.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM cours")) {

            while (rs.next()) {
                coursList.add(mapResultSetToCour(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return coursList;
    }

    // Récupérer un cours par son ID
    public Cour findById(int id) {
        Cour cours = null;
        String sql = "SELECT * FROM cours WHERE id = ?";

        try (Connection conn = ConnexionBD.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                cours = mapResultSetToCour(rs);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return cours;
    }

    // Sauvegarder un nouveau cours
    public Cour save(Cour cours) {
        String sql = "INSERT INTO cours (code, nom, description, professeur, duree) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = ConnexionBD.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            setPreparedStatementParameters(statement, cours);
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                cours.setId(generatedKeys.getInt(1)); // Récupérer l'ID généré
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return cours;
    }

    // Mettre à jour un cours
    public Cour update(Cour cours) {
        String sql = "UPDATE cours SET code = ?, nom = ?, description = ?, professeur = ?, duree = ? WHERE id = ?";

        try (Connection conn = ConnexionBD.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            setPreparedStatementParameters(statement, cours);
            statement.setInt(6, cours.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return cours;
    }

    // Supprimer un cours
    public void delete(int id) {
        String sql = "DELETE FROM cours WHERE id = ?";

        try (Connection conn = ConnexionBD.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Méthode utilitaire pour mapper un ResultSet vers un objet Cour
    private Cour mapResultSetToCour(ResultSet rs) throws SQLException {
        Cour cours = new Cour();
        cours.setId(rs.getInt("id"));
        cours.setCode(rs.getString("code"));
        cours.setNom(rs.getString("nom"));
        cours.setDescription(rs.getString("description"));
        cours.setProfesseur(rs.getString("professeur"));
        cours.setDuree(rs.getInt("duree"));
        return cours;
    }

    // Méthode utilitaire pour définir les paramètres d'un PreparedStatement
    private void setPreparedStatementParameters(PreparedStatement statement, Cour cours) throws SQLException {
        statement.setString(1, cours.getCode());
        statement.setString(2, cours.getNom());
        statement.setString(3, cours.getDescription());
        statement.setString(4, cours.getProfesseur());
        statement.setInt(5, cours.getDuree());
    }
}
