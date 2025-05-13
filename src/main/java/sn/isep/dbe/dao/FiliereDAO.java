package sn.isep.dbe.dao;

import sn.isep.dbe.modele.Filiere;
import sn.isep.dbe.util.ConnexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FiliereDAO {

    // Récupérer toutes les filières
    public List<Filiere> findAll() {
        List<Filiere> filieres = new ArrayList<>();
        String sql = "SELECT * FROM filiere";

        try (Connection connection = ConnexionBD.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                filieres.add(mapResultSetToFiliere(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return filieres;
    }

    // Récupérer une filière par son ID
    public Filiere findById(int id) {
        Filiere filiere = null;
        String sql = "SELECT * FROM filiere WHERE id = ?";

        try (Connection conn = ConnexionBD.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                filiere = mapResultSetToFiliere(rs);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return filiere;
    }

    // Sauvegarder une nouvelle filière
    public Filiere save(Filiere filiere) {
        String sql = "INSERT INTO filiere (code, nom, departement, nom_responsable, prenom_responsable, capacite) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = ConnexionBD.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            setPreparedStatementParameters(statement, filiere);
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                filiere.setId(generatedKeys.getInt(1)); // Récupérer l'ID généré
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return filiere;
    }

    // Mettre à jour une filière
    public Filiere update(Filiere filiere) {
        String sql = "UPDATE filiere SET code = ?, nom = ?, departement = ?, nom_responsable = ?, prenom_responsable = ?, capacite = ? WHERE id = ?";

        try (Connection conn = ConnexionBD.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            setPreparedStatementParameters(statement, filiere);
            statement.setInt(7, filiere.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return filiere;
    }

    // Supprimer une filière
    public void delete(int id) {
        String sql = "DELETE FROM filiere WHERE id = ?";

        try (Connection conn = ConnexionBD.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Mapper un ResultSet vers un objet Filiere
    private Filiere mapResultSetToFiliere(ResultSet rs) throws SQLException {
        Filiere filiere = new Filiere();
        filiere.setId(rs.getInt("id"));
        filiere.setCode(rs.getString("code"));
        filiere.setNom(rs.getString("nom"));
        filiere.setDepartement(rs.getString("departement"));
        filiere.setNomResponsable(rs.getString("nom_responsable"));
        filiere.setPrenomResponsable(rs.getString("prenom_responsable"));
        filiere.setCapacite(rs.getInt("capacite"));
        return filiere;
    }

    // Définir les paramètres d'un PreparedStatement pour une Filiere
    private void setPreparedStatementParameters(PreparedStatement statement, Filiere filiere) throws SQLException {
        statement.setString(1, filiere.getCode());
        statement.setString(2, filiere.getNom());
        statement.setString(3, filiere.getDepartement());
        statement.setString(4, filiere.getNomResponsable());
        statement.setString(5, filiere.getPrenomResponsable());
        statement.setInt(6, filiere.getCapacite());
    }
}
