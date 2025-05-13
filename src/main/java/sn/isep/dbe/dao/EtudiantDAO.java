package sn.isep.dbe.dao;

import sn.isep.dbe.modele.Etudiant;
import sn.isep.dbe.util.ConnexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EtudiantDAO {

    // Récupérer tous les étudiants
    public List<Etudiant> findAll() {
        List<Etudiant> etudiants = new ArrayList<>();

        try (Connection connection = ConnexionBD.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM etudiant");

            while (rs.next()) {
                Etudiant etudiant = mapResultSetToEtudiant(rs);
                etudiants.add(etudiant);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return etudiants;
    }

    // Récupérer un étudiant par son ID
    public Etudiant findById(int id) {
        Etudiant etudiant = null;

        String sql = "SELECT * FROM etudiant WHERE id = ?";
        try (Connection conn = ConnexionBD.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                etudiant = mapResultSetToEtudiant(rs);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return etudiant;
    }

    // Sauvegarder un nouvel étudiant
    public Etudiant save(Etudiant etudiant) {
        if (etudiant.getNumeroCarteEtudiant() == null || etudiant.getNumeroCarteEtudiant().isEmpty()) {
            etudiant.setNumeroCarteEtudiant(generateUniqueCarteNumber());
        }

        String sql = "INSERT INTO etudiant (matricule, nom, prenom, email, telephone, filiere, numeroCarteEtudiant) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnexionBD.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            setEtudiantParameters(statement, etudiant);
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                etudiant.setId(generatedKeys.getInt(1));
            }
            generatedKeys.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return etudiant;
    }

    // Mettre à jour un étudiant
    public Etudiant update(Etudiant etudiant) {
        String sql = "UPDATE etudiant SET matricule=?, nom=?, prenom=?, email=?, telephone=?, filiere=?, numeroCarteEtudiant=? WHERE id=?";
        try (Connection conn = ConnexionBD.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            setEtudiantParameters(statement, etudiant);
            statement.setInt(8, etudiant.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return etudiant;
    }

    // Supprimer un étudiant
    public void delete(int id) {
        String sql = "DELETE FROM etudiant WHERE id=?";
        try (Connection connection = ConnexionBD.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Méthode pour générer un numéro de carte unique
    private String generateUniqueCarteNumber() {
        return "CART" + System.currentTimeMillis();
    }

    // Mapper un ResultSet vers un objet Etudiant
    private Etudiant mapResultSetToEtudiant(ResultSet rs) throws SQLException {
        Etudiant etudiant = new Etudiant();
        etudiant.setId(rs.getInt("id"));
        etudiant.setMatricule(rs.getString("matricule"));
        etudiant.setNom(rs.getString("nom"));
        etudiant.setPrenom(rs.getString("prenom"));
        etudiant.setEmail(rs.getString("email"));
        etudiant.setTelephone(rs.getString("telephone"));
        etudiant.setFiliere(rs.getString("filiere"));
        etudiant.setNumeroCarteEtudiant(rs.getString("numeroCarteEtudiant"));
        return etudiant;
    }

    // Configurer les paramètres du PreparedStatement pour un Etudiant
    private void setEtudiantParameters(PreparedStatement statement, Etudiant etudiant) throws SQLException {
        statement.setString(1, etudiant.getMatricule());
        statement.setString(2, etudiant.getNom());
        statement.setString(3, etudiant.getPrenom());
        statement.setString(4, etudiant.getEmail());
        statement.setString(5, etudiant.getTelephone());
        statement.setString(6, etudiant.getFiliere());
        statement.setString(7, etudiant.getNumeroCarteEtudiant());
    }
}
